package com.bukkeubook.book.secretary.model.dto;

public class EquipmentCateDTO {
	
//  TBL_EQUIPMENT_CATE 비품 카테고리 테이블
	
//	EQ_CATE_NO	NUMBER
//	EQ_CATE_NAME	NVARCHAR2(31 CHAR)
	
	private int no;
	private int name;
	
	public EquipmentCateDTO() {
	}

	public EquipmentCateDTO(int no, int name) {
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EquipmentCateDTO [no=" + no + ", name=" + name + "]";
	}
	
	
	

}
