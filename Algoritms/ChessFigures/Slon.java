public class Slon {

    public static int SIZE = 8;
    public static int[] positions = new int[SIZE];
    public static int counter = 0;

    public static void main(String[] args) {
        placeSlons(0);
        
    }


    public static void placeSlons(int row) {
        if (row == SIZE) {
            printBoard();
            counter++;
            return;
        }

        for (int col = 0; col < SIZE; col++) {
            if (isSafe(row, col)) {
                positions[row] = col;
                placeSlons(row + 1);
            }
        }
    }


    public static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            int prevCol = positions[i];
            if (Math.abs(prevCol - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }


    public static void printBoard() {
        System.out.println("Рішення:");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (positions[i] == j) {
                    System.out.print("S ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
