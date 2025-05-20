import java.util.Scanner;
public class logupexercise {

    public static String SaveNames(String[] namemas) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        int nameNum = 0;

        while (true) {
            if(namemas[14] != null){
                System.out.println("You cant log up. Max of users");
                break;
            }
            if (namemas[nameNum] == null) {
                namemas[nameNum] = name;
                break;
            }

        }
        String currentUser = namemas[nameNum];
        sc.close();
        return currentUser;
    }

    public static String SavePasswords(String[] pasmas){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        int pasNum = 0;
        while (true) {
            if(pasmas[14] != null){
                System.out.println("You cant log up. Max of users");
                break;
            }
            if (pasmas[pasNum] == null) {
                pasmas[pasNum] = password;
                break;
            }
        }
        String currentPassword = pasmas[pasNum];
        sc.close();
        return currentPassword;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] passwords = new String[15];
        String[] names = new String[15];
        System.out.println("Menu\n");
        System.out.println("1.Log in");
        System.out.println("2.Log up");
        int choose = sc.nextInt();
        if (choose == 2){
            SaveNames(names);
            SavePasswords(passwords);

        }


    }
}
