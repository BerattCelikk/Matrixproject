import java.util.Scanner;

public class MatrixCalculator {

    public static void main (String[] args) {

        String control = "Yes";
        Scanner input = new Scanner(System.in);
        
        while(control.equals("Yes")) {

        System.out.println("Please enter the length of 2 matrixes: ");
        int n = input.nextInt();
        int Matrix1 [][] = new int[n][n];
        int Matrix2 [][] = new int[n][n];

        Operations c = new Operations();

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

        System.out.println("What do you want to do with this matrix or matrixes? :");
        System.out.println("Sum => + / Subtraction => - / Multiplication => * / Diagonal and Trace => d / Symmetric or Asymmetric => s / Orthogonal matrix or not => o / Periodic matrix or not => p / Idempotent matrix or not => i / Nilpotent matrix or not => n / Involutive matrix or not => v ");
        
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
                      
            case 'p': System.out.println("Please enter which matrix you want to use?(1/2): ");
                  int choice5 = input.nextInt();
                  if(choice5 == 1) {
                  c.isPeriodic(Matrix1);;
                  } 
                  else if(choice5 == 2) {
                  c.isPeriodic(Matrix2);
                  } break;
            
            case 's': System.out.println("Please enter which matrix you want to use?(1/2): ");
                      int choice6 = input.nextInt();
                      if(choice6 == 1) {
                        System.out.println(c.symmetricORasymmetric(Matrix1));
                      }
                      else if(choice6 == 2) {
                        System.out.println(c.symmetricORasymmetric(Matrix2));
                      } break;
                      
            case 'o': System.out.println("Please enter which matrix you want to use?(1/2): ");
                      int choice7 = input.nextInt();
                      if(choice7 == 1) {
                        System.out.println(c.orthogonalORnot(Matrix1));
                      }
                      else if(choice7 == 2) {
                        System.out.println(c.orthogonalORnot(Matrix2));
                      } break;
                      
            default: System.out.println("Invalid operation!");
        }

        System.out.println("Do you want to continue(Yes/No): ");
        control = input.next();
      }

    }
  }

class Operations {
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

int symmetricORasymmetric(int[][] Matrix) {
    int issymmetric=1;
    int isasymmetric=1;
    int length = Matrix.length;
    
    System.out.println("TRANSPOSE OF MATRIX : ");
    int transposematrix[][]=new int[length][length];
    
    for(int i = 0; i < length; i++) {
        for(int j = 0; j < length; j++) {
        transposematrix[j][i]=Matrix[i][j];
        System.out.printf("%3d", Matrix[j][i]);
        }
    System.out.println();
    }
                        
    for(int i = 0; i < length; i++) {
        for(int j = 0; j < length; j++) {
            if(transposematrix[i][j]!=Matrix[i][j]){
            issymmetric=0;
            break;
            }
        }
        if(issymmetric==0){
        break;
        }
    }
                            
    for(int i = 0; i < length; i++) {
        for(int j = 0; j < length; j++) {
            if((transposematrix[i][j])!=(-Matrix[i][j])){
            isasymmetric=0;
            break;
            }
        }
        if(isasymmetric==0){
        break;
        }
    }
    if(isasymmetric==1){
    System.out.println("Your matrix is an asymmetric matrix .");
    }else if(issymmetric==1){
    System.out.println("Your matrix is a symmetric matrix .");
    }
    else{
    System.out.println("Your matrix is neither symmetric nor asymmetric matrix .");
    }
    
    return 0;
}

static int orthogonalORnot(int[][] Matrix) {
    int length = Matrix.length;
    int tempMatrix[][] = new int[length][length];
    int unitMatrix[][] = new int[length][length];
    
    System.out.println("TRANSPOSE OF MATRIX: ");
    int transposeMatrix[][] = new int[length][length];
    
    for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
        transposeMatrix[j][i] = Matrix[i][j];
        System.out.printf("%3d", Matrix[j][i]);
        }
    System.out.println();
    }
            
    for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
            tempMatrix[i][j] = Matrix[i][j] * transposeMatrix[i][j];
            if (i == j) {
                unitMatrix[i][j] = tempMatrix[i][j];
            }
        }
    }
                
    System.out.println("Transpose of Matrix * Matrix =");
    for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
            System.out.printf("%3d", unitMatrix[i][j]);
        }
    System.out.println();
    }
                
    boolean isUnitMatrix = true;
    for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
            if ((i == j && unitMatrix[i][j] != 1) || (i != j && unitMatrix[i][j] != 0)) {
            isUnitMatrix = false;
            break;
            }
        }
        if (!isUnitMatrix) {
            break;
        }
    }
    if (isUnitMatrix) {
        System.out.println("Your matrix is an orthogonal matrix.");
    } 
    else {
        System.out.println("Your matrix is not an orthogonal matrix.");
    }
    
    return 0;
}

void isPeriodic(int[][] Matrix) {
    System.out.println("enter the period of matrix :");
    Scanner get = new Scanner(System.in);
    int period=get.nextInt();
    int length = Matrix.length;
    int periodic_matrix[][]=new int[length][length];
    System.out.println("PERIODIC  MATRIX : ");
    for(int p=1;p<=period+1;p++){
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                int sum=0;
                for(int k=0;k<length;k++){
                    
                    sum+=Matrix[i][k]*Matrix[k][j];
                }
                periodic_matrix[i][j]+= sum;
            }
        }    
    }
    
    for(int i=0;i<length;i++){
        for(int j=0;j<length;j++){
            System.out.printf("%3d",periodic_matrix[i][j]);
        }
        System.out.println();
    }
    boolean isperiodic=true;
    for(int i=0;i<length;i++){
        for(int j=0;j<length;j++){
            if(periodic_matrix[i][j]!=Matrix[i][j]){
                isperiodic=false;
                break;
            }
        }
        if(!(isperiodic)){
            break;
        }
    }
    if(isperiodic){
        System.out.println("Your matrix is an periodic matrix");
    }else{
        System.out.println("Your matrix is not an periodic matrix");
    }
}
        
}
