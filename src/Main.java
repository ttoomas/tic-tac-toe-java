import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static String line = "----------------------------------------------------------------------------------------------------------------";
    static String circle = "○";
    static String square = "◙";
    static boolean playerWon = false;
    static int[][] gameNumbers = new int[3][3];

    public static void main(String[] args) {
        System.out.println("Vítej ve hře tic-tac-toe");
        System.out.println("Tvým úkolem bude získat tři stejné symboly v řadě");
        System.out.println("Pro hraní použij klávesnici");
        System.out.println("První zadáš pozici kterou chceš zabrat, tu zadáš čísly 1 až 9");
        System.out.println("Druhé zadáš, svůj znak");
        System.out.println("Číslo 1 značí kolečko ○");
        System.out.println("Číslo 2 značí čtverec ◙");
        System.out.println("Hodně Štěstí");
        System.out.println(line);

        game();

//        int[] numbers = {1, 2, 3, 1, 0};
//        int[] test = Arrays.stream(numbers).distinct().toArray();
//
//        System.out.println(Arrays.toString(test));
    }

    static void game(){
        Scanner sc = new Scanner(System.in);

        // Position
        System.out.println("Zadej pozici");
        double position = sc.nextDouble();

        if(position < 1 || position > 9){
            System.out.println("Zadal jsi špatnou pozici, zkus to znovu");
            game();
            return;
        }

        // Symbol
        System.out.println("Zadej symbol");
        int symbol = sc.nextInt();

        if(symbol != 1 && symbol != 2){
            System.out.println("Zadal jsi špatný symbol, zkus to znovu");
            game();
            return;
        }

        double firstArrDouble = Math.ceil(position / 3);
        int firstArr = (int)firstArrDouble;
        int secondArr = (int)position - ((firstArr - 1) * 3);

        gameNumbers[firstArr - 1][secondArr - 1] = symbol;

        printLines();
    }

    static void printLines(){
        playerWon = false;

        for (int i = 0; i < gameNumbers.length; i++) {
            System.out.println(Arrays.toString(gameNumbers[i]));

            // Check rows
            if(gameNumbers[i][0] == gameNumbers[i][1] && gameNumbers[i][1] == gameNumbers[i][2] && gameNumbers[i][0] != 0){
                playerWon = true;
            }

            // Check column
            else if(gameNumbers[0][i] == gameNumbers[1][i] && gameNumbers[1][i] == gameNumbers[2][i] && gameNumbers[0][i] != 0){
                playerWon = true;
            }
        }

        // Check diagonals
        if(gameNumbers[0][0] == gameNumbers[1][1] && gameNumbers[1][1] == gameNumbers[2][2] && gameNumbers[0][0] != 0){
            playerWon = true;
        }
        else if(gameNumbers[0][2] == gameNumbers[1][1] && gameNumbers[1][1] == gameNumbers[2][0] && gameNumbers[0][2] != 0){
            playerWon = true;
        }

        if(playerWon){
            System.out.println("Vyhrál jsi, gratuluji");
            System.out.println("Pro novou hru musíš znovu spustit program");
            return;
        }

        game();
    }
}