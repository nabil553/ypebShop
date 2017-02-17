package com.ypeb.model.shopping.goodsOrder;

import com.ypeb.model.trade.pointsSale.BaseHibernateDAO;
import com.ypeb.util.Page;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Order
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.ypeb.model.shopping.goodsOrder.Order
 * @author MyEclipse Persistence Tools
 */
public class OrderDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(OrderDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String GOODS_ID = "goodsId";
	public static final String UNIT_PRICE = "unitPrice";
	public static final String NUM = "num";
	public static final String STATE = "state";
	public static final String TOTALPRICE = "totalprice";
	public static final String ADDRESS = "address";
	public static final String STYLE = "style";
	public static final String ORDER_CODE = "orderCode";

	public List<Order> findAllByPage(Page page,int userID) {
		log.debug("finding all Order instances");
		try {
			getSession().clear();
			String queryString = "from Order where userID="+userID+" order  by time desc";
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
	
	public int findCount(int userID) {
		log.debug("finding all goods count");
		try {
			getSession().clear();
			String hql = "select count(*) from Order where userID="+userID+" ";
			Query query = getSession().createQuery(hql);
			return  ((Number) query.uniqueResult()).intValue();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public void save(Order transientInstance) {
		log.debug("saving Order instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Order persistentInstance) {
		log.debug("deleting Order instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Order findById(java.lang.Integer id) {
		log.debug("getting Order instance with id: " + id);
		try {
			Order instance = (Order) getSession().get(
					"com.ypeb.model.shopping.goodsOrder.Order", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Order> findByExample(Order instance) {
		log.debug("finding Order instance by example");
		try {
			
			Criteria criteria=getSession().createCriteria("com.ypeb.model.shopping.goodsOrder.Order");
			criteria.addOrder(org.hibernate.criterion.Order.desc("time"));
			List<Order> results = (List<Order>) 
					criteria.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Order instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Order as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Order> findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List<Order> findByGoodsId(Object goodsId) {
		return findByProperty(GOODS_ID, goodsId);
	}

	public List<Order> findByUnitPrice(Object unitPrice) {
		return findByProperty(UNIT_PRICE, unitPrice);
	}

	public List<Order> findByNum(Object num) {
		return findByProperty(NUM, num);
	}

	public List<Order> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<Order> findByTotalprice(Object totalprice) {
		return findByProperty(TOTALPRICE, totalprice);
	}

	public List<Order> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<Order> findByStyle(Object style) {
		return findByProperty(STYLE, style);
	}

	public List<Order> findByOrderCode(Object orderCode) {
		return findByProperty(ORDER_CODE, orderCode);
	}

	public List findAll() {
		log.debug("finding all Order instances");
		try {
			String queryString = "from Order";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Order merge(Order detachedInstance) {
		log.debug("merging Order instance");
		try {
			Order result = (Order) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Order instance) {
		log.debug("attaching dirty Order instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Order instance) {
		log.debug("attaching clean Order instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}