public class Paket {
    private String durum; //kapsülleme yüzünden private oldular
    private double agirlik;
    private String icerik;

    public Paket(double agirlik,String icerik) {
        this.agirlik = agirlik;
        this.icerik = icerik;
        this.durum = "Hazirlanmaktadir"; 
    }
    //get-setler
    public double agirlikGetir(){return this.agirlik;}

    public String icerikGetir(){return this.icerik;}

    public String durumGetir(){return this.durum;}

    public void durumAyarla(String yeniDurum){this.durum = yeniDurum;}//set ile günecelleri
}
