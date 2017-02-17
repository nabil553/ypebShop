package com.ypeb.model.user.bankCard;

import com.ypeb.model.trade.pointsSale.BaseHibernateDAO;
import com.ypeb.model.user.user.User;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Bankcard entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ypeb.model.user.bankCard.Bankcard
 * @author MyEclipse Persistence Tools
 */
public class BankcardDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BankcardDAO.class);
	// property constants
	public static final String CARD_NUM = "cardNum";
	public static final String BANK_NAME = "bankName";
	public static final String NAME = "name";
	public static final String IS_DELETE = "isDelete";

	
	public List<Bankcard> findByCard(User user,boolean isDelete) {  
	    final DetachedCriteria query = DetachedCriteria  
	            .forClass(Bankcard.class);  
	    Criteria criteria = query.getExecutableCriteria(getSession());  
	    criteria.add(Restrictions.eq("user", user));
	    criteria.add(Restrictions.eq("isDelete", false));
	    @SuppressWarnings("unchecked")  
	    List<Bankcard> list = criteria.list();  
	    return list;  
	}
	
	
	
	
	public void save(Bankcard transientInstance) {
		log.debug("saving Bankcard instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Bankcard persistentInstance) {
		log.debug("deleting Bankcard instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Bankcard findById(java.lang.Integer id) {
		log.debug("getting Bankcard instance with id: " + id);
		try {
			Bankcard instance = (Bankcard) getSession().get(
					"com.ypeb.model.user.bankCard.Bankcard", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Bankcard> findByExample(Bankcard instance) {
		log.debug("finding Bankcard instance by example");
		try {
			List<Bankcard> results = (List<Bankcard>) getSession()
					.createCriteria("com.ypeb.model.user.bankCard.Bankcard")
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
		log.debug("finding Bankcard instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Bankcard as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Bankcard> findByCardNum(Object cardNum) {
		return findByProperty(CARD_NUM, cardNum);
	}

	public List<Bankcard> findByBankName(Object bankName) {
		return findByProperty(BANK_NAME, bankName);
	}

	public List<Bankcard> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Bankcard> findByIsDelete(Object isDelete) {
		return findByProperty(IS_DELETE, isDelete);
	}

	public List findAll() {
		log.debug("finding all Bankcard instances");
		try {
			String queryString = "from Bankcard";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Bankcard merge(Bankcard detachedInstance) {
		log.debug("merging Bankcard instance");
		try {
			Bankcard result = (Bankcard) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Bankcard instance) {
		log.debug("attaching dirty Bankcard instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Bankcard instance) {
		log.debug("attaching clean Bankcard instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}