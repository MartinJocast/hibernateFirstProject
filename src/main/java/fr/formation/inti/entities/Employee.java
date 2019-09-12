package fr.formation.inti.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

	private int empID;
	private String firstName; 
	private String lastName;
	private Date startDate;
	private Date endDate;
	private String title;
	private Department dept;
	private Employee manager;
	private Set<Employee> employees = new HashSet<Employee>();
	
	public Employee() {
		super();
	}

	public Employee(int empID, String firstName, String lastName, Date startDate, String title, Department dept, Employee manager) {
		super();
		this.empID = empID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.startDate = startDate;
		this.title = title;
		this.dept = dept;
		this.manager = manager;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
	@Column(name = "EMP_ID") // assure la correspondance avec sql
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}

	@Column(name = "FIRST_NAME", length = 20, nullable = false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME", length = 20, nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "START_DATE", nullable = false)
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "TITLE", length = 20)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@ManyToOne(fetch = FetchType.LAZY) //chargement paresseux: ce qu'on veut quand il faut
	@JoinColumn(name = "DEPT_ID", nullable = true)
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPERIOR_EMP_ID", nullable = true)
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "manager")
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", firstName=" + firstName + ", lastName=" + lastName + ", startDate="
				+ startDate + ", title=" + title + "]";
	}
}
