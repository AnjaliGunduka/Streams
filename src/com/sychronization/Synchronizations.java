package com.sychronization;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class Synchronizations {

	public static void main(String[] args) {

		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		
		int i1=sc.nextInt();
		
		
		
		Consumer<Integer> aa=a->System.out.println(a+2);
		aa.accept(1);

		
		
		
		Function<Integer, Double> a = (i) -> {
			return Math.sqrt(i);
		};
		//int i = 6;
		System.out.println(a.apply(i1));
	}

}
