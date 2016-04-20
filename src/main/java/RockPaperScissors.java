import java.util.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class RockPaperScissors {
  public static void main(String[] args) {
    get("/twoplayer", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/twoplayer.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());

    get("/computer", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/computer.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());

    get("/detector", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      RockPaperScissors newGame = new RockPaperScissors();
      String input1 = request.queryParams("input1");
      String input2 = request.queryParams("input2");
      String displayWinner = newGame.checkWinnerTwoPlayers(input1, input2);

      model.put("input1", input1);
      model.put("input2", input2);
      model.put("displayWinner", displayWinner);


      model.put("template", "templates/detector.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());

    get("/computerGameDetector", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      RockPaperScissors newGame = new RockPaperScissors();
      String input1 = request.queryParams("input1");
      String input2 = newGame.generateChoice();
      String displayWinner = newGame.checkWinnerOnePlayer(input1, input2);


      model.put("input1", input1);
      model.put("input2", input2);
      model.put("displayWinner", displayWinner);


      model.put("template", "templates/computerGameDetector.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());
  }


  public static String generateChoice(){
    Random myRandomGenerator = new Random();
    Integer randomNum = myRandomGenerator.nextInt(3);
    String computerChoice = "";
    if (randomNum == 0){
      computerChoice = "rock";
    }else if (randomNum == 1) {
      computerChoice = "paper";
    }else if (randomNum == 2) {
      computerChoice = "scissor";
    }
    return computerChoice;
  }

   public static String checkWinnerOnePlayer(String input1, String input2) {
     String result = "";
     String rock = "rock";
     String paper = "paper";
     String scissor = "scissor";
     if (input1.equals(input2)){
      result= "tie";
    } else if((input1.equals("rock") && input2.equals("paper"))
              || (input1.equals("paper") && input2.equals("scissor"))
              || (input1.equals("scissor") && input2.equals("rock"))){
     result= "Computer wins";
   } else if((input1.equals("rock") && input2.equals("scissor"))
              || (input1.equals("scissor") && input2.equals("paper"))
              || (input1.equals("paper") && input2.equals("rock"))){
      result= "Player1 wins";
    }
    return result;
  }


  public static String checkWinnerTwoPlayers(String input1, String input2){
    String rock = "rock";
    String paper = "paper";
    String scissor = "scissor";
    String result = "";
    if(input1.equals(input2)){
      result = "tie";
    } else if(input1.equals("rock") && input2.equals("paper")
              || input1.equals("paper") && input2.equals("scissor")
              || input1.equals("scissor") && input2.equals("rock")){
      result = "player2 wins";
    } else if(input1.equals("rock") && input2.equals("scissor")
              || input1.equals("scissor") && input2.equals("paper")
              || input1.equals("paper") && input2.equals("rock")){
      result = "player1 wins";
    }
    return result;
  }

}
