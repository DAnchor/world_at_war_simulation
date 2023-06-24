package package_singleton_attack;

/**
 * custom package import
 */
import package_class_attack.AirForce;
import package_class_attack.BaseAttack;
import package_class_attack.GroundForce;
import package_class_attack.NuclearBlast;

/**
 * @author Dmitriy Jakovlevs
 * attack factory class
 */
public class AttackFactory {
	
	/**
	 * SINGLETON PATTERN
	 * @param type
	 * @param multiplier
	 * @return
	 * @throws RuntimeException
	 */
	public static BaseAttack<Integer> setAttack(
			String type, Integer multiplier
			) throws RuntimeException {
		
		// conditional variable
		int conditional_scenario = 0;
		
		// conditional comparison
		if("GroundForce".equalsIgnoreCase(type))
			conditional_scenario = 1;
		else if("AirForce".equalsIgnoreCase(type))
			conditional_scenario = 2;
		else if("NuclearBlast".equalsIgnoreCase(type))
			conditional_scenario = 3;
		else
			throw new RuntimeException(String.format("%s not specified!", type));
		
		// switch case that is based on conditional result
		switch(conditional_scenario) {
		case 1:
			return new GroundForce<Integer>(multiplier);
		case 2:
			return new AirForce<Integer>(multiplier);
		case 3:
			return new NuclearBlast<Integer>(multiplier);
		
		}
		
		return null;
	}
}
