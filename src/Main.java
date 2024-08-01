// JAVA CALCULATOR TEST TASK
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new Exception("Неверный формат ввода. Используйте формат: число операция число");
        }

        int num1 = parseNumber(parts[0]);
        int num2 = parseNumber(parts[2]);
        String operator = parts[1];

        int result = switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    throw new Exception("Деление на ноль");
                }
                yield num1 / num2;
            }
            default -> throw new Exception("Неподдерживаемая операция: " + operator);
        };

        return String.valueOf(result);
    }

    private static int parseNumber(String str) throws Exception {
        try {
            int number = Integer.parseInt(str);
            if (number < 1 || number > 10) {
                throw new Exception("Число должно быть от 1 до 10 включительно");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new Exception("Неверный формат числа: " + str);
        }
    }
}
