package com.ypeb.model.points.release;

import com.ypeb.model.trade.pointsSale.BaseHibernateDAO;
import java.util.Date;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Pointsrelease entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ypeb.model.points.release.Pointsrelease
 * @author MyEclipse Persistence Tools
 */
public class PointsreleaseDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PointsreleaseDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String POINTS_NUM = "pointsNum";
	public static final String RELEASE_TIME = "releaseTime";
	public static final String SOURCE = "source";
	public static final String RELEASED_T = "releasedT";
	public static final String IS_FINISH = "isFinish";
	public static final String RESIDUE = "residue";

	public void save(Pointsrelease transientInstance) {
		log.debug("saving Pointsrelease instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Pointsrelease persistentInstance) {
		log.debug("deleting Pointsrelease instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Pointsrelease findById(java.lang.Integer id) {
		log.debug("getting Pointsrelease instance with id: " + id);
		try {
			Pointsrelease instance = (Pointsrelease) getSession().get(
					"com.ypeb.model.points.release.Pointsrelease", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Pointsrelease> findByExample(Pointsrelease instance) {
		log.debug("finding Pointsrelease instance by example");
		try {
			List<Pointsrelease> results = (List<Pointsrelease>) getSession()
					.createCriteria(
							"com.ypeb.model.points.release.Pointsrelease")
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
		log.debug("finding Pointsrelease instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Pointsrelease as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Pointsrelease> findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List<Pointsrelease> findByPointsNum(Object pointsNum) {
		return findByProperty(POINTS_NUM, pointsNum);
	}

	public List<Pointsrelease> findByReleaseTime(Object releaseTime) {
		return findByProperty(RELEASE_TIME, releaseTime);
	}

	public List<Pointsrelease> findBySource(Object source) {
		return findByProperty(SOURCE, source);
	}

	public List<Pointsrelease> findByReleasedT(Object releasedT) {
		return findByProperty(RELEASED_T, releasedT);
	}

	public List<Pointsrelease> findByIsFinish(Object isFinish) {
		return findByProperty(IS_FINISH, isFinish);
	}

	public List<Pointsrelease> findByResidue(Object residue) {
		return findByProperty(RESIDUE, residue);
	}

	public List findAll() {
		log.debug("finding all Pointsrelease instances");
		try {
			String queryString = "from Pointsrelease";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Pointsrelease merge(Pointsrelease detachedInstance) {
		log.debug("merging Pointsrelease instance");
		try {
			Pointsrelease result = (Pointsrelease) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Pointsrelease instance) {
		log.debug("attaching dirty Pointsrelease instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Pointsrelease instance) {
		log.debug("attaching clean Pointsrelease instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}