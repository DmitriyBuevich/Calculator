package Calculator;

// создаем класс для Режим=Римский
public class Roman {

    // делаем значение закрытым
    private final int value;

    // конструктор класса. Который создает новый экземпляр класса римской системы по входящей строке
    public Roman(String str) throws Exception {
        // делаем расширенный Switch

        switch (str) {
            case "I" -> this.value = 1;
            case "II" -> this.value = 2;
            case "III" -> this.value = 3;
            case "IV" -> this.value = 4;
            case "V" -> this.value = 5;
            case "VI" -> this.value = 6;
            case "VII" -> this.value = 7;
            case "VIII" -> this.value = 8;
            case "IX" -> this.value = 9;
            case "X" -> this.value = 10;
            default -> throw new Exception("Римские цифры введены неверно или вне допустимого диапозона от 1 до 10");
        }
    }

    // метод перевода в главном классе Число1 и Число2 из Режим=Римский в Арабкий
    public int intValue() {
        return this.value;
    }


    //создаем конвертер Числа в Строку из значения Int
    public static String convertIntToStr(int value) throws Exception {

        // проверяем на отприцательные риские числа
        if (value < 1) {
            throw new Exception("Ошибка, т.к. в римской системе нет отрицательных чисел");
        }
        // инициализируем, и число 100 запишем как исключение десятки/ еденицы
        String result = "";
        if (value == 100) {
            result = "C";
            return result;
        }

        // Возвращает строковое представление аргумента int value
        String s = String.valueOf(value);
        if (value < 10) {

            // если римское число меньше единицы добавляем 0
            s = "0" + s;
        }

        // представляем строку как подстроки для отделения римких десятков и единиц
        // извлекаем из подстроки Единицы
        int edinica = Integer.parseInt(s.substring(1, 2));

        // извлекаем из подстроки Десятки
        int des = Integer.parseInt(s.substring(0, 1));


        // ДЛЯ результата. присваиваем десяткам их римское написание
        result = switch (des) {
            case 1 -> "X";
            case 2 -> "XX";
            case 3 -> "XXX";
            case 4 -> "XL";
            case 5 -> "L";
            case 6 -> "LX";
            case 7 -> "LXX";
            case 8 -> "LXXX";
            case 9 -> "XC";
            default -> result;
        };

        // // ДЛЯ результата. присваиваем единицам их римское написание
        switch (edinica) {
            case 1 -> result += "I";
            case 2 -> result += "II";
            case 3 -> result += "III";
            case 4 -> result += "IV";
            case 5 -> result += "V";
            case 6 -> result += "VI";
            case 7 -> result += "VII";
            case 8 -> result += "VIII";
            case 9 -> result += "IX";
        }
        return result;
    }
}
