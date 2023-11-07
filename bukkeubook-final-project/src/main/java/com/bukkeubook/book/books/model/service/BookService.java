package com.bukkeubook.book.books.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bukkeubook.book.books.controller.NativeRepository;
import com.bukkeubook.book.books.model.dto.BookDTO;
import com.bukkeubook.book.books.model.dto.DamBookDTO;
import com.bukkeubook.book.books.model.dto.RelBkListAndBookAndRelListDTO;
import com.bukkeubook.book.books.model.dto.RelBkListDTO;
import com.bukkeubook.book.books.model.dto.RelListAndEmpDTO;
import com.bukkeubook.book.books.model.dto.RelListDTO;
import com.bukkeubook.book.books.model.dto.StockBookListAndBookAndStockListAndEmpDTO;
import com.bukkeubook.book.books.model.dto.StockBookListDTO;
import com.bukkeubook.book.books.model.dto.StockListAndEmpDTO;
import com.bukkeubook.book.books.model.dto.StockListDTO;
import com.bukkeubook.book.books.model.entity.Book;
import com.bukkeubook.book.books.model.entity.DamBook;
import com.bukkeubook.book.books.model.entity.RelBkList;
import com.bukkeubook.book.books.model.entity.RelBkListAndBookAndRelList;
import com.bukkeubook.book.books.model.entity.RelList;
import com.bukkeubook.book.books.model.entity.RelListAndEmp;
import com.bukkeubook.book.books.model.entity.StockBookList;
import com.bukkeubook.book.books.model.entity.StockBookListAndBookAndStockListAndEmp;
import com.bukkeubook.book.books.model.entity.StockList;
import com.bukkeubook.book.books.model.entity.StockListAndEmp;
import com.bukkeubook.book.books.model.repository.BookInputRepository;
import com.bukkeubook.book.books.model.repository.BookInputRepository2;
import com.bukkeubook.book.books.model.repository.BookOutputRepository;
import com.bukkeubook.book.books.model.repository.BookOutputRepository2;
import com.bukkeubook.book.books.model.repository.BookRepository;
import com.bukkeubook.book.books.model.repository.DamBookRepository;
import com.bukkeubook.book.books.model.repository.InputRepository;
import com.bukkeubook.book.books.model.repository.OutputRepository;
import com.bukkeubook.book.books.model.repository.RelBkListAndBookAndRelListRepository;
import com.bukkeubook.book.books.model.repository.StockBookListAndBookAndStockListAndEmpRepository;
import com.bukkeubook.book.common.paging.SelectCriteria;

@Service
public class BookService {
	
	private final BookRepository bookRepository;
	private final NativeRepository nativeRepository; 
	private final OutputRepository outputRepository;
	private final RelBkListAndBookAndRelListRepository relBkListAndBookAndRelListRepository;
	private final StockBookListAndBookAndStockListAndEmpRepository stockBookListAndBookAndStockListAndEmpRepository;
	private final InputRepository inputRepository;
	private final BookOutputRepository bookOutputRepository;
	private final BookOutputRepository2 bookOutputRepository2;
	private final BookInputRepository bookInputRepository;
	private final BookInputRepository2 bookInputRepository2;
	private final DamBookRepository damBookRepository;
	private final ModelMapper modelMapper;			// modelMapper 빈을 선언
	
	@Autowired
	public BookService(DamBookRepository damBookRepository, BookInputRepository2 bookInputRepository2, BookInputRepository bookInputRepository, BookOutputRepository2 bookOutputRepository2, BookOutputRepository bookOutputRepository, StockBookListAndBookAndStockListAndEmpRepository stockBookListAndBookAndStockListAndEmpRepository, InputRepository inputRepository, RelBkListAndBookAndRelListRepository relBkListAndBookAndRelListRepository, BookRepository bookRepository, ModelMapper modelMapper, NativeRepository nativeRepository, OutputRepository outputRepository) {
		this.bookRepository = bookRepository;
		this.outputRepository = outputRepository;
		this.nativeRepository = nativeRepository;
		this.relBkListAndBookAndRelListRepository = relBkListAndBookAndRelListRepository;
		this.stockBookListAndBookAndStockListAndEmpRepository = stockBookListAndBookAndStockListAndEmpRepository;
		this.inputRepository = inputRepository;
		this.bookOutputRepository = bookOutputRepository;
		this.bookOutputRepository2 = bookOutputRepository2;
		this.bookInputRepository = bookInputRepository;
		this.bookInputRepository2 = bookInputRepository2;
		this.damBookRepository = damBookRepository;
		this.modelMapper = modelMapper;
	}
	
	public List<BookDTO> findBookList() {
		
		List<Book> bookList = bookRepository.findAll(Sort.by("no"));
		return bookList.stream().map(book -> modelMapper.map(book, BookDTO.class)).toList();
	}

	public int selectTotalCount(String searchCondition, String searchValue) {

		int count = 0;
		if(searchValue != null) {
			if("name".equals(searchCondition)) {
				count = bookRepository.countByNameContaining(searchValue);
			}

			if("author".equals(searchCondition)) {
				count = bookRepository.countByAuthorContaining(searchValue);
			}
			
			if("no".equals(searchCondition)) {
				count = bookRepository.countByNoContaining(searchValue);
			}
			if("date".equals(searchCondition)) {
				count = inputRepository.countBystDateContaining(searchValue);
			}
		} else {
			count = (int)bookRepository.count();
		}

		return count;
	}

	public List<BookDTO> searchBookList(SelectCriteria selectCriteria) {

		int index = selectCriteria.getPageNo() - 1;
		int count = selectCriteria.getLimit();
		String searchValue = selectCriteria.getSearchValue();

		Pageable paging = PageRequest.of(index, count, Sort.by("no"));

		List<Book> bookList = new ArrayList<Book>();
		if(searchValue != null) {

			if("name".equals(selectCriteria.getSearchCondition())) {
				bookList = bookRepository.findByNameContaining(selectCriteria.getSearchValue(), paging);
			}

			if("author".equals(selectCriteria.getSearchCondition())) {
				bookList = bookRepository.findByAuthorContaining(selectCriteria.getSearchValue(), paging);
			}
			
			if("no".equals(selectCriteria.getSearchCondition())) {
				bookList = bookRepository.findByNoContaining(selectCriteria.getSearchValue(), paging);
			}
		} else {
			bookList = bookRepository.findAll(paging).toList();
		}

		/* 자바의 Stream API와 ModelMapper를 이용하여 entity를 DTO로 변환 후 List<MenuDTO>로 반환 */
		return bookList.stream().map(book -> modelMapper.map(book, BookDTO.class)).collect(Collectors.toList());
	}
	
	/***********************************************************************************************************/
	@Transactional
	public List<BookDTO> findBookByNo(String no) {
		List<Book> bookList = bookRepository.findBookByNo(no);
		return bookList.stream().map(book -> modelMapper.map(book, BookDTO.class)).collect(Collectors.toList());
	}
	/**
	 * @return *********************************************************************************************************/
	
	@Transactional	
	public boolean modifyBookInfo(BookDTO bookDTO) {
		
		Book book = bookRepository.findByNo(bookDTO.getNo());
		
		try {
			
		book.setNo(bookDTO.getNo());
		book.setPrice(bookDTO.getPrice());
		book.setStoreSt(bookDTO.getStoreSt());
		book.setWhSt(bookDTO.getWhSt());
		book.setSellYn(bookDTO.getSellYn());
		
		} catch (IllegalArgumentException exception) {
			return false;
		}
		return true;
	}
	
	/* 현재 도서코드 시퀀스 max값 +1 조회용 */
	public String newBookCode() {
		String bookCode = nativeRepository.newBookCode();
		return bookCode;
	}
	
	/* 신규 도서 추가 */
	@Transactional
	public boolean insertBook(BookDTO bookDTO) {
		String bkNo = bookDTO.getNo();
		DamBookDTO damBook = new DamBookDTO();
		try {
			damBook.setBkNo(bkNo);
			damBook.setDamAmount(0);
			bookRepository.save(modelMapper.map(bookDTO, Book.class));
			damBookRepository.save(modelMapper.map(damBook, DamBook.class));
		} catch (IllegalArgumentException exception) {
			return false;
		}
		return true;
	}

	public List<RelListAndEmpDTO> searchBookList2(SelectCriteria selectCriteria) {

		int index = selectCriteria.getPageNo() - 1;
		int count = selectCriteria.getLimit();
		String searchValue = selectCriteria.getSearchValue();

		Pageable paging = PageRequest.of(index, count, Sort.by("relDate").descending());

		List<RelListAndEmp> bookList = new ArrayList<RelListAndEmp>();
		if(searchValue != null) {

			if("name".equals(selectCriteria.getSearchCondition())) {
				bookList = outputRepository.findAllByEmp_EmpNameContaining(selectCriteria.getSearchValue(), paging);
			}

			if("date".equals(selectCriteria.getSearchCondition())) {
				bookList = outputRepository.findAllByRelDateContaining(selectCriteria.getSearchValue(), paging);
			}
		} else {
			bookList = outputRepository.findAll(paging).toList();
		}
		System.out.println(bookList);
		return bookList.stream().map(book -> modelMapper.map(book, RelListAndEmpDTO.class)).collect(Collectors.toList());
	}

	public List<RelBkListAndBookAndRelListDTO> outputDetail(int no2) {
		List<RelBkListAndBookAndRelList> bookList = relBkListAndBookAndRelListRepository.findByrelListEmp_relNo(no2);
		System.out.println(bookList);
		return bookList.stream().map(book -> modelMapper.map(book, RelBkListAndBookAndRelListDTO.class)).toList();
	}

	public List<StockListAndEmpDTO> searchBookList3(SelectCriteria selectCriteria) {
		
		int index = selectCriteria.getPageNo() - 1;
		int count = selectCriteria.getLimit();
		String searchValue = selectCriteria.getSearchValue();

		Pageable paging = PageRequest.of(index, count, Sort.by("stDate").descending());

		List<StockListAndEmp> stockListEmp = new ArrayList<StockListAndEmp>();
		if(searchValue != null) {

			if("name".equals(selectCriteria.getSearchCondition())) {
				stockListEmp = inputRepository.findAllByEmp_EmpNameContaining(selectCriteria.getSearchValue(), paging);
			}

			if("date".equals(selectCriteria.getSearchCondition())) {
				stockListEmp = inputRepository.searchDate(selectCriteria.getSearchValue(), paging);
			}
		} else {
			stockListEmp = inputRepository.findAll(paging).toList();
		}
		System.out.println(stockListEmp);
		return stockListEmp.stream().map(book -> modelMapper.map(book, StockListAndEmpDTO.class)).collect(Collectors.toList());
	}

	public List<StockBookListAndBookAndStockListAndEmpDTO> inputDetail(int no2) {
		List<StockBookListAndBookAndStockListAndEmp> bookList = stockBookListAndBookAndStockListAndEmpRepository.findBystockListEmp_stCode(no2);
		System.out.println(bookList);
		return bookList.stream().map(book -> modelMapper.map(book, StockBookListAndBookAndStockListAndEmpDTO.class)).toList();
	}

	public List<BookDTO> searchBookList4(SelectCriteria selectCriteria) {
		int index = selectCriteria.getPageNo() - 1;
		int count = selectCriteria.getLimit();
		String searchValue = selectCriteria.getSearchValue();

		Pageable paging = PageRequest.of(index, count, Sort.by("no"));

		List<Book> outputList = new ArrayList<Book>();
		if(searchValue != null) {

			if("no".equals(selectCriteria.getSearchCondition())) {
				outputList = bookRepository.findAllByNoContaining(selectCriteria.getSearchValue(), paging);
			}

			if("name".equals(selectCriteria.getSearchCondition())) {
				outputList = bookRepository.findAllByNameContaining(selectCriteria.getSearchValue(), paging);
			}
			
			if("author".equals(selectCriteria.getSearchCondition())) {
				outputList = bookRepository.findAllByAuthorContaining(selectCriteria.getSearchValue(), paging);
			}
		} /*
			 * else { stockListEmp = bookRepository.findAll(paging).toList(); }
			 */
		System.out.println(outputList);
		return outputList.stream().map(book -> modelMapper.map(book, BookDTO.class)).collect(Collectors.toList());
	}

	public List<BookDTO> searchBookList5(SelectCriteria selectCriteria) {
		int index = selectCriteria.getPageNo() - 1;
		int count = selectCriteria.getLimit();
		String searchValue = selectCriteria.getSearchValue();

		Pageable paging = PageRequest.of(index, count, Sort.by("no"));

		List<Book> inputList = new ArrayList<Book>();
		if(searchValue != null) {

			if("no".equals(selectCriteria.getSearchCondition())) {
				inputList = bookRepository.findAllByNoContaining(selectCriteria.getSearchValue(), paging);
			}

			if("name".equals(selectCriteria.getSearchCondition())) {
				inputList = bookRepository.findAllByNameContaining(selectCriteria.getSearchValue(), paging);
			}
			
			if("author".equals(selectCriteria.getSearchCondition())) {
				inputList = bookRepository.findAllByAuthorContaining(selectCriteria.getSearchValue(), paging);
			}
		} /*
			 * else { stockListEmp = bookRepository.findAll(paging).toList(); }
			 */
		System.out.println(inputList);
		return inputList.stream().map(book -> modelMapper.map(book, BookDTO.class)).collect(Collectors.toList());
	}
	
	@Transactional
	public int outputReceipt(RelListDTO relList) {
		bookOutputRepository.save(modelMapper.map(relList, RelList.class));
		int relNo = nativeRepository.newRelNo();
		System.out.println(relNo);
		return relNo;
		
	}
	
	@Transactional
	public boolean outputReceipt2(RelBkListDTO relBkList) {
		try {
			bookOutputRepository2.save(modelMapper.map(relBkList, RelBkList.class));
			
		} catch (IllegalArgumentException exception) {
			return false;
		}
		return true;
	}
	
	@Transactional
	public boolean outputReceipt3(BookDTO bookDTO, int amount) {
		try {
			Book book = bookRepository.findByNo(bookDTO.getNo());
			int nowAmount = book.getWhSt();
			int nowStoreAmount = book.getStoreSt();
			book.setWhSt(nowAmount - amount);
			book.setStoreSt(nowStoreAmount + amount);
		} catch (IllegalArgumentException exception) {
			return false;
		}
		return true;
	}
	
	@Transactional
	public int inputReceipt(StockListDTO stockList) {
		bookInputRepository.save(modelMapper.map(stockList, StockList.class));
		int stCode = nativeRepository.newStCode();
		System.out.println(stCode);
		return stCode;
	}
	
	@Transactional
	public boolean inputReceipt2(StockBookListDTO stockBookList) {
		try {
			bookInputRepository2.save(modelMapper.map(stockBookList, StockBookList.class));
		} catch (IllegalArgumentException exception) {
			return false;
		}
		return true;
	}
	
	@Transactional
	public boolean inputReceipt3(BookDTO bookDTO, int amount, String selectInput) {
		try {
			Book book = bookRepository.findByNo(bookDTO.getNo());
			int nowAmount = book.getWhSt();
			int nowStAmount = book.getStoreSt();
			
			if(selectInput.equals("일반입고")) {
				book.setWhSt(nowAmount + amount);
				book.setStoreSt(nowStAmount - amount);
			} else if(selectInput.equals("발주입고")) {
				book.setWhSt(nowAmount + amount);
			}
		} catch (IllegalArgumentException exception) {
			return false;
		}
		return true;
	}

	
	public List<BookDTO> searchDamageBook(SelectCriteria selectCriteria) {
		int index = selectCriteria.getPageNo() - 1;
		int count = selectCriteria.getLimit();
		String searchValue = selectCriteria.getSearchValue();

		Pageable paging = PageRequest.of(index, count, Sort.by("no"));

		List<Book> bookList = new ArrayList<Book>();
		if(searchValue != null) {

			if("name".equals(selectCriteria.getSearchCondition())) {
				bookList = bookRepository.findByNameContaining(selectCriteria.getSearchValue(), paging);
			}

			if("author".equals(selectCriteria.getSearchCondition())) {
				bookList = bookRepository.findByAuthorContaining(selectCriteria.getSearchValue(), paging);
			}
			
			if("no".equals(selectCriteria.getSearchCondition())) {
				bookList = bookRepository.findByNoContaining(selectCriteria.getSearchValue(), paging);
			}
		} else {
			bookList = bookRepository.findAll(paging).toList();
		}
		System.out.println(bookList);
		return bookList.stream().map(book -> modelMapper.map(book, BookDTO.class)).collect(Collectors.toList());
	}

	@Transactional
	public boolean findByNo(String no, int updateAmount) {
		try {
			DamBook damBookList = damBookRepository.findBybkNo(no);
			int nowAmount = damBookList.getDamAmount();
			damBookList.setDamAmount(nowAmount + updateAmount);
			damBookRepository.save(damBookList);
		} catch (IllegalArgumentException exception) {
			return false;
		}
		return true;
	}
	
	@Transactional
	public boolean findBookByNo(String no, int updateAmount, int amount) {
//		amount = 기존훼손 수량
//		updateAmount = 추가훼손 수량
//		whst = 기존 창고수량
		try {
			Book book = bookRepository.findByNo(no);
			int whst = book.getWhSt();		
			book.setWhSt(whst - updateAmount);
		} catch (IllegalArgumentException exception) {
			return false;
		}
		return true;
	}
	
	public List<BookDTO> searchBookList(String searchCondition, String searchValue) {
		List<Book> bookList = new ArrayList<Book>();
		if(searchValue != null) {

			if("name".equals(searchCondition)) {
				bookList = bookRepository.findByNameContaining(searchValue, Sort.by("no"));
			}

			if("author".equals(searchCondition)) {
				bookList = bookRepository.findByAuthorContaining(searchValue, Sort.by("no"));
			}
			
			if("no".equals(searchCondition)) {
				bookList = bookRepository.findByNoContaining(searchValue, Sort.by("no"));
			}
		} else {
			bookList = bookRepository.findAll(Sort.by("no"));
		}

		return bookList.stream().map(Book -> modelMapper.map(Book, BookDTO.class)).collect(Collectors.toList());
	
	}

	
}
