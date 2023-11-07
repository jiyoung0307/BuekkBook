package com.bukkeubook.book.finance.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class ClientDTO implements Serializable{

	private static final long serialVersionUID = -6857726369628180171L;
	
	/* 
	 * DB 자료형
	 * 
	 * CNT_NO	NUMBER    거래처번호
		CNT_NAME	VARCHAR2(63 BYTE)    거래처이름
		CNT_REG_NO	VARCHAR2(31 BYTE)    사업자등록번호
		CNT_REP_NAME	NVARCHAR2(31 CHAR)    대표자명
		CNT_PHONE	VARCHAR2(15 BYTE)    전화번호
		CNT_EMAIL	VARCHAR2(31 BYTE)    이메일
		CNT_FAX	VARCHAR2(15 BYTE)    FAX
		CNT_START_DATE	DATE    등록날짜
		CNT_TRADE_YN	VARCHAR2(3 BYTE)    거래여부
		CNT_MANA_NAME	NVARCHAR2(31 CHAR)    담당자명
		CNT_MANA_PHONE	VARCHAR2(15 BYTE)    담당자연락처
		CNT_MANA_EMAIL	VARCHAR2(31 BYTE)    담당자이메일
		CNT_OPEN_DATE	DATE     개업일
		CNT_ADDRESS	NVARCHAR2(255 CHAR)    소재지
		CNT_CATE	NVARCHAR2(31 CHAR)    사업의종류
		CORP_REG_NO	VARCHAR2(31 BYTE)    법인등록번호
		CNT_TYPE	NVARCHAR2(31 CHAR)    업태
	 */
	private int cntNo;						// 거래처번호
	private String cntName;					// 거래처이름
	private String cntRegNo;				// 사업자등록번호
	private String cntRepName;				// 대표자명
	private String cntPhone;				// 전화번호
	private String cntEmail;				// 이메일
	private String cntFax;					// FAX
	private java.sql.Date cntStartDate;		// 등록날짜
	private String cntTradeYn;				// 거래여부
	private String cntManaName;				// 담당자명`
	private String cntManaPhone;			// 담당자연락처
	private String cntManaEmail;			// 담당자이메일
	private java.sql.Date cntOpenDate;		// 개업일
	private String cntAddress;				// 소재지
	private String cntCate;					// 사업의종류
	private String corpRegNo;				// 법인등록번호
	private String cntType;					// 업태
	
	public ClientDTO() {
	}
	
	public ClientDTO(int cntNo, String cntName, String cntRegNo, String cntRepName, String cntPhone, String cntEmail,
			String cntFax, Date cntStartDate, String cntTradeYn, String cntManaName, String cntManaPhone,
			String cntManaEmail, Date cntOpenDate, String cntAddress, String cntCate, String corpRegNo,
			String cntType) {
		this.cntNo = cntNo;
		this.cntName = cntName;
		this.cntRegNo = cntRegNo;
		this.cntRepName = cntRepName;
		this.cntPhone = cntPhone;
		this.cntEmail = cntEmail;
		this.cntFax = cntFax;
		this.cntStartDate = cntStartDate;
		this.cntTradeYn = cntTradeYn;
		this.cntManaName = cntManaName;
		this.cntManaPhone = cntManaPhone;
		this.cntManaEmail = cntManaEmail;
		this.cntOpenDate = cntOpenDate;
		this.cntAddress = cntAddress;
		this.cntCate = cntCate;
		this.corpRegNo = corpRegNo;
		this.cntType = cntType;
	}

	public int getCntNo() {
		return cntNo;
	}

	public void setCntNo(int cntNo) {
		this.cntNo = cntNo;
	}

	public String getCntName() {
		return cntName;
	}

	public void setCntName(String cntName) {
		this.cntName = cntName;
	}

	public String getCntRegNo() {
		return cntRegNo;
	}

	public void setCntRegNo(String cntRegNo) {
		this.cntRegNo = cntRegNo;
	}

	public String getCntRepName() {
		return cntRepName;
	}

	public void setCntRepName(String cntRepName) {
		this.cntRepName = cntRepName;
	}

	public String getCntPhone() {
		return cntPhone;
	}

	public void setCntPhone(String cntPhone) {
		this.cntPhone = cntPhone;
	}

	public String getCntEmail() {
		return cntEmail;
	}

	public void setCntEmail(String cntEmail) {
		this.cntEmail = cntEmail;
	}

	public String getCntFax() {
		return cntFax;
	}

	public void setCntFax(String cntFax) {
		this.cntFax = cntFax;
	}

	public java.sql.Date getCntStartDate() {
		return cntStartDate;
	}

	public void setCntStartDate(java.sql.Date cntStartDate) {
		this.cntStartDate = cntStartDate;
	}

	public String getCntTradeYn() {
		return cntTradeYn;
	}

	public void setCntTradeYn(String cntTradeYn) {
		this.cntTradeYn = cntTradeYn;
	}

	public String getCntManaName() {
		return cntManaName;
	}

	public void setCntManaName(String cntManaName) {
		this.cntManaName = cntManaName;
	}

	public String getCntManaPhone() {
		return cntManaPhone;
	}

	public void setCntManaPhone(String cntManaPhone) {
		this.cntManaPhone = cntManaPhone;
	}

	public String getCntManaEmail() {
		return cntManaEmail;
	}

	public void setCntManaEmail(String cntManaEmail) {
		this.cntManaEmail = cntManaEmail;
	}

	public java.sql.Date getCntOpenDate() {
		return cntOpenDate;
	}

	public void setCntOpenDate(java.sql.Date cntOpenDate) {
		this.cntOpenDate = cntOpenDate;
	}

	public String getCntAddress() {
		return cntAddress;
	}

	public void setCntAddress(String cntAddress) {
		this.cntAddress = cntAddress;
	}

	public String getCntCate() {
		return cntCate;
	}

	public void setCntCate(String cntCate) {
		this.cntCate = cntCate;
	}

	public String getCorpRegNo() {
		return corpRegNo;
	}

	public void setCorpRegNo(String corpRegNo) {
		this.corpRegNo = corpRegNo;
	}

	public String getCntType() {
		return cntType;
	}

	public void setCntType(String cntType) {
		this.cntType = cntType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ClientDTO [cntNo=" + cntNo + ", cntName=" + cntName + ", cntRegNo=" + cntRegNo + ", cntRepName="
				+ cntRepName + ", cntPhone=" + cntPhone + ", cntEmail=" + cntEmail + ", cntFax=" + cntFax
				+ ", cntStartDate=" + cntStartDate + ", cntTradeYn=" + cntTradeYn + ", cntManaName=" + cntManaName
				+ ", cntManaPhone=" + cntManaPhone + ", cntManaEmail=" + cntManaEmail + ", cntOpenDate=" + cntOpenDate
				+ ", cntAddress=" + cntAddress + ", cntCate=" + cntCate + ", corpRegNo=" + corpRegNo + ", cntType="
				+ cntType + "]";
	}
	
}
