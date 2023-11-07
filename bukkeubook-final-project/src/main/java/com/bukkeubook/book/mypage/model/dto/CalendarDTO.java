package com.bukkeubook.book.mypage.model.dto;

import java.sql.Date;

public class CalendarDTO {
	
// TBL_CALENDAR 개인 일정 테이블

//	CAL_CODE	NUMBER
//	CAL_TITLE	NVARCHAR2(63 CHAR)
//	CAL_CONTENT	NVARCHAR2(255 CHAR)
//	CAL_START	DATE
//	CAL_END	DATE
//	EMP_NO	NUMBER
	
	private int code;
	private String title;
	private String content;
	private java.sql.Date start;
	private java.sql.Date end;
	private int empNo;
	public CalendarDTO() {
	}
	public CalendarDTO(int code, String title, String content, Date start, Date end, int empNo) {
		this.code = code;
		this.title = title;
		this.content = content;
		this.start = start;
		this.end = end;
		this.empNo = empNo;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public java.sql.Date getStart() {
		return start;
	}
	public void setStart(java.sql.Date start) {
		this.start = start;
	}
	public java.sql.Date getEnd() {
		return end;
	}
	public void setEnd(java.sql.Date end) {
		this.end = end;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	@Override
	public String toString() {
		return "CalendarDTO [code=" + code + ", title=" + title + ", content=" + content + ", start=" + start + ", end="
				+ end + ", empNo=" + empNo + "]";
	}
	
	
	
}
