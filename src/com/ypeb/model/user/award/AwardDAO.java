package com.ypeb.model.user.award;

import com.ypeb.model.trade.pointsSale.BaseHibernateDAO;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Award
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.ypeb.model.user.award.Award
 * @author MyEclipse Persistence Tools
 */
public class AwardDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(AwardDAO.class);
	// property constants
	public static final String GET_AWARD_ID = "getAwardId";
	public static final String LEVEL = "level";
	public static final String NUM = "num";
	public static final String SOURCE_ID = "sourceId";

	public void save(Award transientInstance) {
		log.debug("saving Award instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Award persistentInstance) {
		log.debug("deleting Award instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Award findById(java.lang.Integer id) {
		log.debug("getting Award instance with id: " + id);
		try {
			Award instance = (Award) getSession().get(
					"com.ypeb.model.user.award.Award", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Award> findByExample(Award instance) {
		log.debug("finding Award instance by example");
		try {
			List<Award> results = (List<Award>) getSession()
					.createCriteria("com.ypeb.model.user.award.Award")
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
		log.debug("finding Award instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Award as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Award> findByGetAwardId(Object getAwardId) {
		return findByProperty(GET_AWARD_ID, getAwardId);
	}

	public List<Award> findByLevel(Object level) {
		return findByProperty(LEVEL, level);
	}

	public List<Award> findByNum(Object num) {
		return findByProperty(NUM, num);
	}

	public List<Award> findBySourceId(Object sourceId) {
		return findByProperty(SOURCE_ID, sourceId);
	}

	public List findAll() {
		log.debug("finding all Award instances");
		try {
			String queryString = "from Award";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Award merge(Award detachedInstance) {
		log.debug("merging Award instance");
		try {
			Award result = (Award) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Award instance) {
		log.debug("attaching dirty Award instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Award instance) {
		log.debug("attaching clean Award instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}