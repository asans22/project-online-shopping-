import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListBarang {
    // class untuk melihat daftar barang yang ada
    private ArrayList<Barang> barang;

    public ListBarang(){
        this.barang = new ArrayList<Barang>();
    }

    //method baca barang
    public void bacaBarang(){
         try {
                    File myObj = new File("List Barang.txt");
                    Scanner s = new Scanner(myObj);
                    while (s.hasNextLine()) {
                    String data = s.nextLine();
                    String[] parts = data.split(" ");
                    
                    if(parts.length == 4){
                        String kodeBarang = parts[0].trim();
                        String namaBarang = parts[1].trim();
                        int stok = Integer.parseInt(parts[2].trim());
                        int harga = Integer.parseInt(parts[3].trim());

                        System.out.println("kode barang: "+kodeBarang);
                        System.out.println("nama barang: "+namaBarang);
                        System.out.println("stok: "+stok);
                        System.out.println("harga: "+harga);
                        System.out.println(" ");
                        
                    }
                    }
                        s.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
    } 


    //method tambah barang
    public  void tambahBarang(){
        try {
            Scanner s = new Scanner(System.in);
            FileWriter fileWriter = new FileWriter("List barang.txt", true);
            System.out.print("masukkan kode barang: ");
            String kodeBarang =  s.nextLine();
            System.out.print("masukkan nama barang: ");
            String namaBarang =  s.nextLine();
            System.out.print("masukkan stok barang: ");
            int stok =  s.nextInt();
            System.out.print("masukkan harga barang: ");
            int harga =  s.nextInt();
            fileWriter.write(kodeBarang + " " + namaBarang + " " + stok + " " + harga + "\n");
            fileWriter.close();
            System.out.println("barang berhasil ditambahkan.");
        }catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
            e.printStackTrace();
        }
    }
                    // File myObj = new File("List Barang.txt");
                    // if (myObj.createNewFile()) {
                    //     System.out.println("File created: " + myObj.getName());
                    // } else {
                    //     String listBarang = "List Barang.txt";
                    //     FileWriter fileWriter = new FileWriter(listBarang, true);

                         
                    // }   
                    // } catch (IOException e) {
                    //     System.out.println("An error occurred.");
                    //     e.printStackTrace();
                    // }
    

    

}
