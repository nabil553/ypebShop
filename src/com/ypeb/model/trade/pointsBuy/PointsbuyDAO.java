package com.ypeb.model.trade.pointsBuy;

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
 * Pointsbuy entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ypeb.model.trade.pointsBuy.Pointsbuy
 * @author MyEclipse Persistence Tools
 */
public class PointsbuyDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PointsbuyDAO.class);
	// property constants
	public static final String BUY_ID = "buyId";
	public static final String PRICE = "price";
	public static final String NUM = "num";
	public static final String ALL_PRICE = "allPrice";
	public static final String STATE = "state";
	public static final String RESIDUE = "residue";

	public void save(Pointsbuy transientInstance) {
		log.debug("saving Pointsbuy instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Pointsbuy persistentInstance) {
		log.debug("deleting Pointsbuy instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Pointsbuy findById(java.lang.Integer id) {
		log.debug("getting Pointsbuy instance with id: " + id);
		try {
			Pointsbuy instance = (Pointsbuy) getSession().get(
					"com.ypeb.model.points.pointsBuy.Pointsbuy", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Pointsbuy> findByExample(Pointsbuy instance) {
		log.debug("finding Pointsbuy instance by example");
		try {
			List<Pointsbuy> results = (List<Pointsbuy>) getSession()
					.createCriteria("com.ypeb.model.points.pointsBuy.Pointsbuy")
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
		log.debug("finding Pointsbuy instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Pointsbuy as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Pointsbuy> findByBuyId(Object buyId) {
		return findByProperty(BUY_ID, buyId);
	}

	public List<Pointsbuy> findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List<Pointsbuy> findByNum(Object num) {
		return findByProperty(NUM, num);
	}

	public List<Pointsbuy> findByAllPrice(Object allPrice) {
		return findByProperty(ALL_PRICE, allPrice);
	}

	public List<Pointsbuy> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<Pointsbuy> findByResidue(Object residue) {
		return findByProperty(RESIDUE, residue);
	}

	public List findAll() {
		log.debug("finding all Pointsbuy instances");
		try {
			String queryString = "from Pointsbuy";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Pointsbuy merge(Pointsbuy detachedInstance) {
		log.debug("merging Pointsbuy instance");
		try {
			Pointsbuy result = (Pointsbuy) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Pointsbuy instance) {
		log.debug("attaching dirty Pointsbuy instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Pointsbuy instance) {
		log.debug("attaching clean Pointsbuy instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}