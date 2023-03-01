package com.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateInterface {
	public static void main(String[] args) {
		/**
		 * collect elements which can have both length 3 or Starts with A
		 */
		Predicate<String> a = x -> x.length() >= 3;
		Predicate<String> b = x -> x.startsWith("A");

		List<String> list = Arrays.asList("Anjali", "nju");

		List<String> collect = list.stream().filter(a.and(b)).collect(Collectors.toList());
		System.out.println(collect);

		/**
		 * example 2
		 */
		Predicate<String> startWithA = x -> x.startsWith("A");
		/**
		 * start with "a" or "m"
		 */

		boolean result = startWithA.or(x -> x.startsWith("m")).test("mkyong");
		System.out.println(result); // true
		/**
		 * !(start with "a" and length is 3)
		 */

		boolean result2 = startWithA.and(x -> x.length() == 3).negate().test("abc");
		System.out.println(result2);
		/**
		 * Find all elements not start with ‘A’.
		 */

		List<String> collect2 = list.stream().filter(startWithA.negate())
				.collect(Collectors.toList());
		collect2.stream().forEach(as -> System.out.println("list of names doesnt starts with A letter" + as));

	}
}
