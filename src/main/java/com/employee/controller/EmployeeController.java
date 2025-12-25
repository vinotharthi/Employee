package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.exception.IdNotFoundException;
import com.employee.exception.NameNotFoundException;
import com.employee.exception.SalaryNotFoundException;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping(value="/emp/api")
public class EmployeeController {
	@Autowired
	EmployeeService es;
	@PostMapping(value="/postSingleEmp")
	public String postEmp(@RequestBody Employee e) {
	return es.postEmp(e);
	}
	@PostMapping(value="/postMultiEmp")
	public List<Employee> postMul(@RequestBody List<Employee> r) {
		return es.postMul(r);
	}
	@GetMapping(value="/getMed")
	public List<Employee> getmed(){
		return es.getmed();
	}
	@GetMapping(value="/getFind/{a}")
	public Employee getfind(@PathVariable int a) {
		return es.getfind(a);
	}
	@GetMapping(value="/getDel/{b}")
	public String getdel(@PathVariable int b) {
		return es.getdel(b);
	}
	@PutMapping(value="/getUpdate/{c}")
	public String getupdate(@RequestBody Employee e,@PathVariable int c) {
		return es.getupdate(e,c);
	}
	@PatchMapping(value="/getSingle/{d}")
	public String getsingle(@PathVariable int d,@RequestBody Employee name) {
		return es.getsingle(d,name);
	}
	@PutMapping(value="/getQuery")
	public List<Employee> getquery() {
		return es.getquery();
	}
	//-------------------------------Streams--------------------------
	@GetMapping(value="/getMd")
	public List<String> getmeed() {
		return es.getmeed();
	}
	@GetMapping(value="/getMedd")
	public int getmdd() {
		return es.getmdd();
	}
	@GetMapping(value="/getNam/{name}")
	public List<Integer>getname(@PathVariable String name){
		return es.getname(name);
	}
	@GetMapping(value="/getSort")
	public List<Employee>getsort(){
		return es.getsort();
	}
	@GetMapping(value="/getSorts")
	public List<Integer> getsorts(){
		return es.getsorts();
	}
	@GetMapping(value="/getMaxx")
	public Employee getmax() {
		return es.getmax();
	}
	@GetMapping(value="/getSec")
	public Employee getmaxs() {
		return es.getmaxs();
	}
	@GetMapping(value="/getDup")
	public List<String>getdup(){
		return getdup();
	}
	@GetMapping("/getsum/{dept}")
	public List<Employee> getByDept(@PathVariable String dept){
		return es.getByDept(dept);
	}
	
//---------------------------------query------------------------------------------------	
	@GetMapping(value="/getMax")
	public List<Employee> getmaxd() {
		return es.getmaxd();
	}
	@GetMapping(value="/getFor")
	public List<Employee> getfor(){
		return es.getfor();
	}
	@GetMapping(value="/getHigh")
	public List<String> gethigh(){
		return es.gethigh();
	}
	@GetMapping(value="/getLow")
	public List<Employee> getlow(){
		return es.getlow();
	}
	
//--------------------------------jpql-------------------------------	
	@GetMapping(value="/getEnt/{name}")
	public List<Employee> getent(@PathVariable String name){
		return es.getent(name);
	}
	@GetMapping(value="/getEmp")
	public List<String>getemp(){
		return es.getemp();
	}
	@GetMapping(value="/getSal")
	public List<String> getsal(){
		return es.getsal();
	}
	@GetMapping(value="/getLike")
	public List<Employee> getlike(){
		return es.getlike();
	}
	
	//-------------------------------Exception--------------------------------------------------
	@GetMapping(value="/getExce/{id}")
	public List<Employee> getexcp(@PathVariable int id) throws IdNotFoundException{
		return es.getexcp(id);
	}
	@GetMapping(value="/getNameExc/{name}")
	public List<Employee> getnameexc(@PathVariable String name) throws NameNotFoundException{
		return es.getnameexc(name);
	}
	@GetMapping(value="/getSalExc/{salary}")
	public List<Employee> getsalexc(@PathVariable int salary) throws SalaryNotFoundException{
		return es.getsalexc(salary);
	}

}
