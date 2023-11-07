package com.bukkeubook.book.main.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "TBL_MEMBER_ROLE")
public class MemberRoleAndRole implements Serializable{
//	EMP_NO	NUMBER		사원번호
//	ROLE_CODE	NUMBER	권한코드
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EMP_NO")
	private int empNo;
	
	@Id
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "ROLE_CODE")
	private Role role;

	public MemberRoleAndRole() {
	}

	public MemberRoleAndRole(int empNo, Role role) {
		this.empNo = empNo;
		this.role = role;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MemberRoleAndRole [empNo=" + empNo + ", role=" + role + "]";
	}
	

	
	
	
    
}
