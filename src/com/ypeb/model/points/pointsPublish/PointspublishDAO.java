package com.ypeb.model.points.pointsPublish;

import com.ypeb.model.trade.pointsSale.BaseHibernateDAO;


import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;


import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Pointspublish entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ypeb.model.points.pointsPublish.Pointspublish
 * @author MyEclipse Persistence Tools
 */
public class PointspublishDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PointspublishDAO.class);
	// property constants
	public static final String OPERATOR = "operator";
	public static final String TOTAL_NUM = "totalNum";
	public static final String RESIDUE = "residue";
	public static final String RELEASE_TIME = "releaseTime";
	public static final String STATE = "state";

	
	public List<Pointspublish> findOrderByTime() {
		final DetachedCriteria query = DetachedCriteria  
	            .forClass(Pointspublish.class);  
	    Criteria criteria = query.getExecutableCriteria(getSession());  
	    
	    criteria.addOrder(Order.desc("time"));
		    
	    
	    @SuppressWarnings("unchecked")  
	    List<Pointspublish> list = criteria.list();  
	    return list;  
	}
	
	public void save(Pointspublish transientInstance) {
		log.debug("saving Pointspublish instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Pointspublish persistentInstance) {
		log.debug("deleting Pointspublish instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Pointspublish findById(java.lang.Integer id) {
		log.debug("getting Pointspublish instance with id: " + id);
		try {
			Pointspublish instance = (Pointspublish) getSession().get(
					"com.ypeb.model.points.pointsPublish.Pointspublish", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Pointspublish> findByExample(Pointspublish instance) {
		log.debug("finding Pointspublish instance by example");
		try {
			List<Pointspublish> results = (List<Pointspublish>) getSession()
					.createCriteria(
							"com.ypeb.model.points.pointsPublish.Pointspublish")
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
		log.debug("finding Pointspublish instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Pointspublish as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Pointspublish> findByOperator(Object operator) {
		return findByProperty(OPERATOR, operator);
	}

	public List<Pointspublish> findByTotalNum(Object totalNum) {
		return findByProperty(TOTAL_NUM, totalNum);
	}

	public List<Pointspublish> findByResidue(Object residue) {
		return findByProperty(RESIDUE, residue);
	}

	public List<Pointspublish> findByReleaseTime(Object releaseTime) {
		return findByProperty(RELEASE_TIME, releaseTime);
	}

	public List<Pointspublish> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all Pointspublish instances");
		try {
			String queryString = "from Pointspublish";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Pointspublish merge(Pointspublish detachedInstance) {
		log.debug("merging Pointspublish instance");
		try {
			Pointspublish result = (Pointspublish) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Pointspublish instance) {
		log.debug("attaching dirty Pointspublish instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Pointspublish instance) {
		log.debug("attaching clean Pointspublish instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}