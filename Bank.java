import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Bank extends Pembayaran {
     
    private static int counter = 0;
    private Keranjang keranjang;
    Scanner s = new Scanner(System.in);

    public Bank() {
        
        keranjang = new Keranjang();
        generateTransactionId();

    }
    public Bank(String id,int totalHarga){
        super(id, totalHarga);
        keranjang = new Keranjang();
        generateTransactionId();
    }

    private void generateTransactionId() {
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String timestamp = dateFormat.format(new Date());
            id = timestamp + "_" + counter;
            counter++;
    }

    @Override
    public void metodePembayaran(){
        totalHarga = this.keranjang.totalHarga();
        System.out.println("cara pembayaran melalui transaksi bank");
        System.out.println("no rek/virtual account: 128 2888 315 1475");
        System.out.println(" ");
        System.out.println("1. masuk ke menu mobile mbanking,kemudian pilih pembayaran ");
        System.out.println("2. masukkan no rek / virtual account 128 2888 315 1475");
        System.out.println("3.jumlah pembayaran  sebesar " + totalHarga );
        System.out.println("4.periksa apakah jumlah pembayaran anda telah sesuai");
        System.out.println("5. masukkan PIN anda dan kemudian pilih SEND.");
        System.out.println(" ");
        System.out.println("tekan 1 jika anda telah selesai proses transaksi");
        int input = s.nextInt();

        if(input == 1){
            System.out.println("menunggu transaksi diterima oleh admin");
            System.out.println("transaction ID : "+ id);
            this.writeTransaksi(totalHarga);
            this.cekTransaksi();
        }

       
    }
    public void writeTransaksi(int totalHarga){

        try {
            FileWriter myWriter = new FileWriter("transaksi.txt");
                String line = String.format("%s %d",id, totalHarga);
            myWriter.write(line);
            myWriter.close();
           
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

        
    }
    public void cekTransaksi(){
        try {
            FileWriter myWriter = new FileWriter("cek.txt");
                String line = "false";
            myWriter.write(line);
            myWriter.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

    }
    



   
    
}