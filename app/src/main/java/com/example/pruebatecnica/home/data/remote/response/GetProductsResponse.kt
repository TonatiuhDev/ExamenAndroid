package com.example.pruebatecnica.home.data.remote.response

data class GetProductsResponse(
    val mensaje: String = "",
    val advertencia: String = "",
    val resultado: Resultado = Resultado()
)

data class Resultado(
    val paginacion: Paginacion = Paginacion(),
    val categoria: String = "",
    val productos: ArrayList<Productos> = arrayListOf()
)

data class Paginacion(
    val pagina: Int = 0,
    val totalPaginas: Int = 0,
    val totalRegistros: Int = 0,
    val totalRegistrosPorPagina: Int = 0
)

data class Productos(
    val id: String = "",
    val idLinea: Int = 0,
    val codigoCategoria: String = "",
    val idModalidad: Int = 0,
    val relevancia: Int = 0,
    val lineaCredito: String = "",
    val pagoSemanalPrincipal: Int = 0,
    val plazoPrincipal: Int = 0,
    val disponibleCredito: Boolean = false,
    val abonosSemanales: ArrayList<Abonos> = arrayListOf(),
    val sku: String = "",
    val nombre: String = "",
    val urlImagenes: ArrayList<String> = arrayListOf(),
    val precioRegular: Double = 0.0,
    val precioFinal: Double = 0.0,
    val porcentajeDescuento: Double = 0.0,
    val descuento: Boolean = false,
    val precioCredito: Double = 0.0,
    val montoDescuento: Double = 0.0
)

data class Abonos(
    val plazo: Int = 0,
    val montoAbono: Int = 0,
    val montoDescuentoAbono: Int = 0,
    val montoUltimoAbono: Int = 0,
    val montoFinalCredito: Int = 0,
    val idPromocion: Int = 0,
    val montoDescuentoElektra: Int = 0,
    val montoDescuentoBanco: Int = 0,
    val precio: Int = 0,
    val montoAbonoDigital: Int = 0
)