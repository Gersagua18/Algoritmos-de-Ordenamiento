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

def counting_sort(array):
    mx=max(array)
    mn=min(array)
    rng=mx-mn+1
    conteo=[0]*rng
    salida=[0]*len(array)
    for i in range(len(array)):
        conteo[array[i]-mn]+=1
    
    for i in range(1,rng):
        conteo[i]+=conteo[i-1]

    for i in range(len(array)-1,-1,-1):
        salida[conteo[array[i]-mn]-1]=array[i]
        conteo[array[i]-mn]-=1

    for i in range(len(array)):
        array[i]=salida[i]

array=leer_archivo(100)
print("Array Orginal: ")
print(array)
start_time=time.perf_counter()
counting_sort(array)
end_time=time.perf_counter()
duration=end_time-start_time
print(f"Duración: {duration:.10f} segundos")
print("Array Ordenado: ")
print(array)
