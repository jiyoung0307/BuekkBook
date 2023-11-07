package com.bukkeubook.book.manage.model.dto;

public class SalaryEmpDTO {

	private int empTotalSal;
	private SalaryDTO salary;
	public SalaryEmpDTO() {
	}
	public SalaryEmpDTO(int empTotalSal, SalaryDTO salary) {
		this.empTotalSal = empTotalSal;
		this.salary = salary;
	}
	public int getEmpTotalSal() {
		return empTotalSal;
	}
	public void setEmpTotalSal(int empTotalSal) {
		this.empTotalSal = empTotalSal;
	}
	public SalaryDTO getSalary() {
		return salary;
	}
	public void setSalary(SalaryDTO salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "SalaryEmpDTO [empTotalSal=" + empTotalSal + ", salary=" + salary + "]";
	}
	
	
}
