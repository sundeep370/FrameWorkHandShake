package com;

import java.math.BigDecimal;

/**
 * 
 */

/**
 * @author Owner
 * 
 */
public class TestClass {

	static {
		String s = null;
		System.out.println("static block called:" + s);
		TestClass t = new TestClass(s.lastIndexOf(1));
	}

	TestClass() {
		System.out.println("init");
	}

	TestClass(int i) {
		System.out.println("init");
	}

	TestClass(Object i) {
		System.out.println("init");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestClass t = new TestClass();
		System.out.println(t.getReturn(null));
		// A a = A.s
	}

	public BigDecimal getReturn(BigDecimal dec) {
		try {
	
		}catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		finally {
			// return dec;
		}
		return dec;
	}

}
