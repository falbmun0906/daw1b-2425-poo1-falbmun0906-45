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
        hora = segundosATiempo(totalSegundos)[0]
        minuto = segundosATiempo(totalSegundos)[1]
        segundo = segundosATiempo(totalSegundos)[2]
        validarHora()
    }

    fun segundosATiempo(segundos: Int): List<Int> {
        var segundos = segundos
        val hora = (segundos / 3600)
        segundos -= hora * 3600
        val minuto = segundos / 60
        val segundo = segundos % 60
        return listOf(hora, minuto, segundo)
    }

    fun validarHora() {
        require(hora in 0..MAX_HORA) { "La hora debe estar entre 0 y 23!" }
    }

    fun incrementar(t:Tiempo):Boolean {
        val segundosIncremento: Int = calcularSegundosTotales(t.segundo, t.minuto, t.hora)
        println(segundosIncremento)

        var segundosActual: Int = calcularSegundosTotales(this.segundo, this.minuto, this.hora)
        println(segundosActual)

        val tiempoNuevo = segundosATiempo(segundosActual + segundosIncremento)
        if (tiempoNuevo[0] in 0..MAX_HORA) {
            hora = tiempoNuevo[0]
            minuto = tiempoNuevo[1]
            segundo = tiempoNuevo[2]
            return true
        } else return false
    }

    override fun toString(): String {
        return "${"%02d".format(hora)}h ${"%02d".format(minuto)}m ${"%02d".format(segundo)}s"
    }

}