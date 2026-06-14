public abstract class Arac {//arac turunu soyutluyoruz
    private String plaka;
    private double kapasite;
    private double hiz;
    private double yakit;
    //private String renk;
    //private String model;
 
    public Arac(String plaka,double kapasite,double yakit,double hiz) {
        this.hiz = hiz;
        this.plaka = plaka;
        this.kapasite = kapasite;
        this.yakit = yakit;
    }

    public String plakaGetir(){return this.plaka;}

    public double kapasiteGetir(){return this.kapasite;}

    public double yakitGetir(){return this.yakit;}

    public double hizGetir(){return this.hiz;}

    //gerkli fonksiyonlar
    // Yakıt azaldığında günceller
    public void yakitAyarla(double yeniYakit){ 
        this.yakit = yeniYakit; 
    }

    // sanırım rapordaki gibi kontrol bu
    public void yakitIkmal() {
        this.yakit = 100.0; // depoyu 100 ile fulliyoruz
        System.out.println(this.plaka +" plakalı araca benzin alındı. Yeni yakıt: "+this.yakit);
    }

    //soyut metod yani araba teslim edicek emme nasıl yapar o araca kalmış
    public abstract void teslimatYap(Musteri musteri, Paket paket) throws Exception;//ağırlık ve genişlik hatası için yazdım
}
//bak postacı geliyor selam veriyor