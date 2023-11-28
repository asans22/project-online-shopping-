public class PembayaranQRIS extends Pembayaran {

    @Override
    public void metodePembayaran() {
        
        System.out.println("Metode Pembayaran: QRIS (Quick Response Code)");
        System.out.println("QR Code:");
        System.out.println("QR CODE");
        System.out.println("Pilihan:");
        System.out.println("1. Scan QR Code");
        
        
        System.out.println("Pembayaran selesai untuk jumlah barang: [TotalBarang]");
        System.out.println("Invoice:");
        System.out.println("=====================================");
        System.out.println("Customer: " + getTransaksi().getAkun().getId());
        System.out.println("Barang yang dibeli:");
        for (Barang item : getTransaksi().getBarang()) {
            System.out.println("- " + item.getNamaBarang() + " (Qty: " + item.getStok() + ")");
        }
        System.out.println("=====================================");
    }
}
