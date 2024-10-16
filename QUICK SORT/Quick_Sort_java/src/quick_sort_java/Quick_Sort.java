package quick_sort_java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Quick_Sort{

    public static void main(String[] args) {       
        
        int []array=LeerArchivo(100);
        System.out.println("Array Original: ");
        imprimir(array);  
        long startTime = System.nanoTime();
        quickSort(array,0,array.length-1);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
           
        System.out.println("Duracion: " + duration/1_000_000_000.0 + " segundos.");
        System.out.println("Array Ordenado:");
        imprimir(array);
        
    }
    public static void quickSort(int[] array, int low, int high) {
        if(low<high){
            int partitionIndex=partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }
    private static int partition(int[] array, int low, int high) {
        int pivot=array[high];
        int i=(low-1);

        for(int j=low;j<high;j++){
            if(array[j]<=pivot){
                i++;
                int aux=array[i];
                array[i]=array[j];
                array[j]=aux;
            }
        }
        int temp=array[i+1];
        array[i+1]=array[high];
        array[high]=temp;

        return i+1;
    }
    public static void imprimir(int[] array) {
        for (int i : array) {
            System.out.print(i+" ");
        }
        System.out.println();
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
