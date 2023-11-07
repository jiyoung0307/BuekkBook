package com.bukkeubook.book.manage.model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bukkeubook.book.manage.model.dto.DayOffDTO;
import com.bukkeubook.book.manage.model.dto.joinDTO.DayOffAndEmpAndDeptDTO;
import com.bukkeubook.book.manage.model.entity.DayOff;
import com.bukkeubook.book.manage.model.entity.DayOffAndEmpAndDept;
import com.bukkeubook.book.manage.model.repository.AppVacRepository;
import com.bukkeubook.book.manage.model.repository.CancelVacRepository;
import com.bukkeubook.book.manage.model.repository.DayOffRepository2;
import com.bukkeubook.book.manage.model.repository.EmpDayOffRepository;

@Service
public class EmpDayOffService {
   
   private final EmpDayOffRepository empDayOffRepository;
   private final DayOffRepository2 dayOffRepository2;
   private final AppVacRepository appVacRepository;
   private final CancelVacRepository cancelVacRepository;
   private final ModelMapper modelMapper;
   
   @Autowired
   public EmpDayOffService(EmpDayOffRepository empDayOffRepository, DayOffRepository2 dayOffRepository2, AppVacRepository appVacRepository, 
		   CancelVacRepository cancelVacRepository, ModelMapper modelMapper) {
      this.empDayOffRepository = empDayOffRepository;
      this.dayOffRepository2 = dayOffRepository2;
      this.appVacRepository = appVacRepository;
      this.cancelVacRepository = cancelVacRepository;
      this.modelMapper = modelMapper;
   }
   
   
   /* 직원 연차조회 */
   public List<DayOffAndEmpAndDeptDTO> findDayOffList() {
      
      List<DayOffAndEmpAndDept> annualList = empDayOffRepository.findAll(Sort.by("doffNo"));
      
      return annualList.stream().map(dayOff -> modelMapper.map(dayOff, DayOffAndEmpAndDeptDTO.class)).toList();
   }

   /* 직원 연차상세조회 */
   public DayOffAndEmpAndDeptDTO searchEmpDayOffDetail(int empNo) {
	   
	   DayOffAndEmpAndDept emp = empDayOffRepository.findById(empNo).get();
		
//		System.out.println("레포지토리      " + emp);
		
		return modelMapper.map(emp, DayOffAndEmpAndDeptDTO.class); // 엔티티를 넣어달라고 요청 -> modelMapper
}
  
	@Transactional
	public DayOffAndEmpAndDeptDTO findByEmpNo(int empNo, int doffNo) {
		DayOffAndEmpAndDept dayOffList = dayOffRepository2.findByEmpNo(empNo);
		int nowDayOffAmount = dayOffList.getDoffAmount();
		int nowDayOffRemain = dayOffList.getDoffRemain();
		int nowDayOffUse = dayOffList.getDoffUse();
		dayOffList.setDoffRemain(nowDayOffAmount - nowDayOffUse);
		
		return modelMapper.map(dayOffList, DayOffAndEmpAndDeptDTO.class);
	}
	
	@Transactional
	public void findDayOffEmpNo(int empNo, int vacNo, String vacStartDate, String vacEndDate) throws ParseException {
		DayOff dayOff = appVacRepository.findByEmpNo(empNo);
		DayOffDTO dayOffDTO = modelMapper.map(dayOff, DayOffDTO.class);
		
		String vacStartTime = vacStartDate;
		String vacEndTime = vacEndDate;
		
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(vacStartTime);
		Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(vacEndTime);
		
		long vacStartTime2 = date1.getTime();
		long vacEndTime2 = date2.getTime();
		long test = vacEndTime2 - vacStartTime2;
		int day = (int)(test / 86400000 + 1);
		
		int dayOffUseRemain = dayOff.getDoffRemain() - day;
		dayOff.setDoffRemain(dayOffUseRemain);

		int UseDoffUse = dayOff.getDoffUse() + day;
		dayOff.setDoffUse(UseDoffUse);
		
//		appVacRepository.save(modelMapper.map(dayOffDTO, DayOff.class));
		
	}

	@Transactional
	public void findDayOffEmpNo(int vacCancNo, int vacNo, int empNo, String vacStartDate, String vacEndDate) throws ParseException {
		DayOff dayOff = cancelVacRepository.findByEmpNo(empNo);
		DayOffDTO dayOffDTO = modelMapper.map(dayOff, DayOffDTO.class);
		
		String vacStartTime = vacStartDate;
		String vacEndTime = vacEndDate;
		
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(vacStartTime);
		Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(vacEndTime);
		
		long vacStartTime2 = date1.getTime();
		long vacEndTime2 = date2.getTime();
		long test2 =  vacEndTime2 - vacStartTime2;
		int day2 = (int)(test2 / 86400000 + 1);
		
		int dayOffUseRemain = dayOff.getDoffRemain() + day2;
		dayOff.setDoffRemain(dayOffUseRemain);
		
		int UseDoffUse = dayOff.getDoffUse() - day2;
		dayOff.setDoffUse(UseDoffUse);
		
	}
	
}


