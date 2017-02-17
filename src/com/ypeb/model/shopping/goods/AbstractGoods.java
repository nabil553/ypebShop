package com.ypeb.model.shopping.goods;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.ypeb.model.shopping.goodsCategory.Goodscategory;

/**
 * AbstractGoods entity provides the base persistence definition of the Goods
 * entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractGoods implements java.io.Serializable {

	// Fields

	private Integer id;
	private Goodscategory goodscategory;
	private String name;
	private String specification;
	private String description;
	private String imageUrl1;
	private Double price;
	private Double givePoints;
	private Double discountPrice;
	private Boolean isShow;
	private Double purchacePrice;
	private String attribute;
	private String imageUrl2;
	private String imageUrl3;
	private String imageUrl4;
	private String imageUrl5;
	private String code;
	private Integer secondCateg;
	private Integer thirdCateg;
	private Integer category2;
	private String timeMark;
	private String telephone;
	private String linkMan;
	private String webChat;
	private Boolean isDelete;
	private String category2name;

	// Constructors

	/** default constructor */
	public AbstractGoods() {
	}

	/** minimal constructor */
	public AbstractGoods(Goodscategory goodscategory, String name,
			Double price, Double givePoints, Double discountPrice,
			Boolean isShow, Double purchacePrice, String attribute,
			String code, Boolean isDelete) {
		this.goodscategory = goodscategory;
		this.name = name;
		this.price = price;
		this.givePoints = givePoints;
		this.discountPrice = discountPrice;
		this.isShow = isShow;
		this.purchacePrice = purchacePrice;
		this.attribute = attribute;
		this.code = code;
		this.isDelete = isDelete;
	}

	/** full constructor */
	public AbstractGoods(Goodscategory goodscategory, String name,
			String specification, String description, String imageUrl1,
			Double price, Double givePoints, Double discountPrice,
			Boolean isShow, Double purchacePrice, String attribute,
			String imageUrl2, String imageUrl3, String imageUrl4,
			String imageUrl5, String code, Integer secondCateg,
			Integer thirdCateg, Integer category2, String timeMark,
			String telephone, String linkMan, String webChat, Boolean isDelete,
			String category2name) {
		this.goodscategory = goodscategory;
		this.name = name;
		this.specification = specification;
		this.description = description;
		this.imageUrl1 = imageUrl1;
		this.price = price;
		this.givePoints = givePoints;
		this.discountPrice = discountPrice;
		this.isShow = isShow;
		this.purchacePrice = purchacePrice;
		this.attribute = attribute;
		this.imageUrl2 = imageUrl2;
		this.imageUrl3 = imageUrl3;
		this.imageUrl4 = imageUrl4;
		this.imageUrl5 = imageUrl5;
		this.code = code;
		this.secondCateg = secondCateg;
		this.thirdCateg = thirdCateg;
		this.category2 = category2;
		this.timeMark = timeMark;
		this.telephone = telephone;
		this.linkMan = linkMan;
		this.webChat = webChat;
		this.isDelete = isDelete;
		this.category2name = category2name;
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
	@JoinColumn(name = "category1", nullable = false)
	public Goodscategory getGoodscategory() {
		return this.goodscategory;
	}

	public void setGoodscategory(Goodscategory goodscategory) {
		this.goodscategory = goodscategory;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "specification", length = 65535)
	public String getSpecification() {
		return this.specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "imageUrl1", length = 45)
	public String getImageUrl1() {
		return this.imageUrl1;
	}

	public void setImageUrl1(String imageUrl1) {
		this.imageUrl1 = imageUrl1;
	}

	@Column(name = "price", nullable = false, precision = 11)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "givePoints", nullable = false, length = 45)
	public Double getGivePoints() {
		return this.givePoints;
	}

	public void setGivePoints(Double givePoints) {
		this.givePoints = givePoints;
	}

	@Column(name = "discountPrice", nullable = false, precision = 11)
	public Double getDiscountPrice() {
		return this.discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	@Column(name = "isShow", nullable = false)
	public Boolean getIsShow() {
		return this.isShow;
	}

	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}

	@Column(name = "purchacePrice", nullable = false, precision = 11)
	public Double getPurchacePrice() {
		return this.purchacePrice;
	}

	public void setPurchacePrice(Double purchacePrice) {
		this.purchacePrice = purchacePrice;
	}

	@Column(name = "attribute", nullable = false, length = 10)
	public String getAttribute() {
		return this.attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	@Column(name = "imageUrl2", length = 45)
	public String getImageUrl2() {
		return this.imageUrl2;
	}

	public void setImageUrl2(String imageUrl2) {
		this.imageUrl2 = imageUrl2;
	}

	@Column(name = "imageUrl3", length = 45)
	public String getImageUrl3() {
		return this.imageUrl3;
	}

	public void setImageUrl3(String imageUrl3) {
		this.imageUrl3 = imageUrl3;
	}

	@Column(name = "imageUrl4", length = 45)
	public String getImageUrl4() {
		return this.imageUrl4;
	}

	public void setImageUrl4(String imageUrl4) {
		this.imageUrl4 = imageUrl4;
	}

	@Column(name = "imageUrl5", length = 45)
	public String getImageUrl5() {
		return this.imageUrl5;
	}

	public void setImageUrl5(String imageUrl5) {
		this.imageUrl5 = imageUrl5;
	}

	@Column(name = "code", nullable = false, length = 45)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "secondCateg")
	public Integer getSecondCateg() {
		return this.secondCateg;
	}

	public void setSecondCateg(Integer secondCateg) {
		this.secondCateg = secondCateg;
	}

	@Column(name = "thirdCateg")
	public Integer getThirdCateg() {
		return this.thirdCateg;
	}

	public void setThirdCateg(Integer thirdCateg) {
		this.thirdCateg = thirdCateg;
	}

	@Column(name = "category2")
	public Integer getCategory2() {
		return this.category2;
	}

	public void setCategory2(Integer category2) {
		this.category2 = category2;
	}

	@Column(name = "timeMark", length = 45)
	public String getTimeMark() {
		return this.timeMark;
	}

	public void setTimeMark(String timeMark) {
		this.timeMark = timeMark;
	}

	@Column(name = "telephone", length = 12)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "linkMan", length = 20)
	public String getLinkMan() {
		return this.linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	@Column(name = "webChat", length = 45)
	public String getWebChat() {
		return this.webChat;
	}

	public void setWebChat(String webChat) {
		this.webChat = webChat;
	}

	@Column(name = "isDelete", nullable = false)
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Column(name = "category2Name", length = 45)
	public String getCategory2name() {
		return this.category2name;
	}

	public void setCategory2name(String category2name) {
		this.category2name = category2name;
	}

}