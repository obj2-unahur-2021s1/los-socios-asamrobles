package ar.edu.unahur.obj2.socios

class Cliente(var animo: AnimoStrategy, var barrio: BarrioStrategy, var dineroBolsillo: Double) {

    fun propinaSegunAnimo(valorDelPedido: Double) = animo.calcularPropina(valorDelPedido, this)

    fun propinaSegunBarrio(propinaAnimo: Double) = barrio.calcularPropina(propinaAnimo)

    fun darPropina(valorDelPedido: Double) = this.propinaSegunBarrio(this.propinaSegunAnimo(valorDelPedido))
}
