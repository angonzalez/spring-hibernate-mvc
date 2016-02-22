package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.GftReleaseDAO;
import com.journaldev.spring.model.GftRelease;

@Service
public class GftReleaseServiceImpl implements GftReleaseService {
	
	private GftReleaseDAO gftReleaseDAO;

	public void setGftReleaseDAO(GftReleaseDAO releaseDAO) {
		this.gftReleaseDAO = releaseDAO;
	}

	@Override
	@Transactional
	public void addGftRelease(GftRelease p) {
		this.gftReleaseDAO.addGftRelease(p);
	}

	@Override
	@Transactional
	public void updateGftRelease(GftRelease p) {
		this.gftReleaseDAO.updateGftRelease(p);
	}

	@Override
	@Transactional
	public List<GftRelease> listGftReleases() {
		return this.gftReleaseDAO.listGftReleases();
	}

	@Override
	@Transactional
	public GftRelease getGftReleaseByReleaseId(int id) {
		return this.gftReleaseDAO.getGftReleaseByReleaseId(id);
	}

	@Override
	@Transactional
	public void removeGftRelease(int id) {
		this.gftReleaseDAO.removeGftRelease(id);
	}

}
