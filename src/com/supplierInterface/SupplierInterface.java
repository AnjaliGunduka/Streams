package com.supplierInterface;

import java.util.function.Supplier;

public class SupplierInterface {
	public static void main(String[] args) {
		Supplier<Double> a=()->Math.sqrt(4);
		System.out.println(a.get());
	}
}
