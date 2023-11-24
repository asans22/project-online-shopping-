import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Main{

      public Akun akun;
      public Driver driverAkun;

    //   public static void login(Akun akun,String password){
    //      if(akun == "ahmad syah ramadhan" && password == "ahmad123" ){

    //      }
    //      }

    public static void main(String[] args) {
  
       
        Scanner s = new Scanner(System.in);
        Admin admin1 = new Admin();
         System.out.println("selamat datang di toko ayadesign");
         System.out.println("====== LOGIN =======");
         System.out.print("ID:");
         String ID = s.nextLine(); 
         System.out.print("nama:");
         String nama = s.nextLine();
         System.out.print("password:");
         String password= s.nextLine();

        //  login(ID,password);
        
        int pilihan;
        if(ID.equals(admin1.getId())){
            System.out.println("selamat datang admin "+nama);
            System.out.println(" ");
            System.out.println("menu:");
            
            do{
            //pilihan admin
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

            ListBarang list1 = new ListBarang();
            // jika pilihan 1
            if(pilihan == 1){
                
                //manggil list barang 
               list1.bacaBarang();

            }
            if(pilihan == 2){
                //menambahkan barang
                list1.tambahBarang();
                
            }
        }while(pilihan!=6);


            

        }

         

    }

   
}