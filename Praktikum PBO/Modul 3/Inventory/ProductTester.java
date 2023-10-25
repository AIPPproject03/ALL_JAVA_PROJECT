package GameStore;

public class ProductTester {
    public static void main(String[] args) {
        // Membuat dan menginisialisasi enam objek Produk :
        // A. Menggunakan konstruktor default
        Produk produk1 = new Produk();
        Produk produk2 = new Produk();

        produk1.setNoGame(1);
        produk1.setNamaGame("Genshin Impact");
        produk1.setJumlahGame(10);
        produk1.setHargaGame(1000000);

        produk2.setNoGame(2);
        produk2.setNamaGame("Among Us");
        produk2.setJumlahGame(20);
        produk2.setHargaGame(2000000);

        // B. Menggunakan konstruktor dengan parameter
        Produk produk3 = new Produk(3, "Evil Within", 5, 500000);
        Produk produk4 = new Produk(4, "GTA V", 3, 150000);
        Produk produk5 = new Produk(5, "Stumble Guys", 10, 7000000);
        Produk produk6 = new Produk(6, "Spider Man", 8, 8000000);

        // Menampilkan detail setiap produk ke konsol
        produk1.tampilProduk();
        produk2.tampilProduk();
        produk3.tampilProduk();
        produk4.tampilProduk();
        produk5.tampilProduk();
        produk6.tampilProduk();
    }
}