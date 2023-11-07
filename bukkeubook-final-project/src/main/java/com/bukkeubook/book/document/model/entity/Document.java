package com.bukkeubook.book.document.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Document")
@Table(name = "TBL_DOCUMENT")
@SequenceGenerator(
		name = "DOCUMENT_SEQ_DOC_NO",
		sequenceName = "SEQ_DOC_NO",
		initialValue = 1,
		allocationSize = 1
)
public class Document {
	
//	DOC_NO	문서번호	NUMBER
//	EMP_NO	사원번호	NUMBER
//	DOC_TITLE	제목	VARCHAR2(500 BYTE)
//	TAG_CNT	태그내용	CLOB
//	CNT	작성내용	CLOB
//	WR_DATE	작성일자	DATE
//	DOC_STATUS	문서상태	VARCHAR2(30 BYTE)
//	FORM_NO	문서양식번호	NUMBER
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "DOCUMENT_SEQ_DOC_NO"
	)
	@Column(name = "DOC_NO")
	private int docNo1;
	
	@Column(name = "EMP_NO")
	private int empNo1;
	
	@Column(name = "DOC_TITLE")
	private String docTitle1;
	
	@Column(name = "TAG_CNT")
	@Lob
	private String tagCnt1;
	
	@Column(name = "CNT")
	@Lob
	private String cnt1;
	
	@Column(name = "WR_DATE")
	private String wrDate1;
	
	@Column(name = "DOC_STATUS")
	private String docStatus1;
	
	@Column(name = "FORM_NO")
	private int formNo1;

	public Document() {
		super();
	}

	public Document(int docNo1, int empNo1, String docTitle1, String tagCnt1, String cnt1, String wrDate1,
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

	@Override
	public String toString() {
		return "Document [docNo1=" + docNo1 + ", empNo1=" + empNo1 + ", docTitle1=" + docTitle1 + ", tagCnt1=" + tagCnt1
				+ ", cnt1=" + cnt1 + ", wrDate1=" + wrDate1 + ", docStatus1=" + docStatus1 + ", formNo1=" + formNo1
				+ "]";
	}

	
	
}
