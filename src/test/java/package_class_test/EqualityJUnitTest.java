package package_class_test;

import static org.junit.Assert.*;

import org.junit.Test;
import package_class_country.IndependentCountry;
import package_class_country.NotCachedCountryGenerator;

/**
 * class for testing equality
 * @author Dmitriy Jakovlevs
 */
public class EqualityJUnitTest {

	@Test
	public void testCase1() {
		String ireland = "IRELAND";
		assertEquals(ireland, NotCachedCountryGenerator.IndependentCountryNames.IRELAND);
	}
	
	@Test
	public void testCase2() {
		IndependentCountry<String, Integer> ireland = new IndependentCountry<String, Integer>();
		ireland.setName("Ireland");
		assertEquals(ireland, ireland.getName());
	}
}
