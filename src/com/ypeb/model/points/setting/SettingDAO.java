package com.ypeb.model.points.setting;

import com.ypeb.model.trade.pointsSale.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Setting entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ypeb.model.points.setting.Setting
 * @author MyEclipse Persistence Tools
 */
public class SettingDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(SettingDAO.class);
	// property constants
	public static final String PRICE = "price";
	public static final String MONTH = "month";
	public static final String GIVE_DAYS = "giveDays";
	public static final String CONSUME_DAYS = "consumeDays";
	public static final String WITHDRAW_RATE = "withdrawRate";
	public static final String FIRST_AWARD = "firstAward";
	public static final String SECOND_AWARD = "secondAward";
	public static final String MAX_POINTS = "maxPoints";
	public static final String FEEDBACK_AWARD = "feedbackAward";
	public static final String IS_USING = "isUsing";
	public static final String IS_DELETE = "isDelete";

	public void save(Setting transientInstance) {
		log.debug("saving Setting instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Setting persistentInstance) {
		log.debug("deleting Setting instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Setting findById(java.lang.Integer id) {
		log.debug("getting Setting instance with id: " + id);
		try {
			Setting instance = (Setting) getSession().get(
					"com.ypeb.model.points.setting.Setting", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Setting> findByExample(Setting instance) {
		log.debug("finding Setting instance by example");
		try {
			List<Setting> results = (List<Setting>) getSession()
					.createCriteria("com.ypeb.model.points.setting.Setting")
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
		log.debug("finding Setting instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Setting as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Setting> findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List<Setting> findByMonth(Object month) {
		return findByProperty(MONTH, month);
	}

	public List<Setting> findByGiveDays(Object giveDays) {
		return findByProperty(GIVE_DAYS, giveDays);
	}

	public List<Setting> findByConsumeDays(Object consumeDays) {
		return findByProperty(CONSUME_DAYS, consumeDays);
	}

	public List<Setting> findByWithdrawRate(Object withdrawRate) {
		return findByProperty(WITHDRAW_RATE, withdrawRate);
	}

	public List<Setting> findByFirstAward(Object firstAward) {
		return findByProperty(FIRST_AWARD, firstAward);
	}

	public List<Setting> findBySecondAward(Object secondAward) {
		return findByProperty(SECOND_AWARD, secondAward);
	}

	public List<Setting> findByMaxPoints(Object maxPoints) {
		return findByProperty(MAX_POINTS, maxPoints);
	}

	public List<Setting> findByFeedbackAward(Object feedbackAward) {
		return findByProperty(FEEDBACK_AWARD, feedbackAward);
	}

	public List<Setting> findByIsUsing(Object isUsing) {
		return findByProperty(IS_USING, isUsing);
	}

	public List<Setting> findByIsDelete(Object isDelete) {
		return findByProperty(IS_DELETE, isDelete);
	}

	public List findAll() {
		log.debug("finding all Setting instances");
		try {
			String queryString = "from Setting";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Setting merge(Setting detachedInstance) {
		log.debug("merging Setting instance");
		try {
			Setting result = (Setting) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Setting instance) {
		log.debug("attaching dirty Setting instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Setting instance) {
		log.debug("attaching clean Setting instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}