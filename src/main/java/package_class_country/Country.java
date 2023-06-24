/**
 *  package name space
 */
package package_class_country;

import java.util.List;

import package_class_attack.BaseAttack;
import package_class_attributes.CoreAttributes;

/**
 * ABSTRACT FACTORY PATTERN
 * Country Class
 * @author Dmitriy Jakovlevs
 *
 * @param <T>
 * @param <N>
 * @param <N>
 */
public abstract class Country<T, N>  implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4319141514177843260L;

	/**
	 * setters/mutators
	 * @param name
	 */
	// name
	public abstract void setName(T name);
	// attributes
	public abstract void setAttributes(CoreAttributes<N> attributes);
	// attack
	public abstract void setAttack(List<BaseAttack<N>> attack);
	
	
	/**
	 * getters/accessors
	 * @return
	 */
	// name
	public abstract T getName();
	// attributes
	public abstract CoreAttributes<N> getAttributes();
	// attack
	public abstract List<BaseAttack<N>> getAttack();
	
	
	/**
	 * this methods are
	 * inherited by subclasses,
	 * and they are overriden
	 * stdout
	 */
	// name
	public abstract void countryName();
	// resources
	public abstract void resources();
	// attack power
	public abstract void attackPower();
}
