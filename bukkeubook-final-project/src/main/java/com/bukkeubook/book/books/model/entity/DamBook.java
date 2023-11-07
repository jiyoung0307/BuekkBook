package com.bukkeubook.book.books.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_DAM_BOOK")
public class DamBook implements Serializable{ 

	private static final long serialVersionUID = -5965545469329989049L;

	/* DB 자료형(TBL_DAM_BOOK) */
//	BK_NO	VARCHAR2(100 BYTE)	도서코드
//	DAM_AMOUNT	NUMBER	훼손수량
	@Id
	@Column(name="BK_NO")
	private String bkNo;		// 도서코드
	
	@Column(name="DAM_AMOUNT", nullable=true)
	private int damAmount;	// 훼손수량

	public DamBook() {
	}

	public DamBook(String bkNo, int damAmount) {
		this.bkNo = bkNo;
		this.damAmount = damAmount;
	}

	public String getBkNo() {
		return bkNo;
	}

	public void setBkNo(String bkNo) {
		this.bkNo = bkNo;
	}

	public int getDamAmount() {
		return damAmount;
	}

	public void setDamAmount(int damAmount) {
		this.damAmount = damAmount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DamBook [bkNo=" + bkNo + ", damAmount=" + damAmount + "]";
	}

	

	

	
	
}
