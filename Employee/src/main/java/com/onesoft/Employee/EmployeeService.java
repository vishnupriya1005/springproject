package com.onesoft.Employee;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empDao;

	public String addEmployee(Employee e) {
		return empDao.addEmployee(e);
	}

	public String addEmployee(List<Employee> e) {
		return empDao.addEmployee(e);
	}

	public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
		
		return empDao.getEmployeeById(id);
	}

	public List<Employee> getEmployee() {
		return empDao.getEmployee();
	}

	public String deleteById(int id) {
		return empDao.deleteById(id);
	}
	public String updateEmployee(Employee id) {
		return empDao.updateEmployee(id);
	}
	public List<Employee> getbygender(String gender){
		List<Employee> allEmp=empDao.getEmployee();
		return allEmp.stream().filter(i->i.getGender().equals(gender)).collect(Collectors.toList());
	}
	public List<Employee> getbysal(int a,int b){
		List<Employee> allEmp=empDao.getEmployee();
		return allEmp.stream().filter(i->i.getSalary()>=a && i.getSalary()<=b).collect(Collectors.toList());
		
	}
	public List<Employee> getname(String name){
		List<Employee> allEmp=empDao.getEmployee();
	return allEmp.stream().filter(i->i.getName().equals(name)).collect(Collectors.toList());
	}
//	public List<Employee> getage(int age){
//		List<Employee> allEmp=empDao.getEmployee();
//	return allEmp.stream().filter(i->i.getAge()==age).collect(Collectors.toList());	
//	}
//	public List<Employee> getEmpName(String name){
//		return empDao.getEmpName(name);
//	}
public List<Employee> getEmpGender(String gender){
	return empDao.getEmpGender(gender);
}
//public List<Employee> getEmpAge(int age){
//	return empDao.getEmpAge(age);
//}
public List<Employee> getEmpSalary(int salary){
	return empDao.getEmpSalary(salary);
}
public List<Employee> sortAsc(){
	return empDao.sortAsc();
}
public List<Employee> sortdes() {
	return empDao.sortdes();
}
	public List<Integer> getmaxsalary() {
	return empDao.getmaxsalary();
}
	public List<Integer> getMin(){
		return empDao.getMin();
	}
	
	public List<Integer> getMaximum(){
		return empDao.getMaximum();
	}
	
	public List<Integer> getMinimum(){
		return empDao.getMinimum();
	}
	
	public List<Integer> maxAge(){
		return empDao.maxAge();
	}
	public List<Integer> minAge(){
		return empDao.minAge();
	}
	public List<Employee> getmaxdetail(){
		return empDao.getmaxdetail();
	}
	public List<Employee> getmindetail(){
		return empDao.getmindetail();
	}
	public List<Employee> getsecmaxdetail(){
		return empDao.getsecmaxdetail();
	}
	public List<Employee> getemprange(int a,int b){
		return empDao.getemprange(a,b);
	}
	public List<Employee> getEmprange(int a,int b){
		List<Employee> getObj=empDao.getEmployee();
		List<Employee> getEmprange=getObj.stream().filter(x->x.getSalary()>=a && x.getSalary()<=b).toList();
		return getEmprange;
	}
//	public List<Employee> getEmpName(String name) throws NameNotFoundException {
//		return empDao.getEmpName(name);
//	}
//	public List<Employee> getAge(int age) throws AgeNotFoundException {
//		return empDao.getAge(age);
//	}
	public List<Employee> getEmpName(String name) throws NameNotFoundException {
		if(empDao.getEmpName(name).isEmpty()==true) {
			throw new NameNotFoundException();
		} else {
			return empDao.getEmpName(name);
		}
		
	}
//	public String getAge(Employee e) throws AgeNotFoundException {
//		if(e.getAge()<=18) {
//			throw new AgeNotFoundException();
//		}
//		return empDao.getAge();
//	}
	}

