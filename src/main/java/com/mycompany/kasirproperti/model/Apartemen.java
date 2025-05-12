package com.mycompany.kasirproperti.model;

public class Apartemen extends Properti {
    public Apartemen(int id, String alamat, double hargaSewa) {
        super(id, "Apartemen", alamat, hargaSewa);
    }

    @Override
    public double hitungPajak() {
        return getHargaSewa() * 0.15; // 15%
    }
}
