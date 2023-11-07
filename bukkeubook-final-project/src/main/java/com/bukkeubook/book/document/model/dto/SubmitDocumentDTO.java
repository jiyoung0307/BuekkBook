package com.bukkeubook.book.document.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class SubmitDocumentDTO implements Serializable{
//	DOC_NO	문서번호	NUMBER
//	EMP_NO	사원번호	NUMBER
//	DOC_TITLE	제목	VARCHAR2(500 BYTE)
//	TAG_CNT	태그내용	CLOB
//	CNT	작성내용	CLOB
//	WR_DATE	작성일자	DATE
//	DOC_STATUS	문서상태	VARCHAR2(30 BYTE)
//	FORM_NO	문서양식번호	NUMBER
	
	private static final long serialVersionUID = 2384618590532492639L;
	private int docNo2;
	private int empNo2;
	private String docTitle2;
	private String tagCnt2;
	private String cnt2;
	private String wrDate2;
	private String docStatus2;
	private int formNo2;
	public SubmitDocumentDTO() {
		super();
	}
	public SubmitDocumentDTO(int docNo2, int empNo2, String docTitle2, String tagCnt2, String cnt2, String wrDate2,
			String docStatus2, int formNo2) {
		super();
		this.docNo2 = docNo2;
		this.empNo2 = empNo2;
		this.docTitle2 = docTitle2;
		this.tagCnt2 = tagCnt2;
		this.cnt2 = cnt2;
		this.wrDate2 = wrDate2;
		this.docStatus2 = docStatus2;
		this.formNo2 = formNo2;
	}
	public int getDocNo2() {
		return docNo2;
	}
	public void setDocNo2(int docNo2) {
		this.docNo2 = docNo2;
	}
	public int getEmpNo2() {
		return empNo2;
	}
	public void setEmpNo2(int empNo2) {
		this.empNo2 = empNo2;
	}
	public String getDocTitle2() {
		return docTitle2;
	}
	public void setDocTitle2(String docTitle2) {
		this.docTitle2 = docTitle2;
	}
	public String getTagCnt2() {
		return tagCnt2;
	}
	public void setTagCnt2(String tagCnt2) {
		this.tagCnt2 = tagCnt2;
	}
	public String getCnt2() {
		return cnt2;
	}
	public void setCnt2(String cnt2) {
		this.cnt2 = cnt2;
	}
	public String getWrDate2() {
		return wrDate2;
	}
	public void setWrDate2(String wrDate2) {
		this.wrDate2 = wrDate2;
	}
	public String getDocStatus2() {
		return docStatus2;
	}
	public void setDocStatus2(String docStatus2) {
		this.docStatus2 = docStatus2;
	}
	public int getFormNo2() {
		return formNo2;
	}
	public void setFormNo2(int formNo2) {
		this.formNo2 = formNo2;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "SubmitDocumentDTO [docNo2=" + docNo2 + ", empNo2=" + empNo2 + ", docTitle2=" + docTitle2 + ", tagCnt2="
				+ tagCnt2 + ", cnt2=" + cnt2 + ", wrDate2=" + wrDate2 + ", docStatus2=" + docStatus2 + ", formNo2="
				+ formNo2 + "]";
	}
	
	
	
}
