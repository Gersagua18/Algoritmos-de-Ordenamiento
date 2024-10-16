package merge_sort_java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Merge_Sort {

    public static void main(String [] args){
        int []array=LeerArchivo(100000);
        System.out.println("Array Original: ");
        imprimir(array);  
        long startTime = System.nanoTime();
        merge_sort(array);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
           
        System.out.println("Duracion: " + duration/1_000_000_000.0 + " segundos.");
        System.out.println("Array Ordenado:");
        imprimir(array);
    }
    public static void merge_sort(int[] array){
        if(array.length < 2){
            return;
        }
        int mid=array.length / 2;
        int[] left=Arrays.copyOfRange(array, 0, mid);
        int[] right=Arrays.copyOfRange(array, mid, array.length);

        merge_sort(left);
        merge_sort(right);

        merge(array, left, right);
    }
    private static void merge(int[] arr, int[] left, int[] right) {
        int i=0,j=0,k=0;

        while (i<left.length && j<right.length) {
            if(left[i]<=right[j]) {
                arr[k++]=left[i++];
            }else{
                arr[k++]=right[j++];
            }
        }

        while (i<left.length) {
            arr[k++]=left[i++];
        }

        while (j<right.length) {
            arr[k++]=right[j++];
        }
    }
    public static void imprimir(int [] array){
        for(int num : array){
            System.out.print(num+" ");
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
