package com.example.MedSchool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.MedSchool.entities.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {

}
