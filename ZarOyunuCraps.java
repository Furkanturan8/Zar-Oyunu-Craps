package JavaLabH6Ornekler.ZarOyunlari;
import java.security.SecureRandom;

public class ZarOyunuCraps {

    private static final SecureRandom randomNumara= new SecureRandom();
    private enum  durum {DEVAM , KAYBETTIN , KAZANDIN};

    //Mantık su: iki zarın var attın onları. bu iki zarın ön yüzündeki sayiların toplami 2,3,12 ise kaybedersin
    // 7,11 ise kazanırsın. EĞER Bunlardan farklı bir puan gelirse bu sefer oyun, önceki aynı puanı getirirsen kazandırır!
    private static final int iki=2; //kaybettirir
    private static final int uc=3; //kaybettirir
    private static final int yedi=7; //kazandırır
    private static final int onbir=11; //kazandırır
    private static final int oniki=12; //kaybettirir

    public static int zarlariAt(){

        int zar1= 1 + randomNumara.nextInt(6);
        int zar2= 1 + randomNumara.nextInt(6);

        int toplam=zar1+zar2;

        System.out.println("Zarların toplamı: "+toplam);

        return toplam;
    }
    public static void main(String[] args) {

        int puan = 0;
        int zarToplami = zarlariAt();
        durum oyunDurumu; //enum dan zarlar toplamına göre oyun durumunu tanımladık.

        switch (zarToplami) {
            case yedi:
            case onbir:
                oyunDurumu = durum.KAZANDIN;
                break;
            case iki:
            case uc:
            case oniki:
                oyunDurumu = durum.KAYBETTIN;
                break;
            default:
                oyunDurumu = durum.DEVAM;
                puan = zarToplami;
                System.out.println("Puanın: " + zarToplami + " Bir daha zar atıldığında aynı puan gelirse kazanırsın!");
                break;
        }

        while (oyunDurumu == durum.DEVAM) {
//eğer önceki yaptığı ile yaparsa kazanır.
            zarToplami = zarlariAt();

            if (zarToplami == puan) {
                oyunDurumu = durum.KAZANDIN;
            } else {
                oyunDurumu = durum.KAYBETTIN;
                System.out.println("Önceki attığın toplam ile eşit olmadı... Kaybettin!");
            }
        }
        if (oyunDurumu == durum.KAZANDIN) {
            System.out.println("Oyunu Kazandın!!!");
        } else
            System.out.println("Oyunu Kaybettin!!!");
    }


}
