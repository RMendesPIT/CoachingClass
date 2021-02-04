package pt.primeit.coachingclass.courses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.mockito.InjectMocks;

import pt.primeit.coachingclass.CoachingClassTests;


public class EnglishCourseTests extends CoachingClassTests {

	@InjectMocks
	EnglishCourse englishCourse;

	@Test
	public void testVowelsValid() {

		assertEquals(Arrays.asList('o', 'e'), englishCourse.getVowels("Vowels"));
	}

	@Test
	public void testPalindromeTrue() {

		assertTrue(englishCourse.isPalindrome("Tenet"));
	}

	@Test
	public void testPalindromeFalse() {

		assertFalse(englishCourse.isPalindrome("Vowels"));
	}

	@Test
	public void testSubstringValid() {

		assertEquals("Te", englishCourse.getSubstring("Test", 2));
	}
}
