package com.kalyan.java8;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import org.springframework.cglib.core.internal.Function;

public class EcommerceApplication {

	public static void main(String[] args) {

		List<Products> products = Arrays.asList(new Products(1, "iPhone 14", "Electronics", 999.99, 20, 100),
				new Products(2, "Samsung Galaxy S23", "Electronics", 899.99, 15, 80),
				new Products(3, "T-shirt", "Fashion", 29.99, 50, 150),
				new Products(4, "Jeans", "Fashion", 49.99, 10, 60),
				new Products(5, "Book - Java 8 in Action", "Books", 39.99, 25, 200),
				new Products(6, "Blender", "Home Appliances", 79.99, 5, 30),
				new Products(7, "Smart Watch", "Electronics", 199.99, 8, 50),
				new Products(8, "Office Chair", "Furniture", 129.99, 12, 40),
				new Products(9, "Headphones", "Electronics", 149.99, 18, 90),
				new Products(10, "Coffee Maker", "Home Appliances", 89.99, 7, 45));

		List<Customer> customers = Arrays.asList(new Customer(1, "John Doe", "john.doe@example.com"),
				new Customer(2, "Jane Smith", "jane.smith@example.com"),
				new Customer(3, "Bob Johnson", "bob.johnson@example.com"),
				new Customer(4, "Alice Brown", "alice.brown@example.com"),
				new Customer(5, "Tom Wilson", "tom.wilson@example.com"),
				new Customer(6, "Sara White", "sara.white@example.com"),
				new Customer(7, "Mike Green", "mike.green@example.com"),
				new Customer(8, "Emma Davis", "emma.davis@example.com"),
				new Customer(9, "Chris Lee", "chris.lee@example.com"),
				new Customer(10, "Sophia Taylor", "sophia.taylor@example.com"));

		List<Orders> orders = Arrays.asList(
				new Orders(1, customers.get(0), Arrays.asList(products.get(0), products.get(3)), "Delivered",
						LocalDate.of(2024, 1, 5), LocalDate.of(2024, 1, 10)),
				new Orders(2, customers.get(1), Arrays.asList(products.get(1), products.get(4), products.get(5)),
						"Shipped", LocalDate.of(2024, 1, 6), LocalDate.of(2024, 1, 12)),
				new Orders(3, customers.get(2), Arrays.asList(products.get(2), products.get(6)), "Pending",
						LocalDate.of(2024, 1, 7), null),
				new Orders(4, customers.get(3), Arrays.asList(products.get(7), products.get(8)), "Delivered",
						LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5)),
				new Orders(5, customers.get(4), Arrays.asList(products.get(9), products.get(0)), "Shipped",
						LocalDate.of(2024, 1, 8), LocalDate.of(2024, 1, 15)),
				new Orders(6, customers.get(5), Arrays.asList(products.get(1), products.get(2)), "Delivered",
						LocalDate.of(2024, 1, 2), LocalDate.of(2024, 1, 8)),
				new Orders(7, customers.get(6), Arrays.asList(products.get(3), products.get(6), products.get(7)),
						"Pending", LocalDate.of(2024, 1, 9), null),
				new Orders(8, customers.get(7), Arrays.asList(products.get(4), products.get(5)), "Shipped",
						LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 16)),
				new Orders(9, customers.get(8), Arrays.asList(products.get(0), products.get(8), products.get(9)),
						"Delivered", LocalDate.of(2024, 1, 3), LocalDate.of(2024, 1, 9)),
				new Orders(10, customers.get(9), Arrays.asList(products.get(2), products.get(5), products.get(7)),
						"Shipped", LocalDate.of(2024, 1, 4), LocalDate.of(2024, 1, 11)));

		System.out.println("::: Real-Time Scenarios to Practice :::");
		System.out.println("1. *******Product Management********");
		System.out.println("======================================");
		System.out.println("Find all products with a price greater than $100");
		List<Products> filteredProducts = products.stream().filter(p -> p.getPrice() > 100.0)
				.collect(Collectors.toList());
		System.out.println(filteredProducts);
		System.out.println("-------------------------");
		System.out.println("2.Get a list of products in the \"Electronics\" category.");
		List<Products> electronicsProductFilters = products.stream().filter(p -> p.getCategory().equals("Electronics"))
				.collect(Collectors.toList());
		System.out.println(electronicsProductFilters);
		System.out.println("-------------------------");
		System.out.println("3.Sort products by their stock quantity in ascending order.");
		List<Products> productsWithQuanityIncreases = products.stream().sorted(Comparator.comparing(Products::getStock))
				.collect(Collectors.toList());
		System.out.println(productsWithQuanityIncreases);
		System.out.println("-------------------------");
		System.out.println("4.Get the top 3 best-selling products (based on sales).");
		List<Products> topThreeProductsBasedOnSales = products.stream()
				.sorted(Comparator.comparing(Products::getSales).reversed()).limit(3).collect(Collectors.toList());
		System.out.println(topThreeProductsBasedOnSales);
		System.out.println("-------------------------");
		System.out.println("5.Find the total value of products in stock (price × stock quantity).");
		double totalValueOfProductsInStock = products.stream().mapToDouble(p -> p.getStock() * p.getPrice()).sum();
		System.out.println(totalValueOfProductsInStock);
		System.out.println("-------------------------");
		System.out.println("2. *******Customer Insights********");
		System.out.println("======================================");
		System.out.println("1.Find all customer Details who placed more than 2 orders =>");
		orders.stream().filter(o -> o.getProducts().size() > 2).map(Orders::getCustomer).forEach(System.out::println);
		System.out.println("======================================");

		System.out.println("2. Get a list of customer emails who have \"Shipped\" orders =>");
		List<String> customersWithEmails = orders.stream().filter(o -> o.getStatus().equalsIgnoreCase("Shipped"))
				.map(o -> o.getCustomer().getEmail()).collect(Collectors.toList());
		System.out.println(customersWithEmails);
		System.out.println("3. Find the customer who spent the most on their orders.");
		Optional<Entry<String, Double>> customerWhoSpentMax = orders.stream()
				.collect(Collectors.groupingBy(o -> o.getCustomer().getName(),
						Collectors.summingDouble(
								p -> p.getProducts().stream().mapToDouble(price -> price.getPrice()).sum())))
				.entrySet().stream().max(Comparator.comparing(v -> v.getValue()));
		if (customerWhoSpentMax.isPresent()) {
			System.out.println(customerWhoSpentMax.get() + " ");
		} else {
			System.out.println("No Customer is Found:");
		}

		System.out.println("======================================");

		System.out.println("4. Generate a report showing the total revenue generated by each customer");

		orders.stream()
				.collect(Collectors.groupingBy(c -> c.getCustomer().getName(),
						Collectors.summarizingDouble(
								p -> p.getProducts().stream().mapToDouble(Products::getPrice).sum())))
				.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "======>" + e.getValue().getSum()));

		System.out.println("======================================");

		System.out.println("5. Find all unique product categories purchased by each  customer.");
		Map<String, Set<String>> uniqueProducts = orders.stream()
				.collect(Collectors.groupingBy(o -> o.getCustomer().getName(), Collectors.flatMapping(
						e -> e.getProducts().stream(), Collectors.mapping(Products::getCategory, Collectors.toSet()))));
		System.out.println(uniqueProducts);
		System.out.println("======================================");

		System.out.println("3.******************Order Management*******************");
		System.out.println("1. Get all orders placed in the last 30 days.");
		List<Orders> recentOrders = orders.stream()
				.filter(order -> ChronoUnit.DAYS.between(order.getOrderDate(), LocalDate.now()) <= 30)
				.collect(Collectors.toList()); // Collect the results into a list
		System.out.println("======================================");
		System.out.println("2. Find all orders that are still pending delivery.");
		List<Orders> ordersWithPendingStatus = orders.stream().filter(o -> o.getStatus().equals("Pending"))
				.collect(Collectors.toList());
		System.out.println(ordersWithPendingStatus);
		System.out.println("======================================");
		System.out.println("3. Calculate the total revenue generated by all \"Delivered\" orders.");
		double totalRevenueGeneratedByDelivered = orders.stream().filter(o -> o.getStatus().equals("Delivered"))
				.flatMap(p -> p.getProducts().stream()).mapToDouble(Products::getPrice).sum();
		System.out.println(totalRevenueGeneratedByDelivered);
		System.out.println("======================================");
		System.out.println("4. Find the average order value for all orders.");
		Double averageOrders = orders.stream().flatMap(o -> o.getProducts().stream())
				.collect(Collectors.averagingDouble(Products::getPrice));
		System.out.println(averageOrders);

		System.out.println("======================================");
		System.out.println("4. *****Advanced Questions*******");
		System.out.println("======================================");
		System.out.println("1. Identify products that are low in stock (stock <= 5) and recommend restocking.");
		Set<Products> productsLessthanFive = orders.stream().flatMap(p -> p.getProducts().stream())
				.filter(p -> p.getStock() <= 5).collect(Collectors.toSet());
		System.out.println(productsLessthanFive);
		System.out.println("======================================");
		System.out.println("2. Get the total number of products sold (sum of sales across all products).");
		double totalSalesOfAllProducts = products.stream().mapToDouble(p -> p.getSales()).sum();

		System.out.println(totalSalesOfAllProducts);

		System.out.println("======================================");
		System.out.println("3. Find the most expensive product purchased across all orders.");
		Products mostExpensiveProductPurchased = orders.stream().flatMap(p -> p.getProducts().stream())
				.max(Comparator.comparing(Products::getPrice)).get();
		System.out.println(mostExpensiveProductPurchased);
		System.out.println("======================================");
		System.out.println("4. Get the total value of all products ordered by each customer.");
		orders.stream()
				.collect(Collectors.groupingBy(c -> c.getCustomer().getName(),
						Collectors.summingDouble(p -> p.getProducts().stream().mapToDouble(v -> v.getPrice()).sum())))
				.entrySet().stream().forEach(e -> System.out.println(e.getKey() + ":::" + e.getValue()));

		System.out.println("========================================");
		System.out.println("5. For each order, calculate the total price of products in the order.");
		Map<Integer, Double> priceOfEachOrder = orders.stream().collect(Collectors.groupingBy(o -> o.getId(),
				Collectors.summingDouble(p -> p.getProducts().stream().mapToDouble(price -> price.getPrice()).sum())));
		System.out.println(priceOfEachOrder);
		System.out.println("========================================");

		System.out.println(
				"6.Find the average delivery time (from order date to delivery date) for \"Delivered\" orders.");
		OptionalDouble averageDate = orders.stream().filter(o -> o.getStatus().equals("Delivered"))
				.mapToLong(o -> ChronoUnit.DAYS.between(o.getOrderDate(), o.getDeliveryDate())).average();
		System.out.println(averageDate.getAsDouble());

	}

}
