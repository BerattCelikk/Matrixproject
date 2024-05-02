import java.util.Random;
import java.util.Scanner;

public class JavaProject {

    public static void main (String[] args) {

        String control = "Yes";
        
        while(control.equals("Yes")) {

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the length of 2 matrixes: ");
        int n = input.nextInt();
        int transposeMatrix1 [][] = new int[n][n];
        int transposeMatrix2 [][] = new int[n][n];

        operations c = new operations();

        Random r=new Random();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                transposeMatrix1[i][j]=r.nextInt(10);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                transposeMatrix2[i][j]=r.nextInt(10);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf("%2d",transposeMatrix1[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf("%2d",transposeMatrix2[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        c.sum(transposeMatrix1, transposeMatrix2);

        System.out.println();

        System.out.println(c.sub(transposeMatrix1, transposeMatrix2 ));

        System.out.println();

        System.out.println(c.mult(transposeMatrix1, transposeMatrix2));

        System.out.println("Do you want to continue(Yes/No): ");
        control = input.next();
      }

    }
  }

class operations {
    void sum(int[][] transposeMatrix1, int[][] transposeMatrix2) {

        int length = transposeMatrix1.length;
        int sum[][] = new int[length][length];

        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                sum[i][j] = transposeMatrix1[i][j] + transposeMatrix2[i][j];
            }
        }
        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                System.out.printf("%4d",sum[i][j]);
        }
        System.out.println();
    }
}

    int sub(int[][] transposeMatrix1, int[][] transposeMatrix2) {
        int length = transposeMatrix1.length;
        int sub[][] = new int[length][length];

        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                sub[i][j] = transposeMatrix1[i][j] - transposeMatrix2[i][j];
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
    static int mult(int[][] transposeMatrix1, int[][] transposeMatrix2) {
        int length = transposeMatrix1.length;
        int mult[][] = new int[length][length];
        
        for (int i=0; i <length; i++) {
            for (int j=0; j <length; j++) {
                for (int k=0; k<length; k++) {
                    mult[i][j] += transposeMatrix1[i][k] * transposeMatrix2[k][j];
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

}

