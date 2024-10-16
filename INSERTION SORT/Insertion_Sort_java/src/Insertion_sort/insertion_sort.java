package Insertion_sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class insertion_sort {
    public static void main(String [] args){
        int []array=LeerArchivo(100000);
        System.out.println("Array Original: ");
        imprimir(array);  
        long startTime = System.nanoTime();
        insertion_sort(array);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
           
        System.out.println("Duracion: " + duration/1_000_000_000.0 + " segundos.");
        System.out.println("Array Ordenado:");
        imprimir(array);
    }
    public static void insertion_sort(int[] array){
        for (int i=0;i<array.length;i++) {
            int pos=i;
            int aux=array[i];
            
            while((pos>0 && (array[pos-1]>aux))){
                array[pos]=array[pos-1];
                pos--;
            }
            array[pos]=aux;
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
