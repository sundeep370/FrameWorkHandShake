package com;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Zenith
 * 
 */
class TestHashMap {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestHashMap map = new TestHashMap();
		map.getHashMap();
		map.getLinkedHashMap();
		map.getTreeMap();
		map.getConcurrentHashMap();
		map.getIdentityHashMap();
	}

	
	public void getHashMap(){
		HashMap<String,String> hMap= new HashMap<>();
		hMap.put("KEY1", "VALUE1");
		hMap.put("KEY2", "VALUE2");
		hMap.put("KEY3", "VALUE3");
		hMap.put("KEY4", "VALUE4");
		System.out.println("HashMap :"+hMap+","+hMap.hashCode());
		
		hMap.put("KEY2", "VALUE1");
		System.out.println("HashMap :"+hMap+","+hMap.hashCode());
		hMap.put("KEY2", "VALUE2");
		System.out.println("HashMap :"+hMap+","+hMap.hashCode());
	}
	
	
	public void getLinkedHashMap(){
		LinkedHashMap<String,String> hMap= new LinkedHashMap<>();
		hMap.put("KEY1", "VALUE1");
		hMap.put("KEY2", "VALUE2");
		hMap.put("KEY3", "VALUE3");
		hMap.put("KEY4", "VALUE4");
		System.out.println("LinkedHashMap :"+hMap+","+hMap.hashCode());
		
		hMap.put("KEY2", "VALUE1");
		System.out.println("LinkedHashMap :"+hMap+","+hMap.hashCode());
		hMap.put("KEY2", "VALUE2");
		System.out.println("LinkedHashMap :"+hMap+","+hMap.hashCode());
	}
	
	public void getTreeMap(){
		TreeMap<String,String> hMap= new TreeMap<>();
		hMap.put("KEY1", "VALUE1");
		hMap.put("KEY2", "VALUE2");
		hMap.put("KEY3", "VALUE3");
		hMap.put("KEY4", "VALUE4");
		System.out.println("TreeMap :"+hMap+","+hMap.hashCode());
		
		hMap.put("KEY2", "VALUE1");
		System.out.println("TreeMap :"+hMap+","+hMap.hashCode());
		hMap.put("KEY2", "VALUE2");
		System.out.println("TreeMap :"+hMap+","+hMap.hashCode());
		
		TreeMap<String,String> hMap1= new TreeMap<>();
		hMap1.put("KEY2", "VALUE1");
		hMap1.put("KEY8", "VALUE2");
		hMap1.put("KEY5", "VALUE1");
		hMap1.put("KEY1", "VALUE1");
		System.out.println("TreeMap :"+hMap1.comparator());
	}
	
	public void getConcurrentHashMap(){
		ConcurrentHashMap<String,String> hMap= new ConcurrentHashMap<>();
		hMap.put("KEY1", "VALUE1");
		hMap.put("KEY2", "VALUE2");
		hMap.put("KEY3", "VALUE3");
		hMap.put("KEY4", "VALUE4");
		System.out.println("ConcurrentHashMap :"+hMap+","+hMap.hashCode());
		
		hMap.put("KEY2", "VALUE1");
		System.out.println("ConcurrentHashMap :"+hMap+","+hMap.hashCode());
		hMap.put("KeY2", "VALUE2");
		System.out.println("ConcurrentHashMap :"+hMap+","+hMap.hashCode());
	}
	
	public void getIdentityHashMap(){
		
		IdentityHashMap<String, String> iMap = new IdentityHashMap<>();
		iMap.put("Key", "Val1");
		iMap.put("KEy", "Val2");
		
		System.out.println(iMap);
	}
	
}
