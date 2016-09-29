package com;

/**
 * 
 */

/**
 * @author Owner
 *
 */
public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestClass t = new TestClass();
		System.out.println(t.getReturn());
		//A a = A.s
	}

	
	@SuppressWarnings("finally")
	public String getReturn(){
		try{
			
			return "Sundeep";
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			return "Chnage";
		}
	}

}
