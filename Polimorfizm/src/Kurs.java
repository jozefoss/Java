public class Kurs {
    static double[][]kurs = {{0, 1.37, 3.89},
            {0.73, 0, 2.84},
            {0.26, 0.35, 0}};


public static void main(String[]args) {
        Euro euro = new Euro();
        Dolar dolar = new Dolar();
        Zloty złoty = new Zloty();
        euro.sprawdźKurs(dolar);
        złoty.sprawdźKurs(euro);
    }
}
