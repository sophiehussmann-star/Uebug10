package p1;

public class P1_main {

    public static Betrag summe(Betrag a, Betrag b) {
        Betrag result = new Betrag(0, 0);

        result.setEuro(a.getEuro() + b.getEuro());
        result.setCent(a.getCent() + b.getCent());

        return result;
    }

    public static void main(String[] args) {
        Betrag a = new Betrag(13, 60);
        Betrag b = new Betrag(14, 80);

        Betrag s = summe(a, b);

        System.out.println(s.getEuro() + "," + s.getCent()); // 28,40
    }
}