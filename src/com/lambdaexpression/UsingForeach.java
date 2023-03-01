package com.lambdaexpression;

import java.net.InterfaceAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class UsingForeach {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		/**
		 * Lambda expressions are usually passed as parameters to a function
		 */
		list.forEach((n) -> {
			System.out.println(n);
		});
		list.forEach(n -> {
			System.out.println(list);
		});
		/**
		 * Consumer interface to store a lambda expression in a variable
		 */
		Consumer<Integer> method = (n) -> System.out.println(n);
		list.forEach(method);
		/**
		 * Create a method which takes a lambda expression as a parameter:
		 */
		example e = (a) -> a + "!";
		methods("hey", e);
		/*
		 * Iterator
		 */

	}

	public static void methods(String str, example exa) {
		String method = exa.method(str);
		System.out.println(method);
	}

	interface example {
		String method(String str);
	}

}
