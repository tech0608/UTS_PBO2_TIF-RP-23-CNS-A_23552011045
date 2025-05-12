package com.mycompany.kasirproperti.model;

public class Properti extends Aset {
    private int id;
    private String jenis;

    public Properti(int id, String jenis, String alamat, double hargaSewa) {
        super(alamat, hargaSewa);
        this.id = id;
        this.jenis = jenis;
    }

    public int getId() {
        return id;
    }

    public String getJenis() {
        return jenis;
    }

    @Override
    public double hitungPajak() {
        return 0; // akan di-override di subclass
    }
}