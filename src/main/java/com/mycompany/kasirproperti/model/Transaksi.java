package com.mycompany.kasirproperti.model;

public class Transaksi {
    private int id;
    private int propertiId;
    private int penyewaId;
    private int durasi;
    private double total;

    public Transaksi(int id, int propertiId, int penyewaId, int durasi, double total) {
        this.id = id;
        this.propertiId = propertiId;
        this.penyewaId = penyewaId;
        this.durasi = durasi;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public int getPropertiId() {
        return propertiId;
    }

    public int getPenyewaId() {
        return penyewaId;
    }

    public int getDurasi() {
        return durasi;
    }

    public double getTotal() {
        return total;
    }
}
