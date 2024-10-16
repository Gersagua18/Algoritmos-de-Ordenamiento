package selection_sort_java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Selection_Sort {

    public static void main(String[] args) {     
        int []array=LeerArchivo(100);
        System.out.println("Array Original:");
        imprimir(array);
        long startTime = System.nanoTime();
        selectionSort(array);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Duracion: " + duration/1_000_000_000.0 + " segundos.");
        System.out.println("Array Ordenado:");
        imprimir(array);
    }
    public static void selectionSort(int[] array) {
        int n=array.length;

        for(int i=0;i<n-1;i++){
            int minIndex=i;
            for(int j=i+1;j<n;j++){
                if(array[j]<array[minIndex]){
                    minIndex=j;
                }
            }

            int temp=array[minIndex];
            array[minIndex]=array[i];
            array[i]=temp;
        }
    }
    public static void imprimir(int[] array){
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
