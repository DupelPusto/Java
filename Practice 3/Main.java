import java.text.MessageFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        String outstr = "\nFirst enter: {0}\nSecond enter: {1}\nThird enter: {2}\nFourth enter: {3}";

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your int value:");
        int intvalue = sc.nextInt();

        System.out.println("Enter your double value:");
        double doublevalue = sc.nextDouble();

        System.out.println("Enter your String value:");
        String stringvalue = sc.next();

        System.out.println("Enter your boolean value:");
        boolean booleanvalue = sc.nextBoolean();

        String outmessage = MessageFormat.format(outstr, intvalue, doublevalue, stringvalue, booleanvalue);
        System.out.println(outmessage);

        System.out.println("\n--- Виведення даних у різних форматах ---\n");
        System.out.println(String.format("Ціле число: %d", intvalue));
        System.out.println(String.format("Число з плаваючою точкою: %.2f", doublevalue));
        System.out.println(String.format("Рядок: %s", stringvalue));
        System.out.println(String.format("Логічне значення: %b", booleanvalue));

        System.out.println("\nВиведення за допомогою System.out.printf():");

        System.out.printf("Ціле число: %d%n", intvalue);
        System.out.printf("Число з плаваючою точкою: %.2f%n", doublevalue);
        System.out.printf("Рядок: %s%n", stringvalue);
        System.out.printf("Логічне значення: %b%n", booleanvalue);

        System.out.println("\nВиведення за допомогою оператора +:");
        System.out.println("Ціле число: " + intvalue);
        System.out.println("Число з плаваючою точкою: " + String.format("%.2f", doublevalue));
        System.out.println("Рядок: " + stringvalue);
        System.out.println("Логічне значення: " + booleanvalue);

        sc.close();
    }
}
