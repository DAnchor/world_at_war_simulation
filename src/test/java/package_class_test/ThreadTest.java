package package_class_test;

import java.util.Scanner;


/**
 * @author Dmitriy Jakovlevs
 *
 */
import package_class_thread.ThreadManipulator;

public class ThreadTest {
	public static void threadTest() throws InterruptedException {
		ThreadManipulator tm = new ThreadManipulator();
		// instance of scanner
		Scanner sc = new Scanner(System.in);

		// stdout launch status
		System.out.print("Would you like to start thread testing? yes/no >>> ");
		String input = sc.next();

		/**
		 * proxy while invoke
		 */
		while (input.equalsIgnoreCase("yes")) {
			System.out.println("\nStarting simulation...");

			// testing thread
			tm.run();
			tm.suspendThread();

			// stdout repeat status
			System.out.print("\nWould you like to continue with another \"BATTLE\" simulation? yes/no >>> ");
			input = sc.next();
		}
		sc.close();
	}

	public static void main(String... strings) throws InterruptedException {
		threadTest();
	}
}
