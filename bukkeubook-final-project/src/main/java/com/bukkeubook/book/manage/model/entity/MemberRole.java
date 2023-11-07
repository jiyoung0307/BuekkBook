package com.bukkeubook.book.manage.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_MEMBER_ROLE")
@IdClass(MemberRole2.class)
public class MemberRole implements Serializable{

//	ROLE_CODE	권한코드	NUMBER
//	EMP_NO	사원 번호	NUMBER
	
	private static final long serialVersionUID = 5322669545741093733L;

	@Id
	@Column(name = "ROLE_CODE")
	private int roleCode;
	
	@Id
	@Column(name = "EMP_NO")
	private int empNo;
	
	public MemberRole() {
	}
	public MemberRole(int roleCode, int empNo) {
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
	@Override
	public String toString() {
		return "MemberRole [roleCode=" + roleCode + ", empNo=" + empNo + "]";
	}
	
	
	
}
