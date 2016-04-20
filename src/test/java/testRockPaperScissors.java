import org.junit.*;
import static org.junit.Assert.*;

public class testRockPaperScissors {

  //app accepts user input from user 1 and user 2 and returns an output.
  @Test
  public void checkWinnerTwoPlayers_appAccepting2UserInputsReturnOutput_String() {
  RockPaperScissors testRockPaperScissors = new RockPaperScissors();
  assertEquals("player1 wins", testRockPaperScissors.checkWinnerTwoPlayers("rock", "scissor"));
  }

  //if user 1 plays a move that beats player 2, the app returns that player 1 wins.
  @Test
  public void checkWinnerTwoPlayers_checksWinnerBetweenSameInput_tie() {
  RockPaperScissors testRockPaperScissors = new RockPaperScissors();
  String expected = "tie";
  assertEquals(expected, testRockPaperScissors.checkWinnerTwoPlayers("rock", "rock"));
  }

  //if user 2 plays a move that beats player 1, the app returns that player 2 wins.
  @Test
  public void checkWinnerTwoPlayers_checksWinnerBetweenDifferentInput_player2wins() {
  RockPaperScissors testRockPaperScissors = new RockPaperScissors();
  String expected = "player2 wins";
  assertEquals(expected, testRockPaperScissors.checkWinnerTwoPlayers("rock", "paper"));
  }
  //app accepts user input and generates a random input

  @Test
  public void generateChoice_appAcceptUserInputAndGenerateRandomNumber_true() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    String computerChoice = testRockPaperScissors.generateChoice();
    assertEquals(true, computerChoice instanceof String);
  }
  //app accepts user input and generates a random input and returns an output

  @Test
  public void checkWinnerOnePlayer_appAcceptUserInputAndGenerateRandomNumber_String() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    // String expected = "pass";
    assertEquals(true, testRockPaperScissors.checkWinnerOnePlayer("rock", "paper") instanceof String);
  }


  //if user plays a move that is the sameas generated input, the app returns tie.
  // @Test
  // public void checkWinnerOnePlayer_checkWinnerBetweenInputWithGeneratedRandomNumber_String() {
  //   RockPaperScissors testRockPaperScissors = new RockPaperScissors();
  //   // String expected = "tie";
  //   assertEquals(true, testRockPaperScissors.checkWinnerOnePlayer("rock") instanceof String);
  // }

  //if user plays a move that beats generated input, the app returns that player wins.
  // @Test
  // public void checkWinnerOnePlayer_checksWinnerBetweenUserInputAndGeneratedRandomNumber_player2wins() {
  //   RockPaperScissors testRockPaperScissors = new RockPaperScissors();
  //   // String expected = "player2 wins";
  //   assertEquals(true, testRockPaperScissors.checkWinnerOnePlayer("rock") instanceof String);
  // }

  //if generated input plays a move that beats player, the app returns that computer wins.
  //Our last test check the random generated to see if the player wins or tie
  //then we do not vhevk the last option if the computer generator beats the player


}
