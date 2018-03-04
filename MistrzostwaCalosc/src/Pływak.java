public class Pływak extends Sportowiec implements Pływanie {

    public Pływak(String imię, String nazwisko) {
        super(imię, nazwisko);
    }
    public void płyń() {
        System.out.println("Płynę");
    }
    public void walczOMedal() {
        płyń();
    }
}
