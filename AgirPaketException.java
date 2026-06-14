public class AgirPaketException extends Exception{//aynı obje gibi bizde exception sınıfını miras alıp agurlık sonucunda olacak hatayı gosteriyoruz
    public AgirPaketException(String mesaj){//constructor
        super(mesaj);//excepitons sınıfını çağırıp agırlık hatasını constructor gösteriyoruz
    }
}