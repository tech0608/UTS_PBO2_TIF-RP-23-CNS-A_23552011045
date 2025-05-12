/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirproperti.service;

import com.mycompany.kasirproperti.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropertiService {

    public List<Properti> getAllProperti() {
        List<Properti> list = new ArrayList<>();
        try (Connection conn = Database.getConnection()) {
            String sql = "SELECT * FROM properti";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                 System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Jenis: " + rs.getString("jenis"));
            System.out.println("Alamat: " + rs.getString("alamat"));
            System.out.println("Harga Sewa: " + rs.getDouble("harga_sewa"));
            System.out.println("------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void tambahProperti(Properti p) {
        try (Connection conn = Database.getConnection()) {
            String sql = "INSERT INTO properti (jenis, alamat, harga_sewa) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, p.getJenis());
            stmt.setString(2, p.getAlamat());
            stmt.setDouble(3, p.getHargaSewa());
            stmt.executeUpdate();
            System.out.println("Properti berhasil ditambahkan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
