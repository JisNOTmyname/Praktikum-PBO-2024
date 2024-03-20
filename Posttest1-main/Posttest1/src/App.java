import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

class Nasabah {
    private String nama;
    private String nomorRekening;
    private String cif;
    private String nomorKTP;
    private String alamat;
    private Date tanggalLahir;
    private String namaIbuKandung;
    private String pekerjaan;

    public Nasabah(String nama, String nomorRekening, String cif, String nomorKTP, String alamat, Date tanggalLahir, String namaIbuKandung, String pekerjaan) {
        this.nama = nama;
        this.nomorRekening = nomorRekening;
        this.cif = cif;
        this.nomorKTP = nomorKTP;
        this.alamat = alamat;
        this.tanggalLahir = tanggalLahir;
        this.namaIbuKandung = namaIbuKandung;
        this.pekerjaan = pekerjaan;
    }

    public String getNama() {
        return nama;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public String getCif() {
        return cif;
    }

    public String getNomorKTP() {
        return nomorKTP;
    }

    public String getAlamat() {
        return alamat;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public String getNamaIbuKandung() {
        return namaIbuKandung;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public void setNomorKTP(String nomorKTP) {
        this.nomorKTP = nomorKTP;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public void setNamaIbuKandung(String namaIbuKandung) {
        this.namaIbuKandung = namaIbuKandung;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return "Nama: " + nama + 
               "\nNomor Rekening: " + nomorRekening + 
               "\nCIF: " + cif +
               "\nNomor KTP: " + nomorKTP + 
               "\nAlamat: " + alamat + 
               "\nTanggal Lahir: " + dateFormat.format(tanggalLahir) + 
               "\nNama Ibu Kandung: " + namaIbuKandung + 
               "\nPekerjaan: " + pekerjaan;
    }
}

class Transaksi {
    private String jenisTransaksi;
    private double jumlah;
    private Date tanggal;
    private String nomorRekening;
    private String nama;
    private String currencyCode;
    private String deskripsi;
    private String tipeTransaksi;

    public Transaksi(String jenisTransaksi, double jumlah, Date tanggal, String nomorRekening, String nama, String currencyCode, String deskripsi, String tipeTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
        this.jumlah = jumlah;
        this.tanggal = tanggal;
        this.nomorRekening = nomorRekening;
        this.nama = nama;
        this.currencyCode = currencyCode;
        this.deskripsi = deskripsi;
        this.tipeTransaksi = tipeTransaksi;
    }

    public String getJenisTransaksi() {
        return jenisTransaksi;
    }

    public double getJumlah() {
        return jumlah;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public String getNama() {
        return nama;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getTipeTransaksi() {
        return tipeTransaksi;
    }

    public void setJenisTransaksi(String jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setTipeTransaksi(String tipeTransaksi) {
        this.tipeTransaksi = tipeTransaksi;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return "Jenis Transaksi: " + jenisTransaksi + 
               "\nNomor Rekening: " + nomorRekening +
               "\nNama: " + nama +
               "\nJumlah: " + jumlah + 
               "\nCurrency Code: " + currencyCode + 
               "\nDeskripsi: " + deskripsi + 
               "\nTanggal: " + dateFormat.format(tanggal) + 
               "\nTipe Transaksi: " + tipeTransaksi;
    }
}

class BankSyariah {
    private ArrayList<Nasabah> dataNasabah = new ArrayList<>();
    private ArrayList<Transaksi> dataTransaksi = new ArrayList<>();
    private Random random = new Random();

    public void tambahNasabah(Nasabah nasabah) {
        nasabah.setNomorRekening(generateNomorRekening());
        nasabah.setCif(generateCIF());
        dataNasabah.add(nasabah);
        System.out.println("Nasabah berhasil ditambahkan.");
    }

    public void tambahTransaksi(Transaksi transaksi) {
        dataTransaksi.add(transaksi);
        System.out.println("Transaksi berhasil ditambahkan.");
    }

    public void lihatNasabah() {
        if (dataNasabah.isEmpty()) {
            System.out.println("Belum ada nasabah terdaftar.");
        } else {
            System.out.println("Data Nasabah:");
            for (Nasabah nasabah : dataNasabah) {
                System.out.println(nasabah);
                System.out.println("======================================");
            }
        }
    }

    public void lihatTransaksi() {
        if (dataTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi tercatat.");
        } else {
            System.out.println("Data Mutasi:");
            for (Transaksi transaksi : dataTransaksi) {
                System.out.println(transaksi);
                System.out.println("======================================");
            }
        }
    }

    public String generateNomorRekening() {
        StringBuilder nomorRekBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            nomorRekBuilder.append(random.nextInt(10));
        }
        return nomorRekBuilder.toString();
    }

    public String generateCIF() {
        StringBuilder cifBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            cifBuilder.append(random.nextInt(10));
        }
        return cifBuilder.toString();
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankSyariah bankSyariah = new BankSyariah();
        boolean dataNasabahDitambahkan = false;

        String[] jenisTransaksi = {
            "Setoran", 
            "Penarikan", 
            "Transfer",
            "M-Banking",
            "Pembayaran",
            "Tabungan"
        };
        
        while (true) {
            System.out.println("\n=== Sistem Pendataan Portofolio Nasabah Bank Syariah ===");
            if (!dataNasabahDitambahkan) {
                System.out.println("1. Tambah Nasabah");
            } else {
                System.out.println("1. Tambah Nasabah (Sudah ditambahkan)");
                System.out.println("2. Tambah Transaksi");
                System.out.println("3. Lihat Data Nasabah");
                System.out.println("4. Lihat Data Transaksi");
                System.out.println("5. Keluar");
            }
            System.out.print("Pilih menu: ");
            int menu = scanner.nextInt();
            scanner.nextLine(); 

            switch (menu) {
                case 1:
                    if (!dataNasabahDitambahkan) {
                        System.out.print("Masukkan nama nasabah: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan nomor KTP: ");
                        String nomorKTP = scanner.nextLine();
                        System.out.print("Masukkan alamat: ");
                        String alamat = scanner.nextLine();
                        System.out.print("Masukkan tanggal lahir (format: yyyy-MM-dd): ");
                        String tanggalLahirStr = scanner.nextLine();
                        Date tanggalLahir = null;
                        try {
                            tanggalLahir = new SimpleDateFormat("yyyy-MM-dd").parse(tanggalLahirStr);
                        } catch (ParseException e) {
                            System.out.println("Format tanggal lahir tidak valid.");
                            continue;
                        }
                        System.out.print("Masukkan nama ibu kandung: ");
                        String namaIbuKandung = scanner.nextLine();
                        System.out.print("Masukkan pekerjaan: ");
                        String pekerjaan = scanner.nextLine();
                        bankSyariah.tambahNasabah(new Nasabah(nama, "", "", nomorKTP, alamat, tanggalLahir, namaIbuKandung, pekerjaan));
                        dataNasabahDitambahkan = true;
                    } else {
                        System.out.println("Data nasabah sudah ditambahkan.");
                    }
                    break;
                case 2:
                    System.out.println("Jenis Transaksi:");
                    for (int i = 0; i < jenisTransaksi.length; i++) {
                        System.out.println((i+1) + ". " + jenisTransaksi[i]);
                    }
                    System.out.print("Pilih jenis transaksi: ");
                    int jenis = scanner.nextInt();
                    scanner.nextLine(); 
                    if (jenis >= 1 && jenis <= jenisTransaksi.length) {
                        System.out.print("Masukkan nama: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan jumlah: ");
                        double jumlah = scanner.nextDouble();
                        scanner.nextLine(); 
                        System.out.print("Masukkan currency code: ");
                        String currencyCode = scanner.nextLine();
                        System.out.print("Masukkan deskripsi: ");
                        String deskripsi = scanner.nextLine();
                        Date tanggalTransaksi = new Date();
                        bankSyariah.tambahTransaksi(new Transaksi(jenisTransaksi[jenis-1], jumlah, tanggalTransaksi, "", nama, currencyCode, deskripsi, ""));
                    } else {
                        System.out.println("Jenis transaksi tidak valid.");
                    }
                    break;
                case 3:
                    bankSyariah.lihatNasabah();
                    break;
                case 4:
                    bankSyariah.lihatTransaksi();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan program.");
                    System.exit(0);
                default:
                    System.out.println("Menu tidak valid.");
            }
        }
    }
}
