package Program_Mengitung;

public class segitiga {
    
    private double alas;
    private double tinggi;
    private double LuasSegitiga;

    public void setTinggi(double t){
        tinggi = t;
    }
    public void setAlas(double a){
        alas = a;
    }
    public void L_Segitiga(){
        LuasSegitiga = 0.5 * (alas * tinggi);

        System.out.println(" Luas Segitiga = "+LuasSegitiga);
    }
}
