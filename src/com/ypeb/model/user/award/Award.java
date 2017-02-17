package com.ypeb.model.user.award;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Award entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "award", catalog = "ypeb")
public class Award extends AbstractAward implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Award() {
	}

	/** full constructor */
	public Award(Integer getAwardId, Short level, Timestamp time, Double num,
			Integer sourceId) {
		super(getAwardId, level, time, num, sourceId);
	}

}
