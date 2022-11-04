package com.example.MedSchool.repositories;
/**
 * 
 * @author Med Guennouni
 *
 */

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.MedSchool.entities.Subject;


@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {
	
	@Query(value = "select  * from  subjects  where active = 1 order by department", nativeQuery = true)
	public List<Subject> AllSubjets();

}
