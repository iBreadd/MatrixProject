import java.util.Scanner;

public class Main {
    public static int[][] inputTheMatrix(int rows, int columns) {
        Scanner sc = new Scanner(System.in);

        int[][] matrix = new int[rows][columns];

        System.out.println("Въведете елементите на матрицата:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Елемент [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }

        return matrix;
    }

    public static void outputTheMatrix(int[][] matrix) {
        System.out.println("Въведената матрица е:");

        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Въведете брой на редовете: ");
        int rows = scanner.nextInt();
        System.out.print("Въведете брой на колоните: ");
        int columns = scanner.nextInt();

        int[][] matrix = inputTheMatrix(rows, columns);
        outputTheMatrix(matrix);
    }
}
