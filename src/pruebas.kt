fun main() {
    var hora = 15
    var minuto = 300
    var segundo = 2000
    var totalSegundos: Int = segundo + (minuto * 60) + (hora * 3600)

    hora = totalSegundos / 3600
    totalSegundos -= hora * 3600

    minuto = totalSegundos / 60
    segundo = totalSegundos % 60

    print("$hora, $minuto, $segundo")
}