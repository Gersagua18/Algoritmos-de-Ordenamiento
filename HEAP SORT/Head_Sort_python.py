import time
def leer_archivo(rango):
    ruta=f"D:/gersael/java/Crear_numeros/{rango}.txt"
    numeros=[]
    try:
        with open(ruta, 'r') as archivo:
            for linea in archivo:
                numeros_como_string = linea.split()
                for num_str in numeros_como_string:
                    if len(numeros) < rango:
                        numeros.append(int(num_str))
    except IOError as e:
        print(f"Error al abrir el archivo: {ruta}")
        print(e)

    return numeros

def heap_sort(array):
    n=len(array)
    for i in range(n//2-1,-1,-1):
        heapify(array,n,i)
    
    for i in range(n-1,0,-1):
        aux=array[0]
        array[0]=array[i]
        array[i]=aux
        heapify(array, i, 0)

def heapify(array,n,i):
    indice_mayor=i
    hijo_derecho=2*i+1
    hijo_izquierdo=2*i+2
    if hijo_izquierdo<n and array[hijo_izquierdo]>array[indice_mayor]:
        indice_mayor=hijo_izquierdo
    
    if hijo_derecho<n and array[hijo_derecho] > array[indice_mayor]:
        indice_mayor=hijo_derecho
    
    if  indice_mayor!=i:
        aux=array[i]
        array[i]=array[indice_mayor]
        array[indice_mayor]=aux
        heapify(array, n, indice_mayor)

array=leer_archivo(100)
print("Array Orginal: ")
print(array)
start_time=time.perf_counter()
heap_sort(array)
end_time=time.perf_counter()
duration=end_time-start_time
print(f"Duración: {duration:.10f} segundos")
print("Array Ordenado: ")
print(array)
