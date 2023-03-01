package com.filters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Filters {

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
		Set<Student> collect13 = list.stream().filter(ele->!list2.contains(ele))
				.collect(Collectors.toSet());
		
		collect13.stream().forEach(ee->System.out.println("two lists :-"+ee));
		
		
		
		
		List<Double> collect10 = list.stream().map(e -> e.getMarks()).distinct().collect(Collectors.toList());
		collect10.stream().forEach(e -> System.out.println("marks" + e));

		/**
		 * Count the students
		 */
		long count = list.stream().count();
		System.out.println(count);
		/**
		 * filter the data based on id
		 */
		list.stream().filter(n -> n.getId() == 534)
				.forEach(n -> System.out.println("name of the students" + " " + n.getName()));

		/**
		 * filter the data based on name
		 */
		list.stream().filter(n -> n.getName() == "Anjali")
				.forEach(n -> System.out.println("marks of the students" + " " + n.getMarks()));

		/**
		 * maximum marks of students
		 * 
		 */
		Student student = list.stream().max((marks1, marks2) -> marks1.getMarks() > marks2.getMarks() ? 1 : -1).get();
		System.out.println("Maximum marks of students:-" + student.getMarks());

		/**
		 * minimum marks of students
		 */
		Student student2 = list.stream().min((marks1, marks2) -> marks1.getMarks() < marks2.getMarks() ? -1 : 1).get();
		System.out.println("Minimum marks of students:-" + student2.getMarks());
		/**
		 * To get Object from list if is present or not By using find any
		 */
		Optional<Student> filter = list.stream().filter(n -> n.getId() == 537).findAny();
		System.out.println("By using find any" + filter.isPresent());
		/**
		 * Using Find First
		 */
		Optional<Student> filter2 = list.stream().filter(n -> n.getId() == 534).findFirst();
		System.out.println("By using find First " + filter2.get().getName());
		/**
		 * 
		 */
		Comparator<Student> students = (stud1, stud2) -> stud1.getName().compareTo(stud2.getName());

		list.stream().sorted(students).collect(Collectors.toList());

		list.stream().forEach(a -> System.out.println(a.toString()));
//
//		Comparator<Student> stuCom = (studComMarks1, studComMarks2) ->
//
//		Double.compare(studComMarks1.getMarks(), studComMarks2.getMarks());
//		list.stream().sorted(stuCom).collect(Collectors.toList());
////                                                       
//		list.stream().forEach(ab -> System.out.println("student names" + ab.toString()));
//		// studComMarks1.getMarks().compare(studComMarks2.getMarks());
//		

		Comparator<Student> studCompMarks = Comparator.comparingDouble(Student::getMarks);
		List<Student> collect = list.stream().sorted(studCompMarks).collect(Collectors.toList());
		collect.stream().forEach(as -> System.out.println("double of comparator" + " " + as.toString()));

		Comparator<Student> studCompId = Comparator.comparingLong(Student::getId);
		List<Student> collect2 = collect.stream().sorted(studCompId).collect(Collectors.toList());
		collect2.stream().forEach(aId -> System.out.println(aId.toString()));

		Comparator<Student> studCompName = Comparator.comparing(Student::getName);
		List<Student> collect4 = collect2.stream().sorted(studCompName).collect(Collectors.toList());
		collect4.stream().forEach(comn -> System.out.println("student name" + comn.toString()));

		List<Student> collect3 = list.stream().sorted(studCompMarks.thenComparing(studCompId))
				.collect(Collectors.toList());
		collect3.stream().forEach(com -> System.out.println("comparing names" + com.toString()));

		List<Student> collect5 = list.stream()
				.sorted(studCompMarks.thenComparing(studCompName).thenComparing(studCompId))
				.collect(Collectors.toList());
		collect5.stream().forEach(comAll -> System.out.println("comparingAll" + " " + comAll.toString()));

		Comparator<Student> reversed = Comparator.comparing(Student::getName).reversed();

		List<Student> collect6 = list.stream().sorted(reversed).collect(Collectors.toList());
		collect6.stream().forEach(nn -> System.out.println("reversed" + nn));
		/**
		 * groupBycomaparator
		 */

//		Map<String, Integer> r=new HashMap<>();
//		r.put("anjali", 1);
//		r.put("pavan", 3);
//		r.put("mani", 6);
//		r.put("bhavani", 8);
//		
//		Map<String, Integer> result = r.entrySet()
//				.stream() .sorted(Map.Entry.comparingByKey()) 
//				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
//				(oldValue, newValue) -> oldValue, 
//				LinkedHashMap::new));
//		
//		List<String> collect11 = r.keySet().stream() .sorted() .collect(Collectors.toList());
//		collect11.stream().forEach(f->System.out.println("keys"));
//		
//		System.out.println("map values"+result.entrySet());

		Comparator<Student> groupBy = Comparator.comparing(Student::getMarks).thenComparing(Student::getId);

		List<Student> collect7 = list.stream().sorted(groupBy).collect(Collectors.toList());
		collect7.stream().forEach(ss -> System.out.println(ss));
		Collections.sort(collect7, groupBy);
		/**
		 * groupingBy
		 */
		Map<String, List<Student>> collect8 = list.stream().collect(Collectors.groupingBy(Student::getName));
		System.out.println("Returns a view of the keys contained in this map" + collect8.keySet());

		Map<Long, Map<String, List<Student>>> collect9 = list.stream()
				.collect(Collectors.groupingBy(Student::getId, Collectors.groupingBy(Student::getName)));

		System.out.println("list" + collect9);

		Arrays.asList("John", "Mark", "Robert", "Lucas", "Brandon").stream().sorted().forEach(System.out::println);

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> squaresofnum = numbers.stream().map(n -> n * n).collect(Collectors.toList());

		squaresofnum.stream().forEach(aa -> System.out.println(aa));

		Student[] array = list.toArray(new Student[list.size()]);
		Arrays.parallelSort(array, groupBy);

		System.out.println(array.toString());

		/**
		 * add two numbers
		 */

		int totalSum = numbers.stream().reduce(0, (number1, number2) -> number1 + number2);

		System.out.println("Sum of integers : " + totalSum);

		/*
		 * using map
		 */

		Double sum = list.stream().map(aaa -> aaa.getMarks()).collect(Collectors.summingDouble(Double::doubleValue));
		System.out.println(sum);

		Map<String, Integer> r = new HashMap<>();
		r.put("anjali", 1);
		r.put("pavan", 3);
		r.put("mani", 6);
		r.put("bhavani", 8);

		Map<String, Integer> result = r.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors
				.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println("map values" + result.entrySet());

		List<String> collect11 = r.keySet().stream().sorted().collect(Collectors.toList());
		collect11.stream().forEach(f -> System.out.println("keys :-" + f));

		List<Integer> collect12 = r.values().stream().sorted().collect(Collectors.toList());
		collect12.stream().forEach(f -> System.out.println("Values :-" + f));
		
		
		
		
		
		
		
		
		
		

	}
}
