package SalaryCalculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class groupingBy {
	public static void main(String[] args) {
		Employee s = new Employee(1, 2000, "Anjali", 11);
		Employee s1 = new Employee(2, 1000, "Neha", 22);
		Employee s2 = new Employee(3, 3000, "Lalitha", 33);
		Employee s3 = new Employee(4, 5000, "Kalpana", 55);
		List<Employee> list = new ArrayList<>();
		list.add(s);
		list.add(s1);
		list.add(s2);
		list.add(s3);
		/**
		 *         * min and max sal         
		 */
		Employee employee = list.stream().min((ss, sss) -> ss.getName()
				.compareTo(sss.getName())).get();
		System.out.println("min salary:" + employee);

		Comparator<Employee> comparing = Comparator.comparing(Employee::getSalary);
		Employee employee2 = list.stream().max(comparing).get();
		System.out.println("max sal:" + employee2);

		/**
		 * calculating employee salary will get total emp salary
		 */
		double c = list.stream().collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println("calculating employee salary will get total emp salary:" + c);
		/**
		 * Calculate the Salary by Name:
		 */
		double d = list.stream().filter(n -> n.getName() == "Anjali")
				.collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println("Calculate the Salary by Name:" + d);

		/**
		 * Calculate emp salary upto limt emps who are greater than 1 can be printed so
		 * here i kept limit is upto 1 only 1 emp details will be printed
		 */
		List<Employee> clct = list.stream().filter(n -> n.getSalary() >= 1)
				.limit(1).collect(Collectors.toList());
		clct.stream().forEach(n -> System.out.println("only 1 emp details will be printed:" + n));

		/**
		 * groupBy
		 */
		Map<String, List<Employee>> m = list.stream().collect(Collectors.groupingBy(Employee::getName));
		System.out.println("grouping the empnames:" + m);
		/**
		 * 
		 * groupby using mapping to group name and depId
		 */
		Map<String, List<Integer>> m1 = list.stream().collect(Collectors.groupingBy
				(emp -> emp.getName(),
				Collectors.mapping(Employee::getDeptId, Collectors.toList())));
		System.out.println("groupby using mapping to group name and depId:" + m1);

		/**
		 * Name of employess" + " " + aa + "\"Salary of employess\""
		 */
		Map<String, Integer> m2 = list.stream().collect(Collectors.toMap
				(Employee::getName, Employee::getSalary));
		m2.forEach(
				(aa, ab) -> System.out.println("Name of employess" + " " + aa + " " + "\"Salary of employess\"" + ab));

		/**
		 * findAny
		 */
		Employee anyOne = list.stream().filter(n -> "Kalpana".equals(n.getName())).findAny().orElse(null);
		System.out.println("find any one:" + anyOne);

		List<Employee> m3 = list.stream().filter(n -> n.getName() == "Kalpana")
				.distinct().collect(Collectors.toList());
		m3.stream().forEach(System.out::println);

		List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

		/*
		 * both list contains same elements
		 */

		List<Integer> finallist = list1.stream().filter(item -> 
		!list2.contains(item)).collect(Collectors.toList());
		System.out.println(finallist);

		/**
		 * groupingby set
		 */
		Map<Integer, Set<Employee>> m4 = list.stream()
				.collect(Collectors.groupingBy(emp -> emp.getDeptId(), Collectors.toSet()));
		System.out.println(m4);

		/**
		 * if we want to print only salry of the emp above 1
		 */

		List<Employee> m5 = list.stream().filter(n -> n.getSalary() > 2000).collect(Collectors.toList());
		m5.stream().forEach(System.out::println);

		/**
		 * MapTo using different scenariao
		 */
		Map<Integer, Integer> m6 = list.stream()
				.collect(Collectors.toMap(Employee::getId, Employee::getSalary, (oldvalue, newvalue) -> newvalue));
		System.out.println("MapTo using different scenariao:" + m6);

		/**
		 * remove duplicate employyes
		 */
		List<Employee> m7 = list.stream().distinct().collect(Collectors.toList());
		System.out.println("distinct employees:" + m7);

		/**
		 * list of employess incremented by 100
		 */

		List<Employee> newList = list.stream().map(e -> {
			e.setSalary(e.getSalary() + 100);
			return e;
		}).collect(Collectors.toList());
		System.out.println("Employees salary incremented by 100" + newList);

		/**
		 * Search elements based on letters
		 */
		List<Employee> m8 = list.stream().filter(n -> n.getName().startsWith("K")).collect(Collectors.toList());
		m8.stream().forEach(System.out::println);

		/**
		 * remove duplicates
		 */
		long orElseThrow = list.stream().mapToLong(Employee::getId).max().orElseThrow(NoSuchElementException::new);
		System.out.println(orElseThrow);
		//
		Double percentage = 10.0;
		Double salIncrOverhead = list.stream()
				.collect(Collectors.reducing(0.0, e -> e.getSalary() * percentage / 100,
						(x, y) -> x + y));
		System.out.println(salIncrOverhead);

		//
		List<Integer> lists = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> collects = lists.stream().filter(x -> x > 5).collect(Collectors.toList());
		System.out.println(collects);

		//
		Predicate<String> lengthIs3 = x -> x.length() == 3;
		Predicate<? super Employee> startWithA = aa -> aa.getName().startsWith("A");
		Predicate<? super String> startWithK = aa -> aa.startsWith("K");

		list.stream().filter(startWithA).forEach(aa -> System.out.println("Should starts withA" + aa));
		list.stream().forEachOrdered(aa -> System.out.println(" starts withA" + aa));

		List<String> listss = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBBShould");

		List<String> g=listss.stream().filter(lengthIs3.or(startWithK)).collect(Collectors.toList());
		System.out.println(g);
		
		Map<Integer, List<Employee>> byDept = list.stream()
				.collect(Collectors.groupingBy(Employee::getDeptId));
		System.out.println("employees details by dept id:"+byDept);
		
		byDept.forEach((k,v)->System.out.println("DeptId:"+k+" "+((List<Employee>) v)
				.stream().map(nm->nm.getName())
				.collect(Collectors.joining(""))));
	
	}
}
