package com;

/**
 * @author Zenith
 *
 */
import java.util.*;

public class TestStack 
{
	public static void main(String[] args) 
	{
		Stack<Object> sLifo=new Stack<Object>();
		sLifo.push(10);
		sLifo.push("22");
		sLifo.push('a');
		sLifo.add(11);
		System.out.println("sLifo :"+sLifo);
		sLifo.pop();
		System.out.println("Pop sLifo:"+sLifo);
		System.out.println("Object 22:"+sLifo.search("22"));
		sLifo.pop();
		System.out.println("Pop sLifo:"+sLifo);
		
		for (Object object : sLifo) {
			System.out.println("LIFO:"+object);
		}
	}
}
