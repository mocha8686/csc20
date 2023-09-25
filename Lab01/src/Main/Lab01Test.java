package Main;

import org.junit.jupiter.api.Test;

class Lab01Test {
    public static <E> void p(E item) {
        System.out.println(item);
    }

    @Test
    void autograde() {
        // TESTER: DO NOT MODIFY!!!
        String Feedback = ""; // This is for grading comments!
        int points = 25; // This is for points
        int[] c = new int[0]; // This is an empty array for testing
        int[] a = {2, 5, 3, 4, 9, 8, 6, 7, 1, 0};
        int[] b = {5, 4, 6, 3, 7, 2, 8, -1, 1, 9};
        Lab01 lab = new Lab01(a); // Declare and initialize class object
// THIS IS THE GRADING PORTION!
        int size = lab.getSize(); // Retrieve tester size value (should be 10)
        if (size != 10) {
            points -= 5;
            Feedback += "Inaccurate 'getSize' result. Should be 10 (-5 pts);";
        }
        int element = lab.getElement(0); // Retrieve tester element value (should be 2)
        if (element != 2) {
            points -= 5;
            Feedback += "Inaccurate 'getElement' result. Should be 2 (-5 pts);";
        }
        int max = lab.getMax();
// Retrieve tester max value (should be 9)
        if (max != 9) {
            points -= 5;
            Feedback += "Inaccurate 'getMax' result. Should be 9 (-5 pts);";
        }
        int sum = lab.getSum();
// Retrieve tester sum value (should be 45)
        if (sum != 45) {
            points -= 5;
            Feedback += "Inaccurate 'getSum' result. Should be 45 (-5 pts);";
        }
        int min = Lab01.getStaticMin(b); // Retrieve tester min value (should be -1)
        if (min != -1) {
            points -= 5;
            Feedback += "Inaccurate 'getStaticMin' result. Should be -1 (-5 pts);";
        }
// Check for OTHER deductions
        Lab01 lab1 = new Lab01(c);
        int elementEmpty = 0;
        try {
            elementEmpty = lab1.getElement(0);
            if (elementEmpty != -1) {
                points -= 2;
                Feedback += "You are supposed to return -1 if array is empty in 'getElement' (-2 pts);";
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            points -= 2;
            Feedback += "You are supposed to return -1 if array is empty in 'getElement' (-2 pts);";
        }
        int maxEmpty = 0;
        try {
            maxEmpty = lab1.getMax();
            if (maxEmpty != -1) {
                points -= 2;
                Feedback += "You are supposed to return -1 if array is empty in 'getMax' (-2 pts);";
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            points -= 2;
            Feedback += "You are supposed to return -1 if array is empty in 'getMax' (-2 pts);";
        }
        int sumEmpty = lab1.getSum();
        if (sumEmpty != 0) {
            points -= 2;
            Feedback += "You are supposed to return 0 if array is empty in 'getSum' (-2 pts);";
        }
        int minEmpty = 0;
        try {
            minEmpty = Lab01.getStaticMin(c);
            if (minEmpty != -1) {
                points -= 2;
                Feedback += "You are supposed to return -1 if array is empty in 'getStaticMin' (-2 pts)";
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            points -= 2;
            Feedback += "You are supposed to return -1 if array is empty in 'getStaticMin' (-2 pts)";
        }
// FINAL GRADE AND COMMENTS
        if (points < 0) points = 0;
        if (points == 25) Feedback = "Great work!";
        p("Grade: " + points + " / 25");
        p("Comments: " + Feedback);
// END OF TEST!!!
    }
}