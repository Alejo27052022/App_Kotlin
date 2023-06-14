package com.example.app.Code

fun CalculoCanal(){
    var resultado:Float;
    var resultado_libra:Float;
    val razas = arrayOf("Aberdeen Angus", "Brahmán", "Charolais", "Hereford", "Limousin", "Nelore", "Brow Swiss", "Holstein", "Normado", "Jersey", "Gando de Lidia");
    println("Ingresa la raza de tu bovino");
    var raza_bovino = readLine().toString();

    when(raza_bovino){
        razas[0] -> {
            println("Ha elegido la raza " + razas[0])
            println("Su bovino es macho o hembra ")
            var sexo_bovino = readLine().toString();
            if(sexo_bovino == "macho"){
                println("Cuanto pesa su bovino macho")
                var peso = readLine()!!.toFloat();
                resultado = ((70.00/100) * peso).toFloat();
                resultado_libra = (resultado * 2.20462).toFloat();

                println("El Rendimiento de canal del peso de macho en Kg pesa " + resultado);
                println("El Rendimiento de canal del peso de macho en libra pesa " + resultado_libra);

            }
            else if (sexo_bovino == "hembra"){
                println("Cuanto pesa su bovino hembra")
                var peso = readLine()!!.toFloat();
                resultado = ((65.00/100) * peso).toFloat();
                resultado_libra = (resultado * 2.20462).toFloat();
                println("El Rendimiento de canal del peso de hembra en Kg pesa " + resultado);
                println("El Rendimiento de canal del peso de hembra en libra pesa " + resultado_libra);
            }
        }

        razas[1] -> {
            println("Ha elegido la raza " + razas[1])
            println("Su bovino es macho o hembra ")
            var sexo_bovino = readLine().toString();
            if(sexo_bovino == "macho"){
                println("Cuanto pesa su bovino macho")
                var peso = readLine()!!.toFloat();
                resultado = ((65.00/100) * peso).toFloat();


                println("El Rendimiento de canal del peso de macho en Kg pesa " + resultado);
            }
            else if (sexo_bovino == "hembra"){
                println("Cuanto pesa su bovino hembra")
                var peso = readLine()!!.toFloat();
                resultado = ((58.00/100) * peso).toFloat();

                println("El Rendimiento de canal del peso de hembra en Kg pesa " + resultado);
            }
        }
    }
    /*
    println(razas[0])
    println(razas[1])
    println(razas[2])
    println(razas[3])
    println(razas[4])
    println(razas[5])
    println(razas[6])
    println(razas[7])
    println(razas[8])
    println(razas[9])
    println(razas[10])

     */
}


fun main(){
    CalculoCanal();
}