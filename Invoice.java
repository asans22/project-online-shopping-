import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Kelas {@code Invoice} bertanggung jawab untuk membuat dan menampilkan invoice transaksi.
 */
public class Invoice {
    Scanner s = new Scanner(System.in);
    private Transaksi transaksi;
    private Pembayaran pembayaran;
    private ArrayList<Barang> listKeranjang;
    private ArrayList<Barang> listInvoice;
    private ArrayList<String> transaksi1;

    /**
     * Konstruktor default untuk membuat instance {@code Invoice}.
     * Inisialisasi objek Transaksi dan ArrayList dilakukan.
     */
    public Invoice(){
        this.transaksi = new Transaksi();
        this.listKeranjang = new ArrayList<>();
        this.listInvoice = new ArrayList<>();
        this.transaksi1 = new ArrayList<>();
    }
    

    /**
     * Konstruktor untuk membuat instance {@code Invoice} dengan objek Transaksi dan Pembayaran yang disediakan.
     *
     * @param transaksi   Objek Transaksi yang akan digunakan.
     * @param pembayaran  Objek Pembayaran yang akan digunakan.
     */
    public Invoice(Transaksi transaksi, Pembayaran pembayaran) {
        this.transaksi = transaksi;
        this.pembayaran = pembayaran;
    }

    /**
     * Metode untuk menampilkan menu pilihan pembayaran (QRIS, BANK, COD) dan memproses pembayaran sesuai pilihan.
     */
    public void menu(){
        int pilihan;
        System.out.println("Pilih menu pembayaran : ");
        System.out.println("1. QRIS");
        System.out.println("2. BANK");
        System.out.println("3. COD");
        pilihan = s.nextInt();

        if(pilihan == 1){
            // Method QRIS
            this.pembayaran = new Qris();
            pembayaran.metodePembayaran();
        }
        if(pilihan == 2){
            // Method Bank
            this.pembayaran = new Bank();
            pembayaran.metodePembayaran();
        }
        if(pilihan == 3){
            // Method COD
            this.pembayaran = new Cod();
            pembayaran.metodePembayaran();
        }
    }

    /**
     * Metode untuk membuat invoice terbaru berdasarkan data transaksi dan list keranjang.
     */
    public void invoiceTerbaru() {
        BufferedWriter tulisInvoice = null;
        this.transaksi.bacaDatabaseTransaksi();
        String pathDatabaseInvoice = "Invoice.txt";
        this.listKeranjang = this.transaksi.getCustomer().getKeranjang().getListKeranjang();
        this.transaksi1 = this.transaksi.getTransaksi();
    
        try {
            tulisInvoice = new BufferedWriter(new FileWriter(pathDatabaseInvoice));
    
            if ((this.listKeranjang != null) && (this.transaksi1 != null)) {
                int index = 0;
    
                // Menulis data transaksi ke dalam file
                for (String tr : this.transaksi1) {
                    String token = this.transaksi1.get(index);
                    String[] token1 = token.split(" ");
                    tulisInvoice.write("id transaksi : " + token1[0] + "\n");
                    tulisInvoice.write("total harga : " + token1[1]+"\n");
                    tulisInvoice.newLine();
                    index++;
                }
    
                // Menulis data barang dari listKeranjang ke dalam file
                for (Barang keranjangItem : this.listKeranjang) {
                    String line = String.format("Kode Barang: %s\nNama Barang: %s\nJumlah: %d\nHarga: %d\n",
                            keranjangItem.getKodeBarang(),
                            keranjangItem.getNamaBarang(),
                            keranjangItem.getStok(),
                            keranjangItem.getHarga());
    
                    tulisInvoice.write(line);
                    tulisInvoice.newLine();
                }
                
    
                this.invoiceSelesai();
            } else {
                System.out.println("Keranjang kosong");
            }
    
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (tulisInvoice != null) {
                    tulisInvoice.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Metode untuk membuat invoice transaksi yang sudah selesai dan menyimpannya dalam file.
     */
    public void invoiceSelesai() {
        BufferedWriter tulisInvoice = null;
        this.transaksi.bacaDatabaseTransaksi();
        String pathDatabaseInvoice = "InvoiceSelesai.txt";
        this.transaksi1 = this.transaksi.getTransaksi();
    
        try {
            tulisInvoice = new BufferedWriter(new FileWriter(pathDatabaseInvoice, true)); // Gunakan true untuk mode append
    
            if ((this.listKeranjang != null) && (this.transaksi1 != null)) {
               
                // Menulis data transaksi ke dalam file
                for (String tr : this.transaksi1) {
                    String[] token1 = tr.split(" ");
                    tulisInvoice.write("id transaksi : " + token1[0] + "\n");
                    tulisInvoice.write("total harga : " + token1[1] + "\n");
                    tulisInvoice.newLine();
                    break;
                }
                
                // Menulis data barang dari listKeranjang ke dalam file
                for (Barang keranjangItem : this.listKeranjang) {
                    String line = String.format("Kode Barang: %s\nNama Barang: %s\nJumlah: %d\nHarga: %d\n",
                            keranjangItem.getKodeBarang(),
                            keranjangItem.getNamaBarang(),
                            keranjangItem.getStok(),
                            keranjangItem.getHarga());
    
                    tulisInvoice.write(line);
                    tulisInvoice.newLine();
                }
                
                // Bersihkan keranjang setelah selesai menulis
                // this.transaksi.getCustomer().getKeranjang().bersihkanKeranjang();
                
            } else {
                System.out.println("Keranjang kosong");
            }
    
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (tulisInvoice != null) {
                    tulisInvoice.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Metode untuk membaca isi file invoice.
     */
    public void bacaInvoice() {
        BufferedReader bacaInvoice = null;
        String pathDatabaseInvoice = "Invoice.txt";

        try {
            bacaInvoice = new BufferedReader(new FileReader(pathDatabaseInvoice));

            String line;
            while ((line = bacaInvoice.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (bacaInvoice != null) {
                    bacaInvoice.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Metode untuk membaca isi file invoice yang sudah selesai.
     */
    public void bacaInvoiceSelesai() {
        BufferedReader bacaInvoice = null;
        String pathDatabaseInvoice = "InvoiceSelesai.txt";

        try {
            bacaInvoice = new BufferedReader(new FileReader(pathDatabaseInvoice));

            String line;
            while ((line = bacaInvoice.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (bacaInvoice != null) {
                    bacaInvoice.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
