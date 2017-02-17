package com.ypeb.util;

import java.util.ArrayList;
import java.util.List;

import com.ypeb.dataClass.front.QueryCondition;
import com.ypeb.model.points.pointsPublish.Pointspublish;
import com.ypeb.model.trade.pointsSale.Pointssale;
import com.ypeb.model.trade.pointsSale.PointssaleDAO;
import com.ypeb.model.user.address.Address;
import com.ypeb.model.user.address.AddressDAO;
import com.ypeb.model.user.user.User;
import com.ypeb.model.user.user.UserDAO;

public class Test {

	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("111");
		list.add("222");
		System.out.println(list);
		list.set(1, "333");
		System.out.println(list);

	}

}
