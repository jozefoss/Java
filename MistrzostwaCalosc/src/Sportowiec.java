public abstract class Sportowiec {
    public String imię;
    public String nazwisko;

    public Sportowiec (String imię, String nazwisko) {
        this.imię = imię;
        this.nazwisko = nazwisko;
    }

    public abstract void walczOMedal();

    public void podajDane() {
        System.out.println("Moje imię: " + imię);
        System.out.println("Moje nazwisko: " + nazwisko);
    }
}
