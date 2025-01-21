fun pedirValor(msj: String, aceptaVacio: Boolean = true) : Int {

    var valor: Int? = null

    do {
        print(msj)
        val entrada = readln().trim()
        if (entrada.isEmpty()) {
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

fun main() {
    val hora = pedirValor("Introduce la hora: ", false)
    val minuto = pedirValor("Introduce los minutos: ")
    val segundo = pedirValor("Introduce los segundos: ")
}