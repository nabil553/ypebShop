package com.ypeb.model.shopping.advertisement;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Advertisement entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "advertisement", catalog = "ypeb")
public class Advertisement extends AbstractAdvertisement implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Advertisement() {
	}

	public Advertisement(String name, String descripe, String url, Integer type) {
		super(name, descripe, url, type);
		// TODO Auto-generated constructor stub
	}

	/** full constructor */
	

}
