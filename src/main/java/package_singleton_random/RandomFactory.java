package package_singleton_random;

import package_class_random.BigNumberGenerator;
import package_class_random.RandomNumberGenerator;
import package_class_random.SmallNumberGenerator;
import package_class_random.SmallestNumberGenerator;


/**
 * method for creation of objects 
 * @author Dmitriy Jakovlevs
 *
 */
public class RandomFactory {

	/**
	 * SINGELTON PATTERN
	 * @param type
	 * @param min
	 * @param max
	 * @return
	 * @throws RuntimeException
	 */
	public static RandomNumberGenerator<Integer> setRandomValue(
			String type, Integer min, Integer max)
			throws RuntimeException {
		
		// conditional variable
		int conditional_scenario = 0;
		
		// conditional comparison
		if ("SmallestNumberGenerator".equalsIgnoreCase(type))
			conditional_scenario = 1;
		else if ("SmallNumberGenerator".equalsIgnoreCase(type))
			conditional_scenario = 2;
		else if ("BigNumberGenerator".equalsIgnoreCase(type))
			conditional_scenario = 3;
		else
			throw new RuntimeException(String.format("% not specified", type));

		// switch case that is based on conditional result
		switch (conditional_scenario) {
		case 1:
			return new SmallestNumberGenerator<Integer>(min, max);
		case 2:
			return new SmallNumberGenerator<Integer>(min, max);
		case 3:
			return new BigNumberGenerator<Integer>(min, max);
		}

		return null;
	}
}
