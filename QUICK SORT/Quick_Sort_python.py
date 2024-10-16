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

def imprimir(array):
    print(array)

def quick_sort(array):
    if len(array) < 2:
        return array

    pivot=array[-1]
    left=[]
    right=[]

    for i in range(len(array) - 1):
        if array[i]<=pivot:
            left.append(array[i])
        else:
            right.append(array[i])

    return quick_sort(left)+[pivot]+quick_sort(right)

array=leer_archivo(100)
print("Array Orginal: ")
print(array)
start_time=time.perf_counter()
array_ordenado=quick_sort(array)
end_time=time.perf_counter()
duration=end_time-start_time
print(f"Duración: {duration:.10f} segundos")
print("Array Ordenado: ")
print(array_ordenado)