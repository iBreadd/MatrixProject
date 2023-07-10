import java.util.Scanner;

public class Main {
    // Въвеждане на матриците , извиква се в майна
    public static double[][] inputMatrix(int rows, int columns) {
        Scanner sc = new Scanner(System.in);

        double[][] matrix = new double[rows][columns];

        System.out.println("Въведете елементите на матрицата:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Елемент [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }

        return matrix;
    }


    //Целта на този метод е да провери дали размерностите на двете матрици са еднакви
    public static boolean validateMatrixDimensions(double[][] matrix1, double[][] matrix2) {
        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int columns2 = matrix2[0].length;

        return rows1 == rows2 && columns1 == columns2;
    }
    // Събиране на две матрици
    public static double[][] addMatrices(double[][] matrix1, double[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix1[0].length;

        double[][] result = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }
    // Извеждане на резултата.
    public static void performMatrixAddition(double[][] matrix1, double[][] matrix2) {
        if (validateMatrixDimensions(matrix1, matrix2)) {
            double[][] sum = addMatrices(matrix1, matrix2);
            System.out.println("Резултатът от събирането на двете матрици е:");
            printMatrix(sum);
        } else {
            System.out.println("Матриците не могат да бъдат събрани. Размерностите им не съвпадат.");
        }
    }

    // Изваждане на две матрици

    public static double[][] subtractMatrices(double[][] A, double[][] B) {
        int rows = A.length;
        int cols = A[0].length;

        // Проверка за еднакъв размер на матриците
        if (rows != B.length || cols != B[0].length) {
            throw new IllegalArgumentException("Матриците трябва да имат еднакъв размер!");
        }

        // Инициализиране на резултантната матрица
        double[][] C = new double[rows][cols];

        // Изваждане на съответните елементи
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }

        return C;
    }
    //Принтиране на матрица
    public static void printMatrix(double[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Целта на този метод е да провери дали размерностите на двете матрици са еднакви
    public static boolean validateMatrixDimensionsForMultiplication(double[][] matrix1, double[][] matrix2) {
        int columns1 = matrix1[0].length;
        int rows2 = matrix2.length;

        return columns1 == rows2;
    }

    // Умножаване на двете матрици
    public static double[][] multiplyMatrices(double[][] matrix1, double[][] matrix2) {
        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int columns2 = matrix2[0].length;

        if (columns1 != rows2) {
            return null;
        }

        double[][] result = new double[rows1][columns2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                for (int k = 0; k < columns1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }
    //Извеждане на резултата от умножението на двете матрици
    public static void performMatrixMultiplication(double[][] matrix1, double[][] matrix2) {
        if (validateMatrixDimensionsForMultiplication(matrix1, matrix2)) {
            double[][] product = multiplyMatrices(matrix1, matrix2);

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

    //Намиране на детерминантата на матрицата
    public static double findDeterminant(double[][] matrix) {
        int n = matrix.length;

        if (n == 1) {
            return matrix[0][0];
        } else if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            int determinant = 0;

            for (int i = 0; i < n; i++) {
                double[][] subMatrix = new double[n - 1][n - 1];
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

    //Извеждане на детерминантата на матрицата
    public static void printDeterminant(double determinant) {
        System.out.println("Детерминантата на матрицата е равна на: " + determinant);
    }

    //Намиране на транспонирана матрица
    public static double[][] calculateTranspose(double[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        double[][] transposeMatrix = new double[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }

        return transposeMatrix;
    }
    //Принтиране на транспонираната матрица
    public static void printTransposeMatrix(double[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }

    // Намиране на минора на матрицата за Adjugate метода.
    public static double calculateMinor(double[][] matrix, int row, int column) {
        int n = matrix.length;
        double[][] subMatrix = new double[n - 1][n - 1];

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
    //Изчисляване на обратната матрица чрез метода на Adjugate
    public static double[][] calculateAdjugate(double[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        double[][] adjugateMatrix = new double[rows][columns];

        double[][] transposeMatrix = calculateTranspose(matrix);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int sign = (int) Math.pow(-1, i + j);
                double minor = calculateMinor(transposeMatrix, i, j);
                adjugateMatrix[i][j] = sign * minor;
            }
        }

        return adjugateMatrix;
    }

    //Принтиране на Adjugate матрицата
    public static void printAdjugateMatrix(double[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Тук трябваше да деля Adjugate метода на детерминантата и да получа обратната матрица точно. Псоле трябваше да я извеждам ама...
    public static double[][] divideByDeterminant(double[][] adjugateMatrix, double determinant) {
        int rows = adjugateMatrix.length;
        int columns = adjugateMatrix[0].length;

        double[][] result = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = adjugateMatrix[i][j] / determinant;
            }
        }

        return result;
    }


    public static void printInverseMatrix(double[][] matrix) {
        double determinant = findDeterminant(matrix);
        if (determinant == 0) {
            System.out.println("Матрицата няма обратна. Детерминантата е 0.");
        } else {
            double[][] adjugateMatrix = calculateAdjugate(matrix);
            double[][] inverseMatrix = divideByDeterminant(adjugateMatrix, determinant);

            System.out.println("Обратната матрица е:");
            printMatrix(inverseMatrix);
        }
    }


    public static void convertToUnitMatrix(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Проверка дали матрицата е квадратна
        if (rows != cols) {
            throw new IllegalArgumentException("Матрицата трябва да бъде квадратна!");
        }

        // Обхождане на елементите на матрицата
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == j) {
                    matrix[i][j] = 1; // Задаване на главния диагонал на 1
                } else {
                    matrix[i][j] = 0; // Задаване на останалите елементи на 0
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Въведете редовете на първата матрица: ");
        int rows1 = scanner.nextInt();
        System.out.print("Въведете колоните на първата матрица: ");
        int columns1 = scanner.nextInt();

        double[][] matrix1 = inputMatrix(rows1, columns1);

        System.out.print("Въведете редовете на втората матрица: ");
        int rows2 = scanner.nextInt();
        System.out.print("Въведете колоните на втората матрица: ");
        int columns2 = scanner.nextInt();

        double[][] matrix2 = inputMatrix(rows2, columns2);

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
                    double[][] result = subtractMatrices(matrix1, matrix2);
                    printMatrix(result);
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
                    try {
                        System.out.println("Транспонирана матрица 1:");
                        double[][] transposeMatrix = calculateTranspose(matrix1);
                        printTransposeMatrix(transposeMatrix);

                        System.out.println("Обратна матрица 1:");
                        double[][] adjugateMatrix = calculateAdjugate(matrix1);
                        printAdjugateMatrix(adjugateMatrix);
                        printInverseMatrix(matrix1);

                        System.out.println("Транспонирана матрица 2:");
                        double[][] transposeMatrix2 = calculateTranspose(matrix2);
                        printTransposeMatrix(transposeMatrix2);

                        System.out.println("Обратна матрица 2:");
                        double[][] adjugateMatrix2 = calculateAdjugate(matrix2);
                        printAdjugateMatrix(adjugateMatrix2);

                        printInverseMatrix(matrix2);
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        System.out.println("Матрицата преди преобразуването: ");
                        printMatrix(matrix1);
                        convertToUnitMatrix(matrix1);
                        System.out.println("Матрицата след преобразуването: ");
                        printMatrix(matrix1);

                        System.out.println("Матрицата преди преобразуването: ");
                        printMatrix(matrix2);
                        convertToUnitMatrix(matrix2);
                        System.out.println("Матрицата след преобразуването: ");
                        printMatrix(matrix2);
                    }catch (IllegalArgumentException e){
                        System.out.println("Грешка при преобразуване: "+e.getMessage());
                    }
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
