package com.bukkeubook.book.document.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "FormCate")
@Table(name = "TBL_FORM_CATE")
public class FormCate{

//	FORM_NO	NUMBER
//	FORM_NAME	NVARCHAR2(255 CHAR)
	
	@Id
	@Column(name = "FORM_NO")
	private int formNo;
	
	@Column(name = "FORM_NAME")
	private String formName;
	
	public FormCate() {
		super();
	}

	public FormCate(int formNo, String formName) {
		super();
		this.formNo = formNo;
		this.formName = formName;
	}

	public int getFormNo() {
		return formNo;
	}

	public void setFormNo(int formNo) {
		this.formNo = formNo;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	@Override
	public String toString() {
		return "FormCate [formNo=" + formNo + ", formName=" + formName + "]";
	}

	
	
	
}
