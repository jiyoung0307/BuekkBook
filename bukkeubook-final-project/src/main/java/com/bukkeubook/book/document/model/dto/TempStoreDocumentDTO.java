package com.bukkeubook.book.document.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class TempStoreDocumentDTO implements Serializable{
//	DOC_NO	문서번호	NUMBER
//	EMP_NO	사원번호	NUMBER
//	DOC_TITLE	제목	VARCHAR2(500 BYTE)
//	TAG_CNT	태그내용	CLOB
//	CNT	작성내용	CLOB
//	WR_DATE	작성일자	DATE
//	DOC_STATUS	문서상태	VARCHAR2(30 BYTE)
//	FORM_NO	문서양식번호	NUMBER
	
	private static final long serialVersionUID = 2384618590532492639L;
	private int docNo1;
	private int empNo1;
	private String docTitle1;
	private String tagCnt1;
	private String cnt1;
	private String wrDate1;
	private String docStatus1;
	private int formNo1;
	public TempStoreDocumentDTO() {
		super();
	}
	public TempStoreDocumentDTO(int docNo1, int empNo1, String docTitle1, String tagCnt1, String cnt1, String wrDate1,
			String docStatus1, int formNo1) {
		super();
		this.docNo1 = docNo1;
		this.empNo1 = empNo1;
		this.docTitle1 = docTitle1;
		this.tagCnt1 = tagCnt1;
		this.cnt1 = cnt1;
		this.wrDate1 = wrDate1;
		this.docStatus1 = docStatus1;
		this.formNo1 = formNo1;
	}
	public int getDocNo1() {
		return docNo1;
	}
	public void setDocNo1(int docNo1) {
		this.docNo1 = docNo1;
	}
	public int getEmpNo1() {
		return empNo1;
	}
	public void setEmpNo1(int empNo1) {
		this.empNo1 = empNo1;
	}
	public String getDocTitle1() {
		return docTitle1;
	}
	public void setDocTitle1(String docTitle1) {
		this.docTitle1 = docTitle1;
	}
	public String getTagCnt1() {
		return tagCnt1;
	}
	public void setTagCnt1(String tagCnt1) {
		this.tagCnt1 = tagCnt1;
	}
	public String getCnt1() {
		return cnt1;
	}
	public void setCnt1(String cnt1) {
		this.cnt1 = cnt1;
	}
	public String getWrDate1() {
		return wrDate1;
	}
	public void setWrDate1(String wrDate1) {
		this.wrDate1 = wrDate1;
	}
	public String getDocStatus1() {
		return docStatus1;
	}
	public void setDocStatus1(String docStatus1) {
		this.docStatus1 = docStatus1;
	}
	public int getFormNo1() {
		return formNo1;
	}
	public void setFormNo1(int formNo1) {
		this.formNo1 = formNo1;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "TempStoreDocumentDTO [docNo1=" + docNo1 + ", empNo1=" + empNo1 + ", docTitle1=" + docTitle1
				+ ", tagCnt1=" + tagCnt1 + ", cnt1=" + cnt1 + ", wrDate1=" + wrDate1 + ", docStatus1=" + docStatus1
				+ ", formNo1=" + formNo1 + "]";
	}
	
	
}
