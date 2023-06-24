package package_class_country;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import package_class_arena.Arena;
import package_singleton_random.RandomFactory;


/**
 * ProxyCountryGenerator is a subclass of CountryGenerator
 * @author Dmitriy Jakovlevs
 *
 */
public class ProxyCountryGenerator extends CountryGenerator implements java.lang.Runnable {
	
	
	/**
	 * private instances, and variables
	 */
	// instances
	private Arena arena = new Arena();
	private NotCachedCountryGenerator originalCopyOfCountryGenerator = new NotCachedCountryGenerator();
	
	// static variables
	private String serializableIndependentCountryFile = 
			"/serializable_objects/IndependentCountries.ser";
	private String serializableSuperIndependentCountryFile = 
			"/serializable_objects/SuperIndependentCountries.ser";
	private String path = System.getProperty("user.dir");
	
	
	/**
	 * constructor overloading
	 */
	public ProxyCountryGenerator() { super(); }
	
	
	/**
	 * TODO: importing serializable objects into ArrayList independent country
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 */
	@SuppressWarnings("unchecked")
	public void deSerializeIndependentCountryObject() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		// pointing to searizable file path
		FileInputStream fileIndependantCountryIn = 
				new FileInputStream(this.path + this.serializableIndependentCountryFile);
		
		// generating objects
		ObjectInputStream objectIndependantCountryIn =
				new ObjectInputStream(fileIndependantCountryIn);
		
		// adding objects into ArrayList
		this.originalCopyOfCountryGenerator.setIndependentCountryList(((ArrayList<IndependentCountry<String, Integer>>) objectIndependantCountryIn.readObject()));
		
		// stdout status
		System.out.print(this.originalCopyOfCountryGenerator.getIObjects());
		
		// terminating active state
		objectIndependantCountryIn.close();
	}
	
	
	/**
	 * TODO: importing serializable objects into ArrayList super independent country
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 */
	@SuppressWarnings("unchecked")
	public void deSerializeSuperIndependentCountryObject() throws FileNotFoundException, IOException, ClassNotFoundException {
		
			// pointing to searizable file path
			FileInputStream fileSuperIndependentCountryIn = 
					new FileInputStream(this.path + this.serializableSuperIndependentCountryFile);
			
			// generating objects
			ObjectInputStream objectSuperIndependantCountryIn =
					new ObjectInputStream(fileSuperIndependentCountryIn);
			
			// adding objects into ArrayList
			this.originalCopyOfCountryGenerator.setSuperIndependentCountryList(((ArrayList<SuperIndependentCountry<String, Integer>>) objectSuperIndependantCountryIn.readObject()));
			
			// stdout status
			System.out.print(this.originalCopyOfCountryGenerator.getSObjects());
			
			// terminating active state
			objectSuperIndependantCountryIn.close();
	}
		
	
	/**
	 * STRUCTURAL PROXY
	 * proxy cache server: this method is inherited from parent super abstract class
	 */
	@Override
	public void generate() {
		// TODO Auto-generated method stub
		int scenario = 0;
		
		/**
		 * scanner for user input
		 */
		@SuppressWarnings({"resource"})
		Scanner sc = new Scanner(System.in);
		System.out.print("Would you like to conntinue with last game (proxy) or start new game (generate new)? continue/new >>> ");
		String choice = sc.next();
		
		/**
		 * conditional that sets scenario value
		 */
		if (choice.equalsIgnoreCase("continue"))
			scenario = 1;
		else
			scenario = 2;
		
		/**
		 * switch case that makes decision on scenario int value
		 */
		switch(scenario) {
		/**
		 * case 1 is used for proxy server cached object execution
		 */
		case 1:
			
			// stdout status
			System.out.println("You are using Proxy cache objects...");
			
			/**
			 * CONCURENT PATTERN
			 * creating instances of ProxyCountryGenerator, and
			 * thread instances
			 */
			ProxyCountryGenerator PCGIndependentCountry = new ProxyCountryGenerator();			
			Thread t1 = new Thread(PCGIndependentCountry);
			// setting first thread name
			t1.setName("Thread-1");
			// starting first thread
			t1.start();
			
			ProxyCountryGenerator PCGSuperIndependentCountry = new ProxyCountryGenerator();
			// setting second thread name
			Thread t2 = new Thread(PCGSuperIndependentCountry);
			t2.setName("Thread-2");
			// starting second thread
			t2.start();
			
			while (true) {
				try {
					t1.join();
					t2.join();
					break;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			// desirialize both objects e.g.(IndependentCountry, SuperIndependentCountry) 
			// for further object manipulation
			try {
				PCGIndependentCountry.deSerializeIndependentCountryObject();
				PCGSuperIndependentCountry.deSerializeSuperIndependentCountryObject();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/**
			 *  check if elements are available in both list
			 */
			// independent country list
			if (PCGIndependentCountry.originalCopyOfCountryGenerator.getIObjects().size() == 0) {
				System.out.print("\n\nGame is over: Independent Countries lost their battlefield...\n\n");
				break;
			}
			// super independent country list
			else if (PCGSuperIndependentCountry.originalCopyOfCountryGenerator.getSObjects().size() == 0) {
				System.out.print("\n\nGame is over: Super Independent Countries lost their battlefield...\n\n");
				break;
			}
			
			// assign countries to the battlefield
			this.arena.battleCountries(
					PCGIndependentCountry.originalCopyOfCountryGenerator.getIObjects().get(0), 
					PCGSuperIndependentCountry.originalCopyOfCountryGenerator.getSObjects().get(0));
			
			/**
			 *  remove elements form list that has health attribute values 0 or less
			 */
			// independent country list
			if(PCGIndependentCountry.originalCopyOfCountryGenerator.getIObjects().get(0).getAttributes().getHealth() <= 0) {
				PCGIndependentCountry.originalCopyOfCountryGenerator.getIObjects().remove(0);
			}
			// super independent country list
			if(PCGSuperIndependentCountry.originalCopyOfCountryGenerator.getSObjects().get(0).getAttributes().getHealth() <= 0) {
				PCGSuperIndependentCountry.originalCopyOfCountryGenerator.getSObjects().remove(0);
			} 
			
			// serialize objects
			try {
				PCGIndependentCountry.originalCopyOfCountryGenerator.serializeIndependentCountry();
				PCGSuperIndependentCountry.originalCopyOfCountryGenerator.serializeSuperIndependentCountry();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			// writing battle log into text files
			try {
				PCGIndependentCountry.originalCopyOfCountryGenerator.writeTextualFileForIndependentCountry();
				PCGSuperIndependentCountry.originalCopyOfCountryGenerator.writeTextualFileForSuperIndependentCountry();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			break;
			
		/**
		 * case 2 is used for execution of original objects
		 */
		case 2:
			// generating random value
			int random_two = 
			RandomFactory.setRandomValue("SmallestNumberGenerator", 1, 7).generate();
			
			// printing status
			System.out.println("You are using Original objects...");
			
			/**
			 * step 1:
			 * generating objects with random values,
			 * and adding objects to ArrayList with
			 * thread.sleep() method
			 * 
			 * step 2:
			 * serialize objects
			 */
			this.originalCopyOfCountryGenerator.generate();
			
			// assign countries to the battlefield
			this.arena.battleCountries(
					originalCopyOfCountryGenerator.getIObjects().get(random_two),
					originalCopyOfCountryGenerator.getSObjects().get(random_two)
					);
			
			// serialize objects
			try {
				this.originalCopyOfCountryGenerator.serializeIndependentCountry();
				this.originalCopyOfCountryGenerator.serializeSuperIndependentCountry();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			// writing battle log into text files
			try {
				this.originalCopyOfCountryGenerator.writeTextualFileForIndependentCountry();
				this.originalCopyOfCountryGenerator.writeTextualFileForSuperIndependentCountry();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}


	/**
	 * CONCURENT PATTERN
	 * override method, which forces process->thread asleep
	 */
	@Override
	public void run() {
		
		// getting instance of time for start point of thread execution
		int startSeconds = Calendar.getInstance().get(Calendar.SECOND);
		int startMiliSeconds = Calendar.getInstance().get(Calendar.MILLISECOND);

		
		System.out.printf(
				"\n\nUnload countries into battlefield...\n\tThread name: [%s] is lalaba at >>> [seconds %d : milliseconds %d]...\n\n", 
				Thread.currentThread().getName(),
				startSeconds,
				startMiliSeconds
				);
		// suspend threads
		try {
			
			Thread.sleep(4000);
			
			// printing status
			
		} catch (InterruptedException ie) {
			// TODO Auto-generated catch block
			ie.printStackTrace();
		}
		
		// getting instance of time for end point of thread execution
		int endSeconds = Calendar.getInstance().get(Calendar.SECOND);
		int endMiliSeconds = Calendar.getInstance().get(Calendar.MILLISECOND);
		
		// printing status
		System.out.printf(
				"\n\nLoad complete...\n\tThread name: [%s] is awake after >>> [seconds %d : milliseconds %d]...\n\n", 
				Thread.currentThread().getName(),
				(endSeconds - startSeconds),
				(endMiliSeconds - startMiliSeconds)
				);
	}
	
}
