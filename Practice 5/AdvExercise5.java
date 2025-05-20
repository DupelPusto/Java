import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class Pract6
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        //Користувач задає кількість елементів
        System.out.println("Введіть кількість рандомних чисел: ");
        double input = sc.nextDouble();
        System.out.println("Введіть мінімальне значення: ");
        double input2 = sc.nextDouble();
        System.out.println("Введіть максимальне значення: ");
        double input3 = sc.nextDouble();

        //Створення динамічного масиву
        ArrayList <Double> nums = new ArrayList<>();

        Random rand = new Random();

        //Додаємо до списку рандомні значення
        for (int i = 0; i < input; ++i)
        {
            double randnum = rand.nextDouble(input2, input3);
            nums.add(randnum);

        }

        //Розрахунок середнього арифметичного та геометричного
        double do_ser_arif = 0;
        double do_ser_geom = 1;
        //System.out.println("Згенеровані числа: ");

        for (int i = 0; i < nums.size(); i++)
        {
            double y = nums.get(i);
            do_ser_arif += y;
            do_ser_geom *= y;
            //Виведення записаних рандомних значень(також дивись 37 рядок)
            //System.out.println(y);
        }
        //Виведення середнього арифметичного
        double ser_arif = do_ser_arif / nums.size();
        System.out.println("Середнє арифметичне чисел: " + ser_arif);

        //Перевірка для знаходження середнього геометричного
        //Середнє геометричне можна знайти у випадку якщо підкореневий вираз do_ser_geom додатній
        if (do_ser_geom > 0)
        {
            double ser_geom = Math.pow(do_ser_geom, 1/input);
            System.out.println("Середнє геометричне числе: " + ser_geom);

        }
        else
        {
            System.out.println("Неможливо знайти середнє геометричне, так як підкоренвий вираз не додатній");
        }
        //Завершення програми
    }
}
