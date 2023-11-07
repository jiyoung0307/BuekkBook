package com.bukkeubook.book.document.model.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bukkeubook.book.config.BukkeubookFinalProjectApplication;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BukkeubookFinalProjectApplication.class})
public class repositoryTest {
	
	private ApproverRepository2 approverRe;
	private AppRootRepository rootRe;
	private ModelMapper modelMapper;
	private DocumentRepository docRe;
	private AppVacationRepository vare;
	
	@Autowired
	public repositoryTest(ApproverRepository2 approverRe,ModelMapper modelMapper, AppRootRepository rootRe
						, DocumentRepository docRe, AppVacationRepository vare) {
		this.approverRe = approverRe;
		this.modelMapper = modelMapper;
		this.rootRe = rootRe;
		this.docRe = docRe;
		this.vare = vare;
	}
	
	@Test
	@Disabled
	public void 사원과_맞는_결제자_조회() {
		List<Object[]> list = approverRe.findByApproverNoDocList(17);
		assertNotNull(list);		// Success!!
	}
	
	@Test
	public void 시퀀스조회() {
		int no = vare.findCurrentSeq();		// Success!!
	}
	
//	@Test
//	@Disabled
//	public void 여러결제번호에_맞는_문서_조회() {
//		List<AppRoot> list = rootRe.findByAppRootNoDocList(9);
//		assertNotNull(list);		// Success!!
//	}
//	
//	@Test
//	@Disabled
//	public void 여러문서번호에_맞는_문서조회() {
//		List<Object[]> list = docRe.findByDocNoDocList(17);
//		assertNotNull(list);		// Success!!
//	}
//	
	
}
