package com.StudentResults.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentResults.Entity.Results;

public interface StudentResultsRepository extends JpaRepository<Results,Integer>{

}
