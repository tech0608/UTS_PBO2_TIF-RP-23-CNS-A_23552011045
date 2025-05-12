package com.mycompany.kasirproperti.service;

import com.mycompany.kasirproperti.model.Penyewa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PenyewaService {

    public List<Penyewa> getAllPenyewa() {
        List<Penyewa> list = new ArrayList<>();
        try (Connection conn = Database.getConnection()) {
            String sql = "SELECT * FROM penyewa";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(new Penyewa(
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("kontak")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void tambahPenyewa(Penyewa p) {
        try (Connection conn = Database.getConnection()) {
            String sql = "INSERT INTO penyewa (nama, kontak) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, p.getNama());
            stmt.setString(2, p.getKontak());
            stmt.executeUpdate();
            System.out.println("Penyewa berhasil ditambahkan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}