public class Main {
    public static void main(String[] args) {
        Konum merkezKonum=new Konum(0, 0);//orijin
        ILogger sistemLoglayici = new KonsolLogger();
        Lojistiksistemi sistem = new Lojistiksistemi(merkezKonum, sistemLoglayici);
        
        Musteri musteri1 = new Musteri(1881, "Arif şeremet", new Konum(3, 4), true);//dar sokak testi
        
        Musteri musteri2 = new Musteri(1453, "Kemal şeremet", new Konum(10, 20), false);
        
        sistem.musteriEkle(musteri1);
        sistem.musteriEkle(musteri2);
        //araçlar
        Kamyon kamyon = new Kamyon("16 AKS 16", 5000, 100.0, 80);//yeni objede özelliklerin yazması çok iyiymiş
        Dron dron = new Dron("NNP-007", 10, 50.0, 60);
        Motor motor = new Motor("07 AKS 07", 50, 80.0, 120);
        sistem.aracEkle(kamyon);
        sistem.aracEkle(dron);
        sistem.aracEkle(motor);

        Paket paket1 = new Paket(2.5, "kodlab kitapları");
        Paket paket2 = new Paket(6.0, "ardinyo set");//ağırlık testinde işe yarar
        Paket paket3 = new Paket(12.0, "lehim makinesi");//yavaşlama
        Paket paket4 = new Paket(3.0, "thinkpad+çanta+fare+sarj");//normal ile karşılaştırırız

        sistem.paketKabulEt(paket1);//fifo
        sistem.paketKabulEt(paket2);
        sistem.paketKabulEt(paket3);
        sistem.paketKabulEt(paket4);
        
        sistem.dagitimiBaslat();//işlerin başlaması için
        sistem.sistemRaporu();

    }
}