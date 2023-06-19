package ejercicioAnagramas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class grupoAnagramas {
    public static String[] encontrarGrupoMasGrande(String[] palabras) { // Metodo para encontrar y desginar el grupo mas grande de anagramas
        Arrays.sort(palabras, (palabra1, palabra2) -> ordenar(palabra1).compareTo(ordenar(palabra2))); // Ordena la matriz de palabras ya ordenadas alfabeticamente en si mismas
        
        List<String> grupoActual = new ArrayList<>(); // Variable para mantener el grupo actual
        List<String> grupoGrande = new ArrayList<>(); // Variable para mantener el grupo mas grande
        
        for (int i = 0; i < palabras.length; i++) { // Bucle para recorrer el arreglo de palabras ordenadas
            if (grupoActual.isEmpty() || sonAnagramas(grupoActual.get(0), palabras[i])) { // Verifica si el grupo actual está vacío o la palabra actual es un anagrama de la primera palabra del grupo actual
                grupoActual.add(palabras[i]);  // En caso afirmativo Agrega la palabra al grupo actual
            } else {
                if (grupoActual.size() > grupoGrande.size()) { // Verifica si el grupo actual es más grande que el grupo más grande encontrado hasta ahora
                    grupoGrande = new ArrayList<>(grupoActual); // En este caso, se reempleaza el grupo mas grande
                }
                grupoActual.clear(); // Sino, limpia el grupo actual 
                grupoActual.add(palabras[i]); // Agrega la palabra actual como la primera palabra del nuevo grupo
            }
        }               
        if (grupoActual.size() > grupoActual.size()) { // Verifica si el grupo actual es más grande que el grupo más grande encontrado hasta ahora al final del bucle
            grupoGrande = new ArrayList<>(grupoActual); // De ser así, reemplaza el valor de grupoGrande
        }                
        return grupoGrande.toArray(new String[0]); // Convierte el grupo más grande de anagramas a un arreglo de String y lo devuelve
    }
    
    public static boolean sonAnagramas(String palabra1, String palabra2) { // Metodo para verificar que dos palabras sean anagramas
        return ordenar(palabra1).equals(ordenar(palabra2)); // Comprueba si dos palabras son anagramas comparando sus representaciones ordenadas
    }
    
    public static String ordenar(String palabra) { // Metodo para ordenar las palabras
        char[] caracteres = palabra.toCharArray(); // Convierte cada palabra en un arreglo de caracteres
        Arrays.sort(caracteres); // Ordena los arreglos de caracteres alfabeticamente
        return new String(caracteres); // Devuelve cada arreglo nuevamente como String
    }
    
    public static String[] leer(String filename) throws IOException { // Metodo para leer el archivo    
        List<String> palabras = new ArrayList<>(); // Las palabras leidas se almacenaran en la lista        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) { // Abre el archivo y lo lee
            String linea; // Variable que almacenará cada linea
            while ((linea = reader.readLine()) != null) { // Bucle que leerá cada linea mientras las haya disponibles para leer
                palabras.add(linea); // Se agrega cada linea de forma separada 
            }
        }              
        return palabras.toArray(new String[0]); // Convierte la lista de palabras a un arreglo de String y lo devuelve
    }
    
    public static void main(String[] args) throws IOException { // Main que recurre a los demas metodos, devuelve el grupo mas grande palabras
        String[] palabras = leer("archivo.txt");
        String[] grupoMasGrande = encontrarGrupoMasGrande(palabras);
        System.out.println("Grupo mas grande de anagramas:");
        for (String palabra : grupoMasGrande) {
            System.out.println(palabra);
        }
    }
}