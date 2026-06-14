import java.util.ArrayList;

public class Lojistiksistemi {
    private ArrayList<Musteri> musteriListesi;//vector gibi estek dizilerle veri tutucaz
    private ArrayList<Arac> aracListesi;
    private ArrayList<Paket> paketKuyrugu; //fıfo iiçin
    private Konum kargoMerkezi;

    public Lojistiksistemi(Konum kargoMerkezi) {//construct
        this.musteriListesi = new ArrayList<>();
        this.aracListesi = new ArrayList<>();
        this.paketKuyrugu = new ArrayList<>();
        this.kargoMerkezi = kargoMerkezi;
    }

    public void musteriEkle(Musteri musteri){this.musteriListesi.add(musteri);}
    public void aracEkle(Arac arac) {this.aracListesi.add(arac);}
    public void paketKabulEt(Paket paket) {this.paketKuyrugu.add(paket);}//fıfo ile sıralıcaz

    public void dagitimiBaslat(){
        if (this.musteriListesi.isEmpty()||this.aracListesi.isEmpty()){//arac ve musteri sayısı>0 olmalı
            System.out.println("Dağıtım için müşteri veya araç bulunmuyor!");
            return;
        }
        System.out.println("       Sehir Lojistik simülasyonu ");
        int musteriIndeks=0;
        int aracIndeks=0;

        // queue boşalana kadar devam
        while (!this.paketKuyrugu.isEmpty()){
            Paket siradakiPaket=this.paketKuyrugu.remove(0);
            siradakiPaket.durumAyarla("Yolda");
            // Sıradaki musteri ve arac seçiyoruz
            Musteri hedefMusteri=this.musteriListesi.get(musteriIndeks%this.musteriListesi.size());
            Arac secilenArac=this.aracListesi.get(aracIndeks%this.aracListesi.size());
            System.out.println("\n-> İşlem gören kargo:"+ siradakiPaket.icerikGetir() + "(" + siradakiPaket.agirlikGetir() + "kilogram)");
            System.out.println("-> taşıyacak oturgaçlıgötürgeç:"+ secilenArac.plakaGetir() + "| Hedef:"+ hedefMusteri.adGetir());

            // Mesafe ve Yakıt Kontrolü
            double gidilecekMesafe = this.kargoMerkezi.mesafeHesapla(hedefMusteri.konumGetir());
            
            //araca yakıt laızmsa benzin yükleriz
            if (secilenArac.yakitGetir()<gidilecekMesafe) {
                System.out.println("benzin yetersiz");
                secilenArac.yakitIkmal();
            }
        //poliformizim+hata kontrolü
            try {
                secilenArac.teslimatYap(hedefMusteri, siradakiPaket);
                secilenArac.yakitAyarla(secilenArac.yakitGetir() - gidilecekMesafe);//hata yoksa benzin harcanmıştır
                System.out.println("Kalan Yakıt"+ secilenArac.yakitGetir());

            } catch (Exception e){
                System.out.println("teslimat iptal" + e.getMessage());//genislik ağırlık gibi hatalar sebpli hata kontrolü
                siradakiPaket.durumAyarla("Teslim edemedik");
            }
            musteriIndeks++;//basit bir indeks güncellemesi
            aracIndeks++;
        }

        System.out.println("Tebrikler bütün kargolar teslim edildi");
    }
}    
