# Requerimientos del Proyecto

* **Funcionalidad:** Ver la fecha y la hora actualizadas automáticamente cada segundo.

## Lección Avanzada: El Reloj Dinámico (Refresco Automático)

Para que el reloj "cobre vida", sigue esta estructura en `MainActivity.kt`:

### Paso 1: Declarar Vistas Globales
Para que una función fuera de `onCreate` pueda ver tus textos, decláralos al inicio de la clase (fuera de las funciones).
- `private lateinit var tvFecha: TextView`
- `private lateinit var tvHora: TextView`
- `private val handler = Handler(Looper.getMainLooper())`

### Paso 2: Crear el Método de Actualización
Crea esta "caja" al final de la clase. Centraliza el trabajo de pedir la hora y pintarla:
```kotlin
fun actualizarPantalla() {
    val ahora = Calendar.getInstance().time
    val fmtFecha = SimpleDateFormat("EEEE, d MMMM yyyy", Locale.getDefault())
    val fmtHora = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    
    tvFecha.text = fmtFecha.format(ahora)
    tvHora.text = fmtHora.format(ahora)
}
```

### Paso 3: Definir la Tarea Repetitiva (Runnable)
Este bloque le pide al Handler que ejecute el método y se reprograme a sí mismo:
```kotlin
private val tareaReloj = object : Runnable {
    override fun run() {
        actualizarPantalla() // 1. Llama a la función que pinta la hora
        handler.postDelayed(this, 1000) // 2. Se agenda a sí misma para dentro de 1 seg
    }
}
```

### Paso 4: Arrancar el motor (Dentro de onCreate)
Inicializa las vistas y arranca el ciclo por primera vez:
`handler.post(tareaReloj)`

## Conceptos Didácticos para investigar
- **postDelayed:** ¿Por qué usamos milisegundos?
- **Scope:** ¿Por qué las variables deben estar fuera de las funciones para ser "globales"?
- **MainLooper:** ¿Qué pasa si intentamos cambiar un texto desde un hilo que no es el principal?

*Nota: Recuerda importar android.os.Handler y android.os.Looper.*
