/**
 * Kelas {@code Driver} merupakan kelas abstrak yang memberikan dasar untuk kelas driver lainnya.
 * Kelas ini memiliki atribut driver dan metode abstrak menu yang akan diimplementasikan oleh kelas turunannya.
 */
public abstract class Driver {
    public String driver;

    /**
     * Metode abstrak yang harus diimplementasikan oleh kelas turunan.
     * Metode ini akan menangani menu dan aksi yang spesifik untuk setiap kelas turunan.
     */
    public abstract void menu();
}
