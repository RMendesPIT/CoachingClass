package pt.primeit.coachingclass.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import pt.primeit.coachingclass.student.Student;

@Component
public class StudentRunner implements ApplicationRunner {

	@Autowired
	Student student;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		student.attendClasses();
	}

}
