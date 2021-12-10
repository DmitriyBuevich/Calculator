package Calculator;

import java.util.Scanner;
public class Calc {

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        int a = getInt();
        char operation = getOperation();
        int b = getInt();
        int result = calc(a, b, operation);
        System.out.print("Результат операции: " + result);
    }

    public static int getInt() {
        System.out.println("Введи число от 1 до 10");
        int num = 0;

        if (scanner.hasNextInt()) {  //hasNextInt проверяет входные данные на Int(целое число)
            num = scanner.nextInt(); // считывает целое число
            try {
                if (num > 10 || num < 1) {
                    throw new Exception("Выбран не верный диапазон от 1 до 10");
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Программа завершена");
            }

        }


        return num;
    }


    public static char getOperation() {
        //System.out.print("Введите операцию: ");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0); //считать 0 char, т.е. первый символ
        } else {
            System.out.print("Вы допустили ошибку, повторите ввод.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static int calc(int a, int b, char operation) {
        int result;
        switch (operation) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            default:
                System.out.println("Ввод был неверный, повторите еще раз.");
                result = calc(a, b, getOperation());
        }
        return result;

    }
}