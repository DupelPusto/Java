import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;



public class Massorting {

    public static void mascreate(Scanner s, Random r){
        System.out.println("Введіть розмір масиву: ");
        try {
            int size = s.nextInt();
            int[] mas = new int[size];
            for (int i = 0; i < size; i++) {
                mas[i] = r.nextInt(0,50);
            }
            System.out.println("Несортований масив: " + Arrays.toString(mas));
            massort(mas);
        }catch (InputMismatchException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static void massort(int[] mas){
        int counter = 0;
        for (int i = 0; i < mas.length; i++) {
            if(mas[i] % 2 == 0){
                counter++;
            }
        }

        int[] indmas = new int[counter];
        int ind = 0;
        for (int i = 0; i < mas.length; i++) {
            if(mas[i] % 2 == 0){
                indmas[ind++] = i;
            }
        }

        for (int i = 0; i < counter; i++) {
            int minind = i;
            for (int j = i + 1; j < counter; j++) {
                if(mas[indmas[j]] < mas[indmas[minind]]){
                    minind = j;
                }
            }
            swap(mas, indmas[i], indmas[minind]);
        }
        System.out.println("Відсортований масив: " + Arrays.toString(mas));

    }

    public static void swap(int[] array, int i, int j) {
        if (i == j) return;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void mainmenu() {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        while (true) {
            System.out.println();
            System.out.println("Головне меню");
            System.out.println();
            System.out.println("1.Створити масив рандомних чисел(значення 0 - 50)");
            System.out.println("2.Вихід");
            System.out.println("Для вибору введіть номер пункту");
            try{
                short menu = s.nextShort();
                s.nextLine();
                switch (menu){
                    case 1:
                        mascreate(s, r);
                        break;
                    case 2:
                        System.out.println("Вихід...");
                        s.close();
                        return;
                    default:
                        System.out.println("Неіснуючий пункт меню, спробуйте знову");
                }
            } catch (InputMismatchException e){
                System.out.println("Помилка: " + e.getMessage());
                s.nextLine();
            }
        }
    }
    public static void main(String[] args) {
        mainmenu();
    }
}
