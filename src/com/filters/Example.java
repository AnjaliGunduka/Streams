package com.filters;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Example {
	public static void main(String[] args) {
		Student s = new Student(534, "Anjali", 30000);
		Student s1 = new Student(531, "Neha", 50000);
		Student s2 = new Student(513, "Lalitha", 60000);
		Student s3 = new Student(531, "Nirosha", 80000);
		Student s5 = new Student(510, "Preethi", 50000);
		List<Student> list = new ArrayList<Student>();
		list.add(s);
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s5);
		List<Student> list2 = new ArrayList<Student>();
		Student lists1 = new Student(534, "Anjali", 30000,"anjali@gmail.com");
		Student lists2 = new Student(531, "Neha", 50000,"neha@gmail.com");
		list2.add(lists1);
		list2.add(lists2);
		List<Student> collect13 = list.stream()
				.filter(ele->!list2.contains(ele))
				.collect(Collectors.toList());
		
		collect13.stream().forEach(ee->System.out.println("two lists "+ee));
		
		
		
		Predicate<? super Student> notIn2 = ss -> list2.stream().anyMatch(mc -> ss
				.equals(mc.getName()));
		List<Student> list3 = list.stream().filter(notIn2).collect(Collectors.toList());
		list3.stream().forEach(ee->System.out.println("two lists :-"+ee));

	}
}
