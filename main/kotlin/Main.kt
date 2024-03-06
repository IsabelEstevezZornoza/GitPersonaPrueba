fun main() {
    var persona : Persona = Persona()

    persona.pedirNombre()
    persona.pedirApellido()
    persona.pedirEdad()

    do {
        persona.dni()
        if (persona.dniValido) {
            println(persona)
        } else {
            println("El DNI es incorrecto.")
        }
    } while (!persona.dniValido)
}