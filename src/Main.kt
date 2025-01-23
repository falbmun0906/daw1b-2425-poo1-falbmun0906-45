fun pedirValor(msj: String, aceptaVacio: Boolean = true) : Int {

    var valor: Int? = null

    do {
        print(msj)
        val entrada = readln().trim()
        if (aceptaVacio && entrada.isEmpty()) {
            valor = 0
        } else {
            try {
                valor = entrada.toInt()
            } catch (e: NumberFormatException) {
                println("ERROR: Debe introducir un valor numérico entero o vacío. Inténtalo de nuevo.")
            }
        }
    } while (valor == null)

    return valor
}

fun crearTiempo(): Tiempo {

    while(true) {
        try {
            val hora = pedirValor("Introduce la hora: ", false)
            val minuto = pedirValor("Introduce los minutos: ")
            val segundo = pedirValor("Introduce los segundos: ")
            return Tiempo(hora, minuto, segundo)
        } catch (e: IllegalArgumentException) {
            println("ERROR: ${e.message}")
        }
    }
}

fun main() {
    println("\nValor de Tiempo Principal\n")
    val tiempo1 = crearTiempo()
    var t = Tiempo(0, 0, 0)
    println("Tiempo principal: $tiempo1")

    println("\nINCREMENTAR TIEMPO: Introduce el tiempo a incrementar el valor principal.")
    t = crearTiempo()
    if (tiempo1.incrementar(t)) {
        println("Nuevo tiempo principal: $tiempo1")
    } else println("ERROR: El tiempo total supera las 23:59:59.")

    println("\nDECREMENTAR TIEMPO: Introduce el tiempo a decrementar el valor principal")
    t = crearTiempo()
    if (tiempo1.decrementar(t)) {
        println("Nuevo tiempo principal: $tiempo1")
    } else println("ERROR: El tiempo es menor a 00:00:00.")

    println("\nCOMPARACIÓN DE TIEMPOS: Introduce el tiempo con el que comparar el valor principal.")
    t = crearTiempo()
    println("Resultado de la comparación: ${tiempo1.comparar(t)}")

    println("\nCOPIA DE TIEMPO: Se va a crear una copia de tiempo principal.")
    t = tiempo1.copiar()
    println("Resultado de la copia: $t")

    println("\nCOPIA 2 DE TIEMPO: Introduce el valor del tiempo que quieres copiar.")
    t = crearTiempo()
    val tiempo2 = tiempo1.copiar(t)
    println("Resultado de la copia: $tiempo2")

    println("\nSUMA DE TIEMPOS: Introduce el tiempo a sumar al valor principal")
    t = crearTiempo()
    var tiempo3: Tiempo? = tiempo1.sumar(t)
    if (tiempo3 != null) {
        println("Nuevo tiempo principal: $tiempo3")
    } else println("ERROR: Tiempo superior a 23:59:59.")

    println("\nRESTA DE TIEMPOS: Introduce el tiempo a restar al valor principal.")
    t = crearTiempo()
    tiempo3 = tiempo1.sumar(t)
    if (tiempo3 != null) {
        println("Nuevo tiempo principal: $tiempo3")
    } else println("ERROR: Tiempo inferior a 00:00:00.")

    println("\nTIEMPO MAYOR QUE t: Introduce el tiempo a comparar con el valor principal.")
    t = crearTiempo()
    println("Resultado de la comparación: ${if (tiempo1.esMayorQue(t)) print("Sí") else print("No")}")

    println("\nTIEMPO MENOR QUE t: Introduce el tiempo a comparar con el valor principal.")
    t = crearTiempo()
    println("Resultado de la comparación: ${if (tiempo1.esMenorQue(t)) "Sí" else "No"}\"")
}
