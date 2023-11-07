package com.bukkeubook.book.document.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "SubmitDocument")
@Table(name = "TBL_DOCUMENT")
@SequenceGenerator(
		name = "DOCUMENT_SEQ_DOC_NO",
		sequenceName = "SEQ_DOC_NO",
		initialValue = 1,
		allocationSize = 1
)
public class SubmitDocument {
	
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
	private int docNo2;
	
	@Column(name = "EMP_NO")
	private int empNo2;
	
	@Column(name = "DOC_TITLE")
	private String docTitle2;
	
	@Column(name = "TAG_CNT")
	@Lob
	private String tagCnt2;
	
	@Column(name = "CNT")
	@Lob
	private String cnt2;
	
	@Column(name = "WR_DATE")
	private String wrDate2;
	
	@Column(name = "DOC_STATUS")
	private String docStatus2;
	
	@Column(name = "FORM_NO")
	private int formNo2;

	public SubmitDocument() {
		super();
	}

	public SubmitDocument(int docNo2, int empNo2, String docTitle2, String tagCnt2, String cnt2, String wrDate2,
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

	@Override
	public String toString() {
		return "SubmitDocument [docNo2=" + docNo2 + ", empNo2=" + empNo2 + ", docTitle2=" + docTitle2 + ", tagCnt2="
				+ tagCnt2 + ", cnt2=" + cnt2 + ", wrDate2=" + wrDate2 + ", docStatus2=" + docStatus2 + ", formNo2="
				+ formNo2 + "]";
	}

	
	
}
