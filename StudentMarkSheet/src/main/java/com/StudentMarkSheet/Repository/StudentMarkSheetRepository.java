package com.StudentMarkSheet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentMarkSheet.Entity.StudentMarkSheet;

public interface StudentMarkSheetRepository extends JpaRepository<StudentMarkSheet, Integer> {

}
