/**
 * Kelas {@code Barang} merepresentasikan suatu barang dengan informasi seperti kode barang, nama barang, stok, dan harga.
 * Kelas ini memiliki metode-metode untuk mendapatkan dan mengatur informasi barang.
 */
public class Barang {
    private String kodeBarang;
    private String namaBarang;
    private int stok;
    private int harga;

    /**
     * Konstruktor default untuk membuat instance {@code Barang} dengan nilai default.
     * Nilai default diatur sebagai kodeBarang "000", namaBarang "not found", stok 0, dan harga 0.
     */
    public Barang() {
        kodeBarang = "000";
        namaBarang = "not found";
        stok = 0;
        harga = 0;
    }

    /**
     * Metode untuk mendapatkan kode barang.
     *
     * @return Kode barang.
     */
    public String getKodeBarang() {
        return this.kodeBarang;
    }

    /**
     * Metode untuk mengatur kode barang.
     *
     * @param kodeBarang Kode barang baru yang akan diatur.
     */
    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    /**
     * Metode untuk mendapatkan nama barang.
     *
     * @return Nama barang.
     */
    public String getNamaBarang() {
        return this.namaBarang;
    }

    /**
     * Metode untuk mengatur nama barang.
     *
     * @param namaBarang Nama barang baru yang akan diatur.
     */
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    /**
     * Metode untuk mendapatkan stok barang.
     *
     * @return Jumlah stok barang.
     */
    public int getStok() {
        return this.stok;
    }

    /**
     * Metode untuk mengatur stok barang.
     *
     * @param stok Jumlah stok barang baru yang akan diatur.
     */
    public void setStok(int stok) {
        this.stok = stok;
    }

    /**
     * Metode untuk mendapatkan harga barang.
     *
     * @return Harga barang.
     */
    public int getHarga() {
        return this.harga;
    }

    /**
     * Metode untuk mengatur harga barang.
     *
     * @param harga Harga barang baru yang akan diatur.
     */
    public void setHarga(int harga) {
        this.harga = harga;
    }

    /**
     * Metode untuk menghasilkan representasi string dari objek {@code Barang}.
     *
     * @return String representasi dari objek {@code Barang}.
     */
    @Override
    public String toString() {
        return "Barang{" +
                "kodeBarang='" + kodeBarang + '\'' +
                ", namaBarang='" + namaBarang + '\'' +
                ", stok=" + stok +
                ", harga=" + harga +
                '}';
    }
}
