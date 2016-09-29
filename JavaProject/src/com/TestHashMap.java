package com;

import java.util.HashMap;

/**
 * @author Zenith
 *
 */
class  TestHashMap
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		HashMap<String,String> hMap= new HashMap<>();
		hMap.put("KEY1", "VALUE1");
		hMap.put("KEY2", "VALUE2");
		hMap.put("KEY3", "VALUE3");
		hMap.put("KEY4", "VALUE4");
		
		System.out.println("HashMap :"+hMap);
	}
}
