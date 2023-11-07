package com.bukkeubook.book.manage.model.entity;

import java.io.Serializable;
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

/* TBL_ATTEND 테이블에 매칭될 Attend 엔티티 클래스도 만들어 보기 */
@Entity
@Table(name = "TBL_ATTEND")
public class AttendAndEmp implements Serializable{


	
	/* DB 자료형 */
	
//	ATT_NO		NUMBER	근태번호
//	ATT_DATE	DATE	근무날짜
//	ATT_START	DATE	출근시간
//	ATT_END		DATE	퇴근시간
//	EMP_NO		NUMBER	사원번호
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -736212802742596368L;

	@Id
	@Column(name = "ATT_NO")
	private int attNo;
	
	@Column(name = "ATT_DATE")
	private java.sql.Date attDate;
	
	@Column(name = "ATT_START")
	private java.sql.Date attStart;
	
	@Column(name = "ATT_END")
	private java.sql.Date attEnd;
	
	@ManyToOne
	@JoinColumn(name = "EMP_NO")
	private Emp emp;

	public AttendAndEmp() {
	}

	public AttendAndEmp(int attNo, Date attDate, Date attStart, Date attEnd, Emp emp) {
		this.attNo = attNo;
		this.attDate = attDate;
		this.attStart = attStart;
		this.attEnd = attEnd;
		this.emp = emp;
	}

	public int getAttNo() {
		return attNo;
	}

	public void setAttNo(int attNo) {
		this.attNo = attNo;
	}

	public java.sql.Date getAttDate() {
		return attDate;
	}

	public void setAttDate(java.sql.Date attDate) {
		this.attDate = attDate;
	}

	public java.sql.Date getAttStart() {
		return attStart;
	}

	public void setAttStart(java.sql.Date attStart) {
		this.attStart = attStart;
	}

	public java.sql.Date getAttEnd() {
		return attEnd;
	}

	public void setAttEnd(java.sql.Date attEnd) {
		this.attEnd = attEnd;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AttendAndEmp [attNo=" + attNo + ", attDate=" + attDate + ", attStart=" + attStart + ", attEnd=" + attEnd
				+ ", emp=" + emp + "]";
	}
	
	

	

	
	

	
}	
