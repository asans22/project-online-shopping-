/**
 * Kelas {@code Akun} mewakili akun pengguna dengan ID dan kata sandi.
 * Kelas ini berisi metode-metode untuk mendapatkan dan mengatur ID serta kata sandi pengguna.
 */
public class Akun {
    protected String id;
    protected String password;

    /**
     * Konstruktor default untuk membuat instance {@code Akun} dengan nilai ID dan kata sandi default.
     * Nilai default diatur sebagai "0" untuk ID dan "0" untuk kata sandi.
     */
    public Akun() {
        this.id = "0";
        this.password = "0";
    }

    /**
     * Konstruktor untuk membuat instance {@code Akun} dengan ID dan kata sandi yang disediakan.
     *
     * @param id       ID pengguna.
     * @param password Kata sandi pengguna.
     */
    public Akun(String id, String password) {
        this.id = id;
        this.password = password;
    }

    /**
     * Mendapatkan ID pengguna.
     *
     * @return ID pengguna.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Mengatur ID baru untuk pengguna.
     *
     * @param newId ID baru yang akan diatur.
     */
    public void setId(String newId) {
        this.id = newId;
    }

    /**
     * Mendapatkan kata sandi pengguna.
     *
     * @return Kata sandi pengguna.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Mengatur kata sandi baru untuk pengguna.
     *
     * @param newPassword Kata sandi baru yang akan diatur.
     */
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}
