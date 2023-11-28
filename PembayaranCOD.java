public class PembayaranCOD extends Pembayaran {

    @Override
    public void metodePembayaran() {
        // Penjelasan mengenai pembayaran COD
        System.out.println("Metode Pembayaran: COD (Cash On Delivery)");
        System.out.println("1. Barang telah diterima.");
        System.out.println("2. Muncul invoice.");
        // Output
        System.out.println("Barang telah diterima. Invoice:");
        System.out.println("=====================================");
        System.out.println("Customer: " + getTransaksi().getAkun().getId());
        System.out.println("Barang yang dibeli:");
        for (Barang item : getTransaksi().getBarang()) {
            System.out.println("- " + item.getNamaBarang() + " (Qty: " + item.getStok() + ")");
        }
        System.out.println("=====================================");
        System.out.println("Total Harga: [TotalHarga]");
        System.out.println("Metode Pembayaran: COD");
        System.out.println("=====================================");
    }
}
