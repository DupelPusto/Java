public class ThirdEx {
    public static void main(String[] args) {

        System.out.print("   | ");
        for (int i = 1; i <= 10; i++)
        {
            System.out.printf("%4d", i);
        }
        System.out.println();
        System.out.println();


        for (int line = 1; line <= 10; line++)
        {
            System.out.printf("%4d", line);
            for (int column = 1; column <= 10; column++)
            {
                System.out.printf("%4d", line * column);
            }
            System.out.println();
        }
    }
}
