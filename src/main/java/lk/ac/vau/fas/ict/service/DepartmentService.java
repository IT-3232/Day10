package lk.vau.fas.ict.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lk.vau.fas.ict.model.Department;
import lk.vau.fas.ict.repo.DepartmentRepo;


@Service
public class DepartmentService {

    private final DepartmentRepo departmentRepo;

    @Autowired
    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    // Get all departments
    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    // Get department by ID
    public Department getDepartmentById(Long depId) {
    	if(departmentRepo.findById(depId).isEmpty()) {
    		throw new EntityNotFoundException("Department Not Found");
    	}
        return departmentRepo.findById(depId).get();
    }
    
    public String addDepartment(Department department) {
    	if(departmentRepo.findById(department.getDepId()).isPresent()) {
    		throw new DuplicateKeyException("The department id is already available");
    	}
    	departmentRepo.save(department);
    	return "New department added";
    }
}
