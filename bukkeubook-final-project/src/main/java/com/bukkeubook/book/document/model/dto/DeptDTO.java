package com.bukkeubook.book.document.model.dto;

import java.io.Serializable;

public class DeptDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3884534154842400232L;
	private int deptCode;			// 부서코드
	private String deptName;		// 부서명
	private String deptRepPhone;	// 대표번호
	public DeptDTO() {
		super();
	}
	public DeptDTO(int deptCode, String deptName, String deptRepPhone) {
		super();
		this.deptCode = deptCode;
		this.deptName = deptName;
		this.deptRepPhone = deptRepPhone;
	}
	public int getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(int deptCode) {
		this.deptCode = deptCode;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptRepPhone() {
		return deptRepPhone;
	}
	public void setDeptRepPhone(String deptRepPhone) {
		this.deptRepPhone = deptRepPhone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "DeptDTO [deptCode=" + deptCode + ", deptName=" + deptName + ", deptRepPhone=" + deptRepPhone + "]";
	}
	
	

}
