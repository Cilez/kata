package kataacademy;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите выражение: \n");
        String str = in.nextLine();

        System.out.printf("%s \n", calc(str));
        in.close();
    }

    public static String calc(String result) throws Exception {
        String[] words = result.split(" ");
        // Слишком много аргументов
        if (words.length > 3)
            throw new Exception();
        boolean rome = typeOf(words);

        // Финальный расчет
        if (rome) {
            int x = changeToArabic(words[0]);
            int y = changeToArabic(words[2]);
            switch (words[1]) {
                case "*":
                    result = changeToRome(x * y);
                    break;
                case "+":
                    result = changeToRome(x + y);
                    break;
                case "/":
                    result = changeToRome(x / y);
                    break;
                case "-":
                    result = changeToRome(x - y);
                    break;
                default:
                    throw new Exception();
            }
        } else {
            Integer x = Integer.valueOf(words[0]);
            Integer y = Integer.valueOf(words[2]);

            switch (words[1]) {
                case "*":
                    result = Integer.toString(x * y);
                    break;
                case "+":
                    result = Integer.toString(x + y);
                    break;
                case "/":
                    result = Integer.toString(x / y);
                    break;
                case "-":
                    result = Integer.toString(x - y);
                    break;
                default:
                    throw new Exception();
            }
        }

        return result;
    }

    private static boolean typeOf(String[] str) throws Exception{
        boolean firstNumIsRome = false;
        boolean secondNumIsRome = false;
        String[] rome = {"X","I","II","III","IV","V","VI","VII","VIII","IX"};

        for (String element : rome) {
            if (element.equals(str[0])) {
                firstNumIsRome = true;
                break;
            }
        }
        for (String element : rome) {
            if (element.equals(str[2])) {
                secondNumIsRome = true;
                break;
            }
        }
        boolean readyToException =  (firstNumIsRome == false    & secondNumIsRome == true) |
                                    (firstNumIsRome == true     & secondNumIsRome == false);
        if (secondNumIsRome & firstNumIsRome) {
            return true;
        }
        if (readyToException) {
            throw new Exception();
        }

        Integer x = Integer.valueOf(str[0]);
        Integer y = Integer.valueOf(str[2]);
        Integer[] arabic = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        boolean firstNumIsArabic = false;
        boolean secondNumIsArabic = false;
        for (Integer element : arabic) {
            if (element.equals(x)) {
                firstNumIsArabic = true;
                break;
            }
        }
        for (Integer element : arabic) {
            if (element.equals(y)) {
                secondNumIsArabic = true;
                break;
            }
        }


        if (firstNumIsArabic & secondNumIsArabic) {
            return false;
        } else {
            throw new Exception();
        }

    }

    private static String changeToRome(int num) throws Exception{
        if (num == 0) {
            throw new Exception();
        }
        if (num < 0) {
            throw new Exception();
        }
        String number = "";

        for (int i = 0; i < num; i++) {
            number += "I";
        }

        return number.replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("XXXX", "XL")
                .replace("LL", "C")
                .replace("LXL", "XC")
                .replace("CCCCC", "D")
                .replace("CCCC", "CD")
                .replace("DD", "M")
                .replace("DCD", "CM");
    }

    private static int changeToArabic(String str) throws Exception{
        switch (str) {
            case "I":
                return 1;
            case "II" :
                return 2;
            case "III" :
                return 3;
            case "IV" :
                return 4;
            case"V" :
                return 5;
            case "VI" :
                return 6;
            case "VII" :
                return 7;
            case "VIII" :
                return 8;
            case "IX" :
                return 9;
            case "X" :
                return 10;
            default:
                throw new Exception();
        }
    }
}


