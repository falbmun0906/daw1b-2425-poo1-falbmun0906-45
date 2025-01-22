/**
 * Representa un tiempo en formato 24 horas, incluyendo horas, minutos y segundos.
 * La hora siempre estará en el rango de [0, 23], los minutos y segundos en [0, 59].
 * Si los valores iniciales exceden estos límites, se ajustan automáticamente al rango permitido.
 *
 * @property hora La hora del día (entre 0 y 23).
 * @property min Los minutos (entre 0 y 59).
 * @property seg Los segundos (entre 0 y 59).
 * @constructor Permite construir un objeto `Tiempo` indicando horas, minutos y segundos,
 *              solo horas y minutos (asumiendo segundos = 0), o solo horas (asumiendo minutos y segundos = 0).
 */
class Tiempo2(var hora: Int, var min: Int, var seg: Int) {

    constructor(hora: Int) : this(hora, 0, 0)

    constructor(hora: Int, min: Int) : this(hora, min, 0)

    companion object {
        const val MAX_HORA = 23
        const val MAX_SEGUNDOS = 86399
    }

    init {
        validar()
        ajustar()
    }

    /**
     * Valida que los minutos y segundos sean positivos o cero,
     * y que la hora esté dentro del rango permitido.
     *
     * @throws IllegalArgumentException Si algún valor no cumple con los rangos establecidos.
     */
    private fun validar() {
        require( min >= 0) { "Los minutos deben ser positivos o cero!" }
        require( seg >= 0) { "Los segundos deben ser positivos o cero!" }
        validarHora()
    }

    /**
     * Valida que la hora esté en el rango permitido [0, MAX_HORA).
     *
     * @throws IllegalArgumentException Si la hora no está dentro del rango válido.
     */
    private fun validarHora() {
        require(hora in 0..MAX_HORA) { "La hora debe estar entre 0 y 23!" }
    }

    /**
     * Ajusta los valores de tiempo para que estén dentro de los rangos correctos.
     * Si los segundos o minutos superan los 59, se incrementa la magnitud superior
     * en función del exceso y se asigna el resto a la unidad actual.
     *
     * Por ejemplo:
     * - Si los segundos son 65, se suman 1 minuto y los segundos quedan en 5.
     * - Si los minutos son 125, se suman 2 horas y los minutos quedan en 5.
     *
     * La hora nunca excederá 23, y si lo hace se lanzará una excepción.
     */
    private fun ajustar() {
        val (minutosExtra, segundosAjustados) = ajustarUnidad(seg)
        seg = segundosAjustados
        min += minutosExtra

        val (horasExtra, minutosAjustados) = ajustarUnidad(min)
        min = minutosAjustados
        hora += horasExtra

        validarHora()
    }

    /**
     * Ajusta una unidad de tiempo (segundos o minutos) a su rango válido (0-59) y
     * calcula el incremento correspondiente para la unidad superior.
     *
     * @param valor El valor de la unidad a ajustar.
     * @return Un par de valores: (incremento para la unidad superior, valor ajustado).
     */
    private fun ajustarUnidad(valor: Int): Pair<Int, Int> {
        val incremento = valor / 60
        val ajustado = valor % 60
        return Pair(incremento, ajustado)
    }

    /**
     * Actualiza los valores de hora, minuto y segundo del objeto actual
     * con base en un total de segundos.
     *
     * @param totalSegundos El tiempo total en segundos.
     */
    private fun actualizarTiempoConSegundos(totalSegundos: Int) {
		//TODO: implementar
    }

    /**
     * Convierte las horas, minutos y segundos del objeto actual en un total de segundos y lo retorna.
     *
     * @return El tiempo total en segundos.
     */
    private fun obtenerSegundos(): Int {
		//TODO: implementar
    }

    /**
     * Incrementa el tiempo del objeto actual en el tiempo especificado por otro objeto `Tiempo`.
     *
     * Si el incremento excede el rango válido de tiempo (23:59:59), el objeto no se modifica.
     * En caso contrario, actualiza el tiempo actual.
     *
     * @param t El objeto `Tiempo` que contiene las horas, minutos y segundos a incrementar.
     * @return `true` si el tiempo se incrementó correctamente; `false` si se excedió el límite permitido.
     */
    fun incrementar(t: Tiempo): Boolean {
		//TODO: implementar
    }

    /**
     * Decrementa el tiempo del objeto actual en el tiempo especificado por otro objeto `Tiempo`.
     *
     * Si el decremento resulta en un tiempo negativo (por debajo de 00:00:00), el objeto no se modifica.
     * En caso contrario, actualiza el tiempo actual.
     *
     * @param t El objeto `Tiempo` que contiene las horas, minutos y segundos a decrementar.
     * @return `true` si el tiempo se decrementó correctamente; `false` si resultó en un tiempo negativo.
     */
    fun decrementar(t: Tiempo): Boolean {
		//TODO: implementar
    }

    /**
     * Compara el tiempo que almacena el objeto actual con el tiempo especificado por otro objeto `Tiempo`.
     *
     * @param t El objeto `Tiempo` con el que se compara.
     * @return `-1` si el tiempo actual es menor que `t`, `0` si son iguales, y `1` si es mayor.
     */
    fun comparar(t: Tiempo): Int {
		//TODO: implementar
    }

    /**
     * Crea una copia del objeto actual con el mismo tiempo almacenado.
     *
     * @return Un nuevo objeto `Tiempo` con los mismos valores de hora, minuto y segundo.
     */
    fun copiar(): Tiempo {
		//TODO: implementar
    }

    /**
     * Copia el tiempo que almacena el objeto `t` en el objeto actual.
     *
     * @param t El objeto `Tiempo` cuyo tiempo será copiado.
     */
    fun copiar(t: Tiempo) {
		//TODO: implementar
    }

    /**
     * Suma el tiempo del objeto actual con el tiempo especificado por otro objeto `Tiempo`.
     *
     * @param t El objeto `Tiempo` cuyo tiempo será sumado.
     * @return Un nuevo objeto `Tiempo` con el resultado de la suma, o `null` si el resultado excede 23:59:59.
     */
    fun sumar(t: Tiempo): Tiempo? {
		//TODO: implementar
    }

    /**
     * Resta el tiempo del objeto actual con el tiempo especificado por otro objeto `Tiempo`.
     *
     * @param t El objeto `Tiempo` cuyo tiempo será restado.
     * @return Un nuevo objeto `Tiempo` con el resultado de la resta, o `null` si el resultado es menor que 00:00:00.
     */
    fun restar(t: Tiempo): Tiempo? {
		//TODO: implementar
    }

    /**
     * Compara si el tiempo almacenado en el objeto actual es mayor que el tiempo especificado por otro objeto `Tiempo`.
     *
     * @param t El objeto `Tiempo` con el que se compara.
     * @return `true` si el tiempo actual es mayor que el tiempo de `t`, de lo contrario, `false`.
     */
    fun esMayorQue(t: Tiempo): Boolean {
		//TODO: implementar
    }

    /**
     * Compara si el tiempo almacenado en el objeto actual es menor que el tiempo especificado por otro objeto `Tiempo`.
     *
     * @param t El objeto `Tiempo` con el que se compara.
     * @return `true` si el tiempo actual es menor que el tiempo de `t`, de lo contrario, `false`.
     */
    fun esMenorQue(t: Tiempo): Boolean {
		//TODO: implementar
    }

    /**
     * Devuelve una representación del tiempo en formato "XXh XXm XXs",
     * donde cada componente tiene siempre dos dígitos.
     *
     * @return Una cadena en formato "XXh XXm XXs".
     */
    override fun toString(): String {
        return "${"%02d".format(hora)}h ${"%02d".format(min)}m ${"%02d".format(seg)}s"
    }
}