public class Coffee
{
    int type;
    boolean sugar;
    public Coffee() {
        System.out.println
                ("Kawa czarna z cukrem");
        type = 0;
        sugar = false;

    }
    public Coffee
            (int type, boolean sugar) {
        this.type = type;
        this.sugar = sugar;

    }
    public void info() {
        if
                (type == 0) {
            System.out.print("Kawa czarna ");

        }else
        {
            System.out.print("Kawa z mlekiem ");

        }
        if
                (sugar) {
            System.out.println("z cukrem");

        }else
        {
            System.out.println("bez cukru");

        }

    }
    public void info
            (Coffee c) {
        System.out.print("Twoja kawa");
        if
                (this.sugar || !c.sugar) {
            System.out.print(" nie");

        }
        System.out.println(" ma mniej cukru od podanej ");

    }
}
