import java.util.ArrayList;

public class Transaksi {
    private Customer akun;
    private ArrayList<Barang> barang;

    public void checkout() {
        Keranjang keranjang = new Keranjang();

        System.out.println("Isi keranjang sebelum checkout: ");
        keranjang.lihatKeranjang();

        System.out.println("\nPilih metode pembayaran: ");
        System.out.println("1. Pembayaran melalui QRIS");
        System.out.println("2. Pembayaran melalui Bank");
        System.out.println("3. Pembayaran melalui COD");

        
    }
}
