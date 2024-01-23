package SpringBoot.crudDemoJPAHibernate;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import SpringBoot.crudDemoJPAHibernate.dao.StudentDAO;
import SpringBoot.crudDemoJPAHibernate.entity.Student;

@SpringBootApplication
public class CrudDemoJpaHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoJpaHibernateApplication.class, args);
	}
	@Bean
	   CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
			return runner ->{
				//createStudent(studentDAO);
				createMultipleStudents(studentDAO);
				//readStudent(studentDAO);
				//queryForStudent(studentDAO);
				//queryForStudentByLastName(studentDAO);
				//updateStudent(studentDAO);
				//deleteStudent(studentDAO);
				//deleteAllStudent(studentDAO);
			};
			
		}
	private void deleteAllStudent(StudentDAO studentDAO) {
		int numRowsDeleted =studentDAO.deleteAll();
		System.out.println("number of Rows Deleted:"+numRowsDeleted);
		
	}
	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object");
		Student tempStudent =new Student("Neelima","Mishra","neelimamishra@gmail.com");
		//save the student object
		System.out.println("saving the student");
		studentDAO.save(tempStudent);
		//display id of saved student
		System.out.println("Saved Student.Generate id:" +tempStudent.getId());
		
	}
	
	private void createMultipleStudents(StudentDAO studentDAO) {
		//create the student object
		//save the student object
		System.out.println("Creating new Mutltiple students object");
		Student tempStudent1 =new Student("Neelima","Mishra","neelimamishra@gmail.com");
		Student tempStudent2 =new Student("harish","khangar","khanhash@gmail.com");
		Student tempStudent3 =new Student("palak","elhance","palakelhance@gmail.com");
		System.out.println("saving the students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		//display id of saved student
		//System.out.println("Saved Student.Generate id:" +tempStudent1.getId());
	}
	
	private void readStudent(StudentDAO studentDAO) {
		//create the student object
		//save the student
		//display id of the saved student
		//retrieve student based on the id:primary key
		//display student
		Student tempstudent = new Student("John","Sen","sen@gmail.com");
		studentDAO.save(tempstudent);
		int theId= tempstudent.getId();
		System.out.println("saved student:" +theId);
		//retrieve student based on the id:primary key
		System.out.println("Retrving the student with id" +theId);
		Student myStudent = studentDAO.findById(theId);
		//display student
		System.out.println("found the student:" +myStudent);
	}
	private void queryForStudent(StudentDAO studentDAO) {
	    //get a list of student
		List<Student> thestudent= studentDAO.findAll();
		//display the list of student
		for(Student tempstudent:thestudent) {
			System.out.println(tempstudent);
		}
		
	}
	private void queryForStudentByLastName(StudentDAO studentDAO) {
		//get a list of student
		List<Student> thestudent= studentDAO.findByLastName("Mishra");
		//display the list of student
		for(Student tempstudent:thestudent) {
			System.out.println(tempstudent);
		}	
	}
	private void updateStudent(StudentDAO studentDAO) {
		//retreive student based on primary key
		//change the first name to "Scooby"
		//update the student
		//display the updated student
		int studentID=1;
		System.out.println("getting student with id:"+studentID);
		Student student = studentDAO.findById(studentID);
		System.out.println("updating the student....");
		student.setFirstName("Scooby");
		studentDAO.update(student);
		System.out.println("display:"+student);
	}
	private void deleteStudent(StudentDAO studentDAO) {
		int studentID=4;
		System.out.println("deleting student id:" +studentID);
		studentDAO.delete(studentID);
	}
	

}


