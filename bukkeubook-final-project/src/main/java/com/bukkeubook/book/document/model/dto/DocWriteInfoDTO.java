package com.bukkeubook.book.document.model.dto;

import java.io.Serializable;

public class DocWriteInfoDTO implements Serializable{

	private static final long serialVersionUID = -6121451642891774445L;
	
	private String empName;
	private String deptName;
	private String empJobCode;
	private int docNo;
	public DocWriteInfoDTO() {
		super();
	}
	public DocWriteInfoDTO(String empName, String deptName, String empJobCode, int docNo) {
		super();
		this.empName = empName;
		this.deptName = deptName;
		this.empJobCode = empJobCode;
		this.docNo = docNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getEmpJobCode() {
		return empJobCode;
	}
	public void setEmpJobCode(String empJobCode) {
		this.empJobCode = empJobCode;
	}
	public int getDocNo() {
		return docNo;
	}
	public void setDocNo(int docNo) {
		this.docNo = docNo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "DocWriteInfoDTO [empName=" + empName + ", deptName=" + deptName + ", empJobCode=" + empJobCode
				+ ", docNo=" + docNo + "]";
	}
	

}
