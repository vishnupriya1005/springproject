package com.onesoft.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService empSer;

	@RequestMapping(value = "/addemp")
	public String addEmployee(@RequestBody Employee e) {
		return empSer.addEmployee(e);
	}

	@RequestMapping(value = "/addList")
	public String addEmployee(@RequestBody List<Employee> e) {
		return empSer.addEmployee(e);
	}

	@RequestMapping(value = "/getEmpById/{id}")
	public Employee getEmployeeById(@PathVariable int id) throws EmployeeNotFoundException {
		return empSer.getEmployeeById(id);
	}

	@RequestMapping(value = "/getList")
	public List<Employee> getEmployee() {
		return empSer.getEmployee();
	}

	@DeleteMapping(value = "/deleteById/{id}")
	public String deletebyId(@PathVariable int id) {
		return empSer.deleteById(id);
	}

	@PutMapping(value = "/updateemp/{id}")
	public String updateEmployee(@RequestBody Employee id) {
		return empSer.updateEmployee(id);
	}

	@GetMapping(path = "/getempbygender/{gender}")
	public List<Employee> getbygender(@PathVariable String gender) {
		return empSer.getbygender(gender);
	}

	@GetMapping(path = "/getempsal/{a}/{b}")
	public List<Employee> getbysal(@PathVariable int a, @PathVariable int b) {
		return empSer.getbysal(a, b);
	}

	@GetMapping(path = "/getname/{name}")
	public List<Employee> getname(@PathVariable String name) {
		return empSer.getname(name);
	}

//	@GetMapping(path = "getdetail/{age}")
//	public List<Employee> getage(@PathVariable int age) {
//		return empSer.getage(age);
//	}

//	@GetMapping(path = "getivanname/{name}")
//	public List<Employee> getEmpName(@PathVariable String name) {
//		return empSer.getEmpName(name);
//	}

	@GetMapping(path = "getivangender/{gender}")
	public List<Employee> getEmpGender(@PathVariable String gender) {
		return empSer.getEmpGender(gender);
	}

//	@GetMapping(path = "getivanage/{age}")
//	public List<Employee> getEmpAge(@PathVariable int age) {
//		return empSer.getEmpAge(age);
//	}

	@GetMapping(path = "getivansalary/{salary}")
	public List<Employee> getEmpSalary(@PathVariable int salary) {
		return empSer.getEmpSalary(salary);
	}

	@GetMapping(path = "getsortasc")
	public List<Employee> sortAsc() {
		return empSer.sortAsc();
	}

	@GetMapping(path = "getdes")
	public List<Employee> sortdes() {
		return empSer.sortdes();
	}

	@RequestMapping(path = "maxivansal")
	public List<Integer> getmaxsalary() {
		return empSer.getmaxsalary();
	}

	@GetMapping(value = "/getmin")
	public List<Integer> getMin() {
		return empSer.getMin();
	}

	@GetMapping(value = "/getmaximum")
	public List<Integer> getMaximum() {
		return empSer.getMaximum();
	}

	@GetMapping(value = "/getminimum")
	public List<Integer> getMinimum() {
		return empSer.getMinimum();
	}

	@GetMapping(value = "/maxage")
	public List<Integer> maxAge() {
		return empSer.maxAge();
	}

	@GetMapping(value = "/minage")
	public List<Integer> minAge() {
		return empSer.minAge();
	}
	@GetMapping(value="/getmaxdetail")
		public List<Employee> getmaxdetail(){
		return empSer.getmaxdetail();
	}
	@GetMapping(value="/getmindetail")
	public List<Employee> getmindetail(){
		return empSer.getmindetail();
	}
	@GetMapping(value="/getsecmaxdetail")
	public List<Employee> getsecmaxdetail(){
		return empSer.getsecmaxdetail();
	}
	@GetMapping(value="/getemprange/{a}/{b}")
	public List<Employee> getemprange(@PathVariable int a,@PathVariable int b){
		return empSer.getemprange(a,b);
	}
	@GetMapping(value="/getEmpRange/{a}/{b}")
	public List<Employee> getEmprange(@PathVariable int a,@PathVariable int b){
		return empSer.getEmprange(a,b);
	}
//	@GetMapping(path = "getivanname/{name}")
//	public List<Employee> getEmpName(@PathVariable String name) throws NameNotFoundException {
//		return empSer.getEmpName(name);
//	}
//	@GetMapping(path="getage/{age}")
//	public List<Employee> getAge(@PathVariable int age) throws AgeNotFoundException {
//		return empSer.getAge(age);
//	}
	@GetMapping(path = "getivanname/{name}")
	public List<Employee> getEmpName(@PathVariable String name) throws NameNotFoundException {
		return empSer.getEmpName(name);
	}
//	@PostMapping(path="getage")
//	public String getAge(@RequestBody Employee e) throws AgeNotFoundException{
//		return empSer.getAge(e);
//	}
}
