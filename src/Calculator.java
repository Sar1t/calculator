import java.util.Arrays;

public class Calculator {

    public void calculate(String s) throws Exception {
        String[] symbols = s.split(" ");

        if (symbols.length != 3) {
            System.out.println("Неверный формат выражения");

        } else {
            boolean isArabic = isArabic(symbols[0]) && isArabic(symbols[2]);
            boolean isRoman = isRoman(symbols[0]) && isRoman(symbols[2]);
            if (!isArabic && !isRoman) {
                System.out.println("Нельзя использовать арабские и римские цифра одновременно");

            } else {
                int a, b = 0;

                if (isArabic) {
                    a = Integer.parseInt(symbols[0]);
                    b = Integer.parseInt(symbols[2]);
                } else {
                    a = romanToArabic(symbols[0]);
                    b = romanToArabic(symbols[2]);
                }

                int result = switch (symbols[1]) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> a / b;
                    default -> throw new Exception("Неверный символ");
                };

                if (isArabic) {
                    System.out.println(result);
                } else {
                    if (result > 0) {
                        System.out.println(arabicToRoman(result));
                    } else {
                        System.out.println("Результат меньше нуля");
                    }
                }
            }
        }
    }

    private boolean isArabic(String a) {
        try {
            int n = Integer.parseInt(a);
            return n <= 10 && n >= 1;
        } catch (NumberFormatException n) {
            return false;
        }
    }

    private boolean isRoman(String a) {
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        return Arrays.asList(roman).contains(a);
    }

    private int romanToArabic(String a) throws Exception {
        switch (a) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                throw new Exception("Римское число не может быть больше 10 и меньше 1");
        }
    }

    private String arabicToRoman(int a) {
        int[] arabicValues = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbols = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arabicValues.length; i++) {
            while (a >= arabicValues[i]) {
                result.append(romanSymbols[i]);
                a -= arabicValues[i];
            }
        }
        return result.toString();
    }
}
