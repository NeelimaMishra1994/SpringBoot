package SpringBoot.crudDemoJPAHibernate.dao;

import java.util.List;

import SpringBoot.crudDemoJPAHibernate.entity.Student;

public interface StudentDAO {
void save(Student thestudent);//for create object in database
Student findById(Integer Id);
List<Student> findAll();
List<Student> findByLastName(String theLastName);
void update(Student theStudent);
void delete(Integer id);
int deleteAll();
}
