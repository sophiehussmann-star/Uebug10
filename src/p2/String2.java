package p2;

public class String2 implements Editable {
    private String mainString;

    public String2(String s) {
        this.mainString = s;
    }

    @Override
    public void addPrefix(String s) {
        mainString = s + mainString;
    }

    @Override
    public void addPostfix(String s) {
        mainString = mainString + s;
    }

    @Override
    public String toString() {
        return mainString;
    }
}
