package com.ypeb.model.shopping.advertisement;

import com.ypeb.model.trade.pointsSale.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Advertisement entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ypeb.model.shopping.advertisement.Advertisement
 * @author MyEclipse Persistence Tools
 */
public class AdvertisementDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AdvertisementDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String DESCRIPE = "descripe";
	public static final String URL = "url";
	public static final String TYPE = "type";

	public void save(Advertisement transientInstance) {
		log.debug("saving Advertisement instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Advertisement persistentInstance) {
		log.debug("deleting Advertisement instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Advertisement findById(java.lang.Integer id) {
		log.debug("getting Advertisement instance with id: " + id);
		try {
			Advertisement instance = (Advertisement) getSession().get(
					"com.ypeb.model.shopping.advertisement.Advertisement", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Advertisement> findByExample(Advertisement instance) {
		log.debug("finding Advertisement instance by example");
		try {
			List<Advertisement> results = (List<Advertisement>) getSession()
					.createCriteria(
							"com.ypeb.model.shopping.advertisement.Advertisement")
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
		log.debug("finding Advertisement instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Advertisement as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Advertisement> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Advertisement> findByDescripe(Object descripe) {
		return findByProperty(DESCRIPE, descripe);
	}

	public List<Advertisement> findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List<Advertisement> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findAll() {
		log.debug("finding all Advertisement instances");
		try {
			String queryString = "from Advertisement";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Advertisement merge(Advertisement detachedInstance) {
		log.debug("merging Advertisement instance");
		try {
			Advertisement result = (Advertisement) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Advertisement instance) {
		log.debug("attaching dirty Advertisement instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Advertisement instance) {
		log.debug("attaching clean Advertisement instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}