package com.journaldev.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="GFT_RELEASE")
public class GftRelease {

	@Id
	@Column(name="release_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int releaseId;
	@Column(name="release_name")
	private String releaseName;
	@Column(name="release_description")
	private String releaseDescription;

	public int getReleaseId() {
		return releaseId;
	}


	public void setReleaseId(int id) {
		this.releaseId = id;
	}

	public String getReleaseName() {
		return releaseName;
	}

	public void setReleaseName(String name) {
		this.releaseName = name;
	}

	public String getReleaseDescription() {
		return releaseDescription;
	}

	public void setReleaseDescription(String country) {
		this.releaseDescription = country;
	}
	
	@Override
	public String toString(){
		return "release_id="+releaseId+", release_name="+releaseName+", release_description="+releaseDescription;
	}
}
