# UTS Pemrograman Berorientasi Obyek 2
<ul>
  <li>Mata Kuliah: Pemrograman Berorientasi Obyek 2</li>
  <li>Dosen Pengampu: <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Profil
<ul>
  <li>Nama: <a href="https://github.com/tech0608">Luthfy Arief</a></li>
  <li>NIM: 23552011045</li>
  <li>Studi Kasus: Kasir Properti</li>
</ul>

## Judul Studi Kasus
<p>Kasir Properti</p>

## Penjelasan Studi Kasus
<p>Aplikasi Kasir Properti dibuat untuk membantu perusahaan penyewaan rumah dan apartemen dalam mengelola data properti, penyewa, serta transaksi sewa. Sistem ini memungkinkan pengguna untuk menambahkan data properti dan penyewa, mencatat transaksi penyewaan berdasarkan durasi dan harga sewa, serta menghitung total pembayaran termasuk pajak berdasarkan jenis properti. Proyek ini dibangun menggunakan Java dengan pendekatan Object-Oriented Programming (OOP), dan terhubung ke database MySQL untuk penyimpanan data secara permanen.</p>

## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance
<p>Suatu kelas bisa mewarisi properti dan method dari kelas lain.</p>

#### Implementasi Inheritance dalam proyek:
<ul>
  <li>Properti mewarisi dari Aset:</li>
  
  ```java
  public class Properti extends Aset
  ```
  <li>Apartemen dan (berdasarkan kode di Main.java) juga Rumah mewarisi dari Properti:</li>
  
  ```java
  public class Apartemen extends Properti
  ```
</ul>
<p>Ini memungkinkan Apartemen dan Rumah memiliki semua properti dan method dari Aset dan Properti.</p>

### 2. Encapsulation
<p>Menyembunyikan detail implementasi dan hanya mengekspos metode untuk mengakses/mengubah data (getter/setter).</p>

#### Implementasi Encapsulation dalam Proyek:
<ul>
  <li>Di semua kelas model (Penyewa, Properti, Transaksi, Aset, Apartemen), atribut-atribut seperti id, nama, hargaSewa, dll disimpan sebagai private, dan diakses melalui getter/setter.</li>
  <li>Contoh dari Penyewa.java:</li>

```java
private int id;
private String nama;
private String kontak;

public String getNama() { return nama; }
public void setKontak(String kontak) { this.kontak = kontak; }
```
</ul>  


### 3. Polymorphism
<p>Kemampuan untuk memproses objek dari kelas turunan secara umum (melalui kelas induk) dan memungkinkan override method.</p>

#### Implementasi Polymorphism dalam Proyek:
<ul>
  <li>Di kelas Aset, hitungPajak() adalah method abstrak.</li>
  <li>Di Properti, method ini diimplementasikan (meskipun default 0).</li>
  <li>Di Apartemen, method ini di-override:</li>
  
```java
@Override
public double hitungPajak() {
    return getHargaSewa() * 0.15;
}
```
  <li>Dalam Main.java, objek Properti bisa berupa Rumah atau Apartemen:</li>

  ```java
Properti p = jenis.equalsIgnoreCase("Rumah") ?
    new Rumah(0, alamat, harga) :
    new Apartemen(0, alamat, harga);
```
</ul>  


### 4. Abstract
<p>Menyederhanakan kompleksitas program dengan hanya menampilkan detail yang penting dan menyembunyikan detail lainnya.</p>

#### Implementasi Abstract dalam Proyek:
<ul>
  <li>Kelas Aset adalah abstract class, dengan method abstrak hitungPajak().</li>

```java
public abstract class Aset {
    public abstract double hitungPajak();
}
``` 
</ul>


## Demo Proyek
<ul>
  <li>Github: <a href="https://github.com/tech0608/UTS_PBO2_TIF-RP-23-CNS-A_23552011045">Github</a></li>
  <li>Youtube: <a href="https://youtu.be/46Cp16eqOAg">Youtube</a></li>
</ul>
