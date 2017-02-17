package com.ypeb.model.user.address;

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
 * AbstractAddress entity provides the base persistence definition of the
 * Address entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractAddress implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String address;
	private String name;
	private String telephone;
	private Boolean isDelete;

	// Constructors

	/** default constructor */
	public AbstractAddress() {
	}

	/** full constructor */
	public AbstractAddress(User user, String address, String name,
			String telephone, Boolean isDelete) {
		this.user = user;
		this.address = address;
		this.name = name;
		this.telephone = telephone;
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

	@Column(name = "address", nullable = false, length = 60)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "telephone", nullable = false, length = 11)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "isDelete", nullable = false)
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

}