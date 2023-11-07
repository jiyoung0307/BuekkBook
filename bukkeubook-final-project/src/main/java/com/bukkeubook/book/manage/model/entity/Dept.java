package com.bukkeubook.book.manage.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/* TBL_DEPT 테이블에 매칭될 Dept 엔티티 클래스도 만들어 보기 */
/**
 * @author Jang
 *
 */
@Entity
@Table(name = "TBL_DEPT")
@SequenceGenerator(
		name = "DEPT_SEQ_GENERATOR",
		sequenceName = "SEQ_DEFT_CODE",
		initialValue = 6,
		allocationSize = 1
)
public class Dept implements Serializable {

	private static final long serialVersionUID = 541840903128253305L;

	/* DB 자료형 */
	
//	DEPT_CODE		NUMBER				부서코드
//	DEPT_NAME		NVARCHAR2(31 CHAR)	부서명
//	DEPT_REP_PHONE	VARCHAR2(15 BYTE)	대표번호
//	DEPT_ACTIVE		VARCHAR2(3 BYTE)	활성화여부	
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "DEPT_SEQ_GENERATOR"
	)
	@Column(name = "DEPT_CODE")
	private int deptCode;
	
	@Column(name = "DEPT_NAME")
	private String deptName;
	
	@Column(name = "DEPT_REP_PHONE")
	private String deptRepPhone;
	
	@Column(name = "DEPT_ACTIVE")
	private String deptActive;

	public Dept() {
	}

	public Dept(int deptCode, String deptName, String deptRepPhone, String deptActive) {
		this.deptCode = deptCode;
		this.deptName = deptName;
		this.deptRepPhone = deptRepPhone;
		this.deptActive = deptActive;
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

	public String getDeptActive() {
		return deptActive;
	}

	public void setDeptActive(String deptActive) {
		this.deptActive = deptActive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Dept [deptCode=" + deptCode + ", deptName=" + deptName + ", deptRepPhone=" + deptRepPhone
				+ ", deptActive=" + deptActive + "]";
	}

}

