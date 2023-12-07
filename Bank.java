import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Kelas {@code Bank} merepresentasikan pembayaran melalui transaksi bank.
 * Kelas ini merupakan turunan dari kelas {@code Pembayaran} dan mengimplementasi metode pembayaran.
 */
public class Bank extends Pembayaran {

    private static int counter = 0;
    private Keranjang keranjang;
    Scanner s = new Scanner(System.in);

    /**
     * Konstruktor default untuk membuat instance {@code Bank}.
     * Inisialisasi objek Keranjang dan generateTransactionId dipanggil.
     */
    public Bank() {
        keranjang = new Keranjang();
        generateTransactionId();
    }

    /**
     * Konstruktor untuk membuat instance {@code Bank} dengan ID dan total harga yang disediakan.
     *
     * @param id          ID transaksi.
     * @param totalHarga  Total harga transaksi.
     */
    public Bank(String id, int totalHarga) {
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
     * Metode untuk melakukan pembayaran melalui transaksi bank.
     */
    @Override
    public void metodePembayaran() {
        totalHarga = this.keranjang.totalHarga();
        System.out.println("Cara pembayaran melalui transaksi bank");
        System.out.println("No rek/virtual account: 128 2888 315 1475");
        System.out.println(" ");
        System.out.println("1. Masuk ke menu mobile mbanking, kemudian pilih pembayaran");
        System.out.println("2. Masukkan no rek / virtual account 128 2888 315 1475");
        System.out.println("3. Jumlah pembayaran sebesar " + totalHarga);
        System.out.println("4. Periksa apakah jumlah pembayaran anda telah sesuai");
        System.out.println("5. Masukkan PIN anda dan kemudian pilih SEND.");
        System.out.println(" ");
        System.out.println("Tekan 1 jika anda telah selesai proses transaksi");
        int input = s.nextInt();

        if (input == 1) {
            System.out.println("Menunggu transaksi diterima oleh admin");
            System.out.println("Transaction ID : " + id);
            this.writeTransaksi(totalHarga);
            this.cekTransaksi();
        }
    }

    /**
     * Metode untuk menulis informasi transaksi ke file "transaksi.txt".
     *
     * @param totalHarga Total harga transaksi.
     */
    public void writeTransaksi(int totalHarga) {
        try {
            FileWriter myWriter = new FileWriter("transaksi.txt");
            String line = String.format("%s %d", id, totalHarga);
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
    public void cekTransaksi() {
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
