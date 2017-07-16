package edu.nau.ipz.HomeWorkStudent;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Helper {
    static int inputIntData(String msg, int max) {
        System.out.print(msg + ": ");
        int val = 0;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    val = scanner.nextInt();
                    if (val >= 1 || val <= max) {
                        break;
                    }
                    throw new IntDataParserException("Введіть число в заданих межах");
                }
            } catch (IntDataParserException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        return val;
    }

    static String inputStringData(String msg, String regex) {
        System.out.print(msg + ": ");
        String val = "";
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                if(scanner.hasNext()){
                    val = scanner.nextLine();
                    if(Pattern.matches(regex, val)) {
                        break;
                    }
                        throw new StringDataParserException("Введіть значення в необхідному форматі");
                }
            } catch (StringDataParserException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        return val;
    }

    static double inputDoubleData(String msg, double min, double max) {
        System.out.print(msg + ": ");
        double val = 0;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextDouble()) {
                    val = scanner.nextDouble();
                    if (val >= min || val <= max) {
                        break;
                    }
                }
                    throw new DoubleDataParserException("Введіть десяткове значення через кому в заданих межах");

            } catch (DoubleDataParserException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        return val;
    }

    static <E extends Enum<E>> boolean isInEnum(String value, Class<E> enumClass) {
        for (E e : enumClass.getEnumConstants()) {
            if(e.name().equals(value.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    static <E extends Enum<E>> Sex inputEnumData(String msg, Class<E> enumClass) {
        System.out.print(msg + ": ");
        String val = "";
        Sex s = Sex.Ч;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNext()) {
                    val = scanner.nextLine();
                    if (isInEnum(val, enumClass)) {
                        s = Sex.valueOf(val.toUpperCase());
                        break;
                    }
                    throw new EnumDataParserException("Введіть значення із запропонованих");
                }
            } catch (EnumDataParserException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        return s;
    }
}
