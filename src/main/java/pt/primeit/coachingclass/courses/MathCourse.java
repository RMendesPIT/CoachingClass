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
import pt.primeit.coachingclass.exception.NotPositiveNumber;

@Service
@Validated
@Slf4j
public class MathCourse {

	@Autowired
	private MessageSource messageSource;

	public int getPrimeNumber(@Min(1) int number) {

		int result = 1;

		for (int i = 0; i < number; i++) {
			result++;
			while (!isPrime(result)) {
				result++;
			}
		}

		return result;
	}

	private boolean isPrime(@Min(1) int number) {

		boolean isPrime = true;

		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				isPrime = false;
				break;
			}
		}

		return isPrime;
	}

	public int getFibonacciNumber(@Min(1) int number) {

		int result = 1;
		for (int i = 2, a = 1, b = 1, aux = 1; i < number; i++, aux = result, a = b, b = aux) {
			if (number < 3) {
				break;
			}

			result = a + b;
		}

		return result;
	}

	public List<Double> sortNumericArray(@NotEmpty List<Double> numbers) {

		return numbers.stream().sorted().collect(Collectors.toList());
	}

	public Double getSquareRootFromString(String number) {

		Integer result;

		try {
			result = Integer.decode(number);
		} catch (NumberFormatException e) {
			log.error("String paremeter " + number + "could not be parsed to Integer!");
			throw new NotPositiveNumber(messageSource);
		}

		return Math.sqrt(result);
	}

}
