public class Kamyon extends Arac {//arac sınıfıının cocugu
    public Kamyon(String plaka, double kapasite, double yakit, double hiz) {//cocuk kendi özelliklerini constractorde almalı
        super(plaka, kapasite, yakit, hiz);//arac sınıfının constratorunu alır
    }

    @Override//aracın ne yapacaıgını burda anlatıyorum
    public void teslimatYap(Musteri musteri,Paket paket) throws Exception{
        // kamyon genis yani dar sokaga giremez
        if (musteri.darSokakMi()==true){
            throw new Exception("Teslim edemiyoruz cunku:"+this.plakaGetir() +" plakalı Kamyon dar sokağa giremiyor(musteri:" + musteri.adGetir() +")");
        }

        paket.durumAyarla("Teslim edilmiştir");
        System.out.println(this.plakaGetir() +"plakalı Kamyon, "+ paket.icerikGetir()+"paketini güvenle evine ulaştırdık");
    }
}
