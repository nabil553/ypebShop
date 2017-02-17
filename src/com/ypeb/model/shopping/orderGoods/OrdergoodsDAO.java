package com.ypeb.model.shopping.orderGoods;

import com.ypeb.model.trade.pointsSale.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Ordergoods entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ypeb.model.shopping.orderGoods.Ordergoods
 * @author MyEclipse Persistence Tools
 */
public class OrdergoodsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(OrdergoodsDAO.class);
	// property constants
	public static final String GOODS_ID = "goodsId";
	public static final String GOODS_NAME = "goodsName";
	public static final String NUM = "num";
	public static final String UNIT_PRICE = "unitPrice";
	public static final String TOTAL_PRICE = "totalPrice";
	public static final String ORDER_ID = "orderId";
	public static final String GOODS_IMAGE = "goodsImage";

	public void save(Ordergoods transientInstance) {
		log.debug("saving Ordergoods instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Ordergoods persistentInstance) {
		log.debug("deleting Ordergoods instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ordergoods findById(java.lang.Integer id) {
		log.debug("getting Ordergoods instance with id: " + id);
		try {
			Ordergoods instance = (Ordergoods) getSession().get(
					"com.ypeb.model.shopping.orderGoods.Ordergoods", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Ordergoods> findByExample(Ordergoods instance) {
		log.debug("finding Ordergoods instance by example");
		try {
			List<Ordergoods> results = (List<Ordergoods>) getSession()
					.createCriteria(
							"com.ypeb.model.shopping.orderGoods.Ordergoods")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Ordergoods instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Ordergoods as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Ordergoods> findByGoodsId(Object goodsId) {
		return findByProperty(GOODS_ID, goodsId);
	}

	public List<Ordergoods> findByGoodsName(Object goodsName) {
		return findByProperty(GOODS_NAME, goodsName);
	}

	public List<Ordergoods> findByNum(Object num) {
		return findByProperty(NUM, num);
	}

	public List<Ordergoods> findByUnitPrice(Object unitPrice) {
		return findByProperty(UNIT_PRICE, unitPrice);
	}

	public List<Ordergoods> findByTotalPrice(Object totalPrice) {
		return findByProperty(TOTAL_PRICE, totalPrice);
	}

	public List<Ordergoods> findByOrderId(Object orderId) {
		return findByProperty(ORDER_ID, orderId);
	}

	public List<Ordergoods> findByGoodsImage(Object goodsImage) {
		return findByProperty(GOODS_IMAGE, goodsImage);
	}

	public List findAll() {
		log.debug("finding all Ordergoods instances");
		try {
			String queryString = "from Ordergoods";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Ordergoods merge(Ordergoods detachedInstance) {
		log.debug("merging Ordergoods instance");
		try {
			Ordergoods result = (Ordergoods) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Ordergoods instance) {
		log.debug("attaching dirty Ordergoods instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Ordergoods instance) {
		log.debug("attaching clean Ordergoods instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}