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
import javax.persistence.Table;

@Entity(name = "TempDocList")
@Table(name = "TBL_DOCUMENT")
public class DocumentAndEmpAndFormCate {
	
	@Id
	@Column(name = "DOC_NO")
	private int docNo;
	
	@Column(name = "EMP_NO")
	private int empNo;
	
	@Column(name = "DOC_TITLE")
	private String docTitle;
	
	@Column(name = "TAG_CNT" , columnDefinition="CLOB")
	@Lob
	private String tagCnt;
	
	@Column(name = "CNT" , columnDefinition="CLOB")
	@Lob
	private String cnt;
	
	@Column(name = "WR_DATE")
	private java.sql.Date wrDate;
	
	@Column(name = "DOC_STATUS")
	private String docStatus;
	
	@Column(name = "FORM_NO")
	private int formNo;
	
	@ManyToOne
	@JoinColumn(name = "FORM_NO", insertable=false, updatable=false)
	private FormCate formCate;
	
	@ManyToOne
	@JoinColumn(name = "EMP_NO" , insertable=false, updatable=false)
	private Emp emp;

	public DocumentAndEmpAndFormCate() {
		super();
	}

	public DocumentAndEmpAndFormCate(int docNo, int empNo, String docTitle, String tagCnt, String cnt, Date wrDate,
			String docStatus, int formNo, FormCate formCate, Emp emp) {
		super();
		this.docNo = docNo;
		this.empNo = empNo;
		this.docTitle = docTitle;
		this.tagCnt = tagCnt;
		this.cnt = cnt;
		this.wrDate = wrDate;
		this.docStatus = docStatus;
		this.formNo = formNo;
		this.formCate = formCate;
		this.emp = emp;
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

	public FormCate getFormCate() {
		return formCate;
	}

	public void setFormCate(FormCate formCate) {
		this.formCate = formCate;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "DocumentAndEmpAndFormCate [docNo=" + docNo + ", empNo=" + empNo + ", docTitle=" + docTitle + ", tagCnt="
				+ tagCnt + ", cnt=" + cnt + ", wrDate=" + wrDate + ", docStatus=" + docStatus + ", formNo=" + formNo
				+ ", formCate=" + formCate + ", emp=" + emp + "]";
	}
	
	
}
