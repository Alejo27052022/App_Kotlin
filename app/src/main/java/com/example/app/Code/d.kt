

package com.example.app.Code



class Calculadora {

    var numero1 : Double = 0.0
    var numero2 : Double = 0.0
    var resultado : Double = 0.0

    fun suma(){
        print("Ingrese el primer numero: ")
        numero1 = readLine().toString().toDouble()
        print("Ingrese el segundo numero: ")
        numero2= readLine().toString().toDouble()

        resultado = numero1 + numero2
        println(" La suma es: " + resultado)
    }

    fun resta(){
        print("Ingrese el primer numero: ")
        numero1 = readLine().toString().toDouble()
        print("Ingrese el segundo numero: ")
        numero2= readLine().toString().toDouble()

        resultado = numero1 - numero2
        println(" La resta es: " + resultado)
    }

    fun multiplicacion(){
        print("Ingrese el primer numero: ")
        numero1 = readLine().toString().toDouble()
        print("Ingrese el segundo numero: ")
        numero2 = readLine().toString().toDouble()

        resultado = numero1 * numero2
        println(" La mutliplicacion es: " + resultado)
    }

    fun division(){
        print("Ingrese el primer numero: ")
        numero1 = readLine().toString().toDouble()
        print("Ingrese el segundo numero: ")
        numero2 = readLine().toString().toDouble()
        println(" La division es: " + resultado)
    }
}
fun main() {
    val calculadora = Calculadora()

    var opcion: Int
    do {
        println("Seleccione una operación:")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("0. Salir")

        opcion = readLine()?.toIntOrNull() ?: -1

        when (opcion) {
            1, 2, 3, 4 -> {
                val resultado = when (opcion) {
                    1 -> calculadora.suma()
                    2 -> calculadora.resta()
                    3 -> calculadora.multiplicacion()
                    4 -> calculadora.division()
                    else -> throw IllegalArgumentException("Operación no válida.")
                }
                println("Resultado: $resultado")
            }
            0 -> println("Saliendo...")
            else -> println("Opción no válida. Inténtelo de nuevo.")
        }
        println()
    } while (opcion != 0)
}
