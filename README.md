
![header](https://raw.githubusercontent.com/sandrocods/Tugas-Besar-Pemrograman-2/master/screenshot/header%20sianjelau.png)

***SI***stem ***AN***tar ***JE***mput ***LAU***ndry. Merupakan sebuah sistem aplikasi berbasis GUI yang dibuat dengan Java Swing yang dapat membantu pengelolaan transaksi laundry. Aplikasi ini terhubung dengan database Mysql untuk penyimpanan data dan terdapat notifikasi otomatis menggunakan Whatsapp Gateway

## Fitur Aplikasi

| Fitur             | Tersedia                                                               |
| ----------------- | ------------------------------------------------------------------ |
| MultiThread Update Status | ✔ |
| Send Notification Whatsapp | ✔ |
| Report by Date | ✔ |
| Multi Role Login | ✔ |


## Aplikasi Pendukung
Aplikasi Pendukung ini dibutuhkan agar aplikasi Sianjelau dapat berjalan dengan lancar

 - [Xampp](https://www.apachefriends.org/download.html)
 - [Java](https://www.java.com/download/ie_manual.jsp)
 - [JDK](https://download.oracle.com/java/19/latest/jdk-19_windows-x64_bin.msi)

Setelah download semua aplikasi diatas , lakukan instalasi seperti biasa



## Installasi Aplikasi

#### Download / Git clone Repository ini

```bash
  git clone https://github.com/sandrocods/Tugas-Besar-Pemrograman-2
```

#### Eksekusi Sql Query
-   Buka dan login pada Phpmyadmin anda
-   Buat database baru dengan nama db_sianjelo ( Seperti pada gambar dibawah ini )
    ![db](https://raw.githubusercontent.com/sandrocods/Tugas-Besar-Pemrograman-2/master/screenshot/image.png)
-    Lakukan import file sql, File SQL berada pada folder yang telah di git sebelumnya ( seperti pada gambar dibawah ini )
     ![db_2](https://raw.githubusercontent.com/sandrocods/Tugas-Besar-Pemrograman-2/master/screenshot/import_db.png)

Jika seluruh proses diatas telah dilakukan maka akan tampil seperti pada gambar dibawah ini menandakan import SQL telah berhasil

![db_3](https://raw.githubusercontent.com/sandrocods/Tugas-Besar-Pemrograman-2/master/screenshot/import_db_success.png)


#### Menjalankan Aplikasi
-    Klik 2x pada file Tugas Besar.jar
     ![db_4](https://raw.githubusercontent.com/sandrocods/Tugas-Besar-Pemrograman-2/master/screenshot/ezgif-4-79b547b2f0.gif)
## Screenshots
#### Landing Page
![App Screenshot](https://raw.githubusercontent.com/sandrocods/Tugas-Besar-Pemrograman-2/master/screenshot/1.png)


#### Login Page
![App Screenshot](https://raw.githubusercontent.com/sandrocods/Tugas-Besar-Pemrograman-2/master/screenshot/2.png)

Pada login page ini user akan diminta memasukan username dan password yang telah terdaftar sebagai Karyawan / Admin, Terdapat fitur show hide password untuk menjaga keamanan password.

#### Dashboard Page
![App Screenshot](https://raw.githubusercontent.com/sandrocods/Tugas-Besar-Pemrograman-2/master/screenshot/3.png)

Pada dashboard page ini manmpilkan beberapa informasi seperti total user, total transaksi, total member, semua informasi dalam dashboard page ini diupdate secara realtime dari database dengan menggunakan multithread

#### Module Manage User 
![App Screenshot](https://raw.githubusercontent.com/sandrocods/Tugas-Besar-Pemrograman-2/master/screenshot/4.png)

Pada halaman manage user ini menampilkan beberapa informasi user yang terdaftar sebagai karyawan / admin 
dan dapat melakukan pencarian data berdasarkan nama. melakukan oprasi CRUD pada umumnya

#### Module Manage Member
![App Screenshot](https://raw.githubusercontent.com/sandrocods/Tugas-Besar-Pemrograman-2/master/screenshot/5.png)

Pada halaman manage member ini menampilkan beberapa informasi member yang terdaftar tetap sebagai pelanggan laundry terdapat fitur point dimana point tersebut dapat bertambah seiring member bertransaksi dan dapat melakukan pencarian data berdasarkan nama. melakukan oprasi CRUD pada umumnya

#### Module Manage Paket
![App Screenshot](https://raw.githubusercontent.com/sandrocods/Tugas-Besar-Pemrograman-2/master/screenshot/6.png)

Pada halaman manage paket ini menampilkan beberapa informasi paket yang tersedia di laundry dan dapat melakukan pencarian data berdasarkan nama. melakukan oprasi CRUD pada umumnya

#### Module Transaksi
![App Screenshot](https://raw.githubusercontent.com/sandrocods/Tugas-Besar-Pemrograman-2/master/screenshot/7.png)

Pada halaman transaksi ini dapat melakukan proses transaksi dengan memilih member yang telah terdaftar sebelumnya kemudian dapat menggunakan point member, memilih jenis paket laundry dan menentukan jumlahnya dan operasi perhitungan lainya

#### Module Update Transaksi
![App Screenshot](https://raw.githubusercontent.com/sandrocods/Tugas-Besar-Pemrograman-2/master/screenshot/8.png)

Pada halaman update transaksi ini dapat melakukan proses update transaksi dengan memilih member yang telah terdaftar sebelumnya kemudian mengganti status proses seperti dalam pengantaran , proses jemput , proses pengerjaan. dapat mengganti status transaksi yang sebelumnya belum dibayar menjadi dibayar.

#### Module Report
![App Screenshot](https://raw.githubusercontent.com/sandrocods/Tugas-Besar-Pemrograman-2/master/screenshot/9.png)

Pada halaman report ini dapat melihat informasi laporan transaksi pada tanggal yang telah ditentukan

#### Module Setting Aplikasi
![App Screenshot](https://raw.githubusercontent.com/sandrocods/Tugas-Besar-Pemrograman-2/master/screenshot/10.png)

Pada halaman setting aplikasi dapat mengaktifkan fitur notifikasi otomatis kirim ke whatsaap nomor pelanggan saat melakukan update transaksi ( [Setting Tambahan untuk whatsaap gateway dapat dilihat disini ](https://github.com/sandrocods/Tugas-Besar-Pemrograman-2/new/master?readme=1#setting-whatsapp-gateway-notifikasi))


## Setting WhatsApp Gateway Notifikasi

- Lakukan Git clone pada project WhatsAppBlaster berikut : https://github.com/sandrocods/WhatsappBlaster
- Ikuti langkah langakah instalasi pada project WhatsAppBlaster diatas
- Copy link API yang tampil di browser anda , simpan padaa aplikasi Sianjelau
- Jangan lupa Melakukan Autentikasi sebelum melakukan kirim pesan

## Video Demo Notifikasi WhatsApp Otomatis



https://user-images.githubusercontent.com/59155826/215007635-77cf8371-d6dd-4a26-aee3-a738a76b235d.mp4



## Team

Aplikasi ini dibuat untuk memenuhi tugas besar matakuliah PBO dirancang dan dibuat oleh :

- [Martinus Krisandro Perdana Putra (21104059)](https://github.com/sandrocods)
- [Rizfan Herlaya (21104049)](https://github.com/Rizfan/)
- [Muhammad Haikal Faruq (21104037)](https://github.com/HaikalFaruq)
- [Airlangga Maulana Anwar (21104050)](https://github.com/Angga21104050)
