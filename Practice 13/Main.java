import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.DateTimeException;
public class Main {

    public static final int SIZE = 50;
    public static LocalDateTime[] data = new LocalDateTime[SIZE];
    public static String[] notates = new String[SIZE];

    public static void addnotate(){
        Scanner s = new Scanner(System.in);


        LocalDateTime date;
        while(true) {
            try {
                System.out.println("Введіть дату для запису: ");
                date = LocalDateTime.of(s.nextInt(), s.nextInt(), s.nextInt(), 00, 00);
                s.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (DateTimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        String notate = "";
        String buf;
        System.out.println("Введіть зміст нотатки(для виходу натисніть 0): ");

        while(true) {
            buf = s.nextLine();
            if(buf.equals("0")){
                break;
            }
            notate += buf  + "\n";


        }
        int i;
        for (i = 0; i < SIZE; i++) {

            if(data[i] == null){
                data[i] = date;
                notates[i] = notate;
                System.out.println("Вміст успішно записано");
                break;
            }
        }
        if(i == SIZE){
            System.out.println("Немає вільних місць для запису. Видаліть попередні та спробуйте ще раз");
        }

    }

    public static void deletenotate(){
        Scanner s = new Scanner(System.in);
        LocalDateTime date;
        System.out.println("Введіть дату для видалення нотатки(рік, місяць, число): ");
        date = LocalDateTime.of(s.nextInt(), s.nextInt(), s.nextInt(), 00,00);

        for (int i = 0; i < SIZE; i++) {
            if(date.equals(data[i])){
                data[i] = null;
                notates[i] = null;
                System.out.println("Запис за датою " + date + " успішно видалено");
                break;
            }
            if(i == SIZE - 1) {
                System.out.println("Запису за заданою датою не знайдено, спробуйте ще раз");
            }
        }
    }

    public static void mainmenu(){
        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.println("Головне меню");
            System.out.println();
            System.out.println("1.Додати запис");
            System.out.println("2.Видалити запис");
            System.out.println("3.Переглянути запис");
            System.out.println("4.Вихід");
            System.out.println("Для вибору введіть номер пункту");

            try {
                int menu = s.nextInt();
                s.nextLine();

                switch (menu) {
                    case 1:
                        addnotate();
                        break;
                    case 2:
                        deletenotate();
                        break;
                    case 3:
                        printNotates();
                        break;
                    case 4:
                        s.close();
                        System.out.println("Вихід...");
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Помилка: " + e.getMessage());
                s.nextLine();
            }

        }
    }

    private static void printNotates(){
        for(int i = 0; i<SIZE; i++){
            if(data[i] != null){
                System.out.println(data[i] + " : " );
                System.out.println(notates[i]);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        mainmenu();
    }
}