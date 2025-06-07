package lk.ac.vau.fas.ict.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lk.ac.vau.fas.ict.model.Department;
import lk.ac.vau.fas.ict.service.DepartmentService;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
	@Autowired
	public DepartmentService service;
	
	//find all details of the department
	@GetMapping
	public ResponseEntity<List<Department>>getDepts(){
		return new ResponseEntity<List<Department>>
		(service.getDepts(),HttpStatus.OK);
	}
	
	//find particular department
	@GetMapping("/{id}")
	public ResponseEntity<Department> getDept(@PathVariable("id") int id) {
		return new ResponseEntity<Department>(service.getDept(id),HttpStatus.OK);
	}
	
    //find department names only using query 01
	@GetMapping("/names")
	public ResponseEntity<List<String>>getNames(){
		return new ResponseEntity<List<String>>
		(service.getDepartmentNames(),HttpStatus.OK);
	}

    //query 02 search department by name
	@GetMapping("/search/{nm}")
	public ResponseEntity<List<Department>>searchDepts(@PathVariable("nm") String name){
		return new ResponseEntity<List<Department>>
		(service.searchDepartmentByName(name),HttpStatus.OK);
	}

    //query 03
    @GetMapping("/empcount/{id}")
	public ResponseEntity<String> countEmp(@PathVariable("id") int id) {
		return new ResponseEntity<>(service.getEmpCount(id),HttpStatus.OK);
	}


	@PostMapping("/add")
	public ResponseEntity<String> addDept(@RequestBody Department department) {
		return new ResponseEntity<String>(service.addDept(department),HttpStatus.OK);
	}
	
	
}
