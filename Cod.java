import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Kelas {@code Cod} merepresentasikan metode pembayaran "Cash on Delivery" (COD).
 * Kelas ini merupakan turunan dari kelas {@code Pembayaran} dan mengimplementasi metode pembayaran.
 */
public class Cod extends Pembayaran {
     
    private static int counter = 0;
    private Keranjang keranjang;
    Scanner s = new Scanner(System.in);

    /**
     * Konstruktor default untuk membuat instance {@code Cod}.
     * Inisialisasi objek Keranjang dan generateTransactionId dipanggil.
     */
    public Cod() {
        keranjang = new Keranjang();
        generateTransactionId();
    }

    /**
     * Konstruktor untuk membuat instance {@code Cod} dengan ID dan total harga yang disediakan.
     *
     * @param id          ID transaksi.
     * @param totalHarga  Total harga transaksi.
     */
    public Cod(String id, int totalHarga) {
        super(id, totalHarga);
        keranjang = new Keranjang();
        generateTransactionId();
    }

    /**
     * Metode untuk menghasilkan ID transaksi berdasarkan timestamp.
     */
    private void generateTransactionId() {
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String timestamp = dateFormat.format(new Date());
            id = timestamp + "_" + counter;
            counter++;
    }

    /**
     * Metode untuk melakukan pembayaran melalui metode "Cash on Delivery" (COD).
     */
    @Override
    public void metodePembayaran(){
        int totalHarga = this.keranjang.totalHarga();
        System.out.println("pembayaran melalui COD");
        System.out.println(" ");
        System.out.println("Tekan 1 jika anda telah menerima barang pesanan anda");
        int input = s.nextInt();

        if(input == 1){
            System.out.println("Menunggu transaksi diterima oleh admin");
            System.out.println("Transaction ID : "+ id);
            this.writeTransaksi(totalHarga);
            this.cekTransaksi();
        }
    }

    /**
     * Metode untuk menulis informasi transaksi ke file "transaksi.txt".
     *
     * @param totalHarga Total harga transaksi.
     */
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

    /**
     * Metode untuk menulis status transaksi ke file "cek.txt".
     */
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
