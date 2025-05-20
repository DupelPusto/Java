import java.util.Scanner;
public class FuncPract {

    public static String checker(){

        Scanner sc = new Scanner(System.in);
        String ex = sc.nextLine().trim();

        String[] mas = ex.split(" ");
        int trucount = 0;
        for (String chars : mas){
            if (chars.length() >= 3){
                trucount++;
            }
            if(trucount >= 2){
                return ex;
            }
        }

        System.out.println("Введіть строку яка відповідає умові");

         return checker();
    }

    public static String fullReverse(String a){
        char[] a1 = a.toCharArray();
        char[] reva = new char[a1.length];
        for (int i = a1.length - 1 ; i >= 0; i--){
            reva[a1.length - 1 - i] = a1[i];
        }
        String a2 = new String(reva);
        return a2;
    }

    public static String wordsReverse(String b){

        String[] b1 = b.split(" ");
        String b2 = new String();
        for(String word : b1){
            b2 += fullReverse(word) + " ";
        }
        return b2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть строку (мінімум 2 слова по 3 символи)");
        String user = checker();
        System.out.println(user);
        System.out.println("Оберіть наступну дію");
        System.out.println("1.Повністю перевернути речення");
        System.out.println("2.Перевернути кожне слово окремо");
        int choose;
        while (true){
            if (sc.hasNextInt()){
                choose = sc.nextInt();
                if (choose == 1 || choose == 2){
                    break;
                }
            }
            System.out.println("Введіть коректне значення");
            sc.next();
        }
        if (choose == 1){
            System.out.println("Ваша перевернута строка: " + fullReverse(user));
        } else if (choose == 2) {
            System.out.println("Ваша строка з перевернутими словами:  " + wordsReverse(user));
        }


    }
}
