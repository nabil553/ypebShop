package com.ypeb.model.trade.pointsTrade;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Pointtrade entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pointtrade", catalog = "ypeb")
public class Pointtrade extends AbstractPointtrade implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Pointtrade() {
	}

	/** full constructor */
	public Pointtrade(Integer saleId, Integer buyId, Double num, Double price,
			Double allprice, Timestamp time, Short iceTime) {
		super(saleId, buyId, num, price, allprice, time, iceTime);
	}

}
