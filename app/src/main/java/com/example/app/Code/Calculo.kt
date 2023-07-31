package com.example.app.Code
fun calcularPeso() {
    print("Ingrese el Perímetro Toráxico en Centímetros: ")
    val PT = readLine()?.toFloatOrNull() ?: 0.0f
    print("Ingrese el Largo del cuerpo en centímetros: ")
    val LC = readLine()?.toFloatOrNull() ?: 0.0f
    val constante = 10838
    val resultado = (PT * PT * LC) / constante
    println("El peso calculado es: $resultado KG")
}

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
                resultado_libra = (resultado * 2.20462).toFloat();

                println("El Rendimiento de canal del peso de macho en Kg pesa " + resultado);
                println("El Rendimiento de canal del peso de macho en libra pesa " + resultado_libra);

            }
            else if (sexo_bovino == "hembra"){
                println("Cuanto pesa su bovino hembra")
                var peso = readLine()!!.toFloat();
                resultado = ((58.00/100) * peso).toFloat();
                resultado_libra = (resultado * 2.20462).toFloat();

                println("El Rendimiento de canal del peso de hembra en Kg pesa " + resultado);
                println("El Rendimiento de canal del peso de hembra en libra pesa " + resultado_libra);

            }
        }

        razas[2] -> {
            println("Ha elegido la raza " + razas[2])
            println("Su bovino es macho o hembra ")
            var sexo_bovino = readLine().toString();
            if(sexo_bovino == "macho"){
                println("Cuanto pesa su bovino macho")
                var peso = readLine()!!.toFloat();
                resultado = ((63.00/100) * peso).toFloat();
                resultado_libra = (resultado * 2.20462).toFloat();

                println("El Rendimiento de canal del peso de macho en Kg pesa " + resultado);
                println("El Rendimiento de canal del peso de macho en libra pesa " + resultado_libra);

            }
            else if (sexo_bovino == "hembra"){
                println("Cuanto pesa su bovino hembra")
                var peso = readLine()!!.toFloat();
                resultado = ((58.00/100) * peso).toFloat();
                resultado_libra = (resultado * 2.20462).toFloat();

                println("El Rendimiento de canal del peso de hembra en Kg pesa " + resultado);
                println("El Rendimiento de canal del peso de hembra en libra pesa " + resultado_libra);

            }
        }

        razas[3] -> {
            println("Ha elegido la raza " + razas[3])
            println("Su bovino es macho o hembra ")
            var sexo_bovino = readLine().toString();
            if(sexo_bovino == "macho"){
                println("Cuanto pesa su bovino macho")
                var peso = readLine()!!.toFloat();
                resultado = ((60.00/100) * peso).toFloat();
                resultado_libra = (resultado * 2.20462).toFloat();

                println("El Rendimiento de canal del peso de macho en Kg pesa " + resultado);
                println("El Rendimiento de canal del peso de macho en libra pesa " + resultado_libra);

            }
            else if (sexo_bovino == "hembra"){
                println("Cuanto pesa su bovino hembra")
                var peso = readLine()!!.toFloat();
                resultado = ((58.00/100) * peso).toFloat();
                resultado_libra = (resultado * 2.20462).toFloat();

                println("El Rendimiento de canal del peso de hembra en Kg pesa " + resultado);
                println("El Rendimiento de canal del peso de hembra en libra pesa " + resultado_libra);

            }
        }

        razas[4] -> {
            println("Ha elegido la raza " + razas[4])
            println("Su bovino es macho o hembra ")
            var sexo_bovino = readLine().toString();
            if(sexo_bovino == "macho"){
                println("Cuanto pesa su bovino macho")
                var peso = readLine()!!.toFloat();
                resultado = ((58.00/100) * peso).toFloat();
                resultado_libra = (resultado * 2.20462).toFloat();

                println("El Rendimiento de canal del peso de macho en Kg pesa " + resultado);
                println("El Rendimiento de canal del peso de macho en libra pesa " + resultado_libra);

            }
            else if (sexo_bovino == "hembra"){
                println("Cuanto pesa su bovino hembra")
                var peso = readLine()!!.toFloat();
                resultado = ((55.00/100) * peso).toFloat();
                resultado_libra = (resultado * 2.20462).toFloat();

                println("El Rendimiento de canal del peso de hembra en Kg pesa " + resultado);
                println("El Rendimiento de canal del peso de hembra en libra pesa " + resultado_libra);

            }
        }

        razas[5] -> {
            println("Ha elegido la raza " + razas[5])
            println("Su bovino es macho o hembra ")
            var sexo_bovino = readLine().toString();
            if(sexo_bovino == "macho"){
                println("Cuanto pesa su bovino macho")
                var peso = readLine()!!.toFloat();
                resultado = ((54.60/100) * peso).toFloat();
                resultado_libra = (resultado * 2.20462).toFloat();

                println("El Rendimiento de canal del peso de macho en Kg pesa " + resultado);
                println("El Rendimiento de canal del peso de macho en libra pesa " + resultado_libra);

            }
            else if (sexo_bovino == "hembra"){
                println("Cuanto pesa su bovino hembra")
                var peso = readLine()!!.toFloat();
                resultado = ((50.80/100) * peso).toFloat();
                resultado_libra = (resultado * 2.20462).toFloat();

                println("El Rendimiento de canal del peso de hembra en Kg pesa " + resultado);
                println("El Rendimiento de canal del peso de hembra en libra pesa " + resultado_libra);

            }
        }

        razas[6] -> {
            println("Ha elegido la raza " + razas[6])
            println("Su bovino es macho o hembra ")
            var sexo_bovino = readLine().toString();
            if(sexo_bovino == "macho"){
                println("Cuanto pesa su bovino macho")
                var peso = readLine()!!.toFloat();
                resultado = ((51.29/100) * peso).toFloat();
                resultado_libra = (resultado * 2.20462).toFloat();

                println("El Rendimiento de canal del peso de macho en Kg pesa " + resultado);
                println("El Rendimiento de canal del peso de macho en libra pesa " + resultado_libra);

            }
            else if (sexo_bovino == "hembra"){
                println("Cuanto pesa su bovino hembra")
                var peso = readLine()!!.toFloat();
                resultado = ((51.29/100) * peso).toFloat();
                resultado_libra = (resultado * 2.20462).toFloat();

                println("El Rendimiento de canal del peso de hembra en Kg pesa " + resultado);
                println("El Rendimiento de canal del peso de hembra en libra pesa " + resultado_libra);

            }
        }

        razas[7] -> {
            println("Ha elegido la raza " + razas[7])
            println("Su bovino es macho o hembra ")
            var sexo_bovino = readLine().toString();
            if(sexo_bovino == "macho"){
                println("Cuanto pesa su bovino macho")
                var peso = readLine()!!.toFloat();
                resultado = ((56.41/100) * peso).toFloat();
                resultado_libra = (resultado * 2.20462).toFloat();

                println("El Rendimiento de canal del peso de macho en Kg pesa " + resultado);
                println("El Rendimiento de canal del peso de macho en libra pesa " + resultado_libra);

            }
            else if (sexo_bovino == "hembra"){
                println("Cuanto pesa su bovino hembra")
                var peso = readLine()!!.toFloat();
                resultado = ((56.07/100) * peso).toFloat();
                resultado_libra = (resultado * 2.20462).toFloat();

                println("El Rendimiento de canal del peso de hembra en Kg pesa " + resultado);
                println("El Rendimiento de canal del peso de hembra en libra pesa " + resultado_libra);

            }
        }

        razas[8] -> {
            println("Ha elegido la raza " + razas[8])
            println("Su bovino es macho o hembra ")
            var sexo_bovino = readLine().toString();
            if(sexo_bovino == "macho"){
                println("Cuanto pesa su bovino macho")
                var peso = readLine()!!.toFloat();
                resultado = ((56.00/100) * peso).toFloat();
                resultado_libra = (resultado * 2.20462).toFloat();

                println("El Rendimiento de canal del peso de macho en Kg pesa " + resultado);
                println("El Rendimiento de canal del peso de macho en libra pesa " + resultado_libra);

            }
            else if (sexo_bovino == "hembra"){
                println("Cuanto pesa su bovino hembra")
                var peso = readLine()!!.toFloat();
                resultado = ((55.00/100) * peso).toFloat();
                resultado_libra = (resultado * 2.20462).toFloat();

                println("El Rendimiento de canal del peso de hembra en Kg pesa " + resultado);
                println("El Rendimiento de canal del peso de hembra en libra pesa " + resultado_libra);

            }
        }

        razas[9] -> {
            println("Ha elegido la raza " + razas[9])
            println("Su bovino es macho o hembra ")
            var sexo_bovino = readLine().toString();
            if(sexo_bovino == "macho"){
                println("Cuanto pesa su bovino macho")
                var peso = readLine()!!.toFloat();
                resultado = ((63.00/100) * peso).toFloat();
                resultado_libra = (resultado * 2.20462).toFloat();

                println("El Rendimiento de canal del peso de macho en Kg pesa " + resultado);
                println("El Rendimiento de canal del peso de macho en libra pesa " + resultado_libra);

            }
            else if (sexo_bovino == "hembra"){
                println("Cuanto pesa su bovino hembra")
                var peso = readLine()!!.toFloat();
                resultado = ((55.00/100) * peso).toFloat();
                resultado_libra = (resultado * 2.20462).toFloat();

                println("El Rendimiento de canal del peso de hembra en Kg pesa " + resultado);
                println("El Rendimiento de canal del peso de hembra en libra pesa " + resultado_libra);

            }
        }

        razas[10] -> {
            println("Ha elegido la raza " + razas[10])
            println("Su bovino es macho o hembra ")
            var sexo_bovino = readLine().toString();
            if(sexo_bovino == "macho"){
                println("Cuanto pesa su bovino macho")
                var peso = readLine()!!.toFloat();
                resultado = ((62.45/100) * peso).toFloat();
                resultado_libra = (resultado * 2.20462).toFloat();

                println("El Rendimiento de canal del peso de macho en Kg pesa " + resultado);
                println("El Rendimiento de canal del peso de macho en libra pesa " + resultado_libra);

            }
            else if (sexo_bovino == "hembra"){
                println("Cuanto pesa su bovino hembra")
                var peso = readLine()!!.toFloat();
                resultado = ((58.00/100) * peso).toFloat();
                resultado_libra = (resultado * 2.20462).toFloat();

                println("El Rendimiento de canal del peso de hembra en Kg pesa " + resultado);
                println("El Rendimiento de canal del peso de hembra en libra pesa " + resultado_libra);

            }
        }

    }
}

fun Calcular(){
    val constante_animal = 400;
    print("Ingrese las unidades de animal de novillo: ")
    val novillo = readLine()?.toFloatOrNull() ?: 0.0f
    print("Ingrese el peso del animal")
    val peso = readLine()?.toFloatOrNull()?: 0.0f
    print("Ingrese las hectareas")
    val hectareas = readLine()?.toFloatOrNull()?: 0.0f

    val res_un_animal = (peso/constante_animal)
    println(res_un_animal)

    val res_hec_animal = (res_un_animal * novillo)/hectareas
    println(res_hec_animal)

}
fun main(){
    Calcular();
    //CalculoCanal();
    //calcularPeso();
}