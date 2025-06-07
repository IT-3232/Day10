package lk.ac.vau.fas.ict.repo;

import lk.ac.vau.fas.ict.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

    // Query 01 Get all department names 
    @Query("SELECT d.name FROM Department d")
    List<String> getDeptNames();

    // Query 02 Search departments by name using LIKE
    @Query("SELECT d FROM Department d WHERE d.name LIKE %:name%")
    List<Department> searchName(String name);

    // Query 03 Get the number of employees in a department
    @Query("SELECT COUNT(e) FROM Department d JOIN d.employees e WHERE d.id = :did")
    int numberofEmp(int did);
}
