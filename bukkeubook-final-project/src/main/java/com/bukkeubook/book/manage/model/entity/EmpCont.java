package com.bukkeubook.book.manage.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "TBL_EMP_CONT")
@SequenceGenerator(
		name = "CONT_SEQ_GENERATOR",
		sequenceName = "SEQ_CONT_NO",
		initialValue = 1,
		allocationSize = 1
		)
public class EmpCont implements Serializable{

	private static final long serialVersionUID = 2280854708427407012L;

	/* DB 자료형 */
	
//	CONT_NO			NUMBER				근로계약번호
//	CONT_NAME		NVARCHAR2(63 CHAR)	계약서명
//	CONT_DATE		DATE				개시일
//	CONT_WRITER		NVARCHAR2(31 CHAR)	작성자
//	CONT_EXP_DATE	DATE				만료일
//	EMP_NO			NUMBER				사원번호
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "CONT_SEQ_GENERATOR"
	)
	@Column(name = "CONT_NO")
	private int contNo;
	
	@Column(name = "CONT_NAME")
	private String contName;
	
	@Column(name = "CONT_DATE")
	private java.sql.Date contDate;
	
	@Column(name = "CONT_WRITER")
	private String contWriter;
	
	@Column(name = "CONT_EXP_DATE")
	private java.sql.Date contExpDate;
	
	@Column(name = "EMP_NO")
	private int empNo;

	public EmpCont() {
	}

	public EmpCont(int contNo, String contName, Date contDate, String contWriter, Date contExpDate, int empNo) {
		this.contNo = contNo;
		this.contName = contName;
		this.contDate = contDate;
		this.contWriter = contWriter;
		this.contExpDate = contExpDate;
		this.empNo = empNo;
	}

	public int getContNo() {
		return contNo;
	}

	public void setContNo(int contNo) {
		this.contNo = contNo;
	}

	public String getContName() {
		return contName;
	}

	public void setContName(String contName) {
		this.contName = contName;
	}

	public java.sql.Date getContDate() {
		return contDate;
	}

	public void setContDate(java.sql.Date contDate) {
		this.contDate = contDate;
	}

	public String getContWriter() {
		return contWriter;
	}

	public void setContWriter(String contWriter) {
		this.contWriter = contWriter;
	}

	public java.sql.Date getContExpDate() {
		return contExpDate;
	}

	public void setContExpDate(java.sql.Date contExpDate) {
		this.contExpDate = contExpDate;
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
		return "EmpCont [contNo=" + contNo + ", contName=" + contName + ", contDate=" + contDate + ", contWriter="
				+ contWriter + ", contExpDate=" + contExpDate + ", empNo=" + empNo + "]";
	}
}