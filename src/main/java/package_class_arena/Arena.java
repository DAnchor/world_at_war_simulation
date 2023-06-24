package package_class_arena;

import java.util.Scanner;

import package_class_attack.BaseAttack;
import package_class_country.Country;
import package_class_country.IndependentCountry;
import package_class_country.SuperIndependentCountry;

import java.lang.Math;

/**
 * class that control battlefield between countries
 * @author Dmitriy Jakovlevs
 */
public class Arena {
	
	
	/**
	 * instances
	 */
	private SuperIndependentCountry<String, Integer> sindpc = 
			new SuperIndependentCountry<String, Integer>();
	private IndependentCountry<String, Integer> indpc = 
			new IndependentCountry<String, Integer>();
	
	
	/**
	 * method that enables battle
	 * between two countries
	 * @param indpc
	 * @param sindpc
	 */
	public void battleCountries(
			Country<String, Integer> indpc,
			Country<String, Integer> sindpc) {
		
		
		/**
		 * initialized instances
		 */
		this.indpc = (IndependentCountry<String, Integer>) indpc;
		this.sindpc = (SuperIndependentCountry<String, Integer>) sindpc;

		
		/**
		 * printing actions for parties that
		 * are involved in battle
		 */
		System.out.println("________________________");
		System.out.println(String.format(
				"\t<<< LETS BATTLE BEGIN >>>\nCompetitors >>>\n(1) country: %s\n(2) country: %s\n",
				this.indpc.getName(),
				this.sindpc.getName())
				);
		System.out.println("________________________");
		int country = 0;
		
		@SuppressWarnings({"resource"})
		Scanner sc = new Scanner(System.in);
		System.out.printf(
				"\nPlease choose country which will strike first >>> "
				+ "e.g. [(1) for %s] or [(2) for %s]: ",
				this.indpc.getName(),
				this.sindpc.getName()
				);
		
		
		/**
		 * system scanner that takes value in
		 * for enabling country turn
		 */
		// conditional variable
		int xCountry = sc.nextInt();
		
		// variable for incrementing counter
		int counter = 0;
		
		// conditional 
		if (xCountry == 1)
			country = 1;
		else
			country = 2;
		
		// switch case that takes conditional value result
		switch(country) {
		
		// independent country strikes
		case 1:
			do {
				
				/**
				 * triggering random strike
				 * generation sequence
				 */
				BaseAttack<Integer> x = this.randomAttackkGeneratorIC(indpc);
				BaseAttack<Integer> y = this.randomAttackkGeneratorSIC(sindpc);
				
				// increment counter
				counter++;
				
				// printing current independent country state
				System.out.println("________________________");
				System.out.printf(
						"\n%s strike #%s: %s",
						indpc.getName(),
						counter,
						x
						);
				// setting values to object based on actions
				this.sindpc.getAttributes().setHealth((this.sindpc.getAttributes().getHealth() - x.getMultiplier()));
				this.sindpc.getAttributes().setPopulation((int)
						((float)this.sindpc.getAttributes().getPopulation() - 
								(((float)x.getMultiplier() / 100) * (float)this.sindpc.getAttributes().getPopulation())));
				this.sindpc.countryName();
				this.sindpc.resources();
				
				// printing current state super independent country
				System.out.printf(
						"\n%s strike #%s: %s",
						sindpc.getName(),
						counter,
						y
						);
				
				// setting values to object based on actions
				this.indpc.getAttributes().setHealth((this.indpc.getAttributes().getHealth() - y.getMultiplier()));	
				this.indpc.getAttributes().setPopulation((int)
						((float)this.indpc.getAttributes().getPopulation() - 
								(((float)y.getMultiplier() / 100) * (float)this.indpc.getAttributes().getPopulation())));
				this.indpc.countryName();
				this.indpc.resources();
			} while((this.indpc.getAttributes().getHealth() > 0) && (this.sindpc.getAttributes().getHealth() > 0));
			break;
			
		// super independent strikes
		case 2:
			
			/**
			 * triggering random strike
			 * generation sequence
			 */
			do {
				BaseAttack<Integer> x = this.randomAttackkGeneratorIC(indpc);
				BaseAttack<Integer> y = this.randomAttackkGeneratorSIC(sindpc);
				
				// increment counter
				counter++;
				
				// printing current independent country state
				System.out.println("________________________");
				System.out.printf(
						"\n%s strike #%s: %s",
						sindpc.getName(),
						counter,
						y
						);
					
				// setting values to object based on actions
				this.indpc.getAttributes().setHealth((this.indpc.getAttributes().getHealth() - y.getMultiplier()));
				this.indpc.getAttributes().setPopulation((int)
						((float)this.indpc.getAttributes().getPopulation() - 
								(((float)y.getMultiplier() / 100) * (float)this.indpc.getAttributes().getPopulation())));
				this.indpc.countryName();
				this.indpc.resources();
				
				// printing current independent country state
				System.out.printf(
						"\n%s strike #%s: %s",
						indpc.getName(),
						counter,
						x
						);
					
				// setting values to object based on actions
				this.sindpc.getAttributes().setHealth((this.sindpc.getAttributes().getHealth() - x.getMultiplier()));
				this.sindpc.getAttributes().setPopulation((int)
						((float)this.sindpc.getAttributes().getPopulation() - 
								(((float)x.getMultiplier() / 100) * (float)this.sindpc.getAttributes().getPopulation())));
				this.sindpc.countryName();
				this.sindpc.resources();
			} while((this.indpc.getAttributes().getHealth() > 0) && (this.sindpc.getAttributes().getHealth() > 0));
			break;
		}
//		sc.close();
	}
	
	/**
	 * attack generator for independent country
	 * @param indpc
	 * @return
	 */
	public BaseAttack<Integer> randomAttackkGeneratorIC(Country<String, Integer> indpc) {
		// country one attack
		this.indpc = (IndependentCountry<String, Integer>) indpc;
		int range = 2;
		int random = (int) (Math.random() * (range));
		
		switch(random) {
		case 0:
			this.indpc.getAttack().get(0).getMultiplier();
			break;
		case 1:
			this.indpc.getAttack().get(1).getMultiplier();
			break;
		} return this.indpc.getAttack().get(random);
	}
	
	
	/**
	 * attack generator for super independent country
	 * @param indpc
	 * @return
	 */
	public BaseAttack<Integer> randomAttackkGeneratorSIC(Country<String, Integer> indpc) {
		
		// country one attack
		int range = 3;
		int random = (int) (Math.random() * (range));
		
		switch(random) {
		case 0:
			this.sindpc.getAttack().get(0).getMultiplier();
			break;
		case 1:
			this.sindpc.getAttack().get(1).getMultiplier();
			break;
		case 2:
			this.sindpc.getAttack().get(2).getMultiplier();
			break;
		}
		return this.sindpc.getAttack().get(random);
	}
}
