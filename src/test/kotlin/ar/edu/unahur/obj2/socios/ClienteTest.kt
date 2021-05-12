package ar.edu.unahur.obj2.socios

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ClienteTest : DescribeSpec({
  val clienteSegunAnimo = Cliente(EnojadoStrategy, 200.0)

  describe("Un/a cliente") {

    describe("propina segun estado de animo") {

      it("cliente enojado") {
        clienteSegunAnimo.propinaSegunAnimo(350.0).shouldBe(0.0)
      }
      it("cliente feliz") {
        clienteSegunAnimo.animo = FelizStrategy
        clienteSegunAnimo.propinaSegunAnimo(500.0).shouldBe(125.0)
      }
      it("cliente indiferente") {
        clienteSegunAnimo.animo = IndiferenteStrategy
        clienteSegunAnimo.propinaSegunAnimo(750.0).shouldBe(200.0)
      }
      it("cliente resfriado") {
        clienteSegunAnimo.animo = ResfriadoStrategy
        clienteSegunAnimo.propinaSegunAnimo(1000.0).shouldBe(1000.0)
      }
    }
  }
})
