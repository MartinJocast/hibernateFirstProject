package fr.formation.inti.dao;

import java.util.List;

import fr.formation.inti.entities.Employee;

public interface IEmployeeDao {
	
	public void closeSession();
	
	public Employee getByID(Integer id);
	
	public List<Employee> getAll();
	
	public Integer saveEmployee(Employee e);
	
	public void updateEmployee(Employee e);
	
	public void delete(Employee e);
	
	public void deleteById(Integer id);
	
	public void deleteRangeId(Integer idMin, Integer idMax);

}
