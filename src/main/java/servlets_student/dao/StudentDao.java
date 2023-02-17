package servlets_student.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import servlets_student.dto.Student;

public class StudentDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}

	public void signupStudent(Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();

	}

	public void updateStudent(int id, Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Student newStudent = entityManager.find(Student.class, id);
		if (newStudent != null) {
			student.setId(id);
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();
		} else
			System.out.println("Student not found");
	}
	
	public Student loginStudent(int id)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Student student = entityManager.find(Student.class, id);
		return student;
	}
}
