import java.util.Scanner;

public class Average {
	public static void main(String[] args) {
		double grade = 0, sum = 0;
		int i = 0;
		Scanner reader = new Scanner(System.in);		
		System.out.print("Program calculates the average of inputted grades.\n" + "Finish with a negative integer.\n\n");						    	
        	   
    	while (true) {
    		System.out.print("Input a grade (4-10): ");
    		grade = reader.nextDouble();        		
    		if (grade >= 0) {
	    		if (grade >= 4 && grade <= 10) {   				
					sum = sum + grade;
					i++;
	    		}
	    		else System.out.println("Invalid grade!");	    			
	    	}
    		else break;
    	}
    					   		    	    	    	    	
    	if (i == 0) System.out.println("\nYou did not input any grades.");
    	else {	    	
	    	System.out.println("\n" + i + " grades inputted.");
			System.out.print("Average of the grades: " + sum / i);	
    	}    	
	}
}