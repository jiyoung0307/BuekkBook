package com.bukkeubook.book.books.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Book")
@Table(name = "TBL_BOOK")

//@SequenceGenerator( name = "BOOK_SEQ_GENERATOR", sequenceName = "SEQ_BK_NO",
//initialValue = 1, allocationSize = 1 )

public class Book {
	
	@Id
//	@GeneratedValue(
//			strategy = GenerationType.SEQUENCE,
//			generator = "BOOK_SEQ_GENERATOR"
//	)
	@Column(name = "BK_NO")
	private String no;					// 도서코드
	
	@Column(name = "BK_NAME")
	private String name;				// 도서명
	
	@Column(name = "BK_AUTHOR")
	private String author;				// 저자
	
	@Column(name = "BK_PUB")
	private String pub;					// 출판사
	
	@Column(name = "BK_PRICE")
	private int price;					// 가격
	
	@Column(name = "BK_STORE_ST")
	private int storeSt;				// 판매재고수량
	
	@Column(name = "BK_WH_ST")
	private int whSt;					// 창고재고수량
	
	@Column(name = "BK_PUB_DATE")
	private java.sql.Date pubDate;		// 발행일
	
	@Column(name = "BK_LAST_DATE")
	private java.sql.Date lastDate;	// 최근입고일
	
	@Column(name = "BK_ISBN")
	private String isbn;				// ISBN
	
	@Column(name = "BK_SELL_YN")
	private String sellYn;				// 판매여부
	
	@Column(name = "BK_CATE")
	private String cate;				// 카테고리
	
	@OneToOne
	@JoinColumn(name = "BK_NO")
	private DamBook damBook;

	public Book() {
	}

	public Book(String no, String name, String author, String pub, int price, int storeSt, int whSt, Date pubDate,
			Date lastDate, String isbn, String sellYn, String cate, DamBook damBook) {
		this.no = no;
		this.name = name;
		this.author = author;
		this.pub = pub;
		this.price = price;
		this.storeSt = storeSt;
		this.whSt = whSt;
		this.pubDate = pubDate;
		this.lastDate = lastDate;
		this.isbn = isbn;
		this.sellYn = sellYn;
		this.cate = cate;
		this.damBook = damBook;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPub() {
		return pub;
	}

	public void setPub(String pub) {
		this.pub = pub;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStoreSt() {
		return storeSt;
	}

	public void setStoreSt(int storeSt) {
		this.storeSt = storeSt;
	}

	public int getWhSt() {
		return whSt;
	}

	public void setWhSt(int whSt) {
		this.whSt = whSt;
	}

	public java.sql.Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(java.sql.Date pubDate) {
		this.pubDate = pubDate;
	}

	public java.sql.Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(java.sql.Date lastDate) {
		this.lastDate = lastDate;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getSellYn() {
		return sellYn;
	}

	public void setSellYn(String sellYn) {
		this.sellYn = sellYn;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public DamBook getDamBook() {
		return damBook;
	}

	public void setDamBook(DamBook damBook) {
		this.damBook = damBook;
	}

	@Override
	public String toString() {
		return "Book [no=" + no + ", name=" + name + ", author=" + author + ", pub=" + pub + ", price=" + price
				+ ", storeSt=" + storeSt + ", whSt=" + whSt + ", pubDate=" + pubDate + ", lastDate=" + lastDate
				+ ", isbn=" + isbn + ", sellYn=" + sellYn + ", cate=" + cate + ", damBook=" + damBook + "]";
	}
	
	
	
}	
















