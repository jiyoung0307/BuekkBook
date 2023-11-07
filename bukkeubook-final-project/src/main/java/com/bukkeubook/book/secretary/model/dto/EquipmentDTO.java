package com.bukkeubook.book.secretary.model.dto;

public class EquipmentDTO {

// 	TBL_EQUIPMENT 비품 정보 테이블
	
//	EQ_NO	NUMBER
//	EQ_NAME	NVARCHAR2(127 CHAR)
//	EQ_PRICE	NUMBER
//	EQ_AMOUNT	NUMBER
//	EQ_USE	VARCHAR2(20 BYTE)
//	EQ_CATE_NO	NUMBER
	
	private int no;
	private String name;
	private int price;
	private int amount;
	private String use;
	private int cateNo;
	
	public EquipmentDTO() {
	}

	public EquipmentDTO(int no, String name, int price, int amount, String use, int cateNo) {
		this.no = no;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.use = use;
		this.cateNo = cateNo;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public int getCateNo() {
		return cateNo;
	}

	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}

	@Override
	public String toString() {
		return "EquipmentDTO [no=" + no + ", name=" + name + ", price=" + price + ", amount=" + amount + ", use=" + use
				+ ", cateNo=" + cateNo + "]";
	}
	
	
	
	
	
}
