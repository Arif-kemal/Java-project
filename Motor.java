public class Motor extends Arac {
    public Motor(String plaka,double kapasite,double yakit,double hiz) {//arac sınıfından olusturluan motorun kendi constu
        super(plaka,kapasite,yakit,hiz);
    }

    @Override//motorun yöntemi
    public void teslimatYap(Musteri musteri,Paket paket) throws Exception{
        // 1. EKLEME: Fabrikadan çıkan ilk hızımızı kaybetmemek için cebimize (yedek değişkene) koyuyoruz
        double orijinalHiz=this.hizGetir(); 
        double anlikHiz=orijinalHiz; //anlık hız agırlık ile degisebilir
        
        if (paket.agirlikGetir()>10) {
            anlikHiz=anlikHiz * 0.8;//10 kg yuk bizi %20 yavaslatıyormuş o yüzden 0,8 ile çarptık 
            this.hizAyarla(anlikHiz); 
            System.out.println("Paket 10 kg'dan ağır. "+ this.plakaGetir() +" plakalı Motor azcık yavasladı " + anlikHiz);
        }
        
        paket.durumAyarla("Teslim Edilmiştir");
        System.out.println(this.plakaGetir()+" motor "+ paket.icerikGetir() + " paketini kapıya bıraktı");
        this.hizAyarla(orijinalHiz); 
    }
}