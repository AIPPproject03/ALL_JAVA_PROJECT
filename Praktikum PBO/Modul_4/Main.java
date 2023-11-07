package Modul_4;
import java.util.Scanner;
import java.util.List;
import java.io.*;

/**
 * @Author: AIPPproject03
 * AKA A.Irwin Putra Pangesti
 */

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        RumahSakit rumahSakit = new RumahSakit();

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader pause = new BufferedReader(is);

        while (true) {

            System.out.print("\033[H\033[2J");
            System.out.println("|=====[Selamat Datang Di Rumah Sakit TINUS]=====|");
            System.out.println("|[1] Tambah Pasien                              |");
            System.out.println("|[2] Cari Pasien                                |");
            System.out.println("|[3] Tampilkan Data Pasien                      |");
            System.out.println("|[4] Keluar                                     |");
            System.out.println("|===============================================|");
            System.out.print("| Pilih menu : ");
            int menu = input.nextInt();
            input.nextLine();

            switch (menu) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.print("Masukkan Nama Pasien: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan Umur Pasien: ");
                    int umur = input.nextInt();
                    input.nextLine();
                    System.out.print("Masukkan Diagnosa: ");
                    String diagnosa = input.nextLine();

                    Pasien pasienBaru = new Pasien(nama, umur, diagnosa);
                    rumahSakit.tambahPasien(pasienBaru);
                    System.out.println("Pasien telah ditambahkan.");
                    pause.readLine();
                    break;

                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.print("Masukkan nama pasien yang ingin dicari: ");
                    String keyword = input.nextLine();
                    List<Pasien> hasilPencarian = rumahSakit.cariPasien(keyword);
                    if (hasilPencarian.isEmpty()) {
                        System.out.println("Tidak ada pasien ditemukan.");
                    } else {
                        System.out.println("Hasil Pencarian:");
                        for (Pasien pasien : hasilPencarian) {
                            // %-10s dan %-30d menunjukkan bahwa string dan integer akan dicetak dengan 
                            // lebar 10 dan 35 karakter masing-masing.
                            System.out.println("|=================================================|");
                            System.out.printf("| %-10s: %-35s |\n", "Nama", pasien.nama);
                            System.out.printf("| %-10s: %-35d |\n", "Umur", pasien.umur);
                            System.out.printf("| %-10s: %-35s |\n", "Diagnosa", pasien.diagnosa);
                            System.out.println("|=================================================|");
                        }
                    }
                    pause.readLine();
                    break;

                case 3:
                    System.out.print("\033[H\033[2J");
                    List<Pasien> daftarPasien = rumahSakit.getDaftarPasien();
                    if (daftarPasien.isEmpty()) {
                        System.out.println("Tidak ada data pasien.");
                    } else {
                        System.out.println("Data Pasien :");
                        for (Pasien pasien : daftarPasien) {
                            // %-10s dan %-30d menunjukkan bahwa string dan integer akan dicetak dengan 
                            // lebar 10 dan 35 karakter masing-masing.
                            System.out.println("|=================================================|");
                            System.out.printf("| %-10s: %-35s |\n", "Nama", pasien.nama);
                            System.out.printf("| %-10s: %-35d |\n", "Umur", pasien.umur);
                            System.out.printf("| %-10s: %-35s |\n", "Diagnosa", pasien.diagnosa);
                            System.out.println("|=================================================|");
                        }
                    }
                    pause.readLine();
                    break;

                case 4:
                    System.out.print("\033[H\033[2J");
                    System.out.println("Terima kasih telah berkunjung.");
                    pause.readLine();
                    System.exit(0);
                    break;

                default:
                    System.out.print("\033[H\033[2J");
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    pause.readLine();
            }
        }
    }
}
