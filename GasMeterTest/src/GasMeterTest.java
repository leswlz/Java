import java.util.Scanner;

public class GasMeterTest {
    public static void main(String args[]) {   
        int answer = 1;
        boolean valueCorrect = true;
        GasMeter meter = new GasMeter();

        while (valueCorrect) {
            Scanner reader = new Scanner(System.in);
            
            System.out.print("What do you want: 1=95, 2=98, 3=Diesel " + "(type any other number to quit): ");
            answer = reader.nextInt();
           
            if(answer >= 1 && answer <= 3) {
                System.out.print("How much do you want to refuel: ");
                double amount = reader.nextDouble();
                meter.refuel(answer, amount);
            } else {
                valueCorrect = false;
            }
        }
       
        GasMeter.totalUsed();
        GasMeter.totalUsed95();
        GasMeter.totalUsed98();
        GasMeter.totalUsedDi();
   }
}

class GasMeter {	
	private static double litres_95 = 0;
	private static double litres_98 = 0;
	private static double litres_Di = 0;
		
	public void refuel(int answer, double amount) {
		switch(answer) {
			case 1:
				litres_95 = litres_95 + amount;				
				break;
			case 2:
				litres_98 = litres_98 + amount;				
				break;
			case 3:
				litres_Di = litres_Di + amount;				
				break;
		}		   
	}		
	public static void totalUsed() {
		System.out.println("Total used fuel: " + (litres_95 + litres_98 + litres_Di));
	}	
	public static void totalUsed95() {
		System.out.println("Total used 95 octane fuel: " + litres_95);		
	}	
	public static void totalUsed98() {
		System.out.println("Total used 98 octane fuel: " + litres_98);		
	}	
	public static void totalUsedDi() {
		System.out.println("Total used diesel fuel: " + litres_Di);		
	}
}