public class Waluta {
    int nr;
    String nazwa;
    public void sprawdźKurs(Waluta drugaWaluta) {
        System.out.println("Kurs " + this.nazwa
                + "/" + drugaWaluta.nazwa
                + " wynosi "
                + Kurs.kurs[this.nr][drugaWaluta.nr]);
    }
}
