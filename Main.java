
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
            Driver driverAkun = new AdminDriver();//merujuk ke admindriver
            driverAkun.menu();
        }
        if((akun.getId().equals(customer1.getId())) && (akun.getPassword().equals(customer1.getPassword()))){
            System.out.println("berhasil login sebagai customer");
            //merujuk ke customerdriver
            Driver driverAkun = new CustomerDriver(customer1);
            driverAkun.menu();

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

         
            s.close();
    }

   
}