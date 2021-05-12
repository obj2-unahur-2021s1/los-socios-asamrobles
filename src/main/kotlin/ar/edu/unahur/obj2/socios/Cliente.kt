package ar.edu.unahur.obj2.socios

class Cliente(var animo: AnimoStrategy, var dineroBolsillo: Double) {

    fun propinaSegunAnimo(valorDelPedido: Double) = animo.calcularPropina(valorDelPedido, this)
}
