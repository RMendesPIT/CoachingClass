package pt.primeit.coachingclass.courses;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import lombok.extern.slf4j.Slf4j;
import pt.primeit.coachingclass.domain.Employee;
import pt.primeit.coachingclass.enums.Department;

@Service
@Validated
@Slf4j
public class StatisticsCourse {

	@Autowired
	private MessageSource messageSource;

	private List<Employee> employees;

	@Value("${courses.statistics.middleAgeLowerLimit}")
	private int MIDDLE_AGE_LOWER_LIMIT;

	@Value("${courses.statistics.middleAgeUpperLimit}")
	private int MIDDLE_AGE_UPPER_LIMIT;

	@Value("#{T(java.time.LocalDate).parse('${courses.statistics.newcomerDate}',T(java.time.format.DateTimeFormatter).ofPattern('${date.format.from.properties.file}'))}")
	private LocalDate NEWCOMER_DATE;

	public StatisticsCourse() throws ParseException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		employees = new ArrayList<>();

		employees.add(new Employee("John Adams", 1, 52, 3000, Department.SALES, LocalDate.parse("14-07-2015", formatter)));
		employees.add(new Employee("Claire Washington", 2, 43, 3000, Department.LEGAL, LocalDate.parse("14-07-2015", formatter)));
		employees.add(new Employee("Peter Cole", 3, 41, 2500, Department.IT, LocalDate.parse("01-01-2016", formatter)));
		employees.add(new Employee("Daisy Williams", 4, 37, 2200, Department.HR, LocalDate.parse("01-01-2017", formatter)));
		employees.add(new Employee("Bryan Collins", 5, 39, 2000, Department.IT, LocalDate.parse("19-02-2017", formatter)));
		employees.add(new Employee("Ryan Smith", 6, 35, 1900, Department.SALES, LocalDate.parse("14-07-2018", formatter)));
		employees.add(new Employee("Michelle Moore", 7, 31, 1700, Department.HR, LocalDate.parse("23-09-2018", formatter)));
		employees.add(new Employee("Robie Taylor", 8, 36, 2000, Department.LOGISTICS, LocalDate.parse("12-03-2020", formatter)));
		employees.add(new Employee("Arthur Jackson", 9, 31, 1600, Department.SALES, LocalDate.parse("09-06-2019", formatter)));
		employees.add(new Employee("Thomas Young", 10, 28, 1500, Department.IT, LocalDate.parse("24-10-2020", formatter)));

		log.info("Complete list of employees:\n" + employees);

	}

	public Map<Integer, String> getEmployeesMap() {

		return employees.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));
	}

	public Set<Employee> getMiddleAgedEmployees() {

		return employees.stream().filter(this::isMiddleAged).collect(Collectors.toSet());
	}

	private boolean isMiddleAged(@NotNull Employee employee) {

		int age = employee.getAge();
		return age >= MIDDLE_AGE_LOWER_LIMIT && age <= MIDDLE_AGE_UPPER_LIMIT;
	}

	public List<Employee> getNewcomers() {

		return getEmployeesJoinedAfterDate(sortEmployeeList(employees), NEWCOMER_DATE);
	}

	private List<Employee> sortEmployeeList(@NotEmpty List<Employee> employees) {

		// sorted() does not need parameters since Employee class implements Comparable interface
		return employees.stream().sorted().collect(Collectors.toList());
	}

	private List<Employee> getEmployeesJoinedAfterDate(@NotEmpty List<Employee> employees, @NotNull LocalDate date) {

		return employees.stream().filter(e -> e.getDateOfJoining().isAfter(date)).collect(Collectors.toList());
	}

}
