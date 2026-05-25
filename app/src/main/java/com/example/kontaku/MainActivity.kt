package com.example.kontaku

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    // Mendefinisikan variabel untuk database dan adapter
    private lateinit var database: AppDatabase
    private lateinit var contactAdapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Inisialisasi Database Room
        database = AppDatabase.getDatabase(this)

        // 2. Hubungkan variabel dengan elemen UI di XML
        val etName = findViewById<EditText>(R.id.etName)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val rvContacts = findViewById<RecyclerView>(R.id.rvContacts)

        // 3. Setup RecyclerView (Tempat menampilkan daftar)
        // Kita mulai dengan daftar kosong (emptyList)
        contactAdapter = ContactAdapter(emptyList())
        rvContacts.layoutManager = LinearLayoutManager(this)
        rvContacts.adapter = contactAdapter

        // 4. Observasi Data dari Database (Fitur Otomatis Update)
        // Setiap ada perubahan di database, tampilan daftar akan langsung berubah
        database.contactDao().getAllContacts().asLiveData().observe(this) { daftarKontak ->
            contactAdapter.updateData(daftarKontak)
        }

        // 5. Logika ketika Tombol SIMPAN ditekan
        btnSave.setOnClickListener {
            val nama = etName.text.toString().trim()
            val telepon = etPhone.text.toString().trim()

            // VALIDASI: Cek jika input masih kosong
            if (nama.isEmpty() || telepon.isEmpty()) {
                // Tampilkan pesan error jika kosong
                Toast.makeText(this, "Nama dan Nomor tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            } else {
                // Jika isi, buat objek kontak baru
                val kontakBaru = Contact(name = nama, phone = telepon)

                // SIMPAN KE DATABASE (Wajib menggunakan Coroutine/lifecycleScope)
                lifecycleScope.launch {
                    database.contactDao().insert(kontakBaru)

                    // Bersihkan kotak input setelah berhasil simpan
                    etName.text.clear()
                    etPhone.text.clear()

                    // Tampilkan pesan sukses
                    Toast.makeText(this@MainActivity, "Kontak berhasil disimpan", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}