package com.ypeb.model.shopping.shoppingCar;

import com.ypeb.model.trade.pointsSale.BaseHibernateDAO;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Shoppingcar entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ypeb.model.shopping.shoppingCar.Shoppingcar
 * @author MyEclipse Persistence Tools
 */
public class ShoppingcarDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ShoppingcarDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String GOODS_ID = "goodsId";
	public static final String NUM = "num";
	public static final String PRICE = "price";
	public static final String ALL_PRICE = "allPrice";

	public void save(Shoppingcar transientInstance) {
		log.debug("saving Shoppingcar instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Shoppingcar persistentInstance) {
		log.debug("deleting Shoppingcar instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Shoppingcar findById(java.lang.Integer id) {
		log.debug("getting Shoppingcar instance with id: " + id);
		try {
			Shoppingcar instance = (Shoppingcar) getSession().get(
					"com.ypeb.model.shopping.shoppingCar.Shoppingcar", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Shoppingcar> findByExample(Shoppingcar instance) {
		log.debug("finding Shoppingcar instance by example");
		try {
			List<Shoppingcar> results = (List<Shoppingcar>) getSession()
					.createCriteria(
							"com.ypeb.model.shopping.shoppingCar.Shoppingcar")
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
		log.debug("finding Shoppingcar instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Shoppingcar as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Shoppingcar> findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List<Shoppingcar> findByGoodsId(Object goodsId) {
		return findByProperty(GOODS_ID, goodsId);
	}

	public List<Shoppingcar> findByNum(Object num) {
		return findByProperty(NUM, num);
	}

	public List<Shoppingcar> findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List<Shoppingcar> findByAllPrice(Object allPrice) {
		return findByProperty(ALL_PRICE, allPrice);
	}

	public List findAll() {
		log.debug("finding all Shoppingcar instances");
		try {
			String queryString = "from Shoppingcar";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Shoppingcar merge(Shoppingcar detachedInstance) {
		log.debug("merging Shoppingcar instance");
		try {
			Shoppingcar result = (Shoppingcar) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Shoppingcar instance) {
		log.debug("attaching dirty Shoppingcar instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Shoppingcar instance) {
		log.debug("attaching clean Shoppingcar instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}