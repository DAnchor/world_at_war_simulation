// package namespace
package package_class_country;


// imports
import java.util.ArrayList;
import java.util.List;

import package_class_attack.BaseAttack;
import package_class_attributes.CoreAttributes;


/**
 * IndependentCountry class
 * @author Dmitriy Jakovlevs
 * @param <T>
 * @param <N>
 * @param <N1>
 * @param <N2>
 */
public class IndependentCountry<T, N> extends Country<T, N> implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7666735169506615082L;
	/**
	 * variable declaration
	 */
	// declaring name of the country
	private T name;
	// initializing, and instantiate attributes
	private CoreAttributes<N> attributes = new CoreAttributes<N>();
	// initialize, and instantiate attack
	private List<BaseAttack<N>> attack = new ArrayList<BaseAttack<N>>();
	
	
	/**
	 * constructor overloading
	 */
	public IndependentCountry() {
		super();
	}

	
	/**
	 * parent Country class constructor with extended functionality for further
	 * invoke
	 * 
	 * @param name
	 * @param perimeter
	 * @param population
	 * @param resources
	 */
	public IndependentCountry(T name, CoreAttributes<N> attributes, List<BaseAttack<N>> attack) {
		this.setName(name);
		this.setAttributes(attributes);
		this.setAttack(attack);
	}

	
	/**
	 * setters/mutators
	 * @param attack
	 */
	// name
	@Override
	public void setName(T name) {
		this.name = name;
	}
	// attributes
	@Override
	public void setAttributes(CoreAttributes<N> attributes) {
		this.attributes = attributes;

	}
	// attack
	@Override
	public void setAttack(List<BaseAttack<N>> attack) {
		this.attack = attack;
	}
	
	
	/**
	 * getters/accessors
	 * @return
	 */
	// name
	@Override
	public T getName() {
		return name;
	}
	// attributes
	@Override
	public CoreAttributes<N> getAttributes() {
		return attributes;
	}
	// attack
	@Override
	public List<BaseAttack<N>> getAttack() {
		return this.attack;
	}
	

	/**
	 * overriden parent methods
	 * stdout 
	 */
	//name
	@Override
	public void countryName() {
		System.out.printf("Name >>> %s\nStatus >>> Independent Country\n", this.getName());
	}
	// attributes
	@Override
	public void resources() {
		System.out.printf("Resources >>> %s\n", this.getAttributes());
	}
	// attack power
	@Override
	public void attackPower( ) {
		System.out.printf(
				"Attack power >>> \n%s\n\n",
				this.getAttack()
				.toString()
				.replace(",", "")
				.replace("[", "")
				.replace("]", "")
				);
	}
	
	
	@Override
	public String toString() {
		return String.format(
				"name: %s, attributes: %s, attack: %s",
				this.getName(),
				this.getAttributes(),
				this.getAttack());
	}
}
