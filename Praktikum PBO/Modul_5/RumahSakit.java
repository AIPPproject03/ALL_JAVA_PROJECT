package Modul_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Layanan {
    void daftarPasien(Pasien pasien, String jenisLayanan);

    void keluarPasien(String namaPasien);

    void metodeBayarPasien(String namaPasien);
}

class RumahSakit implements Layanan {
    private List<Pasien> daftarPasien;
    private List<Pasien> daftarPasienRawatInap;
    private List<Pasien> daftarPasienPoli;
    private List<Pasien> daftarPasienUGD;

    public RumahSakit() {
        daftarPasien = new ArrayList<>();
        daftarPasienRawatInap = new ArrayList<>();
        daftarPasienPoli = new ArrayList<>();
        daftarPasienUGD = new ArrayList<>();
    }

    public void tambahPasien(Pasien pasien) {
        daftarPasien.add(pasien);
    }

    public List<Pasien> cariPasien(String keyword) {
        List<Pasien> hasilPencarian = new ArrayList<>();
        for (Pasien pasien : daftarPasien) {
            if (pasien.getNama().contains(keyword)) {// contains() untuk mencari kata yang mirip
                hasilPencarian.add(pasien);
            }
        }
        return hasilPencarian;
    }

    public List<Pasien> getDaftarPasien() {
        return daftarPasien;
    }

    @Override
    public void daftarPasien(Pasien pasien, String jenisLayanan) {
        // Pemeriksaan apakah pasien sudah terdaftar di salah satu layanan
        if (isPasienTerdaftar(pasien, jenisLayanan)) {
            System.out.println("Pasien sudah terdaftar di " + jenisLayanan + ". Tidak bisa mendaftar lagi.");
            return;
        }

        switch (jenisLayanan) {
            case "Rawat Inap":
                daftarPasienRawatInap.add(pasien);
                break;
            case "Poli":
                daftarPasienPoli.add(pasien);
                break;
            case "UGD":
                daftarPasienUGD.add(pasien);
                break;
            default:
                System.out.println("Jenis layanan tidak valid.");
                break;
        }
    }

    // Metode untuk memeriksa apakah pasien sudah terdaftar di salah satu layanan
    private boolean isPasienTerdaftar(Pasien pasien, String jenisLayanan) {
        switch (jenisLayanan) {
            case "Rawat Inap":
                return daftarPasienRawatInap.contains(pasien);
            case "Poli":
                return daftarPasienPoli.contains(pasien);
            case "UGD":
                return daftarPasienUGD.contains(pasien);
            default:
                System.out.println("Jenis layanan tidak valid.");
                return true;
        }
    }

    public List<Pasien> getDaftarPasienRawatInap() {
        return daftarPasienRawatInap;
    }

    public List<Pasien> getDaftarPasienPoli() {
        return daftarPasienPoli;
    }

    public List<Pasien> getDaftarPasienUGD() {
        return daftarPasienUGD;
    }

    @Override
    public void keluarPasien(String namaPasien) {
        // Cari pasien di setiap layanan dan keluarkan dari layanan yang sesuai
        if (removePasienFromLayanan(daftarPasienRawatInap, namaPasien)) {
            System.out.println("Pasien " + namaPasien + " telah dikeluarkan dari layanan Rawat Inap.");
        }
        if (removePasienFromLayanan(daftarPasienPoli, namaPasien)) {
            System.out.println("Pasien " + namaPasien + " telah dikeluarkan dari layanan Poli.");
        }
        if (removePasienFromLayanan(daftarPasienUGD, namaPasien)) {
            System.out.println("Pasien " + namaPasien + " telah dikeluarkan dari layanan UGD.");
        }

        // Setelah keluar dari semua layanan, keluarkan dari rumah sakit
        if (removePasienFromList(daftarPasien, namaPasien)) {
            System.out.println("Pasien " + namaPasien + " telah dikeluarkan dari Rumah Sakit.");
        } else {
            System.out.println("Pasien " + namaPasien + " tidak ditemukan di Rumah Sakit.");
        }
    }

    // Metode untuk menghapus pasien dari daftar dalam layanan
    private boolean removePasienFromLayanan(List<Pasien> layanan, String namaPasien) {
        for (Pasien pasien : layanan) {
            if (pasien.getNama().equals(namaPasien)) {
                layanan.remove(pasien);
                return true;
            }
        }
        return false;
    }

    // Metode untuk menghapus pasien dari daftar pasien di Rumah Sakit
    private boolean removePasienFromList(List<Pasien> pasienList, String namaPasien) {
        for (Pasien pasien : pasienList) {
            if (pasien.getNama().equals(namaPasien)) {
                pasienList.remove(pasien);
                return true;
            }
        }
        return false;
    }

    @Override
    public void metodeBayarPasien(String namaPasien) {
        int totalBiaya = 0;

        // Cari pasien di setiap layanan
        for (Pasien pasien : daftarPasienRawatInap) {
            if (pasien.getNama().equals(namaPasien) && pasien instanceof PasienRawatInap) {
                PasienRawatInap pasienRawatInap = (PasienRawatInap) pasien;
                int biayaRawatInap = pasienRawatInap.getLamaRawatInap() * 100000;
                System.out.println("|=============================================|");
                System.out.println("|Biaya Rawat Inap (Rp.100.000 per hari) ");
                System.out.println("|Total Biaya: Rp." + String.format("%,d", biayaRawatInap));
                System.out.println("|=============================================|");
                totalBiaya += biayaRawatInap;
            }
        }

        for (Pasien pasien : daftarPasienPoli) {
            if (pasien.getNama().equals(namaPasien) && pasien instanceof PasienPoli) {
                System.out.println("|=============================================|");
                System.out.println("|Biaya Poli: Rp.50.000");
                System.out.println("|=============================================|");
                totalBiaya += 50000;
            }
        }

        for (Pasien pasien : daftarPasienUGD) {
            if (pasien.getNama().equals(namaPasien) && pasien instanceof PasienUGD) {
                System.out.println("|=============================================|");
                System.out.println("|Biaya UGD: Rp.150.000");
                System.out.println("|=============================================|");
                totalBiaya += 150000;
            }
        }

        if (totalBiaya > 0) {
            System.out.println("Total Biaya yang harus dibayar oleh pasien " + namaPasien + " adalah Rp."
                    + String.format("%,d", totalBiaya));
        } else {
            System.out.println("Pasien " + namaPasien + " tidak ditemukan di Rumah Sakit atau tidak memiliki layanan.");
        }
    }

}
