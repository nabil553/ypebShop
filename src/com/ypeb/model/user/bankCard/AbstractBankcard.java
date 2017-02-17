package com.ypeb.model.user.bankCard;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.ypeb.model.user.user.User;

/**
 * AbstractBankcard entity provides the base persistence definition of the
 * Bankcard entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractBankcard implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String cardNum;
	private String bankName;
	private String name;
	private Boolean isDelete;

	// Constructors

	/** default constructor */
	public AbstractBankcard() {
	}

	/** minimal constructor */
	public AbstractBankcard(User user, String cardNum, String bankName,
			String name) {
		this.user = user;
		this.cardNum = cardNum;
		this.bankName = bankName;
		this.name = name;
	}

	/** full constructor */
	public AbstractBankcard(User user, String cardNum, String bankName,
			String name, Boolean isDelete) {
		this.user = user;
		this.cardNum = cardNum;
		this.bankName = bankName;
		this.name = name;
		this.isDelete = isDelete;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userID", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "cardNum", nullable = false, length = 30)
	public String getCardNum() {
		return this.cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	@Column(name = "bankName", nullable = false, length = 45)
	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "isDelete")
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

}