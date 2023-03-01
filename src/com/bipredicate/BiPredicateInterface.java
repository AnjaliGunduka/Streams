package com.bipredicate;

import java.util.ArrayList;
import java.util.List;

import SalaryCalculation.Employee;

@FunctionalInterface
interface BiPredicate<T, U> {
	boolean test(T t, U u);
}

public class BiPredicateInterface {
	public static void main(String[] args) {

		BiPredicate<String, Integer> filter = (x, y) -> {
			return x.length() == y;
		};

		boolean ab = filter.test("he", 2);
		System.out.println(ab);

	}
}
