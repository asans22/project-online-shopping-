public abstract class Pembayaran {
    protected String id;

    public abstract void metodePembayaran();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
