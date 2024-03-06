class Persona {
    var nombre : String = ""
    var apellido : String = ""
    var edad : Int? = 0
    var dni : String = ""
    var dniValido : Boolean = false

    fun pedirNombre() {
        do {
            println("¿Cuál es tu nombre?")
            nombre = readln().lowercase()
        } while (!(nombre.all { it in 'a'..'z' } && nombre.length in 2..20))
    }

    fun pedirApellido() {
        do {
            println("¿Cuál es tu apellido?")
            apellido = readln().lowercase()
        } while (!(apellido.all { it in 'a'..'z' } && apellido.length in 2..20))
    }

    fun pedirEdad() {
        println("¿Cuántos años tienes?")
        do {
            edad = readln().toIntOrNull()
            if (edad in 1..150) {
                if (edad != null) {
                    when {
                        edad!! <= 11 -> println("Infantil")
                        edad in 12..17 -> println("Adolescencia")
                        edad in 18..25 -> println("Juventud")
                        edad in 26..59 -> println("Adultez")
                        else -> println("Vejez")
                    }
                }
            } else {
                println("La edad introducida no está en el rango válido (1-150).")
            }

        }while (edad!! <0 || edad!! >150)
    }

    fun dni(): Boolean {
        var dniLetra: String
        var dniNumeros: String
        val NUMEROS: String = "0123456789"
        val RESTO: String = "TRWAGMYFPDXBNJZSQVHLCKE"

        do {
            do {
                println("Introduce tu DNI:")
                dni = readln()
            } while (dni == "" || dni.length != 9)

            dniNumeros = dni.substring(0, 8)
            dniLetra = dni.substring(8).uppercase()

            var esLetra = false
            var sonNumeros = false
            var contador = 0

            for (i in dniNumeros) {
                if (NUMEROS.contains(i) && contador == 0) {
                    sonNumeros = true
                } else {
                    sonNumeros = false
                    contador++
                }
            }
            if (RESTO.contains(dniLetra)) {
                esLetra = true
            }
        } while (!esLetra || !sonNumeros)

        val CALCULO = dniNumeros.toInt() % 23

        if (RESTO[CALCULO].toString() == dniLetra) {
            //println("El DNI es válido.")
            dniValido = true
        } else {
            //println("DNI incorrecto.")
            dniValido = false
        }
        return dniValido
    }

    override fun toString(): String {
        return "$nombre $apellido tiene $edad años y su DNI es: $dni."
    }

}