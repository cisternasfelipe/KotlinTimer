# Guía de Aprendizaje: Reloj Dinámico

## 1. Lo que hemos construido (Tu Código)
Hemos logrado capturar la fecha y la hora del sistema y mostrarla en pantalla. 
- **Error corregido:** Cambiamos `Locale, getDefault()` por `Locale.getDefault()`. El punto es el "conector" que permite entrar a las funciones de una clase.

## 2. El Reto: Refresco Automático

Actualmente, tu código solo se ejecuta **una vez** al abrir la app. Para que cambie cada segundo, necesitamos convertirlo en una **tarea repetitiva**.

### Paso A: Crear el Método (La Caja de Herramientas)
En lugar de tener el código suelto, lo metemos en una función propia fuera de `onCreate`. Esto nos permite llamarla muchas veces.

### Paso B: El Handler (El Mayordomo)
En Android no podemos usar un reloj normal porque bloquearíamos el teléfono. Usamos un `Handler`, que es un mensajero que sabe esperar sin detener el sistema.

### Paso C: La Tarea (Runnable)
Es un bloque de código que dice: *"Actualiza la hora y luego dile al Handler que vuelva a ejecutarme en 1000 milisegundos (1 segundo)"*.

---

## Estructura sugerida para que TÚ la adaptes:

1. **Variables Globales:**
   `private lateinit var tvHora: TextView` (Declarada arriba de la clase).
2. **Método:**
   `fun refrescarReloj() { ... }` (Con tu lógica de formateo).
3. **Handler y Runnable:**
   Configurados en `onCreate` para llamar a tu método cada segundo.
