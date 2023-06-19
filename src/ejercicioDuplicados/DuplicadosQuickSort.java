package ejercicioDuplicados;

public class DuplicadosQuickSort {

    public static int eliminaDuplicados(int[] A, int N) { // El metodo eliminaDuplicados recibe como parametro una matriz de numeros y un entero que corresponde al contador final
        int contador = N; // Variable contador que adopta la longitud de N
        metodoQuicksort(A, 0, N - 1); // Ordena la matriz utilizando el algoritmo de ordenación rapida
        for (int i = 1; i < N; i++) { // Bucle for que recorre la longitud de la matriz
            if (A[i] == A[i - 1]) { // Verifica que el elemento actual sea igual al anterior
                contador--; // En caso positivo, descontamos contador en 1
            }
        }
        return contador;   // Devuelve el contador final
    }

    public static void metodoQuicksort(int[] A, int menor, int mayor) { // Metodo recursivo para ordenar la matriz desde menor hasta mayor
        if (menor < mayor) {
            int indicePivote = corte(A, menor, mayor); // Variable que obtiene el indice del pivote una vez terminado el metodo corte
            metodoQuicksort(A, menor, indicePivote - 1); // Ordena los elementos menores al pivote de forma recursiva
            metodoQuicksort(A, indicePivote + 1, mayor); // Ordena los elementos mayores al pivote de forma recursiva
        }
    }

    public static int corte(int[] A, int menor, int mayor) { // Metodo que realiza la división de la matriz, tomando el pivote, devolviendo los elementos menores y mayores
        int pivote = A[mayor]; // Variable que toma el ultimo elemento como pivote
        int i = menor - 1; // Variable i que toma el indice mas pequeño
        for (int j = menor; j < mayor; j++) { // Bucle que recorre los elementos mayores
            if (A[j] <= pivote) { // Verifica que el elemento sea menor al pivote
                i++; // Aumenta i en 1
                intercambio(A, i, j); // Intercambia el elemento actual con el elemento en el indice mas pequeño
            }
        }
        intercambio(A, i + 1, mayor); // Intercambia el pivote con el elemento en el indice mas pequeño + 1
        return i + 1; // Devuelve el indice del pivote
    }

    public static void intercambio(int[] A, int i, int j) { // Metodo para intercambiar los elementos en las posiciones i y j de la matriz
        int aux = A[i]; // Variable auxiliar que toma el indice actual de la matriz
        A[i] = A[j]; // El indice i toma el valor de j
        A[j] = aux; // El indice j toma el valor de la variable auxiliar
    }
    
    public static void main(String[] args) {
        int[] matrizPrueba = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5};
        int resultado = eliminaDuplicados(matrizPrueba, matrizPrueba.length);
        System.out.println("Número de elementos que permanecen en A: " + resultado); // debería imprimir 9
    }   
}