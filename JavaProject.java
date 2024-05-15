import java.util.Scanner;

public class MatrixCalculator {

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
        System.out.println("Sum => + / Subtraction => - / Multiplication => * / Diagonal and Trace => d / Symmetric or Asymmetric => s / Orthogonal matrix or not => o ");
        System.out.println("Periodic matrix or not => p / Idempotent matrix or not => i / Nilpotent matrix or not => n / Involutive matrix or not => v ");

        char operation = input.next().charAt(0);

        switch(operation) {
            case '+':  c.sum(Matrix1, Matrix2); break;
            case '-':  System.out.println(c.sub(Matrix1, Matrix2 )); break;
            case '*':  System.out.println(c.mult(Matrix1, Matrix2)); break;
            case 'd':  System.out.println("Please enter which matrix you want to use?(1/2): "); 
                       int choice1 = input.nextInt();
                       if(choice1 == 1) {
                        c.diagonalANDtrace(Matrix1);
                       }
                       else if(choice1 == 2) {
                        c.diagonalANDtrace(Matrix2);
                       } break;
            case 'i': System.out.println("Please enter which matrix you want to use?(1/2): ");
                      int choice2 = input.nextInt();
                      if(choice2 == 1) {
                        System.out.println(c.isIdempotent(Matrix1));
                      }
                      else if(choice2 == 2) {
                        System.out.println(c.isIdempotent(Matrix2));
                      } break;
            case 'n': System.out.println("Please enter which matrix you want to use?(1/2): ");
                      int choice3 = input.nextInt();
                      if(choice3 == 1) {
                      System.out.println(c.isNilpotent(Matrix2));
                      }
                      else if(choice3 == 2) {
                      System.out.println(c.isNilpotent(Matrix2));
                      } break;
            case 'v': System.out.println("Please enter which matrix you want to use?(1/2): ");
                      int choice4 = input.nextInt();
                      if(choice4 == 1) {
                      c.isInvolitive(Matrix1);;
                      }
                      else if(choice4 == 2) {
                      c.isInvolitive(Matrix2);
                      } break;
            case 'p': break;
            case 's': 
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

void diagonalANDtrace(int[][] Matrix) {
    int length = Matrix.length;
    int diag[]=new int[length];
    int trace = 0;
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                if(i==j){
                    diag[i]=Matrix[i][j];
                    trace+=Matrix[i][j];
                }
            }
        }
        System.out.println("DIAGONAL OF MATRIX :");
        for(int i=0;i<length;i++){
            System.out.printf("%3d",diag[i]);    
        }
        System.out.println();
        System.out.println("TRACE OF MATRIX = "+trace);
}

int isIdempotent(int[][] Matrix) {
    int length = Matrix.length;
    int idempotent_matrix[][]=new int[length][length];
    System.out.println("IDEMPOTENT MATRIX : ");
    for(int i=0;i<length;i++){
        for(int j=0;j<length;j++){
            int sum=0;
            for(int k=0;k<length;k++){
                sum+=Matrix[i][k]*Matrix[k][j];
            }
            idempotent_matrix[i][j]= sum;
        }
    }
    for(int i=0;i<length;i++){
        for(int j=0;j<length;j++){
            System.out.printf("%3d",idempotent_matrix[i][j]);
        }
        System.out.println();
    }
    boolean isidempotent=true;
    for(int i=0;i<length;i++){
        for(int j=0;j<length;j++){
            if(idempotent_matrix[i][j]!=Matrix[i][j]){
                isidempotent=false;
                break;
            }
        }
        if(!(isidempotent)){
            break;
        }
    }
    if(isidempotent){
        System.out.println("Your matrix is an idempotent matrix");
    }else{
        System.out.println("Your matrix is not an idempotent matrix");
    }
    return 0;
}

static int isNilpotent(int[][] Matrix) {
    System.out.println("enter the power of matrix :");
    Scanner get = new Scanner(System.in);
    int length = Matrix.length;
    int power=get.nextInt();
    int nilpotent_matrix[][]=new int[length][length];
    System.out.println("NILPOTENT  MATRIX : ");
    for(int p=1;p<=power;p++){
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                int sum=0;
                for(int k=0;k<length;k++){
                    
                    sum+=Matrix[i][k]*Matrix[k][j];
                }
                nilpotent_matrix[i][j]+= sum;
            }
        }    
    }
    
    for(int i=0;i<length;i++){
        for(int j=0;j<length;j++){
            System.out.printf("%3d",nilpotent_matrix[i][j]);
        }
        System.out.println();
    }
    boolean isnilpotent=true;
    for(int i=0;i<length;i++){
        for(int j=0;j<length;j++){
            if(nilpotent_matrix[i][j]!=0){
                isnilpotent=false;
                break;
            }
        }
        if(!(isnilpotent)){
            break;
        }
    }
    if(isnilpotent){
        System.out.println("Your matrix is a nilpotent matrix");
    }else{
        System.out.println("Your matrix is not a nilpotent matrix");
    }
    return 0;
}

void isInvolitive(int[][] Matrix) {
    int length = Matrix.length;
    int involutive_matrix[][]=new int[length][length];
    System.out.println("INVOLUTIVE MATRIX : ");
    for(int i=0;i<length;i++){
        for(int j=0;j<length;j++){
            int sum=0;
            for(int k=0;k<length;k++){
                sum+=Matrix[i][k]*Matrix[k][j];
            }
            involutive_matrix[i][j]= sum;
        }
    }
    for(int i=0;i<length;i++){
        for(int j=0;j<length;j++){
            System.out.printf("%3d",involutive_matrix[i][j]);
        }
        System.out.println();
    }
    int unitmatrix[][]=new int[100][100];
    for(int i=0;i<length;i++){
        for(int j=0;j<length;j++){
            if(i==j){
                unitmatrix[i][j]=1;
            }
        }
    }

    boolean isinvolutive=true;
    for(int i=0;i<length;i++){
        for(int j=0;j<length;j++){
            if(involutive_matrix[i][j]!=unitmatrix[i][j]){
                isinvolutive=false;
                break;
            }
        }
        if(!(isinvolutive)){
            break;
        }
    }
    if(isinvolutive){
        System.out.println("Your matrix is an involutive matrix");
    }else{
        System.out.println("Your matrix is not an involutive matrix");
    }
}
        
}
