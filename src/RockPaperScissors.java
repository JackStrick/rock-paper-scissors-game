import java.util.*;

public class RockPaperScissors
{
    //Main Method
    public static void main(String[] args)
    {
        String playerName;
        String playerSelection;
        String cpuSelection;
        String winner;
        int playerWin=0;
        int cpuWin=0;
        int tieCount=0;
        int gamesPlayed = 0;


        playerName = getPlayerName();

        welcomePlayer(playerName);


        do{
            playerSelection = playerChoice();

            if (!playerSelection.equalsIgnoreCase("done"))
            {
                cpuSelection = computerChoice();

                winner = determineWinner(playerSelection, cpuSelection);

                // updateScore(winner); IF I WANT TO MAKE A METHOD FOR UPDATING SCORE IN BACKGROUND

                if (winner == "CPU")
                {
                    cpuWin++;
                    gamesPlayed++;
                }

                else if (winner == "player")
                {
                    playerWin++;
                    gamesPlayed++;
                }

                else
                {
                    tieCount++;
                    gamesPlayed++;
                }


            } //end if

        }while (!playerSelection.equalsIgnoreCase("done"));


        winnerBoard(playerWin, cpuWin, tieCount, gamesPlayed);


    }//END MAIN METHOD






    //Method Start
    public static String getPlayerName()
    {
        //Variables
        Scanner userInput = new Scanner(System.in);
        String playerName;

        System.out.print("Enter name: ");
        playerName = userInput.nextLine();

        while (playerName.length() == 0)
        {
            System.out.print("Please enter name:");
            playerName = userInput.nextLine();
        }

        return playerName;

    }








    //Mehthod Start
    public static void welcomePlayer(String x)
    {

        System.out.print("Hello " + x +", welcome to the Rock, Paper, Scissors game");
    }//END METHOD





    //Method Start
    public static String playerChoice()
    {
        String playerSelection;
        Scanner userInput = new Scanner(System.in);


        do {
            System.out.print("\n\nEnter Rock, Paper, Scissors, or Done: ");
            playerSelection = userInput.nextLine();


        }while (!(playerSelection.equalsIgnoreCase("Rock")) && !(playerSelection.equalsIgnoreCase("Paper")) && !(playerSelection.equalsIgnoreCase("Scissors")) && !(playerSelection.equalsIgnoreCase("Done")));

        System.out.print("You have selected " + playerSelection);
        return playerSelection;

    }// End Method





    //Method Start
    public static String computerChoice()
    {
        Random rand = new Random();
        int num1;
        String choice;

        num1 = rand.nextInt(3) + 1;

        switch (num1)
        {
            case 1 : choice = "Rock";
                break;

            case 2 : choice = "Paper";
                break;

            case 3 : choice = "Scissors";
                break;

            default : choice = "";
                break;
        }
        System.out.print("\nThe computer has selected " + choice+"\n");
        return choice;


    }//End Method






    //Method Start
    public static String determineWinner(String player, String cpu)
    {
        String result;


        if (player.equalsIgnoreCase("rock") && cpu.equalsIgnoreCase("paper"))
        {
            System.out.print("Paper covers Rock. CPU wins");
            result = "CPU";
        }
        else if (player.equalsIgnoreCase("paper") && cpu.equalsIgnoreCase("rock"))
        {
            System.out.print("Paper covers Rock. You win");
            result = "player";
        }


        else if (player.equalsIgnoreCase("scissors") && cpu.equalsIgnoreCase("paper"))
        {
            System.out.print("Scissiors cuts Paper. You win");
            result = "player";
        }
        else if (player.equalsIgnoreCase("paper") && cpu.equalsIgnoreCase("Scissors"))
        {
            System.out.print("Scissiors cuts Paper. CPU wins");
            result = "CPU";
        }


        else if (player.equalsIgnoreCase("scissors") && cpu.equalsIgnoreCase("rock"))
        {
            System.out.print("Rock smashes Scissiors. CPU wins");
            result = "CPU";
        }
        else if (player.equalsIgnoreCase("rock") && cpu.equalsIgnoreCase("Scissors"))
        {
            System.out.print("Rock smashes Scissiors. You win");
            result = "player";
        }
        else //(player.equalsIgnoreCase(cpu))
        {
            System.out.print("You have tied");
            result = "tie";
        }

        return result;


    }//End Method



     /* //Method Start
      public static int updateScore(String result)
      {
          if (winner == "CPU")
              {
                cpuWin++;
              }

              else if (winner == "player")
              {
                playerWin++;
              }

              else
              {
               tieCount++;
              }

      Can't determine how to return multiple scores.
      }*/




    //Method Start
    public static void winnerBoard(int playerWin, int cpuWin, int tieCount, int gamesPlayed)
    {

        System.out.println("\n\nGame Statistics: \nThe computer won the game " + cpuWin + " times.");
        System.out.println("You won " + playerWin + " times.");
        System.out.println("There were " + tieCount + " tie games.");
        System.out.println("There were a total of " + gamesPlayed + " games played.");

    }




}