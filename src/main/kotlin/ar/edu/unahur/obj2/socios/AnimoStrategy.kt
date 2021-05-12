package ar.edu.unahur.obj2.socios

interface AnimoStrategy {
    fun calcularPropina(valorPedido: Double, cliente: Cliente): Double
}

object EnojadoStrategy: AnimoStrategy {
    override fun calcularPropina(valorPedido: Double, cliente: Cliente) = 0.0
}

object FelizStrategy: AnimoStrategy {
    override fun calcularPropina(valorPedido: Double, cliente: Cliente) = valorPedido * 0.25
}

object IndiferenteStrategy: AnimoStrategy {
    override fun calcularPropina(valorPedido: Double, cliente: Cliente) = cliente.dineroBolsillo
}

object ResfriadoStrategy: AnimoStrategy {
    override fun calcularPropina(valorPedido: Double, cliente: Cliente) = valorPedido
}