package com.kalyan.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
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
		long customerCount = bankingDetails.stream().filter(account -> account.getAccounts().size() > 1).count();
		System.out.println(customerCount);
		System.out.println("========================================================================");
		System.out.println("Find all customers whose total balance in CURRENT accounts exceeds ₹20,000.");
		List<BankingCustomer> listOfCustomersValue = bankingDetails.stream()
				.filter(customer -> customer.getAccounts().stream().anyMatch(
						account -> account.getAccountType().equals("CURRENT") && account.getBalance() > 20000))
				.map(updatedCustomerDetails -> new BankingCustomer(updatedCustomerDetails.getId(),
						updatedCustomerDetails.getName(), updatedCustomerDetails.getCity(),
						updatedCustomerDetails.getAccounts().stream()
								.filter(acc -> acc.getAccountType().equals("CURRENT")).collect(Collectors.toList())))
				.collect(Collectors.toList());
		System.out.println(listOfCustomersValue);
		System.out.println("========================================================================");

		System.out.println("Generate a list of customer names who have both SAVINGS and LOAN accounts.");
		List<BankingCustomer> listOfCustomerWithHoldingSavigsAndLoan = bankingDetails.stream()
				.filter(customer -> customer.getAccounts().stream()
						.allMatch(accountype -> accountype.getAccountType().equals("SAVINGS")
								|| accountype.getAccountType().equals("LOAN")))
				.collect(Collectors.toList());
		System.out.println(listOfCustomerWithHoldingSavigsAndLoan);
		System.out.println("========================================================================");
		System.out.println("Find the customer(s) with the least total account balance.");
//		Optional<Entry<BankingCustomer, Double>> customerWithLeastBalance = bankingDetails.stream()
//				.filter(customer -> customer.getAccounts().stream()
//						.anyMatch(account -> account.getAccountType().equals("CURRENT")
//								|| account.getAccountType().equals("SAVINGS")))
//				.map(updatedCustomerDetails -> new BankingCustomer(updatedCustomerDetails.getId(),
//						updatedCustomerDetails.getName(), updatedCustomerDetails.getAge(),
//						updatedCustomerDetails.getCity(),
//						updatedCustomerDetails.getAccounts().stream()
//								.filter(account -> account.getAccountType().equals("CURRENT")
//										|| account.getAccountType().equals("SAVINGS"))
//								.collect(Collectors.toList())))
//				.collect(Collectors.groupingBy(c -> c,
//						Collectors.summingDouble(
//								e -> e.getAccounts().stream().mapToDouble(balance -> balance.getBalance()).sum())))
//				.entrySet().stream().min(Entry.<BankingCustomer, Double>comparingByValue());
//		if (customerWithLeastBalance.isPresent())
//			System.out.println(customerWithLeastBalance.get());
//		System.out.println("========================================================================");

		// System.out.println("Find the customer(s) with the least total account
		// balance.");

		Optional<Entry<BankingCustomer, Double>> customerWithLeastBalance = bankingDetails.stream()
				.filter(customer -> customer.getAccounts().stream()
						.anyMatch(account -> account.getAccountType().equals("CURRENT")
								|| account.getAccountType().equals("SAVINGS")))
				// Filter customers Details Who is having SAVINGS OR CURRENT in their accounts
				// (here it will give accounts with other accounts also)
				.collect(Collectors.toMap(customer -> customer, // Use the customer as the key
						customer -> customer.getAccounts().stream() // Sum balances of "CURRENT" and "SAVINGS" accounts
								.filter(account -> account.getAccountType().equals("CURRENT")
										|| account.getAccountType().equals("SAVINGS")) // It will give only SAVINGS and
																						// CURRENT accounts from each
																						// customer
								.mapToDouble(BankingAccount::getBalance).sum()))
				.entrySet().stream() // Find the entry with the minimum balance
				.min(Entry.comparingByValue());

		if (customerWithLeastBalance.isPresent()) {
			System.out.println("Customer with the least total account balance: ");
			System.out.println(customerWithLeastBalance.get());
		} else {
			System.out.println("No customer found with savings or current accounts.");
		}
		System.out.println("========================================================================");

		System.out.println("Retrieve all account IDs for customers living in \"Delhi.\"");
		List<Integer> listOfBankIds = bankingDetails.stream().filter(address -> address.getCity().equals("Delhi"))
				.flatMap(banking -> banking.getAccounts().stream()).map(customer -> customer.getAccountId())
				.collect(Collectors.toList());
		System.out.println(listOfBankIds);
		System.out.println("========================================================================");

		System.out.println("Create a map of account types and the count of how many accounts exist for each type.");
		Map<String, Long> countAccountTypes = bankingDetails.stream().flatMap(banking -> banking.getAccounts().stream())
				.collect(Collectors.groupingBy(accountType -> accountType.getAccountType(), Collectors.counting()));
		System.out.println(countAccountTypes);
		System.out.println("========================================================================");

		System.out.println("Find customers based on cities and have at least one LOAN account.");
		bankingDetails.stream()
				.filter(accounts -> accounts.getAccounts().stream()
						.anyMatch(accounType -> accounType.getAccountType().equals("LOAN")))
				.collect(Collectors.groupingBy(BankingCustomer::getCity)).entrySet().stream()
				.forEach(e -> System.out.println(e.getKey() + "::" + e.getValue()));

		System.out.println("========================================================================");

		System.out.println("Find customers based on specific city and have at least one LOAN account.");
		bankingDetails.stream().filter(city -> city.getCity().equals("Hyderabad"))
				.filter(accounts -> accounts.getAccounts().stream()
						.anyMatch(accounType -> accounType.getAccountType().equals("LOAN")))
				.collect(Collectors.groupingBy(BankingCustomer::getCity)).entrySet().stream()
				.forEach(e -> System.out.println(e.getKey() + "::" + e.getValue()));

		System.out.println("========================================================================");

		System.out.println("Calculate the total number of accounts across all customers.");
		List<BankingAccount> flatMap = bankingDetails.stream().flatMap(accounts -> accounts.getAccounts().stream())
				.collect(Collectors.toList());
		System.out.println(flatMap.size());

		long totalNoOfAccounts = bankingDetails.stream().flatMap(accounts -> accounts.getAccounts().stream()).count();
		System.out.println(totalNoOfAccounts);
		System.out.println("========================================================================");
		System.out.println("List customers whose total account balance is divisible by 10,000");

		Map<BankingCustomer, Double> customersWhosBalanceDivisbleBy10000 = bankingDetails.stream()
				.filter(customer -> customer.getAccounts().stream()
						.anyMatch(account -> account.getAccountType().equals("CURRENT")
								|| account.getAccountType().equals("SAVINGS")))
				.collect(Collectors.toMap(customer -> customer, // Use the customer as the key
						customer -> customer.getAccounts().stream() // Sum balances of "CURRENT" and "SAVINGS" accounts
								.filter(account -> account.getAccountType().equals("CURRENT")
										|| account.getAccountType().equals("SAVINGS")) // It will give only SAVINGS and
																						// CURRENT accounts from each
																						// customer
								.mapToDouble(BankingAccount::getBalance).sum()))
				.entrySet().stream().filter(e -> e.getValue() % 10000 == 0)
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
		System.out.println(customersWhosBalanceDivisbleBy10000);
		System.out.println("========================================================================");

		System.out.println("Find all customers below 25 years of age and retrieve only their names.");
		List<BankingCustomer> customersAbove25Years = bankingDetails.stream().filter(age -> age.getAge() > 25)
				.collect(Collectors.toList());
		System.out.println(customersAbove25Years);
		System.out.println("========================================================================");
		System.out.println("Create a summary of total balances grouped by account type.");
		Map<String, Double> totalBalanceOfEachAccountType = bankingDetails.stream()
				.flatMap(bankingAccount -> bankingAccount.getAccounts().stream())
				.collect(Collectors.groupingBy(accountType -> accountType.getAccountType(),
						Collectors.summingDouble(BankingAccount::getBalance)));
		System.out.println(totalBalanceOfEachAccountType);
		System.out.println("========================================================================");
		System.out.println("Determine the total number of accounts across all customers in each city.");
		Map<String, Long> totalNoOfCustomerInEachCity = bankingDetails.stream()
				.collect(Collectors.groupingBy(c -> c.getCity(), Collectors.counting()));
		System.out.println(totalNoOfCustomerInEachCity);
		System.out.println("========================================================================");

		System.out.println("Sort all customers alphabetically by their names and print their details.");
		List<BankingCustomer> sortTheCusomers = bankingDetails.stream()
				.sorted(Comparator.comparing(BankingCustomer::getName).reversed()).collect(Collectors.toList());
		System.out.println(sortTheCusomers);
		System.out.println("========================================================================");

		System.out.println("Retrieve the top 5 customers with the highest total LOAN balances");
		LinkedHashMap<String, Double> topFiveCustomers = bankingDetails.stream()
				.filter(accountType -> accountType.getAccounts().stream()
						.anyMatch(bankAccountType -> bankAccountType.getAccountType().equals("LOAN")))
				.collect(Collectors.toMap(Function.identity(),
						customer -> customer.getAccounts().stream().filter(
								eachCustomerAccountType -> eachCustomerAccountType.getAccountType().equals("LOAN"))
								.collect(Collectors.summingDouble(balance -> balance.getBalance()))))
				.entrySet().stream().sorted(Entry.<BankingCustomer, Double>comparingByValue().reversed()).limit(5)
				.collect(Collectors.toMap(customerName -> customerName.getKey().getName(), Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(topFiveCustomers);
		System.out.println("========================================================================");
		System.out.println("Merge all account IDs from all customers into a single list.");
		List<Integer> customerIds = bankingDetails.stream()
				.flatMap(accountDetails -> accountDetails.getAccounts().stream())
				.map(accountId -> accountId.getAccountId()).collect(Collectors.toList());
		System.out.println(customerIds);
		System.out.println("========================================================================");

	}

}
