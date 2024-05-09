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
        System.out.println("sum => + / subtraction => - / multiplication => * / Diagonal and Trace => d / Invertible of Matrix => i :");
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
        }else if((operation == 'd')||(operation == 'i')){
            if(row1==col1){
                int diag[]=new int[row1];
                int trace = 0;
                switch(operation){
                    case ('d'):
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
                    case ('i'):
                        int determinant=1;
                        int a=1,b=1;
                        for(int i=0;i<row1;i++){
                            for(int j=0;j<col1;j++){
                                if(i==j){
                                    a*=matrix1[i][j];
                                }
                            }
                        }
                        for(int i=row1;i>0;i--){
                            for(int j=col1;j>0;j--){
                                if(i==j){
                                    b*=matrix1[i][j];
                                }
                            }
                        }
                        determinant=a-b;
                }    
            }else{
                System.out.println("MATRIX MUST BE SQUARE MATRIX .");
            }
            
            
        }
        
    }
}






























