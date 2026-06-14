public class Musteri {
    private int id;
    private String ad;
    private Konum konum;//bu da bir variable 
    private boolean darSokakMi;

    public Musteri(int id,String ad,Konum konum,boolean darSokakMi) {//musterinin bilgileri
        this.id = id;
        this.ad = ad;
        this.konum = konum;
        this.darSokakMi = darSokakMi;
    }
    //musteri bilgisi sabit set yazmadım o yüzden
    public int idGetir() {return this.id;}

    public String adGetir() {return this.ad;}

    public Konum konumGetir() {return this.konum;}

    public boolean darSokakMi() {return this.darSokakMi;}
}
