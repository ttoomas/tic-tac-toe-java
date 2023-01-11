import java.util.Scanner;

public class Main {
    static String line = "----------------------------------------------------------------------------------------------------------------";
    static String circle = "○";
    static String square = "◙";
    static int[] gameNumbers = new int[9];

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
    }

    static void game(){
        Scanner sc = new Scanner(System.in);

        // Position
        System.out.println("Zadej pozici");
        int position = sc.nextInt();

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

        gameNumbers[position - 1] = symbol;

        printLines();

//        game();
    }

    static void printLines(){
        for (int i = 0; i < gameNumbers.length; i++) {
            if(i % 3 == 0){
                System.out.println();
            }

            System.out.print(gameNumbers[i]);
        }
    }
}