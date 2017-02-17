package com.ypeb.dataClass.front;

import java.util.Date;
import java.util.List;

import com.ypeb.model.trade.pointsTrade.Pointtrade;
import com.ypeb.model.trade.pointsTrade.PointtradeDAO;

public class TradeK {
	/**
	 * @author jilin
	 * @date : 2017年1月7日 下午2:56:26
	 * @descripe :数据类，用来传送月K线图所需的数据。
	 */
	public double firtTrade;
	public double lastTrade;
	public double maxTrade;
	public double minTrade;

	public void calcuMonthK(Date start, Date end) {
		/**
		 * @author jilin
		 * @date : 2017年1月7日 下午2:58:55
		 * @descripe: 方法用来查询date日期的K线数据,并给自身赋值
		 */

		PointtradeDAO dao = new PointtradeDAO();

		List<Pointtrade> pointtradeList = dao.findByTime(start, end);
		if(!pointtradeList.isEmpty()){
			System.out.println(pointtradeList.get(0).getPrice());
			this.setFirtTrade(pointtradeList.get(0).getPrice());
			this.setLastTrade(pointtradeList.get(pointtradeList.size()-1).getPrice());
		}else{
			System.out.println(0.0);
			this.setFirtTrade(0.0);
			this.setLastTrade(0.0);
		}

		List<Pointtrade> priceList = dao.findByPrice(start, end);
		if (!priceList.isEmpty()){
			this.setMaxTrade(priceList.get(0).getPrice());
			this.setMinTrade(priceList.get(priceList.size()-1).getPrice());
		}else{ 
			this.setMaxTrade(0.0);
			this.setMinTrade(0.0);
		}
	
	}

	public double getFirtTrade() {
		return firtTrade;
	}

	public void setFirtTrade(double firtTrade) {
		this.firtTrade = firtTrade;
	}

	public double getLastTrade() {
		return lastTrade;
	}

	public void setLastTrade(double lastTrade) {
		this.lastTrade = lastTrade;
	}

	public double getMaxTrade() {
		return maxTrade;
	}

	public void setMaxTrade(double maxTrade) {
		this.maxTrade = maxTrade;
	}

	public double getMinTrade() {
		return minTrade;
	}

	public void setMinTrade(double minTrade) {
		this.minTrade = minTrade;
	}

}
