package com.onesoft.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value = "select * from employee where name like ?", nativeQuery = true)
	public List<Employee> getEmpName(String name);

	@Query(value = "select * from employee where gender like ?", nativeQuery = true)
	public List<Employee> getEmpGender(String gender);

	@Query(value = "select * from employee where age = ?", nativeQuery = true)
	public List<Employee> getEmpAge(int age);

	@Query(value = "select * from employee where salary =?", nativeQuery = true)
	public List<Employee> getEmpSalary(int salary);

	@Query(value = "select * from employee order by name", nativeQuery = true)
	public List<Employee> sortAsc();

	@Query(value = "select * from employee order by name desc", nativeQuery = true)
	public List<Employee> sortdes();

	@Query(value = "select max(salary) as maxsalary from employee", nativeQuery = true)
	public List<Integer> getmaxsalary();

	@Query(value = "select min(salary) as minsalary from employee", nativeQuery = true)
	public List<Integer> getMin();

	@Query(value = "SELECT min(SALARY) FROM Employee WHERE SALARY > (SELECT min(SALARY) FROM Employee)", nativeQuery = true)
	public List<Integer> getMinimum();

	@Query(value = "select max(salary) from employee where salary<(select max(salary) from employee)", nativeQuery = true)
	public List<Integer> getMaximum();

	@Query(value = "select max(age) as maxage  from employee", nativeQuery = true)
	public List<Integer> maxAge();

	@Query(value = "select min(age) as minage  from employee", nativeQuery = true)
	public List<Integer> minAge();

	@Query(value = "select id,name,age,gender,salary from employee where salary = (select max(salary) from employee)", nativeQuery = true)
	public List<Employee> getmaxdetail();

	@Query(value = "select id,name,age,gender,salary from employee where salary = (select min(salary) from employee)", nativeQuery = true)
	public List<Employee> getmindetail();

	@Query(value = "select * from employee where salary = (select max(salary) from employee where salary < (select max(salary) from employee)) ", nativeQuery = true)
	public List<Employee> getsecmaxdetail();

	@Query(value = "select * from employee where salary >= ? and salary <= ?", nativeQuery = true)
	public List<Employee> getemprange(int a,int b);
	
	@Query(value = "select * from employee where age = ?", nativeQuery = true)
	public List<Employee> getAge(int age);


}
