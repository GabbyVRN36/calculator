import javax.management.InvalidApplicationException;
import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    private static final String[] VALID_OPERATIONS = {"+", "-", "*", "/"};

    public static void main(String[] args) throws InvalidApplicationException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(calc(input));
    }

    public static String calc(String input) throws InvalidApplicationException {
        String[] inputAgrs = input.split(" ");

        int firstArg = validateAndReturnArg(inputAgrs[0]);
        String operation = validateAndReturnOperation(inputAgrs[1]);
        int secondArg = validateAndReturnArg(inputAgrs[2]);

        int result = 0;
        if (operation.equals("+")) {
            result = firstArg + secondArg;
        } else if (operation.equals("-")) {
            result = firstArg - secondArg;
        } else if (operation.equals("*")) {
            result = firstArg * secondArg;
        } else if (operation.equals("/")) {
            result = firstArg / secondArg;
        } else {
            throw new InvalidApplicationException("Недопустимая операция");

        }
        return result + "";
    }

    private static int validateAndReturnArg(String arg) {
        int toIntArg = Integer.parseInt(arg);
        if (toIntArg < 0 || toIntArg > 10) {
            throw new IllegalArgumentException("Число должно быть в диапозоне от 1 до 10");
        }

        return toIntArg;
    }

    private static String validateAndReturnOperation(String operation) {
        if (!Arrays.asList(VALID_OPERATIONS).contains(operation)) {
            throw new IllegalArgumentException("Не допустимая операция");
        }

        return operation;
    }
}
