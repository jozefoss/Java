public class Pięcioboista extends Sportowiec implements Pływanie, Bieganie {

    public Pięcioboista(String imię, String nazwisko) {
        super(imię, nazwisko);
    }
    public void walczOMedal() {
        płyń();
        rozpocznijSzermierkę();
        rozpoczijJazdęKonną();
        biegnij();
        strzelaj();
    }
    public void strzelaj() {
        System.out.println("Strzelam");
    }
    public void rozpocznijSzermierkę() {
        System.out.println("Rozpoczynam konkurencję szermierki");
    }
    public void rozpoczijJazdęKonną() {
        System.out.println("Rozpoczynam konkurencję: jazda konna");
    }
    public void płyń() {
        System.out.println("Płynę stylem dowolnym");
    }
    public void biegnij() {
        System.out.println("Rozpoczynam konkurencję: bieg z przeszkodami");
    }
}