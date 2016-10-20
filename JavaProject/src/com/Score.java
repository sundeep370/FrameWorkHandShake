/**
 * 
 */
package com;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Owner
 *
 */
public  class Score {

	
//	public HashMap<String,String> scoreMap = null;
	public final String str = "OM";
	public final ArrayList<Object> list = new ArrayList<>();
	public void getScore(){
		HashMap<String,String>  scoreMap = new HashMap<>();
		scoreMap.put(null, "dee");
		for (String iterable_element : scoreMap.keySet()) {
			
			//System.out.println(iterable_element.hashCode());
		}
		System.out.println(scoreMap.keySet());
//		str = "DEMo";
		list.add("OM");
		list.add("OM2");
		System.out.println(""+list);
	}
	
	public static void main (String[] args){
		
		Score s = new Score();
		s.getScore();
	}
	
}
