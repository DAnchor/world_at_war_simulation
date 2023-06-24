// package namespace
package package_class_attack;


import package_interface_attack.AttackInterface;


/**
 * BaseAttack is parent class with composition
 * @author Dmitriy Jakovlevs
 * @param <N>
 */
public abstract class BaseAttack<N> implements AttackInterface, java.io.Serializable  {
	
	
	/**
	 * serializable id
	 */
	private static final long serialVersionUID = -1236948244071458510L;
	
	/**
	 * setter/mutator for attack multiplier
	 * @param multiplier
	 */
	public abstract void setMultiplier(N multiplier);
	
	
	/**
	 * getter/accessor for attack multiplier
	 * @return
	 */
	public abstract N getMultiplier();
	
	
	/**
	 * overrides attack-interface method attack
	 */
	@Override
	public abstract String attack();
	
	
	/**
	 * stdout-overrides toString method
	 */
	@Override
	public String toString() {
		return String.format("%s", this.attack());
	}
}
