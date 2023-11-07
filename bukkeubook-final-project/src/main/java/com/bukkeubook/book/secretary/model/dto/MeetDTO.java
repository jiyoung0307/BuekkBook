package com.bukkeubook.book.secretary.model.dto;

import java.sql.Date;

public class MeetDTO {
	
// TBL_MEET 회의 테이블
	
//	MEET_NO	NUMBER
//	MEET_TITLE	NVARCHAR2(255 CHAR)
//	MEET_DATE	DATE
//	MEET_START_TIME	DATE
//	MEET_END_TIME	DATE
//	MEET_CONTENT	NVARCHAR2(2000 CHAR)
//	MEET_STATE	NVARCHAR2(15 CHAR)
//	EMP_NO	NUMBER
//	DEPT_CODE	NUMBER
//	MEET_REG_DATE	DATE
	
	private int no;
	private String title;
	private java.sql.Date date;
	private java.sql.Date startTime;
	private java.sql.Date endTime;
	private String content;
	private String state;
	private int empNo;
	private int deptCode;
	private java.sql.Date regDate;
	
	public MeetDTO() {
	}

	public MeetDTO(int no, String title, Date date, Date startTime, Date endTime, String content, String state,
			int empNo, int deptCode, Date regDate) {
		this.no = no;
		this.title = title;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.content = content;
		this.state = state;
		this.empNo = empNo;
		this.deptCode = deptCode;
		this.regDate = regDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public java.sql.Date getStartTime() {
		return startTime;
	}

	public void setStartTime(java.sql.Date startTime) {
		this.startTime = startTime;
	}

	public java.sql.Date getEndTime() {
		return endTime;
	}

	public void setEndTime(java.sql.Date endTime) {
		this.endTime = endTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public int getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(int deptCode) {
		this.deptCode = deptCode;
	}

	public java.sql.Date getRegDate() {
		return regDate;
	}

	public void setRegDate(java.sql.Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "MeetDTO [no=" + no + ", title=" + title + ", date=" + date + ", startTime=" + startTime + ", endTime="
				+ endTime + ", content=" + content + ", state=" + state + ", empNo=" + empNo + ", deptCode=" + deptCode
				+ ", regDate=" + regDate + "]";
	}
	
	
	
	
	

}
