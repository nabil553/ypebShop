package come.ypeb.model.manager;

import com.ypeb.model.trade.pointsSale.BaseHibernateDAO;
import com.ypeb.util.Page;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Manager entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see come.ypeb.model.manager.Manager
 * @author MyEclipse Persistence Tools
 */
public class ManagerDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ManagerDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String REAL_NAME = "realName";
	public static final String TELEPHONE = "telephone";
	public static final String IS_DELETE = "isDelete";
	public static final String PASSWORD = "password";
	
	public List<Manager> findAllByPage(Page page) {
		log.debug("finding all Manager instances");
		try {
			getSession().clear();
			String queryString = "from Manager where isDelete=0";
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
		log.debug("finding all Manager count");
		try {
			getSession().clear();
			String hql = "select count(*) from Manager where isDelete=0";
			Query query = getSession().createQuery(hql);
			return  ((Number) query.uniqueResult()).intValue();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public void save(Manager transientInstance) {
		log.debug("saving Manager instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Manager persistentInstance) {
		log.debug("deleting Manager instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Manager findById(java.lang.Integer id) {
		log.debug("getting Manager instance with id: " + id);
		try {
			Manager instance = (Manager) getSession().get(
					"come.ypeb.model.manager.Manager", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Manager> findByExample(Manager instance) {
		log.debug("finding Manager instance by example");
		try {
			List<Manager> results = (List<Manager>) getSession()
					.createCriteria("come.ypeb.model.manager.Manager")
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
		log.debug("finding Manager instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Manager as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Manager> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Manager> findByRealName(Object realName) {
		return findByProperty(REAL_NAME, realName);
	}

	public List<Manager> findByTelephone(Object telephone) {
		return findByProperty(TELEPHONE, telephone);
	}

	public List<Manager> findByIsDelete(Object isDelete) {
		return findByProperty(IS_DELETE, isDelete);
	}

	public List<Manager> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findAll() {
		log.debug("finding all Manager instances");
		try {
			String queryString = "from Manager";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Manager merge(Manager detachedInstance) {
		log.debug("merging Manager instance");
		try {
			Manager result = (Manager) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Manager instance) {
		log.debug("attaching dirty Manager instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Manager instance) {
		log.debug("attaching clean Manager instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}