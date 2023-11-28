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

        Scanner scan = new Scanner(System.in);
        System.out.println("Masukkan pilihan anda: ");
        int metodePembayaran = scan.nextInt();

        // proses pembayaran 
        switch (metodePembayaran) {
            case 1:
                // pemanggilan method pembayaran dengan QRIS
                break;
            
            case 2:
                // pemanggilan method pembayaran dengan Bank
                break;

            case 3:
                // pemanggilan method pembayaran dengan COD
                break;

            default:
                break;
        }
    }
}
