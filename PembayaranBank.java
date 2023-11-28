import java.util.Scanner;

public class PembayaranBank extends Pembayaran {
    private String nomorATM;
    private String passwordATM;
    private int totalHarga;

    public PembayaranBank(String nomorATM, String passwordATM, int totalHarga) {
        this.nomorATM = nomorATM;
        this.passwordATM = passwordATM;
        this.totalHarga = totalHarga;
    }

    @Override
    public void metodePembayaran() {
        // Penjelasan mengenai pembayaran menggunakan bank
        Scanner scanner = new Scanner(System.in);
        System.out.println("Metode Pembayaran: Bank Transfer");
        System.out.print("Masukkan nomor ATM: ");
        String inputNomorATM = scanner.nextLine();
        System.out.print("Masukkan password ATM: ");
        String inputPasswordATM = scanner.nextLine();
        System.out.print("Masukkan total harga yang dibayar: ");
        int inputTotalHarga = scanner.nextInt();

        if (inputNomorATM.equals(nomorATM) && inputPasswordATM.equals(passwordATM) && inputTotalHarga == totalHarga) {
            // Output
            System.out.println("Pembayaran berhasil");
            System.out.println("=====================================");
            System.out.println("Customer: " + getTransaksi().getAkun().getId());
            System.out.println("Barang yang dibeli:");
            for (Barang item : getTransaksi().getBarang()) {
                System.out.println("- " + item.getNamaBarang() + " (Qty: " + item.getStok() + ")");
            }
            System.out.println("=====================================");
            System.out.println("Total Harga: " + totalHarga);
            System.out.println("Metode Pembayaran: Bank Transfer");
            System.out.println("=====================================");
        } else {
            System.out.println("Pembayaran gagal. Nomor ATM, password, atau total harga tidak sesuai.");
        }
        scanner.close();
    }
}
