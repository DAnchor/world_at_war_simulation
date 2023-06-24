/**
 *  package name space
 */
package package_class_attack;

/**
 * class GroundForce is a subclass of BaseAttack
 * @author Dmitriy Jakovlevs
 * @param <N>
 */
public class GroundForce<N> extends BaseAttack<N> implements java.io.Serializable  {
	
	
	/**
	 * serializable id
	 */
	private static final long serialVersionUID = -8173030036159862556L;
	/**
	 * variable declaration
	 */
	// generic multiplier
	private N multiplier;

	
	/**
	 * constructor overloading
	 */
	public GroundForce() {
		super();
	}

	
	/**
	 * base constructor
	 * @param multiplier
	 */
	public GroundForce(N multiplier) {
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
				"\t- Ground-force: x(%d)\n",
				this.getMultiplier()
				);
	}
}
