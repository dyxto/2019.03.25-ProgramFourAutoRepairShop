/*Denny To
CSCI 1301
Program Four
*/
package ToDennyProgramFour;
import java.util.Scanner;
import java.text.DecimalFormat;
public class ToDennyProgramFour {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("What make of vehicle do you own? ");
		String vehicleMake = sc.next();
		
		customerGreeting(vehicleMake); //uses make of vehicle as parameter for greeting
		finalPrice(carMaintenance(vehicleMake)); // finalPrice uses the RESULT of carMaintenance--
												//--use of vehicleMake as parameter
		
		System.out.print("Thank you for your business.");

		sc.close();
		System.exit(0);
	}
	private static DecimalFormat df2 = new DecimalFormat(".##");
	//formats double value of totalPrice to two decimal places
	
	private static void customerGreeting(String vehicleMake) {
		//uses user input for make of vehicle as parameter
		
		System.out.println("\n" + "Hello!  We will be happy to service your "
				+ vehicleMake + " automobile today!");
	}
	
	private static double carMaintenance(String vehicleMake) {
		//uses user input for make of vehicle as parameter
		
		//parallel arrays for services and prices
		String[] services = {"Oil Change", "Tire Rotation", "Air Filter", "Check Fluids"};
		double[] prices = {39.99, 49.99, 19.99, 10.99};
		int i;
		Scanner sc = new Scanner(System.in);
		double totalPrice = 0;
		
		System.out.println("\n" + "The following are the services we provide:" + "\n");
		
		for (i = 0; i < services.length; ++i) {
			//lists services along with prices
			System.out.print("(" + (i + 1) + ") " + services[i] + "   " + prices[i] + "\n");
		}
		
		String carService;
		for (i = 0; i < services.length; ++i) {
			System.out.println();
			
			//asking user for input
			System.out.print(" >  Would you like the " + services[i] + 
					" (" + prices[i] + ") " + "service? " + "(y/n): ");
			carService = sc.next();
			
			//if user enters y or Y, totalPrice is updated and printed--
			if (carService.equals("y") || carService.equals("Y")) {
				totalPrice += prices[i];
				System.out.println("    Total Price: " + df2.format(totalPrice));
			
			//--if n or N, current totalPrice is printed	
			} else if (carService.equals("n") || carService.equals("N")) {
				System.out.println("    Total Price: " + df2.format(totalPrice));
				
			//other inputs will result in system exit, requires a program restart 
			} else {
				System.out.println("Incorrect Input.");
				System.exit(0);
			}
		}
		return totalPrice; //totalPrice is returned to main()
	}
	
	private static void finalPrice(double totalPrice) {
		//uses totalPrices from carMaintenace method as parameter
		
		Scanner sc = new Scanner(System.in);
		
		//required payment of labor costs
		totalPrice = totalPrice + (totalPrice * .3); 
		System.out.println("\n" + "    +30% for labor" + "\n" + "    Total Price: " + df2.format(totalPrice) + "\n");
		
		//asks user if car is an import
		System.out.print(" >  Is the car an import? (y/n): ");
		String carImport = sc.next();
		if (carImport.equals("y")||carImport.equals("Y")) {
			
			//if y or Y, totalPrice is updated (5% of totalPrice is added to totalPrice)
			totalPrice = totalPrice + (totalPrice * .05);
			//new totalPrice is printed with two decimal places
			System.out.println("    +5% for car is an import" + "\n" + "    Total Price: " + df2.format(totalPrice) + "\n");
			
		} else if (carImport.equals("n")||carImport.equals("N")) {
			
			//if n or N, statement is printed and code proceeds
			System.out.println("    Your car is not an import." + "\n");
			
		} else {
			//other inputs will result in system exit, requires a program restart 
			System.out.println("Incorrect Input.");
			System.exit(0);
		}
		
		// 7% of totalPrice is added to totalPrice, updating totalPrice 
		totalPrice = totalPrice + (totalPrice * .07);
		// and printing the (final value of) totalPrice in the program, (the final price)
		System.out.println("    +7% for sales tax" + "\n" + ">>> TOTAL PRICE: " + df2.format(totalPrice) + " <<<" + "\n");
	}
	
}
