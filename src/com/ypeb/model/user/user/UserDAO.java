package com.ypeb.model.user.user;

import com.ypeb.model.points.points.Points;
import com.ypeb.model.trade.pointsSale.BaseHibernateDAO;
import com.ypeb.util.Page;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.ypeb.model.user.user.User
 * @author MyEclipse Persistence Tools
 */
public class UserDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(UserDAO.class);
	// property constants
	public static final String PASSWORD = "password";
	public static final String PAY_PASSWORD = "payPassword";
	public static final String TELEPHONE = "telephone";
	public static final String NAME = "name";
	public static final String PROVINCE = "province";
	public static final String CITY = "city";
	public static final String COUNTRY = "country";
	public static final String IDCARD = "idcard";
	public static final String LEVEL = "level";
	public static final String CASH = "cash";
	public static final String USING_POINTS = "usingPoints";
	public static final String INFOR_IS_FULL = "inforIsFull";
	public static final String IMAGE_URL = "imageUrl";
	public static final String STYLE = "style";
	public static final String ICE_POINTS = "icePoints";
	public static final String TRADE_POINTS = "tradePoints";
	public static final String BANK_CARD = "bankCard";
	public static final String IS_DELETE = "isDelete";
	
	public List<User> findAllByPage(Page page) {
		log.debug("finding all Points instances");
		try {
			getSession().clear();
			String queryString = "from User where isDelete=0 order by id desc";
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
		log.debug("finding all User count");
		try {
			getSession().clear();
			String hql = "select count(*) from User where isDelete=0";
			Query query = getSession().createQuery(hql);
			
			return  ((Number) query.uniqueResult()).intValue();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	
	public List<User> findByUser(User user) {  
	    final DetachedCriteria query = DetachedCriteria  
	            .forClass(User.class);  
	    Criteria criteria = query.getExecutableCriteria(getSession());  
	    criteria.add(Restrictions.eq("user", user));  
 	  
	    @SuppressWarnings("unchecked")  
	    List<User> list = criteria.list();  
	      
	    return list;  
	} 

	public void save(User transientInstance) {
		log.debug("saving User instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public User findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getSession().get(
					"com.ypeb.model.user.user.User", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<User> findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List<User> results = (List<User>) getSession()
					.createCriteria("com.ypeb.model.user.user.User")
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
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<User> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<User> findByPayPassword(Object payPassword) {
		return findByProperty(PAY_PASSWORD, payPassword);
	}

	public List<User> findByTelephone(Object telephone) {
		return findByProperty(TELEPHONE, telephone);
	}

	public List<User> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<User> findByProvince(Object province) {
		return findByProperty(PROVINCE, province);
	}

	public List<User> findByCity(Object city) {
		return findByProperty(CITY, city);
	}

	public List<User> findByCountry(Object country) {
		return findByProperty(COUNTRY, country);
	}

	public List<User> findByIdcard(Object idcard) {
		return findByProperty(IDCARD, idcard);
	}

	public List<User> findByLevel(Object level) {
		return findByProperty(LEVEL, level);
	}

	public List<User> findByCash(Object cash) {
		return findByProperty(CASH, cash);
	}

	public List<User> findByUsingPoints(Object usingPoints) {
		return findByProperty(USING_POINTS, usingPoints);
	}

	public List<User> findByInforIsFull(Object inforIsFull) {
		return findByProperty(INFOR_IS_FULL, inforIsFull);
	}

	public List<User> findByImageUrl(Object imageUrl) {
		return findByProperty(IMAGE_URL, imageUrl);
	}

	public List<User> findByStyle(Object style) {
		return findByProperty(STYLE, style);
	}

	public List<User> findByIcePoints(Object icePoints) {
		return findByProperty(ICE_POINTS, icePoints);
	}

	public List<User> findByTradePoints(Object tradePoints) {
		return findByProperty(TRADE_POINTS, tradePoints);
	}

	public List<User> findByBankCard(Object bankCard) {
		return findByProperty(BANK_CARD, bankCard);
	}

	public List<User> findByIsDelete(Object isDelete) {
		return findByProperty(IS_DELETE, isDelete);
	}

	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}