package pt.primeit.coachingclass.domain;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pt.primeit.coachingclass.enums.Department;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Comparable<Employee> {

	private String name;

	private int id;

	private int age;

	private double salary;

	private Department dept;

	private LocalDate dateOfJoining;

	@Override
	public String toString() {

		return "\n\n----- Employee -----"
				+ "\nname: " + name
				+ "\nid: " + id
				+ "\nage: " + age
				+ "\nsalary: " + salary
				+ "\ndept: " + dept
				+ "\ndate of joining: " + dateOfJoining
				+ "\n";
	}

	@Override
	public int compareTo(Employee o) {

		return this.getName().compareTo(o.getName());
	}

}
