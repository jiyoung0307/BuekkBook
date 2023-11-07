package com.bukkeubook.book.document.model.dto;

import java.io.Serializable;

public class AppRootDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5572878668404675699L;
	
//	APP_ROOT_NO	경로번호	NUMBER
//	DOC_NO	문서번호	NUMBER
//	STEP_NO	결재단계번호	NUMBER
	
	private int appRootNo;
	private int docNo;
	private int stepNo;
	public AppRootDTO() {
		super();
	}
	public AppRootDTO(int appRootNo, int docNo, int stepNo) {
		super();
		this.appRootNo = appRootNo;
		this.docNo = docNo;
		this.stepNo = stepNo;
	}
	public int getAppRootNo() {
		return appRootNo;
	}
	public void setAppRootNo(int appRootNo) {
		this.appRootNo = appRootNo;
	}
	public int getDocNo() {
		return docNo;
	}
	public void setDocNo(int docNo) {
		this.docNo = docNo;
	}
	public int getStepNo() {
		return stepNo;
	}
	public void setStepNo(int stepNo) {
		this.stepNo = stepNo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "AppRootDTO [appRootNo=" + appRootNo + ", docNo=" + docNo + ", stepNo=" + stepNo + "]";
	}

	
	
}
