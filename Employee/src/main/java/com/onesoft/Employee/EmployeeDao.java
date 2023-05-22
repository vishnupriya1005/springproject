package com.onesoft.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository empRepo;

	public String addEmployee(Employee e) {
		empRepo.save(e);
		return "Successfully saved";
	}

	public String addEmployee(List<Employee> e) {
		empRepo.saveAll(e);
		return "Succesfully saved";
	}

	public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
		
		return empRepo.findById(id).orElseThrow(()->new EmployeeNotFoundException());
	}

	public List<Employee> getEmployee() {
		return empRepo.findAll();
	}

	public String deleteById(int id) {
		empRepo.deleteById(id);
		return "Deleted successfully";
	}
	public String updateEmployee(Employee id) {
		empRepo.save(id);
		return "updated successfully";
	}
//	public List<Employee> getEmpName(String name){
//		return empRepo.getEmpName(name);
//	}
	public List<Employee> getEmpGender(String gender){
		return empRepo.getEmpGender(gender);
	}
//	public List<Employee> getEmpAge(int age){
//		return empRepo.getEmpAge(age);
//	}
	public List<Employee> getEmpSalary(int salary){
		return empRepo.getEmpSalary(salary);
	}
	public List<Employee> sortAsc(){
		return empRepo.sortAsc();
	}
	public List<Employee> sortdes() {
		return empRepo.sortdes();
	}
	public List<Integer> getmaxsalary() {
		return empRepo.getmaxsalary();
	}
	public List<Integer> getMin(){
		return empRepo.getMin();
	}
	
	public List<Integer> getMaximum(){
		return empRepo.getMaximum();
	}
	
	public List<Integer> getMinimum(){
		return empRepo.getMinimum();
	}
	
	public List<Integer> maxAge(){
		return empRepo.maxAge();
	}
	
	public List<Integer> minAge(){
		return empRepo.minAge();
	}
	public List<Employee> getmaxdetail(){
		return empRepo.getmaxdetail();
	}
	public List<Employee> getmindetail(){
		return empRepo.getmindetail();
	}
	public List<Employee> getsecmaxdetail(){
		return empRepo.getsecmaxdetail();
	}
	public List<Employee> getemprange(int a,int b){
		return empRepo.getemprange(a,b);
	}
	public List<Employee> getEmpName(String name) throws NameNotFoundException {
		if(empRepo.getEmpName(name).isEmpty()==true) {
			throw new NameNotFoundException();
		} else {
			return empRepo.getEmpName(name);
		}
	}
//	public List<Employee> getAge(int age) throws AgeNotFoundException{
//		if(empRepo.getAge(age).isEmpty()==true) {
//			throw new AgeNotFoundException();
//		} else {
//			return empRepo.getAge(age);
//			}
//	}
}
 
