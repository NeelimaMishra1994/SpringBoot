package SpringBoot.crudDemoJPAHibernate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import SpringBoot.crudDemoJPAHibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOIml implements StudentDAO  {

	//define field for entity manager
	private EntityManager entityManager;
	
	
	//inject entity manager using constructor 
	@Autowired
	public StudentDAOIml(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	//implement the save method
	@Override
	@Transactional
	public void save(Student thestudent) {
		entityManager.persist(thestudent);
		
	}
	@Override
	//No need to add Transactional since we are doing read query only.
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}
	@Override
	public List<Student> findAll() {
		//create Query
		//TypedQuery<Student> theQuery = entityManager.createQuery("From Student",Student.class);
		//return Query result
		//return theQuery.getResultList();
		TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by lastName",Student.class);
	    return theQuery.getResultList();
	}
	@Override
	public List<Student> findByLastName(String theLastName) {
		//create Query
		//set parameter
		//turn query results
		TypedQuery<Student> theQuery = entityManager.createQuery("From Student WHERE lastName=:theData",Student.class);
		theQuery.setParameter("theData", theLastName);
		return theQuery.getResultList();
	}
	@Override
	@Transactional
	public void update(Student theStudent) {
		entityManager.merge(theStudent);
	}
	@Override
	@Transactional
	public void delete(Integer id) {
		Student thestudent=entityManager.find(Student.class, id);
		entityManager.remove(thestudent);
		
	}
	@Override
	@Transactional
	public int deleteAll() {
		int numRowsDeleted =entityManager.createQuery("DELETE from Student").executeUpdate();
		return numRowsDeleted;
	}
	

}
