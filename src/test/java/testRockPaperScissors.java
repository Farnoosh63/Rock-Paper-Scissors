import org.junit.*;
import static org.junit.Assert.*;

public class testRockPaperScissors {



  //app accepts user input and returns an output.
  @Test
  public void rpsGame_appAcceptingUserInputReturnOutput_true() {
  RockPaperScissors testRockPaperScissors = new RockPaperScissors();
  assertEquals("true", testRockPaperScissors.rpsGame("input1", ""));
  }

  //app accepts user input from user 1 and user 2 and returns an output.
  @Test
  public void rpsGame_appAccepting2UserInputsReturnOutput_true() {
  RockPaperScissors testRockPaperScissors = new RockPaperScissors();
  assertEquals("true", testRockPaperScissors.rpsGame("input1", "input2"));
  }

  //if user 1 plays a move that beats player 2, the app returns that player 1 wins.
  @Test
  public void rpsGame_checksWinnerBetweenSameInput_tie() {
  RockPaperScissors testRockPaperScissors = new RockPaperScissors();
  String expected = "tie";
  assertEquals(expected, testRockPaperScissors.rpsGame("rock", "rock"));
  }

  //if user 2 plays a move that beats player 1, the app returns that player 2 wins.
  @Test
  public void rpsGame_checksWinnerBetweenDifferentInput_player2wins() {
  RockPaperScissors testRockPaperScissors = new RockPaperScissors();
  String expected = "player2 wins";
  assertEquals(expected, testRockPaperScissors.rpsGame("rock", "paper"));
  }
  //app accepts user input and generates a random input

  //app accepts user input and generates a random input and returns an output

  //if user plays a move that beats generated input, the app returns that player wins.

  //if generated input plays a move that beats player, the app returns that computer wins.


}
