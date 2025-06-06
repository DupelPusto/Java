import java.util.Arrays;

/*
Задача про сонячні панелі
Умова: Встановити якнайбільше панелей, які вміщуються на даху довжиною L.
 */
public class SolarPanels {
    public static void main(String[] args) {
        int[] panels = {3, 2, 5, 1};
        int L = 7;

        //Сортування за зростанням
        for(int i = 0; i < panels.length - 1; i++) {
            for(int j = i +1; j < panels.length;j++){
                if(panels[i] > panels[j]){
                    swap(panels, i, j);
                }
            }
        }


        System.out.println("1 варіант");
        int total = 0;
        int count = 0;
        for (int i = 0; i < panels.length; i++) {
            while (total + panels[i] <= L) {
                total += panels[i];
                count++;
                System.out.println("Взято панель довжиною " + panels[i]);
            }
        }
        System.out.println("Установлено панелей: " + count);

        System.out.println("2 варіант");
        int total1 = 0;
        int count1 = 0;
        for (int i = 0; i < panels.length; i++) {
            if (total1 + panels[i] <= L) {
                total1 += panels[i];
                count1++;
                System.out.println("Взято панель довжиною " + panels[i]);
            }
        }
        System.out.println("Установлено панелей: " + count1);


    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
