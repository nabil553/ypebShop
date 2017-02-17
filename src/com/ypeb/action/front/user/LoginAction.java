package com.ypeb.action.front.user;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ypeb.dataClass.front.MD5encryption;
import com.ypeb.model.hibernate.HibernateSessionFactory;
import com.ypeb.model.points.points.Points;
import com.ypeb.model.points.points.PointsDAO;
import com.ypeb.model.points.setting.Setting;
import com.ypeb.model.points.setting.SettingDAO;
import com.ypeb.model.shopping.goods.GoodsDAO;
import com.ypeb.model.shopping.goodsOrder.Order;
import com.ypeb.model.shopping.goodsOrder.OrderDAO;
import com.ypeb.model.shopping.orderGoods.Ordergoods;
import com.ypeb.model.shopping.orderGoods.OrdergoodsDAO;
import com.ypeb.model.user.user.User;
import com.ypeb.model.user.user.UserDAO;
import com.ypeb.util.ReleaseDateUtil;

public class LoginAction extends ActionSupport {
	private String destUrl;
	private User user;
	private String message;
	private String statusCode;
	private String erro;
	private String phone;

	public String goLogin() {

		destUrl = "frontPage/user/login/userLogin.jsp";
		return "diyUrl";
	}

	public String goRegister() {

		destUrl = "frontPage/user/login/simpleRegister.jsp";
		return "diyUrl";
	}

	public String register() {
		Transaction tx = null;
		try {

			List<User> userList = new ArrayList<User>();
			userList = new UserDAO().findByTelephone(phone);

			if (userList.size() == 0) {
				tx = HibernateSessionFactory.getSession().beginTransaction();
				user.setIsDelete(false);
				user.setPassword(MD5encryption.GetMD5Code(user.getPassword()));
				user.setPayPassword("123456");
				user.setInforIsFull(false);
				user.setStyle(1);
				user.setCash(0.0);
				user.setIcePoints(0.0);
				user.setUsingPoints(0.0);
				user.setTradePoints(0.0);
				short tem = 1;
				user.setLevel(tem);
				user.setTelephone(phone);
				;
				new UserDAO().save(user);

				tx.commit();
			} else {
				erro = "手机号重复";
				destUrl = "frontPage/user/login/simpleRegister.jsp";
				return "diyUrl";

			}
		} catch (Exception e) {
			HibernateSessionFactory.getSession().close();
			e.printStackTrace();
		}
		destUrl = "frontPage/user/login/userLogin.jsp";
		return "diyUrl";
	}

	public String quit() {
		try {
			ActionContext.getContext().getSession().put("userName", null);
			ActionContext.getContext().getSession().put("userID", null);
			ActionContext.getContext().getSession().put("user", null);
			statusCode = "200";
		} catch (Exception e) {
			e.printStackTrace();
			statusCode = "300";
		}
		return "ajaxdone";
	}

	public String login() {
		/**
		 * @author jilin
		 * @date : 2017年1月17日 上午3:28:42
		 * @descripe:用户登录处理 1.进行登录验证 2.通过往下执行，不通过返回提示信息 3.检查冻结积分并进行解冻
		 *                  4.检查购物订单并进行确认
		 */
		// 登录信息验证

		UserDAO dao = new UserDAO();
		// 1.检验验证码是否正确if()
		if (user != null) {
			if (user.getTelephone() != null && !user.getTelephone().isEmpty()) {
				if (dao.findByTelephone(user.getTelephone()).size() > 0) {
					// 2.检查手机号正确

					User temp = dao.findByTelephone(user.getTelephone()).get(0);
					if (temp.getPassword().equals(
							MD5encryption.GetMD5Code(user.getPassword()))) {
						// 3.密码正确，

						ActionContext.getContext().getSession()
								.put("userName", temp.getName());
						ActionContext.getContext().getSession()
								.put("userID", temp.getId());
						ActionContext.getContext().getSession()
								.put("user", temp);
						short tem = 2;
						if (temp.getStyle() == tem) {

							// 4.(1)商城会员处理，检查是否是商城会员进行解冻积分检查，

							Points points = new Points();
							points.setState(false);
							points.setUserId(temp.getId());
							List<Points> pointsList = new PointsDAO()
									.findByExample(points);
							System.out.println("平台发行积分未释放pointsList:"
									+ pointsList.size() + " userID:"
									+ temp.getId());
							// 从points表中查询出没释放完的记录，一次释放平台发行积分
							if (pointsList.size() > 0) {
								// 还有没释放的平台发行积分，进行释放
								for (Points pointsToRelease : pointsList) {
									System.out
											.println(pointsToRelease.getTime()
													+ ")))))))))))))"
													+ pointsToRelease
															.getReleasedTime());
									int num = new ReleaseDateUtil().getTime(
											pointsToRelease.getTime(),
											pointsToRelease.getReleasedTime(),
											pointsToRelease.getPointspublish()
													.getReleaseTime());
									Transaction tx = HibernateSessionFactory
											.getSession().beginTransaction();
									pointsToRelease
											.setReleasedTime(pointsToRelease
													.getReleasedTime() + num);
									if (pointsToRelease.getReleasedTime() >= pointsToRelease
											.getPointspublish()
											.getReleaseTime()) {
										pointsToRelease.setState(true);
									}
									/*
									 * System.out .println("************num:" +
									 * num);
									 */
									double everyMonthRelease = pointsToRelease
											.getPointNum()
											/ pointsToRelease
													.getPointspublish()
													.getReleaseTime();
									temp.setUsingPoints(temp.getUsingPoints()
											+ num * everyMonthRelease);
									temp.setIcePoints(temp.getIcePoints() - num
											* everyMonthRelease);
									new PointsDAO().merge(pointsToRelease);
									new UserDAO().merge(temp);
									tx.commit();
									/*
									 * HibernateSessionFactory.getSession()
									 * .close();
									 */
								}

							}

						}
						// 释放购物赠送积分
						Order order = new Order();
						order.setUserId(temp.getId());
						order.setReleaseState(false);
						short state = 3;
						order.setState(state);
						List<Order> orderList = new OrderDAO()
								.findByExample(order);
						/*
						 * System.out.println("购物积分未释放orderList:" +
						 * orderList.size());
						 */
						if (orderList.size() > 0) {
							for (Order list : orderList) {
								Timestamp currentTime = new Timestamp(
										System.currentTimeMillis());
								long sub = currentTime.getTime()
										- list.getTime().getTime();
								long days = 0;
								if (new SettingDAO().findAll().size() > 0) {
									Setting setting = (Setting) new SettingDAO()
											.findAll().get(0);
									days = setting.getGiveDays();
								}
								if ((sub / (1000 * 60 * 60 * 24)) >= days) {
									// 检查该订单已到达释放时间的处理
									List<Ordergoods> orderGoodsList = new OrdergoodsDAO()
											.findByOrderId(list.getId());
									double releaseGivePoints = 0;
									for (Ordergoods tempOrdergoods : orderGoodsList) {
										// 已到时间的订单将所有商品的赠送积分分别乘以其数量,再相加,得到该订单应该释放积分
										releaseGivePoints = releaseGivePoints
												+ (new GoodsDAO().findById(
														tempOrdergoods
																.getGoodsId())
														.getGivePoints() * tempOrdergoods
														.getNum());
									}
									Transaction tx = HibernateSessionFactory
											.getSession().beginTransaction();

									// 开启一个事务将订单改为已释放，并给user用户增加购物积分
									/*
									 * System.out.println("temp:" + temp);
									 * System.out.println("temp.usingPoints:" +
									 * temp.getUsingPoints());
									 */

									temp.setUsingPoints(temp.getUsingPoints()
											+ releaseGivePoints);
									/*
									 * System.out .println("city:" +
									 * user.getCity());
									 */
									new UserDAO().merge(temp);
									list.setReleaseState(true);
									new OrderDAO().merge(list);
									tx.commit();
									HibernateSessionFactory.getSession()
											.close();
									/*
									 * System.out.println("购物积分未释放order中的商品:" +
									 * orderGoodsList.size());
									 */
								}

							}
						}
						// 释放购物积分转交易积分期间的冻结积分
					} else {
						message = "密码错误";
						destUrl = "frontPage/user/login/userLogin.jsp";
						return "diyUrl";
						// 3.1密码错误处理
					}
				} else {
					// 2.1手机号错误处理
					message = "账号错误";
					destUrl = "frontPage/user/login/userLogin.jsp";
					return "diyUrl";
				}
			} else {
				message = "账号错误";
				destUrl = "frontPage/user/login/userLogin.jsp";
				return "diyUrl";
			}
		} else {
			message = "账号错误";
			destUrl = "frontPage/user/login/userLogin.jsp";
			return "diyUrl";
		}
		destUrl = "frontShopping_Index_indexData";
		return "nextAction";
	}

	public String addInfo() {
		/**
		 * @author jilin
		 * @date : 2017年1月17日 上午3:47:52
		 * @descripe:完善信息的处理方法
		 */
		return "diyUrl";
	}

	public String getDestUrl() {
		return destUrl;
	}

	public void setDestUrl(String destUrl) {
		this.destUrl = destUrl;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
