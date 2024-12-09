import java.util.Arrays;

public class TablaDeFrecuencias {
    public static void main(String[] args) {
    
        int[] datos = {105, 106, 105, 107, 109, 111, 110, 110, 107, 107, 104, 99, 103, 99, 103, 101, 100,
            101, 100, 103, 98, 92, 97, 94, 95, 95, 93, 95, 95, 95, 91, 82 ,91, 85, 90, 86, 87,
            89, 87, 89};

        
        Arrays.sort(datos);
        
        
        int rango = datos[datos.length - 1] - datos[0];

   
       int n = datos.length;
       int kExacto = (int) (1 + 3.322 * Math.log10(n));
       int k = (int) Math.round(kExacto);

        
        int amplitud = (int) Math.ceil((double) rango / kExacto);

        int[][] clases = new int[kExacto][2];
        for (int i = 0; i < kExacto; i++) {
            clases[i][0] = datos[0] + i * amplitud;
            clases[i][1] = clases[i][0] + amplitud - 1;
        }

        int[] frecuencia = new int[kExacto];
        double[] frecuenciaRelativa = new double[kExacto];
        int[] frecuenciaAcumulada = new int[kExacto];
        double[] frecuenciaRelativaAcumulada = new double[kExacto];

        for (int dato : datos) {
            for (int j = 0; j < kExacto; j++) {
                if (dato >= clases[j][0] && dato <= clases[j][1]) {
                    frecuencia[j]++;
                    break;
                }
            }
        }

     
        int totalDatos = datos.length;
        for (int j = 0; j < kExacto; j++) {
            frecuenciaRelativa[j] = (double) frecuencia[j] / totalDatos;
            frecuenciaAcumulada[j] = (j == 0) ? frecuencia[j] : frecuenciaAcumulada[j - 1] + frecuencia[j];
        }

       
        for (int i = 0; i < kExacto; i++) {
            if (i >= 1) {
                frecuenciaRelativaAcumulada[i] = frecuenciaRelativaAcumulada[i - 1];
            }
            frecuenciaRelativaAcumulada[i] += frecuenciaRelativa[i];
        }

        
        System.out.printf("%-10s %-20s %-15s %-15s %-10s %-10s %-10s %-15s%n", "Clase", "Límite de Clase", "Frecuencia (f)", "Punto Medio (Xc)", "Fa", "fr", "fra", "Porcentaje %");
        for (int j = 0; j < kExacto; j++) {
            int puntoMedio = clases[j][0] + clases[j][1]/2;
            System.out.printf("%-10d %-20s %-15d %-15d %-10d %-10.2f %-10.2f %-15.2f%n", (j + 1), clases[j][0] + " - " + clases[j][1], frecuencia[j], puntoMedio, frecuenciaAcumulada[j], frecuenciaRelativa[j], frecuenciaRelativaAcumulada[j], frecuenciaRelativa[j] * 100);
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-15s %-15s %-10s %-10.2f %-10.2f %-15.2f%n", "TOTAL", "", "n = " + totalDatos, "", "", 1.00, 1.00, 100.00);
        
        
    }
}