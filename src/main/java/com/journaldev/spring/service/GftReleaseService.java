package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.GftRelease;

public interface GftReleaseService {

	public void addGftRelease(GftRelease p);
	public void updateGftRelease(GftRelease p);
	public List<GftRelease> listGftReleases();
	public GftRelease getGftReleaseByReleaseId(int id);
	public void removeGftRelease(int id);
	
}
