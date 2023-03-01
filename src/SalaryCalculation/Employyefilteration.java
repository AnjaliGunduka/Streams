package SalaryCalculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Employyefilteration {

	public static void main(String[] args) {

		Employee s = new Employee(1, 1000, "Anjali", 1);
		Employee s1 = new Employee(2, 2000, "Neha", 1);
		Employee s2 = new Employee(3, 3000, "Lalitha", 1);

		List<Employee> list = new ArrayList<>();
		list.add(s);
		list.add(s1);
		list.add(s2);
		/**
		 * min and max sal
		 */

		Employee employee = list.stream().min((ss, sss) ->
		ss.getName().compareTo(sss.getName())).get();
		System.out.println(employee);

		Comparator<Employee> comparing = Comparator.comparing(Employee::getDeptId);
		Employee employee2 = list.stream().max(comparing).get();
		System.out.println("deptid :-"+employee2);

		/**
		 * calculating employee salary will get total emp salary
		 */

		int c = list.stream().collect(Collectors.summingInt(Employee::getSalary));
		System.out.println("Total salary of employess " + c);

		/**
		 * Calculate the Salary by Name:
		 */

		Integer collect = list.stream().filter(n -> n.getName() == "Neha")
				.collect(Collectors.summingInt(Employee::getSalary));
		System.out.println("Calculate the Salary by Name" + collect);
		/**
		 * Calculate emp salary upto limt emps who are greater than 1 can be printed so
		 * here i kept limit is upto 1 only 1 emp details will be printed
		 */

		List<Employee> collect4 = list.stream().filter(n -> n.getSalary() >= 1).limit(1).collect(Collectors.toList());
		collect4.stream().forEach(n -> System.out.println("keeping emps limit" + n));
		/**
		 * groupBy
		 */

		Map<String, List<Employee>> collect3 = list.stream().collect(Collectors
				.groupingBy(Employee::getName));
		System.out.println("grouping the empnames" + collect3);

		/**
		 * 
		 * groupby using mapping to group name and depId
		 */

		Map<String, List<Integer>> ssss = list.stream().collect(Collectors.groupingBy
				(emp -> emp.getName(),
				Collectors.mapping(Employee::getDeptId, Collectors.toList())));
		System.out.println("maaping of list" + ssss);

		Map<String, Integer> collect5 = list.stream().collect(Collectors.toMap
				(Employee::getName, Employee::getSalary));
		collect5.forEach(
				(aa, ab) -> System.out.println("Name of employess" + " " + aa + "\"Salary of employess\"" + ab));

		// System.out.println(collect5);

		/**
		 * Here we will get employess names and their salary
		 * 
		 */
//		Map<String, Integer> aaaaa = list.stream().collect(Collectors.groupingBy(
//				st -> st.getName(),
//				Hashtable::new, Collectors.mapping(Employee::getSalary, Collectors.toList())));
//		System.out.println("hashtable " + aaaaa);
		/**
		 * findAny
		 */
		Employee orElse = list.stream().filter(n -> "Anjali".equals(n.getName())).findAny().orElse(null);
		System.out.println(orElse);
		/**
		 */

		List<Employee> collect2 = list.stream().filter(nn -> nn.getName() == "Anjali").distinct()
				.collect(Collectors.toList());
		collect2.stream().forEach(nn -> System.out.println("lists" + nn));

		List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3));
		/**
		 * both list contains same elemmnts
		 */
		List<Integer> finalList = list1.stream().filter(item -> !list2.contains(item)).collect(Collectors.toList());

		System.out.println(finalList);

		/**
		 * groubu=y set
		 */

		Map<String, Set<Employee>> ss = list.stream()
				.collect(Collectors.groupingBy(emp -> emp.getName(), Collectors.toSet()));

		System.out.println(ss);
		/**
		 * if we want to print only salry of the emp above 1
		 */
		List<Employee> collect6 = list.stream().filter(n -> n.getSalary() >= 1)// .collect(Collectors.toList());
				// .map(n->n.getSalary())
				.collect(Collectors.toList());
		collect6.stream().forEach(n -> System.out.println("sal of emp" + n));
		/**
		 * MapTo using different scenariao
		 */
		Map<Integer, Integer> res = list.stream()
				.collect(Collectors.toMap(Employee::getId, Employee::getSalary, (oldValue, newValue) -> oldValue));
		System.out.println("Result : " + res);
		/**
		 * remove duplicate employyes
		 */

		List<Employee> collect7 = list.stream().distinct().collect(Collectors.toList());
		System.out.println(collect7);

		/**
		 * list of employess incremented by 100
		 */

		List<Employee> newList = list.stream().map(e -> {
			e.setSalary(e.getSalary() + 100);
			return e;
		}).collect(Collectors.toList());

		// Employees salary incremented by 100
		System.out.println("Employees salary incremented by 100" + newList);
		/**
		 * Search elements based on letters
		 */
		List<Employee> filter = list.stream().distinct().filter(x
				-> x.getName().startsWith("A"))
				.collect(Collectors.toList());
		System.out.println("A letter" + filter.toString());
		/**
		 * remove duplicates
		 */
		//list.stream().collect(Collectors.toCollection()->new TreeSet)
		
		int orElseThrow = list.stream()
	      .mapToInt(Employee::getId)
	      .max()
	      .orElseThrow(NoSuchElementException::new);
		System.out.println("orElseThrow"+orElseThrow);
		
		
		 Double percentage = 10.0;
		    Double salIncrOverhead = list.stream().collect(Collectors.reducing(
		        0.0, e -> e.getSalary() * percentage / 100, (ssssss, sssss) -> ssssss + sssss));
	System.out.println("salIncrOverhead"+salIncrOverhead);
	
	
	List<Integer> lists = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    List<Integer> collects = lists.stream().filter(x -> x > 5).collect(Collectors.toList());

    System.out.println(collects);
	
    Predicate<String> lengthIs3 = x -> x.length() == 3;
    Predicate<String> startWithA = x -> x.startsWith("A");

    List<String> listss = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");

    List<String> collectss = listss.stream()
            .filter(lengthIs3.or(startWithA))
            .collect(Collectors.toList());

    System.out.println(collectss);
		/**
		 * group by different scenerio
		 */
		Map<Integer, List<Employee>> byDept = list.stream()
				.collect(Collectors.groupingBy(Employee::getDeptId));

		byDept.forEach((k, v) -> System.out.println("DeptId:" + k + "   "
				+ ((List<Employee>) v).stream().map(m -> m.getName())
				.collect(Collectors.joining(","))));

	}

}
