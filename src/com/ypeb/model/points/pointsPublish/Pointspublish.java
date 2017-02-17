package com.ypeb.model.points.pointsPublish;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ypeb.model.points.points.Points;

/**
 * Pointspublish entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pointspublish", catalog = "ypeb")
public class Pointspublish extends AbstractPointspublish implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Pointspublish() {
	}

	/** minimal constructor */
	public Pointspublish(Integer operator, Timestamp time, Double totalNum,
			Double residue, Integer releaseTime, Boolean state) {
		super(operator, time, totalNum, residue, releaseTime, state);
	}

	/** full constructor */

}
