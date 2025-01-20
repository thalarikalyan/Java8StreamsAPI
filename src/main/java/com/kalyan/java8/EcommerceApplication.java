package com.kalyan.java8;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
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

		List<Customer> customers = Arrays.asList(new Customer(1, "John Doe", "john.doe@gmail.com"),
				new Customer(2, "Jane Smith", "jane.smith@gmail.com"),
				new Customer(3, "Bob Johnson", "bob.johnson@gmail.com"),
				new Customer(4, "Alice Brown", "alice.brown@yahoo.com"),
				new Customer(5, "Tom Wilson", "tom.wilson@gmail.com"),
				new Customer(6, "Sara White", "sara.white@yahoo.com"),
				new Customer(7, "Mike Green", "mike.green@gmail.com"),
				new Customer(8, "Emma Davis", "emma.davis@yahoo.com"),
				new Customer(9, "Chris Lee", "chris.lee@gmail.com"),
				new Customer(10, "Sophia Taylor", "sophia.taylor@gmail.com"),
				new Customer(11, "Ravi", "sophia.taylor@gmail.com"));

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
						"Pending", LocalDate.of(2024, 12, 19), LocalDate.of(2025, 1, 19)),
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

		System.out.println("========================================");

		System.out.println("Find Top 3 Products Which are ordered Mostly:::");
		List<Entry<String, Long>> topThreeOrderedProducts = orders.stream().flatMap(p -> p.getProducts().stream())
				.collect(Collectors.groupingBy(product -> product.getName(), Collectors.counting())).entrySet().stream()
				.sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(3).collect(Collectors.toList());
		System.out.println(topThreeOrderedProducts);
		System.out.println("=========================================");
		System.out.println("Find all products Which are Ordered Mostly::");

		Entry<String, Long> maxProduct = orders.stream().flatMap(product -> product.getProducts().stream())
				.collect(Collectors.groupingBy(p -> p.getName(), Collectors.counting())).entrySet().stream()
				.max(Entry.comparingByValue()).get();
		System.out.println("The Product Which is Ordered Mostly::" + maxProduct);
		System.out.println("=========================================");

		System.out.println("Calculate the total revenue generated by each product category.");
		Map<String, Double> categoryWithTotalRevenue = orders.stream().filter(o -> o.getStatus().equals("Delivered"))
				.flatMap(p -> p.getProducts().stream())
				.collect(Collectors.groupingBy(p -> p.getCategory(), Collectors.summingDouble(p -> p.getPrice())));
		System.out.println(categoryWithTotalRevenue);
		System.out.println("=========================================");
		System.out.println("Identify the month that generated the highest revenue.");
		Entry<Month, Double> monthWithMaxRevenue = orders.stream().filter(o -> o.getStatus().equals("Delivered"))
				.collect(Collectors.groupingBy(o -> o.getOrderDate().getMonth(),
						Collectors.summingDouble(p -> p.getProducts().stream().mapToDouble(Products::getPrice).sum())))
				.entrySet().stream().max(Entry.comparingByValue()).get();
		System.out.println(monthWithMaxRevenue);
		System.out.println("=========================================");

		System.out.println("Find the cheapest Ordered by customer with Name ::");
		Entry<String, Double> cheapestOrderedByCustomer = orders.stream()
				.collect(Collectors.groupingBy(o -> o.getCustomer().getName(),
						Collectors.summingDouble(p -> p.getProducts().stream().mapToDouble(pr -> pr.getPrice()).sum())))
				.entrySet().stream().min(Entry.<String, Double>comparingByValue()).get();
		System.out.println(cheapestOrderedByCustomer);

		System.out.println("=========================================");

		System.out.println("Find the costly Ordered by customer with Name ::");
		Entry<String, Double> costlytOrderedByCustomer = orders.stream()
				.collect(Collectors.groupingBy(o -> o.getCustomer().getName(),
						Collectors.summingDouble(p -> p.getProducts().stream().mapToDouble(pr -> pr.getPrice()).sum())))
				.entrySet().stream().max(Entry.<String, Double>comparingByValue()).get();
		System.out.println(costlytOrderedByCustomer);
		System.out.println("=========================================");

		System.out.println("Identify Category with Max Stock ::");
		Entry<String, Double> maxStock = products.stream()
				.collect(Collectors.groupingBy(p -> p.getCategory(), Collectors.summingDouble(p -> p.getStock())))
				.entrySet().stream().max(Entry.comparingByValue()).get();
		System.out.println(maxStock);
		System.out.println("=========================================");
		System.out.println("Find the oldest pending order (based on the order date).");

		Orders oldestPendingOrder = orders.stream().filter(o -> o.getStatus().equals("Pending"))
				.min(Comparator.comparing(Orders::getOrderDate)).get();
		System.out.println(oldestPendingOrder);

		System.out.println("=========================================");
		System.out.println(
				"Generate a report of products grouped by their categories, including the total stock quantity for each category.");
		Map<String, IntSummaryStatistics> collect = products.stream()
				.collect(Collectors.groupingBy(p -> p.getCategory(), Collectors.summarizingInt(p -> p.getStock())));
		collect.entrySet().stream().forEach(e -> System.out.println(e.getKey() + ":::" + e.getValue().getSum()));
		System.out.println("=========================================");
		System.out.println("Find customers who haven't placed any orders yet.");
		Set<Integer> customerIdWhoIsOrderedTheProducts = orders.stream()
				.collect(Collectors.groupingBy(e -> e.getCustomer().getId())).entrySet().stream().map(e -> e.getKey())
				.collect(Collectors.toSet());
		Set<Customer> customerWhoIsNotOrderedYet = customers.stream()
				.filter(c -> !customerIdWhoIsOrderedTheProducts.contains(c.getId())).collect(Collectors.toSet());
		System.out.println(customerWhoIsNotOrderedYet);
		System.out.println("=========================================");
		System.out.println("Generate a report showing the average spending of each customer.");

		Map<String, Double> customerReport = orders.stream()
				.collect(Collectors.groupingBy(c -> c.getCustomer().getName(), Collectors
						.averagingDouble(p -> p.getProducts().stream().mapToDouble(price -> price.getPrice()).sum())));
		System.out.println(customerReport);
		System.out.println("=========================================");
		System.out.println("Identify the customers who placed more than 500$ on Each Order.");
		Set<Integer> orderIdWithMoreThan500Purchase = orders.stream()
				.collect(Collectors.groupingBy(order -> order.getId(),
						Collectors.summingDouble(o -> o.getProducts().stream().mapToDouble(p -> p.getPrice()).sum())))
				.entrySet().stream().filter(e -> e.getValue() > 500).map(e -> e.getKey()).collect(Collectors.toSet());
		List<String> cusomterNames = orders.stream()
				.filter(order -> orderIdWithMoreThan500Purchase.contains(order.getId()))
				.map(c -> c.getCustomer().getName()).collect(Collectors.toList());
		System.out.println(cusomterNames);
		System.out.println("===========================================");
		Long gmailCount = customers.stream().filter(c -> c.getEmail().contains("@gmail"))
				.collect(Collectors.counting());
		Long yahooCount = customers.stream().filter(c -> c.getEmail().contains("@yahoo"))
				.collect(Collectors.counting());
		System.out.println("Gmail Count is: " + gmailCount);
		System.out.println("Yahoo Count is: " + yahooCount);
		System.out.println("===========================================");
		

	}

}
