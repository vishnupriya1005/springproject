package com.StudentDetails.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.StudentDetails.Entity.StudentDetails;
import com.StudentDetails.Service.StudentDetailsService;
import com.StudentDetails.Exceptions.AgeNotFoundException;

@RestController
public class StudentDetailsController {
	@Autowired
	StudentDetailsService stdSer;

	@PostMapping(value = "/addStudentDetails")
	public String addStudentDetails(@RequestBody StudentDetails sd) {
		return stdSer.addStudentDetails(sd);
	}

	@PostMapping(value = "/addStudentListDetails")
	public String addStudentListDetails(@RequestBody List<StudentDetails> sd) {
		return stdSer.addStudentListDetails(sd);
	}

	@PutMapping(value = "/updateStudentDetails/{id}")
	public String updateStudentDetails(@RequestBody StudentDetails id) {
		return stdSer.updateStudentDetails(id);
	}

	@PostMapping(value = "/getAge")
	public String getAge(@RequestBody List<StudentDetails> sd) throws AgeNotFoundException {
		return stdSer.getAge(sd);
	}
}
