import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static int minvaluesearch(int[] mas){
        int min = mas[0];
        for (int num : mas){
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    static int maxvaluesearch(int[] mas){
        int max = mas[0];

        for (int num : mas){
            if(num > max){
                max = num;
            }
        }
        return max;
    }

    static String changer(int[] mas, int min, int max){
        for (int i = 0; i < mas.length; i++) {
            if(mas[i] == max){
                mas[i] = min;
            }
        }
        return Arrays.toString(mas);
    }

    static void mainmenu(){
        Scanner s = new Scanner(System.in);
        int menu;
        int minnumber;
        int maxnumber;
        Random random = new Random();
        while (true) {
            System.out.println();
            System.out.println("Меню:");
            System.out.println("1.Статичний масив");
            System.out.println("2.Масив з рандомними числами");
            System.out.println("3.Вихід");
            System.out.println("Для виберу введіть номер пункту");
            try{
                menu = s.nextInt();
                s.nextLine();
                switch (menu){
                    case 1:
                        int[] numbers = new int[]{1, 5, 3, 56, 56, 34, 56};

                        System.out.println("Початковий масив: " + Arrays.toString(numbers));
                        minnumber = minvaluesearch(numbers);
                        maxnumber = maxvaluesearch(numbers);
                        String newmas = changer(numbers,minnumber,maxnumber);

                        System.out.println("Мінімальне число: " + minnumber);
                        System.out.println("Максимальне число: " + maxnumber);
                        System.out.println("Змінений масив: " + newmas);
                        break;

                    case 2:
                        System.out.println("Введіть розмір масиву: ");
                        int size = s.nextInt();
                        s.nextLine();
                        int[] numbers1 = new int[size];
                        for (int i = 0; i < size; i++) {
                             numbers1[i] = random.nextInt(0,250);
                        }

                        System.out.println("Початковий масив" + Arrays.toString(numbers1));
                        minnumber = minvaluesearch(numbers1);
                        maxnumber = maxvaluesearch(numbers1);
                        String newmas1 = changer(numbers1,minnumber,maxnumber);

                        System.out.println("Мінімальне число: " + minnumber);
                        System.out.println("Максимальне число: " + maxnumber);
                        System.out.println("Змінений масив: " + newmas1);
                        break;
                    case 3:
                        System.out.println("Вихід...");
                        return;
                }
            } catch (InputMismatchException e){
                System.out.println("Error: " + e.getMessage());
                s.nextLine();
            }


        }
    }

    public static void main(String[] args) {
        mainmenu();
    }
}