package com.kalyan.java8;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderManagementSystem {

	public static void main(String[] args) {

		// Dummy Data
		List<Order> orders = Arrays.asList(
				new Order(1, "Laptop", "C001", 1200.50, "DELIVERED", LocalDate.of(2025, 1, 10), 2),
				new Order(2, "Phone", "C002", 800.00, "PENDING", LocalDate.of(2025, 1, 12), 5),
				new Order(3, "Laptop", "C003", 1150.75, "CANCELLED", LocalDate.of(2025, 1, 11), 2),
				new Order(4, "Tablet", "C004", 500.00, "DELIVERED", LocalDate.of(2025, 1, 14), 1),
				new Order(5, "Laptop", "C007", 1250.00, "PENDING", LocalDate.of(2025, 1, 13), 4),
				new Order(6, "Phone", "C005", 850.25, "DELIVERED", LocalDate.of(2025, 1, 15), 1),
				new Order(7, "Tablet", "C008", 600.00, "DELIVERED", LocalDate.of(2025, 1, 16), 2));
		System.out.println("****1. The complete Order Details *****");
		System.out.println(orders);

		System.out.println(
				"=============================================================================================");
		System.out.println("2. Filter Orders by Product Name\r\n"
				+ "Given a list of orders with product names, filter all orders for a specific product, e.g., \"Laptop\".");
		List<Order> productWithLaptop = orders.stream()
				.filter(product -> product.getProductName().equalsIgnoreCase("Laptop")).collect(Collectors.toList());
		System.out.println(productWithLaptop);

		System.out
				.println("==========================================================================================");
		System.out.println("3.Calculate Total Revenue :::");
		double revenue = orders.stream().mapToDouble(o -> o.getPrice()).sum();
		System.out.println(revenue);
		System.out.println("USing Map and redue Methods");
		Double reduce = orders.stream().map(Order::getPrice).reduce(0.0, (e1, e2) -> e1 + e2);
		System.out.println(reduce);
		System.out.println(
				"=============================================================================================");
		System.out.println("4. Find Most Expensive Order");
		orders.stream().max(Comparator.comparing(Order::getPrice)).ifPresent(e -> System.out.println(e));
		System.out.println(
				"=============================================================================================");
		System.out.println("5. Get Orders by Customer\r\n"
				+ "Extract all orders placed by a specific customer (e.g., by customerId).");
		orders.stream().collect(Collectors.groupingBy(o -> o.getCustomerId())).entrySet().stream()
				.forEach(e -> System.out.println(e.getKey() + ":::" + e.getValue()));
		System.out.println(
				"=============================================================================================");

		System.out.println("5. Group Orders by Status\r\n"
				+ "Group orders into different categories like DELIVERED, PENDING, and CANCELLED ");
		orders.stream().collect(Collectors.groupingBy(o -> o.getStatus())).entrySet().stream()
				.forEach(e -> System.out.println(e.getKey() + ":::" + e.getValue()));
		System.out.println(
				"=============================================================================================");

		System.out.println("Count Orders per Product ::");
		orders.stream().collect(Collectors.groupingBy(o -> o.getProductName(), Collectors.counting())).entrySet()
				.stream().forEach(o -> System.out.println(o.getKey() + ":::" + o.getValue()));

		System.out.println(
				"=============================================================================================");
		System.out.println(
				"7. Sort Orders by Date\r\n" + "Sort orders in ascending or descending order based on the order date.");
		List<Order> collectOrdersByOrdersDate = orders.stream()
				.sorted(Comparator.comparing(Order::getOrderDate).reversed()).collect(Collectors.toList());
		System.out.println(collectOrdersByOrdersDate);
		System.out.println(
				"=============================================================================================");
		System.out.println("8. Find All Orders Within a Price Range\r\n"
				+ "Filter orders with total amounts between a specified range, e.g., $50 to $200.");
		List<Order> filterOrdersBasedOnPrice = orders.stream().filter(o -> o.getPrice() >= 1000 && o.getPrice() <= 2000)
				.collect(Collectors.toList());
		System.out.println(filterOrdersBasedOnPrice);
		System.out.println("=====================================================================================");
		System.out.println("9.Get Unique Product Names");
		List<String> distinctProductNames = orders.stream().map(Order::getProductName).distinct()
				.collect(Collectors.toList());
		System.out.println(distinctProductNames);
		System.out.println("=====================================================================================");
		System.out.println("10.Combine All Product Names\r\n"
				+ "Create a comma-separated string of all product names from the orders using Collectors.joining.");
		String collect = orders.stream().map(Order::getProductName).collect(Collectors.joining(","));
		System.out.println(collect);
		System.out.println("=====================================================================================");

		System.out.println("11. Find the First Order Placed");
		Order firstOrder = orders.stream().sorted(Comparator.comparing(Order::getOrderDate)).findFirst().get();
		System.out.println(firstOrder);
		System.out.println("=====================================================================================");
		System.out.println(" 12.Generate an Order Summary\r\n"
				+ "Create a summary report (e.g., total count, total revenue, minimum, and maximum order amount) using Collectors.summarizingDouble.");
		orders.stream()
				.collect(Collectors.groupingBy(Order::getCustomerId, Collectors.summarizingDouble(Order::getPrice)))
				.entrySet().stream()
				.forEach(e -> System.out.println(e.getKey() + "::::" + "The Averge Amout is" + e.getValue().getAverage()
						+ "==>" + "The Max Amount is" + e.getValue().getMax() + "===>" + "The Min Amount"
						+ e.getValue().getMin() + "===>" + "The Total Sum ::" + e.getValue().getSum()));

		System.out.println("=====================================================================================");
		System.out.println("\n**** 2. Total Purchase Amount on Each Order *****");
		orders.forEach(o -> {
			double totalAmount = o.getPrice() * o.getQuantity();
			System.out.print("Order ID::" + o.getOrderId() + " ==>");
			System.out.print("Total Amount::" + totalAmount);
			System.out.println();

		});
		System.out.println("=====================================================================================");
		System.out.println("Find Total Order For Order ID Specific Order::");
		orders.forEach(o -> {
			if (o.getOrderId() == 2) {
				double totalAmount = o.getPrice() * o.getQuantity();
				System.out.print("Order ID::" + o.getOrderId() + " ==>");
				System.out.print("Total Amount::" + totalAmount);
				System.out.println();

			}
		});
		System.out.println("=====================================================================================");

	}
}
