package project;

import project.common.*;
import project.staff.Cleaner;
import project.staff.Salary;
import project.staff.Security;
import project.utilities.Energy;
import project.utilities.Water;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final int SIZE = 4;
    private static final String LOGIN = "ad";
    private static final String PASSWORD = "ad";
    static Cleaner[] cleaners = new Cleaner[SIZE];
    static Security[] securitys = new Security[SIZE];
    static Parking[] parkplaces = new Parking[20];
    static Count counter = new Count();
    static Energy energy = new Energy();
    static Water water = new Water();

    public static void main(String[] args) {
        initParkplaces();
        consoleMenu();
    }


    private static void puMenu(){
        Scanner s = new Scanner(System.in);
        int check;

        while (true) {
            System.out.println("\nPublic utilities");
            System.out.println("1. Energy info");
            System.out.println("2. Water info");
            System.out.println("3. Exit to admin menu");

            while (true){
                try{
                    check = s.nextInt();
                    break;
                }catch (InputMismatchException e){
                    System.out.println("Incorrect number format, try again: ");
                    s.nextInt();
                }
            }

            switch (check){

                case 1:
                    double valueE;
                    while (true) {
                        try {
                            System.out.print("Enter consumed energy: ");
                            valueE = s.nextDouble();
                            energy.setConsumed(valueE);
                            break;
                        }catch (InputMismatchException e){
                            System.out.println("Incorrect number format, try again: ");
                            s.nextLine();
                        }
                    }
                    System.out.println(energy.limitRemainingCompute());
                    System.out.println(energy.computePayment());
                    break;
                case 2:
                    double valueW;
                    while (true) {
                        try {
                            System.out.print("Enter consumed water: ");
                            valueW = s.nextDouble();
                            water.setConsumed(valueW);
                            break;
                        }catch (InputMismatchException e){
                            System.out.println("Incorrect number format, try again: ");
                            s.nextLine();
                        }
                    }
                    System.out.println(water.limitRemainingCompute());
                    System.out.println(water.computePayment());
                    break;
                case 3:
                    admin();
                    return;
            }

        }
    }

    private static void admin(){
        Scanner s = new Scanner(System.in);
        int check;

        while (true) {

            System.out.println("\nAdmin menu\n");
            System.out.println("1. Statistic");
            System.out.println("2. Add staff");
            System.out.println("3. Staff control panel");
            System.out.println("4. Public utilities");
            System.out.println("5. Exit to main menu");

            while (true) {
                try {
                    check = s.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Incorrect number format, try again: ");
                    s.nextInt();
                }
            }

            switch (check) {
                case 1:
                    counter.showStatistic();
                    break;
                case 2:
                    addStaffMenu();
                    break;
                case 3:
                    staffControlPanel();
                    return;
                case 4:
                    puMenu();
                    break;
                case 5:
                    consoleMenu();
                    return;
            }
        }
    }

    private static void adminAuthorization(){
        Scanner s = new Scanner(System.in);
        String login;
        String password;

        System.out.print("Enter login: ");
        login = s.nextLine();
        System.out.print("Enter password: ");
        password = s.nextLine();
        if(login.equals(LOGIN) && password.equals(PASSWORD)){
            admin();
        }else{
            System.out.println("Access denied");
        }

    }

    private static void initParkplaces(){
        for (int i = 0; i < parkplaces.length; i++) {
            parkplaces[i] = new Parking(true, false, null, (short) (i+1));
        }
    }

    private static void showOccupied(){
        int counter = 0;
        for(Parking p : parkplaces){
            if(p.getTransport()!= null){
                p.getTransport().showTransportInfo();
                counter++;
            }

        }

        if(counter == 0){
            System.out.println("No one parking place is occupied");
        }
    }

    private static void staffControlPanel(){
        Scanner s = new Scanner(System.in);
        int check;

        while (true) {
            System.out.println("Staff control panel\n");
            System.out.println("1. Calculate salary");
            System.out.println("2. Get status");
            System.out.println("3. Make them to do their responsibilities");
            System.out.println("4. Make them to inspect their equipment");
            System.out.println("5. Exit to Admin menu");

            while (true) {
                try {
                    check = s.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Incorrect number format, try again: ");
                    s.nextInt();
                }
            }

            switch (check) {
                case 1:
                    Salary.computeSalary();
                    break;
                case 2:
                    for (int i = 0; i < SIZE; i++) {
                        if (cleaners[i] != null) {
                            System.out.println(cleaners[i].reportStatus());
                        }
                    }

                    for (int i = 0; i < SIZE; i++){
                        if (securitys[i] != null) {
                            System.out.println(securitys[i].reportStatus());
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < SIZE; i++) {
                        if (cleaners[i] != null) {
                            System.out.println(cleaners[i].doResponsibilities());
                        }
                    }
                    for (int i = 0; i < SIZE; i++) {
                        if (securitys[i] != null) {
                            System.out.println(securitys[i].doResponsibilities());
                        }
                    }
                    break;

                case 4:
                    for (int i = 0; i < SIZE; i++) {
                        if (cleaners[i] != null) {
                            System.out.println(cleaners[i].inspectEquipment());
                        }
                    }
                    for (int i = 0; i < SIZE; i++){
                        if (securitys[i] != null) {
                            System.out.println(securitys[i].inspectEquipment());
                        }
                    }
                    break;
                case 5:
                    admin();
                    return;
            }
        }
    }

    private static void addStaffMenu(){
        Scanner s = new Scanner(System.in);
        int check;
        System.out.println("1. Add security");
        System.out.println("2. Add claner");

        while(true){
            try{
                check = s.nextInt();
                break;
            }catch (InputMismatchException e){
                System.out.println("Incorrect number format, try again: ");
                s.nextInt();
            }
        }

        switch (check){
            case 1:
                addStaff("security");
                break;
            case 2:
                addStaff("cleaner");
                break;
        }

    }

    private static void addStaff(String kind){
        Scanner s = new Scanner(System.in);
        String name;
        String surname;
        int age;
        String pos;
        int exp;

        System.out.printf("Add %s", kind);
        System.out.print("\nEnter name: ");
        name = s.nextLine();
        System.out.print("Enter surname: ");
        surname = s.nextLine();
        while(true){
            try{
                System.out.print("Enter age: ");
                age = s.nextInt();
                s.nextLine();
                System.out.print("Enter position: ");
                pos = s.nextLine();
                System.out.print("Enter work experience: ");
                exp = s.nextInt();
                break;
            }catch (InputMismatchException e){
                System.out.println("Incorrect number format, try again:");
                s.nextInt();
            }
        }

        if(kind.equals("security")){
            Security sec = new Security(name,surname,age,pos,exp);
            addToMasSec(sec);
        }

        if (kind.equals("cleaner")){
            Cleaner cl = new Cleaner(name,surname,age,pos,exp);
            addToMasClean(cl);
        }

    }

    private static void addToMasClean(Cleaner cl){
        for (int i = 0; i < cleaners.length; i++) {
            if (cleaners[i] == null) {
                cleaners[i] = cl;
                break;
            }
        }
    }

    private static void addToMasSec(Security st){
        for (int i = 0; i < securitys.length; i++) {
            if (securitys[i] == null) {
                securitys[i] = st;
                break;
            }
        }
    }

    private static void addToParkPlace(Transport transport){
        for (int i = 0; i < parkplaces.length; i++) {
            if(parkplaces[i].isFree()){
                parkplaces[i].setTransport(transport);
                parkplaces[i].setFree(false);
                parkplaces[i].setPaid(true);
                transport.setId(parkplaces[i].getId());
                break;
            }
        }

    }

    private static void addCar(){
        Scanner s = new Scanner(System.in);

        String mark;
        String model;
        String govnumber;

        System.out.println("Car info\n");
        System.out.print("Enter car mark: ");
        mark = s.nextLine();
        System.out.print("Enter car model: ");
        model = s.nextLine();
        System.out.print("Enter car government number: ");
        govnumber = s.nextLine();
        System.out.println();

        Transport transport = new Transport(mark, model, govnumber);

        String d_name;
        String d_surname;
        String d_email;
        long d_phonenumber;

        System.out.println("Driver info\n");
        System.out.print("Enter driver`s name: ");
        d_name = s.nextLine();
        System.out.print("Enter driver`s surname: ");
        d_surname = s.nextLine();
        System.out.print("Enter driver`s email: ");
        d_email = s.nextLine();
        System.out.print("Enter driver`s phonenumber(0...): ");

        while (true) {
            try {
                d_phonenumber = s.nextLong();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect number format, try again: ");
                s.next();
            }
        }

        Driver driver = new Driver(d_name, d_surname, d_phonenumber,d_email);
        driver.setTransport(transport);
        transport.setDriver(driver);
        addToParkPlace(transport);
        counter.add(1);

    }

    private static void consoleMenu(){
        Scanner s = new Scanner(System.in);
        while (true){

            int check;
            System.out.println("Main Menu\n");
            System.out.println("1. Add car to parking place");
            System.out.println("2. Show taken places");
            System.out.println("3. For admin");
            System.out.println("4. Exit");
            System.out.print("To select action, enter its number: ");

            while (true) {
                try {
                    check = s.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Incorrect number format, try again: ");
                    s.nextInt();
                }
            }

            switch (check){

                case 1:
                    addCar();
                    break;
                case 2:
                    showOccupied();
                    break;
                case 3:
                    adminAuthorization();
                    break;
                case 4:
                    System.out.println("Exit...");
                    System.exit(0);

            }

        }
    }

}
