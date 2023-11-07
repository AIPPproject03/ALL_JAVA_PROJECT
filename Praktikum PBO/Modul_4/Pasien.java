package Modul_4;

public class Pasien {
    String nama;
    int umur;
    String diagnosa;
    public Pasien(String nama, int umur, String diagnosa) {
        this.nama = nama;
        this.umur = umur;
        this.diagnosa = diagnosa;
    }

    // Getter dan Setter
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
