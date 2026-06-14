public class KonsolLogger implements ILogger{//bağlı implements ettik 
    @Override
    public void logla(String mesaj) {
        System.out.println("Bilgi-> " + mesaj);
    }
}