package ar.edu.unahur.obj2.socios

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ClienteTest : DescribeSpec({
  val clienteSegunAnimoYBarrio = Cliente(EnojadoStrategy, LasRosas, 300.0)

  describe("Un/a cliente") {

    describe("propina segun estado de animo") {

      it("cliente enojado") {
        clienteSegunAnimoYBarrio.propinaSegunAnimo(350.0).shouldBe(0.0)
      }
      it("cliente feliz") {
        clienteSegunAnimoYBarrio.animo = FelizStrategy
        clienteSegunAnimoYBarrio.propinaSegunAnimo(500.0).shouldBe(125.0)
      }
      it("cliente indiferente con dinero en bolsillo monto original") {
        clienteSegunAnimoYBarrio.animo = IndiferenteStrategy
        clienteSegunAnimoYBarrio.propinaSegunAnimo(750.0).shouldBe(300.0)
      }
      it("cliente indiferente con dinero en bolsillo monto nuevo") {
        clienteSegunAnimoYBarrio.animo = IndiferenteStrategy
        clienteSegunAnimoYBarrio.dineroBolsillo = 400.0
        clienteSegunAnimoYBarrio.propinaSegunAnimo(750.0).shouldBe(400.0)
      }
      it("cliente resfriado") {
        clienteSegunAnimoYBarrio.animo = ResfriadoStrategy
        clienteSegunAnimoYBarrio.propinaSegunAnimo(1000.0).shouldBe(1000.0)
      }
    }

    describe("Un cliente de barrio Las Rosas") {
      it("propina que deja si esta enojado/a") {
        clienteSegunAnimoYBarrio.darPropina(350.0).shouldBe(50.0)
        clienteSegunAnimoYBarrio.darPropina(800.0).shouldBe(50.0)
      }
      it("propina que deja si esta feliz") {
        clienteSegunAnimoYBarrio.animo = FelizStrategy
        clienteSegunAnimoYBarrio.darPropina(800.0).shouldBe(250.0)
        clienteSegunAnimoYBarrio.darPropina(500.0).shouldBe(175.0)
      }
      it("propina que deja si esta indiferente con dinero en bolsillo monto original") {
        clienteSegunAnimoYBarrio.animo = IndiferenteStrategy
        clienteSegunAnimoYBarrio.darPropina(1000.0).shouldBe(350.0)
      }
      it("propina que deja si esta indiferente con dinero en bolsillo monto nuevo") {
        clienteSegunAnimoYBarrio.animo = IndiferenteStrategy
        clienteSegunAnimoYBarrio.dineroBolsillo = 750.0
        clienteSegunAnimoYBarrio.darPropina(1000.0).shouldBe(800.0)
      }
      it("propina que deja si esta resfriado") {
        clienteSegunAnimoYBarrio.animo = ResfriadoStrategy
        clienteSegunAnimoYBarrio.darPropina(600.0).shouldBe(650.0)
        clienteSegunAnimoYBarrio.darPropina(400.0).shouldBe(450.0)
      }
    }

    describe("Un cliente de barrio Las Lauchas") {
      clienteSegunAnimoYBarrio.barrio = LasLauchas

      it("propina que deja si esta enojado/a") {
        clienteSegunAnimoYBarrio.darPropina(800.0).shouldBe(0.0)
        clienteSegunAnimoYBarrio.darPropina(400.0).shouldBe(0.0)
      }
      it("propina que deja si esta feliz") {
        clienteSegunAnimoYBarrio.animo = FelizStrategy
        clienteSegunAnimoYBarrio.darPropina(500.0).shouldBe(62.5)
        clienteSegunAnimoYBarrio.darPropina(250.0).shouldBe(31.25)
      }
      it("propina que deja si esta indiferente con dinero en bolsillo monto original") {
        clienteSegunAnimoYBarrio.animo = IndiferenteStrategy
        clienteSegunAnimoYBarrio.darPropina(350.0).shouldBe(150.0)
      }
      it("propina que deja si esta indiferente con dinero en bolsillo monto nuevo") {
        clienteSegunAnimoYBarrio.animo = IndiferenteStrategy
        clienteSegunAnimoYBarrio.dineroBolsillo = 500.0
        clienteSegunAnimoYBarrio.darPropina(350.0).shouldBe(250.0)
      }
      it("propina que deja si esta resfriado") {
        clienteSegunAnimoYBarrio.animo = ResfriadoStrategy
        clienteSegunAnimoYBarrio.darPropina(1000.0).shouldBe(500.0)
        clienteSegunAnimoYBarrio.darPropina(750.0).shouldBe(375.0)
      }
    }

    describe("Un cliente del Barrio Verde") {
      clienteSegunAnimoYBarrio.barrio = BarrioVerde

      it("propina que deja si esta enojado/a") {
        clienteSegunAnimoYBarrio.darPropina(500.0).shouldBe(200.0)
        clienteSegunAnimoYBarrio.darPropina(350.0).shouldBe(200.0)
      }
      it("propina que deja si esta feliz") {
        clienteSegunAnimoYBarrio.animo = FelizStrategy
        clienteSegunAnimoYBarrio.darPropina(250.0).shouldBe(200.0)
        clienteSegunAnimoYBarrio.darPropina(850.0).shouldBe(212.5)
      }
      it("propina que deja si esta indiferente con dinero en bolsillo monto original") {
        clienteSegunAnimoYBarrio.animo = IndiferenteStrategy
        clienteSegunAnimoYBarrio.darPropina(750.0).shouldBe(300.0)
      }
      it("propina que deja si esta indiferente con dinero en bolsillo monto nuevo") {
        clienteSegunAnimoYBarrio.animo = IndiferenteStrategy
        clienteSegunAnimoYBarrio.dineroBolsillo = 150.0
        clienteSegunAnimoYBarrio.darPropina(750.0).shouldBe(200.0)
      }
      it("propina que deja si esta resfriado") {
        clienteSegunAnimoYBarrio.animo = ResfriadoStrategy
        clienteSegunAnimoYBarrio.darPropina(150.0).shouldBe(200.0)
        clienteSegunAnimoYBarrio.darPropina(1500.0).shouldBe(1500.0)
      }
    }

    describe("Un cliente del barrio Las Torres") {
      clienteSegunAnimoYBarrio.barrio = LasTorres

      it("propina que deja si esta enojado/a") {
        clienteSegunAnimoYBarrio.darPropina(200.0).shouldBe(0.0)
        clienteSegunAnimoYBarrio.darPropina(300.0).shouldBe(0.0)
      }
      it("propina que deja si esta feliz") {
        clienteSegunAnimoYBarrio.animo = FelizStrategy
        clienteSegunAnimoYBarrio.darPropina(650.0).shouldBe(162.5)
        clienteSegunAnimoYBarrio.darPropina(350.0).shouldBe(87.5)
      }
      it("propina que deja si esta indiferente con dinero en bolsillo monto original") {
        clienteSegunAnimoYBarrio.animo = IndiferenteStrategy
        clienteSegunAnimoYBarrio.darPropina(500.0).shouldBe(300.0)
      }
      it("propina que deja si esta indiferente con dinero en bolsillo monto nuevo") {
        clienteSegunAnimoYBarrio.animo = IndiferenteStrategy
        clienteSegunAnimoYBarrio.dineroBolsillo = 75.0
        clienteSegunAnimoYBarrio.darPropina(500.0).shouldBe(75.0)
      }
      it("propina que deja si esta resfriado") {
        clienteSegunAnimoYBarrio.animo = ResfriadoStrategy
        clienteSegunAnimoYBarrio.darPropina(250.0).shouldBe(250)
        clienteSegunAnimoYBarrio.darPropina(125.0).shouldBe(125)
      }
    }
  }
})
