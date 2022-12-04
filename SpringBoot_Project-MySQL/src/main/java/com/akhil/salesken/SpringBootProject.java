package com.akhil.salesken;

import com.akhil.salesken.entity.Student;
import com.akhil.salesken.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProject implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject.class, args);
	}

	@Autowired
	StudentRepo studentRepo;
	/**
	 * Callback used to run the bean.
	 *
	 * @param args incoming main method arguments
	 * @throws Exception on error
	 */
	@Override
	public void run(String... args) throws Exception {
//		Student one = new Student("Akhil", 75, 85, 95, 2);
//		studentRepo.save(one);
	}
}
