import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String expression = scn.nextLine();

        Calculator calculator = new Calculator();
        calculator.calculate(expression);
    }
}