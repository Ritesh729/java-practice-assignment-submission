import java.util.Random;

public class MatrixOperations {

    // Create a random matrix
    public static double[][] createRandomMatrix(int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10); // 0-9
            }
        }
        return matrix;
    }

    // Display matrix
    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.printf("%8.2f", val);
            }
            System.out.println();
        }
    }

    // Add matrices
    public static double[][] add(double[][] A, double[][] B) {
        int r = A.length, c = A[0].length;
        double[][] result = new double[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                result[i][j] = A[i][j] + B[i][j];

        return result;
    }

    // Subtract matrices
    public static double[][] subtract(double[][] A, double[][] B) {
        int r = A.length, c = A[0].length;
        double[][] result = new double[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                result[i][j] = A[i][j] - B[i][j];

        return result;
    }

    // Multiply matrices
    public static double[][] multiply(double[][] A, double[][] B) {
        int r1 = A.length, c1 = A[0].length, c2 = B[0].length;
        double[][] result = new double[r1][c2];

        for (int i = 0; i < r1; i++)
            for (int j = 0; j < c2; j++)
                for (int k = 0; k < c1; k++)
                    result[i][j] += A[i][k] * B[k][j];

        return result;
    }

    // Transpose of a matrix
    public static double[][] transpose(double[][] A) {
        int r = A.length, c = A[0].length;
        double[][] result = new double[c][r];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                result[j][i] = A[i][j];

        return result;
    }

    // Determinant of 2x2
    public static double determinant2x2(double[][] m) {
        return m[0][0]*m[1][1] - m[0][1]*m[1][0];
    }

    // Determinant of 3x3
    public static double determinant3x3(double[][] m) {
        return m[0][0]*(m[1][1]*m[2][2] - m[1][2]*m[2][1])
             - m[0][1]*(m[1][0]*m[2][2] - m[1][2]*m[2][0])
             + m[0][2]*(m[1][0]*m[2][1] - m[1][1]*m[2][0]);
    }

    // Inverse of 2x2 matrix
    public static double[][] inverse2x2(double[][] m) {
        double det = determinant2x2(m);
        if (det == 0) return null;

        double[][] inv = new double[2][2];
        inv[0][0] =  m[1][1] / det;
        inv[0][1] = -m[0][1] / det;
        inv[1][0] = -m[1][0] / det;
        inv[1][1] =  m[0][0] / det;

        return inv;
    }

    // Inverse of 3x3 matrix using adjoint method
    public static double[][] inverse3x3(double[][] m) {
        double det = determinant3x3(m);
        if (det == 0) return null;

        double[][] inv = new double[3][3];

        inv[0][0] =  (m[1][1]*m[2][2] - m[1][2]*m[2][1]) / det;
        inv[0][1] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]) / det;
        inv[0][2] =  (m[0][1]*m[1][2] - m[0][2]*m[1][1]) / det;

        inv[1][0] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]) / det;
        inv[1][1] =  (m[0][0]*m[2][2] - m[0][2]*m[2][0]) / det;
        inv[1][2] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]) / det;

        inv[2][0] =  (m[1][0]*m[2][1] - m[1][1]*m[2][0]) / det;
        inv[2][1] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]) / det;
        inv[2][2] =  (m[0][0]*m[1][1] - m[0][1]*m[1][0]) / det;

        return inv;
    }
     public static void main(String[] args) {
        System.out.println("Matrix A:");
        double[][] A = MatrixOperations.createRandomMatrix(3, 3);
        MatrixOperations.displayMatrix(A);

        System.out.println("\nMatrix B:");
        double[][] B = MatrixOperations.createRandomMatrix(3, 3);
        MatrixOperations.displayMatrix(B);

        System.out.println("\nA + B:");
        MatrixOperations.displayMatrix(MatrixOperations.add(A, B));

        System.out.println("\nA - B:");
        MatrixOperations.displayMatrix(MatrixOperations.subtract(A, B));

        System.out.println("\nA * B:");
        MatrixOperations.displayMatrix(MatrixOperations.multiply(A, B));

        System.out.println("\nTranspose of A:");
        MatrixOperations.displayMatrix(MatrixOperations.transpose(A));

        // Determinant & Inverse for 2x2
        double[][] C = MatrixOperations.createRandomMatrix(2, 2);
        System.out.println("\n2x2 Matrix C:");
        MatrixOperations.displayMatrix(C);
        System.out.println("Determinant of C: " + MatrixOperations.determinant2x2(C));

        double[][] invC = MatrixOperations.inverse2x2(C);
        if (invC != null) {
            System.out.println("Inverse of C:");
            MatrixOperations.displayMatrix(invC);
        } else {
            System.out.println("Matrix C has no inverse (determinant = 0).");
        }

        // Determinant & Inverse for 3x3
        System.out.println("\n3x3 Matrix A:");
        MatrixOperations.displayMatrix(A);
        double detA = MatrixOperations.determinant3x3(A);
        System.out.println("Determinant of A: " + detA);

        double[][] invA = MatrixOperations.inverse3x3(A);
        if (invA != null) {
            System.out.println("Inverse of A:");
            MatrixOperations.displayMatrix(invA);
        } else {
            System.out.println("Matrix A has no inverse (determinant = 0).");
        }
    }
}
