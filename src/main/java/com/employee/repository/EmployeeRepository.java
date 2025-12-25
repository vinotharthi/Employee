package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value = "SELECT * FROM employee_details.emp_table WHERE name=?", nativeQuery = true)
	public List<Employee> getByDept(String dept);
	
	@Query(value="SELECT * FROM  employee_details.emp_table WHERE salary >30000",nativeQuery = true)
	public List<Employee> getmaxd();
	
	@Query(value="SELECT * FROM employee_details.emp_table WHERE salary like '4%'",nativeQuery = true)
	public List<Employee> getfor();
	
	@Query(value="select name,sum(salary)as emp_salary from employee_details.emp_table group by name",nativeQuery = true)
	public List<String> gethigh();
	@Query(value="UPDATE employee_details.emp_table SET salary=salary+salary*0.10",nativeQuery = true)
	public List<Employee> getquery();
	//----------------------------------JPQL--------------------------------------------------
	@Query(value="select e from Employee e  order by e.salary asc")
	public List<Employee> getlow();
	@Query(value="select e from Employee e where e.name = :name")
	public List<Employee> getent(String name);
	@Query(value="select s.name,sum(s.salary) from Employee s group by s.name")
	public List<String>getemp();
	@Query(value="select s.name,sum(s.salary) from Employee s group by s.name having count(s.salary)>1")
	public List<String> getsal();
	@Query(value="select s from Employee s where str(s.salary) like concat ('4%') ")
	public List<Employee> getlike(); 
//must be concat and like string return in jpql using typecast	
//   @Query(value="select s from Employee s where s.salary like concat ('4','%') ")
//   public List<Integer> getlike();

//---------------------------------------Exception--------------------------------------------	
	@Query(value = "SELECT * FROM employee_details.emp_table WHERE id=?", nativeQuery = true)		
	public List<Employee> getexcp(int id);

	@Query(value = "SELECT * FROM employee_details.emp_table WHERE name=?", nativeQuery = true)		
	public List<Employee> getnameexc(String name);
	
	@Query(value = "SELECT * FROM employee_details.emp_table WHERE salary=?", nativeQuery = true)		
	public List<Employee> getsalexc(int name);

	
	
	
	
	
}