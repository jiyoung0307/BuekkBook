package com.bukkeubook.book.document.model.dto;

import java.io.Serializable;
import java.util.List;

public class AllVacationListDTO implements Serializable{

	private static final long serialVersionUID = 9108576992459087960L;

	private List<AppVacationDTO> vacaList;
	private List<CancelVacationDTO> cancelList;
	public AllVacationListDTO(List<AppVacationDTO> vacaList, List<CancelVacationDTO> cancelList) {
		this.vacaList = vacaList;
		this.cancelList = cancelList;
	}
	
	
	
}
