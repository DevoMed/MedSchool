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
import com.example.MedSchool.entities.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {
	
	@Query(value = "select  * from  teachers  where (first_name =?1) "
			+ "and (active = 1) order by (first_name)", nativeQuery = true)
	public List<Teacher> findByfname(String firstName);

	@Query(value = "select * from teachers  where last_name like ?1% "
			+ "and active = 1 order by first_name", nativeQuery = true)
	public List<Teacher> findBylname(String lastName);
	
	public List<Teacher> findByBirthdayDateBetween(Date d1, Date d2);
	
	@Query(value = "select  * from  teachers  where active = 1 "
			+ "order by first_name", nativeQuery = true)
	public List<Teacher> AllTeachers();



}
