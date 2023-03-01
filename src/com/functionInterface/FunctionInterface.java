package com.functionInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import SalaryCalculation.Employee;

public class FunctionInterface {
	public static void main(String[] args) {
		/**
		 * apply method
		 */
		Function<Integer, Double> half = a -> a / 2.0;
		System.out.println("apply method "+half.apply(10));
		/**
		 * andThen
		 */
		half = half.andThen(a -> a + 3);
		System.out.println("andThen "+half.apply(10));
		/**
		 * andThen nullPointer
		 */
		try {
		half=half.andThen(null);
		}
		catch(Exception e)
		{
			System.out.println("exception");
		}
		/**
		 * compose
		 */
		half=half.compose(a -> a + 3);
		System.out.println("compose "+half.apply(10));
		/**
		 * identify
		 */
		
		Function<Integer,Integer> aas=Function.identity();
		System.out.println(aas.apply(1));
		
		
		/**
		 * squareroot
		 */
		Function<Integer, Double> aa = (input) -> { 
			return Math.sqrt(input);
		};

		int input = 6;
		System.out.println("Square Root of " + input + " is " + aa.apply(input));


	}
}
