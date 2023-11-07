package com.bukkeubook.book.main.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_ROLE")
public class Role implements Serializable{
//	ROLE_CODE	NUMBER				// 권한코드
//	ROLE_NAME	VARCHAR2(63 BYTE)	// 권한명
//	ROLE_DESC	VARCHAR2(255 BYTE)	// 권한설명
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ROLE_CODE")
	private int roleCode;
	
	@Column(name = "ROLE_NAME")
	private String roleName;
	
	@Column(name = "ROLE_DESC")
	private String roleDesc;

	public Role() {
	}

	public Role(int roleCode, String roleName, String roleDesc) {
		this.roleCode = roleCode;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
	}

	public int getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(int roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Role [roleCode=" + roleCode + ", roleName=" + roleName + ", roleDesc=" + roleDesc + "]";
	}
	
	
	
}
