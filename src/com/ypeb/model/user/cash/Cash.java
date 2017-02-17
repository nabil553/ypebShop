package com.ypeb.model.user.cash;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Cash entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cash", catalog = "ypeb")
public class Cash extends AbstractCash implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Cash() {
	}

	public Cash(Integer userId, Double num, Timestamp time, Integer operator,
			Boolean operate, Short state, Double rate) {
		super(userId, num, time, operator, operate, state, rate);
		// TODO Auto-generated constructor stub
	}

	public Cash(Integer userId, Double num, Timestamp time, Integer operator,
			Boolean operate, Short state, String webChat, Double rate) {
		super(userId, num, time, operator, operate, state, webChat, rate);
		// TODO Auto-generated constructor stub
	}

	
	/** full constructor */

}
