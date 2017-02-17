package com.ypeb.model.shopping.announcement;

import com.ypeb.model.trade.pointsSale.BaseHibernateDAO;
import com.ypeb.util.Page;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Announcement entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ypeb.model.shopping.announcement.Announcement
 * @author MyEclipse Persistence Tools
 */
public class AnnouncementDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AnnouncementDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String CONTENT = "content";
	
	
	
	public List<Announcement> findAllByPage(Page page) {
		log.debug("finding all Announcement instances");
		try {
			getSession().clear();
			String queryString = "from Announcement order by time desc";
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
		log.debug("finding all Announcement count");
		try {
			getSession().clear();
			String hql = "select count(*) from Announcement as inf";
			Query query = getSession().createQuery(hql);

			return  ((Number) query.uniqueResult()).intValue();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	
	
	public List<Announcement> findIndexAnnoun(){
		/**
		 * @author jilin
		 * @date : 2017年1月12日 上午11:23:38
		 * @descripe:查询首页上显示的6个公告
		 */
		log.debug("finding index Announcement instances");
		try {
			String queryString = "from Announcement order by time";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setFirstResult(0);
			queryObject.setMaxResults(6);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
		
	}

	public void save(Announcement transientInstance) {
		log.debug("saving Announcement instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Announcement persistentInstance) {
		log.debug("deleting Announcement instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Announcement findById(java.lang.Integer id) {
		log.debug("getting Announcement instance with id: " + id);
		try {
			Announcement instance = (Announcement) getSession().get(
					"com.ypeb.model.shopping.announcement.Announcement", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Announcement> findByExample(Announcement instance) {
		log.debug("finding Announcement instance by example");
		try {
			List<Announcement> results = (List<Announcement>) getSession()
					.createCriteria(
							"com.ypeb.model.shopping.announcement.Announcement")
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
		log.debug("finding Announcement instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Announcement as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Announcement> findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List<Announcement> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findAll() {
		log.debug("finding all Announcement instances");
		try {
			String queryString = "from Announcement";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Announcement merge(Announcement detachedInstance) {
		log.debug("merging Announcement instance");
		try {
			Announcement result = (Announcement) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Announcement instance) {
		log.debug("attaching dirty Announcement instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Announcement instance) {
		log.debug("attaching clean Announcement instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}