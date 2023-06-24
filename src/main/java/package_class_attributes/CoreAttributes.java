// package namespace
package package_class_attributes;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

/**
 * BEHAVIOURAL OBSERVER (EVENT LISTENER)
 * class CoreAttributes
 * 
 * @author Dmitriy Jakovlevs
 * @param <N>
 */
public class CoreAttributes<N> implements java.beans.PropertyChangeListener, java.io.Serializable {

	/**
	 * serialization id
	 */
	private static final long serialVersionUID = 8460279295350232714L;
	
	/**
	 * variable declaration
	 */
	// generic
	private N health;
	private N population;
	private N perimeter;
	
	// instance
	private PropertyChangeSupport psc = new PropertyChangeSupport(this);

	
	/**
	 * constructor overloading
	 */
	public CoreAttributes() {
	}

	
	/**
	 * constructor
	 * @param health
	 * @param population
	 * @param perimeter
	 */
	public CoreAttributes(N health, N population, N perimeter) {
		this.setHealth(health);
		this.setPopulation(population);
		this.setPerimeter(perimeter);
		this.psc.addPropertyChangeListener(this);
	}

	
	/**
	 * OBSERVER METHOD (EVENT LISTENER)
	 * setters/mutators
	 * @param health
	 */
	// health that has firePropertyChange event listener
	public void setHealth(N health) {
		N oldHealthValue = this.getHealth();
		this.health = health;
		this.psc.firePropertyChange("health", oldHealthValue, health);
	}

	
	/**
	 * OBSERVER METHOD (EVENT LISTENER)
	 * @param population
	 */
	// population that has firePropertyChange event listener
	public void setPopulation(N population) {
		N oldPapulationValue = this.getPopulation();
		this.population = population;
		this.psc.firePropertyChange("population", oldPapulationValue, population);
	}

	
	// perimeter
	public void setPerimeter(N perimeter) {
		this.perimeter = perimeter;
	}

	
	/**
	 * getters/accessors
	 * 
	 * @return
	 */
	// health
	public N getHealth() {
		return health;
	}
	
	// population
	public N getPopulation() {
		return population;
	}

	// perimeter
	public N getPerimeter() {
		return perimeter;
	}

	
	/**
	 * stdout overriden
	 */
	@Override
	public String toString() {
		return String.format("health: %s, Population: %s, Perimeter: %sKm\u00B2", this.getHealth(),
				this.getPopulation(), this.getPerimeter());
	}

	
	/**
	 * stdout changes to the attributes based on specific event
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		System.out.printf(
				"\t<<< ATTENTION changing values for >>> %s: [old-value: %s -> new-value: %s] <<< ATTENTION >>>\n",
				evt.getPropertyName(), evt.getOldValue(), evt.getNewValue());
	}
}
