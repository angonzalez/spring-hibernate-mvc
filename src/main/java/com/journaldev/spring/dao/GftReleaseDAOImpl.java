package com.journaldev.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.model.GftRelease;

@Transactional
@Repository
public class GftReleaseDAOImpl implements GftReleaseDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(GftReleaseDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addGftRelease(GftRelease p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Release saved successfully, Release Details="+p);
	}

	@Override
	public void updateGftRelease(GftRelease p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Release updated successfully, Release Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GftRelease> listGftReleases() {
		Session session = this.sessionFactory.getCurrentSession();
		List<GftRelease> reasonList = session.createQuery("from GftRelease").list();
		for(GftRelease p : reasonList){
			logger.info("Release List::"+p);
		}
		return reasonList;
	}

	@Override
	public GftRelease getGftReleaseByReleaseId(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		GftRelease p = (GftRelease) session.load(GftRelease.class, new Integer(id));
		logger.info("Release loaded successfully, Release details="+p);
		return p;
	}

	@Override
	public void removeGftRelease(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		GftRelease p = (GftRelease) session.load(GftRelease.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Release deleted successfully, Release details="+p);
	}
	

}
