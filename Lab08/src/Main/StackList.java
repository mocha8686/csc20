// Your name here: Jun Paulino
package Main;

import java.util.ArrayList;

public class StackList {
	private final ArrayList<String> a = new ArrayList<>();

	public void push(String item) {
		a.add(item);
	}

	public String pop() {
		return a.isEmpty() ? "EMPTY" : a.remove(a.size() - 1);
	}

	public String peek() {
		return a.isEmpty() ? "EMPTY" : a.get(a.size() - 1);
	}

	public boolean isEmpty() {
		return a.isEmpty();
	}

	public int size() {
		return a.size();
	}

	public void clear() {
		a.clear();
	}
}