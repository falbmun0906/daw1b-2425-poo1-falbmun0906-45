class Tiempo(var hora: Int, var minuto: Int, var segundo: Int) {

    constructor(hora: Int, min: Int) : this(hora, min, 0)
    constructor(hora: Int) : this(hora, 0,0)

    companion object {
        const val MAX_HORA = 23
        const val MAX_SEGUNDOS = 86399
    }

    init {
        validar()
        ajustar()
    }

    fun validar() {
        require(segundo in 0..86399) {"Los segundos deben ser positivos y un máximo de 86399."}
        require(minuto >= 0) {"Los minutos deben ser mayores o igual a cero."}
    }

    fun calcularSegundosTotales(segundo: Int, minuto: Int, hora: Int): Int {
        return segundo + (minuto * 60) + (hora * 3600)
    }

    fun ajustar() {
        val totalSegundos: Int = calcularSegundosTotales(segundo, minuto, hora)
        hora = segundosAHorMinSeg(totalSegundos).first
        minuto = segundosAHorMinSeg(totalSegundos).second
        segundo = segundosAHorMinSeg(totalSegundos).third
        validarHora()
    }

    fun segundosAHorMinSeg(segundos: Int): Triple<Int, Int, Int> {
        var segundos = segundos
        val hora = (segundos / 3600)
        segundos %= 3600
        val minuto = segundos / 60
        val segundo = segundos % 60
        return Triple(hora, minuto, segundo)
    }

    fun validarHora() {
        require(hora in 0..MAX_HORA) { "La hora debe estar entre 0 y 23!" }
    }

    fun actualizarTiempo(segundosTotales: Int): Boolean {
        val tiempoNuevo = segundosAHorMinSeg(segundosTotales)
        if (tiempoNuevo.first in 0..MAX_HORA) {  // Comprobar si la hora es válida
            hora = tiempoNuevo.first
            minuto = tiempoNuevo.second
            segundo = tiempoNuevo.third
            return true
        }
        return false
    }

    fun incrementar(t: Tiempo): Boolean {
        val segundosIncremento: Int = calcularSegundosTotales(t.segundo, t.minuto, t.hora)
        val segundosActual: Int = calcularSegundosTotales(this.segundo, this.minuto, this.hora)
        return actualizarTiempo(segundosActual + segundosIncremento)
    }

    fun decrementar(t: Tiempo): Boolean {
        val segundosIncremento: Int = calcularSegundosTotales(t.segundo, t.minuto, t.hora)
        val segundosActual: Int = calcularSegundosTotales(this.segundo, this.minuto, this.hora)
        return if (segundosActual - segundosIncremento > 0) {
            actualizarTiempo(segundosActual - segundosIncremento)
        } else {
            false
        }
    }

    fun comparar(t: Tiempo): Int {
        val segundosT: Int = calcularSegundosTotales(t.segundo, t.minuto, t.hora)
        val segundosActual: Int = calcularSegundosTotales(this.segundo, this.minuto, this.hora)

        return when {
            segundosActual < segundosT -> -1
            segundosActual > segundosT -> 1
            else -> 0
        }
    }

    fun copiar(): Tiempo {
        return Tiempo(this.hora, this.minuto, this.segundo)
    }

    fun copiar(t: Tiempo): Tiempo {
        return Tiempo(t.hora, t.minuto, t.segundo)
    }

    fun sumar(t: Tiempo): Tiempo? {
        val segundosSuma: Int = calcularSegundosTotales(t.segundo, t.minuto, t.hora)
        val segundosActual: Int = calcularSegundosTotales(this.segundo, this.minuto, this.hora)
        val tiempoNuevo = segundosAHorMinSeg(segundosSuma + segundosActual)
        if (tiempoNuevo.first in 0..MAX_HORA) {
            return Tiempo(tiempoNuevo.first, tiempoNuevo.second, tiempoNuevo.third)
        } else return null
    }

    fun restar(t: Tiempo): Tiempo? {
        val segundosResta: Int = calcularSegundosTotales(t.segundo, t.minuto, t.hora)
        val segundosActual: Int = calcularSegundosTotales(this.segundo, this.minuto, this.hora)
        if (segundosActual - segundosResta >= 0) {
            val tiempoNuevo = segundosAHorMinSeg(segundosActual - segundosResta)
            return Tiempo(tiempoNuevo.first, tiempoNuevo.second, tiempoNuevo.third)
        } else return null
    }

    fun esMayorQue(t:Tiempo): Boolean {
        return comparar(t) == 1
    }

    fun esMenorQue(t:Tiempo): Boolean {
        return comparar(t) == -1
    }

    override fun toString(): String {
        return "${"%02d".format(hora)}h ${"%02d".format(minuto)}m ${"%02d".format(segundo)}s"
    }
}