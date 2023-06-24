package package_class_thread;

import java.util.Calendar;


/**
 * @author Dmitriy Jakovlevs
 *
 */
public class ThreadManipulator implements java.lang.Runnable {
	
	/**
	 * constructor overload
	 */
	public ThreadManipulator() {}
	
	/**
	 * manipulate threads
	 */	
	public void suspendThread() {
		
		// run iterator
		this.run();
		
		// print status
		System.out.printf(
				"\n\t-> Thread name: [%s] is asleep at >>> [seconds %d : milliseconds %d]...\n\n", 
				Thread.currentThread().getName(),
				Calendar.getInstance().get(Calendar.SECOND),
				Calendar.getInstance().get(Calendar.MILLISECOND)
				);
	}
	
	/**
	 * override method, which forces process->thread suspend
	 */
	@Override
	public void run() {
		
		// suspend thread
		try {
			Thread.sleep(250);
		} catch (InterruptedException ie) {
			// TODO Auto-generated catch block
			ie.printStackTrace();
		}
	}
}

