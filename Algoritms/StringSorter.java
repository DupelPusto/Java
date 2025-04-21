import java.lang.reflect.Array;
import java.util.Arrays;

public class StringSorter {

    public static void charswap(char[] array, int i, int j) {
        if (i == j) return;
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void strswap(String[] array, int i, int j) {
        if (i == j) return;
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static String[] strsort(String[] s){
        String[] buf = new String[s.length];
        for(int i = 0; i < s.length; i++){
            buf[i] = s[i];
            s[i] = s[i].toLowerCase();
        }
        System.out.println(Arrays.toString(s));

        char[] frstchar = new char[s.length];
        for(int i = 0; i < s.length; i++){
            frstchar[i] = s[i].charAt(0);
        }

        for (int i = s.length - 1; i > 0; i--) {
            int frst = 0;
            for(int j = 1; j <= i; j++){
                if(frstchar[frst] < frstchar[j]){
                    frst = j;
                }
            }
            charswap(frstchar, frst, i);
            strswap(buf, frst, i);
        }
        System.out.println(Arrays.toString(frstchar));
        System.out.println(Arrays.toString(frstchar));
        return buf;
    }


    public static void main(String[] args) {
        String[] mas = new String[]{"banana", "Apple", "cherry", "avocado"};
        System.out.println("Невідсортовані слова: " + Arrays.toString(mas));
        System.out.println("Відсортовані слова: " + Arrays.toString(strsort(mas)));
    }
}
