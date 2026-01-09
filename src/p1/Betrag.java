package p1;

public class Betrag {
    private int euro;
    private int cent;

    public Betrag(int euro, int cent) {
        // Reihenfolge wie gefordert: erst euro, dann cent (über Setter)
        setEuro(euro);
        setCent(cent);
    }

    public int getEuro() {
        return euro;
    }

    public void setEuro(int euro) {
        this.euro = euro;
    }

    public int getCent() {
        return cent;
    }

    public void setCent(int cent) {
        // Ganze Euro aus cent herausziehen (nur wenn möglich)
        if (cent >= 100) {
            int extraEuro = cent / 100;
            this.euro += extraEuro;
            cent = cent % 100;
        }
        this.cent = cent;
    }
}
