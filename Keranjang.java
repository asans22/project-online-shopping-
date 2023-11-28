import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Keranjang {
    private ArrayList<Barang> barang;
    public ArrayList<Barang> keranjang ;
    private Scanner s = new Scanner(System.in);

    public Keranjang(){
        this.barang = new ArrayList<Barang>();
        this.keranjang = new ArrayList<Barang>();
    }
     private void bacaDatabase(){
        BufferedReader databaseBarang = null;
        String bacaDatabeseBarang;
        String pathDatabase = "List Barang.txt";
        try{
            databaseBarang = new BufferedReader(new FileReader(pathDatabase));
            while((bacaDatabeseBarang=databaseBarang.readLine())!= null){
                Barang barang1 = new Barang();
                String[] token = bacaDatabeseBarang.split(" ");

                barang1.setKodeBarang(token[0]);
                barang1.setNamaBarang(token[1]);
                barang1.setStok(Integer.parseInt(token[2]));
                barang1.setHarga(Integer.parseInt(token[3]));

                this.barang.add(barang1);

            }
        }catch(IOException e){
            System.out.println(e);
        }finally{
            try{
                if(databaseBarang != null){
                    databaseBarang.close();
                }
            }catch(IOException e){
                System.out.println(e);
            }
        }
    }
    public void tambahBarangKeKeranjang(){
        this.bacaDatabase();
        
        System.out.println("===== masukkan barang ke keranjang =====");
        System.out.print("kode barang : ");
        String kodebarang = s.nextLine();
        System.out.print("jumlah barang : ");
        int jumlahBarang = Integer.parseInt(s.nextLine());
        
        boolean barangSudahAda = false;

        System.out.println(this.barang.size());
        System.out.println(this.keranjang);

        for(int i = 0 ;i<this.barang.size();i++){
            for(Barang item : this.keranjang){
                if(kodebarang.equals(kodebarang)){
                    item.setStok(item.getStok()+jumlahBarang);
                    barangSudahAda = true;
                    System.out.println(jumlahBarang + " " + kodebarang + " telah di tambahkan ke dalam database keranjang belanja.");
                    break;
                } else {
                    System.out.println("Stok tidak mencukupi untuk " + kodebarang + " Stok yang tersedia: " + item.getStok());
                }

                if(!barangSudahAda){
                    for(Barang barangDatabase : this.barang){
                        if(kodebarang.equals(barangDatabase.getKodeBarang())){
                            Barang barangBaruKeranjang = new Barang();
                            barangBaruKeranjang.setKodeBarang(kodebarang);
                            barangBaruKeranjang.setNamaBarang(this.barang.get(i).getNamaBarang());
                            barangBaruKeranjang.setStok(jumlahBarang);
                            barangBaruKeranjang.setHarga(this.barang.get(i).getHarga());
                            this.keranjang.add(barangBaruKeranjang);
                            tambahBarangKeDatabaseKeranjang();
                           
                        }
                    }
                }
                tambahBarangKeDatabaseKeranjang();
            }
        }
        


    }
    public  void tambahBarangKeDatabaseKeranjang(){
        BufferedWriter dataBaseKeranjang = null ;
        String pathDatabaseKeranjang = "Keranjang.txt";

        try{
            dataBaseKeranjang = new BufferedWriter(new FileWriter(pathDatabaseKeranjang));
            for(Barang keranjang1 :this.keranjang){
                String line = String.format("%s %s %d %d",
                keranjang1.getKodeBarang(),
                keranjang1.getNamaBarang(),
                keranjang1.getStok(),
                keranjang1.getHarga());

                dataBaseKeranjang.write(line);
                dataBaseKeranjang.newLine();
                
            }
        }catch(IOException e){
            System.out.println(e);
        }finally{
            try{
                if(dataBaseKeranjang != null){
                    dataBaseKeranjang.close();
                }
            }catch(IOException e){
                System.out.println(e);
            }
        }
  }
  public void bacaDatabaseKeranjang(){
    BufferedReader databaseKeranjang=null;
    String bacaDatabaseKeranjang;
    String pathReaderKeranjang = "Keranjang.txt";
    this.keranjang.clear();
    try{
        databaseKeranjang = new BufferedReader(new FileReader(pathReaderKeranjang));
        while((bacaDatabaseKeranjang=databaseKeranjang.readLine())!= null){
            Barang keranjang1 = new Barang();
            String[] token = bacaDatabaseKeranjang.split(" ");
            
            keranjang1.setKodeBarang(token[0]);
            keranjang1.setNamaBarang(token[1]);
            keranjang1.setHarga(Integer.parseInt(token[2]));
            keranjang1.setHarga(Integer.parseInt(token[3]));

            this.keranjang.add(keranjang1);
        }
    }catch(IOException e){
        System.out.println(e);
    }finally{
        try{
            if(databaseKeranjang != null){
                databaseKeranjang.close();
            }
    
        }catch(IOException e){
            System.out.println(e);
        }
        // this.keranjang.clear();
        
    }
  }
  public void lihatKeranjang(){
   this.bacaDatabaseKeranjang();
    System.out.println("data keranjang anda : ");
   barang.forEach((keranjang1)->{
    System.out.println("kode barang : " + keranjang1.getKodeBarang());
    System.out.println("nama barang : " + keranjang1.getNamaBarang());
    System.out.println("stok : " + keranjang1.getStok());
    System.out.println("harga : " + keranjang1.getHarga());
    System.out.println(" ");
   });

   this.keranjang.clear();
  }
}