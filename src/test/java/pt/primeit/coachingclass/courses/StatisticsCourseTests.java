package pt.primeit.coachingclass.courses;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import pt.primeit.coachingclass.CoachingClassTests;

@ContextConfiguration(classes = StatisticsCourse.class)
@TestPropertySource("/application.properties")
public class StatisticsCourseTests extends CoachingClassTests {

	@InjectMocks
	StatisticsCourse statisticsCourse;

	@Test
	public void testEmployeesMap() {

		assertNotNull(statisticsCourse.getEmployeesMap());
	}

	@Test
	public void testMiddleAgedEmployees() {

		assertNotNull(statisticsCourse.getMiddleAgedEmployees());
	}
}
