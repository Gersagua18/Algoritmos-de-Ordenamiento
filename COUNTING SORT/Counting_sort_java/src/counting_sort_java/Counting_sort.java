package counting_sort_java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Counting_sort {
    public static void main(String [] args){
        int []array=LeerArchivo(100);
        System.out.println("Array Original: ");
        imprimir(array);  
        long startTime = System.nanoTime();
        counting_sort(array);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
           
        System.out.println("Duracion: " + duration/1_000_000_000.0 + " segundos.");
        System.out.println("Array Ordenado:");
        imprimir(array);
    }
    public static void counting_sort(int[] array){
        int max=array[0],min=array[0],range;
        for(int i=0;i<array.length;i++){
            if(array[i]>max){
            max=array[i];
            }
            if(array[i]<min){
            min=array[i];
            }
        }
        
        range=max-min+1;
        int[] conteo=new int[range];
        int[] salida=new int[array.length];
        for(int i=0;i<array.length;i++){
            conteo[array[i]-min]++;
        }
        for(int i=1;i<range;i++){
            conteo[i]+=conteo[i-1];
        }
        for(int i=array.length-1;i>=0;i--){
            salida[conteo[array[i]-min]-1]=array[i];
            conteo[array[i]-min]--;
        }
        for(int i=0;i<array.length;i++){
            array[i]=salida[i];
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
