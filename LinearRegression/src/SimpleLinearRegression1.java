//AUTOR: Emiliano De la rosa
//Probability & Stats

public class SimpleLinearRegression1{

    public static void main(String[] args) {
        int[] X = {23, 26, 30, 34, 43, 48, 52, 57, 58};
        int[] Y = {651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518};

       int sumaX = 0;
       int sumaY = 0;
       int sumaXY = 0;
       int sumaXCuadrado = 0;
       int n =  X.length;

        for (int i = 0; i < n; i++) {
           sumaX += X[i];
           sumaY += Y[i];
           sumaXY += X[i] * Y[i];
           sumaXCuadrado += X[i] * X[i];
        }

        double B1 = (n * sumaXY - sumaX * sumaY) / (double)(n * sumaXCuadrado - sumaX * sumaX);
        double B0 = (sumaY - B1 * sumaX) / (double) n;
 


        System.out.println("Suma X: " + sumaX);
        System.out.println("Suma Y: " + sumaY);
        System.out.println("Suma XY: " + sumaXY);
        System.out.println("Suma X^2: " + sumaXCuadrado);
        System.out.println("Número de X: " + n);
        System.out.println("B0 = " + Math.round(B0));
        System.out.println("B1 = " + Math.round(B1));
    }
}


