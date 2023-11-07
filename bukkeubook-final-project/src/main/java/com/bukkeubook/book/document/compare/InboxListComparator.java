package com.bukkeubook.book.document.compare;

import java.util.Comparator;

import com.bukkeubook.book.document.model.dto.InboxListDTO;

public class InboxListComparator implements Comparator<InboxListDTO>{

	@Override
	public int compare(InboxListDTO o1, InboxListDTO o2) {

		 if (o1.getDocument().getDocNo1() > o2.getDocument().getDocNo1()) {
			 return 1;        
		 } else if (o1.getDocument().getDocNo1() < o2.getDocument().getDocNo1()) {
			 return -1;        
		 }
		
		return 0;
	}

}
