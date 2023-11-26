
public class Barang {
    // class untuk menambahkan,mengedit dan menghapus barang
    private String kodeBarang;
    private String namaBarang;
    private int stok;
    private int harga;

    public Barang(){
        kodeBarang = "000";
        namaBarang = "not found";
        stok = 0;
        harga = 0;
    }
    public String getKodeBarang(){
        return this.kodeBarang;
    }
    public void setKodeBarang(String kodeBarang){
        this.kodeBarang = kodeBarang;
    }
    public String getNamaBarang(){
        return this.namaBarang;
    }
    public void setNamaBarang(String namaBarang){
        this.namaBarang = namaBarang;
    }
    public int getStok(){
        return this.stok;
    }
    public void setStok(int stok){
        this.stok = stok;
    }
    public int getHarga(){
        return this.harga;
    }
    public void setHarga(int harga){
        this.harga = harga;
    }

    
}
