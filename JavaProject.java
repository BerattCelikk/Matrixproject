import java.util.Scanner;

public class JavaProject {

    public static void main (String[] args) {

        String control = "Yes";
        
        while(control.equals("Yes")) {

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the length of 2 matrixes: ");
        int n = input.nextInt();
        int Matrix1 [][] = new int[n][n];
        int Matrix2 [][] = new int[n][n];

        operations c = new operations();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf("Enter a number to (%d,%d). first matrix element : ",i,j);
                Matrix1[i][j]=input.nextInt();
            }
        }
        System.out.println("FIRST MATRIX:");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf("%3d",Matrix1[i][j]);
            }
            System.out.println();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf("Enter a number to (%d,%d). second matrix element : ",i,j);
                Matrix2[i][j]=input.nextInt();
            }
        }
        System.out.println("SECOND MATRIX : ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf("%3d",Matrix2[i][j]);
            }
            System.out.println();
        }


        System.out.println("What do you want to calculate with this matrix? :");
        System.out.println("sum => + / subtraction => - / multiplication => * / Diagonal and Trace => d /Symmetric or asymmetric => s /Orthogonal matrix or not => o ");

        char operation = input.next().charAt(0);

        switch(operation) {
            case '+':  c.sum(Matrix1, Matrix2); break;
            case '-':  System.out.println(c.sub(Matrix1, Matrix2 )); break;
            case '*':  System.out.println(c.mult(Matrix1, Matrix2)); break;
            case 's':   
            System.out.println("TRANSPOSE OF MATRIX : ");
            int transposematrix1[][]=new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    transposematrix1[j][i] = Matrix1[i][j];
                    System.out.printf("%3d", Matrix1[j][i]);
                }
                System.out.println();
            }
            boolean symmetric = true;
            boolean asymmetric = true;
            symmetric = c.checkSymmetryWithRecursive(Matrix1, transposematrix1, n, 0 , 0, symmetric, asymmetric);
            if (asymmetric) {
                System.out.println("Your matrix is an asymmetric matrix.");
            } else if (symmetric) {
                System.out.println("Your matrix is a symmetric matrix.");
            } else {
                System.out.println("Your matrix is neither symmetric nor asymmetric matrix.");
            } break;
            case 'd':
            case 'o':
            default: System.out.println("Invalid operation!");
        }



        System.out.println("Do you want to continue(Yes/No): ");
        control = input.next();
      }

    }
  }

class operations {
    void sum(int[][] Matrix1, int[][] Matrix2) {

        int length = Matrix1.length;
        int sum[][] = new int[length][length];

        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                sum[i][j] = Matrix1[i][j] + Matrix2[i][j];
            }
        }
        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                System.out.printf("%4d",sum[i][j]);
        }
        System.out.println();
    }
}

    int sub(int[][] Matrix1, int[][] Matrix2) {
        int length = Matrix1.length;
        int sub[][] = new int[length][length];

        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                sub[i][j] = Matrix1[i][j] - Matrix2[i][j];
            }
        }
        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                System.out.printf("%4d",sub[i][j]);
        }
        System.out.println();
    }
        return 0;
}
    static int mult(int[][] Matrix1, int[][] Matrix2) {
        int length = Matrix1.length;
        int mult[][] = new int[length][length];
        
        for (int i=0; i <length; i++) {
            for (int j=0; j <length; j++) {
                for (int k=0; k<length; k++) {
                    mult[i][j] += Matrix1[i][k] * Matrix2[k][j];
                }
            }
        }
        for (int i=0; i <length; i++) {
            for (int j=0; j <length; j++) {
                System.out.printf("%8d",mult[i][j]);
            }   
            System.out.println(); 
    }
        return 0;
}
    boolean checkSymmetryWithRecursive(int[][] Matrix1, int[][] transpose, int n, int i, int j, boolean symmetric, boolean asymmetric) {
        if (i == n) {
        return symmetric;
        }
        if (j == n) {
        return checkSymmetryWithRecursive(Matrix1, transpose, n, i + 1, 0, symmetric, asymmetric);
        }
        if (transpose[i][j] != Matrix1 [i][j]) {
        symmetric = false;
        }
        if (transpose[i][j] != -Matrix1[i][j]) {
        asymmetric = false;
        }
        return checkSymmetryWithRecursive(Matrix1, transpose, n, i, j + 1, symmetric, asymmetric);
}

}
