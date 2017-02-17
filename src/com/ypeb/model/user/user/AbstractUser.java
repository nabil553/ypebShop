package com.ypeb.model.user.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.ypeb.model.user.address.Address;
import com.ypeb.model.user.bankCard.Bankcard;

/**
 * AbstractUser entity provides the base persistence definition of the User
 * entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String password;
	private String payPassword;
	private String telephone;
	private String name;
	private String province;
	private String city;
	private String country;
	private String idcard;
	private Short level;
	private Double cash;
	private Double usingPoints;
	private Boolean inforIsFull;
	private String imageUrl;
	private Integer style;
	private Double icePoints;
	private Double tradePoints;
	private String bankCard;
	private Boolean isDelete;
	private Set<Address> addresses = new HashSet<Address>(0);
	private Set<User> users = new HashSet<User>(0);
	private Set<Bankcard> bankcards = new HashSet<Bankcard>(0);

	// Constructors

	/** default constructor */
	public AbstractUser() {
	}

	/** minimal constructor */
	public AbstractUser(String password, String payPassword, String telephone,
			String name, String province, String city, String country,
			Short level, Boolean inforIsFull, Integer style) {
		this.password = password;
		this.payPassword = payPassword;
		this.telephone = telephone;
		this.name = name;
		this.province = province;
		this.city = city;
		this.country = country;
		this.level = level;
		this.inforIsFull = inforIsFull;
		this.style = style;
	}

	/** full constructor */
	public AbstractUser(User user, String password, String payPassword,
			String telephone, String name, String province, String city,
			String country, String idcard, Short level, Double cash,
			Double usingPoints, Boolean inforIsFull, String imageUrl,
			Integer style, Double icePoints, Double tradePoints,
			String bankCard, Boolean isDelete, Set<Address> addresses,
			Set<User> users, Set<Bankcard> bankcards) {
		this.user = user;
		this.password = password;
		this.payPassword = payPassword;
		this.telephone = telephone;
		this.name = name;
		this.province = province;
		this.city = city;
		this.country = country;
		this.idcard = idcard;
		this.level = level;
		this.cash = cash;
		this.usingPoints = usingPoints;
		this.inforIsFull = inforIsFull;
		this.imageUrl = imageUrl;
		this.style = style;
		this.icePoints = icePoints;
		this.tradePoints = tradePoints;
		this.bankCard = bankCard;
		this.isDelete = isDelete;
		this.addresses = addresses;
		this.users = users;
		this.bankcards = bankcards;
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
	@JoinColumn(name = "refferrer")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "password", nullable = false, length = 40)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "payPassword", nullable = false, length = 40)
	public String getPayPassword() {
		return this.payPassword;
	}

	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}

	@Column(name = "telephone", nullable = false, length = 11)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "province", nullable = false, length = 10)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "city", nullable = false, length = 20)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "country", nullable = false, length = 30)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "IDcard", length = 20)
	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	@Column(name = "level", nullable = false)
	public Short getLevel() {
		return this.level;
	}

	public void setLevel(Short level) {
		this.level = level;
	}

	@Column(name = "cash", precision = 12)
	public Double getCash() {
		return this.cash;
	}

	public void setCash(Double cash) {
		this.cash = cash;
	}

	@Column(name = "usingPoints", precision = 12)
	public Double getUsingPoints() {
		return this.usingPoints;
	}

	public void setUsingPoints(Double usingPoints) {
		this.usingPoints = usingPoints;
	}

	@Column(name = "inforIsFull", nullable = false)
	public Boolean getInforIsFull() {
		return this.inforIsFull;
	}

	public void setInforIsFull(Boolean inforIsFull) {
		this.inforIsFull = inforIsFull;
	}

	@Column(name = "imageURL", length = 45)
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name = "style", nullable = false)
	public Integer getStyle() {
		return this.style;
	}

	public void setStyle(Integer style) {
		this.style = style;
	}

	@Column(name = "icePoints", precision = 12)
	public Double getIcePoints() {
		return this.icePoints;
	}

	public void setIcePoints(Double icePoints) {
		this.icePoints = icePoints;
	}

	@Column(name = "tradePoints", precision = 12)
	public Double getTradePoints() {
		return this.tradePoints;
	}

	public void setTradePoints(Double tradePoints) {
		this.tradePoints = tradePoints;
	}

	@Column(name = "bankCard", length = 45)
	public String getBankCard() {
		return this.bankCard;
	}

	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}

	@Column(name = "isDelete")
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Bankcard> getBankcards() {
		return this.bankcards;
	}

	public void setBankcards(Set<Bankcard> bankcards) {
		this.bankcards = bankcards;
	}

}