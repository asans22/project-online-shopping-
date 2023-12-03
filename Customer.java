import java.util.ArrayList;

/**
 * Kelas {@code Customer} merepresentasikan pengguna dengan peran sebagai pelanggan.
 * Kelas ini merupakan turunan dari kelas {@code Akun}.
 */
public class Customer extends Akun {
    private Keranjang keranjang;
    private ArrayList<Invoice> invoiceSelesai;

    /**
     * Konstruktor default untuk membuat instance {@code Customer}.
     * Inisialisasi objek Keranjang dan ArrayList InvoiceSelesai dilakukan.
     */
    public Customer() {
        super("iffa", "iffa123");
        this.keranjang = new Keranjang();
        this.invoiceSelesai = new ArrayList<>();
    }

    /**
     * Konstruktor untuk membuat instance {@code Customer} dengan ID dan password yang disediakan.
     *
     * @param id       ID pelanggan.
     * @param password Password pelanggan.
     */
    public Customer(String id, String password) {
        super(id, password);
        this.keranjang = new Keranjang();
        this.invoiceSelesai = new ArrayList<>();
    }

    /**
     * Metode untuk mendapatkan ID pelanggan.
     *
     * @return ID pelanggan.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Metode untuk mengatur ID pelanggan.
     *
     * @param newId ID baru yang akan diatur.
     */
    public void setId(String newId) {
        this.id = newId;
    }

    /**
     * Metode untuk mendapatkan password pelanggan.
     *
     * @return Password pelanggan.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Metode untuk mengatur password pelanggan.
     *
     * @param newPassword Password baru yang akan diatur.
     */
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    /**
     * Metode untuk mendapatkan objek Keranjang pelanggan.
     *
     * @return Objek Keranjang pelanggan.
     */
    public Keranjang getKeranjang() {
        return this.keranjang;
    }

    /**
     * Metode untuk mendapatkan ArrayList Invoice yang sudah selesai.
     *
     * @return ArrayList Invoice yang sudah selesai.
     */
    public ArrayList<Invoice> getInvoiceSelesai() {
        return this.invoiceSelesai;
    }
}
