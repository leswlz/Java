import java.util.*;

public class BinarySearch {
	public static void main(String[] args) {
		// test list
		List<Person> l = new ArrayList<Person>();
	    l.add(new Person(1, "Chris", "Evans", 30));
	    l.add(new Person(2, "Adam","Sandler" , 35));
	    l.add(new Person(3, "Bradley", "Cooper", 40));
	    l.add(new Person(4, "Jackie", "Chan", 35));
	    l.add(new Person(5, "Chris", "Hemsworth" , 30));
	    l.add(new Person(6, "Morgan", "Freeman" , 50));
	    l.add(new Person(7, "Leonardo", "DiCaprio" , 40));
	    l.add(new Person(8, "Brad", "Pitt" , 45));
	    l.add(new Person(9, "Tom", "Hanks" , 55));
	    l.add(new Person(10, "Christian", "Bale", 35));
	    
	    // list with the ids
	    List<Integer> listId = new ArrayList<Integer>();
	    for (Person p : l) {
	    	listId.add(p.id);
	    }	 	    
	    // array with the ids
        Integer[] intId = new Integer[listId.size()];
        intId = listId.toArray(intId);
	    	    
	    // list with the first names
	    List<String> listFirstname = new ArrayList<String>();
	    for (Person p : l) {
	    	listFirstname.add(p.firstname);
	    }
	    // array with the first names
	    String[] arrayFirstname = new String[listFirstname.size()];
	    arrayFirstname = listFirstname.toArray(arrayFirstname);
	    
	    // list with the last names
	    List<String> listLastname = new ArrayList<String>();
	    for (Person p : l) {
	    	listLastname.add(p.lastname);
	    }
	    // array with the last names
	    String[] arrayLastname = new String[listLastname.size()];
	    arrayLastname = listLastname.toArray(arrayLastname);
	    
	    // list with the ages
	    List<Integer> listAge = new ArrayList<Integer>();
	    for (Person p : l) {
	    	listAge.add(p.age);
	    }
	    // array with the ages
	    Integer[] arrayAge = new Integer[listAge.size()];
	    arrayAge = listAge.toArray(arrayAge);
	    
	 // test case 1
	    System.out.println("Test 1:");
	    int toFindId = 3;
	    String toFindFirstname = "Bradley";
	    String toFindLastname = "Cooper";
	    int toFindAge = 40;
	    
	    long startTime = System.currentTimeMillis();
	    int index = BinarySearch(intId, toFindId, 0, arrayFirstname.length - 1);
		long endTime = System.currentTimeMillis();
		System.out.println("BinarySearch total execution time: " + (endTime-startTime) + " ms"); 
	    checkPerson(index, arrayFirstname, arrayLastname, arrayAge, toFindId, toFindFirstname, toFindLastname, toFindAge);
	    // Output: 2 (BinarySearch)
	    
	    startTime = System.currentTimeMillis();
	    index = LinearSearch(intId, toFindId);
		endTime = System.currentTimeMillis();
		System.out.println("LinearSearch total execution time: " + (endTime-startTime) + " ms"); 	    	    
	    checkPerson(index, arrayFirstname, arrayLastname, arrayAge, toFindId, toFindFirstname, toFindLastname, toFindAge);
	    // Output: 2 (LinearSearch)
	    
	    // test case 2
	    System.out.println("Test 2:");
	    toFindId = 3;
	    toFindFirstname = "Brad"; // wrong first name
	    toFindLastname = "Cooper";
	    toFindAge = 40;
	    
	    startTime = System.currentTimeMillis();
	    index = BinarySearch(intId, toFindId, 0, arrayFirstname.length - 1);	
		endTime = System.currentTimeMillis();
		System.out.println("BinarySearch total execution time: " + (endTime-startTime) + " ms"); 
	    checkPerson(index, arrayFirstname, arrayLastname, arrayAge, toFindId, toFindFirstname, toFindLastname, toFindAge);
	    // Output: -1 (BinarySearch)

	    startTime = System.currentTimeMillis();
	    index = LinearSearch(intId, toFindId);
		endTime = System.currentTimeMillis();
		System.out.println("LinearSearch total execution time: " + (endTime-startTime) + " ms"); 	    	    
	    checkPerson(index, arrayFirstname, arrayLastname, arrayAge, toFindId, toFindFirstname, toFindLastname, toFindAge);
	    // Output: -1 (LinearSearch)
	    
	    // test case 3
	    System.out.println("Test 3:");
	    toFindId = 3;
	    toFindFirstname = "Bradley";
	    toFindLastname = "Coop"; // wrong last name
	    toFindAge = 40;
	    index = BinarySearch(intId, toFindId, 0, arrayFirstname.length - 1);	    
	    checkPerson(index, arrayFirstname, arrayLastname, arrayAge, toFindId, toFindFirstname, toFindLastname, toFindAge);
	    index = LinearSearch(intId, toFindId);
	    checkPerson(index, arrayFirstname, arrayLastname, arrayAge, toFindId, toFindFirstname, toFindLastname, toFindAge);	   
	    // Output: -1 (BinarySearch)
	    // Output: -1 (LinearSearch)
	    
	    // test case 4
	    System.out.println("Test 4:");
	    toFindId = 3;
	    toFindFirstname = "Bradley";
	    toFindLastname = "Cooper";
	    toFindAge = 4; // wrong age
	    index = BinarySearch(intId, toFindId, 0, arrayFirstname.length - 1);	    
	    checkPerson(index, arrayFirstname, arrayLastname, arrayAge, toFindId, toFindFirstname, toFindLastname, toFindAge);	    
	    index = LinearSearch(intId, toFindId);
	    checkPerson(index, arrayFirstname, arrayLastname, arrayAge, toFindId, toFindFirstname, toFindLastname, toFindAge);	   
	    // Output: -1 (BinarySearch)
	    // Output: -1 (LinearSearch)

	    // test case 5
	    System.out.println("Test 5:"); 
	    toFindId = 2; // wrong id
	    toFindFirstname = "Bradley";
	    toFindLastname = "Cooper";
	    toFindAge = 40; 
	    index = BinarySearch(intId, toFindId, 0, arrayFirstname.length - 1);	    
	    checkPerson(index, arrayFirstname, arrayLastname, arrayAge, toFindId, toFindFirstname, toFindLastname, toFindAge);
	    index = LinearSearch(intId, toFindId);
	    checkPerson(index, arrayFirstname, arrayLastname, arrayAge, toFindId, toFindFirstname, toFindLastname, toFindAge);	   
	    // Output: -1 (BinarySearch)
	    // Output: -1 (LinearSearch)
	    
	    // test case 5
	    System.out.println("Test 6:"); 
	    toFindId = 5; 
	    toFindFirstname = "Chris";
	    toFindLastname = "Hemsworth";
	    toFindAge = 30; 
	    index = BinarySearch(intId, toFindId, 0, arrayFirstname.length - 1);	    
	    checkPerson(index, arrayFirstname, arrayLastname, arrayAge, toFindId, toFindFirstname, toFindLastname, toFindAge);
	    index = LinearSearch(intId, toFindId);
	    checkPerson(index, arrayFirstname, arrayLastname, arrayAge, toFindId, toFindFirstname, toFindLastname, toFindAge);	   
	    // Output: 4 (BinarySearch)
	    // Output: 4 (LinearSearch)
	}	    
	public static void checkPerson(int index, String[] arrayFirstname, String[] arrayLastname, Integer[] arrayAge, 
		int toFindId, String toFindFirstname, String toFindLastname, int toFindAge) {
		if (arrayFirstname[index].equals(toFindFirstname) && arrayLastname[index].equals(toFindLastname) && arrayAge[index].equals(toFindAge)) {
		    System.out.println(index);  
	    } else {
		    System.out.println("-1");  
	    }
	}    
	public static int BinarySearch(Integer[] id, int key, int low, int high) {
		int index = Integer.MAX_VALUE;
			     
	    while (low <= high) {
	        int middle = (low + high) / 2;		        
	        // If the element is bigger than the middle, it can be present in right subarray only
	        if (id[middle] < key) {
	        	low = middle + 1;		        	
	        // If the element is smaller than the middle, it can be present in left subarray only
	        } else if (id[middle] > key) {
	        	high = middle - 1;		        
	        // If the element is presented in the middle
		    } else if (id[middle] == key) {
		    	index = middle;
		    	break;
		      	}
		  	}
	    //return index;
	    if ((index >= 0) & (index < id.length))		 	 
	    	return index;   	
	    else
			return -1;
	}		
	public static int LinearSearch(Integer[] intId, int key) {
		for(int i = 0; i < intId.length; i++) {
			if (intId[i] == key) {
				return i;				
			}
		}
		return -1;	       
	}
}	    
class Person {
	int id;
	String firstname;
	String lastname;	
	int age;
	
	public Person(int id, String firstname, String lastname, int age) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;	
		this.age = age;
	}	
}