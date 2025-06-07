package lk.vau.fas.ict.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.vau.fas.ict.model.Department;


public interface DepartmentRepo extends JpaRepository<Department, Long> {
}
