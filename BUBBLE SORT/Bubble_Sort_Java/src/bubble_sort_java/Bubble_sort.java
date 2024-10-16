package bubble_sort_java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Bubble_sort {
    public static void main (String[] args){
        int []array=LeerArchivo(500);
        System.out.println("Array Original: ");
        imprimir(array);  
            long startTime = System.nanoTime();
        bubblesort(array);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
           
        System.out.println("Duracion: " + duration/1_000_000_000.0 + " segundos.");
        System.out.println("Array Ordenado:");
        imprimir(array);
    }
    public static void bubblesort(int[]array){
        int size=array.length;
        boolean cambio;
        for(int i=0;i<size-1;i++){
            cambio=false;
            for(int j=0;j<size-1-i;j++){
                if(array[j]>array[j+1]){
                    int aux=array[j];
                    array[j]=array[j+1];
                    array[j+1]=aux;
                    cambio=true;
                }
            }
            if(!cambio) break;
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
