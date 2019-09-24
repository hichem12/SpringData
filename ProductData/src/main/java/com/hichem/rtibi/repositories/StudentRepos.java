package com.hichem.rtibi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hichem.rtibi.entities.Student;

public interface StudentRepos extends CrudRepository<Student, Long> {

}
