package in.sp.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.sp.beans.Student;

@Configuration
public class SpringConfigFile {
	@Bean
	public Student stdId1() {
		Student std=new Student();
		std.setName("Aniket");
		std.setEmail("Aniket@Gmail.com");
		std.setRollno(103);
		return std;
	}
}
