package modulo;

import op.Op;

public class Modulo extends Op {
    public Modulo(int n1, int n2) {
        super(n1, n2);
    }

    @Override
    public int getResult() {
        return n1 % n2;
    }

    @Override
    protected String getOpString() {
        return "%";
    }
}
