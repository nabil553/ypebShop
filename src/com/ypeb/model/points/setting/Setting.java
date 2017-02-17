package com.ypeb.model.points.setting;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Setting entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "setting", catalog = "ypeb")
public class Setting extends AbstractSetting implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Setting() {
	}

	public Setting(Double price, Short month, Short giveDays,
			Short consumeDays, Double withdrawRate, Double firstAward,
			Double secondAward, Integer maxPoints, Double feedbackAward,
			Boolean isUsing, Boolean isDelete) {
		super(price, month, giveDays, consumeDays, withdrawRate, firstAward,
				secondAward, maxPoints, feedbackAward, isUsing, isDelete);
		// TODO Auto-generated constructor stub
	}

	public Setting(Double price, Short month, Short giveDays,
			Short consumeDays, Double withdrawRate, Double firstAward,
			Double secondAward, Integer maxPoints, Double feedbackAward,
			Boolean isDelete) {
		super(price, month, giveDays, consumeDays, withdrawRate, firstAward,
				secondAward, maxPoints, feedbackAward, isDelete);
		// TODO Auto-generated constructor stub
	}

	/** full constructor */
	
}
