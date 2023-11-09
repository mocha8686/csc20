// This is the Autograder for CSC20 / CS13 Lab #8

package Main;

public class Autograder {
	public static void main(String[] args){
		// Autograder!
		StackList sl = new StackList();
		String s1 = sl.pop().toLowerCase().trim();
		String s2 = sl.peek().toLowerCase().trim();
		sl.push("Test string one");
		String s3 = sl.peek().toLowerCase().trim();
		int size1 = sl.size();
		boolean emp1 = sl.isEmpty();
		sl.push("Test string two");
		sl.push("Test string three");
		String s4 = sl.pop().toLowerCase().trim();
		int size2 = sl.size();
		boolean emp2 = sl.isEmpty();
		sl.clear();
		boolean emp3 = sl.isEmpty();
		// Now the points and the comments
		int points = 25;		// Everyone starts with 25 points
		String comments = "";
		if(!s1.equals("empty")){
			points -= 3;
			comments += "pop test #1 should have been 'EMPTY' (-3 pts);";
		}
		if(!s2.equals("empty")){
			points -= 3;
			comments += "peek test #1 should have been 'EMPTY' (-3 pts);";
		}
		if(!s3.equals("test string one")){
			points -= 3;
			comments += "peek test #2 should have been 'Test string one' (-3 pts);";
		}
		if(size1 != 1){
			points -= 3;
			comments += "Size test #1 should have been 1 (-3 pts);";
		}
		if(emp1){
			points -= 3;
			comments += "isEmpty test #1 should have been false (-3 pts);";
		}
		if(!s4.equals("test string three")){
			points -= 3;
			comments += "pop test #2 should have been 'Test string three' (-3 pts);";
		}
		if(size2 != 2){
			points -= 3;
			comments += "Size test #2 should have been 2 (-3 pts);";
		}
		if(emp2){
			points -= 3;
			comments += "isEmpty test #2 should have been false (-3 pts);";
		}
		if(!emp3){
			points -= 3;
			comments += "isEmpty test #3 should have been true (-3 pts);";
		}
		// Grading portion here...
		if(points == 25)			comments = "Good work.";
		if(points < 0)				points = 0;
		p("Points: " + points + "/25 (provided there are no values printed by student's code)");
		p("Comments: " + comments);
	}
	
	/* Helper method for easy displaying of text to console */
	public static <E> void p(E item){
		System.out.println(item);
	}
}