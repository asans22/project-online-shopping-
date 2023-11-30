import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListBarang {
    // class untuk melihat daftar barang1 yang ada
    private ArrayList<Barang> barang;

    public ListBarang(){
        this.barang = new ArrayList<Barang>();
    }

    //method baca database
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
    public void tampilkanListBarang(){
        this.bacaDatabase();

        barang.forEach((barang1)->{
            System.out.println("kode barang : " +barang1.getKodeBarang());
            System.out.println("nama barang : " +barang1.getNamaBarang());
            System.out.println("stok barang : " +barang1.getStok());
            System.out.println("harga barang : " +barang1.getHarga());
            System.out.println(" ");
        });

        
        this.barang.clear();

    }

    public void tambahBarang(){
        this.bacaDatabase();

        Scanner s = new Scanner(System.in);

        System.out.print("masukkan kode barang : ");
        String kodeBarang = s.nextLine();
        
        System.out.print("masukkan nama barang : ");
        String namaBarang = s.nextLine();
        
        System.out.print("masukkan  stok : ");
        int stok = s.nextInt();
        
        System.out.print("masukkan harga : ");
        int harga = s.nextInt();

        Barang newBarang = new Barang();

        newBarang.setKodeBarang(kodeBarang);
        newBarang.setNamaBarang(namaBarang);
        newBarang.setStok(stok);
        newBarang.setHarga(harga);

        this.barang.add(newBarang);
        this.writeDatabase();


    }
    private void writeDatabase(){
        BufferedWriter databaseBarang = null;
        // String tulisDatabaseBarang;
        String pathDatabase = "List Barang.txt";

        try{
            databaseBarang = new BufferedWriter(new FileWriter(pathDatabase));
            for(Barang barang1 : this.barang){
                String line = String.format("%s %s %d %d",
                barang1.getKodeBarang(),
                barang1.getNamaBarang(),
                barang1.getStok(),
                barang1.getHarga());

                databaseBarang.write(line);
                databaseBarang.newLine();
           }
        } catch(IOException e){
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
    public void editBarang(){
        this.bacaDatabase();
        BufferedReader bacaDatabase = null;
        Scanner s = new Scanner(System.in);
        Barang barangEdit = new Barang();
        String kodeBarang;
        System.out.println("===  EDIT BARANG ===");
        System.out.print("masukkan kode barang : ");
        kodeBarang = s.nextLine();

        try {
            
            for(int i=0 ; i<this.barang.size();i++){
                if(kodeBarang.equals(this.barang.get(i).getKodeBarang())){
                    System.out.println("edit barang " + this.barang.get(i).getNamaBarang());
                    System.out.print("masukkan stok : ");
                    String newStok = s.nextLine();
                    System.out.print("masukkan harga : ");
                    String newHarga = s.nextLine();

                    barangEdit.setKodeBarang(kodeBarang);
                    barangEdit.setNamaBarang(this.barang.get(i).getNamaBarang());
                    barangEdit.setStok(Integer.parseInt(newStok));
                    barangEdit.setHarga(Integer.parseInt(newHarga));

                    this.barang.set(i, barangEdit);

                }
            }
            this.writeDatabase();
            this.barang.clear();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }finally{
            if(bacaDatabase != null){
                try {
                    bacaDatabase.close();
                } catch (IOException e) {
                    
                    System.out.println((e));
                }
            }
        
        }

        
         
    }
    public void hapusBarang(){
        this.bacaDatabase();
        Scanner s = new Scanner(System.in);
        String kodeBarang;
        System.out.println("===  HAPUS BARANG ===");
        System.out.print("masukkan kode barang : ");
        kodeBarang = s.nextLine();

        for(int i = 0 ; i<this.barang.size();i++){
            if(kodeBarang.equals(this.barang.get(i).getKodeBarang())){
                this.barang.remove(i);
            }
        }
        this.writeDatabase();
        this.barang.clear();

    }
    

    

}
