import java.util.Random;
import java.util.Scanner;

public class SecondEx
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        int x = rand.nextInt(50);
        System.out.println(x);

        Scanner sc = new Scanner(System.in);
        System.out.println("Бот загадав число, спробуй відгадати: ");
        int i = 0;

        starter: while (true)
        {
            int usinput = sc.nextInt();
            i++;

            if (usinput == x)
            {
                System.out.println("Чоловіче, ти шаман! Вгадав число... з " + i + " спроби");
                break;
            } else
            {
                System.out.println("Чоловіче, не вгадав, спробуй ще раз :)");

                continue starter;
            }




        }

    }
}
