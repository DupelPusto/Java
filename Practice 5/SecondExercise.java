import java.util.Scanner;
import java.lang.Math;
public class Pract5Second
{


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Введення користувачем занчення змінної x
        System.out.println("Enter x value:");
        double x = sc.nextDouble();

        // Введення користувачем занчення змінної a
        System.out.println("Enter a value:");
        double a = sc.nextDouble();

        // Введення користувачем занчення змінної b
        System.out.println("Enter b value:");
        double b = sc.nextDouble();

        double res;

        if (x > -3 && x < 2) //Перевірка першої умови
        {
            res = Math.sqrt(a * x + 2);
            System.out.println("The result is: " + res);
        }
        else if (x == 2) // Перевірка другої умови
        {
            res = Math.cos(Math.toRadians(2 * x));
            System.out.println("The result is: " + res);
        }
        else if (x > 2) // Перевірка третьої умови
        {
            res =  (3 * Math.pow(x, 2)) + (b * x) + 1;
            System.out.println("The result is: " + res);
        }
        else // Виведення у разі якщо жодна з умов не була виконана
        {
            System.out.println("The number you entered is incorrect. Try again");
        }
    //Завершення програми

    }
}
