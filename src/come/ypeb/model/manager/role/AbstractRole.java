package come.ypeb.model.manager.role;

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

import come.ypeb.model.manager.Manager;

/**
 * AbstractRole entity provides the base persistence definition of the Role
 * entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractRole implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Boolean super_;
	private Boolean shopWeb;
	private Boolean points;
	private Boolean member;
	private Boolean goodsOrder;
	private Boolean message;
	private Boolean setting;
	private Integer trade;
	private Boolean isDelete;
	private Set<Manager> managers = new HashSet<Manager>(0);

	// Constructors

	/** default constructor */
	public AbstractRole() {
	}

	/** minimal constructor */
	public AbstractRole(String name, Boolean super_, Boolean shopWeb,
			Boolean points, Boolean member, Boolean goodsOrder,
			Boolean message, Boolean setting, Integer trade) {
		this.name = name;
		this.super_ = super_;
		this.shopWeb = shopWeb;
		this.points = points;
		this.member = member;
		this.goodsOrder = goodsOrder;
		this.message = message;
		this.setting = setting;
		this.trade = trade;
	}

	/** full constructor */
	public AbstractRole(String name, Boolean super_, Boolean shopWeb,
			Boolean points, Boolean member, Boolean goodsOrder,
			Boolean message, Boolean setting, Integer trade, Boolean isDelete,
			Set<Manager> managers) {
		this.name = name;
		this.super_ = super_;
		this.shopWeb = shopWeb;
		this.points = points;
		this.member = member;
		this.goodsOrder = goodsOrder;
		this.message = message;
		this.setting = setting;
		this.trade = trade;
		this.isDelete = isDelete;
		this.managers = managers;
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

	@Column(name = "super", nullable = false)
	public Boolean getSuper_() {
		return this.super_;
	}

	public void setSuper_(Boolean super_) {
		this.super_ = super_;
	}

	@Column(name = "shopWeb", nullable = false)
	public Boolean getShopWeb() {
		return this.shopWeb;
	}

	public void setShopWeb(Boolean shopWeb) {
		this.shopWeb = shopWeb;
	}

	@Column(name = "points", nullable = false)
	public Boolean getPoints() {
		return this.points;
	}

	public void setPoints(Boolean points) {
		this.points = points;
	}

	@Column(name = "member", nullable = false)
	public Boolean getMember() {
		return this.member;
	}

	public void setMember(Boolean member) {
		this.member = member;
	}

	@Column(name = "goodsOrder", nullable = false)
	public Boolean getGoodsOrder() {
		return this.goodsOrder;
	}

	public void setGoodsOrder(Boolean goodsOrder) {
		this.goodsOrder = goodsOrder;
	}

	@Column(name = "message", nullable = false)
	public Boolean getMessage() {
		return this.message;
	}

	public void setMessage(Boolean message) {
		this.message = message;
	}

	@Column(name = "setting", nullable = false)
	public Boolean getSetting() {
		return this.setting;
	}

	public void setSetting(Boolean setting) {
		this.setting = setting;
	}

	@Column(name = "trade", nullable = false)
	public Integer getTrade() {
		return this.trade;
	}

	public void setTrade(Integer trade) {
		this.trade = trade;
	}

	@Column(name = "isDelete")
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	public Set<Manager> getManagers() {
		return this.managers;
	}

	public void setManagers(Set<Manager> managers) {
		this.managers = managers;
	}

}