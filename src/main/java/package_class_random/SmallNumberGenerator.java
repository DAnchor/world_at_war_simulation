package package_class_random;

/**
 * built-in imports
 */
import java.util.Random;


/**
 * child class of RandomNumberGenerator which
 * generates values range 1-50
 * @author Dmitriy Jakovlevs
 * @param <N>
 */
public class SmallNumberGenerator<N> extends RandomNumberGenerator<N> {
	
	/**
	 * private generic variables, and instances
	 */
	// generic
	private N min, max;
	
	// instance
	private Random r;
	
	
	/**
	 * constructor overloading
	 */
	public SmallNumberGenerator() {}
	
	
	/**
	 * base constructor
	 * @param min
	 * @param max
	 */
	public SmallNumberGenerator(N min, N max) {
		this.setMin(min);
		this.setMax(max);
	}
	
	
	/**
	 *  getters/accessors
	 *  @return min, max
	 */
	// min
	@Override
	public N getMin() {
		// TODO Auto-generated method stub
		return this.min;
	}
	// max
	@Override
	public N getMax() {
		// TODO Auto-generated method stub
		return this.max;
	}

	
	/**
	 * setters/mutators
	 * @param min
	 */
	// min
	@Override
	public void setMin(N min) {
		// TODO Auto-generated method stub
		this.min = min;
	}
	// max
	@Override
	public void setMax(N max) {
		// TODO Auto-generated method stub
		this.max = max;
	}

	
	/**
	 * random value generator in range of 1-50
	 */
	@Override
	public int generate() {
		// TODO Auto-generated method stub
		if (((int) this.min >= (int) this.max)) {
			throw new IllegalArgumentException("min must be greater than max...");
		} else if ((int) this.min < 1) {
			throw new IllegalArgumentException("min must be greater than 0 but not greater than max value...");
		} else if ((int) this.max > 50) {
			throw new IllegalArgumentException("min must be less or equal 50, but not less than min value...");
		}
		this.r = new Random();
		
		return this.r.nextInt(((int)max - (int)min) + 1);
	}

}
