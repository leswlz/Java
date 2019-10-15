import java.util.*;

public class RevisionExercise {
    public static void main(String[] args) {      
        int[] tempArray = new int[100];
        
        System.out.println("Type in numbers. Type zero to quit.");
        int amountOfNumbers = askInfo(tempArray);               
        int[] realArray = new int[amountOfNumbers];
        copyInfo(realArray, tempArray);     
        setArray(realArray);        
        printArray(realArray);
    }
    public static int askInfo(int[] temp_array) {     	       	
        Scanner reader = new Scanner(System.in);
        int i = 0, number = 0; 	    	   
    	
    	do {
    		System.out.print((i + 1) + ". number: ");
    		number = reader.nextInt();  
    		if (number != 0) {
    			temp_array[i] = number;  
    			i++;
	        }
	       	else break;    		
    	}     	
    	while (number != 0 && i < 100);		    	    	
		return i;    	
    }        
    public static void copyInfo(int[] real_array, int[] temp_array) { 		
    	for(int i = 0; i < real_array.length; i++) {
    		real_array[i] = temp_array[i];
    	}    	    	
    }    
    public static void setArray(int[] real_array) {
    	Integer[] array = Arrays.stream(real_array).boxed().toArray(Integer[]::new);
    	Arrays.sort(array, Collections.reverseOrder());    	
    	for(int i = 0; i < array.length; i++) {
            real_array[i] = array[i];
        }    
    }    	      
    public static void printArray(int[] real_array) {
        System.out.println("Ordered array: ");
        for(int i = 0; i < real_array.length; i++) {
            System.out.println(real_array [i]);
        }
    }
}