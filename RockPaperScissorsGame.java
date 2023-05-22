import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {
  private final int ROCK = 1;
  private final int PAPER = 2;
  private final int SCISSORS = 3;

  private int ties;
  private int userWins;
  private int computerWins;

  private Scanner scanner;

  public RockPaperScissorsGame() {
    scanner = new Scanner(System.in);
  }

  public static void main(String[] args) {
    RockPaperScissorsGame game = new RockPaperScissorsGame();
    game.play();
  }

  public void play() {
    System.out.println("Welcome to the Rock Paper Scissors game!");

    boolean playAgain = true;
    while (playAgain) {
      playGame();
      playAgain = askToPlayAgain();
    }

    System.out.println("Thanks for playing!");
  }

  public void playGame() {
    int rounds = getNumberOfRounds();

    ties = 0;
    userWins = 0;
    computerWins = 0;

    for (int i = 1; i <= rounds; i++) {
      System.out.println("\nRound " + i);
      System.out.print("Enter your choice (1 = Rock, 2 = Paper, 3 = Scissors): ");
      int userChoice = scanner.nextInt();

      int computerChoice = getRandomChoice();

      System.out.println("Computer chose: " + choiceToString(computerChoice));
      System.out.println("Result: " + getRoundResult(userChoice, computerChoice));
    }

    System.out.println("\nGame Over!");
    System.out.println("Ties: " + ties);
    System.out.println("User Wins: " + userWins);
    System.out.println("Computer Wins: " + computerWins);

    String overallWinner = getOverallWinner();
    System.out.println("Overall Winner: " + overallWinner);
  }

  public int getNumberOfRounds() {
    int rounds;
    do {
      System.out.print("How many rounds do you want to play? (1-10): ");
      rounds = scanner.nextInt();
      if (rounds < 1 || rounds > 10) {
        System.out.println("Invalid range, you must pick between 1 and 10 inclusive");
      }
    } while (rounds < 1 || rounds > 10);

    return rounds;
  }

  public int getRandomChoice() {
    Random random = new Random();
    return random.nextInt(3) + 1;
  }

  public String choiceToString(int choice) {
    if (choice == ROCK) {
      return "Rock";
    } else if (choice == PAPER) {
      return "Paper";
    } else if (choice == SCISSORS) {
      return "Scissors";
    } else {
      return "";
    }
  }

  public String getRoundResult(int userChoice, int computerChoice) {
    if (userChoice == computerChoice) {
      ties++;
      return "Tie!";
    } else if ((userChoice == ROCK && computerChoice == SCISSORS) ||
        (userChoice == PAPER && computerChoice == ROCK) ||
        (userChoice == SCISSORS && computerChoice == PAPER)) {
      userWins++;
      return "You win!";
    } else {
      computerWins++;
      return "Computer wins!";
    }
  }

  public String getOverallWinner() {
    if (userWins > computerWins) {
      return "You";
    } else if (computerWins > userWins) {
      return "Computer";
    } else {
      return "It's a tie!";
    }
  }

  public boolean askToPlayAgain() {
    System.out.print("Do you want to play again? (Yes/No):");
    String choice = scanner.next().toLowerCase();
    return choice.equals("yes");
  }
}