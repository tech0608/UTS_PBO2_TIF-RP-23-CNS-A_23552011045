package com.mycompany.kasirproperti.model;

public abstract class Aset {
    private String alamat;
    private double hargaSewa;

    public Aset(String alamat, double hargaSewa) {
        this.alamat = alamat;
        this.hargaSewa = hargaSewa;
    }

    public String getAlamat() {
        return alamat;
    }

    public double getHargaSewa() {
        return hargaSewa;
    }

    public abstract double hitungPajak();
}