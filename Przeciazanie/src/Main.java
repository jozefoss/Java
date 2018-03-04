public class Main {
    public static void main(String[]args) {
        Coffee myCup = new Coffee(1, false);
        System.out.println("Twoj wybor:");
        myCup.info();
        myCup.info(new Coffee(2, true));
        System.out.println("Do wyboru tez:");
        new Coffee();
    }
}
