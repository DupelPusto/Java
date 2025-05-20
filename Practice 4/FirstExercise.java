import java.util.Scanner;

public class FirstEX
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть довжину першої сторони: ");
        int firstside = sc.nextInt();

        System.out.println("Введіть довжину другої сторони: ");
        int secondside = sc.nextInt();

        System.out.println("Введіть довжину третьої сторони: ");
        int thirdside = sc.nextInt();

        int sum1_1 = firstside - (secondside + thirdside);
        int sum1_2 = secondside - (firstside + thirdside);
        int sum1_3 = thirdside - (secondside + firstside);

        if (sum1_1 < 0 && sum1_2 < 0 && sum1_3 < 0){
            System.out.println("З заданими сторонами може існувати трикутник ");
        } else {
            System.out.println("З заданими сторонами не може існувати трикутник ");
        }

        if (firstside == secondside && firstside == thirdside){
            System.out.println("Трикутник рівносторонній");
        } else if (firstside == secondside || firstside == thirdside || secondside == thirdside) {
            System.out.println("Трикутник рівнобедрений");
        } else {
            System.out.println("Трикутник різносторонній");
        }

        sc.close();
    }
}
