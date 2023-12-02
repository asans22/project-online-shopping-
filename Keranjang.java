import java.io.BufferedReader;
import java.io.BufferedWriter;
// import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Keranjang {
    private ArrayList<Barang> barang;

    private ArrayList<Barang> listKeranjang;
    private Scanner s = new Scanner(System.in);

    public Keranjang(){
        this.barang = new ArrayList<Barang>();
 
        this.listKeranjang = new ArrayList<Barang>();
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
    public void bacaDatabaseKeranjang(){
    BufferedReader databaseKeranjang=null;
    String bacaDatabaseKeranjang;
    String pathReaderKeranjang = "Keranjang.txt";
    
    try{
        databaseKeranjang = new BufferedReader(new FileReader(pathReaderKeranjang));
        while((bacaDatabaseKeranjang=databaseKeranjang.readLine())!= null){
            Barang keranjang1 = new Barang();
            String[] token = bacaDatabaseKeranjang.split(" ");
            
            keranjang1.setKodeBarang(token[0]);
            keranjang1.setNamaBarang(token[1]);
            keranjang1.setStok(Integer.parseInt(token[2]));
            keranjang1.setHarga(Integer.parseInt(token[3]));

        
            this.listKeranjang.add(keranjang1);
            
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
       
        
    }
  }
  public void lihatKeranjang(){
   this.bacaDatabaseKeranjang();
    System.out.println("data keranjang anda : ");
    listKeranjang.forEach((keranjang1)->{
    System.out.println("kode barang : " + keranjang1.getKodeBarang());
    System.out.println("nama barang : " + keranjang1.getNamaBarang());
    System.out.println("stok : " + keranjang1.getStok());
    System.out.println("harga : " + keranjang1.getHarga());
    System.out.println(" ");
   });


    System.out.println("Jumlah barang dalam keranjang: " + listKeranjang.size()); 
    this.listKeranjang.clear();
  }

    public void tambahBarangKeKeranjang(){
        this.bacaDatabase();
        this.bacaDatabaseKeranjang();
        
        System.out.println("===== masukkan barang ke keranjang =====");
        System.out.print("kode barang : ");
        String kodebarang = s.nextLine();
        System.out.print("jumlah barang : ");
        int jumlahBarang = Integer.parseInt(s.nextLine());
        
        for(int i = 0 ;i<this.barang.size();i++){
            if(kodebarang.equals(this.barang.get(i).getKodeBarang())){
                Barang newBarangKeranjang  =  new Barang();
                newBarangKeranjang.setKodeBarang(barang.get(i).getKodeBarang());
                newBarangKeranjang.setNamaBarang(barang.get(i).getNamaBarang());
                newBarangKeranjang.setStok(jumlahBarang);
                newBarangKeranjang.setHarga(barang.get(i).getHarga());
                
                this.listKeranjang.add(newBarangKeranjang);
                this.writeDatabasekeranjang(); 
                break;
                
            }
        }
        
        this.listKeranjang.clear();


    }
    public  void writeDatabasekeranjang(){
        
        BufferedWriter dataBaseKeranjang = null ;
        String pathDatabaseKeranjang = "Keranjang.txt";

        try{
            dataBaseKeranjang = new BufferedWriter(new FileWriter(pathDatabaseKeranjang));
            for(Barang keranjang1 :this.listKeranjang){
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
        this.listKeranjang.clear();
  }
  public void editBarangKeranjang(){
    this.bacaDatabaseKeranjang();
    BufferedWriter editkeranjang = null ;
    Barang editBarang = new Barang();
    String kodeBarang ;
    System.out.println("===== EDIT BARANG DIKERANJANG ======");
    System.out.print("kode barang: ");
    kodeBarang = s.nextLine();
    
    try {
        for(int i=0;i<this.listKeranjang.size();i++){
            if(kodeBarang.equals(this.listKeranjang.get(i).getKodeBarang())){
                System.out.println("edit barang "+this.listKeranjang.get(i).getNamaBarang() +" di keranjang");
                System.out.print("masukkan jumlah terbaru : ");
                String newJumlah = s.nextLine();

                editBarang.setKodeBarang(kodeBarang);
                editBarang.setNamaBarang(this.listKeranjang.get(i).getNamaBarang());
                editBarang.setStok(Integer.parseInt(newJumlah));
                editBarang.setHarga(this.listKeranjang.get(i).getHarga());

                this.listKeranjang.set(i,editBarang);

            }
        }
        this.writeDatabasekeranjang();
        this.listKeranjang.clear();
    } catch (Exception e) {
        // TODO: handle exception
        System.out.println(e);
    }finally{
        if(editkeranjang != null){
            try {
                editkeranjang.close();
            } catch (IOException e) {
                // TODO: handle exception
                System.out.println(e);
            }
        }
    }
  }


  public void hapusBarangDariKeranjang() {
    this.bacaDatabaseKeranjang();
    
    System.out.print("Masukkan kode barang yang ingin dihapus dari keranjang: ");
    String kodeBarang = s.nextLine();

    boolean found = false;

    // Iterasi melalui listKeranjang dan hapus barang jika kodeBarang sesuai
    for (int i = 0; i < this.listKeranjang.size(); i++) {
        if (kodeBarang.equals(this.listKeranjang.get(i).getKodeBarang())) {
            this.listKeranjang.remove(i);
            found = true;
            break;
        }
    }

    if (found) {
        System.out.println("Barang berhasil dihapus dari keranjang.");
        this.writeDatabasekeranjang(); // Menulis ulang database setelah menghapus barang
    } else {
        System.out.println("Barang dengan kode " + kodeBarang + " tidak ditemukan dalam keranjang.");
    }

    this.listKeranjang.clear();
}

public int totalHarga() {
    this.bacaDatabaseKeranjang();
    
    int jumlahHarga = 0; // Inisialisasi jumlahHarga menjadi 0

    for (int i = 0; i < this.listKeranjang.size(); i++) {
        int jumlahStok = this.listKeranjang.get(i).getStok(); // Inisialisasi jumlahStok di dalam loop
        int harga = this.listKeranjang.get(i).getHarga(); // Inisialisasi harga di dalam loop
        jumlahHarga += jumlahStok * harga; // Akumulasi total harga
    }

    return jumlahHarga;
}

  
}