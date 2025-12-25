package com.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Repository
public class EmployeeDao {

		@Autowired
		EmployeeRepository er;
		public String postEmp(Employee e) {
			er.save(e);
			return "Saved Successfully";
		}
		public List<Employee> postMul(List<Employee> r) {
			// TODO Auto-generated method stub
			//er.saveAll(r);
			return er.saveAll(r);
		}
		public List<Employee> getmed() {
			// TODO Auto-generated method stub
			//er.findAll();
			return er.findAll();
		}
		public Employee getfind(@PathVariable int a) {
			return er.findById(a).get();
		}
		public String getdel(@PathVariable int b) {
			// TODO Auto-generated method stub
			  er.deleteById(b);
			  return "Delete SuccessFully";
			 
		}
		public String getupdate(Employee e, int c) {
			// TODO Auto-generated method stub
			Employee x=er.findById(c).get();
			x.setName(e.getName());
			x.setSalary(e.getSalary());
			er.save(x);
			return "Updated";
		}
		public String getsingle(int d, Employee name) {
			// TODO Auto-generated method stub
			Employee n=er.findById(d).get();
			n.setName(name.getName());
			 er.save(n);
			 return "Patch Successfully";
		}
		
//---------------------------------Query-----------------------------------------------------		
		public List<Employee> getmaxd() {
			// TODO Auto-generated method stub
			return er.getmaxd();
		}
			public List<Employee> getfor(){
			return er.getfor();
		}
		public List<String> gethigh(){
			return er.gethigh();
		}
		public List<Employee> getlow(){
			return er.getlow();
		}
//--------------------------------------jpql----------------------------------------------------
		public List<Employee> getent(String name){
			return er.getent(name);
		}
		public List<String>getemp(){
			return er.getemp();
		}
		public List<String> getsal(){
			return er.getsal();
		}
		public List<Employee> getlike(){
			return er.getlike();
		}
		
		//-------------------------------Exception-------------------------------
		public List<Employee> getexcp(int id) {
			// TODO Auto-generated method stub
			 return er.getexcp(id);
		}
		public List<Employee> getnameexc(String name) {
			// TODO Auto-generated method stub
			return er.getnameexc(name);
		}
		public List<Employee> getsalexc(int salary) {
			// TODO Auto-generated method stub
			return er.getsalexc(salary);
		}
		public List<Employee> getquery() {
			// TODO Auto-generated method stub
			return er.getquery();
		}
		}
	

	
	

