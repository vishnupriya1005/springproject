package com.StudentResults.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.StudentResults.Repository.StudentResultsRepository;

@Repository
public class StudentResultsDao {
@Autowired
StudentResultsRepository srRepo;
public String findResults() {
	return "saved successfully";
	
}
public String setResults() {
	return "saved successfully";
}
}
