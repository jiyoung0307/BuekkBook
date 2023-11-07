package com.bukkeubook.book.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bukkeubook.book.manage.model.service.LaborService;

@Controller
@RequestMapping("/labor")
public class LaborController {
	
	private final LaborService laborService;
	
	@Autowired
	public LaborController (LaborService laborService) {
		this.laborService = laborService;
	}
	
	@GetMapping("select")
	public String main() {
		return "manage/labor/select";
	}
	
	
}
