package com.evenNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EvenNumber {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(2);

		List<Integer> collect = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(collect);
	}
}
