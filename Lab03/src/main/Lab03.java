package main;

interface Foo {
	String getName();
	int getNumber();
}

interface Bar {
	default int add42(int n) {
		return n + 42;
	}
}

interface Baz {
	static String createGreeting(String name) {
		return "Hello, world! I am " + name + ".";
	}
}

public class Lab03 implements Foo, Bar, Baz {
	private static final String name = "Lab03";

	private final int number;

	public Lab03(int number) {
		this.number = number;
	}

	@Override
	public String getName() {
		return Lab03.name;
	}

	@Override
	public int getNumber() {
		return this.number;
	}

	public static void main(String[] args) {
		Lab03 object = new Lab03(144);

		System.out.println(Baz.createGreeting(object.getName()));
		System.out.println("My number plus 42 is: " + object.add42(object.getNumber()));
	}
}
