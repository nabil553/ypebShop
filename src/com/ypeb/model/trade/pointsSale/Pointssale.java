package com.ypeb.model.trade.pointsSale;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Pointssale entity. @author MyEclipse Persistence Tools
 */
public class Pointssale extends AbstractPointssale implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Pointssale() {
	}

	public Pointssale(Integer saleId, Timestamp time, Double num, Double price,
			Double allPrice, Short state, Short residue, Boolean selectAll) {
		super(saleId, time, num, price, allPrice, state, residue, selectAll);
		// TODO Auto-generated constructor stub
	}

	/** full constructor */
	

}
