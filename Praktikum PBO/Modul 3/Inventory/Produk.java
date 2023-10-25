package GameStore;

public class Produk {
    int noGame;
    String namaGame;
    int jumlahGame;
    double HargaGame;
    /**
     * Konstruktor default tanpa parameter
     * Menginisialisasi field ke nilai defaultnya
     */
    public Produk() {
        this.noGame = 0;
        this.namaGame = null;
        this.jumlahGame = 0;
        this.HargaGame = 0.0;
    }
    /**
     * Konstruktor dengan parameter untuk keempat variabel kelas
     */
    public Produk(int noGame, String namaGame, int jumlahGame, double HargaGame) {
        this.noGame = noGame;
        this.namaGame = namaGame;
        this.jumlahGame = jumlahGame;
        this.HargaGame = HargaGame;
    }
    /**
     * Getter untuk variabel noGame
     */
    public int getNoGame() {
        return noGame;
    }
    /**
     * Setter untuk variabel noGame
     */
    public void setNoGame(int noGame) {
        this.noGame = noGame;
    }
    /**
     * Getter untuk variabel namaGame
     */
    public String getNamaGame() {
        return namaGame;
    }
    /**
     * Setter untuk variabel namaGame
     */
    public void setNamaGame(String namaGame) {
        this.namaGame = namaGame;
    }
    /**
     * Getter untuk variabel jumlahGame
     */
    public int getJumlahGame() {
        return jumlahGame;
    }
    /**
     * Setter untuk variabel jumlahGame
     */
    public void setJumlahGame(int jumlahGame) {
        this.jumlahGame = jumlahGame;
    }
    /**
     * Getter untuk variabel HargaGame
     */
    public double getHargaGame() {
        return HargaGame;
    }
    /**
     * Setter untuk variabel HargaGame
     */
    public void setHargaGame(double HargaGame) {
        this.HargaGame = HargaGame;
    }
    /**
     * Menampilkan nilai tiap variabel
     */
    public void tampilProduk() {
        System.out.println("|=====================================");
        System.out.println("|Nomor : " + noGame);
        System.out.println("|Nama  : " + namaGame);
        System.out.println("|Stok  : " + jumlahGame);
        // gunakan printf() dengan format string %,.0f agar harga terlihat lebih rapi seperti Rp1,000,000 bukan Rp1000000
        // https://docs.oracle.com/javase/tutorial/java/data/numberformat.html
        System.out.printf("|Harga : Rp%,.0f\n", HargaGame);
        System.out.println("|=====================================");
    }
}