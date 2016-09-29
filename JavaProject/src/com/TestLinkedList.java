package com;

import java.util.LinkedList;

/**
 * @author Zenith
 * best for remove and add operation 
 */
public class TestLinkedList
{
	public static void main(String[] args) 
	{
		LinkedList<Object> linkList=new LinkedList<>();
		linkList.add(10);
		linkList.add("11");
		linkList.addFirst('F');
		linkList.addLast('L');
		System.out.println(linkList);
		linkList.remove(1);
		System.out.println(linkList);
		linkList.removeFirst();
		System.out.println(linkList);
		
	}
}
