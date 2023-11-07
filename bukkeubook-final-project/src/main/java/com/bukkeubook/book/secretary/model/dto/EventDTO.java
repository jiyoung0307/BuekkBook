package com.bukkeubook.book.secretary.model.dto;

import java.sql.Date;

public class EventDTO {
	
// TBL_EVENT 행사 일정 테이블
	
//	EVENT_NO	NUMBER						// 행사번호
//	EVENT_NAME	NVARCHAR2(255 CHAR)			// 행사명
//	EVENT_START	DATE						// 행사 시작일
//	EVENT_END	DATE						// 행사 종료일
//	EVENT_STATE	NVARCHAR2(15 CHAR)			// 상태
//	EVENT_CONTENT	NVARCHAR2(2000 CHAR)	// 행사 기록
//	EMP_NO	NUMBER							// 사원번호
//	DEPT_CODE	NUMBER						// 부서코드
//	EVENT_REG_DATE	DATE					// 작성일
	
	private int no;
	private String name;
	private java.sql.Date start;
	private java.sql.Date end;
	private String state;
	private String content;
	private int empNo;
	private int deptCode;
	private java.sql.Date regDate;
	
	public EventDTO() {
	}

	public EventDTO(int no, String name, Date start, Date end, String state, String content, int empNo, int deptCode,
			Date regDate) {
		this.no = no;
		this.name = name;
		this.start = start;
		this.end = end;
		this.state = state;
		this.content = content;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		return "EventDTO [no=" + no + ", name=" + name + ", start=" + start + ", end=" + end + ", state=" + state
				+ ", content=" + content + ", empNo=" + empNo + ", deptCode=" + deptCode + ", regDate=" + regDate + "]";
	}
	
	
	
	
	
	

}
