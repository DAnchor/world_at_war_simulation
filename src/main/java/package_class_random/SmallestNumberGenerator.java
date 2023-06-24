package package_class_random;

import java.util.Random;

/**
 * child class of RandomNumberGenerator that
 * generates values range 1-7
 * @author Dmitriy Jakovlevs
 * @param <N>
 */
public class SmallestNumberGenerator<N> extends RandomNumberGenerator<N> {
	
	/**
	 * private generic variables, and instances
	 */
	// generic
	private N min, max;
	
	// instance
	private Random randomInstance;
	
	
	/**
	 * constructor overloading
	 */
	public SmallestNumberGenerator() {}
	
	
	/**
	 * base constructor
	 * @param min
	 * @param max
	 */
	public SmallestNumberGenerator(N min, N max) {
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
	 * random value generator in range of 1-7
	 */
	@Override
	public int generate() {
		// TODO Auto-generated method stub
		if (((int) this.min >= (int) this.max)) {
			throw new IllegalArgumentException("min must be greater than max...");
		} else if ((int) this.min < 0) {
			throw new IllegalArgumentException("min must be 0...");
		} else if ((int) this.max > 7) {
			throw new IllegalArgumentException("min must be less or equal 7, but not less than min value...");
		}
		this.randomInstance = new Random();
		
		return this.randomInstance.nextInt(((int)max - (int)min) + 1);
	}
}
