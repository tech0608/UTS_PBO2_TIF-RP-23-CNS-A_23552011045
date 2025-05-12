package com.mycompany.kasirproperti.model;

public class Penyewa {
    private int id;
    private String nama;
    private String kontak;

    public Penyewa(int id, String nama, String kontak) {
        this.id = id;
        this.nama = nama;
        this.kontak = kontak;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }
}