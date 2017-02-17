package com.ypeb.model.shopping.goodsCategory;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ypeb.model.shopping.goods.Goods;

/**
 * Goodscategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "goodscategory", catalog = "ypeb")
public class Goodscategory extends AbstractGoodscategory implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Goodscategory() {
	}

	public Goodscategory(String name, Boolean isFloor, Short level,
			Boolean isDelete) {
		super(name, isFloor, level, isDelete);
		// TODO Auto-generated constructor stub
	}

	public Goodscategory(String name, Boolean isFloor, Short level,
			Integer superId, String url, Boolean isDelete, String superName,
			Set<Goods> goodses) {
		super(name, isFloor, level, superId, url, isDelete, superName, goodses);
		// TODO Auto-generated constructor stub
	}

	/** minimal constructor */
	

	/** full constructor */

}
