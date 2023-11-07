package com.bukkeubook.book.document.model.dto;

import java.io.Serializable;

public class InboxListDTO implements Serializable{

	private static final long serialVersionUID = 1606105336507335642L;
	
	private String appStatus;
	private String stepName;
	private TempStoreDocumentDTO document;
	private String formName;
	public InboxListDTO() {
		super();
	}
	public InboxListDTO(String appStatus, String stepName, TempStoreDocumentDTO document, String formName) {
		super();
		this.appStatus = appStatus;
		this.stepName = stepName;
		this.document = document;
		this.formName = formName;
	}
	public String getAppStatus() {
		return appStatus;
	}
	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}
	public String getStepName() {
		return stepName;
	}
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
	public TempStoreDocumentDTO getDocument() {
		return document;
	}
	public void setDocument(TempStoreDocumentDTO document) {
		this.document = document;
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
		return "InboxListDTO [appStatus=" + appStatus + ", stepName=" + stepName + ", document=" + document
				+ ", formName=" + formName + "]";
	}
	
	
}
