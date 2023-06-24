/**
 * controller for IndependantCountry class
 */
package package_class_country;


// imports
import java.util.ArrayList;
import java.util.List;

import package_class_attack.BaseAttack;
import package_class_attributes.CoreAttributes;


/**
 * SuperIndependentCountry is a subclass of CountryGenerator
 * @author Dmitriy Jakovlevs
 * @param <T>
 */
public class SuperIndependentCountry<T, N> extends Country<T, N> implements java.io.Serializable  {
	
	
	/**
	 * serializable id
	 */
	private static final long serialVersionUID = 1012216816908527277L;
	/**
	 * variables , and instances
	 */
	// generic
	private T name;
	// instances
	private CoreAttributes<N> attributes = new CoreAttributes<N>();
	private List<BaseAttack<N>> attack = new ArrayList<BaseAttack<N>>();
	
	
	/**
	 * constructor overload
	 */
	public SuperIndependentCountry() {
		super();
	}
	
	
	/**
	 * base constructor
	 * @param unionName
	 */
	public SuperIndependentCountry(T name, CoreAttributes<N> attributes, List<BaseAttack<N>> attack) {
		this.setName(name);
		this.setAttributes(attributes);
		this.setAttack(attack);
	}
	
	
	/**
	 * setter/mutator
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
	 * getter/accessor
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
		System.out.printf("Name >>> %s\nStatus >>> Super Independent Country\n", this.getName());
	}
	
	//  resources
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
	
	// override toString method
	@Override
	public String toString() {
		return String.format(
				"name: %s, attributes: %s, attack: %s",
				this.getName(),
				this.getAttributes(),
				this.getAttack());
	}


}
