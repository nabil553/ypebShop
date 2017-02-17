package com.ypeb.model.shopping.advertisement;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractAdvertisement entity provides the base persistence definition of the
 * Advertisement entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractAdvertisement implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String descripe;
	private String url;
	private Integer type;

	// Constructors

	/** default constructor */
	public AbstractAdvertisement() {
	}

	/** full constructor */
	public AbstractAdvertisement(String name, String descripe, String url,
			Integer type) {
		this.name = name;
		this.descripe = descripe;
		this.url = url;
		this.type = type;
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

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "descripe", nullable = false, length = 45)
	public String getDescripe() {
		return this.descripe;
	}

	public void setDescripe(String descripe) {
		this.descripe = descripe;
	}

	@Column(name = "url", nullable = false, length = 45)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "type", nullable = false)
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}