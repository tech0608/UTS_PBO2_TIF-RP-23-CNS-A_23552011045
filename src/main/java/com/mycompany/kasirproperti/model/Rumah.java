package com.mycompany.kasirproperti.model;

public class Rumah extends Properti {
    public Rumah(int id, String alamat, double hargaSewa) {
        super(id, "Rumah", alamat, hargaSewa);
    }

    @Override
    public double hitungPajak() {
        return getHargaSewa() * 0.10; // 10%
    }
}