# Kontaku - Aplikasi Manajemen Kontak Sederhana

**Kontaku** adalah aplikasi Android sederhana yang dibuat untuk memenuhi tugas kuis pengembangan aplikasi mobile. Aplikasi ini berfungsi untuk menyimpan daftar nama dan nomor telepon secara lokal di perangkat pengguna.

## 📱 Fitur Utama
- **Simpan Kontak:** Menambahkan nama dan nomor telepon ke database.
- **Validasi Input:** Mencegah penyimpanan jika kolom nama atau nomor kosong dengan peringatan Toast.
- **Daftar Kontak Elegan:** Menampilkan kontak dalam bentuk kartu (CardView) yang modern.
- **Fitur Panggil (Dial):** Klik ikon telepon pada daftar kontak untuk langsung membuka aplikasi dialer HP.
- **Penyimpanan Lokal (Persistence):** Data tetap tersimpan meski aplikasi ditutup atau HP dimatikan.
- **Satu Activity:** Mengikuti instruksi kuis dengan menggunakan arsitektur 1 Activity.

## 🛠️ Teknologi yang Digunakan
- **Bahasa:** [Kotlin](https://kotlinlang.org/)
- **Database:** [Room Persistence Library](https://developer.android.com/training/data-storage/room) (SQLite Abstraction)
- **UI Components:** RecyclerView, CardView, Material Design.
- **Concurrency:** Kotlin Coroutines (untuk operasi database yang ringan).
- **Architecture:** MVVM-ready (menggunakan LiveData/Flow untuk update data otomatis).

## 🗄️ Struktur Database
Aplikasi ini menggunakan satu tabel utama bernama `contact_table`:

| Kolom | Tipe Data | Deskripsi |
|---|---|---|
| `id` | Integer | Primary Key (Auto-increment) |
| `name` | String | Nama lengkap kontak |
| `phone` | String | Nomor telepon kontak |


## 🚀 Cara Menjalankan Proyek

Ikuti langkah-langkah berikut untuk menjalankan aplikasi **Kontaku** di perangkat lokal atau emulator Anda:

### 1. Prasyarat (Prerequisites)
Pastikan Anda sudah menginstal perangkat lunak berikut:
* **Android Studio** (Versi Flamingo | 2022.2.1 atau yang lebih baru disarankan).
* **JDK 17** (Bawaan Android Studio terbaru).
* **Android SDK** minimal versi 34 atau 35.

### 2. Kloning Repositori (Clone)
Buka terminal atau CMD, lalu jalankan perintah berikut:
```bash
git clone https://github.com/USERNAME_ANDA/kontaku.git
Atau, Anda bisa langsung mengunduh file ZIP dari tombol Code di atas dan mengekstraknya.

### 3. Membuka Proyek di Android Studio
Buka Android Studio.
Pilih File -> Open.
Arahkan ke folder hasil kloning/ekstrak tadi.
Klik OK dan tunggu Android Studio selesai melakukan Gradle Build (pastikan Anda terhubung ke internet untuk mendownload library pendukung).

### 4. Sinkronisasi Gradle (Jika Diperlukan)
Jika muncul peringatan Gradle Sync, klik tombol Sync Project with Gradle Files (ikon gajah) di toolbar atas. Pastikan tidak ada pesan error setelah proses selesai.

### 5. Menjalankan Aplikasi (Run)
Siapkan Emulator (AVD) melalui Device Manager atau sambungkan HP Android asli menggunakan kabel USB (pastikan USB Debugging aktif).
Pilih perangkat Anda di toolbar Android Studio.
Klik tombol Run (Ikon segitiga hijau ▶️) atau tekan tombol Shift + F10.
Tunggu proses instalasi selesai, dan aplikasi Kontaku akan muncul di layar.

### 6. Membuat File APK (Opsi Tambahan)
Jika Anda ingin membuat file instalasi (APK):
Klik menu Build -> Build Bundle(s) / APK(s) -> Build APK(s).
Setelah selesai, klik Locate untuk menemukan file app-debug.apk.
