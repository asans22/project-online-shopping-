public abstract class Pembayaran {
    protected String id;
    protected Transaksi transaksi; // tambahkan atribut transaksi

    public Pembayaran(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public abstract void metodePembayaran();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
