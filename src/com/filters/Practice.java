package com.filters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Practice {
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

		Comparator<Student> stu = (stud1, stud2) -> stud1.getName().compareTo(stud2.getName());
		List<Student> collect = list.stream().sorted(stu).collect(Collectors.toList());
		collect.forEach(a -> System.out.println(a.toString()));

		Comparator<Student> stuM = Comparator.comparingDouble(Student::getMarks);
		List<Student> collect2 = collect.stream().sorted(stuM).collect(Collectors.toList());
		collect2.stream().forEach(ab -> System.out.println("stuM" + ab.toString()));

		List<Student> collect3 = list.stream().sorted(stuM.thenComparing(stu)).collect(Collectors.toList());
		collect3.stream().forEach(ass -> System.out.println("collect3" + ass));

		list.stream().filter(n -> n.getMarks() == 30000).forEach(n -> System.out.println("filter" + " " + n));

		Comparator<Student> reversed = Comparator.comparing(Student::getName).reversed();
		List<Student> collect4 = list.stream().sorted(reversed).collect(Collectors.toList());
		collect4.stream().forEach(nnn -> System.out.println("reveresd names" + " " + nnn));
		
		List<Integer> ass=Arrays.asList(1,2);
		Integer reduce = ass.stream().reduce(0,(a1,b)->a1+b);
		System.out.println("sums "+reduce);
		
		/**
		 * 
		 */
		int sum = ass.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum);
		

		
		
		
	}
}
