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
    public static int findDeterminant(int[][] matrix) {
        int n = matrix.length;

        if (n == 1) {
            return matrix[0][0];
        } else if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            int determinant = 0;

            for (int i = 0; i < n; i++) {
                int[][] subMatrix = new int[n - 1][n - 1];
                for (int j = 1; j < n; j++) {
                    for (int k = 0, l = 0; k < n; k++) {
                        if (k != i) {
                            subMatrix[j - 1][l] = matrix[j][k];
                            l++;
                        }
                    }
                }
                determinant += (i % 2 == 0 ? 1 : -1) * matrix[0][i] * findDeterminant(subMatrix);
            }

            return determinant;
        }
    }

    public static void printDeterminant(int determinant) {
        System.out.println("Детерминантата на матрицата е равна на: " + determinant);
    }

    public static int[][] calculateTranspose(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] transposeMatrix = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }

        return transposeMatrix;
    }
    public static void printTransposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }


    public static int[][] calculateAdjugate(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] adjugateMatrix = new int[rows][columns];

        int[][] transposeMatrix = calculateTranspose(matrix);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int sign = (int) Math.pow(-1, i + j);
                int minor = calculateMinor(transposeMatrix, i, j);
                adjugateMatrix[i][j] = sign * minor;
            }
        }

        return adjugateMatrix;
    }

    public static void printAdjugateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }



    public static int calculateMinor(int[][] matrix, int row, int column) {
        int n = matrix.length;
        int[][] subMatrix = new int[n - 1][n - 1];

        int rowIndex = 0;
        for (int i = 0; i < n; i++) {
            if (i == row) {
                continue;
            }
            int columnIndex = 0;
            for (int j = 0; j < n; j++) {
                if (j == column) {
                    continue;
                }
                subMatrix[rowIndex][columnIndex] = matrix[i][j];
                columnIndex++;
            }
            rowIndex++;
        }

        return findDeterminant(subMatrix);
    }

    public static int[][] divideByDeterminant(int[][] adjugateMatrix, int determinant) {
        int rows = adjugateMatrix.length;
        int columns = adjugateMatrix[0].length;

        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = adjugateMatrix[i][j] / determinant;
            }
        }

        return result;
    }


    public static void printInverseMatrix(int[][] matrix) {
        int determinant = findDeterminant(matrix);
        if (determinant == 0) {
            System.out.println("Матрицата няма обратна. Детерминантата е 0.");
        } else {
            int[][] adjugateMatrix = calculateAdjugate(matrix);
            int[][] inverseMatrix = divideByDeterminant(adjugateMatrix, determinant);

            System.out.println("Обратната матрица е:");
            printMatrix(inverseMatrix);
        }
    }


    public static boolean canTransformToIdentityMatrix(int[][] matrix) {
        int n = matrix.length;

        // Проверка дали матрицата е квадратна
        if (n != matrix[0].length) {
            return false;
        }

        // Извършване на елементарни редови операции
        for (int i = 0; i < n; i++) {
            // Проверка за ненулев елемент на главния диагонал
            if (matrix[i][i] == 0) {
                // Намерен елемент, който не може да бъде преобразуван до 1
                return false;
            }

            // Преобразуване на елементите под главния диагонал до нули
            for (int j = i + 1; j < n; j++) {
                int factor = matrix[j][i] / matrix[i][i];
                for (int k = i; k < n; k++) {
                    matrix[j][k] -= factor * matrix[i][k];
                }
            }
        }

        return true;
    }



    public static void printMatrixWithIdentityCheck(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        System.out.println("Матрица:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        if (canTransformToIdentityMatrix(matrix)) {
            System.out.println("Това е единична матрица.");
        } else {
            System.out.println("Това не е единична матрица.");
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Въведете редовете на първата матрица: ");
        int rows1 = scanner.nextInt();
        System.out.print("Въведете колоните на първата матрица: ");
        int columns1 = scanner.nextInt();

        int[][] matrix1 = inputMatrix(rows1, columns1);

        System.out.print("Въведете редовете на втората матрица: ");
        int rows2 = scanner.nextInt();
        System.out.print("Въведете колоните на втората матрица: ");
        int columns2 = scanner.nextInt();

        int[][] matrix2 = inputMatrix(rows2, columns2);

        int choice;

        do {
            System.out.println("Моля, въведете число за избор:");
            System.out.println("1. Извеждане на въведените матрици");
            System.out.println("2. Събиране (на 2 матрици)");
            System.out.println("3. Изваждане на матрици (на 2 матрици)");
            System.out.println("4. Умножение на матрици (на 2 матрици)");
            System.out.println("5. Извеждане на детерминанта на матрица");
            System.out.println("6. Извеждане на обратна матрица");
            System.out.println("7. Извеждане дали дадена квадратна матрица може да се преобразува до единичната (E)");
            System.out.println("8. Изход");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Първа матрица:");
                    printMatrix(matrix1);
                    System.out.println("Втора матрица:");
                    printMatrix(matrix2);
                    break;
                case 2:
                    performMatrixAddition(matrix1, matrix2);
                    break;
                case 3:
                    // Логика за изваждане на 2 матрици
                    break;
                case 4:
                    performMatrixMultiplication(matrix1, matrix2);
                    break;
                case 5:
                    System.out.println("Матрица 1:");
                    printDeterminant(findDeterminant(matrix1));
                    System.out.println("Матрица 2:");
                    printDeterminant(findDeterminant(matrix2));
                    break;
                case 6:
                    System.out.println("Транспонирана матрица 1:");
                    int[][] transposeMatrix = calculateTranspose(matrix1);
                    printTransposeMatrix(transposeMatrix);

                    System.out.println("Обратна матрица 1:");
                    int[][] adjugateMatrix = calculateAdjugate(matrix1);
                    printAdjugateMatrix(adjugateMatrix);
                    //printInverseMatrix(matrix1);

                    System.out.println("Транспонирана матрица 2:");
                    int[][] transposeMatrix2 = calculateTranspose(matrix2);
                    printTransposeMatrix(transposeMatrix2);

                    System.out.println("Обратна матрица 2:");
                    int[][] adjugateMatrix2 = calculateAdjugate(matrix2);
                    printAdjugateMatrix(adjugateMatrix2);

                    //printInverseMatrix(matrix2);
                    break;
                case 7:
                    printMatrixWithIdentityCheck(matrix1);
                    printMatrixWithIdentityCheck(matrix2);
                    break;
                case 8:
                    System.out.println("Програмата спря да работи!");
                    break;
                default:
                    System.out.println("Невалиден избор. Моля, опитайте отново.");
                    break;
                }

            } while (choice != 8);
        }
    }
