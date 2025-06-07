package lk.ac.vau.fas.ict.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import lk.ac.vau.fas.ict.model.Department;
import lk.ac.vau.fas.ict.model.ViewDepartment;
import lk.ac.vau.fas.ict.repo.DepartmentRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepo repo;

	public List<Department> getDepts() {
		return repo.findAll();
	}

	public Department getDept(int id) {
		if (repo.findById(id).isEmpty()) {
			throw new EntityNotFoundException("Department Not Found");
		}
		return repo.findById(id).get();
	}

	//get department names form query 01
	public List<String> getDepartmentNames() {
		if (repo.getDeptNames().isEmpty()) {
			throw new EntityNotFoundException("Department Not Found");
		}
		return repo.getDeptNames();
	}

    //query 02
    public List<Department> searchDepartmentByName(String name) {
		if (repo.searchName(name).isEmpty()) {
			throw new EntityNotFoundException("Department Not Found");
		}
		return repo.searchName(name);
	}

   //query 03
   public String getEmpCount(int id) {
		if (repo.findById(id).isEmpty()) {
			throw new EntityNotFoundException("Department Not Found");
		}
		return "Number of employees: "+repo.numberofEmp(id);
	}


	public String addDept(Department department) {
		// before adding a department make sure that the department id is unique
		if (repo.findById(department.getId()).isPresent()) {
			throw new DuplicateKeyException("The department id is already available");
		}
		repo.save(department);
		return "New department added";
	}
	// update

	

	

	

	/*public ViewDepartment getEmpCountView(int id) {
		if (repo.findById(id).isEmpty()) {
			throw new EntityNotFoundException("Department Not Found");
		}
		Department department = repo.findById(id).get();
		ViewDepartment viewDepartment = new ViewDepartment(department.getId(), department.getName(),
				department.getEstablished(), getEmpCount(id));
		return viewDepartment;
	}*/
}
