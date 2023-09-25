// Your name here: Jun Paulino

import java.util.Arrays;
import java.util.StringTokenizer;

public class Lab02 {
	public static void main(String[] args) {
		// My code to dynamically create a small movie database (DO NOT MODIFY OR REMOVE!)
		String[] movies = new String[5];
		movies[0] = "Shawshank Redemption*1994*Tim Robbins*2.36";
		movies[1] = "The Godfather*1972*Al Pacino*2.92";
		movies[2] = "Raging Bull*1980*Robert De Niro*2.15";
		movies[3] = "Million Dollar Baby*2004*Hilary Swank*2.2";
		movies[4] = "Straight Outta Compton*2015*Jason Mitchell*2.45";
		// End of code
		
		// TODO: Write your code to parse the data, and display the data in a meaningful way...
		// (Use the instructions in the hand out to complete the assignment for full credit)
		String[] titles = new String[movies.length];
		int[] years = new int[movies.length];
		String[] stars = new String[movies.length];
		float[] runtimes = new float[movies.length];

		for (int i = 0; i < movies.length; i++) {
			String raw = movies[i];
			StringTokenizer st = new StringTokenizer(raw, "*");
			titles[i] = st.nextToken().trim();
			years[i] = Integer.parseInt(st.nextToken().trim());
			stars[i] = st.nextToken().trim();
			runtimes[i] = Float.parseFloat(st.nextToken().trim());
		}

		printArray("titles", titles);
		printArray("years", years);
		printArray("stars", stars);
		printArray("runtimes", runtimes);
	}

	public static void printArray(String title, Object[] arr) {
		System.out.println("-----" + title.toUpperCase() + "-----");
		for (Object x : arr) {
			System.out.println(x);
		}
	}

	public static void printArray(String title, int[] arr) {
		Integer[] newArr = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		printArray(title, newArr);
	}

	public static void printArray(String title, float[] arr) {
		Float[] newArr = new Float[arr.length];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		printArray(title, newArr);
	}
}