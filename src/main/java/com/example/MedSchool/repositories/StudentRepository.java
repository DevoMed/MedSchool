package com.example.MedSchool.repositories;
/**
 * 
 * @author Med Guennouni
 *
 */

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.MedSchool.entities.Student;





@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

	@Query(value = "select  * from  students  where (first_name =?1) "
			+ "and (active = 1) order by (first_name)", nativeQuery = true)
	public List<Student> findByfname(String firstName);

	@Query(value = "select * from students  where last_name like ?1% "
			+ "and active = 1 order by first_name", nativeQuery = true)
	public List<Student> findBylname(String lastName);
	
	//@Query(value = "select * from students  where birthday_date between '?1' and '?2'", nativeQuery = true)
	public List<Student> findByBirthdayDateBetween(Date d1, Date d2);
	
	@Query(value = "select  * from  students  where active = 1 "
			+ "order by first_name", nativeQuery = true)
	public List<Student> AllStudents();

}
