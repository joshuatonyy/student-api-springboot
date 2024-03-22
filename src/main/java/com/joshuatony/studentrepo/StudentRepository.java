package com.joshuatony.studentrepo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findAllByGradeYear(Integer gradeYear);
    Optional<Student> findByEmail(String email);
}
