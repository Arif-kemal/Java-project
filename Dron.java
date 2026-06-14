public class Dron extends Arac {

    // 1. Yapıcı Metot
    public Dron(String plaka, double kapasite, double yakit, double hiz) {
        // Üst sınıfın (Arac) yapıcı metoduna değişkenleri gönderiyoruz.
        super(plaka, kapasite, yakit, hiz);
    }
    @Override//dron nasıl teslimat yapıyor onu açıklıyorum
    public void teslimatYap(Musteri musteri, Paket paket) throws AgirPaketException {
        if (paket.agirlikGetir() >= 5.0) {
            throw new AgirPaketException("Kapasite Hatası: "+ this.plakaGetir() + " plakalı Dron o kadar ağırlığı taşıyamaz(Paket: " + paket.agirlikGetir() + " kg)");
        }//ağırlık hatası frlatıyoruz
        
        paket.durumAyarla("Teslim Edildi");
        System.out.println(this.plakaGetir() + "plakalı Dron" + paket.icerikGetir() + "pkaeti eve fırlattı");
    }
}