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

## 📸 Tampilan Aplikasi
> *Silakan masukkan screenshot aplikasi Anda di sini*

| Halaman Utama | Validasi Kosong | Fitur Dial |
|---|---|---|
| ![Main](https://via.placeholder.com/200x400?text=Main+UI) | ![Validation](https://via.placeholder.com/200x400?text=Validation) | ![Dial](https://via.placeholder.com/200x400?text=Dial+Feature) |

## 🗄️ Struktur Database
Aplikasi ini menggunakan satu tabel utama bernama `contact_table`:

| Kolom | Tipe Data | Deskripsi |
|---|---|---|
| `id` | Integer | Primary Key (Auto-increment) |
| `name` | String | Nama lengkap kontak |
| `phone` | String | Nomor telepon kontak |

## 🚀 Cara Menjalankan
1. Clone repository ini:
   ```bash
   git clone https://github.com/USERNAME_ANDA/kontaku.git
