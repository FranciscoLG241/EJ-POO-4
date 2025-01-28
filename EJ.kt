

class coche(color: String,
            marca: String,
            modelo: String,
            numCaballos: Int,
            numPuertas: Int,
            matricula: String){



    var color: String = color
        set(value){
            require(value.isNotEmpty()){"El color no puede estar vacío"}
            require(value.length in 1..20){"El nombre del color no puede pasar los 20 caracteres"}
            field = value
        }



    var matricula: String = matricula
        set (value){
            require(value.length == 7){"La matrícula debe de tener 7 caracteres"}
            field = value
        }


    var modelo: String = modelo
        get () = field.replaceFirstChar { it.uppercase() }
        private set (value){
            field = value.replaceFirstChar { it.uppercase() }

        }


    var numCaballos: Int = numCaballos
        set(value){
            require(numCaballos in 70..700){"El número de caballos debe de estar entre 70 y 700"}
            field = value
        }


    var numPuertas: Int = numPuertas
        set(value){
            require(numPuertas in 3..5){"El número de puertas debe de estar entre 3 y 5"}
            field = value
        }



    init {
        require(marca.isNotEmpty()){"La marca no puede estar vacía"}
        require(modelo.isNotEmpty()){"El modelo no puede estar vacío"}
        require(numCaballos > 0){"El número de caballos debe de ser mayoe que 0"}
        require(numPuertas > 0){"El número de puertas debe de ser mayor que 0"}

    }

    override fun toString(): String {
        return "Vehículo(modelo= $modelo, caballos= $numCaballos, puertas= $numPuertas, matrícula= $matricula, color= $color)"
    }
}




fun main() {

    val coche1 = coche("Rojo", "Corolla", "RGEGE", 456, 5, "FRTHYUK")
    val coche2 = coche("Negro", "Civic", "JJYJ", 345, 3, "KYGRDCV")
    val coche3 = coche("Azul", "Focus", "RYHR", 678, 4, "HNJKLOI")

    println(coche1)
    println(coche2)
    println(coche3)

    coche1.color = "Verde"
    coche2.color = "Blanco"
    coche3.color = "Gris"

    coche1.numCaballos = 180

    coche2.numPuertas = 4

    println(coche1)
    println(coche2)
    println(coche3)


    try {
        val cocheInvalido1 = coche("Verde", "Civic", "RGGE", 500, 8, "FEWFTGH")
    } catch (e: IllegalArgumentException) {
        println("Error al crear coche: ${e.message}")
    }

    try {

        val cocheInvalido2 = coche("AZUL", "Corolla", "TRH", 4, 3, "JUYTGHF")
    } catch (e: IllegalArgumentException) {
        println("Error al crear coche: ${e.message}")
    }

    try {
        coche1.numCaballos = 800
    } catch (e: IllegalArgumentException) {
        println("Error al modificar caballos: ${e.message}")
    }

    try {
        coche2.numPuertas = 2
    } catch (e: IllegalArgumentException) {
        println("Error al modificar puertas: ${e.message}")
    }

    try {
        coche3.matricula = "12345"
    } catch (e: IllegalArgumentException) {
        println("Error al modificar matrícula: ${e.message}")
    }

    try {
        coche1.color = ""
    } catch (e: IllegalArgumentException) {
        println("Error al modificar color: ${e.message}")
    }

    try {
        val cocheInvalido3 = coche("", "Focus", "TGT", 345, 4, "GTYHJUI")
    } catch (e: IllegalArgumentException) {
        println("Error al crear coche: ${e.message}")
    }
}