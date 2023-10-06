package Program_Mengitung;

public class bujursangkar {
    
    private double sisi;
    private double LuasBujursangkar;

    public void setSisi(double s){
        sisi = s;
    }
    public void L_Bujursangkar(){
        LuasBujursangkar = sisi * sisi;

        System.out.println(" Luas Bujursangkar = "+LuasBujursangkar);
    }
}
