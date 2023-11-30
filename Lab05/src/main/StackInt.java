// Your name here (NO NAME, NO CREDIT!): Jun Paulino

package main;

public class StackInt {
    private final int MAX_ITEMS = 256;
    private final int[] items = new int[MAX_ITEMS];
    private int top = 0;

    public void push(int item) {
        if (top == MAX_ITEMS) return;
        items[top++] = item;
    }

    public int pop() {
        int item = peek();
        if (top > 0) top--;
        return item;
    }

    public int peek() {
        int currentItem = top - 1;
        if (currentItem == -1) return -1;
        return items[currentItem];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return top;
    }

    public void clear() {
        top = 0;
    }

    @Override
    public String toString() {
        String res = "[";
        for (int i = 0; i < size(); i++) {
            int item = items[i];
            res += item + ", ";
        }
        res = res.substring(0, res.length() - 2);
        return res + "]";
    }
}