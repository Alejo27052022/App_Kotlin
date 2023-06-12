package com.example.app.Pages

fun numeros(){
    print("Ingrese el primer numero: ")
    var num1: Int = readLine().toString().toInt()
    print("Ingrese el segundo numero: ")
    var num2: Int = readLine().toString().toInt()
    print("Ingrese el tercer numero: ")
    var num3: Int = readLine().toString().toInt()

    if (num1 > num2){
        println("El numero mayor es " + num1)
    }else if (num3 > num2){
        println("El numero mayor es " + num3)
    }else{
        println("El numero mayor es " + num2)
    }
}

fun factorial(){
    print("Ingrese hasta que numero deseas calcular ")
    var num: Int = readLine().toString().toInt()
    var factorial: Long = 1

    for(i in 1..num){
        factorial *= i.toLong()
    }
    println("Factorial del numero hasta $num = $factorial")
}

fun num_while(){
    var i:Int = 0
    while(i <= 9){
        println(i++)
    }
}

fun num_dowhile(){
    var i:Int = 0
    do {
        println(i++)
    } while (i<=9)
}

fun calculadora(){
    println("Ingrese la operacion que quiere elegir ")
    println("1. Suma")
    println("2. Resta")
    println("3. Multiplicacion")
    println("4. Division")
    var opcion:Int = readLine().toString().toInt()

    when(opcion){
        1 -> {
            println("La operacion que elegio es Suma")
            println("Ingrese el primer numero")
            var num1:Int = readLine().toString().toInt()
            println("Ingrese el segundo numero")
            var num2:Int = readLine().toString().toInt()
            println("El resultado de la suma es: " + (num1+num2))
        }
        2 -> {
            println("La operacion que elegio es Resta")
            println("Ingrese el primer numero")
            var num1:Int = readLine().toString().toInt()
            println("Ingrese el segundo numero")
            var num2:Int = readLine().toString().toInt()
            println("El resultado de la resta es: " + (num1-num2))
        }
        3 -> {
            println("La operacion que elegio es Multiplicacion")
            println("Ingrese el primer numero")
            var num1:Int = readLine().toString().toInt()
            println("Ingrese el segundo numero")
            var num2:Int = readLine().toString().toInt()
            println("El resultado de la multiplicacion es: " + (num1*num2))
        }
        4 -> {
            println("La operacion que elegio es Division")
            println("Ingrese el primer numero")
            var num1:Int = readLine().toString().toInt()
            println("Ingrese el segundo numero")
            var num2:Int = readLine().toString().toInt()
            println("El resultado de la division es: " + (num1/num2))
        }


    }
}

fun main(){
    /*
    print("Ingrese su nombre:")
    var nombre: String = readLine().toString()
    print("Ingrese la edad:")
    var edad: Int = readLine().toString().toInt()

    if(edad > 18){
        println ("Usted con nombre " + nombre + " es mayor de edad con " + edad + " años")
    }else{
        println ("Usted con nombre " + nombre + "es menor de edad con " + edad + " años")
    }
    */
    //numeros()
    //factorial()
    //num_while
    //num_dowhile()
    calculadora()
}