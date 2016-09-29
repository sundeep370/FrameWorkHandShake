package com;

import java.util.HashMap;

/**
 * 
 */

/**
 * @author Zenith
 *
 */
public class TestStringClass {

	public static TestStringClass testStringClass;
	
	public static synchronized  TestStringClass getInstance(){
		if(null == testStringClass){
			System.out.println("Initialized");
			testStringClass = new TestStringClass();
		}
		return testStringClass;
	}
			
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestStringClass stringClass = TestStringClass.getInstance();
		stringClass.getHashCode();
		

		TestStringClass str = new TestStringClass();
		str.reverseStr();
		
	}
	
	public void getHashCode(){
		String s1 = "My1";
		String s2 = "Name";
		String s3 = s1+s2;
		String s4 = "My1";
		String s5 = new String("My1");
		System.out.println(s1+s2+s3);
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		System.out.println(s5.hashCode());
		
		if(s1== s4){
			System.out.println("value");
		}
		
		if(s1.equals( s4)){
			System.out.println("value 2");
		}
		
		HashMap<String,Object> hp = new HashMap<>();
		hp.put("Key", "args");
		System.out.println(hp.hashCode());
		hp.put("Key", "args");
		System.out.println(hp.hashCode());
		hp.put("Key", "args");
		System.out.println(hp.hashCode());
		System.out.println(hp.size());
		
	}
	
	public void reverseStr(){
		
		StringBuffer sb = new StringBuffer();
		String str = "ZENITH SERVICES";
		sb.append(str);
		System.out.println(sb.reverse());
		
		str = "ZENITH SERVICES";
		sb = new StringBuffer();
		for (int i=str.length()-1;i>=0;i--)
		{
			sb.append( str.charAt(i));
		}
		System.out.println(sb);
	}

}
