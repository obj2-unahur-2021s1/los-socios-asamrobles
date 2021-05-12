package ar.edu.unahur.obj2.socios

import kotlin.math.max

interface BarrioStrategy {
    fun calcularPropina(propinaAnimo: Double): Double
}

object LasRosas: BarrioStrategy {
    override fun calcularPropina(propinaAnimo: Double) = propinaAnimo + 50.0
}

object LasLauchas: BarrioStrategy {
    override fun calcularPropina(propinaAnimo: Double) = propinaAnimo / 2.0
}

object BarrioVerde: BarrioStrategy {
    override fun calcularPropina(propinaAnimo: Double) = max(propinaAnimo, 200.0)
}

object LasTorres: BarrioStrategy {
    override fun calcularPropina(propinaAnimo: Double) = propinaAnimo
}
