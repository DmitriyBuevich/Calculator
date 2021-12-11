package Calculator;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class MainCalc {

    // используем сканер для чтения из консоли
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // запускаем метод считывания со сканера, сам метод ниже
        String str = getInputData();

        // разделяем полученный массив из сканера при помощи пробела рег.выражения ("\\s")
        String[] strings = str.split("\\s");

        // проверку Число1, Оператора, Число2 на валидность по всем правилам (подходят под условия задачи)

        // Доп.проверка, проверяем на наличие только 1 строки ввода, выбрасываем исключение
        if (strings.length == 1) {
            throw new Exception("Ошибка, строка не является математической операцией");
        }
        // Должно быть 3 переменных в массиве: Число1, Оператор, Число2
        if (strings.length != 3) {
            throw new Exception("Входные данные введены неверно. Не забудьте разделить 2 числа и оператор одним пробелом.");
        }

        // присваиваем 3 входным данным num1, operator, num2
        String num1 = strings[0];
        String operator = strings[1];
        String num2 = strings[2];

        // Нам нужно выбрать режим по умолчанию для дальнейших арифметических действий
        // Переменная Режим. По умолчанию находимся в режим Арабский.
        boolean isRoman = false;

        // объявляем и инициализируем  int переменные
        int int1 = 0;
        int int2 = 0;

        // Определить в каком режиме мы работаем - Римский или Арабский.
        // Если Число1 (num1) - это строка (т.е. римская цифра), то Режим=Римский, Иначе Режим=Арабский
        try {
            // Пытаемся сконвертировать входную строку Числа1 в число. Если получается - хорошо. Если нет, то будет исключение.
            // представляем число в строковом формате. Используем класс обертку Integer
            int1 = Integer.parseInt(num1);
            int2 = Integer.parseInt(num2);
        } catch (Exception e) {
            // не удалось распознать число как обычное арабское число,  переключаемся на Режим=Римский
            isRoman = true;
        }
        // Если режим Риский
        if (isRoman) {
            // нужно пытаться проверить на использование одновременнно разных систем счисления Число1 и Число2
            // пробуем опознать входные числа как римские, если не получится - ошибка
            try {
                // создаем 2 экзэмпляра класса Roman, где у нас хранятся данные Римский
                Roman roman1 = new Roman(num1);
                Roman roman2 = new Roman(num2);

                // переводи Число1 и Число2 из Режим=Римский в Арабкий
                int1 = roman1.intValue();
                int2 = roman2.intValue();

            } catch (Exception e) {
                throw new Exception("Используются одновременно разные системы счисления.");
            }
        }

        // сделаем проверку от 1 до 10
        if (int1 > 10 || int1 < 1 || int2 > 10 || int2 < 1) {
            throw new Exception("Выбран не верный диапазон от 1 до 10");
        }

        // считаем арабские числа и получаем результат
        int result = calc(int1, int2, operator);

        // выводим Наш результат
        if (isRoman) {
            // Если Режим=Римский, то РЕЗУЛЬТАТ конвертируем из арабских цифр в римские.
            System.out.println("Наш результат " + Roman.convertIntToStr(result));
        } else {
            System.out.println("Наш результат " + result);
        }

    }

    // метод получения строки из сканера
    public static String getInputData() {
        String str = scanner.nextLine();
        return str;
    }

    // метод получения результата с арабкими числами
    public static int calc(int a, int b, String operation) throws Exception {
        // инициализируем, и выбирваем нужный оператор
        int result = 0;
        switch (operation) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new Exception("Не удалось определить оператор (+, -, /, *)");
        }
        return result;
    }
}