package Program_Mengitung;

public class lingkaran {
    
    private double jari_jari;
    private double phi = 3.1415;
    private double LuasLingkaran;

    public void setJari(double r){
        jari_jari = r;
    }
    public void L_Lingkaran(){
        LuasLingkaran = phi * jari_jari * jari_jari;

        System.out.println(" Luas Lingkaran = "+LuasLingkaran);
    }
}
