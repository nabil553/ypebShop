package com.ypeb.model.trade.pointsBuy;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Pointsbuy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pointsbuy", catalog = "ypeb")
public class Pointsbuy extends AbstractPointsbuy implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Pointsbuy() {
	}

	/** full constructor */
	public Pointsbuy(Integer buyId, Timestamp time, Double price, Double num,
			Double allPrice, Short state, Double residue) {
		super(buyId, time, price, num, allPrice, state, residue);
	}

}
