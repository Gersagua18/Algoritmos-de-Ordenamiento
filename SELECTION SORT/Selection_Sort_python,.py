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

def selection_sort(array):
    n=len(array)

    for i in range(n):
        min_index=i
        for j in range(i+1,n):
            if array[j]<array[min_index]:
                min_index=j

        array[i],array[min_index]=array[min_index],array[i]

array=leer_archivo(100)
print("Array Orginal: ")
print(array)
start_time=time.perf_counter()
selection_sort(array)
end_time=time.perf_counter()
duration=end_time-start_time
print(f"Duración: {duration:.10f} segundos")
print("Array Ordenado: ")
print(array)