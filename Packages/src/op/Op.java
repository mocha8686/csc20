package op;

public abstract class Op {
    protected int n1;
    protected int n2;

    public Op(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public abstract int getResult();
    protected abstract String getOpString();

    public void changeVals(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public String toString() {
        return String.format("%d %s %d = %d", n1, getOpString(), n2, getResult());
    }
}
