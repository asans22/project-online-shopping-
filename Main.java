
import java.util.Scanner;


public class Main{

    public static Akun akun;
    public static Akun password;
      public Driver driverAkun;

      public static void login(Akun akun,Akun password2){
         Admin admin1 = new Admin();
         Customer customer1 = new Customer();
        if((akun.getId().equals(admin1.getId()))&&(akun.getPassword().equals(admin1.getPassword()))){
            System.out.println("berhasil login sebagai admin");
            AdminDriver adminDriver = new AdminDriver();//merujuk ke admindriver
            adminDriver.menu();
        }
        if((akun.getId().equals(customer1.getId())) && (akun.getPassword().equals(customer1.getPassword()))){
            System.out.println("berhasil login sebagai customer");
            //merujuk ke customerdriver

        }
         }

    public static void main(String[] args) {
  
       
        Scanner s = new Scanner(System.in);
        akun = new Akun();
       
       
         System.out.println("selamat datang di toko ayadesign");
         System.out.println("====== LOGIN =======");
         System.out.print("Akun:");
         akun.setId(s.nextLine());
         System.out.print("password:");
         akun.setPassword(s.nextLine());
        

         login(akun, password);

        //  login(ID,password);
        
        // int pilihan;
        // if(ID.equals(admin1.getId())){
        //     System.out.println("selamat datang admin "+nama);
        //     System.out.println(" ");
        //     System.out.println("menu:");
            
        //     do{
        //     //pilihan admin
        //     System.out.println(" ");
        //     System.out.println("1.lihat list barang");
        //     System.out.println("2.tambah barang");
        //     System.out.println("3.edit barang");
        //     System.out.println("4.hapus barang");
        //     System.out.println("5.invoice selesai");
        //     System.out.println("6.logout");
        //     System.out.print("masukkan pilihan anda:");
        //      pilihan = s.nextInt();
        //      System.out.println(" ");

        //     ListBarang list1 = new ListBarang();
          
        //     // jika pilihan 1
        //     if(pilihan == 1){
                
        //         //manggil list barang 
        //       list1.tampilkanListBarang();

        //     }
        //     if(pilihan == 2){
        //         //menambahkan barang
        //         list1.tambahBarang();
                
        //     }
        //     if(pilihan == 3){
        //         list1.editBarang();
        //     }
        //     if(pilihan == 4){
        //         list1.hapusBarang();
        //     }
        //     if(pilihan == 5){
        //         //method untuk manggil invoice
        //     }
        // }while(pilihan!=6);


            

        // }

         
            s.close();
    }

   
}