package com.example.app.Pages
class Nombre {
    var id: Int = 0 //declara una variable id que será tipo enter
    var Nombrevaca: String? = null //declara una variable String
    var Descripcion: String? = null //declara una variable String
    var Fecha: String? = null //declara una variable String
    var Hora: String? = null //declara una variable String
    var Fecharinserta: String? = null //declara una variable String
    var Fecharetiro: String? = null //declara una variable String

    // indicar que a la variable es posible asignarle valores nulos
    constructor(id: Int, nombre: String,descripcion: String,fecha: String,hora: String,inserto: String,retiro: String) { //constructor de la clase

        this.id = id
        this.Nombrevaca = nombre
        this.Descripcion =descripcion
        this.Fecha = fecha
        this.Hora =hora
        this.Fecharinserta = inserto
        this.Fecharetiro =retiro

    }
    constructor(nombre: String,descripcion: String,fecha: String,hora: String,inserto: String,retiro: String) { //sobrecarga del constructor de la
        class Nombre
        this.Nombrevaca = nombre
        this.Descripcion =descripcion
        this.Fecha = fecha
        this.Hora =hora
        this.Fecharinserta = inserto
        this.Fecharetiro =retiro

    }
}
