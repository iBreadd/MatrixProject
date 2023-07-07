import java.util.Scanner;

public class Main {
    public static int[][] inputMatrix(int rows, int columns) {
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

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix1[0].length;

        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean validateMatrixDimensions(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int columns2 = matrix2[0].length;

        return rows1 == rows2 && columns1 == columns2;
    }

    public static void performMatrixAddition(int[][] matrix1, int[][] matrix2) {
        if (validateMatrixDimensions(matrix1, matrix2)) {
            int[][] sum = addMatrices(matrix1, matrix2);
            System.out.println("Резултатът от събирането на двете матрици е:");
            printMatrix(sum);
        } else {
            System.out.println("Матриците не могат да бъдат събрани. Размерностите им не съвпадат.");
        }
    }
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int columns2 = matrix2[0].length;

        if (columns1 != rows2) {
            return null;
        }

        int[][] result = new int[rows1][columns2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                for (int k = 0; k < columns1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    public static boolean validateMatrixDimensionsForMultiplication(int[][] matrix1, int[][] matrix2) {
        int columns1 = matrix1[0].length;
        int rows2 = matrix2.length;

        return columns1 == rows2;
    }

    public static void performMatrixMultiplication(int[][] matrix1, int[][] matrix2) {
        if (validateMatrixDimensionsForMultiplication(matrix1, matrix2)) {
            int[][] product = multiplyMatrices(matrix1, matrix2);

            if (product != null) {
                System.out.println("Резултатът от умножението на двете матрици е:");
                printMatrix(product);
            } else {
                System.out.println("Матриците не могат да бъдат умножени. Невалидни размерности.");
            }
        } else {
            System.out.println("Матриците не могат да бъдат умножени. Невалидни размерности.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Въведете редовете на първата матрица: ");
        int rows1 = scanner.nextInt();
        System.out.print("Въведете колоните на първата матрица: ");
        int columns1 = scanner.nextInt();

        int[][] matrix1 = inputMatrix(rows1, columns1);

        System.out.println("Първа матрица:");
        printMatrix(matrix1);

        System.out.print("Въведете редовете на втората матрица: ");
        int rows2 = scanner.nextInt();
        System.out.print("Въведете колоните на втората матрица: ");
        int columns2 = scanner.nextInt();

        int[][] matrix2 = inputMatrix(rows2, columns2);

        System.out.println("Втора матрица:");
        printMatrix(matrix2);

        performMatrixAddition(matrix1, matrix2);

        performMatrixMultiplication(matrix1, matrix2);
    }
}
