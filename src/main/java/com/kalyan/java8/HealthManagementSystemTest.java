package com.kalyan.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class HealthManagementSystemTest {

	public static void main(String[] args) {

		List<Patient> patientDetails = Arrays.asList(
				new Patient(1, "John Doe", 28, "Male", "Diabetes", 78.5, 170, "Dr. Smith"),
				new Patient(2, "Jane Smith", 34, "Female", "Hypertension", 65.2, 160, "Dr. Taylor"),
				new Patient(3, "Sam Wilson", 45, "Male", "Asthma", 85.0, 175, "Dr. Smith"),
				new Patient(4, "Emily Davis", 29, "Female", "Healthy", 54.0, 158, "Dr. Taylor"),
				new Patient(5, "Chris Brown", 50, "Male", "Heart Disease", 95.3, 172, "Dr. Wilson"),
				new Patient(6, "Sophia Johnson", 40, "Female", "Diabetes", 70.0, 165, "Dr. Smith"));

		System.out.println("1. Find all patients with a specific condition (e.g., \"Diabetes\").");
		List<Patient> diabateicPatients = patientDetails.stream().filter(p -> p.getCondition().equals("Diabetes"))
				.collect(Collectors.toList());
		System.out.println(diabateicPatients);
		System.out.println("============================================================================");
		System.out.println("2.Calculate the average age of all patients.");
		Double averagePatientAge = patientDetails.stream().collect(Collectors.averagingInt(Patient::getAge));
		System.out.println(averagePatientAge);
		System.out.println("============================================================================");
		System.out.println("3. Group all patients by their assigned doctor.");
		patientDetails.stream().collect(Collectors.groupingBy(p -> p.getDoctor())).entrySet().stream()
				.forEach(e -> System.out.println(e.getKey() + ":::" + e.getValue()));
		System.out.println("============================================================================");
		System.out.println("4.  Identify the patient with the highest Body Mass Index (BMI).");
		Optional<Patient> highestBmiPatient = patientDetails.stream().max(Comparator
				.comparingDouble(patient -> patient.getWeight() / (patient.getHeight() * patient.getHeight())));

		System.out.println(highestBmiPatient.get());
		System.out.println("============================================================================");
		System.out.println("5.Find all patients aged above 40.");
		List<Patient> patientWithAboveFourty = patientDetails.stream().filter(p -> p.getAge() > 40)
				.collect(Collectors.toList());
		System.out.println(patientWithAboveFourty);
		System.out.println("============================================================================");
		System.out.println("6.Generate statistics for patient weights, including count, sum, average, min, and max.");
		DoubleSummaryStatistics summerizingPatientUsingWeight = patientDetails.stream()
				.collect(Collectors.summarizingDouble(Patient::getWeight));
		System.out.println("Patient Details ::" + "count: ==>" + summerizingPatientUsingWeight.getCount()
				+ " Sum	:==> " + summerizingPatientUsingWeight.getSum() + " Average: ==> "
				+ summerizingPatientUsingWeight.getAverage() + " Min: ==> " + summerizingPatientUsingWeight.getMin()
				+ " Max: ==>" + summerizingPatientUsingWeight.getMax());
		System.out.println("===============================================================================");
		System.out.println("7.Identify the oldest patient in the system ::");
		Optional<Patient> maxAgePatient = patientDetails.stream().max(Comparator.comparing(p -> p.getAge()));
		if (maxAgePatient.isPresent())
			System.out.println("Maximum Age Patient :" + maxAgePatient.get());

		System.out.println("=================================================================================");
		System.out.println("8. Sort the patients in ascending or descending order of their age.");
		List<Patient> patientWithsmallToOld = patientDetails.stream().sorted(Comparator.comparing(Patient::getAge))
				.collect(Collectors.toList());
		List<Patient> patientWithOldToSmall = patientDetails.stream()
				.sorted(Comparator.comparing(Patient::getAge).reversed()).collect(Collectors.toList());
		System.out.println("Patient With Small Age to Max Age :: " + patientWithsmallToOld);
		System.out.println("Patient With Old Age to Small Age :: " + patientWithOldToSmall);
		System.out.println("==================================================================================");

		System.out.println("9.  Filter patients with BMI in the healthy range ");
		Map<String, Double> healthyBMIPatients = patientDetails.stream().collect(Collectors.toMap(Patient::getName,
				patient -> patient.getWeight() / (patient.getHeight() * patient.getHeight()) // Correct BMI formula
		)).entrySet().stream().filter(entry -> entry.getValue() >= 18.5 && entry.getValue() <= 24.9) // Healthy BMI
																										// range
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		// Output the filtered patients
		System.out.println("Patients with healthy BMI: " + healthyBMIPatients);

		System.out.println("==================================================================================");

		System.out.println("Unique Medical Conditions: List all unique medical conditions.");
		List<String> uniqueCondition = patientDetails.stream().map(Patient::getCondition).distinct()
				.collect(Collectors.toList());
		System.out.println(uniqueCondition);
		System.out.println("==================================================================================");
		System.out.println(" Count the number of male and female patients.");
		patientDetails.stream().collect(Collectors.groupingBy(Patient::getGender, Collectors.counting())).entrySet()
				.stream().forEach(e -> System.out.println(e.getKey() + "::" + e.getValue()));
		System.out.println("==================================================================================");

	}

}
