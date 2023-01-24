package com.marketingapp.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.entities.Lead;
import com.marketingapp.services.LeadService;
import com.marketingapp.util.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private LeadService leadService;
	
	@RequestMapping("/viewLeadPage")
	public String viewCreateLeadpage() {
		return "create_lead";
	}
	
	@RequestMapping(value = "/saveLead", method = RequestMethod.POST)
	public String saveLead(@ModelAttribute("lead") Lead l, ModelMap model) {
		leadService.saveOneLead(l);
		emailService.sendSimpleMail(l.getEmail(), "welcome", "happy new year");
		model.addAttribute("msg", "Lead is saved..!");
		return "create_lead";
	}
	
	@RequestMapping("/listAll")
	public String listAllLeads(ModelMap model) {
		List<Lead> leads = leadService.listAllLeads();
		//System.out.println(leads);
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	
	@RequestMapping("/delete")
	public String deleteLead(@RequestParam("id") long id, ModelMap model) {
		leadService.deleteOneLead(id);
		List<Lead> leads = leadService.listAllLeads();
		//System.out.println(leads);
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	
	@RequestMapping("/update")
	public String updateLead(@RequestParam("id") long id, ModelMap model) {
		Lead findById = leadService.findById(id);
		model.addAttribute("leads", findById);
		return "update_lead";
	}
	
	@RequestMapping("/updateLead")
	public String updateOneLead(@ModelAttribute("lead") Lead l, ModelMap model) {
		leadService.saveOneLead(l);
		List<Lead> leads = leadService.listAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
}
