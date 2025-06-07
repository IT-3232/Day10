package lk.vau.fas.ict.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long DepId;
	private String DName;

	@OneToMany(mappedBy = "department")
	@JsonManagedReference
	private List<Employee> employees;

	private String Location;

	public Department() {
	}

	public Department(Long DepId, String DName, String Location) {
		this.DepId = DepId;
		this.DName = DName;
		this.Location = Location;
	}

	public Department(Long DepId, String DName, List<Employee> employees, String location) {
		super();
		this.DepId = DepId;
		this.DName = DName;
		this.employees = employees;
		this.Location = location;
	}

	public Long getDepId() {
		return DepId;
	}

	public void setDepId(Long DepId) {
		this.DepId = DepId;
	}

	public String getDName() {
		return DName;
	}

	public void setDName(String DName) {
		this.DName = DName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String Location) {
		this.Location = Location;
	}

}
