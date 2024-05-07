//DIAGONAL AND TRACE OF MATRIX  (IT MUST BE SQUARE MATRİX.)
import java.util.Scanner;
import java.util.Random;
public class matrix_ozellikleri {
    public static void main(String[] args) {
        long seed=System.currentTimeMillis();   //ZAMANI MİLİSANİYE CİNSİNDEN AYARLAR.BU ŞEKİLDE HEP FARKLI DEĞERLER ATAR RANDOMA.
        Scanner get=new Scanner(System.in);     
        Random random=new Random(seed);
        
        System.out.println("Please enter the length of 2 matrixes: ");
        int number=get.nextInt();
        int matrix1[][]=new int[number][number];
        int matrix2[][]=new int[number][number];
        for(int i=0;i<number;i++){
            for(int j=0;j<number;j++){
                matrix1[i][j]=random.nextInt(10);  //0 DAN 100 E KADAR.
                matrix2[i][j]=random.nextInt(10);
            }
        }
        System.out.println("1.MATRIX :");
        for(int i=0;i<number;i++){
            for(int j=0;j<number;j++){
                System.out.printf("%3d",matrix1[i][j]);
            }
            System.out.println();
        }
        System.out.println("2.MATRIX :");
        for(int i=0;i<number;i++){
            for(int j=0;j<number;j++){
                System.out.printf("%3d",matrix2[i][j]);
            }
            System.out.println();
        }
        int diagonal1=0;
        int diagonal2=0;
        for(int i=0;i<number;i++){
            for(int j=0;j<number;j++){
                if(i==j){
                    diagonal1+=matrix1[i][j];
                    diagonal2+=matrix2[i][j];
                }
            }
        }
        
        System.out.printf("1.MATRIX'S DIAGONAL = %d",diagonal1);
        System.out.println();
        System.out.printf("2.MATRIX'S DIAGONAL = %d",diagonal2);
        
    //TRACE KISMI DEVAM EDECEK
        
        
        get.close();      
    }
    
}