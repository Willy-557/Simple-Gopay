package simple.gopay;
import java.util.Scanner;
import java.util.HashMap;

class Data {
        private String namaPengguna;
        private double saldoPengguna;
        
        public Data (String namaPengguna, double saldoPengguna) {
            this.namaPengguna = namaPengguna;
            this.saldoPengguna = saldoPengguna;
        }
        
        public String cekNama () {
            return this.namaPengguna;
        }
        
        public double cekSaldo () {
            return this.saldoPengguna;
        }
        
        public void topupSaldo (double saldoMasuk) {
            if (saldoMasuk < 1) {
                System.out.println("Nominal yang dimasukkan harus diatas 0");
            }
            else {
                this.saldoPengguna += saldoMasuk;
                System.out.println("Berhasil menambahkan saldo sebesar Rp " + saldoMasuk + "ke rekening!");
            }
        }
        
        public void paymentMethode (double price) {
            if (price < 1) {
                System.out.println("Pembayaran tidak dapat dilakukan dikarenakan nominal yang dimasukkan tidak valid!");
            }
            else {
                if (price > this.saldoPengguna) {
                    System.out.println("Maaf, saldo anda tidak cukup!");
                }
                else {
                    this.saldoPengguna -= price;
                    System.out.println("Pembayar sebesar Rp " + price + "berhasil dilakukan!");
                }
            }
        }
    }

public class SimpleGopay {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        HashMap <Integer, Data> databaseUser = new HashMap <>();
        
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Sign in");
            System.out.println("3. Exit");
            
            System.out.print(">> ");
            int choice = scanner.nextInt();
            
            if (choice == 3){
                System.out.println("Terimakasih!");
                break;
            }
            else if (choice > 3 || choice < 1) {
                System.out.println("Masukkan nomor menu antara 1 - 3!");
                continue;
            }
            else {
                switch (choice) {
                    case 1 : 
                        System.out.print("Masukkan no telp : ");
                        int noTelp = scanner.nextInt();
                        
                        if (!databaseUser.containsKey(noTelp)) {
                            System.out.println("Silahkan buat akun terlebih dahulu!");
                        }
                        else {
                            while (true) {
                                System.out.println("1. Topup");
                                System.out.println("2. Cek saldo");
                                System.out.println("3. Pembayaran");
                                System.out.println("4. Keluar");
                                
                                System.out.print(">> ");
                                int choiceMenu = scanner.nextInt();
                                
                                if (choiceMenu == 4){
                                    System.out.println("Terimakasih!");
                                    break;
                                }
                                else if (choiceMenu > 4 || choiceMenu < 1){
                                    System.out.println("Harap masukkan nomor menu antara 1 - 4!");
                                    continue;
                                }
                                else {
                                    switch (choiceMenu) {
                                        case 1:
                                            System.out.print("Masukkan nominal yang di-topupkan : ");
                                            double nominalTopup = scanner.nextDouble();
                                            
                                            Data ambilData = databaseUser.get(noTelp);
                                            ambilData.topupSaldo(nominalTopup);
                                            
                                            break;
                                            
                                        case 2:
                                            Data ambilDataPengguna = databaseUser.get(noTelp);
                                            System.out.println("Nama : " + ambilDataPengguna.cekNama());
                                            System.out.println("Saldo : " + ambilDataPengguna.cekSaldo());
                                            
                                            break;
                                            
                                        case 3:
                                            System.out.print("Masukkan nominal yang di-bayarkan : ");
                                            double nominalPembayaran = scanner.nextDouble();
                                            
                                            Data ambilDataUser = databaseUser.get(noTelp);
                                            ambilDataUser.paymentMethode(nominalPembayaran);
                                            
                                            break;
                                    }
                                }
                            }
                        }
                        break;
                        
                    case 2:
                        System.out.print("Masukkan no telp baru : ");
                        int noTelpUserBaru = scanner.nextInt();
                        
                        scanner.nextLine();
                        System.out.print("Masukkan nama baru : ");
                        String namaUserBaru = scanner.nextLine();
                        
                        double saldoAwal = 0;
                        
                        Data rekBaru = new Data (namaUserBaru, saldoAwal);
                        databaseUser.put(noTelpUserBaru, rekBaru);
                        
                        System.out.println("Akun atas nama " + namaUserBaru + "berhasil dibuat!");
                        break;     
                }
            }
        }
    }
}
