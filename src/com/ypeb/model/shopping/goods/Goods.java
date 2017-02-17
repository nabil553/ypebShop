package com.ypeb.model.shopping.goods;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ypeb.model.shopping.goodsCategory.Goodscategory;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "goods", catalog = "ypeb")
public class Goods extends AbstractGoods implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Goods() {
	}

	public Goods(Goodscategory goodscategory, String name, Double price,
			Double givePoints, Double discountPrice, Boolean isShow,
			Double purchacePrice, String attribute, String code,
			Boolean isDelete) {
		super(goodscategory, name, price, givePoints, discountPrice, isShow,
				purchacePrice, attribute, code, isDelete);
		// TODO Auto-generated constructor stub
	}

	public Goods(Goodscategory goodscategory, String name,
			String specification, String description, String imageUrl1,
			Double price, Double givePoints, Double discountPrice,
			Boolean isShow, Double purchacePrice, String attribute,
			String imageUrl2, String imageUrl3, String imageUrl4,
			String imageUrl5, String code, Integer secondCateg,
			Integer thirdCateg, Integer category2, String timeMark,
			String telephone, String linkMan, String webChat, Boolean isDelete,
			String category2name) {
		super(goodscategory, name, specification, description, imageUrl1, price,
				givePoints, discountPrice, isShow, purchacePrice, attribute, imageUrl2,
				imageUrl3, imageUrl4, imageUrl5, code, secondCateg, thirdCateg,
				category2, timeMark, telephone, linkMan, webChat, isDelete,
				category2name);
		// TODO Auto-generated constructor stub
	}

	

	

	/** minimal constructor */

	/** full constructor */

}
