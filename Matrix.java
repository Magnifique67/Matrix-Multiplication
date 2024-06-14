import java.util.*;

public class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, p;

        // Entering number of rows and columns for matrix A
        System.out.print("Enter the number of rows and columns for matrix A: ");
        n = validateInput(sc);
        m = validateInput(sc);
        System.out.println("Matrix A: " + n + "," + m);
        int[][] A = getMatrix(sc, n, m);

        // Entering number of rows and columns for matrix B
        System.out.print("Enter the number of rows and columns for matrix B: ");
        m = validateInput(sc);
        p = validateInput(sc);
        // Checking if the number of columns in A matches the number of rows in B
        if (A[0].length != m) {
            System.out.println("The number of columns in matrix A does not match the number of rows in matrix B.");
            return;
        }
        System.out.println("Matrix B: " + m + "," + p);
        int[][] B = getMatrix(sc, m, p);

        // Multiplication of matrix A and matrix B
        int[][] C = matrixMultiplication(A, B);

        // Displaying result
        System.out.println("\nMatrix C:");
        displayMatrix(C);

        sc.close();
    }

    public static int validateInput(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("That's not a valid number!");
            sc.next();
        }
        return sc.nextInt();
    }

    public static int[][] getMatrix(Scanner sc, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = validateInput(sc);
            }
        }
        return matrix;
    }

    public static int[][] matrixMultiplication(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                C[i][j] = 0;
                for (int k = 0; k < A[0].length; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }

            }

        }
        return C;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("|  ");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println("|");
        }
    }

}