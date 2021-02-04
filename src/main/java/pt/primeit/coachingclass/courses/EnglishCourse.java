package pt.primeit.coachingclass.courses;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import lombok.extern.slf4j.Slf4j;
import pt.primeit.coachingclass.enums.Vowels;

@Service
@Validated
@Slf4j
public class EnglishCourse {

	@Autowired
	private MessageSource messageSource;

	public List<Character> getVowels(@NotEmpty String word) {

		return word
				.codePoints()
				.mapToObj(c -> (char) c)
				.filter(Vowels::isVowel)
				.collect(Collectors.toList());
	}

	public boolean isPalindrome(@NotEmpty String word) {

		String reverseWord = new StringBuilder(word).reverse().toString();

		return reverseWord.equalsIgnoreCase(word);
	}

	public String getSubstring(@NotEmpty String word, @Min(0) Integer number) {

		return word.substring(0, number);
	}

}
