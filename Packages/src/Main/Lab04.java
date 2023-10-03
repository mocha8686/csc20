package Main;

import add.Add;
import divide.Divide;
import modulo.Modulo;
import multiply.Multiply;
import op.Op;
import subtract.Subtract;

public class Lab04 {
    public static void main(String[] args) {
        Add a = new Add(5, 3);
        test(a, 8);
        a.changeVals(4, 8);
        test(a, 12);
        a.changeVals(6, -2);
        test(a, 4);

        Subtract s = new Subtract(5, 3);
        test(s, 2);
        s.changeVals(4, 8);
        test(s, -4);
        s.changeVals(6, -2);
        test(s, 8);

        Multiply m = new Multiply(5, 3);
        test(m, 15);
        m.changeVals(4, 8);
        test(m, 32);
        m.changeVals(6, -2);
        test(m, -12);

        Divide d = new Divide(5, 3);
        test(d, 1);
        d.changeVals(4, 8);
        test(d, 0);
        d.changeVals(6, -2);
        test(d, -3);

        Modulo mod = new Modulo(5, 3);
        test(mod, 2);
        mod.changeVals(4, 8);
        test(mod, 4);
        mod.changeVals(6, -2);
        test(mod, 0);
    }

    public static void test(Op op, int expected) {
        System.out.println(op);
        verify(expected, op.getResult(), op.toString());
    }

    public static void verify(int expected, int actual, String equation) {
        assert expected == actual : String.format("Expected %d (got %s)", expected, equation);
    }
}