package com.ypeb.model.shopping.goodsCategory;


import com.ypeb.model.trade.pointsSale.BaseHibernateDAO;
import com.ypeb.util.Page;

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Goodscategory entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ypeb.model.shopping.goodsCategory.Goodscategory
 * @author MyEclipse Persistence Tools
 */
public class GoodscategoryDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(GoodscategoryDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String IS_FLOOR = "isFloor";
	public static final String LEVEL = "level";
	public static final String SUPER_ID = "superId";
	public static final String URL = "url";
	public static final String IS_DELETE = "isDelete";
	public static final String SUPER_NAME = "superName";
	
	public List<Goodscategory> findAllByPage(Page page) {
		log.debug("finding all Goodscategory instances");
		try {
			getSession().clear();
			String queryString = "from Goodscategory where isDelete=0";
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

	public int findCount() {
		log.debug("finding all Goodscategory count");
		try {
			getSession().clear();
			String hql = "select count(*) from Goodscategory where isDelete=0";
			Query query = getSession().createQuery(hql);

			return  ((Number) query.uniqueResult()).intValue();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	

	public void save(Goodscategory transientInstance) {
		log.debug("saving Goodscategory instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Goodscategory persistentInstance) {
		log.debug("deleting Goodscategory instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Goodscategory findById(java.lang.Integer id) {
		log.debug("getting Goodscategory instance with id: " + id);
		try {
			Goodscategory instance = (Goodscategory) getSession().get(
					"com.ypeb.model.shopping.goodsCategory.Goodscategory", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Goodscategory> findByExample(Goodscategory instance) {
		log.debug("finding Goodscategory instance by example");
		try {
			List<Goodscategory> results = (List<Goodscategory>) getSession()
					.createCriteria(
							"com.ypeb.model.shopping.goodsCategory.Goodscategory")
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
		log.debug("finding Goodscategory instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Goodscategory as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Goodscategory> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Goodscategory> findByIsFloor(Object isFloor) {
		return findByProperty(IS_FLOOR, isFloor);
	}

	public List<Goodscategory> findByLevel(Object level) {
		return findByProperty(LEVEL, level);
	}

	public List<Goodscategory> findBySuperId(Object superId) {
		return findByProperty(SUPER_ID, superId);
	}

	public List<Goodscategory> findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List<Goodscategory> findByIsDelete(Object isDelete) {
		return findByProperty(IS_DELETE, isDelete);
	}

	public List<Goodscategory> findBySuperName(Object superName) {
		return findByProperty(SUPER_NAME, superName);
	}

	public List findAll() {
		log.debug("finding all Goodscategory instances");
		try {
			String queryString = "from Goodscategory";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Goodscategory merge(Goodscategory detachedInstance) {
		log.debug("merging Goodscategory instance");
		try {
			Goodscategory result = (Goodscategory) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Goodscategory instance) {
		log.debug("attaching dirty Goodscategory instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Goodscategory instance) {
		log.debug("attaching clean Goodscategory instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}