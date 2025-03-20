import java.util.Scanner;
public class Practise10 {

    public static final int maxusers = 15;
    public static final String[] usernames = new String[maxusers];
    public static final String[] passwords = new String[maxusers];
    public static final String[] unallowedPasw = {"admin", "password", "qwerty", "QWERTY", "YTREWQ", "ytrewq", "pasw"};


    public static void UserLogup(Scanner s){
        try {
            System.out.print("Введіть ім'я користувача(мінімум 5 символів без пробілів): ");
            String username = s.nextLine();
            UsernameValid(username);

            System.out.print("Введіть пароль(мін.10 символів, 1 спецсимвол, 3 цифри): ");
            String password = s.nextLine();
            PasswordValid(password);

            for (int i = 0; i < maxusers; i++) {
                if(usernames[i] == null){
                    usernames[i] = username;
                    passwords[i] = password;
                    System.out.println("Користувача " + username + " зареєстровано");
                    return;
                }
            }
            System.out.println("Максимальна кількість користувачів. Видаліть користувача щоб додати нового");

        } catch (IllegalArgumentException e){
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static void UsernameValid(String name){
        if(name.length() < 5){
            throw new IllegalArgumentException("Ім'я користувача коротше 5 символів");
        }
        for (int i = 0; i < name.length(); i++) {
            if(name.charAt(i) == ' '){
                throw new IllegalArgumentException("Пробіл в імені");
            }
        }

    }

    public static void PasswordValid(String pasw){
        if(pasw.length() < 10){
            throw new IllegalArgumentException("Пароль менше 10 символів");
        }

        int numbers = 0;
        boolean spsymbol = false;
        for (int i = 0; i < pasw.length() ; i++) {
            if(pasw.charAt(i) == ' '){
                throw new IllegalArgumentException("Пароль містить пробіл");
            }
            if(!Character.isLetterOrDigit(pasw.charAt(i))){
                spsymbol = true;
            }
            if(Character.isDigit(pasw.charAt(i))){
                numbers++;
            }
        }
        if(!spsymbol){
            throw new IllegalArgumentException("Пароль має містити хоча б 1 спецсимвол");
        }
        if(numbers < 3){
            throw new IllegalArgumentException("Пароль має містити хоча б 3 цифри");
        }
        for (String str : unallowedPasw) {
            if(pasw.contains(str)){
                throw new IllegalArgumentException("Недозволені слова в паролі");
            }
        }
    }

    public static void UserAutorize(Scanner s){
        System.out.print("Введіть ім'я користувача: ");
        String name = s.nextLine();
        System.out.print("Введіть пароль: ");
        String password = s.nextLine();
        for (int i = 0; i < maxusers; i++) {
            if(name.equals(usernames[i]) && password.equals(passwords[i])){
                System.out.println("Користувача" + name + " авторизовано");
                return;
            }
        }
        System.out.println("Невірне ім1я користувача або пароль");

    }

    public static void UserDelete(Scanner s){
        System.out.print("Введіть ім'я користувача для видалення: ");
        String name = s.nextLine();
        for (int i = 0; i < maxusers; i++) {
            if(name.equals(usernames[i])){
                usernames[i] = null;
                passwords[i] = null;
                System.out.println("Користувача " + name + " видалено");
                return;
            }
        }
        System.out.println("Користувача не знайдено");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("\nМеню:\n");
            System.out.println("1.Реєстрація");
            System.out.println("2.Авторизація");
            System.out.println("3.Видалити користувача");
            System.out.println("4.Вихід");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    UserLogup(sc);
                    break;
                case 2:
                    UserAutorize(sc);
                    break;
                case 3:
                    UserDelete(sc);
                    break;
                case 4:
                    System.out.println("Вихід...");
                    return;
            }
        }
    }
}