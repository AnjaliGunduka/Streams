package com.Iterator;

import java.util.ArrayList;
import java.util.List;

public class Iterator {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(2);
		java.util.Iterator<Integer> i = list.iterator();
		while (i.hasNext()) {
			Integer it = i.next();
			if (it == 3) {
				// it will remove below number
				i.remove();
				i.next();
			}
		}
		System.out.println(list);
		
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
	
		for (Integer i1 : list) {
			System.out.println("loop pf the data is:" + i1);
		}
		
	}
	
	
}
