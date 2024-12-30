package com.kalyan.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Product {

	private String productname;
	private Double productcost;

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Double getProductcost() {
		return productcost;
	}

	public void setProductcost(Double productcost) {
		this.productcost = productcost;
	}

	public Product(String productname, Double productcost) {
		super();
		this.productname = productname;
		this.productcost = productcost;
	}

	@Override
	public String toString() {
		return "Product [productname=" + productname + ", productcost=" + productcost + "]";
	}

}

public class CombineHashMapWithArrayList {

	public static void main(String[] args) {

		// HashMap with ArrayList as Values
		Map<String, ArrayList<String>> hashMap = new HashMap<>();
		hashMap.put("fruits", new ArrayList<>(Arrays.asList("Apple", "Banana", "Avacado", "BlueBerry")));
		hashMap.put("vegetables", new ArrayList<>(Arrays.asList("Carrot", "Cucumber", "Beetroot", "Indian Egg Plant")));
		hashMap.put("fruits", new ArrayList<>(Arrays.asList("Apple", "Banana", "Avacado", "BlueBerry")));
		System.out.println(hashMap);
		System.out.println("===========================================");
		System.out.println("HashMap With List Of Products:::");
		Map<String, List<Product>> listHashMap = new LinkedHashMap<>();
		listHashMap.put("Electronics", Arrays.asList(new Product("SAMSUNG TV", 785942.0),
				new Product("SONY TV", 74125.0), new Product("REALME TV", 17745.0)));
		listHashMap.put("Kitchen", Arrays.asList(new Product("GAS", 5942.0), new Product("RICE COOKER", 4125.0),
				new Product("PRESSURE COOKER", 1745.0)));
		listHashMap.put("Toys",
				Arrays.asList(new Product("CAR", 5942.0), new Product("BIKE", 4125.0), new Product("SHIP", 1745.0)));
		System.out.println(listHashMap);
		System.out.println("==========================================");
		

	}

}
