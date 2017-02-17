package com.ypeb.model.user.bankCard;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ypeb.model.user.user.User;

/**
 * Bankcard entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bankcard", catalog = "ypeb")
public class Bankcard extends AbstractBankcard implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Bankcard() {
	}

	/** full constructor */
	public Bankcard(User user, String cardNum, String bankName, String name) {
		super(user, cardNum, bankName, name);
	}

}
