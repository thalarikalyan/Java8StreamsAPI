package com.kalyan.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8StudentExamplesTest {

	public static void main(String[] args) {

		List<Student> studentList = Stream.of(
				new Student(1, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 122,
						Arrays.asList("+912632632782", "+1673434729929")),
				new Student(2, "Pulkit", 56, "Male", "Computer Engineering", "Delhi", 67,
						Arrays.asList("+912632632762", "+1673434723929")),
				new Student(3, "Ankit", 25, "Female", "Mechanical Engineering", "Kerala", 164,
						Arrays.asList("+912632633882", "+1673434709929")),
				new Student(4, "Satish Ray", 30, "Male", "Mechanical Engineering", "Kerala", 26,
						Arrays.asList("+9126325832782", "+1671434729929")),
				new Student(5, "Roshan", 23, "Male", "Biotech Engineering", "Mumbai", 12,
						Arrays.asList("+012632632782")),
				new Student(6, "Chetan", 24, "Male", "Mechanical Engineering", "Telanagana", 90,
						Arrays.asList("+9126254632782", "+16736784729929")),
				new Student(7, "Arun", 26, "Male", "Electronics Engineering", "Telanagana", 324,
						Arrays.asList("+912632632782", "+1671234729929")),
				new Student(8, "Nam", 31, "Male", "Computer Engineering", "Telanagana", 433,
						Arrays.asList("+9126326355782", "+1673434729929")),
				new Student(9, "Sonu", 27, "Female", "Computer Engineering", "Karnataka", 7,
						Arrays.asList("+9126398932782", "+16563434729929", "+5673434729929")),
				new Student(10, "Shubham", 26, "Male", "Instrumentation Engineering", "Mumbai", 98,
						Arrays.asList("+912632646482", "+16734323229929")))
				.collect(Collectors.toList());

		// // 1. Find the list of students whose rank is in between 50 and 100
		List<Student> studentsRanks = studentList.stream().filter(s -> s.getRank() >= 50 && s.getRank() <= 100)
				.collect(Collectors.toList());
		System.out.println(studentsRanks);
		//// 2. Find the Students who stays in Telanagana and sort them by their names
		List<Student> studentsLivesInTS = studentList.stream().filter(s -> s.getCity().equals("Telanagana"))
				.sorted(Comparator.comparing(Student::getFirstName)).collect(Collectors.toList());
		System.out.println(studentsLivesInTS);

		// // 3. Find all departments names
		List<String> collectDeptNames = studentList.stream().map(s -> s.getDept()).distinct()
				.collect(Collectors.toList());
		System.out.println(collectDeptNames);

		// Group The Student By Department Names

		Map<String, List<Student>> studentsBasedOnDepartMentNames = studentList.stream()
				.collect(Collectors.groupingBy(Student::getDept));
		System.out.println(studentsBasedOnDepartMentNames);

		//// 6. Find the department who is having maximum number of students
		Entry<String, Long> maxNumberOfStudents = studentList.stream()
				.collect(Collectors.groupingBy(Student::getDept, Collectors.counting())).entrySet().stream()
				.max(Entry.comparingByValue()).get();
		System.out.println(maxNumberOfStudents);

		// 7. Find the average age of male and female students
		Map<String, Double> averageAgeOfMaleAndFemale = studentList.stream()
				.collect(Collectors.groupingBy(s -> s.getGender(), Collectors.averagingInt(s -> s.getAge())));
		System.out.println(averageAgeOfMaleAndFemale);
		// Find the highest rank in each department
		studentList.stream()
				.collect(Collectors.groupingBy(Student::getDept,
						Collectors.minBy(Comparator.comparing(Student::getRank))))
				.entrySet().stream()
				.forEach(entry -> System.out.println(entry.getKey() + "::" + entry.getValue().get()));
		// 9 .Find the student who has second rank
		Student studentWithSecondRank = studentList.stream().sorted(Comparator.comparing(Student::getRank)).skip(1)
				.findFirst().get();
		System.out.println(studentWithSecondRank);

	}

}
