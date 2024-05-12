import java.util.Scanner;
public class MatrixEntrance{
    public static void main (String[] args) {
        Scanner get=new Scanner(System.in);
        System.out.println("Enter first matrix's length of rows : ");
        int row1=get.nextInt();
        System.out.println("Enter first matrix's length of columns : ");
        int col1=get.nextInt();
        int matrix1[][]=new int[row1][col1];
        char operation;
        for(int i=0;i<row1;i++){
            for(int j=0;j<col1;j++){
                System.out.printf("enter a number to (%d,%d). matrix element : ",i,j);
                matrix1[i][j]=get.nextInt();
            }
        }
        for(int i=0;i<row1;i++){
            for(int j=0;j<col1;j++){
                System.out.printf("%3d",matrix1[i][j]);
            }
            System.out.println();
        }
        System.out.println("What do you want to calculate with this matrix ? :");
        System.out.println("sum => + / subtraction => - / multiplication => * / Diagonal and Trace => d /Symmetric or asymmetric => s /Orthogonal matrix or not => o ");
        System.out.println("Periodic matrix or not => p /Idempotent matrix or not => i /Nilpotent matrix or not => n / Involutive matrix or not => v ");
        operation=get.next().charAt(0);
        if((operation=='+') || (operation=='-') || (operation=='*')){
            System.out.println("Enter second matrix's length of rows : ");
            int row2=get.nextInt();
            System.out.println("Enter second matrix's length of columns : ");
            int col2=get.nextInt();
            int matrix2[][]=new int[row2][col2];
            for(int i=0;i<row2;i++){
                for(int j=0;j<col2;j++){
                    System.out.printf("enter a number to (%d,%d). matrix element : ",i,j);
                    matrix2[i][j]=get.nextInt();
                }
            }
            System.out.println("FIRST MATRIX:");
            for(int i=0;i<row1;i++){
                for(int j=0;j<col1;j++){
                    System.out.printf("%3d",matrix1[i][j]);
                }
                System.out.println();
            }
            System.out.println("SECOND MATRIX : ");
            for(int i=0;i<row2;i++){
                for(int j=0;j<col2;j++){
                    System.out.printf("%3d",matrix2[i][j]);
                }
                System.out.println();
            }
            switch(operation){
                case ('+'):
                    
                    if((row1 == row2)&&(col1==col2)){
                        int sum[][]=new int[row1][col1];
                        System.out.println("SUM OF MATRIX : ");
                        for(int i=0;i<row1;i++){
                            for(int j=0;j<col1;j++){
                                sum[i][j]=matrix1[i][j]+matrix2[i][j];
                            }
                        }
                        for(int i=0;i<row1;i++){
                            for(int j=0;j<col1;j++){
                                System.out.printf("%3d",sum[i][j]);
                            }
                            System.out.println();
                        }
                        break;
                    }else{
                        System.out.println("These matrixs' columns and rows aren't equal that's why they can't be sum.");
                        break;
                    }
                case ('-'):
                    if((row1 == row2)&&(col1==col2)){
                        int subtraction[][]=new int[row1][col1];
                        System.out.println("SUBTRACTION OF MATRIX : ");
                        for(int i=0;i<row1;i++){
                            for(int j=0;j<col1;j++){
                                subtraction[i][j]=matrix1[i][j]-matrix2[i][j];
                            }
                        }
                        for(int i=0;i<row1;i++){
                            for(int j=0;j<col1;j++){
                                System.out.printf("%3d",subtraction[i][j]);
                            }
                            System.out.println();
                        }
                        break;
                    }else{
                        System.out.println("These matrixs' columns and rows aren't equal that's why they can't be subtraction.");
                        break;
                    }
                case ('*'):
                    if(col1==row2){
                        int multiplication[][]=new int[row1][col2];
                        System.out.println("MULTIPLICATION OF MATRIX : ");
                        for(int i=0;i<row1;i++){
                            for(int j=0;j<col2;j++){
                                int sum=0;
                                for(int k=0;k<col1;k++){
                                    sum+=matrix1[i][k]*matrix2[k][j];
                                }
                                multiplication[i][j]= sum;
                            }
                        }
                        for(int i=0;i<row1;i++){
                            for(int j=0;j<col2;j++){
                                System.out.printf("%3d",multiplication[i][j]);
                            }
                            System.out.println();
                        }
                        
                    }else{
                        System.out.println("first matrix' column and second matrix' row aren't equal so they can't be multiplication.");
                    }
            }
        }else if((operation == 'd')||(operation == 's')||(operation=='p')||(operation=='i')||(operation=='n')||(operation=='v')){
            
                switch(operation){
                    case ('d'):
                        if(row1==col1){
                            int diag[]=new int[row1];
                            int trace = 0;
                                for(int i=0;i<row1;i++){
                                    for(int j=0;j<col1;j++){
                                        if(i==j){
                                            diag[i]=matrix1[i][j];
                                            trace+=matrix1[i][j];
                                        }
                                    }
                                }
                                System.out.println("DIAGONAL OF MATRIX :");
                                for(int i=0;i<row1;i++){
                                    System.out.printf("%3d",diag[i]);    
                                }
                                System.out.println();
                                System.out.println("TRACE OF MATRIX = "+trace);
                        }else{
                            System.out.println("MATRIX MUST BE SQUARE MATRIX .");
                        }
                        break;
                    case ('s'):
                        int issymmetric=1;
                        int isasymmetric=1;
                        if(row1==col1){
                            System.out.println("TRANSPOSE OF MATRIX : ");
                            int transposematrix1[][]=new int[100][100];
                            for(int i = 0; i < col1; i++) {
                                for(int j = 0; j < row1; j++) {
                                    transposematrix1[j][i]=matrix1[i][j];
                                    System.out.printf("%3d", matrix1[j][i]);
                                }
                                System.out.println();
                            }
                            for(int i = 0; i < row1; i++) {
                                for(int j = 0; j < col1; j++) {
                                    if(transposematrix1[i][j]!=matrix1[i][j]){
                                        issymmetric=0;
                                        break;
                                    }
                                }
                                if(issymmetric==0){
                                    break;
                                }
                            }
                            for(int i = 0; i < row1; i++) {
                                for(int j = 0; j < col1; j++) {
                                    if((transposematrix1[i][j])!=(-matrix1[i][j])){
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
                        }else{
                            System.out.println("MATRIX MUST BE SQUARE MATRIX .");
                        }
                        break;
                    case('p'):
                        System.out.println("enter the period of matrix :");
                        int period=get.nextInt();
                        int periodic_matrix[][]=new int[row1][col1];
                        System.out.println("PERIODIC  MATRIX : ");
                        for(int p=1;p<=period+1;p++){
                            for(int i=0;i<row1;i++){
                                for(int j=0;j<col1;j++){
                                    int sum=0;
                                    for(int k=0;k<col1;k++){
                                        
                                        sum+=matrix1[i][k]*matrix1[k][j];
                                    }
                                    periodic_matrix[i][j]+= sum;
                                }
                            }    
                        }
                        
                        for(int i=0;i<row1;i++){
                            for(int j=0;j<col1;j++){
                                System.out.printf("%3d",periodic_matrix[i][j]);
                            }
                            System.out.println();
                        }
                        boolean isperiodic=true;
                        for(int i=0;i<row1;i++){
                            for(int j=0;j<col1;j++){
                                if(periodic_matrix[i][j]!=matrix1[i][j]){
                                    isperiodic=false;
                                    break;
                                }
                            }
                            if(!(isperiodic)){
                                break;
                            }
                        }
                        if(isperiodic){
                            System.out.println("Your matrix is an idempotent matrix");
                        }else{
                            System.out.println("Your matrix is not an idempotent matrix");
                        }
                        break;
                    case('i'):
                        int idempotent_matrix[][]=new int[row1][col1];
                        System.out.println("IDEMPOTENT MATRIX : ");
                        for(int i=0;i<row1;i++){
                            for(int j=0;j<col1;j++){
                                int sum=0;
                                for(int k=0;k<col1;k++){
                                    sum+=matrix1[i][k]*matrix1[k][j];
                                }
                                idempotent_matrix[i][j]= sum;
                            }
                        }
                        for(int i=0;i<row1;i++){
                            for(int j=0;j<col1;j++){
                                System.out.printf("%3d",idempotent_matrix[i][j]);
                            }
                            System.out.println();
                        }
                        boolean isidempotent=true;
                        for(int i=0;i<row1;i++){
                            for(int j=0;j<col1;j++){
                                if(idempotent_matrix[i][j]!=matrix1[i][j]){
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
                        break;
                    case ('n'):
                        System.out.println("enter the power of matrix :");
                        int power=get.nextInt();
                        int nilpotent_matrix[][]=new int[row1][col1];
                        System.out.println("NILPOTENT  MATRIX : ");
                        for(int p=1;p<=power;p++){
                            for(int i=0;i<row1;i++){
                                for(int j=0;j<col1;j++){
                                    int sum=0;
                                    for(int k=0;k<col1;k++){
                                        
                                        sum+=matrix1[i][k]*matrix1[k][j];
                                    }
                                    nilpotent_matrix[i][j]+= sum;
                                }
                            }    
                        }
                        
                        for(int i=0;i<row1;i++){
                            for(int j=0;j<col1;j++){
                                System.out.printf("%3d",nilpotent_matrix[i][j]);
                            }
                            System.out.println();
                        }
                        boolean isnilpotent=true;
                        for(int i=0;i<row1;i++){
                            for(int j=0;j<col1;j++){
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
                        break;
                    case ('v'):
                        int involutive_matrix[][]=new int[row1][col1];
                        System.out.println("INVOLUTIVE MATRIX : ");
                        for(int i=0;i<row1;i++){
                            for(int j=0;j<col1;j++){
                                int sum=0;
                                for(int k=0;k<col1;k++){
                                    sum+=matrix1[i][k]*matrix1[k][j];
                                }
                                involutive_matrix[i][j]= sum;
                            }
                        }
                        for(int i=0;i<row1;i++){
                            for(int j=0;j<col1;j++){
                                System.out.printf("%3d",involutive_matrix[i][j]);
                            }
                            System.out.println();
                        }
                        int unitmatrix[][]=new int[100][100];
                        for(int i=0;i<row1;i++){
                            for(int j=0;j<col1;j++){
                                if(i==j){
                                    unitmatrix[i][j]=1;
                                }
                            }
                        }
                        
                        
                        boolean isinvolutive=true;
                        for(int i=0;i<row1;i++){
                            for(int j=0;j<col1;j++){
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
                            System.out.println("Your matrix is an idempotent matrix");
                        }else{
                            System.out.println("Your matrix is not an idempotent matrix");
                        }
                }
        }else if (operation == 'o') {
            if (row1 == col1) {
                int matrix3[][] = new int[100][100];
                int unitMatrix[][] = new int[100][100];
                System.out.println("TRANSPOSE OF MATRIX: ");
                int transposeMatrix1[][] = new int[100][100];
                for (int i = 0; i < col1; i++) {
                    for (int j = 0; j < row1; j++) {
                        transposeMatrix1[j][i] = matrix1[i][j];
                        System.out.printf("%3d", matrix1[j][i]);
                    }
                    System.out.println();
                }
                for (int i = 0; i < row1; i++) {
                    for (int j = 0; j < col1; j++) {
                        matrix3[i][j] = matrix1[i][j] * transposeMatrix1[i][j];
                        if (i == j) {
                            unitMatrix[i][j] = matrix3[i][j];
                        }
                    }
                }
                System.out.println("Transpose of Matrix * Matrix =");
                for (int i = 0; i < row1; i++) {
                    for (int j = 0; j < col1; j++) {
                        System.out.printf("%3d", unitMatrix[i][j]);
                    }
                    System.out.println();
                }
                boolean isUnitMatrix = true;
                for (int i = 0; i < row1; i++) {
                    for (int j = 0; j < col1; j++) {
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
                } else {
                    System.out.println("Your matrix is not an orthogonal matrix.");
                }
            } else {
                System.out.println("MATRIX MUST BE SQUARE MATRIX.");
            }
        }

        
    }
}






























