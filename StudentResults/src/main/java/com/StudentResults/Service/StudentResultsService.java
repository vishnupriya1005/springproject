package com.StudentResults.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.StudentResults.Dao.StudentResultsDao;

@Service
public class StudentResultsService {
@Autowired
StudentResultsDao srDao;
public String findResults() {
	return srDao.findResults();
}
public String setResults() {
	return srDao.setResults();
}
}
