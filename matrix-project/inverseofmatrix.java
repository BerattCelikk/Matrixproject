public class MatrixOperations {
    
    // Matrisin tersini bulan fonksiyon
    public static double[][] findInverse(double[][] matrix) {
        int n = matrix.length;
        
        // Başlangıçta birim matris oluştur
        double[][] identity = new double[n][n];
        for (int i = 0; i < n; i++) {
            identity[i][i] = 1;
        }
        
        // Matrisin kopyasını oluştur
        double[][] temp = new double[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, temp[i], 0, n);
        }
        
        // Gauss-Jordan eleme yöntemiyle matrisin tersini bul
        for (int i = 0; i < n; i++) {
            // Birinci adım: Ana diyagonali 1'e getir
            double divisor = temp[i][i];
            for (int j = 0; j < n; j++) {
                temp[i][j] /= divisor;
                identity[i][j] /= divisor;
            }
            // İkinci adım: Diğer satırlardan bu sütunu 0 yap
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = temp[k][i];
                    for (int j = 0; j < n; j++) {
                        temp[k][j] -= factor * temp[i][j];
                        identity[k][j] -= factor * identity[i][j];
                    }
                }
            }
        }
        
        return identity;
    }
    
    // Matrisi ekrana yazdıran yardımcı fonksiyon
    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.printf("%8.2f", element);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the size of the square matrix:");
        int size = scanner.nextInt();
        
        System.out.println("Enter the elements of the matrix:");
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        
        System.out.println("Original Matrix:");
        printMatrix(matrix);
        
        // Matrisin tersini bul
        double[][] inverse = findInverse(matrix);
        
        System.out.println("Inverse Matrix:");
        printMatrix(inverse);
        
        scanner.close();
    }
}
