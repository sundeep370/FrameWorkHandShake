package com;

/**
 * 
 */

/**
 * @author Sundeep
 *
 */
public class ThreadsClass implements Runnable{

	public String zipCode = "12345 05836";
	
	class Zipcode{
		String areaCode = "12345";
		String citiCode = "05836";
		
	}
	/**
	 * 
	 */
	
	/**
	 * @param args
	 */
	
	public String str ="str", str1 = "str1";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ThreadsClass class1 = new ThreadsClass("MyTread");
		class1.start();class1.run();*/
		Thread thread = new Thread(new ThreadsClass(),"myRunnable");
		//thread.start();
		thread.run();
		System.out.println("END of MAIN");

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(":"+Thread.currentThread().getName());
	}

}
