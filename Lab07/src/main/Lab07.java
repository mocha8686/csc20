// Your name here (NO NAME, NO CREDIT!): Jun Paulino

package main;

public class Lab07 {
	public static void main(String[] args) {
		// Do NOT modify this method! This portion is provided just so you can see how I will grade the assignment.
		int[] a = {9, 1, 8, 2, 7, 3, 6, 4, 5};
		System.out.println(linearSearch(a, 0));        // This should return false
		System.out.println(linearSearch(a, 3));        // This should return true
		selectionSort(a);                            // This should sort the array
		System.out.println(binarySearch(a, 0));        // This should return -1
		System.out.println(binarySearch(a, 3));        // This should return 2 (the index of value 3 once array is sorted)
		// END OF TEST DATA
	}

	////////////// DO ALL OF YOUR CODING BELOW THIS LINE! //////////////////////////////////

	public static boolean linearSearch(int[] a, int value) {
		for (int i : a) {
			if (i == value) return true;
		}

		return false;
	}

	public static void selectionSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[i]) {
					int tmp = a[j];
					a[j] = a[i];
					a[i] = tmp;
				}
			}
		}
	}

	public static int binarySearch(int[] a, int value) {
		int start = 0;
		int end = a.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			int n = a[mid];
			if (n == value) return mid;
			else if (value < n) end = mid - 1;
			else start = mid + 1;
		}

		return -1;
	}
}