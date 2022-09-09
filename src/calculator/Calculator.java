package calculator;

public class Calculator {

    public String calculate(double number1, double number2, char operator) {



        if (operator == '/' && number2 == 0) return "Division durch 0 nicht möglich!";

        return switch (operator) {
            case '+' -> number1 + " + " + number2 + " = " + String.valueOf(number1 + number2);
            case '-' -> number1 + " - " + number2 + " = " + String.valueOf(number1 - number2);
            case '*' -> number1 + " x " + number2 + " = " + String.valueOf(number1 * number2);
            case '/' -> number1 + " : " + number2 + " = " + String.valueOf(number1 / number2);
            default -> "Sie müssen einen der vier Operatoren +,-,*,/ eingeben!";
        };
    }
}

