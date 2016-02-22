package com.journaldev.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.GftRelease;
import com.journaldev.spring.service.GftReleaseService;

@Controller
public class GftReleaseController {
	
	private GftReleaseService gftReleaseService;
	
	@Autowired(required=true)
	@Qualifier(value="gftReleaseService")
	public void setGftReleaseService(GftReleaseService ps){
		this.gftReleaseService = ps;
	}
	
	@RequestMapping(value = "/gftreleases", method = RequestMethod.GET)
	public String listReleases(Model model) {
		model.addAttribute("gftrelease", new GftRelease());
		model.addAttribute("listGftReleases", this.gftReleaseService.listGftReleases());
		return "gftrelease";
	}
	
	//For add and update person both
	@RequestMapping(value= "/gftrelease/add", method = RequestMethod.POST)
	public String addRelease(@ModelAttribute("release") GftRelease p){
		
		if(p.getReleaseId() == 0){
			//new person, add it
			this.gftReleaseService.addGftRelease(p);
		}else{
			//existing person, call update
			this.gftReleaseService.updateGftRelease(p);
		}
		
		return "redirect:/gftreleases";
	}
	
	@RequestMapping("/gftrelease/remove/{releaseId}")
    public String removeRelease(@PathVariable("releaseId") int id){
        this.gftReleaseService.removeGftRelease(id);
        return "redirect:/gftreleases";
    }
	
    @RequestMapping("/gftrelease/edit/{releaseId}")
    public String editRelease(@PathVariable("releaseId") int id, Model model){
        model.addAttribute("gftrelease", this.gftReleaseService.getGftReleaseByReleaseId(id));
        model.addAttribute("listGftReleases", this.gftReleaseService.listGftReleases());
        return "gftrelease";
    }
	
}
