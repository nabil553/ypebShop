package com.ypeb.action.front.trade;

import com.opensymphony.xwork2.ActionSupport;
import com.ypeb.model.trade.pointsTrade.Pointtrade;

public class TradeDealAction extends ActionSupport {
	/**
	 * @author jilin
	 * @date : 2017年1月9日 上午8:30:30
	 * @descripe:用来处理积分系统中积分交易的类
	 */
	
	private Pointtrade pointsTrade;//购买者和售卖者等订单信息存在这里
	private int state;//状态码
	private String destUrl;//重定向地址
	/* 售卖积分状态码：
	 * 提交之后返回状态码state,200为交易成功，201为挂卖积分超出购买申请（此时剩余售卖积分进入积分中心显示），
    202为挂载积分价格过高，暂时不会在积分中心显示。205为积分不足，206为未知原因。 
    *购买积分状态码：
    *200为交易成功，201为按此价格不能购买到足够的积分（例如订单是以
    1.1元价格购买3000，但是1.1的只有1200，则默认成交1200积分），205为现金余额不足，206为未知原因。
    */
	private String buyPointsPre(){
		/**
		 * @author jilin
		 * @date : 2017年1月9日 上午8:39:32
		 * @descripe:点击我要买之后的处理方法
		 * 1.获取购买人和订单信息；
		 * 2.将信息储存在pointsTrade对象中
		 * 3.重定向到下单页面
		 */
		return "diyUrl";
	}
	
	private String buyPoints(){
		/**
		 * @author jilin
		 * @date : 2017年1月9日 上午8:39:02
		 * @descripe:用来处理购买订单
		 * 1.获取订单对象pointsTrade
		 * 2.积分购买计算：
		 * 	（1）数量超过挂卖的数量
		 * 	（2）数量少于挂卖的数量
		 *	（3）现金账户余额不足
		 *3.计算完成，存储数据，根据状态返回信息
		 */
		return "diyUrl";
	}
	
	private String salePointsPre(){
		/**
		 * @author jilin
		 * @date : 2017年1月9日 上午8:44:00
		 * @descripe:我要卖积分
		 * 参考我要买积分
		 */
		return "diyUrl";
	}
	
	private String salePoints(){
		/**
		 * @author jilin
		 * @date : 2017年1月9日 上午8:44:00
		 * @descripe:参考购买积分处理
		 */
		return "diyUrl";
	}

	public Pointtrade getPointsTrade() {
		return pointsTrade;
	}

	public void setPointsTrade(Pointtrade pointsTrade) {
		this.pointsTrade = pointsTrade;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getDestUrl() {
		return destUrl;
	}

	public void setDestUrl(String destUrl) {
		this.destUrl = destUrl;
	}

	
}
