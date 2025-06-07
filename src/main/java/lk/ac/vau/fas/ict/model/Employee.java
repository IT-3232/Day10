package lk.vau.fas.ict.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long EmpId;
    private String EmpName;
    private String Job;
    private double Salary;
    private Date DOB;

    @ManyToOne
    @JsonBackReference
    private Department department;
    public Employee() {}

    public Employee(Long empId, String empName, String job, double salary, Department department, Date dOB) {
        this.EmpId = empId;
        this.EmpName = empName;
        this.Job = job;
        this.Salary = salary;
        this.department = department;
        this.DOB = dOB;
    }

    public Long getEmpId() {
        return EmpId;
    }

    public void setEmpId(Long empId) {
        this.EmpId = empId;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        this.EmpName = empName;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        this.Job = job;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        this.Salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date dOB) {
        this.DOB = dOB;
    }
}
