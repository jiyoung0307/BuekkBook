package com.bukkeubook.book.manage.model.entity;

import java.io.Serializable;

public class MemberRole2 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6200272624199468495L;

	private int roleCode;
	private int empNo;
	public MemberRole2() {
	}
	public MemberRole2(int roleCode, int empNo) {
		this.roleCode = roleCode;
		this.empNo = empNo;
	}
	public int getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(int roleCode) {
		this.roleCode = roleCode;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "MemberRole2 [roleCode=" + roleCode + ", empNo=" + empNo + "]";
	}
	
	
	
}
