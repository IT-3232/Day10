package lk.ac.vau.fas.ict.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ac.vau.fas.ict.model.Employee;
import lk.ac.vau.fas.ict.repo.EmployeeRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo repo;
	
	public List<Employee>searchSalary(int s,int e) {
		if(repo.findSalaryRange(s, e).isEmpty()) {
			throw new EntityNotFoundException("Employee Not Found");
		}
		return repo.findSalaryRange(s, e);
	}
}
