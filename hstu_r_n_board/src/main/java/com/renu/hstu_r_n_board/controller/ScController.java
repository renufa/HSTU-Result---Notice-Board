package com.renu.hstu_r_n_board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.renu.hstu_r_n_board_backend.dao.NoticesDao;
import com.renu.hstu_r_n_board_backend.dao.ResultsDao;
import com.renu.hstu_r_n_board_backend.dto.Sc_Notices;
import com.renu.hstu_r_n_board_backend.dto.Sc_Results;

@Controller
@RequestMapping("/sc")
public class ScController {
	@Autowired
	private ResultsDao resultDao;
	@Autowired
	private NoticesDao noticesDao;

	@RequestMapping("/results")
	public ModelAndView showScResults() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("jsonURL", "sc/all/results");
		mv.addObject("userClickScResults", true);
		return mv;
		
	}
	
	@RequestMapping("/notices")
	public ModelAndView showScNotices() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("jsonURL", "sc/all/notices");
		mv.addObject("userClickScNotices", true);
		return mv;
		
	}
	
	
	
	@RequestMapping("/scManageResults")
	public ModelAndView showScManageResults(Map<String,Object>map) {
		//string must be as lioke as modelAttribue and small letters
		map.put("scmanageresults",new Sc_Results());
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("scManageResults",true);
		return mv;
		
	}

	@RequestMapping("/scManageNotices")
	public ModelAndView showScManageNotices(Map<String,Object>map) {
		//string must be as lioke as modelAttribue and small letters
		map.put("scmanagenotices",new Sc_Notices());
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("scManageNotices",true);
		return mv;
		
	}

	
	
	
	@RequestMapping("/all/results")
	@ResponseBody
	public List<Sc_Results>scAllResults(){
		
		return resultDao.scGetAllResults();
	}

	@RequestMapping("/all/notices")
	@ResponseBody
	public List<Sc_Notices> scAllNotices(){
		
		return noticesDao.scGetAllNotices();
	}
	
	
	
	
	
	
	
	
	
	
}
