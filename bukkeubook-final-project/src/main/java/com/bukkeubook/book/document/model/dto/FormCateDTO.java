package com.bukkeubook.book.document.model.dto;

import java.io.Serializable;

public class FormCateDTO implements Serializable{

	private static final long serialVersionUID = -7436709052819924470L;

//	FORM_NO	NUMBER
//	FORM_NAME	NVARCHAR2(255 CHAR)
//	FORM_CONTENT	NVARCHAR2(2000 CHAR)
	
	private int formNo;
	private String formName;
	public FormCateDTO() {
		super();
	}
	public FormCateDTO(int formNo, String formName) {
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "FormCateDTO [formNo=" + formNo + ", formName=" + formName + "]";
	}
	
	
	
}
