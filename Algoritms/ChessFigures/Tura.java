public class Tura {
    public static int SIZE = 3;
    public static int[] pos = new int[SIZE];
    public static int counter = 0;

    public static void main(String[] args) {
        placeTurs(0);
        System.out.println("Всього рішень: " + counter);
    }


    public static void placeTurs(int row) {
        if (row == SIZE) {
            printBoard();
            counter++;
            return;
        }

        for (int col = 0; col < SIZE; col++) {
            if (isSafe(row, col)) {
                pos[row] = col;
                placeTurs(row + 1);
            }
        }
    }

    public static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (pos[i] == col) {
                return false;
            }
        }
        return true;
    }


    public static void printBoard() {
        System.out.println("Рішення №" + (counter + 1) + ":");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (pos[i] == j) {
                    System.out.print("T ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
