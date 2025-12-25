package com.employee.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;
import com.employee.exception.IdNotFoundException;
import com.employee.exception.NameNotFoundException;
import com.employee.exception.SalaryNotFoundException;
import com.employee.repository.EmployeeRepository;

//import jdk.javadoc.internal.doclets.toolkit.util.Comparators;
@Service
public class EmployeeService {
	@Autowired
	EmployeeDao ed;
	public String postEmp(Employee e) {
		return ed.postEmp(e);
	}
	public List<Employee> postMul(List<Employee> r) {
	
		return ed.postMul(r);
	}
	public List<Employee> getmed() {
		// TODO Auto-generated method stub
		return ed.getmed();
	}
	public Employee getfind( int a) {
		return ed.getfind(a);
	}
	public String getdel(@PathVariable int b) {
		// TODO Auto-generated method stub
		return ed.getdel(b);
	}
	public String getupdate(Employee e, int c) {
		// TODO Auto-generated method stub
		return ed.getupdate(e,c);
	}
	public String getsingle(int d, Employee name) {
		// TODO Auto-generated method stub
		return ed.getsingle(d,name);
	}
	public List<Employee> getquery() {
		// TODO Auto-generated method stub
		return ed.getquery();
	}
	
	//-------------------------Streams Concept-------------------------------
	public List<String> getmeed() {
		// TODO Auto-generated method stub
		return ed.getmed().stream().filter(x->x.getSalary()>20000).map(x->x.getName()).collect(Collectors.toList());
	}
	public int getmdd(){
		return ed.getmed().stream().map(x->x.getSalary()).max(Comparable::compareTo).get();
	}
	public List<Integer> getname( String name) {
		// TODO Auto-generated method stub
		return ed.getmed().stream().filter(x->x.getName().equals(name)).map(x->x.getSalary()).collect(Collectors.toList());
	}
	public List<Employee> getsort(){
		return ed.getmed().stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
	}
	public List<Integer> getsorts(){
		return ed.getmed().stream().map(x->x.getSalary()).sorted().collect(Collectors.toList());
	}
	public Employee getmaxs() {
		return ed.getmed().stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().get();
	}
	public List<String>getdup(){
		return ed.getmed().stream().map(x->x.getName()).distinct().collect(Collectors.toList());
	}
	//------------------------------Query----------------------------------------------------
	public List<Employee> getmaxd() {
		// TODO Auto-generated method stub
		return ed.getmaxd();
	}
	public List<Employee> getfor(){
		return ed.getfor();
	}
	public List<String> gethigh(){
		return ed.gethigh();
	}
	public List<Employee> getlow(){
		return ed.getlow();
	}
	//------------------------------------jpql----------------------------------------------------
	public List<Employee> getent(String name){
		return ed.getent(name);
	}
	public List<String>getemp(){
		return ed.getemp();
	}
	public List<String> getsal(){
		return ed.getsal();
	}
	public List<Employee> getlike(){
		return ed.getlike();
	}
	
//------------------------------------------exception-----------------------------------------------
	public List<Employee> getexcp(int id) throws IdNotFoundException {
		if(ed.getexcp(id).isEmpty()) {
			
			throw new IdNotFoundException("load to success");
		}
		else {
			return ed.getexcp(id);

		}
	}
	public List<Employee> getnameexc(String name)  throws NameNotFoundException{
		if(ed.getnameexc(name).isEmpty()) {
			throw new NameNotFoundException("Name not inthe table");
		}
		else {
		return ed.getnameexc(name);
	}
	}
	
	public List<Employee> getsalexc(int salary) throws SalaryNotFoundException {
		if(ed.getsalexc(salary).isEmpty()) {
			throw new SalaryNotFoundException("Not in the Table");
		}
		else {
			return ed.getsalexc(salary);
		}
	}
	
	
	
	@Autowired
	EmployeeRepository er;
	public Employee getmax() {
		// TODO Auto-generated method stub
		//er.findAll();
		return er.findAll().stream().max(Comparator.comparing(Employee::getSalary)).get();
	}
	public List<Employee> getByDept(String dept) {
		// TODO Auto-generated method stub
		return er.getByDept(dept);
	}
	public Employee getnum() {
		// TODO Auto-generated method stub
		return er.findAll().stream().min(Comparator.comparing(Employee::getSalary)).get();
	}



}
