package com.kalyan.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BankingBasedApplication {

	public static void main(String[] args) {

		List<BankingCustomer> bankingDetails = Arrays.asList(
				new BankingCustomer(1, "Alice", 30, "Mumbai",
						Arrays.asList(new BankingAccount(101, "SAVINGS", 5000.0),
								new BankingAccount(102, "CURRENT", 20000.0))),
				new BankingCustomer(2, "Bob", 45, "Delhi",
						Arrays.asList(new BankingAccount(103, "SAVINGS", 15000.0),
								new BankingAccount(104, "LOAN", 300000.0))),
				new BankingCustomer(3, "Charlie", 35, "Bangalore",
						Arrays.asList(new BankingAccount(105, "CURRENT", 10000.0))),
				new BankingCustomer(4, "David", 40, "Hyderabad",
						Arrays.asList(new BankingAccount(106, "SAVINGS", 2000.0),
								new BankingAccount(107, "LOAN", 500000.0))),
				new BankingCustomer(5, "Eve", 25, "Pune", Arrays.asList(new BankingAccount(108, "SAVINGS", 8000.0))),
				new BankingCustomer(6, "Frank", 29, "Chennai",
						Arrays.asList(new BankingAccount(109, "SAVINGS", 10000.0),
								new BankingAccount(110, "CURRENT", 25000.0),
								new BankingAccount(111, "LOAN", 200000.0))),
				new BankingCustomer(7, "Grace", 32, "Mumbai",
						Arrays.asList(new BankingAccount(112, "SAVINGS", 18000.0))),
				new BankingCustomer(8, "Henry", 50, "Delhi",
						Arrays.asList(new BankingAccount(113, "CURRENT", 15000.0),
								new BankingAccount(114, "LOAN", 350000.0))),
				new BankingCustomer(9, "Ivy", 28, "Kolkata",
						Arrays.asList(new BankingAccount(115, "SAVINGS", 12000.0),
								new BankingAccount(116, "CURRENT", 10000.0))),
				new BankingCustomer(10, "Jack", 42, "Bangalore",
						Arrays.asList(new BankingAccount(117, "SAVINGS", 25000.0),
								new BankingAccount(118, "LOAN", 400000.0))),
				new BankingCustomer(11, "Kate", 31, "Hyderabad",
						Arrays.asList(new BankingAccount(119, "SAVINGS", 22000.0),
								new BankingAccount(120, "CURRENT", 5000.0))),
				new BankingCustomer(12, "Leo", 38, "Chennai",
						Arrays.asList(new BankingAccount(121, "CURRENT", 30000.0),
								new BankingAccount(122, "LOAN", 250000.0))),
				new BankingCustomer(13, "Mia", 36, "Mumbai",
						Arrays.asList(new BankingAccount(123, "SAVINGS", 15000.0),
								new BankingAccount(124, "CURRENT", 7000.0))),
				new BankingCustomer(14, "Nathan", 48, "Delhi",
						Arrays.asList(new BankingAccount(125, "SAVINGS", 35000.0),
								new BankingAccount(126, "LOAN", 450000.0))),
				new BankingCustomer(15, "Olivia", 26, "Bangalore", Arrays.asList(
						new BankingAccount(127, "SAVINGS", 9000.0), new BankingAccount(128, "CURRENT", 15000.0))));

		System.out.println("1. Get a list of customers who are above 30 years old ::");
		List<BankingCustomer> customerMoreThan30 = bankingDetails.stream().filter(banking -> banking.getAge() > 30)
				.collect(Collectors.toList());
		System.out.println(customerMoreThan30);
		System.out.println("========================================================================");
		System.out.println("2. Calculate the total balance of all SAVINGS accounts across all customers :: ");
		double totaBalanceOfSavingAccounts = bankingDetails.stream().flatMap(b -> b.getAccounts().stream())
				.filter(b -> b.getAccountType().equals("SAVINGS")).mapToDouble(v -> v.getBalance()).sum();
		System.out.println(totaBalanceOfSavingAccounts);
		System.out.println("========================================================================");

		System.out.println("3. Retrieve the names of all customers living in \"Mumbai  :: ");
		List<String> customersWhoLivesInMumbai = bankingDetails.stream().filter(v -> v.getCity().equals("Mumbai"))
				.map(b -> b.getName()).collect(Collectors.toList());
		System.out.println(customersWhoLivesInMumbai);
		System.out.println("========================================================================");

		System.out.println("4. Find the customer with the highest total loan balance.");
		Optional<Entry<String, Double>> customerWithHighestBalanceLoan = bankingDetails.stream()
				.collect(Collectors.groupingBy(c -> c.getName(),
						Collectors.summingDouble(accounts -> accounts.getAccounts().stream()
								.filter(acc -> acc.getAccountType().equals("LOAN"))
								.mapToDouble(balance -> balance.getBalance()).sum())))
				.entrySet().stream().max(Entry.comparingByValue());
		if (customerWithHighestBalanceLoan.isPresent()) {
			System.out.println(customerWithHighestBalanceLoan.get());
		}
		System.out.println("========================================================================");

		System.out.println("5. Group all customers by the city they live in.");
		Map<String, List<BankingCustomer>> listOfCustomersBasedOnCity = bankingDetails.stream()
				.collect(Collectors.groupingBy(city -> city.getCity())).entrySet().stream()
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
		System.out.println(listOfCustomersBasedOnCity);

		System.out.println("========================================================================");

		System.out.println("6. Create a summary of each customer showing their name and total account balance.");
		Map<String, Double> customerWithTotalBalance = bankingDetails.stream()
				.collect(Collectors.groupingBy(c -> c.getName(), Collectors
						.summingDouble(value -> value.getAccounts().stream().mapToDouble(p -> p.getBalance()).sum())));
		System.out.println(customerWithTotalBalance);

		System.out.println("========================================================================");
		System.out.println("7. List all distinct account types available in the system.");
		List<String> distinctAccountTypes = bankingDetails.stream().flatMap(p -> p.getAccounts().stream())
				.map(account -> account.getAccountType()).distinct().toList();
		System.out.println(distinctAccountTypes);

		System.out.println("========================================================================");

		System.out.println("8. Check if there is any customer whose total account balance exceeds ₹1,00,000.");
		List<BankingCustomer> customerDetails = bankingDetails.stream()
				.collect(Collectors.groupingBy(customer -> customer,
						Collectors.summingDouble(
								v -> v.getAccounts().stream().mapToDouble(BankingAccount::getBalance).sum())))
				.entrySet().stream().filter(e -> e.getValue() > 100000).map(e -> e.getKey())
				.collect(Collectors.toList());
		System.out.println(customerDetails);
		System.out.println("========================================================================");

		System.out.println("9. Sort all customers in descending order based on their total account balance.");

		List<Entry<BankingCustomer, Double>> listOfCustomersBasedOnDescendingOrder = bankingDetails.stream()
				.collect(Collectors.groupingBy(customer -> customer,
						Collectors.summingDouble(
								v -> v.getAccounts().stream().mapToDouble(BankingAccount::getBalance).sum())))
				.entrySet().stream().sorted(Map.Entry.<BankingCustomer, Double>comparingByValue().reversed())
				.collect(Collectors.toList());
		listOfCustomersBasedOnDescendingOrder.stream()
				.forEach(e -> System.out.println(e.getKey() + ":::" + e.getValue()));
		System.out.println("========================================================================");

		System.out.println("10. Identify customers who do not have a SAVINGS account.");
		List<BankingCustomer> customerDetailsNotHavingSavingsAccount = bankingDetails.stream()
				.filter(customer -> customer.getAccounts().stream()
						.noneMatch(account -> account.getAccountType().equals("SAVINGS")))
				.collect(Collectors.toList());
		System.out.println(customerDetailsNotHavingSavingsAccount);
		System.out.println("========================================================================");

		System.out.println("Calculate the total balance for each account type (SAVINGS, CURRENT, LOAN).");
		Map<String, Double> eachAccountTypeTotalBalance = bankingDetails.stream()
				.flatMap(acc -> acc.getAccounts().stream()).collect(Collectors.groupingBy(acc -> acc.getAccountType(),
						Collectors.summingDouble(price -> price.getBalance())));
		System.out.println(eachAccountTypeTotalBalance);
		System.out.println("========================================================================");

		System.out.println("Find the top 3 customers with the highest total account balances.");
		List<Entry<BankingCustomer, Double>> collect = bankingDetails.stream()
				.collect(Collectors.groupingBy(c -> c,
						Collectors.summingDouble(
								acc -> acc.getAccounts().stream().mapToDouble(balance -> balance.getBalance()).sum())))
				.entrySet().stream().sorted(Entry.<BankingCustomer, Double>comparingByValue().reversed()).limit(3)
				.collect(Collectors.toList());
		System.out.println(collect);

		System.out.println("========================================================================");

		System.out.println("Get the average account balance across all customers.");
		Double avergeBalanceOfAllCustomers = bankingDetails.stream().collect(Collectors.averagingDouble(
				customer -> customer.getAccounts().stream().mapToDouble(details -> details.getBalance()).sum()));
		System.out.println(avergeBalanceOfAllCustomers);
		System.out.println("========================================================================");

		System.out.println("Count how many customers have more than one account.");
		long customerCount = bankingDetails.stream().filter(v -> v.getAccounts().size() > 1).count();
		System.out.println(customerCount);
		System.out.println("========================================================================");

	}

}
