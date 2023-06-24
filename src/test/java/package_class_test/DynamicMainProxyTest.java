package package_class_test;

import java.util.Scanner;

import package_class_country.ProxyCountryGenerator;

/**
 * 
 * @author Dmitriy Jakovlevs
 */
public class DynamicMainProxyTest {
	public static void proxyTest() {
		
		/**
		 * proxy instance
		 */
		ProxyCountryGenerator pcg  = new
				ProxyCountryGenerator();
		

		// instance of scanner
		Scanner sc = new Scanner(System.in);
		
		// stdout launch status
		System.out.print("Would you like to start \"BATTLE\" simulation? yes/no >>> ");
		String input = sc.next();
		
		/**
		 * proxy while invoke
		 */
		while(input.equalsIgnoreCase("yes")) {
			System.out.println("\nStarting simulation...");
			
			// proxy invoke
			pcg.generate();
			
			// stdout repeat status
			System.out.print("\nWould you like to continue with another \"BATTLE\" simulation? yes/no >>> ");
			input = sc.next();
		}
		
		// stdout termination status
		System.out.println("\nExiting simulation now...");
		sc.close();
		System.exit(0);
	}
	
	/**
	 * main method
	 * @param args
	 */
	public static void main(String... strings) {
		// proxy execution
		proxyTest();
	}
}
