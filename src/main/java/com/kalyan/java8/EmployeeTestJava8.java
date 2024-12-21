package com.kalyan.java8;

import java.util.ArrayList;
import java.util.Arrays;
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
				new Employee(12349, "Madhu", "Java Developer", 17000, "Warangal")

		);

		// 1. convert the list Of Employees to set of Employees
		listOfEmployees.stream().collect(Collectors.toSet()).forEach(System.out::println);
		System.out.println("====================================");

		// 2. Print the employee who is having the highest salary
		System.out.println(":: Employee With Highest Salary:: ");

		Employee highestSalaryEmployee = listOfEmployees.stream().max(Comparator.comparingInt(Employee::getEmpsalary))
				.get();
		System.out.println(highestSalaryEmployee);
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
		listOfEmployees.stream().min(Comparator.comparing(e -> e.getEmpname().length()))
				.ifPresent(System.out::println);

		System.out.println("=========================================");
	}

}
