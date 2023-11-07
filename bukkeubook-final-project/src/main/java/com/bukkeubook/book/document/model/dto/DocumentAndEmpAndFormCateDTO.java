package com.bukkeubook.book.document.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class DocumentAndEmpAndFormCateDTO implements Serializable{
	
//	DOC_NO	문서번호	NUMBER
//	EMP_NO	사원번호	NUMBER
//	DOC_TITLE	제목	VARCHAR2(500 BYTE)
//	TAG_CNT	태그내용	CLOB
//	CNT	작성내용	CLOB
//	WR_DATE	작성일자	DATE
//	DOC_STATUS	문서상태	VARCHAR2(30 BYTE)
//	FORM_NO	문서양식번호	NUMBER
	
	private static final long serialVersionUID = -3088008793203223975L;
	private int docNo;
	private int empNo;
	private String docTitle;
	private String tagCnt;
	private String cnt;
	private java.sql.Date wrDate;
	private String docStatus;
	private int formNo;
	
	private EmpDTO emp;
	private FormCateDTO formCate;
	public DocumentAndEmpAndFormCateDTO() {
		super();
	}
	public DocumentAndEmpAndFormCateDTO(int docNo, int empNo, String docTitle, String tagCnt, String cnt, Date wrDate,
			String docStatus, int formNo, EmpDTO emp, FormCateDTO formCate) {
		super();
		this.docNo = docNo;
		this.empNo = empNo;
		this.docTitle = docTitle;
		this.tagCnt = tagCnt;
		this.cnt = cnt;
		this.wrDate = wrDate;
		this.docStatus = docStatus;
		this.formNo = formNo;
		this.emp = emp;
		this.formCate = formCate;
	}
	public int getDocNo() {
		return docNo;
	}
	public void setDocNo(int docNo) {
		this.docNo = docNo;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getDocTitle() {
		return docTitle;
	}
	public void setDocTitle(String docTitle) {
		this.docTitle = docTitle;
	}
	public String getTagCnt() {
		return tagCnt;
	}
	public void setTagCnt(String tagCnt) {
		this.tagCnt = tagCnt;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public java.sql.Date getWrDate() {
		return wrDate;
	}
	public void setWrDate(java.sql.Date wrDate) {
		this.wrDate = wrDate;
	}
	public String getDocStatus() {
		return docStatus;
	}
	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}
	public int getFormNo() {
		return formNo;
	}
	public void setFormNo(int formNo) {
		this.formNo = formNo;
	}
	public EmpDTO getEmp() {
		return emp;
	}
	public void setEmp(EmpDTO emp) {
		this.emp = emp;
	}
	public FormCateDTO getFormCate() {
		return formCate;
	}
	public void setFormCate(FormCateDTO formCate) {
		this.formCate = formCate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "DocumentAndEmpAndFormCateDTO [docNo=" + docNo + ", empNo=" + empNo + ", docTitle=" + docTitle
				+ ", tagCnt=" + tagCnt + ", cnt=" + cnt + ", wrDate=" + wrDate + ", docStatus=" + docStatus
				+ ", formNo=" + formNo + ", emp=" + emp + ", formCate=" + formCate + "]";
	}
	
	
}
