package com.functionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import SalaryCalculation.Employee;

@FunctionalInterface
interface A {
	// void evenum();
	abstract void sum(int a, int b);
}

public class FunctionalInterfaces {
	public static void main(String[] args) {

		A aa = (a, b) -> {
			System.out.println(a + b);
		};
		aa.sum(1, 2);

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

	}
}
