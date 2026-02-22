/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
        public void topupSaldo (int saldoMasuk) {
            if (saldoMasuk < 1) {
                System.out.println("Nominal yang dimasukkan harus diatas 0");
            }
            else {
                this.saldoPengguna += saldoMasuk;
                System.out.println("Berhasil menambahkan saldo sebesar Rp " + saldoMasuk + "ke rekening!");
            }
        }
        
        public void paymentMethode (int price) {
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
            
            }

        }
    }
    
}
