// Your name here (NO NAME, NO CREDIT!): Jun Paulino

package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Lab10 {
    public static void main(String[] args) {
        // TEST PORTION (DO NOT MODIFY!)
        ArrayList<String> alist = new ArrayList<String>();    // Created array list
        Stack<Integer> st = new Stack<Integer>();            // Created stack
        final int n = 10;
        for (int i = 0; i < n; i++) {
            alist.add(Integer.toString(i));
            st.push(i);
        }
        // END TEST...CODE BELOW THIS LINE!

		System.out.print("ArrayList: [");
		Iterator<String> alistIt = alist.iterator();
		if (alistIt.hasNext()) {
			String next = alistIt.next();
			while (alistIt.hasNext()) {
				System.out.print("\"" + next + "\", ");
				next = alistIt.next();
			}
			System.out.println("\"" + next + "\"]");
		} else {
			System.out.println("]");
		}

		System.out.print("Stack: [");
		Iterator<Integer> stIt = getStackIterator(st);
		if (stIt.hasNext()) {
			Integer next = stIt.next();
			while (stIt.hasNext()) {
				System.out.print(next + ", ");
				next = stIt.next();
			}
			System.out.println(next + "]");
		} else {
			System.out.println("]");
		}
    }

    public static Iterator<Integer> getStackIterator(Stack<Integer> st) {
		Iterator<Integer> it = st.iterator();
		ArrayList<Integer> integers = new ArrayList<>(st);
		for (int i = st.size() - 1; i >= 0; i--)
			integers.set(i, it.next());
		return integers.iterator();
    }

    /* Helper method for easy printing on same line */
    public static <E> void p(E item) {
        System.out.print(item + " ");
    }

    /* Helper method for easy printing with line return */
    public static <E> void pn(E item) {
        System.out.println(item);
    }
}