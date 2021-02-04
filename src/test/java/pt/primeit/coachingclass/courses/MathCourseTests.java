package pt.primeit.coachingclass.courses;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import pt.primeit.coachingclass.CoachingClassTests;

public class MathCourseTests extends CoachingClassTests {

	@InjectMocks
	MathCourse mathCourse;

	@Test
	public void testPrimeNumberValid() {

		assertEquals(2, mathCourse.getPrimeNumber(1));
	}

	@Test
	public void testFibonacciNumberValid() {

		assertEquals(8, mathCourse.getFibonacciNumber(6));
	}

	@Test
	public void testSortNumericArrayValid() {

		List<Double> unordered = Arrays.asList(2.68, 9.58, 4.39, 7.0);
		List<Double> ordered = Arrays.asList(2.68, 4.39, 7.0, 9.58);
		assertEquals(ordered, mathCourse.sortNumericArray(unordered));
	}

	@Test
	public void testSquareRootFromStringValid() {

		assertEquals(5, mathCourse.getSquareRootFromString("25"));
	}

}
