package package_class_country;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import package_class_attack.BaseAttack;
import package_class_attributes.CoreAttributes;
import package_class_thread.ThreadManipulator;
import package_singleton_attack.AttackFactory;
import package_singleton_random.RandomFactory;

/**
 * OriginalCopyOfCountryGenerator is a subclass of CountryGenerator class 
 * @author Dmitriy Jakovlevs
 */
public class NotCachedCountryGenerator extends CountryGenerator {
	
	/**
	 * private instances, and variables
	 */
	// static variables
	private String serializableIndependentCountryFile = 
			"/serializable_objects/IndependentCountries.ser";
	private String serializableSuperIndependentCountryFile = 
			"/serializable_objects/SuperIndependentCountries.ser";
	private String textualIndependentCountryFile = 
			"/serializable_objects/LastBattleIndependentCountry.txt";
	private String textualSuperIndependentCountryFile = 
			"/serializable_objects/LastBattleSuperIndependentCountry.txt";
	private String path = System.getProperty("user.dir");
	
	// instances
	private ThreadManipulator thread = new ThreadManipulator();
	private List<BaseAttack<Integer>> attacksIndependent = 
			new ArrayList<BaseAttack<Integer>>();
	private List<BaseAttack<Integer>> attacksSuperIndependent = 
			new ArrayList<BaseAttack<Integer>>();
	private List<SuperIndependentCountry<String, Integer>> sCountryList =
			new ArrayList<SuperIndependentCountry<String, Integer>>();
	private List<IndependentCountry<String, Integer>> countryList = 
			new ArrayList<IndependentCountry<String, Integer>>();
	
	
	/**
	 * constructor overloading
	 */
	public NotCachedCountryGenerator(){ super(); }
	
	
	/**
	 * base constructor
	 * @param attacksIndependent
	 * @param attacksSuperIndependent
	 * @param sCountryList
	 * @param countryList
	 */
	public NotCachedCountryGenerator(
			List<BaseAttack<Integer>> attacksIndependent,
			List<BaseAttack<Integer>> attacksSuperIndependent,
			List<SuperIndependentCountry<String, Integer>> sCountryList,
			List<IndependentCountry<String, Integer>> countryList) {
		super();
		this.attacksIndependent = attacksIndependent;
		this.attacksSuperIndependent = attacksSuperIndependent;
		this.sCountryList = sCountryList;
		this.countryList = countryList;
	}
	
	
	/**
	 * ENUM
	 * static enum collection for
	 * super independent countries 
	 * @author Dmitriy Yakovlev
	 *
	 */
	public enum SuperIndependentCountryNames {
		RUSSIA, USA, CHINA,
		KOREA, INDIA, FRANCE,
		ISRAEL, PAKISTAN
	}
	
	
	/**
	 * ENUM
	 * static enum collection for
	 * independent countries 
	 * @author Dmitriy Yakovlev
	 *
	 */
	public enum IndependentCountryNames {
		GERMANY, IRELAND, POLAND,
		BULGARIA, DENMARK, GREECE,
		ICELAND, PORTUGAL
	}
	

	/**
	 * super independent contry generator
	 * @throws InterruptedException
	 */
	public void generateSuperIndependentCountryObjects() throws InterruptedException {
		
		/**
		 * static SINGLETON random class
		 */
		int firstAttrVal = RandomFactory.setRandomValue("SmallNumberGenerator", 9, 50).generate();
		int secondAttrVal = RandomFactory.setRandomValue("SmallNumberGenerator", 8, 50).generate();
		int thirdAttrVal = RandomFactory.setRandomValue("SmallNumberGenerator", 3, 50).generate();
		int population = RandomFactory.setRandomValue("BigNumberGenerator", 999999, 9999999).generate();
		int perimeter = RandomFactory.setRandomValue("BigNumberGenerator", 999999, 9999999).generate();
		// zero value for loop array manipulation
		int zero = 0;
		
		/**
		 * static SINGLETON attack class with random values
		 */
		this.attacksIndependent.add(AttackFactory.setAttack("GroundForce", firstAttrVal));
		this.attacksIndependent.add(AttackFactory.setAttack("AirForce", secondAttrVal));
		this.attacksIndependent.add(AttackFactory.setAttack("NuclearBlast", thirdAttrVal));
		// instance of super independent class object
		SuperIndependentCountry<String, Integer> country;
		// instance of super independent country list
		this.sCountryList = new ArrayList<SuperIndependentCountry<String, Integer>>();
		
		// notification
		System.out.println("<<<\t"+"Adding Super Independent Country Elements"+"\t>>>\n");
		
		/**
		 * iterating over all enumerated elements 
		 * in super independent country names method
		 */
		for (SuperIndependentCountryNames obj : SuperIndependentCountryNames.values()) {
			// instantiating new objects
			country = new SuperIndependentCountry<String, Integer>(
					obj.name(),
					new CoreAttributes<Integer>(100, population, perimeter),
					attacksIndependent
					);
			
			// getting current list size
			int currentLoopCount = this.sCountryList.size();
			
			// adding new elements to list
			this.sCountryList.add(country);
			
			// printing current list state
			System.out.printf(
					"(%s) adding [object: \"%s\"] ->",
					this.sCountryList.size(),
					this.sCountryList.get(zero + currentLoopCount).getName()
					);	
			
			// forcing thread to sleep
			this.thread.suspendThread();
		}
		// new line
		System.out.print("\n");
	}

	
	/**
	 * super independent contry generator
	 * @throws InterruptedException
	 */
	public void generateIndependentCountryObjects() throws InterruptedException {
		
		/**
		 * static SINGLETON random number generator class
		 */
		int firstAttrVal = RandomFactory.setRandomValue("SmallNumberGenerator", 2, 50).generate();
		int secondAttrVal = RandomFactory.setRandomValue("SmallNumberGenerator", 4, 50).generate();
		int population = RandomFactory.setRandomValue("BigNumberGenerator", 1099999, 9999999).generate();
		int perimeter = RandomFactory.setRandomValue("BigNumberGenerator", 1099999, 9999999).generate();
		
		// zero value for loop array manipulation
		int zero = 0;
		
		/**
		 * static SINGLETON attack class with random values
		 */
		this.attacksSuperIndependent.add(AttackFactory.setAttack("GroundForce", firstAttrVal));
		this.attacksSuperIndependent.add(AttackFactory.setAttack("AirForce", secondAttrVal));
		// instance of super independent country list
		this.countryList = new ArrayList<IndependentCountry<String, Integer>>();
		// instance of super independent class object
		IndependentCountry<String, Integer> country;
		
		// notification
		System.out.println("<<<\t"+"Adding Independent Country Elements"+"\t>>>\n");
		
		/**
		 * iterating over all enumerated elements 
		 * in independent country names method
		 */
		for (IndependentCountryNames i : IndependentCountryNames.values()) {
			// instantiating new objects
			country = new IndependentCountry<String, Integer>(
					i.name(),
					new CoreAttributes<Integer>(100, population, perimeter),
					attacksSuperIndependent
					);
			
			// getting current list size
			int currentLoopCount = this.countryList.size();
			
			// adding new elements to list
			this.countryList.add(country);
			
			/**
			 * uncomment section below to observe serializable
			 * independent country objects
			 */
			// printing current list state
			System.out.printf(
					"(%s) adding [object: \"%s\"] ->",
					this.countryList.size(),
					this.countryList.get(zero + currentLoopCount).getName()
					);
			
			// forcing thread to sleep
			this.thread.suspendThread();
		}
	}
	
	
	/**
	 * setters/mutators
	 * @param countryList, sCountryList
	 */
	// independent country
	public void setIndependentCountryList(ArrayList<IndependentCountry<String, Integer>> countryList) {
		this.countryList = countryList;
	}
	// super independent country
	public void setSuperIndependentCountryList(ArrayList<SuperIndependentCountry<String, Integer>> sCountryList) {
		this.sCountryList = sCountryList;
	}
	
	
	/**
	 * method that returns super independent country, 
	 * independent country list
	 * @return
	 */
	public List<SuperIndependentCountry<String, Integer>> getSObjects() {
		return this.sCountryList;
	}
	public List<IndependentCountry<String, Integer>> getIObjects() {
		return this.countryList;
	}
	
	
	/**
	 * serializes/map independent country collection
	 * @param countryGenericObj
	 * @throws IOException
	 */
	public void serializeIndependentCountry() throws IOException {
		try {
			/**
			 * iterating over all enumerated elements 
			 * in independent country names method
			 */
			FileOutputStream fileOut = new FileOutputStream(
					this.path + this.serializableIndependentCountryFile
					);
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(this.countryList);
			objOut.close();
			fileOut.close();
			
			/**
			 * uncomment section below to observe serializable
			 * super independent country objects
			 */
//			System.out.printf(
//					"\nserialized: %s\nto path: %s\n", 
//					this.countryList.toString(),
//					this.path + this.serializableIndependentCountryFile
//					);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	
	/**
	 * serializes/map super independent country collection
	 * @param countryGenericObj
	 * @throws IOException
	 */
	public void serializeSuperIndependentCountry() throws IOException {
		try {
			FileOutputStream fileOut = new FileOutputStream(
					this.path + this.serializableSuperIndependentCountryFile
					);
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(this.sCountryList);
			objOut.close();
			fileOut.close();
//			System.out.printf(
//					"\nserialized: %s\nto path: %s\n", 
//					this.sCountryList.toString(),
//					this.path + this.serializableSuperIndependentCountryFile
//					);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	
	/**
	 * DECORATOR
	 * maps textual file for independent country
	 * @param countryGenericObj
	 * @throws IOException
	 */
	public void writeTextualFileForIndependentCountry() throws IOException {
		try {
			BufferedWriter fileOut = new BufferedWriter(new FileWriter(this.path + this.textualIndependentCountryFile));
			fileOut.write(this.countryList.toString());
			fileOut.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}		
	}
	
	
	/**
	 * DECORATOR
	 * maps textual file for super independent country
	 * @param countryGenericObj
	 * @throws IOException
	 */
	public void writeTextualFileForSuperIndependentCountry() throws IOException {
		try {
			BufferedWriter fileOut = new BufferedWriter(new FileWriter(this.path + this.textualSuperIndependentCountryFile));
			fileOut.write(this.sCountryList.toString());
			fileOut.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}		
	}
	
	/**
	 * STRUCTURAL PROXY
	 * original object generator: 
	 * this method is inherited from parent super abstract class
	 */
	@Override
	public void generate() {
		/**
		 * generating objects with random values,
		 * and adding objects to ArrayList with
		 * thread.sleep() method
		 */
		try {
			this.generateIndependentCountryObjects();
			this.generateSuperIndependentCountryObjects();
		} catch (InterruptedException ie) {
			// TODO Auto-generated catch block
			ie.printStackTrace();
		}
		
		/**
		 * serialize objects
		 */
//		try {
//			this.serializeIndependentCountry();
//			this.serializeSuperIndependentCountry();
//		} catch (IOException ioe) {
//			// TODO Auto-generated catch block
//			ioe.printStackTrace();
//		}
		
	}
	
}
