package com.ypeb.model.shopping.goodsCategory;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.ypeb.model.shopping.goods.Goods;

/**
 * AbstractGoodscategory entity provides the base persistence definition of the
 * Goodscategory entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractGoodscategory implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Boolean isFloor;
	private Short level;
	private Integer superId;
	private String url;
	private Boolean isDelete;
	private String superName;
	private Set<Goods> goodses = new HashSet<Goods>(0);

	// Constructors

	/** default constructor */
	public AbstractGoodscategory() {
	}

	/** minimal constructor */
	public AbstractGoodscategory(String name, Boolean isFloor, Short level,
			Boolean isDelete) {
		this.name = name;
		this.isFloor = isFloor;
		this.level = level;
		this.isDelete = isDelete;
	}

	/** full constructor */
	public AbstractGoodscategory(String name, Boolean isFloor, Short level,
			Integer superId, String url, Boolean isDelete, String superName,
			Set<Goods> goodses) {
		this.name = name;
		this.isFloor = isFloor;
		this.level = level;
		this.superId = superId;
		this.url = url;
		this.isDelete = isDelete;
		this.superName = superName;
		this.goodses = goodses;
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

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "isFloor", nullable = false)
	public Boolean getIsFloor() {
		return this.isFloor;
	}

	public void setIsFloor(Boolean isFloor) {
		this.isFloor = isFloor;
	}

	@Column(name = "level", nullable = false)
	public Short getLevel() {
		return this.level;
	}

	public void setLevel(Short level) {
		this.level = level;
	}

	@Column(name = "superID")
	public Integer getSuperId() {
		return this.superId;
	}

	public void setSuperId(Integer superId) {
		this.superId = superId;
	}

	@Column(name = "url", length = 45)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "isDelete", nullable = false)
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Column(name = "superName", length = 45)
	public String getSuperName() {
		return this.superName;
	}

	public void setSuperName(String superName) {
		this.superName = superName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "goodscategory")
	public Set<Goods> getGoodses() {
		return this.goodses;
	}

	public void setGoodses(Set<Goods> goodses) {
		this.goodses = goodses;
	}

}