package org.example.project.repositories;

import org.example.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail (String email);
	@Query("SELECT u FROM User u WHERE u.role = 'student'")
	List<User> findAllByStudent();
	@Query("SELECT u FROM User u WHERE u.role = 'student' and u.department.id = ?1")
	List<User> findAllByStudentInDept(Long id);
	@Query("select u from User u where u.role = 'student' and u.id = ?1")
	List<User> searchStudentById(Long keyword);
	@Query("select u from User u where u.role = 'student' and u.id = ?1 and u.department.id = ?2")
	List<User> searchStudentByIdAndDeptId(Long keyword, Long keyword1);
	@Query("select u from User u where u.fullname like %?1%")
	List<User> searchStudentByName(String keyword);
	@Query("select COUNT(*) from User u where u.role = 'student' and u.department.id = ?1")
	Integer numberOfStudentsInDept(Long id);
	@Query("select COUNT(*) from User u where u.role = 'lecturer' and u.department.id = ?1")
	Integer numberOfStudentsInLecturer(Long id);

	@Query("SELECT u FROM User u WHERE u.role = 'lecturer' and u.department.id = ?1")
	List<User> findAllByLecturerInDept(Long id);
	@Query("SELECT u FROM User u WHERE u.role = 'lecturer'")
	List<User> findAllByLecturer();

	//@Query("select u from User u where u.role='student' and u.department.id = ?1 and u.id = ?2")
	//List<User> getStudent(Long id, Long userId, String fullName);
	@Query("SELECT u FROM User u WHERE u.role = 'student' AND u.department.id = :departmentId AND u.id = :userId AND u.fullname LIKE %:fullName%")
	List<User> getStudent(@Param("departmentId") Long departmentId, @Param("userId") Long userId, @Param("fullName") String fullName);


	@Query("select COUNT(*) from User u where u.role = 'student'")
	Integer numberOfAllStudents();
	@Query("select COUNT(*) from User u where u.role = 'lecturer'")
	Integer numberOfAllLecturers();
}
