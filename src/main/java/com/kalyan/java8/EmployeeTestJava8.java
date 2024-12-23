package com.kalyan.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeTestJava8 {

//	Here’s a list of questions for the Stream API using the provided Employee collection:
//
//		Find all employees who are Java Developers.
//		Retrieve the names of all employees.
//		Get the total salary of all employees.
//		Count the number of employees in Hyderabad.
//		Check if all employees earn more than 60,000.
//		Find the employee with the lowest salary.
//		Group employees by their city.
//		Partition employees into two groups: those earning more than 75,000 and those earning less.
//		Get the names of employees sorted by their salary in descending order.
//		Find distinct designations of employees.
//		Find the average salary of all employees.
//		Get the top 2 highest-earning employees.
//		Join all employee names into a single comma-separated string.
//		Calculate the total salary of employees grouped by their designation.
//		Find the second-highest salary among employees.
//		Check if any employee is from Warangal.
//		Find the total number of employees for each designation.
//		List the employees in ascending order of their names.
//		Find the employee with the maximum ID.
//		Create a map of employee IDs and their names.

	public static void main(String[] args) {

		// create the employee objects

		List<Employee> listOfEmployees = Arrays.asList(

				new Employee(12345, "Kalyan", "Java Developer", 75000, "Hyderabad"),
				new Employee(12347, "Vedhansh", ".Net Developer", 65000, "Hyderabad"),
				new Employee(12346, "Venkatesh", ".Net Developer", 85000, "Warangal"),
				new Employee(12348, "Amadaiah", "Java Developer", 95000, "Hyderabad"),
				new Employee(12349, "Madhu", "Java Developer", 17000, "Warangal"),
				new Employee(12350, "Sanjay", "Python Developer", 78000, "Bangalore"),
				new Employee(12351, "Rajesh", "Data Analyst", 82000, "Chennai"),
				new Employee(12352, "Bhavana", "Project Manager", 120000, "Hyderabad"),
				new Employee(12353, "Sneha", "Frontend Developer", 68000, "Pune"),
				new Employee(12354, "Suresh", "QA Engineer", 55000, "Mumbai"),
				new Employee(12355, "Ravi", "DevOps Engineer", 90000, "Bangalore"),
				new Employee(12356, "Priya", "Business Analyst", 72000, "Chennai"),
				new Employee(12357, "Divya", "HR Manager", 95000, "Hyderabad"),
				new Employee(12358, "Vikram", "System Administrator", 60000, "Warangal"),
				new Employee(12359, "Anjali", "Scrum Master", 105000, "Bangalore")

		);

		// 1. convert the list Of Employees to set of Employees
		listOfEmployees.stream().collect(Collectors.toSet()).forEach(System.out::println);
		System.out.println("====================================");

		// 2. Print the employee who is having the highest salary
		System.out.println(":: Employee With Highest Salary:: ");

		Optional<Employee> max = listOfEmployees.stream().max(Comparator.comparingInt(Employee::getEmpsalary));

		System.out.println(max.isPresent() ? max.get() : null);
		System.out.println("====================================");
		// 3. Print the employee who is having minimum salary
		System.out.println(":: Print the employee who is having minimum salary ::  ");

		Employee lowestSalaryEmployee = listOfEmployees.stream().min(Comparator.comparingInt(Employee::getEmpsalary))
				.get();
		System.out.println(lowestSalaryEmployee);
		System.out.println("====================================");
		// 4. Group the employees based on the address
		System.out.println("Group the employees based on the address");

		listOfEmployees.stream().collect(Collectors.groupingBy(Employee::getEmpaddress)).entrySet()
				.forEach(System.out::println);
		System.out.println("====================================");

		// 5. List of the employees who are living in the Hyderabad city
		System.out.println("List of the employees who are living in the Hyderabad city");

		List<Employee> employeeFromHyderabad = listOfEmployees.stream()
				.filter(e -> e.getEmpaddress().equals("Hyderabad")).collect(Collectors.toList());
		System.out.println(employeeFromHyderabad);
		System.out.println("====================================");

		// 6. Find the average salary of the employee
		System.out.println("Find the average salary of the employee::");

		Integer averageSalaryOfEmployee = listOfEmployees.stream()
				.collect(Collectors.averagingInt(Employee::getEmpsalary)).intValue();
		System.out.println(averageSalaryOfEmployee);
		System.out.println("====================================");

		// 7. Employee with having second max salary
		System.out.println("Employee with having second minimum salary:::");
		Employee secondMinEmp = listOfEmployees.stream().sorted(Comparator.comparing(Employee::getEmpsalary)).skip(1)
				.limit(1).findAny().get();
		System.out.println(secondMinEmp);
		System.out.println("======================================");

		// 8. Employee with Second Minimum Salary
		System.out.println("Employee with Second Maximum Salary ::: ");

		Employee secondMaxEmployee = listOfEmployees.stream()
				.sorted(Comparator.comparing(Employee::getEmpsalary).reversed()).skip(1).limit(1).findAny().get();
		System.out.println(secondMaxEmployee);
		System.out.println("=======================================");

		// 9.Retrieve the names of all employees
		System.out.println("Retrieve the names of all employees::");
		listOfEmployees.stream().map(Employee::getEmpname).toList().forEach(System.out::println);
		System.out.println("=======================================");

		// 10. Get the total salary of all employees.

		System.out.println("Get the total salary of all employees ::");
		double sum = listOfEmployees.stream().mapToInt(Employee::getEmpsalary).sum();
		System.out.println((int) sum);
		System.out.println("=======================================");

		// 11. Count the number of employees in Hyderabad
		System.out.println("Count the number of employees in Hyderabad");
		Long countNoOfEmployeesInHyderabad = listOfEmployees.stream().filter(e -> e.getEmpaddress().equals("Hyderabad"))
				.collect(Collectors.counting());
		System.out.println(countNoOfEmployeesInHyderabad);
		System.out.println("=======================================");

		// 12.Check if all employees earn more than 60,000
		System.out.println("Check if all employees earn more than 60,000");
		List<Employee> empMoreThan60K = listOfEmployees.stream().filter(e -> e.getEmpsalary() > 60000)
				.collect(Collectors.toList());
		System.out.println(empMoreThan60K);
		System.out.println("=======================================");

		// 13. Find distinct designations of employees
		System.out.println("Find distinct designations of employees");
		List<String> distinctDesignationOfEmployees = listOfEmployees.stream().map(emp -> emp.getDesignation())
				.distinct().collect(Collectors.toList());
		System.out.println(distinctDesignationOfEmployees);
		System.out.println("=======================================");

		// 14. Create a map of employee IDs and their names.
		System.out.println("Create a map of employee IDs and their names ::");
		Set<Entry<Integer, String>> empIdsWithNames = listOfEmployees.stream()
				.collect(Collectors.toMap(Employee::getEmpid, Employee::getEmpname)).entrySet();
		System.out.println(empIdsWithNames);
		System.out.println("========================================");

		// 15. Find the employee with the maximum ID

		System.out.println("Find the employee with the maximum ID ::");
		Employee maxEmployeeWithID = listOfEmployees.stream()
				.sorted(Comparator.comparing(Employee::getEmpid).reversed()).findFirst().get();
		System.out.println(maxEmployeeWithID);
		System.out.println("========================================");

		// 16. List the employees in ascending order of their names

		System.out.println("List the employees in ascending order of their names ::");
		List<String> empNamesWithAsc = listOfEmployees.stream().sorted(Comparator.comparing(Employee::getEmpname))
				.map(Employee::getEmpname).collect(Collectors.toList());
		System.out.println(empNamesWithAsc);
		System.out.println("========================================");

		// 17. Find the employee with the longest name and Given Only Employee Name

		System.out.println("Find the employee with the longest name and Given Only Employee Name ::: ");
		listOfEmployees.stream().max(Comparator.comparing(e -> e.getEmpname().length())).map(emp -> emp.getEmpname())
				.ifPresent(System.out::println);

		System.out.println("=========================================");

		// 18. Find the employee with the longest name and Given Only Employee Name

		System.out.println("Find the employee with the longest name and Given Complete Employee Details ::: ");
		listOfEmployees.stream().max(Comparator.comparing(e -> e.getEmpname().length())).ifPresent(System.out::println);

		System.out.println("=========================================");

		// 19. Find the employee with the lowest name and Given Only Employee Name

		System.out.println("Find the employee with the lowest name and Given Only Employee Name ::: ");
		listOfEmployees.stream().min(Comparator.comparing(e -> e.getEmpname().length())).map(emp -> emp.getEmpname())
				.ifPresent(System.out::println);

		System.out.println("=========================================");

		// 19. Find the employee with the lowest name and Given Only Employee Name

		System.out.println("Find the employee with the lowest name and Given Complete Employee Details ::: ");
		listOfEmployees.stream().min(Comparator.comparing(e -> e.getEmpname().length())).ifPresent(System.out::println);

		System.out.println("=========================================");

		// 20. Find Employees Who Are Not Java Developers
		System.out.println("Find Employees Who Are Not Java Developers");
		listOfEmployees.stream().filter(e -> !e.getDesignation().equals("Java Developer")).forEach(System.out::println);

		System.out.println("=========================================");

		// 21. Find employees whose names start with a specific letter (e.g., "V")

		System.out.println("Find employees whose names start with a specific letter (e.g., \"V\")");
		List<Employee> listOfEmployeesWhoNameStartsWithV = listOfEmployees.stream()
				.filter(e -> e.getEmpname().startsWith("V")).collect(Collectors.toList());
		System.out.println(listOfEmployeesWhoNameStartsWithV);

		System.out.println("=========================================");

		// 22.Get the third highest-earning employee.
		System.out.println("Get the third highest-earning employee. :: ");
		Employee employee = listOfEmployees.stream().sorted(Comparator.comparing(Employee::getEmpsalary).reversed())
				.skip(2).limit(1).findAny().get();
		System.out.println(employee);

		System.out.println("=========================================");

		// 23. Find the top 3 designations with the most employees.

		System.out.println("Find the top 3 designations with the most employees :: ");
		List<Entry<String, Long>> top3EmployeesWithDesignation = listOfEmployees.stream()
				.collect(Collectors.groupingBy(Employee::getDesignation, Collectors.counting())).entrySet().stream()
				.sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(3).collect(Collectors.toList());
		System.out.println(top3EmployeesWithDesignation);
		System.out.println("==========================================");

		// 24. Partition employees based on whether their names have more than 6
		// characters
		System.out.println("Partition employees based on whether their names have more than 6 characters");

		List<String> listOfEmployeesWithSixCharacters = listOfEmployees.stream()
				.filter(e -> e.getEmpname().length() > 6).map(Employee::getEmpname).collect(Collectors.toList());
		System.out.println(listOfEmployeesWithSixCharacters);

		System.out.println("==========================================");

		// 25. Group employees by their designation and find the average salary for each
		// group.
		System.out.println("Group employees by their designation and find the average salary for each group");
		List<Entry<String, Double>> EmployeeWithAvgSalaries = listOfEmployees.stream()
				.collect(Collectors.groupingBy(Employee::getDesignation,
						Collectors.averagingInt(Employee::getEmpsalary)))
				.entrySet().stream().collect(Collectors.toList());
		System.out.println(EmployeeWithAvgSalaries);
		System.out.println("============================================");

		// 26. Find the total number of employees grouped by their city and sorted by
		// count in descending order.

		System.out.println(
				"Find the total number of employees grouped by their city and sorted by count in descending order.");
		Stream<Entry<String, Long>> mapOfEmployees = listOfEmployees.stream()
				.collect(Collectors.groupingBy(Employee::getEmpaddress, Collectors.counting())).entrySet().stream()
				.sorted(Map.Entry.<String, Long>comparingByValue());
		mapOfEmployees.forEach(entry -> System.out.println("City is::" + entry.getKey() + " " + entry.getValue()));
		System.out.println("============================================");

		// 27. Get the names of employees sorted by their salaries in ascending order
		// but exclude the lowest salary

		System.out.println(
				"Get the names of employees sorted by their salaries in ascending order but exclude the lowest salary ::");
		List<Employee> listOfEmployeesBasedOnSalary = listOfEmployees.stream()
				.sorted(Comparator.comparingInt(Employee::getEmpsalary)).skip(1).collect(Collectors.toList());
		System.out.println(listOfEmployeesBasedOnSalary);
		System.out.println("=================================================");

		// 28 .Filter out employees whose IDs are even and return their names.

		System.out.println("Filter out employees whose IDs are even and return their names.");

		List<Entry<Integer, List<Employee>>> listOfEmployeesWithEvenEmpId = listOfEmployees.stream()
				.collect(Collectors.groupingBy(Employee::getEmpid)).entrySet().stream().filter(e -> e.getKey() % 2 == 0)
				.collect(Collectors.toList());
		System.out.println(listOfEmployeesWithEvenEmpId);
		System.out.println("=================================================");

		// 29.Find all employees who are earning exactly the average salary.
		System.out.println("Find all employees who are earning Greater  the average salary.");
		Integer averageSalary = listOfEmployees.stream().collect(Collectors.averagingInt(Employee::getEmpsalary))
				.intValue();
		List<Employee> employeesWhoseSalaryGreaterThanAverage = listOfEmployees.stream()
				.filter(e -> e.getEmpsalary() >= averageSalary).collect(Collectors.toList());
		System.out.println(employeesWhoseSalaryGreaterThanAverage);
		System.out.println("=================================================");

		// 30. Get a list of employees grouped by city, sorted by salary within each
		// group.
//		System.out.println("Get a list of employees grouped by city, sorted by salary within each group::");
//		listOfEmployees.stream().collect(Collectors.groupingBy(Employee::getEmpaddress),Collectors.collectingAndThen(Collectors.toList(), list->list.stream().sorted(Comparator.comparing(Employee::getEmpsalary).reversed())));

		// 31. Create a flat list of all employee names converted to Uppercase
		System.out.println("Create a flat list of all employee names converted to uppercase");
		List<String> allEmployeesWithUpperCase = listOfEmployees.stream().map(emp -> emp.getEmpname().toUpperCase())
				.collect(Collectors.toList());
		System.out.println(allEmployeesWithUpperCase);

		System.out.println("==================================================");

		// Get the maximum salary of employees in each city
		System.out.println("Get the maximum salary of employees in each city ::: ");
		listOfEmployees.stream()
				.collect(Collectors.groupingBy(Employee::getEmpaddress,
						Collectors.maxBy(Comparator.comparing(Employee::getEmpsalary))))
				.entrySet().forEach(e -> System.out.println(e.getKey() + "++++++++++++++" + e.getValue()));
		System.out.println("==================================================");

		// Get the Minimum salary of employees in each city
		System.out.println("Get the Minimum salary of employees in each city ::: ");
		listOfEmployees.stream()
				.collect(Collectors.groupingBy(Employee::getEmpaddress,
						Collectors.minBy(Comparator.comparing(Employee::getEmpsalary))))
				.entrySet().forEach(e -> System.out.println(e.getKey() + "==============" + e.getValue()));
		System.out.println("==================================================");

		// Requirement is Groups Employees based on the Address, and Print Only Employee
		// Names

		System.out.println("Groups Employees based on the Address, and Print Only Employee Names");

		// Collectors.mapping()--> it is used to get specific record, value from the Map
		Map<String, List<String>> groupEmployeesBasedOnAddress = listOfEmployees.stream().collect(Collectors
				.groupingBy(Employee::getEmpaddress, Collectors.mapping(Employee::getEmpname, Collectors.toList())));

		System.out.println(groupEmployeesBasedOnAddress);

		System.out.println("==================================================");

		// Get the maximum salary of employee Names in each city
		System.out.println("Get the maximum salary of  Only employees in each city ::: ");
		listOfEmployees.stream()
				.collect(Collectors.groupingBy(Employee::getEmpaddress,
						Collectors.maxBy(Comparator.comparing(Employee::getEmpsalary))))
				.entrySet()
				.forEach(e -> System.out.println(e.getKey() + "++++++++++++++" + e.getValue().get().getEmpname()));
		System.out.println("==================================================");
	}
}
