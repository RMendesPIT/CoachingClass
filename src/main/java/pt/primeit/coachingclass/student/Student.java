package pt.primeit.coachingclass.student;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pt.primeit.coachingclass.courses.EnglishCourse;
import pt.primeit.coachingclass.courses.MathCourse;
import pt.primeit.coachingclass.courses.StatisticsCourse;

@Component
@Slf4j
public class Student {

	@Autowired
	MathCourse mathCourse;

	@Autowired
	EnglishCourse englishCourse;

	@Autowired
	StatisticsCourse statisticsCourse;

	public void attendClasses() {

		//Parameters
		int number = 7;
		String stringNumber = "16";
		List<Double> numericArray = Arrays.asList(2.68, 9.58, 4.39, 7.0);
		String word = "Experiment";
		String palindromeWord = "Tenet";

		log.info("Classes are starting!");

		//Math
		log.info("----- Math Class -----");
		log.info("Prime number " + number + ": " + mathCourse.getPrimeNumber(number));
		log.info("Fibonacci number " + number + ": " + mathCourse.getFibonacciNumber(number));
		log.info("Sort array [7, 5, 4, 19.5, -4.2]: " + mathCourse.sortNumericArray(numericArray));
		log.info("Square root of string number " + stringNumber + ": " + mathCourse.getSquareRootFromString(stringNumber));

		//English
		log.info("----- English Class -----");
		log.info("Vowels from word '" + word + "': " + englishCourse.getVowels(word));
		log.info("Is word '" + word + "' palindrome?: " + englishCourse.isPalindrome(word));
		log.info("Is word '" + palindromeWord + "' palindrome?: " + englishCourse.isPalindrome(palindromeWord));
		log.info("Substring of word '" + word + "' and number " + number + ": " + englishCourse.getSubstring(word, number));

		//Statistics
		log.info("----- Statistics Class -----");
		log.info("Employees map: " + statisticsCourse.getEmployeesMap());
		log.info("Employees aged between 30-40: " + statisticsCourse.getMiddleAgedEmployees());
		log.info("Employees who joind since 01-04-2018 sorted: " + statisticsCourse.getNewcomers());
	}

}
