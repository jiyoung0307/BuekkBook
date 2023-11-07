package com.bukkeubook.book.manage.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bukkeubook.book.document.model.entity.Emp;

/* TBL_DEPT 테이블에 매칭될 Dept 엔티티 클래스도 만들어 보기 */
@Entity
@Table(name = "TBL_DEPT")
public class DeptAndEmp2 implements Serializable {


	private static final long serialVersionUID = 8249127615292389456L;

	/* DB 자료형 */
   
//   DEPT_CODE      NUMBER            부서코드
//   DEPT_NAME      NVARCHAR2(31 CHAR)   부서명
//   DEPT_REP_PHONE   VARCHAR2(15 BYTE)   대표번호

@Id
   @Column(name = "DEPT_CODE")   // PK
   private int deptCode;
   
   @Column(name = "DEPT_NAME")
   private String deptName;
   
   @Column(name = "DEPT_REP_PHONE")
   private String deptRepPhone;
   
   @Column(name = "DEPT_ACTIVE")
   private String deptActive;
   
   @OneToMany(mappedBy ="deptCode")   // FK명
   private List<Emp> empList = new ArrayList<>();

   public DeptAndEmp2() {
   }

	public DeptAndEmp2(int deptCode, String deptName, String deptRepPhone, String deptActive, List<Emp> empList) {
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
	
	public List<Emp> getEmpList() {
		return empList;
	}
	
	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DeptAndEmp2 [deptCode=" + deptCode + ", deptName=" + deptName + ", deptRepPhone=" + deptRepPhone
				+ ", deptActive=" + deptActive + ", empList=" + empList + "]";
	}

}