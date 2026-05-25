package com.example.kontaku

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Kita daftarkan class Contact sebagai tabel, dan versinya adalah 1
@Database(entities = [Contact::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    // Menghubungkan database dengan perintah (DAO) yang kita buat tadi
    abstract fun contactDao(): ContactDao

    companion object {
        // @Volatile memastikan data database selalu yang terbaru di semua thread
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // Jika database belum ada, kita buat baru
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "contact_database" // Ini adalah nama file database di HP
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}