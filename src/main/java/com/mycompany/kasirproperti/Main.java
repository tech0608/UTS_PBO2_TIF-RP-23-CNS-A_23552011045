package com.mycompany.kasirproperti;

import com.mycompany.kasirproperti.model.*;
import com.mycompany.kasirproperti.service.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PropertiService propertiService = new PropertiService();
        PenyewaService penyewaService = new PenyewaService();
        TransaksiService transaksiService = new TransaksiService();

        while (true) {
            System.out.println("\n=== KASIR PROPERTI ===");
            System.out.println("1. Tambah Properti");
            System.out.println("2. Tambah Penyewa");
            System.out.println("3. Lihat Properti");
            System.out.println("4. Lihat Penyewa");
            System.out.println("5. Tambah Transaksi");
            System.out.println("6. Lihat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            int pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1 -> {
                    System.out.print("Jenis (Rumah/Apartemen): ");
                    String jenis = sc.nextLine();
                    System.out.print("Alamat: ");
                    String alamat = sc.nextLine();
                    System.out.print("Harga sewa: ");
                    double harga = sc.nextDouble();

                    Properti p = jenis.equalsIgnoreCase("Rumah") ?
                        new Rumah(0, alamat, harga) :
                        new Apartemen(0, alamat, harga);

                    propertiService.tambahProperti(p);
                }

                case 2 -> {
                    System.out.print("Nama penyewa: ");
                    String nama = sc.nextLine();
                    System.out.print("Kontak: ");
                    String kontak = sc.nextLine();
                    penyewaService.tambahPenyewa(new Penyewa(0, nama, kontak));
                }

                case 3 -> {
                    var list = propertiService.getAllProperti();
                    for (Properti p : list) {
                        System.out.printf("[%s] %s | Rp%.2f | Pajak: Rp%.2f\n",
                            p.getJenis(), p.getAlamat(), p.getHargaSewa(), p.hitungPajak());
                    }
                }

                case 4 -> {
                    var list = penyewaService.getAllPenyewa();
                    for (Penyewa p : list) {
                        System.out.printf("[%d] %s | %s\n", p.getId(), p.getNama(), p.getKontak());
                    }
                }

                case 5 -> {
                    System.out.print("ID Properti: ");
                    int pid = sc.nextInt();
                    System.out.print("ID Penyewa: ");
                    int sid = sc.nextInt();
                    System.out.print("Durasi sewa (bulan): ");
                    int durasi = sc.nextInt();

                    List<Properti> propertiList = propertiService.getAllProperti();
                    double harga = 0;
                    for (Properti p : propertiList) {
                        if (p.getId() == pid) {
                            harga = p.getHargaSewa();
                            break;
                        }
                    }

                    double total = harga * durasi;
                    transaksiService.tambahTransaksi(new Transaksi(0, pid, sid, durasi, total));
                }

                case 6 -> {
                    var list = transaksiService.getAllTransaksi();
                    for (Transaksi t : list) {
                        System.out.printf("Transaksi #%d - Properti %d - Penyewa %d - %d bulan - Total: Rp%.2f\n",
                            t.getId(), t.getPropertiId(), t.getPenyewaId(), t.getDurasi(), t.getTotal());
                    }
                }

                case 0 -> {
                    System.out.println("Terima kasih!");
                    return;
                }

                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }
}