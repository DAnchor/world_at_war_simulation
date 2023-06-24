package package_class_test;

import package_class_country.Country;
import package_class_country.IndependentCountry;
import package_class_country.SuperIndependentCountry;
import package_singleton_attack.AttackFactory;
import package_class_attributes.CoreAttributes;
import package_class_attack.BaseAttack;
import package_class_arena.Arena;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class for testing static values
 * @author Dmitriy Jakovlevs
 *
 */
public class StaticMainProxyTest {
	
	
	public static void staticTest() {
		
		// instances of classes
		Arena arena = new Arena();
		List<BaseAttack<Integer>> attack = new ArrayList<BaseAttack<Integer>>();
		
		
		// adding new attacks
		attack.add(AttackFactory.setAttack("GroundForce", 20));
		attack.add(AttackFactory.setAttack("AirForce", 40));
		
		
		// instantiating independent country
		Country<String, Integer> independent = 
				new IndependentCountry<String, Integer>(
						"Germany",
						new CoreAttributes<Integer>(100, 30000, 40000),
						attack
				);
		
		// stdout status
		independent.countryName();
		independent.resources();
		independent.attackPower();
		
		
		// adding new attacks
		attack.clear();
		attack.add(AttackFactory.setAttack("GroundForce", 40));
		attack.add(AttackFactory.setAttack("AirForce", 50));
		attack.add(AttackFactory.setAttack("NuclearBlast", 50));
		
		// instantiating super independent country
		Country<String, Integer> superIndependent = 
				new SuperIndependentCountry<String, Integer>(
						"USA",
						new CoreAttributes<Integer>(100, 60000, 80000),
						attack
						);
		
		
		// stdout status
		superIndependent.countryName();
		superIndependent.resources();
		superIndependent.attackPower();
		
		
		// executing arena method
		arena.battleCountries(independent, superIndependent);
		
	}
	
	public static void main(String... strings) {
		staticTest();
	}
}
