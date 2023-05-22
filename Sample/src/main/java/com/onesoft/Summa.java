package com.onesoft;

//public class Summa {
//	 public class StudentAgeIsBelow18 extends Exception {
//		public StudentAgeIsBelow18(String val) {
//			super(val);
//		}

//	}
//	@RestControllerAdvice
//	public class StudentException {
//
//
//			@org.springframework.web.bind.annotation.ExceptionHandler(StudentAgeIsBelow18.class)
//			public ResponseEntity<Object> ageExceptionHandler(){
//				return new ResponseEntity<Object>("Below 18 age found",HttpStatus.BAD_REQUEST);
//			}
//	}
// @RestController
//	public class StudentController {
//		
//		@Autowired
//		StudentService studSer;
//		
//		@PostMapping(value ="/setStudent")
//		public String setStudent(@RequestBody List<Student> det) throws StudentAgeIsBelow18 {
//			return studSer.setStudent(det);
//		}
//
//	}
//	@Service
//	public class StudentService {
//
//		@Autowired
//		StudentDao studDao;
//
//		public String setStudent(List<Student> det) throws StudentAgeIsBelow18 {
//		
//			
//			List<Student> below18Age=det.stream().filter(x->x.getAge()<18).collect(Collectors.toList());
//			
//			if(below18Age.isEmpty()) {
//				return studDao.setStudent(det);
//			}
//			else {
//				throw new StudentAgeIsBelow18("Age error");
//			}
//			
//			
//
//		}
//			
//				
//	}
//	 @Repository
//	public class StudentDao {
//
//		@Autowired
//		StudentRepository studRepo;
//
//		public String setStudent(List<Student> det) throws StudentAgeIsBelow18 {
//			studRepo.saveAll(det);
//			return "Save Succesfully";
//		
//		}
//
//	}
// @RestController
//	public class StudentMarkSheetController {
//		
//		@Autowired 
//		StudentMarkSheetService stdSer;
//		
//		@PostMapping(value ="/setMark")
//		public String setMark(@RequestBody List<StudentMarkSheet> mark) {
//			return stdSer.setMark(mark);
//		}
//
//	}
//	
//	 @Service
//	public class StudentMarkSheetService {
//		@Autowired 
//		StudentMarkSheetDao stdDao;
//
//		public String setMark(List<StudentMarkSheet> mark) {
//			
//			for(StudentMarkSheet x : mark) {
//			int total1=	x.getSem1Practicals()+x.getSem1Theory();
//			x.setSem1Toatl(total1);
//			
//			int total2 = x.getSem2Practicals()+x.getSem2Theory();
//			x.setSem2Total(total2);
//			}
//			
//			return stdDao.setMark(mark) ;
//		}
//
//	}
//	 @Repository
//	public class StudentMarkSheetDao {
//		
//		@Autowired
//		StudentMarkSheetRepository stdRepo;
//		
//		public String setMark(List<StudentMarkSheet> mark) {
//			stdRepo.saveAll(mark);
//			
//			return "Save Successfully";
//		}
//
//	}
package com.student.results.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
import com.student.marksheet.entity.StudentMarkSheet;
import com.student.results.entity.ResultsEntity;
import com.student.results.services.ResultsServices;
import com.students.entity.Student;

@RestController
public class ResultsController {

	@Autowired
	RestTemplate rt;
	@Autowired
	ResultsServices rs;

	@PostMapping("/setResults")
	public String setResults(@RequestBody ResultsEntity res) {
		return rs.setResults(res);
	}

	@GetMapping("/getFinalMarks")
	public List<ResultsEntity> getFinalMarks() {
		return rs.getFinalMarks();
	}

	@GetMapping("/getFinalMarkByRoll/{roll}")
	public ResultsEntity getFinalMarkByRoll(@PathVariable int roll) {
		return rs.getFinalMarkByRoll(roll);
	}

	@GetMapping("/getTotalByRoll/{roll}")
	public int getTotalByRoll(@PathVariable int roll) {
		return rs.getTotalByRoll(roll);
	}

	@PutMapping("/updateByRoll/{roll}")
	public String updateByRoll(@RequestBody ResultsEntity a, @PathVariable int roll) {
		return rs.updateByRoll(a, roll);
	}

	@DeleteMapping("/deleteByid/{id}")
	public String deleteByid(@PathVariable int id) {
		return rs.deleteByid(id);
	}

	// Post in DataBase
	@PostMapping("/findResults")
	public String findResults() {
		String url1 = "http://localhost:8080/getStudentsDetails";
		ResponseEntity<List<Student>> studentResponse = rt.exchange(url1, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Student>>() {
				});
		List<Student> stDet = studentResponse.getBody();
		List<ResultsEntity> resultsDetails = new ArrayList<>();
		
		for (Student x : stDet) {
			String url2 = "http://localhost:8081/getMarkSheetDetailByRoll/";
			ResponseEntity<StudentMarkSheet> markResponse = rt.exchange(url2 + x.getRollNumber(), HttpMethod.GET, null,
					new ParameterizedTypeReference<StudentMarkSheet>() {});
			StudentMarkSheet marksheet = markResponse.getBody();
			int id=x.getId();
			int rollNumber = x.getRollNumber();
			String name = x.getName();
			int overAll = marksheet.getSem1Total() + marksheet.getSem2Total();
			int total = overAll / 2;
			int percentage = total;
			if (x.getAttendance() > 90) {
				total += 5;
				percentage = total;
				if (total > 100) {
					total = 100;
				}
			}
			Results resu = new Results();
			resu.setRollNumber(rollNumber);
			resu.setName(name);
			resu.setTotalMarks(total);
			resu.setPercentage(percentage);
			resultsDetails.add(resu);
			resultsDetails.add(resu);
		}
		return rs.findResults(resultsDetails); 
	}
	@GetMapping("/getTopper")
	public ResultsEntity getTopper() {
		String url1 = "http://localhost:8082/getFinalMarks";
		ResponseEntity<List<ResultsEntity>> resultsResponse = rt.exchange(url1, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ResultsEntity>>() {
				});
		List<ResultsEntity> allRes = resultsResponse.getBody();

		ResultsEntity topper = allRes.stream().max(Comparator.comparing(ResultsEntity::getTotalMarks)).get();
		return topper;

	}
	@GetMapping("/getThreeToppers")
	public List<ResultsEntity> getThreeToppers() {
		String url1 = "http://localhost:8082/getFinalMarks";
		ResponseEntity<List<ResultsEntity>> resultsResponse = rt.exchange(url1, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ResultsEntity>>() {
				});
		List<ResultsEntity> allRes = resultsResponse.getBody();

		List<ResultsEntity> topThree = allRes.stream()
				.sorted(Comparator.comparing(ResultsEntity::getTotalMarks).reversed()).limit(3)
				.collect(Collectors.toList());

		return topThree;
	}

	@GetMapping("/getStudentsByRange/{a}/{b}")
	public List<ResultsEntity> getStudentsByRange(@PathVariable int a, @PathVariable int b) {
		String url1 = "http://localhost:8082/getFinalMarks";
		ResponseEntity<List<ResultsEntity>> resultsResponse = rt.exchange(url1, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ResultsEntity>>() {
				});
		List<ResultsEntity> allRes = resultsResponse.getBody();
		

		List<ResultsEntity> byRange = allRes.stream().filter(x -> x.getTotalMarks() > a && x.getTotalMarks() < b)
				.collect(Collectors.toList());

	
		return byRange;
	}
	
	//

	@RestController
	public class ResultController {
		@Autowired
		RestTemplate rt;
		@Autowired
		ResultService rs;

		@PostMapping("/setAllResult")
		public String setAllResult() {
			String url1 = "http://localhost:8080/getstudentdetails";
			ResponseEntity<List<Student>> r1 = rt.exchange(url1, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Student>>() {
					});
			List<Student> b1=r1.getBody();
			String url2 = "http://localhost:8081/getmarksheetDetail";
			ResponseEntity<List<MarkSheet>> r2 = rt.exchange(url2, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<MarkSheet>>() {
					});
			List<MarkSheet> b2=r2.getBody();
			
			List<Results> res=new LinkedList<>();
			for(Student s: b1) {
				Results r= new Results();
				r.setName(s.getName());
				r.setRollnumber(s.getRollnumber());
				int attendance=s.getAttendance();
				int totalMarks=0;
				int percen=0;
				int sturoll=s.getRollnumber();
				for(MarkSheet m:b2) {
					int marroll=m.getRollnumber();
					if(sturoll==marroll) {
					 totalMarks=m.getSem1Total()+m.getSem2Total();
					}
					percen=totalMarks/12;
				}
				if(attendance>=90&&attendance<=95) {
					percen=percen+5;
				}
				else if(attendance==96) {
					percen=percen+4;
				}else if(attendance==97) {
					percen=percen+3;
				}else if(attendance==98) {
					percen=percen+2;
				}else if(attendance==99) {
					percen=percen+1;
				} 
				
						r.setTotalMarks(totalMarks);
						r.setPercentage(percen);
					  res.add(r);
				}
				
				return rs.setAllResult(res);
	}

//	
//}

		// done by pugazh sir in class
		
//		@PostMapping(value="/setResults")
//		public String setResults() {
//			String url1 = "http://localhost:8080/addStudentListDetails";
//			String url2="http://localhost:8082/addStudentMarkSheetList";
//			ResponseEntity<List<Students>> r1 = rt.exchange(url1, HttpMethod.POST, null,
//					new ParameterizedTypeReference<List<Students>>() {
//					});
//			List<Students> s = r1.getBody();
//			ResponseEntity<List<StudentMark>> r2=rt.exchange(url2,HttpMethod.POST,null,
//					new ParameterizedTypeReference<List<StudentMark>>() {});
//			List<StudentMark> m=r2.getBody();
//		for(int i=0;i<=s.size();i++) {
//			int id=s.get(i).getId();
//			String name=s.get(i).getName();
//			int rollNumber=s.get(i).getRollNumber();
//			int total=m.get(i).getSem1Total()+m.get(i).getSem2Total()/2;
//			if(s.get(i).getAttendance()>90) {
//				total=total+5;
//				if(total>100) {
//					total=100;
//				}
//				int percentage=total;
//				Results.add(new Results(id,rollNumber,name,total,percentage));
//			}
//		}
//		return srSer.setResults();
//		}	
//		}
	
		