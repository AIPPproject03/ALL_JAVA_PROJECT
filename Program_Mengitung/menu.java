package Program_Mengitung;
import java.io.*;

/*
 * 
 * Programmed by AIPPproject03
 * 
 */

public class menu {

    public static void main (String [] args) throws IOException{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(is);
        System.out.print("\033[H\033[2J");
        System.out.flush();

        int pilih;
        do{
            System.out.print("\033[H\033[2J");
            System.out.println("[==================================]");
            System.out.println("|     PROGRAM MENGHITUNG LUAS      |");
            System.out.println("[==================================]");
            System.out.println("|[1] Luas Segitiga                 |");
            System.out.println("|[2] Luas Lingkaran                |");
            System.out.println("|[3] Luas Bujursangkar             |");
            System.out.println("|[4] END                           |");
            System.out.println("[==================================]");
            System.out.print(" Pilih : ");
            String inpString = input.readLine();
            pilih = Integer.parseInt(inpString);
            switch (pilih){
                case 1:
                System.out.print("\033[H\033[2J");

                /* Variable dan pemanggilan objek segitiga */
                double a;
                double t;
                segitiga triangle = new segitiga();

                /* Instruksi untuk menginput alas(r) dan tinggi (t) */
                System.out.print(" Input Alas     = ");
                String inAlas = input.readLine();
                a = Double.parseDouble(inAlas);
                System.out.print(" Input Tinggi   = ");
                String inTinggi = input.readLine();
                t = Double.parseDouble(inTinggi);

                /* Pemanggillan objek segitiga untuk menghitung luasnya */
                triangle.setAlas(a);
                triangle.setTinggi(t);
                triangle.L_Segitiga();
                input.readLine();
                break;
                case 2:
                System.out.print("\033[H\033[2J");

                /* Variable dan pemanggilan objek lingkaran */
                double num;
                lingkaran circle = new lingkaran();

                /* Instruksi untuk menginput jari-jari (r) */
                System.out.print(" Input Jari-Jari = ");
                String inJari = input.readLine();
                num = Double.parseDouble(inJari);

                /* Pemanggillan objek lingkaran untuk menghitung luasnya */
                circle.setJari(num);
                circle.L_Lingkaran();
                input.readLine();
                break;
                
                case 3:
                System.out.print("\033[H\033[2J");

                /* Variable dan pemanggilan objek bujursangkar */
                double s;
                bujursangkar square = new bujursangkar();

                /* Instruksi untuk menginput sisi (s) */
                System.out.print(" Input Sisi = ");
                String inSisi = input.readLine();
                s = Double.parseDouble(inSisi);

                /* Pemanggillan objek bujursangkar untuk menghitung luasnya */
                square.setSisi(s);
                square.L_Bujursangkar();
                input.readLine();
                break;
                case 4:
                break;
                default:
                System.out.print("\033[H\033[2J");
                System.out.println("Invalid instruction");
                input.readLine();
            }
        }while (pilih != 4);
        System.out.print("\033[H\033[2J");
        System.out.println(" Thank You :)......... Made By IRWIN PROJECT");
        input.readLine();
    }
}
