package package_class_random;


/**
 * ABSTRACT FACTORY
 * parent class of all attack child classes
 * @author Dmitriy Jakovlevs
 * @param <N>
 */
public abstract class RandomNumberGenerator<N> {
	
	/**
	 * setters/mutators
	 * @param min, max
	 */
	// min
	public abstract void setMin(N min);
	// max
	public abstract void setMax(N max);
	
	
	/**
	 * getters/accesssors
	 * @return
	 */
	// min
	public abstract N getMin();
	// max
	public abstract N getMax();
	
	
	/**
	 * generate method, for generating random integer values
	 * @return
	 */
	public abstract int generate();
}
