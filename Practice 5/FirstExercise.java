
public class Pract5First
{
    //Створення констант необхідних за умовою
    public static final double a = 0.3;
    public static final double b = 0.9;
    public static final double c = 0.61;


    public static void main(String[] args)
    {

        //Знаходимо перший доданок прикладу
        double firstx = Math.pow(a, 2 * c) + (Math.pow(b, -c) * Math.cos(Math.toRadians(a) + Math.toRadians(b)));
        double firsty = Math.sqrt(Math.pow(c,2) + b);
        //Знаходимо другий доданок прикладу
        double secondx = c + 1;
        double secondy = Math.pow(b,2) * Math.pow(Math.sin((a+c)/c),3);

        //Знаходимо результат прикладу
        double resultx = firstx + secondx;
        double resulty = firsty - secondy;

        //Виведення результату обчислення прикладу
        System.out.println("Result x is: " + resultx);
        System.out.println("Result y is: " + resulty);
      
    }

}
