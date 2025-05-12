package com.mycompany.kasirproperti.service;

import com.mycompany.kasirproperti.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransaksiService {

    public void tambahTransaksi(Transaksi transaksi) {
        try (Connection conn = Database.getConnection()) {
            // Ambil data properti berdasarkan ID
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM properti WHERE id = ?");
            ps.setInt(1, transaksi.getPropertiId());
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Properti tidak ditemukan.");
                return;
            }

            String jenis = rs.getString("jenis");
            String alamat = rs.getString("alamat");
            double hargaSewa = rs.getDouble("harga_sewa");

            Properti properti;
            if (jenis.equalsIgnoreCase("Rumah")) {
                properti = new Rumah(transaksi.getPropertiId(), alamat, hargaSewa);
            } else {
                properti = new Apartemen(transaksi.getPropertiId(), alamat, hargaSewa);
            }

            double pajak = properti.hitungPajak();
            double total = (hargaSewa * transaksi.getDurasi()) + pajak;

            // Simpan transaksi ke database
            String insertSql = "INSERT INTO transaksi (properti_id, penyewa_id, durasi, total) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            insertStmt.setInt(1, transaksi.getPropertiId());
            insertStmt.setInt(2, transaksi.getPenyewaId());
            insertStmt.setInt(3, transaksi.getDurasi());
            insertStmt.setDouble(4, total);
            insertStmt.executeUpdate();

            System.out.println("Transaksi berhasil disimpan. Total (termasuk pajak): " + total);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Transaksi> getAllTransaksi() {
        List<Transaksi> list = new ArrayList<>();
        try (Connection conn = Database.getConnection()) {
            String sql = "SELECT * FROM transaksi";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(new Transaksi(
                    rs.getInt("id"),
                    rs.getInt("properti_id"),
                    rs.getInt("penyewa_id"),
                    rs.getInt("durasi"),
                    rs.getDouble("total")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
