package org.hnist.controller;

import javax.servlet.http.HttpSession;

import org.hnist.service.ContactInformationService;
import org.hnist.service.CultureService;
import org.hnist.service.SocietyHistoryService;
import org.hnist.service.SocietyNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {

	@Autowired
	private ContactInformationService contactInformationService;
	@Autowired
	private SocietyHistoryService societyHistoryService;
	@Autowired
	private SocietyNumberService societyNumberService;
	
	@RequestMapping("/front/Contact")
	public String showContact(Model model,HttpSession session) {
		contactInformationService.findAllContactInformation(model, session);
		societyHistoryService.findAllSocietyHistory(model, session);
		societyNumberService.findAllSocietyNumber(model, session);
		return "/front/contact";
	}
}
