package com.bukkeubook.book.manage.model.dto.joinDTO;

import java.util.ArrayList;
import java.util.List;

import com.bukkeubook.book.document.model.dto.EmpDTO;


public class DeptAndEmpDTO {
   
//   DEPT_CODE      NUMBER            부서코드
//   DEPT_NAME      NVARCHAR2(31 CHAR)   부서명
//   DEPT_REP_PHONE   VARCHAR2(15 BYTE)   대표번호
   
   private int deptCode;         // 부서코드
   private String deptName;      // 부서명
   private String deptRepPhone;   // 대표번호
   private String deptActive;	// 활성화여부
   private List<EmpDTO> empList = new ArrayList<>();

   public DeptAndEmpDTO() {
   }

	public DeptAndEmpDTO(int deptCode, String deptName, String deptRepPhone, String deptActive, List<EmpDTO> empList) {
		this.deptCode = deptCode;
		this.deptName = deptName;
		this.deptRepPhone = deptRepPhone;
		this.deptActive = deptActive;
		this.empList = empList;
	}
	
	public int getDeptCode() {
		return deptCode;
	}
	
	public void setDeptCode(int deptCode) {
		this.deptCode = deptCode;
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public String getDeptRepPhone() {
		return deptRepPhone;
	}
	
	public void setDeptRepPhone(String deptRepPhone) {
		this.deptRepPhone = deptRepPhone;
	}
	
	public String getDeptActive() {
		return deptActive;
	}
	
	public void setDeptActive(String deptActive) {
		this.deptActive = deptActive;
	}
	
	public List<EmpDTO> getEmpList() {
		return empList;
	}
	
	public void setEmpList(List<EmpDTO> empList) {
		this.empList = empList;
	}
	
	@Override
	public String toString() {
		return "DeptAndEmpDTO [deptCode=" + deptCode + ", deptName=" + deptName + ", deptRepPhone=" + deptRepPhone
				+ ", deptActive=" + deptActive + ", empList=" + empList + "]";
	}
   
}