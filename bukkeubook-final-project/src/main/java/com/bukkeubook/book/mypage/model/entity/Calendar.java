package com.bukkeubook.book.mypage.model.entity;

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
@Table(name = "TBL_CALENDAR ")
@SequenceGenerator(
		name = "CAL_SEQ_GENERATOR",
		sequenceName = "SEQ_CAL_CODE",
		initialValue = 1,
		allocationSize = 1
		)
public class Calendar implements Serializable{

	private static final long serialVersionUID = -4097921945209946253L;
	
//	CAL_CODE	NUMBER
//	CAL_TITLE	NVARCHAR2(63 CHAR)
//	CAL_CONTENT	NVARCHAR2(255 CHAR)
//	CAL_START	DATE
//	CAL_END	DATE
//	EMP_NO	NUMBER
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "CAL_SEQ_GENERATOR"
	)
	@Column(name = "CAL_CODE")
	private int code;
	
	@Column(name = "CAL_TITLE")
	private String title;
	
	@Column(name = "CAL_CONTENT")
	private String content;
	
	@Column(name = "CAL_START")
	private java.sql.Date start;
	
	@Column(name = "CAL_END")
	private java.sql.Date end;
	
	@Column(name = "EMP_NO")
	private int empNo;

	public Calendar() {
	}

	public Calendar(int code, String title, String content, Date start, Date end, int empNo) {
		this.code = code;
		this.title = title;
		this.content = content;
		this.start = start;
		this.end = end;
		this.empNo = empNo;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public java.sql.Date getStart() {
		return start;
	}

	public void setStart(java.sql.Date start) {
		this.start = start;
	}

	public java.sql.Date getEnd() {
		return end;
	}

	public void setEnd(java.sql.Date end) {
		this.end = end;
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
		return "Calendar [code=" + code + ", title=" + title + ", content=" + content + ", start=" + start + ", end="
				+ end + ", empNo=" + empNo + "]";
	}
	
	
	
	
	

}
