package com.Optimus.studentlaibraymangment.repository;

import com.Optimus.studentlaibraymangment.Enum.Gender;
import com.Optimus.studentlaibraymangment.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student , Integer> {

    List<Student> findByGender(Gender gender);
}
