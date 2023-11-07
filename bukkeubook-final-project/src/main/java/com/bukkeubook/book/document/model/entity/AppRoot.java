package com.bukkeubook.book.document.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "AppRoot")
@Table(name = "TBL_APP_ROOT")
@SequenceGenerator(
		name = "DOCUMENT_SEQ_APP_ROOT_NO",
		sequenceName = "SEQ_APP_ROOT_NO",
		initialValue = 1,
		allocationSize = 1
)
public class AppRoot{
	
//	APP_ROOT_NO	경로번호	NUMBER
//	DOC_NO	문서번호	NUMBER
//	STEP_NO	결재단계번호	NUMBER

	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "DOCUMENT_SEQ_APP_ROOT_NO"
	)
	@Column(name = "APP_ROOT_NO")
	private int appRootNo;
	
	@Column(name = "DOC_NO")
	private int docNo;
	
	@Column(name = "STEP_NO")
	private int stepNo;

	public AppRoot() {
		super();
	}

	public AppRoot(int appRootNo, int docNo, int stepNo) {
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

	@Override
	public String toString() {
		return "AppRoot [appRootNo=" + appRootNo + ", docNo=" + docNo + ", stepNo=" + stepNo + "]";
	}
	
	
	
}
