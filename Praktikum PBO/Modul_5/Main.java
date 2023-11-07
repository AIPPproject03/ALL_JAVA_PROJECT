package Modul_5;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.io.*;

/**
 * @Author: AIPPproject03
 *          AKA A.Irwin Putra Pangesti
 */

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        RumahSakit rumahSakit = new RumahSakit();

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader pause = new BufferedReader(is);

        boolean sudahAdaPasienTerdaftar = false;
        boolean isRegistrasiSelesai = false;
        int menu;
        do {
            System.out.print("\033[H\033[2J");
            System.out.println("|=======[Selamat Datang Di TINUS HOSPITAL]=======|");
            System.out.println("|[1] Tambah Pasien                               |");
            System.out.println("|[2] Registrasi Pasien                           |");
            System.out.println("|[3] Keluarkan Pasien                            |");
            System.out.println("|[4] Pembayaran Pasien                           |");
            System.out.println("|[5] Cari Pasien                                 |");
            System.out.println("|[6] Tampilkan Data Pasien                       |");
            System.out.println("|[7] Keluar                                      |");
            System.out.println("|================================================|");
            System.out.print("| Pilih menu : ");
            menu = input.nextInt();
            input.nextLine();

            switch (menu) {
                case 1: {
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
                    sudahAdaPasienTerdaftar = true; // Pasien telah terdaftar
                    pause.readLine();
                    break;
                }
                case 2: {
                    if (!sudahAdaPasienTerdaftar) {
                        System.out.print("\033[H\033[2J");
                        System.out.println("Belum ada pasien terdaftar. Tambahkan pasien terlebih dahulu.");
                        pause.readLine();
                        break;
                    } else {
                        int menu2;
                        do {
                            System.out.print("\033[H\033[2J");
                            System.out.println("|=====[+REGISTRASI PASIEN+]=====|");
                            System.out.println("|[1] Pasien Rawat Inap          |");
                            System.out.println("|[2] Pasien Poli                |");
                            System.out.println("|[3] Pasien UGD                 |");
                            System.out.println("|[4] Kembali                    |");
                            System.out.println("|===============================|");
                            System.out.print("| Pilih menu : ");
                            menu2 = input.nextInt();
                            input.nextLine();
                            if (menu2 == 1) {
                                System.out.print("\033[H\033[2J");

                                boolean isPasienTerdaftar = false; // Tambahkan variabel untuk mengecek apakah pasien
                                                                   // sudah terdaftar

                                // Menampilkan daftar pasien yang sudah terdaftar
                                List<Pasien> daftarPasien = rumahSakit.getDaftarPasien();
                                if (!daftarPasien.isEmpty()) {
                                    System.out.println("Daftar Pasien TINUS HOSPITAL:");
                                    for (int i = 0; i < daftarPasien.size(); i++) {
                                        Pasien pasien = daftarPasien.get(i);
                                        System.out.println("[" + (i + 1) + "] " + pasien.getNama());
                                    }

                                    System.out.print("Pilih nomor pasien yang akan dijadikan pasien Rawat Inap: ");
                                    int nomorPasien = input.nextInt();
                                    input.nextLine();

                                    if (nomorPasien >= 1 && nomorPasien <= daftarPasien.size()) {
                                        Pasien pasienTerpilih = daftarPasien.get(nomorPasien - 1);

                                        // Periksa apakah pasien sudah terdaftar di Rawat Inap
                                        for (Pasien pasienRawatInap : rumahSakit.getDaftarPasienRawatInap()) {
                                            if (pasienRawatInap.getNama().equals(pasienTerpilih.getNama())) {
                                                isPasienTerdaftar = true;
                                                break;
                                            }
                                        }

                                        if (!isPasienTerdaftar) {
                                            System.out.print("Nomor Kamar Pasien: ");
                                            int nomorKamar = input.nextInt();
                                            input.nextLine();
                                            System.out.print("Lama Rawat Inap Pasien: ");
                                            int lamaRawatInap = input.nextInt();
                                            input.nextLine();

                                            PasienRawatInap pasienRawatInap = new PasienRawatInap(
                                                    pasienTerpilih.getNama(),
                                                    pasienTerpilih.getUmur(), pasienTerpilih.getDiagnosa(), nomorKamar,
                                                    lamaRawatInap);
                                            rumahSakit.daftarPasien(pasienRawatInap, "Rawat Inap");
                                            System.out.println("Pasien telah ditambahkan.");

                                        } else {
                                            System.out.println("Pasien sudah terdaftar di Rawat Inap.");
                                        }
                                    } else {
                                        System.out.println("Nomor pasien tidak valid. Silakan coba lagi.");
                                    }
                                } else {
                                    System.out.println("Belum ada pasien terdaftar. Tambahkan pasien terlebih dahulu.");
                                }
                                pause.readLine();

                            } else if (menu2 == 2) {
                                System.out.print("\033[H\033[2J");

                                boolean isPasienTerdaftar = false; // Tambahkan variabel untuk mengecek apakah pasien
                                                                   // sudah terdaftar

                                // Menampilkan daftar pasien yang sudah terdaftar
                                List<Pasien> daftarPasien = rumahSakit.getDaftarPasien();
                                if (!daftarPasien.isEmpty()) {
                                    System.out.println("Daftar Pasien yang sudah terdaftar:");
                                    for (int i = 0; i < daftarPasien.size(); i++) {
                                        Pasien pasien = daftarPasien.get(i);
                                        System.out.println("[" + (i + 1) + "] " + pasien.getNama());
                                    }

                                    System.out.print("Pilih nomor pasien yang akan dijadikan pasien Poli: ");
                                    int nomorPasien = input.nextInt();
                                    input.nextLine();

                                    if (nomorPasien >= 1 && nomorPasien <= daftarPasien.size()) {
                                        Pasien pasienTerpilih = daftarPasien.get(nomorPasien - 1);

                                        // Periksa apakah pasien sudah terdaftar di Poli
                                        for (Pasien pasienPoli : rumahSakit.getDaftarPasienPoli()) {
                                            if (pasienPoli.getNama().equals(pasienTerpilih.getNama())) {
                                                isPasienTerdaftar = true;
                                                break;
                                            }
                                        }

                                        if (!isPasienTerdaftar) {
                                            System.out.println("Jenis Poli yang tersedia: ");
                                            // Tambahkan logika untuk menampilkan jenis Poli yang tersedia
                                            // Misalnya, daftar jenis Poli yang tersedia
                                            List<String> jenisPoliTersedia = Arrays.asList("Poli A", "Poli B",
                                                    "Poli C");
                                            for (int i = 0; i < jenisPoliTersedia.size(); i++) {
                                                System.out.println("[" + (i + 1) + "] " + jenisPoliTersedia.get(i));
                                            }
                                            System.out.print("Pilih jenis Poli: ");
                                            int nomorJenisPoli = input.nextInt();
                                            input.nextLine();

                                            // Ubah ini sesuai dengan logika jenis Poli yang dipilih
                                            String jenisPoliTerpilih = jenisPoliTersedia.get(nomorJenisPoli - 1);

                                            Pasien pasienPoli = new PasienPoli(pasienTerpilih.getNama(),
                                                    pasienTerpilih.getUmur(), pasienTerpilih.getDiagnosa(),
                                                    jenisPoliTerpilih);
                                            rumahSakit.daftarPasien(pasienPoli, "Poli");
                                            System.out.println("Pasien telah ditambahkan ke Poli.");

                                        } else {
                                            System.out.println("Pasien sudah terdaftar di Poli.");
                                        }
                                    } else {
                                        System.out.println("Nomor pasien tidak valid. Silakan coba lagi.");
                                    }
                                } else {
                                    System.out.println("Belum ada pasien terdaftar. Tambahkan pasien terlebih dahulu.");
                                }
                                pause.readLine();

                            } else if (menu2 == 3) {
                                System.out.print("\033[H\033[2J");

                                boolean isPasienTerdaftar = false; // Tambahkan variabel untuk mengecek apakah pasien
                                                                   // sudah terdaftar

                                // Menampilkan daftar pasien yang sudah terdaftar
                                List<Pasien> daftarPasien = rumahSakit.getDaftarPasien();
                                if (!daftarPasien.isEmpty()) {
                                    System.out.println("Daftar Pasien yang sudah terdaftar:");
                                    for (int i = 0; i < daftarPasien.size(); i++) {
                                        Pasien pasien = daftarPasien.get(i);
                                        System.out.println("[" + (i + 1) + "] " + pasien.getNama());
                                    }

                                    System.out.print("Pilih nomor pasien yang akan dijadikan pasien UGD: ");
                                    int nomorPasien = input.nextInt();
                                    input.nextLine();

                                    if (nomorPasien >= 1 && nomorPasien <= daftarPasien.size()) {
                                        Pasien pasienTerpilih = daftarPasien.get(nomorPasien - 1);

                                        // Periksa apakah pasien sudah terdaftar di UGD
                                        for (Pasien pasienUGD : rumahSakit.getDaftarPasienUGD()) {
                                            if (pasienUGD.getNama().equals(pasienTerpilih.getNama())) {
                                                isPasienTerdaftar = true;
                                                break;
                                            }
                                        }

                                        if (!isPasienTerdaftar) {
                                            System.out.print("Jenis Kecelakaan Pasien: ");
                                            String jenisKecelakaan = input.nextLine();

                                            PasienUGD pasienUGD = new PasienUGD(pasienTerpilih.getNama(),
                                                    pasienTerpilih.getUmur(), pasienTerpilih.getDiagnosa(),
                                                    jenisKecelakaan);
                                            rumahSakit.daftarPasien(pasienUGD, "UGD");
                                            System.out.println("Pasien telah ditambahkan ke UGD.");

                                        } else {
                                            System.out.println("Pasien sudah terdaftar di UGD.");
                                        }
                                    } else {
                                        System.out.println("Nomor pasien tidak valid. Silakan coba lagi.");
                                    }
                                } else {
                                    System.out.println("Belum ada pasien terdaftar. Tambahkan pasien terlebih dahulu.");
                                }
                                pause.readLine();

                            } else if (menu2 == 4) {
                                System.out.println("Back");
                                break;
                            } else {
                                System.out.print("\033[H\033[2J");
                                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                                pause.readLine();
                            }
                        } while (menu2 != 4);
                    }
                    break;
                }
                case 3: {
                    List<Pasien> daftarPasienRumahSakit = rumahSakit.getDaftarPasien();
                    System.out.print("\033[H\033[2J");
                    if (daftarPasienRumahSakit.isEmpty()) {
                        System.out.println("Belum ada pasien terdaftar di Rumah Sakit.");
                        pause.readLine();
                    } else {
                        System.out.println("Data Pasien:");
                        int i = 1;
                        for (Pasien pasien : rumahSakit.getDaftarPasien()) {
                            // Tampilkan semua pasien
                            System.out.println("|[" + (i++) + "]==============================================|");
                            System.out.printf("| %-10s: %-35s |\n", "Nama", pasien.getNama());
                            System.out.println("|=================================================|");
                        }
                        System.out.print("Masukkan nama pasien yang akan dikeluarkan: ");
                        String namaPasien = input.nextLine();

                        // Panggil method keluarPasien dari RumahSakit
                        rumahSakit.keluarPasien(namaPasien);
                        pause.readLine();
                    }
                }
                    break;

                case 4: {
                    System.out.print("\033[H\033[2J");

                    // Menampilkan daftar pasien pada Rawat Inap
                    List<Pasien> pasienRawatInap = rumahSakit.getDaftarPasienRawatInap();
                    if (!pasienRawatInap.isEmpty()) {
                        System.out.println("Daftar Pasien Rawat Inap: ");
                        int i = 1;
                        for (Pasien pasien : pasienRawatInap) {
                            System.out.println("[" + (i++) + "]" + pasien.getNama());
                        }
                    } else {
                        System.out.println("Belum ada pasien yang mendaftar pada layanan Rawat Inap.");
                    }

                    // Menampilkan daftar pasien pada Poli
                    List<Pasien> pasienPoli = rumahSakit.getDaftarPasienPoli();
                    if (!pasienPoli.isEmpty()) {
                        System.out.println("Daftar Pasien Poli: ");
                        int i = 1;
                        for (Pasien pasien : pasienPoli) {
                            System.out.println("[" + (i++) + "]" + pasien.getNama());
                        }
                    } else {
                        System.out.println("Belum ada pasien yang mendaftar pada layanan Poli.");
                    }

                    // Menampilkan daftar pasien pada UGD
                    List<Pasien> pasienUGD = rumahSakit.getDaftarPasienUGD();
                    if (!pasienUGD.isEmpty()) {
                        System.out.println("Daftar Pasien UGD: ");
                        int i = 1;
                        for (Pasien pasien : pasienUGD) {
                            System.out.println("[" + (i++) + "]" + pasien.getNama());
                        }
                    } else {
                        System.out.println("Belum ada pasien yang mendaftar pada layanan UGD.");
                    }

                    System.out.println();
                    System.out.print("Masukkan nama pasien yang akan dibayar: ");
                    String namaPasien = input.nextLine();
                    rumahSakit.metodeBayarPasien(namaPasien);
                    pause.readLine();
                    break;
                }

                case 5: {
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
                }
                case 6: {
                    int menuTampil;
                    do {
                        System.out.print("\033[H\033[2J");
                        System.out.println("Pilihan menu:");
                        System.out.println("1. Tampilkan semua pasien");
                        System.out.println("2. Tampilkan pasien Rawat Inap");
                        System.out.println("3. Tampilkan pasien Poli");
                        System.out.println("4. Tampilkan pasien UGD");
                        System.out.println("5. Kembali");
                        System.out.print("Pilih submenu: ");
                        menuTampil = input.nextInt();
                        input.nextLine();

                        switch (menuTampil) {
                            case 1:
                                if (rumahSakit.getDaftarPasien().isEmpty()) {
                                    System.out.println("Tidak ada data pasien.");
                                    break;
                                } else {
                                    System.out.println("Data Pasien:");
                                    for (Pasien pasien : rumahSakit.getDaftarPasien()) {
                                        // Tampilkan semua pasien
                                        System.out.println("|=================================================|");
                                        System.out.printf("| %-10s: %-35s |\n", "Nama", pasien.getNama());
                                        System.out.printf("| %-10s: %-35d |\n", "Umur", pasien.getUmur());
                                        System.out.printf("| %-10s: %-35s |\n", "Diagnosa", pasien.getDiagnosa());
                                        System.out.println("|=================================================|");
                                    }
                                }
                                break;

                            case 2:
                                // Menampilkan daftar pasien Rawat Inap
                                List<Pasien> daftarPasienRawatInap = rumahSakit.getDaftarPasienRawatInap();
                                if (!daftarPasienRawatInap.isEmpty()) {
                                    System.out.println("Daftar Pasien Rawat Inap:");
                                    for (Pasien pasien : daftarPasienRawatInap) {
                                        // Menampilkan detail pasien Rawat Inap
                                        System.out.println(
                                                "|============================================================|");
                                        System.out.printf("| %-16s: %-40s |\n", "Nama", pasien.getNama());
                                        System.out.printf("| %-16s: %-40d |\n", "Umur", pasien.getUmur());
                                        System.out.printf("| %-16s: %-40s |\n", "Diagnosa",
                                                pasien.getDiagnosa());
                                        System.out.printf("| %-16s: %-40d |\n", "Nomor Kamar",
                                                ((PasienRawatInap) pasien).getNomorKamar());
                                        System.out.printf("| %-16s: %-40d |\n", "Lama Rawat Inap",
                                                ((PasienRawatInap) pasien).getLamaRawatInap());
                                        System.out.println(
                                                "|============================================================|");
                                    }
                                } else {
                                    System.out.println("Tidak ada pasien Rawat Inap.");
                                    break;
                                }
                                break;

                            case 3:
                                // Menampilkan daftar pasien Poli
                                List<Pasien> daftarPasienPoli = rumahSakit.getDaftarPasienPoli();
                                if (!daftarPasienPoli.isEmpty()) {
                                    System.out.println("Daftar Pasien Poli:");
                                    for (Pasien pasien : daftarPasienPoli) {
                                        // Menampilkan detail pasien Poli
                                        System.out.println(
                                                "|============================================================|");
                                        System.out.printf("| %-16s: %-40s |\n", "Nama", pasien.getNama());
                                        System.out.printf("| %-16s: %-40d |\n", "Umur", pasien.getUmur());
                                        System.out.printf("| %-16s: %-40s |\n", "Diagnosa",
                                                pasien.getDiagnosa());
                                        System.out.printf("| %-16s: %-40s |\n", "Jenis Poli",
                                                ((PasienPoli) pasien).getJenisPoli());
                                        System.out.println(
                                                "|============================================================|");
                                    }
                                } else {
                                    System.out.println("Tidak ada pasien di Poli.");
                                    break;
                                }
                                break;

                            case 4:
                                // Menampilkan daftar pasien UGD
                                List<Pasien> daftarPasienUGD = rumahSakit.getDaftarPasienUGD();
                                if (!daftarPasienUGD.isEmpty()) {
                                    System.out.println("Daftar Pasien UGD:");
                                    for (Pasien pasien : daftarPasienUGD) {
                                        // Menampilkan detail pasien UGD
                                        System.out.println(
                                                "|============================================================|");
                                        System.out.printf("| %-16s: %-40s |\n", "Nama", pasien.getNama());
                                        System.out.printf("| %-16s: %-40d |\n", "Umur", pasien.getUmur());
                                        System.out.printf("| %-16s: %-40s |\n", "Diagnosa",
                                                pasien.getDiagnosa());
                                        System.out.printf("| %-16s: %-40s |\n", "Jenis Kecelakaan",
                                                ((PasienUGD) pasien).getJenisKecelakaan());
                                        System.out.println(
                                                "|============================================================|");
                                    }
                                } else {
                                    System.out.println("Tidak ada pasien di UGD.");
                                    break;
                                }
                                break;

                            case 5:
                                System.out.println("Back");
                                break;

                            default:
                                System.out.println("Pilihan submenu tidak valid.");
                        }
                        pause.readLine();
                    } while (menuTampil != 5);
                }
                    break;
                case 7: {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Terima kasih telah berkunjung.");
                    pause.readLine();
                    break;
                }
                default:
                    System.out.print("\033[H\033[2J");
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    pause.readLine();
            }
        } while (menu != 7);
    }
}
