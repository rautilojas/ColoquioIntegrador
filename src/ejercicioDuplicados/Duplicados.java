package ejercicioDuplicados;

import java.util.Arrays;

public class Duplicados {
	
	private static int eliminaDuplicados(int[] A, int N) { // El metodo eliminaDuplicados recibe como parametro una matriz de numeros y su longitud
	    int contador = N; // Variable contador que adopta la longitud de N
	    Arrays.sort(A); // Ordena la matriz utilizando el algoritmo de ordenación rapida
	    for (int i = 1; i < N; i++) { // Bucle for que recorre la longitud de la matriz
	        if (A[i] == A[i-1]) { // Verifica que el elemento actual sea igual al anterior
	            contador--; // En caso positivo, descontamos contador en 1
	        }
	    }
	    return contador; // Devuelve el contador final
	}

	public static void main(String[] args) {
	    int[] matrizPrueba = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5}; // Matriz de prueba
	    int resultado = eliminaDuplicados(matrizPrueba, matrizPrueba.length); // Llama al metodo eliminaDuplicados sobre la matriz ingresada, tomando sus elementos y su longitud
	    System.out.println("Número de elementos que permanecen en A: " + resultado); // Imprime el numero de elementos final
	}	
}