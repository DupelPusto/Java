import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final int SIZE = 25;

//    public static Driver[] drivers = new Driver[SIZE];
//    public static Transport[] transports = new Transport[SIZE];
//    public static Parking[] parkplaces = new Parking[SIZE];


    public static Driver driver;
    public static Transport transport;
    public static Parking parkplace;
    public static Staff staff;
    public static void main(String[] args) {
//        initialize();
        Scanner s = new Scanner(System.in);
        addDriver(s);
        System.out.println();
        addTransport(s);
        System.out.println();
        addStaff(s);
        System.out.println();
        addParkplace(s);
        driver.tostring();
        System.out.println();
        transport.tostring();
        System.out.println();
        parkplace.tostring();
        System.out.println();
        staff.tostring();

    }

//    private static void initialize(){
//        for (int i = 0; i < SIZE; i++) {
//            drivers[i] = new Driver();
//            transports[i] = new Transport();
//        }
//    }

    private static void addParkplace(Scanner s){
        boolean isfree;
        boolean ispaid;
        boolean paytype;
        System.out.println("Паркувальне місце");
        System.out.println("Чи вільне паркомісце(true/false):");
        isfree = s.nextBoolean();
        System.out.println("Чи оплачене паркомісце(true/false):");
        ispaid = s.nextBoolean();
        System.out.println("Тип оплати паркомісця(true - готівка/false - безготівково):");
        paytype = s.nextBoolean();
        s.nextLine();
        parkplace = new Parking(isfree, ispaid, transport,paytype);
    }

    private static void addDriver(Scanner s){

        String name;
        String surname;
        String email;
        int number;
        System.out.println("Додавання водія");
        System.out.println("Введіть ім'я водія: ");
        name = s.nextLine();
        System.out.println("Введіть прізвище водія: ");
        surname = s.nextLine();
        System.out.println("Введіть email водія: ");
        email = s.nextLine();
        System.out.println("Введіть номер водія: ");
        try {
            number = s.nextInt();
            s.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Некоректний формат номера, спробуйте ще раз: ");
            s.next();
            number = s.nextInt();
        }

        driver = new Driver(name, surname, number, email);
    }

    private static void addTransport(Scanner s){

        String carmodel;
        String govnumber;
        System.out.println("Додавання автомобіля");
        System.out.println("Введіть марку та модель автомобіля: ");
        carmodel = s.nextLine();
        System.out.println("Введіть державний номерний знак: ");
        govnumber = s.nextLine();
        s.nextLine();
        transport = new Transport(carmodel, govnumber);
    }

    private static void addStaff(Scanner s){

        String name;
        int age;
        String kind;
        String position;
        int exp;

        System.out.println("Додавання персоналу");
        System.out.println("Введіть ім'я: ");
        name = s.nextLine();

        System.out.println("Введіть вік: ");
        try {
            age = s.nextInt();
            s.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Некоректний формат, спробуйте ще раз: ");
            s.next();
            age = s.nextInt();
            s.nextLine();
        }

        System.out.println("Введіть тип персоналу: ");
        kind = s.nextLine();

        System.out.println("Введіть посаду: ");
        position = s.nextLine();

        System.out.println("Введіть досвід роботи: ");
        try {
            exp = s.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Некоректний формат, спробуйте ще раз: ");
            exp = s.nextInt();
        }

        staff = new Staff(name, age, position, exp, kind);
    }
}