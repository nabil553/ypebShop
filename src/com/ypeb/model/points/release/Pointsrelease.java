package com.ypeb.model.points.release;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Pointsrelease entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pointsrelease", catalog = "ypeb")
public class Pointsrelease extends AbstractPointsrelease implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Pointsrelease() {
	}

	/** full constructor */
	public Pointsrelease(Integer userId, Double pointsNum, Short releaseTime,
			Date beginTime, Short source, Short releasedT, Boolean isFinish,
			String residue) {
		super(userId, pointsNum, releaseTime, beginTime, source, releasedT,
				isFinish, residue);
	}

}
