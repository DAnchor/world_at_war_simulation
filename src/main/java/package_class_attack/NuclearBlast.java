/**
 *  package name space
 */
package package_class_attack;

/**
 * class NuclearBlast is a subclass of BaseAttack
 * @author Dmitriy Jakovlevs
 * @param <N>
 */
public class NuclearBlast<N> extends BaseAttack<N> implements java.io.Serializable  {
	
	
	/**
	 * serializable id
	 */
	private static final long serialVersionUID = 2328266508272446878L;
	/**
	 * variable declaration
	 */
	// generic multiplier
	private N multiplier;
	
	
	/**
	 * constructor overloading
	 */
	public NuclearBlast() { super(); }
	
	
	/**
	 * base constructor
	 * @param multiplier
	 */
	public NuclearBlast(N multiplier) {
		super();
		this.setMultiplier(multiplier);
	}
	
	
	/**
	 * setter/mutator
	 * @param multiplier
	 */
	// multiplier
	@Override
	public void setMultiplier(N multiplier) {
		this.multiplier = multiplier;
	}
	
	
	/**
	 * getter/accessor
	 * @return
	 */
	// multiplier
	@Override
	public N getMultiplier() {
		return this.multiplier;
	}
	
	
	/**
	 * stdout-overriden attack
	 * method from superclass
	 */
	// attack
	@Override
	public String attack() {
		return String.format(
				"\t- Nuclear-Blast: x(%d)\n",
				this.getMultiplier()
				);
	}
}
