import java.util.ArrayList;
import java.util.Scanner;
public class AdminDriver extends Driver {
    private Admin akun;
    private ListBarang listBarang;
    private ArrayList<Transaksi> listTransaksi;

    public void menu(){
        Scanner s = new Scanner(System.in);
        int pilihan;
        listBarang = new ListBarang();
       do{
         System.out.println("menu : ");
        System.out.println(" ");
             System.out.println("1.lihat list barang");
            System.out.println("2.tambah barang");
            System.out.println("3.edit barang");
            System.out.println("4.hapus barang");
            System.out.println("5.invoice selesai");
            System.out.println("6.logout");
            System.out.print("masukkan pilihan anda:");
            pilihan = s.nextInt();
            System.out.println(" ");

                 // jika pilihan 1
            if(pilihan == 1){
                
                //manggil list barang 
              listBarang.tampilkanListBarang();

            }
            if(pilihan == 2){
                //menambahkan barang
                listBarang.tambahBarang();
                
            }
            if(pilihan == 3){
                listBarang.editBarang();
            }
            if(pilihan == 4){
                listBarang.hapusBarang();
            }
            if(pilihan == 5){
                //method untuk manggil invoice
            }
            

       }while(pilihan != 6);
       s.close();

    }
}
