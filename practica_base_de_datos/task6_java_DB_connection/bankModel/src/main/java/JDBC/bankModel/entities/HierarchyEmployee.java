package JDBC.bankModel.entities;

import java.util.List;

public final class HierarchyEmployee {
	//private fields:
	private Employee subAlternEmployee;
	private List<Employee> employeeBossList;

	//Constructors:
	public HierarchyEmployee() {
		super(); 
	}

	public HierarchyEmployee(Employee subAlternEmployee, List<Employee> employeeBossList) {
		super();
		this.subAlternEmployee = subAlternEmployee;
		this.employeeBossList = employeeBossList;
	}

	//getters and setters:
	public Employee getSubAlternEmployee() {
		return subAlternEmployee;
	}

	public void setSubAlternEmployee(Employee subAlternEmployee) {
		this.subAlternEmployee = subAlternEmployee;
	}

	public List<Employee> getEmployeeBossList() {
		return employeeBossList;
	}

	public void setEmployeeBossList(List<Employee> employeeBossList) {
		this.employeeBossList = employeeBossList;
	}

	//ToString
	@Override
	public String toString() {
		return "HierarchyEmployee [subAlternEmployee=" + subAlternEmployee + ", \n employeeBossList=" + employeeBossList
				+ "]";
	}
	
}
