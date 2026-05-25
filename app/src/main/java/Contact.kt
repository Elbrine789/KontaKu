package com.example.kontaku // Pastikan baris ini sesuai dengan nama package Anda

import androidx.room.Entity
import androidx.room.PrimaryKey

// @Entity memberitahu Room bahwa class ini adalah tabel database
@Entity(tableName = "contact_table")
data class Contact(
    // @PrimaryKey membuat 'id' unik untuk tiap data. 
    // autoGenerate = true artinya nomor 1, 2, 3... akan dibuat otomatis oleh sistem.
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    // Ini adalah kolom untuk menyimpan Nama
    val name: String,

    // Ini adalah kolom untuk menyimpan Nomor Telepon
    val phone: String
)