/**
 * 
 */

/**
 * @author Sundeep
 *
 */
public class ThreadsClass implements Runnable{

	/**
	 * 
	 */
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ThreadsClass class1 = new ThreadsClass("MyTread");
		class1.start();class1.run();*/
		Thread thread = new Thread(new ThreadsClass(),"myRunnable");
		thread.start();
		thread.run();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(":"+Thread.currentThread().getName());
	}

}
