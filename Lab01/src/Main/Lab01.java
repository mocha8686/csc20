// Your name here: Jun Paulino

package Main;

public class Lab01 {
    public static void main(String[] args){
        // TESTER: DO NOT MODIFY!!!
        int[] a = {2,5,3,4,9,8,6,7,1,0};
        int[] b = {5,4,6,3,7,2,8,-1,1,9};
        Lab01 lab = new Lab01(a); // Declare and initialize class object
        p(lab.getSize()); // Should return 10
        p(lab.getElement(0)); // Should return 2
        p(lab.getMax()); // Should return 9
        p(lab.getSum()); // Should return 45
        p(Lab01.getStaticMin(b)); // Should return -1
        // END OF TEST!!!
    }

    // HELPER METHOD FOR TEST: DO NOT MODIFY!!!
    public static <E> void p(E item){
        System.out.println(item);
    }

    // Fields below here...
    private final int[] arr;

    // Constructor below here...
    public Lab01(int[] arr) {
        this.arr = arr;
    }

    // Methods below here...
    public int getSize() {
        return arr.length;
    }

    public int getElement(int index) {
        if (index < 0 || index >= arr.length)
            return -1;
        return arr[index];
    }

    public int getMax() {
        if (arr.length == 0)
            return -1;

        int max = arr[0];
        for (int n : arr)
            if (n > max)
                max = n;
        return max;
    }

    public int getSum() {
        int res = 0;
        for (int n : arr)
            res += n;
        return res;
    }

    public static int getStaticMin(int[] arr) {
        if (arr.length == 0)
            return -1;

        int min = arr[0];
        for (int n : arr)
            if (n < min)
                min = n;
        return min;
    }
}