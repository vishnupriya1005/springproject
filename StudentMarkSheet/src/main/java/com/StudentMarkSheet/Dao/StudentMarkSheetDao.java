package com.StudentMarkSheet.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.StudentMarkSheet.Entity.StudentMarkSheet;
import com.StudentMarkSheet.Repository.StudentMarkSheetRepository;

@Repository
public class StudentMarkSheetDao {
	@Autowired
	StudentMarkSheetRepository smsRepo;

	public String addStudentMarkSheetList(List<StudentMarkSheet> mark) {
		smsRepo.saveAll(mark);
		return "Saved all Details";
	}
}
