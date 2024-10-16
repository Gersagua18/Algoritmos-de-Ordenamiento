package heap_sort_java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Head_Sort {
    public static void main(String[] args) {
        int []array=LeerArchivo(100);
        System.out.println("Array Original: ");
        imprimir(array);  
        long startTime = System.nanoTime();
        heap_sort(array);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
           
        System.out.println("Duracion: " + duration/1_000_000_000.0 + " segundos.");
        System.out.println("Array Ordenado:");
        imprimir(array);
    }
    public static void imprimir(int [] array){
        for(int num : array){
            System.out.print(num+" ");
        }
        System.out.println("\n");
    }
    public static void heap_sort(int [] array){
        int n = array.length;

        for(int i=n/2-1;i>=0;i--) {
            heapify(array,n,i);
        }

        for (int i=n-1;i>0;i--) {
            int aux=array[0];
            array[0]=array[i];
            array[i]=aux;
            heapify(array, i, 0);
        }
        
    }
    private static void heapify(int[] array, int n, int i) {
        int indice_mayor= i;
        int hijo_izquierdo=2*i+1;
        int hijo_derecho=2*i+2;

        if (hijo_izquierdo<n && array[hijo_izquierdo]>array[indice_mayor]) {
            indice_mayor=hijo_izquierdo;
        }
        if (hijo_derecho<n && array[hijo_derecho] > array[indice_mayor]) {
            indice_mayor=hijo_derecho;
        }

        if (indice_mayor!=i) {
            int aux=array[i];
            array[i]=array[indice_mayor];
            array[indice_mayor]=aux;
            heapify(array, n, indice_mayor);
        }   
    }
    public static int [] LeerArchivo(int rango) {
        String ruta="D:\\gersael\\java\\Crear_numeros"+"\\"+String.valueOf(rango)+".txt";
        int [] numeros=new int[rango];
        try (BufferedReader br=new BufferedReader(new FileReader(ruta))) {
            String linea;
            int i=0;
            while((linea=br.readLine())!=null && i<rango) {
                String[] numerosComoString=linea.split(" ");
                for(String numStr : numerosComoString){
                    if(i<rango) { // Asegúrate de que i no exceda el rango
                        numeros[i] = Integer.parseInt(numStr);
                        i++;
                    }
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return numeros;
    }
}
