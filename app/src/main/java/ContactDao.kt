package com.example.kontaku

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    // Perintah untuk memasukkan data baru ke tabel
    // 'suspend' artinya fungsi ini dijalankan di latar belakang (agar aplikasi tidak lag)
    @Insert
    suspend fun insert(contact: Contact)

    // Perintah untuk mengambil SEMUA data dari tabel 'contact_table'
    // Urutkan berdasarkan Nama secara alfabetis (ASC)
    // Kita gunakan Flow agar tampilan aplikasi otomatis update jika ada data baru
    @Query("SELECT * FROM contact_table ORDER BY name ASC")
    fun getAllContacts(): Flow<List<Contact>>
}