package com.StudentResults.Controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.StudentResults.StudentMark;
import com.StudentResults.Students;
import com.StudentResults.Entity.Results;
import com.StudentResults.Service.StudentResultsService;

@RestController
public class StudentResultsController {
@Autowired
RestTemplate rt;
@Autowired
StudentResultsService resSer;

@PostMapping("/setResults")
public String setResults(@RequestBody Results res) {
	return resSer.setResults(res);
}

@GetMapping("/getFinalMarks")
public List<Results> getFinalMarks() {
	return resSer.getFinalMarks();
}

@GetMapping("/getFinalMarkByRoll/{rollNumber}")
public Results getFinalMarkByRoll(@PathVariable int rollNumber) {
	return resSer.getFinalMarkByRoll(rollNumber);
}

@PutMapping("/updateByRoll/{rollNumber}")
public String updateByRoll(@PathVariable Results rollNumber) {
	return resSer.updateByRoll(rollNumber);
}

@DeleteMapping("/deleteByid/{id}")
public String deleteByid(@PathVariable int id) {
	return resSer.deleteByid(id);
}

@PostMapping("/setAllResult")
public String setAllResult() {
	String url1 = "http://localhost:8080/getallbyid";
	ResponseEntity<List<Students>> r1 = rt.exchange(url1, HttpMethod.GET, null,
			new ParameterizedTypeReference<List<Students>>() {
			});
	List<Students> b1=r1.getBody();
	String url2 = "http://localhost:8081/getmarksheetDetail";
	ResponseEntity<List<StudentMark>> r2 = rt.exchange(url2, HttpMethod.GET, null,
			new ParameterizedTypeReference<List<StudentMark>>() {
			});
	List<StudentMark> b2=r2.getBody();
	
	List<Results> res=new ArrayList<>();
	for(Students s: b1) {
		Results sr= new StudentResults();
		sr.setName(s.getName());
		sr.setRollNumber(s.getRollNumber());
		int attendance=s.getAttendance();
		int totalMarks=0;
		int percent=0;
		int sturoll=s.getRollNumber();
		for(MarkSheet m:b2) {
			int marroll=m.getRollNumber();
			if(sturoll==marroll) {
			 totalMarks=m.getSem1Total()+m.getSem2Total();
		}
		percent=totalMarks/2;
		}
		if(attendance>=90) {
			percent=percent+5;	
			if(totalMarks>400) {
				totalMarks=400;
			}
		
		}
				sr.setTotalMarks(totalMarks);
				sr.setPercentage(percent);
			  res.add(sr);
		}
		
		return resSer.setAllResult(res);
}


@GetMapping("/getTopper")
public StudentResults getTopper() {
	String url1 = "http://localhost:8082/getFinalMarks";
	ResponseEntity<List<StudentResults>> resultsResponse = rt.exchange(url1, HttpMethod.GET, null,
			new ParameterizedTypeReference<List<StudentResults>>() {
			});
	List<StudentResults> allRes = resultsResponse.getBody();

	StudentResults topper = allRes.stream().max(Comparator.comparing(StudentResults::getTotalMarks)).get();
	return topper;

}


@GetMapping("/getThreeToppers")
public List<StudentResults> getThreeToppers() {
	String url1 = "http://localhost:8082/getFinalMarks";
	ResponseEntity<List<StudentResults>> resultsResponse = rt.exchange(url1, HttpMethod.GET, null,
			new ParameterizedTypeReference<List<StudentResults>>() {
			});
	List<StudentResults> allRes = resultsResponse.getBody();

	List<StudentResults> topThree = allRes.stream()
			.sorted(Comparator.comparing(StudentResults::getTotalMarks).reversed()).limit(3)
			.collect(Collectors.toList());

	return topThree;
}


@GetMapping("/getStudentsByRange/{a}/{b}")
public List<StudentResults> getStudentsByRange(@PathVariable int a, @PathVariable int b) {
	String url1 = "http://localhost:8082/getFinalMarks";
	ResponseEntity<List<StudentResults>> resultsResponse = rt.exchange(url1, HttpMethod.GET, null,
			new ParameterizedTypeReference<List<StudentResults>>() {
			});
	List<StudentResults> allRes = resultsResponse.getBody();
	

	List<StudentResults> range = allRes.stream().filter(x -> x.getTotalMarks() > a && x.getTotalMarks() < b)
			.collect(Collectors.toList());

		return range;
	
}
