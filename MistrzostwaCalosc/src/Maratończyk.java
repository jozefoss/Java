public class Maratończyk extends Sportowiec implements Bieganie {

    public Maratończyk(String imię, String nazwisko) {
        super(imię, nazwisko);
    }
    public void biegnij() {
        System.out.println("Biegnę w maratonie");
    }
    public void walczOMedal() {
        biegnij();
    }
}
