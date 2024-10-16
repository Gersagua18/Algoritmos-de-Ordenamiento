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

def bubblesort(array):
    size=len(array)
    cambio=False

    for i in range(size-1):
        cambio=False

        for j in range(size-1-i):
            if array[j]>array[j+1]:
                array[j], array[j + 1] = array[j + 1], array[j]
                cambio=True

        if not cambio:
            break
        
  
array=leer_archivo(100)
print("Array Orginal: ")
print(array)
start_time=time.perf_counter()
bubblesort(array)
end_time=time.perf_counter()
duration=end_time-start_time
print(f"Duración: {duration:.10f} segundos")
print("Array Ordenado: ")
print(array)
