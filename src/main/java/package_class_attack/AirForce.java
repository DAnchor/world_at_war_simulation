/**
 *  package name space
 */
package package_class_attack;

/**
 * class AirForce is a subclass of BaseAttack
 * of BaseAttack
 * @author Dmitriy Jakovlevs
 *
 * @param <N>
 */
public class AirForce<N> extends BaseAttack<N>  implements java.io.Serializable  {

	
	/**
	 * serializable id
	 */
	private static final long serialVersionUID = 6095024875888499370L;
	
	/**
	 * variable declaration
	 */
	// generic multiplier
	private N multiplier;

	
	/**
	 * constructor overloading
	 */
	public AirForce() {
		super();
	}

	
	/**
	 * base constructor
	 * @param multiplier
	 */
	public AirForce(N multiplier) {
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
				"\t- Air-force: x(%d)\n",
				this.getMultiplier()
				);
	}
}
