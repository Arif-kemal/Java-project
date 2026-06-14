public class Konum {
    private double x;
    private double y;

    //Konum yaratılırken x ve y yi zorunlu kullancan
    public Konum(double x, double y) {
        this.x=x;
        this.y=y;
    }

    public double xGetir() {return this.x;}

    public double yGetir() {return this.y;}

    //iki konum arasi mesafeyi ölçmeliyiz
    //973. K Closest Points to Origin  bu sorudaki gibi bence olur
    public double mesafeHesapla(Konum hedefKonum) {
        return Math.hypot(
    hedefKonum.xGetir() - this.x,
    hedefKonum.yGetir() - this.y );
    }
}
