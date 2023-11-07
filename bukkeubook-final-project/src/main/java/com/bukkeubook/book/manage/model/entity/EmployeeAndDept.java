package com.bukkeubook.book.manage.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_EMP")
public class EmployeeAndDept implements Serializable{

	private static final long serialVersionUID = 3203951350841492882L;
	
    @Id
    @Column(name = "EMP_NO")
    private int empNo;
    
    @Column(name = "EMP_NAME")
    private String empName;
    
    @Column(name = "EMP_JOB_CODE")
    private String empJobCode;
    
    @Column(name = "EMP_ENT_DATE")
    private java.sql.Date empEntDate;
    
    @Column(name = "EMP_END_DATE")
    private java.sql.Date empEndDate;
    
    @ManyToOne
    @JoinColumn(name = "DEPT_CODE")
    private Dept dept;

	public EmployeeAndDept() {
	}

	public EmployeeAndDept(int empNo, String empName, String empJobCode, Date empEntDate, Date empEndDate, Dept dept) {
		this.empNo = empNo;
		this.empName = empName;
		this.empJobCode = empJobCode;
		this.empEntDate = empEntDate;
		this.empEndDate = empEndDate;
		this.dept = dept;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpJobCode() {
		return empJobCode;
	}

	public void setEmpJobCode(String empJobCode) {
		this.empJobCode = empJobCode;
	}

	public java.sql.Date getEmpEntDate() {
		return empEntDate;
	}

	public void setEmpEntDate(java.sql.Date empEntDate) {
		this.empEntDate = empEntDate;
	}

	public java.sql.Date getEmpEndDate() {
		return empEndDate;
	}

	public void setEmpEndDate(java.sql.Date empEndDate) {
		this.empEndDate = empEndDate;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EmployeeAndDept [empNo=" + empNo + ", empName=" + empName + ", empJobCode=" + empJobCode
				+ ", empEntDate=" + empEntDate + ", empEndDate=" + empEndDate + ", dept=" + dept + "]";
	}
    
}
