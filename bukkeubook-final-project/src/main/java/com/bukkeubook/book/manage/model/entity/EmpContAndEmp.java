package com.bukkeubook.book.manage.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "EmpContAndEmp")
@Table(name = "TBL_EMP_CONT")
@SequenceGenerator(
		name = "CONT_SEQ_GENERATOR",
		sequenceName = "SEQ_CONT_NO",
		initialValue = 1,
		allocationSize = 1
		)
public class EmpContAndEmp {
	
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
	
	@ManyToOne
	@JoinColumn(name = "EMP_NO")
	private Emp emp;

	public EmpContAndEmp() {
	}

	public EmpContAndEmp(int contNo, String contName, Date contDate, String contWriter, Date contExpDate, Emp emp) {
		this.contNo = contNo;
		this.contName = contName;
		this.contDate = contDate;
		this.contWriter = contWriter;
		this.contExpDate = contExpDate;
		this.emp = emp;
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

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "EmpContAndEmp [contNo=" + contNo + ", contName=" + contName + ", contDate=" + contDate + ", contWriter="
				+ contWriter + ", contExpDate=" + contExpDate + ", emp=" + emp + "]";
	}
	
	

}
