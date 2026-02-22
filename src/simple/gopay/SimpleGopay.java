/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple.gopay;
import java.util.Scanner;


public class SimpleGopay {

    class Data {
        private String namaPengguna;
        private double saldoPengguna;
        
        public Data (String namaPengguna, double saldoPengguna) {
            this.namaPengguna = namaPengguna;
            this.saldoPengguna = saldoPengguna;
        }
        
        public void cekNama () {
            System.out.println("Nama pengguna : " + this.namaPengguna);
        }
        
        public void cekSaldo () {
            System.out.println("Saldo pengguna : " + this.saldoPengguna);
        }
        
        
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        
        
    }
    
}
