import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static String line = "----------------------------------------------------------------------------------------------------------------";
    static String circle = "o";
    static String square = "x";
    static String playerWon = "";
    static String playerName1;
    static String playerName2;
    static String currentPlayer;
    static String currentSymbol = circle;
    static String[][] gameNumbers = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Vítej ve hře tic-tac-toe");
        System.out.println("Tvým úkolem bude získat tři stejné symboly v řadě");
        System.out.println("Pro hraní použij klávesnici");

        System.out.println("Zadej jméno prvního hráče");
        playerName1 = sc.nextLine();

        System.out.println("Zadejte jméno druhé hráče");
        playerName2 = sc.nextLine();

        currentPlayer = playerName1;

        System.out.println("Hráče se jménem " + playerName1 + " značí kolečko " + circle);
        System.out.println("Hráče se jménem " + playerName2 + " značí čtverec " + square);
        System.out.println("Hodně Štěstí");
        System.out.println(line);

        game();
    }

    static void game(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Právě je na tahu hráč se jménem " + currentPlayer + ", jeho znak je " + currentSymbol);


        // Y Position
        System.out.println("Zadej y pozici (1 - 3)");
        int yPosition = sc.nextInt();

        if(yPosition < 1 || yPosition > 4){
            System.out.println("Zadal jsi špatnou pozici, zkus to znovu");
            game();
            return;
        }


        // X Position
        System.out.println("Zadej x pozici (1 - 3)");
        int xPosition = sc.nextInt();

        if(xPosition < 1 || xPosition > 4){
            System.out.println("Zadal jsi špatnou pozici, zkus to znovu");
            game();
            return;
        }


        if(!Objects.equals(gameNumbers[yPosition - 1][xPosition - 1], "-")){
            System.out.println("Zabráno");
            game();
        }
        else{
            if(Objects.equals(currentPlayer, playerName1)){
                gameNumbers[yPosition - 1][xPosition - 1] = circle;
            }
            else{
                gameNumbers[yPosition - 1][xPosition - 1] = square;
            }


            printLines();
        }
    }

    static void printLines(){
        playerWon = "";
        int fullPlayground = 0;

        for (int i = 0; i < gameNumbers.length; i++) {
            System.out.println(Arrays.toString(gameNumbers[i]).replace("[", "").replace("]", " ").replace(",", ""));

            // Check rows
            if(Objects.equals(gameNumbers[i][0], gameNumbers[i][1]) && Objects.equals(gameNumbers[i][1], gameNumbers[i][2]) && !Objects.equals(gameNumbers[i][0], "-")){
                playerWon = gameNumbers[i][0];
            }

            // Check column
            else if(Objects.equals(gameNumbers[0][i], gameNumbers[1][i]) && Objects.equals(gameNumbers[1][i], gameNumbers[2][i]) && !Objects.equals(gameNumbers[0][i], "-")){
                playerWon = gameNumbers[0][i];
            }

            if(!Arrays.asList(gameNumbers[i]).contains("-")){
                fullPlayground++;
            }
        }

        // Check diagonals
        if(Objects.equals(gameNumbers[0][0], gameNumbers[1][1]) && Objects.equals(gameNumbers[1][1], gameNumbers[2][2]) && !Objects.equals(gameNumbers[0][0], "-")){
            playerWon = gameNumbers[0][0];
        }
        else if(Objects.equals(gameNumbers[0][2], gameNumbers[1][1]) && Objects.equals(gameNumbers[1][1], gameNumbers[2][0]) && !Objects.equals(gameNumbers[0][2], "-")){
            playerWon = gameNumbers[0][2];
        }

        // Check if someone won
        if(!Objects.equals(playerWon, "")){
            System.out.println("Vyhrál hráč se jménem " + currentPlayer + ", gratuluji!");
            System.out.println("Pro novou hru musíš znovu spustit program");
            return;
        }

        // Check if playground is not full
        if(fullPlayground == 3){
            System.out.println();
            System.out.println("Herní pole je plné, hra skončila");
            System.out.println("Pro novou hru musíš znovu spustit program");

            return;
        }


        // Update current player and symbol
        if(Objects.equals(currentPlayer, playerName1)){
            currentPlayer = playerName2;
            currentSymbol = square;
        }
        else{
            currentPlayer = playerName1;
            currentSymbol = circle;
        }

        game();
    }
}