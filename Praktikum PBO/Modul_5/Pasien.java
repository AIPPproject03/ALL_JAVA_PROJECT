package Modul_5;

public class Pasien {
    String nama;
    int umur;
    String diagnosa;

    public Pasien(String nama, int umur, String diagnosa) {
        this.nama = nama;
        this.umur = umur;
        this.diagnosa = diagnosa;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getDiagnosa() {
        return diagnosa;
    }

    public void setDiagnosa(String diagnosa) {
        this.diagnosa = diagnosa;
    }
}

class PasienRawatInap extends Pasien {
    public int nomorKamar;
    public int lamaRawatInap;

    public PasienRawatInap(String nama, int umur, String diagnosa, int nomorKamar, int lamaRawatInap) {
        super(nama, umur, diagnosa);
        this.nomorKamar = nomorKamar;
        this.lamaRawatInap = lamaRawatInap;
    }

    public int getNomorKamar() {
        return nomorKamar;
    }

    public void setNomorKamar(int nomorKamar) {
        this.nomorKamar = nomorKamar;
    }

    public int getLamaRawatInap() {
        return lamaRawatInap;
    }

    public void setLamaRawatInap(int lamaRawatInap) {
        this.lamaRawatInap = lamaRawatInap;
    }

}

class PasienPoli extends Pasien {
    public String jenisPoli;

    public PasienPoli(String nama, int umur, String diagnosa, String jenisPoli) {
        super(nama, umur, diagnosa);
        this.jenisPoli = jenisPoli;
    }

    public String getJenisPoli() {
        return jenisPoli;
    }

    public void setJenisPoli(String jenisPoli) {
        this.jenisPoli = jenisPoli;
    }

}

class PasienUGD extends Pasien {
    public String jenisKecelakaan;

    public PasienUGD(String nama, int umur, String diagnosa, String jenisKecelakaan) {
        super(nama, umur, diagnosa);
        this.jenisKecelakaan = jenisKecelakaan;
    }

    public String getJenisKecelakaan() {
        return jenisKecelakaan;
    }

    public void setJenisKecelakaan(String jenisKecelakaan) {
        this.jenisKecelakaan = jenisKecelakaan;
    }
}