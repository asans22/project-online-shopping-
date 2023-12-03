/**
 * Kelas {@code Admin} mewakili pengguna administratif yang merupakan turunan dari kelas {@code Akun}.
 * Ini mencakup metode untuk mendapatkan dan mengatur ID pengguna serta kata sandi.
 */
public class Admin extends Akun {

    /**
     * Membangun instance {@code Admin} baru dengan nilai default untuk ID dan kata sandi.
     * Nilai default diatur sebagai "ahmad" untuk ID dan "ahmad123" untuk kata sandi.
     */
    public Admin() {
        super("ahmad", "ahmad123");
    }

    /**
     * Mendapatkan ID saat ini dari pengguna admin.
     *
     * @return ID dari pengguna admin.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Mengatur ID baru untuk pengguna admin.
     *
     * @param newId ID baru yang akan diatur.
     */
    public void setId(String newId) {
        this.id = newId;
    }

    /**
     * Mendapatkan kata sandi saat ini dari pengguna admin.
     *
     * @return Kata sandi dari pengguna admin.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Mengatur kata sandi baru untuk pengguna admin.
     *
     * @param newPassword Kata sandi baru yang akan diatur.
     */
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}
