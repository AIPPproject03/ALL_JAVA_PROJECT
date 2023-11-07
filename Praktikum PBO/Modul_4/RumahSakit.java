package Modul_4;
import java.util.ArrayList;
import java.util.List;

public class RumahSakit {
    private List<Pasien> daftarPasien;

    public RumahSakit() {
        daftarPasien = new ArrayList<>();
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
}

