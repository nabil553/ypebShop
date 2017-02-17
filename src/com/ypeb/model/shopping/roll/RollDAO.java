package com.ypeb.model.shopping.roll;

import com.ypeb.model.shopping.goods.Goods;
import com.ypeb.model.trade.pointsSale.BaseHibernateDAO;
import com.ypeb.util.Page;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Roll
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.ypeb.model.shopping.roll.Roll
 * @author MyEclipse Persistence Tools
 */
public class RollDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(RollDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String URL = "url";
	public static final String GOODS_ID = "goodsId";
	
	public List<Roll> findAllByPage(Page page) {
		log.debug("finding all Roll instances");
		try {
			getSession().clear();
			String queryString = "from Roll";
			Query queryObject = getSession().createQuery(queryString);
			int first = (page.getCurrentPage() - 1) * page.getEveryPage();
			queryObject.setFirstResult(first);
			queryObject.setMaxResults(page.getEveryPage());
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public int findCount( ) {
		log.debug("finding all roll count");
		try {
			getSession().clear();
			String hql = "select count(*) from Roll  ";
			Query query = getSession().createQuery(hql);
			return  ((Number) query.uniqueResult()).intValue();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public void save(Roll transientInstance) {
		log.debug("saving Roll instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Roll persistentInstance) {
		log.debug("deleting Roll instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Roll findById(java.lang.Integer id) {
		log.debug("getting Roll instance with id: " + id);
		try {
			Roll instance = (Roll) getSession().get(
					"com.ypeb.model.shopping.roll.Roll", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Roll> findByExample(Roll instance) {
		log.debug("finding Roll instance by example");
		try {
			List<Roll> results = (List<Roll>) getSession()
					.createCriteria("com.ypeb.model.shopping.roll.Roll")
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
		log.debug("finding Roll instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Roll as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Roll> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Roll> findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List<Roll> findByGoodsId(Object goodsId) {
		return findByProperty(GOODS_ID, goodsId);
	}

	public List findAll() {
		log.debug("finding all Roll instances");
		try {
			String queryString = "from Roll";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Roll merge(Roll detachedInstance) {
		log.debug("merging Roll instance");
		try {
			Roll result = (Roll) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Roll instance) {
		log.debug("attaching dirty Roll instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Roll instance) {
		log.debug("attaching clean Roll instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}