public class Mistrzostwa {
    public static void main(String[] args) {
        Pływak pływak = new Pływak("Paweł", "Korzeniowski");
        Pięcioboista pięcioboista = new Pięcioboista("Paulina", "Boenisz");
        Maratończyk maratończyk = new Maratończyk("Rafał", "Wójcik");
        pływak.podajDane();
        pływak.walczOMedal();
        System.out.println("----------------------------------");
        pięcioboista.podajDane();
        pięcioboista.walczOMedal();
        System.out.println("----------------------------------");
        maratończyk.podajDane();
        maratończyk.walczOMedal();
    }
}
