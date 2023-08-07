package com.example.app.Pages
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
class ayudaDb(
    context: Context,
    factory: SQLiteDatabase.CursorFactory?
) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "nombres.db"
        const val TABLE_NAME = "tnombres"
        const val COLUMN_ID = "_id"
        const val COLUMN_NOMBRE = "nombre"
        const val COLUMN_DESCRICPCION = "descripción"
        const val COLUMN_FECHA = "fecha"
        const val COLUMN_HORA = "hora"
        const val COLUMN_FECHAINSERTO = "fechainserto"
        const val COLUMN_FECHARETIRO = "fecharetiro"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_PRODUCTS_TABLE = ("CREATE TABLE " +
                TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NOMBRE + " TEXT," +
                COLUMN_DESCRICPCION + " TEXT," +
                COLUMN_FECHA + " TEXT," +
                COLUMN_HORA + " TEXT," +
                COLUMN_FECHAINSERTO + " TEXT," +
                COLUMN_FECHARETIRO + " TEXT" + ")")
        db?.execSQL(CREATE_PRODUCTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addName(persona: Persona) {
        val values = ContentValues()
        values.put(COLUMN_NOMBRE, persona.nombre)
        values.put( COLUMN_DESCRICPCION, persona.descripcion)
        values.put(COLUMN_FECHA, persona.fecha)
        values.put(COLUMN_HORA, persona.hora)
        values.put(COLUMN_FECHAINSERTO, persona.inserto)
        values.put(COLUMN_FECHARETIRO, persona.retiro)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getAllName(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT $COLUMN_ID, $COLUMN_NOMBRE, $COLUMN_DESCRICPCION, $COLUMN_FECHA, $COLUMN_HORA, $COLUMN_FECHAINSERTO,$COLUMN_FECHARETIRO FROM $TABLE_NAME", null)
    }
}

data class Persona(val nombre: String, val descripcion: String, val fecha: String, val hora: String, val inserto: String, val retiro: String,)
