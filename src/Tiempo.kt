class Tiempo(var hora: Int, var minuto: Int, var segundo: Int) {

    constructor(hora: Int, min: Int) : this(hora, min, 0)
    constructor(hora: Int) : this(hora, 0,0)

    companion object { }

    override fun toString(): String {
        return "${"%02d".format(hora)}h $${"%02d".format(minuto)}m ${"%02d".format(segundo)}s"
    }

    init {
        if (segundo > 59) {
            minuto += segundo /60
            segundo %= 60
        }

        if (minuto > 59) {
            hora += minuto / 60
            minuto %= 60
        }

        require(hora in 0..23) {"La hora debeser un nvalor entre 0 y 23"}
        if (hora == 24) {
            require(minuto == 0 && segundo == 0) {"La hora máxima es 24.00.00"}
        }
    }
}