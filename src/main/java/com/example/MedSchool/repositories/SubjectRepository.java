package com.example.MedSchool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.MedSchool.entities.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {

}
