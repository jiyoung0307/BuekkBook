package com.bukkeubook.book.books.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bukkeubook.book.manage.model.dto.EmpDTO;
import com.bukkeubook.book.manage.model.entity.Emp;

@Entity(name="RelListAndEmp")
@Table(name="TBL_REL_LIST")
public class RelListAndEmp implements Serializable{
//	REL_NO	NUMBER
//	REL_DATE	DATE
//	EMP_NO	NUMBER
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="REL_NO")
	private int relNo;				// 출고번호
	
	@Column(name="REL_DATE")
	private java.sql.Date relDate;	// 출고날짜
	
	@ManyToOne
	@JoinColumn(name="EMP_NO")
	private Emp emp;				// 사원번호

	public RelListAndEmp() {
	}

	public RelListAndEmp(int relNo, Date relDate, Emp emp) {
		this.relNo = relNo;
		this.relDate = relDate;
		this.emp = emp;
	}

	public int getRelNo() {
		return relNo;
	}

	public void setRelNo(int relNo) {
		this.relNo = relNo;
	}

	public java.sql.Date getRelDate() {
		return relDate;
	}

	public void setRelDate(java.sql.Date relDate) {
		this.relDate = relDate;
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
		return "RelListAndEmp [relNo=" + relNo + ", relDate=" + relDate + ", emp=" + emp + "]";
	}

	


	

	
	
	
}
