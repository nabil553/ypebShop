package com.ypeb.model.user.address;

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
 * Address entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ypeb.model.user.address.Address
 * @author MyEclipse Persistence Tools
 */
public class AddressDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(AddressDAO.class);
	// property constants
	public static final String ADDRESS = "address";
	public static final String NAME = "name";
	public static final String TELEPHONE = "telephone";
	public static final String IS_DELETE = "isDelete";


	public List<Address> findByUser(User user,boolean isDelete) {  
	    final DetachedCriteria query = DetachedCriteria  
	            .forClass(Address.class);  
	    Criteria criteria = query.getExecutableCriteria(getSession());  
	    criteria.add(Restrictions.eq("user", user));
	    criteria.add(Restrictions.eq("isDelete", false));
 
	  
	    @SuppressWarnings("unchecked")  
	    List<Address> list = criteria.list();  
	      
	    return list;  
	} 
	public void save(Address transientInstance) {
		log.debug("saving Address instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Address persistentInstance) {
		log.debug("deleting Address instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Address findById(java.lang.Integer id) {
		log.debug("getting Address instance with id: " + id);
		try {
			Address instance = (Address) getSession().get(
					"com.ypeb.model.user.address.Address", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Address> findByExample(Address instance) {
		log.debug("finding Address instance by example");
		try {
			List<Address> results = (List<Address>) getSession()
					.createCriteria("com.ypeb.model.user.address.Address")
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
		log.debug("finding Address instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Address as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Address> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<Address> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Address> findByTelephone(Object telephone) {
		return findByProperty(TELEPHONE, telephone);
	}

	public List<Address> findByIsDelete(Object isDelete) {
		return findByProperty(IS_DELETE, isDelete);
	}

	public List findAll() {
		log.debug("finding all Address instances");
		try {
			String queryString = "from Address";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Address merge(Address detachedInstance) {
		log.debug("merging Address instance");
		try {
			Address result = (Address) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Address instance) {
		log.debug("attaching dirty Address instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Address instance) {
		log.debug("attaching clean Address instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}