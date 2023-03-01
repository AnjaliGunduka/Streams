package com.methodReferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class MethodReferences {
	public static void main(String[] args) {
		System.out.println("Sum of numbers by normal operation : ");
		MathOperation op = new MathOperation(10, 20);

		/**
		 * static methods
		 */

		// reference to static method
		System.out.println("Refering a static Method : ");
		List<Integer> numbers = Arrays.asList(20, 15);
		numbers.stream().map(MathOperation::isEven).forEach(System.out::println);

		// reference to an an Instance Method of a Particular Object
		System.out.println("Reference to instance Method : ");
		BiFunction<Integer, Integer, Integer> add2 = op::add;
		System.out.println("Addtion = " + add2.apply(4, 5));

		// reference to an an Instance Method of a Particular //Object
		BiFunction<Integer, Integer, Integer> sub2 = op::sub;
		System.out.println("Subtraction = " + sub2.apply(58, 5));

		// Reference to a Constructor
		System.out.println("Refering a constructor : ");
		BiConsumer<Integer, Integer> addtion2 = MathOperation::new;
		addtion2.accept(10, 30);

		// Reference to an Instance Method of an Arbitrary Object of //a Particular Type
		List<String> weeks = new ArrayList<String>();
		weeks.add("Monday");
		weeks.add("Tuesday");
		weeks.add("Wednesday");
		weeks.add("Thursday");
		weeks.add("Friday");
		weeks.add("Saturday");
		weeks.add("Sunday");

		System.out.println("Refering a Arbitrary Object of a Particular Type : ");
		weeks.stream().map(String::toUpperCase).forEach(System.out::println);

	}
}

class MathOperation {

	// constructor operation
	public MathOperation(int a, int b) {
		System.out.println("Sum of " + a + " and " + b + " is " + (a + b));
	}

	// is Even or odd
	public static boolean isEven(int n) {
		return n % 2 == 0;
	}

	// Addition
	public int add(int a, int b) {
		return a + b;
	}

	// Subtraction
	public int sub(int a, int b) {
		return a - b;
	}

}