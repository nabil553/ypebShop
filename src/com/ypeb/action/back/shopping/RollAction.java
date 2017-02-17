package com.ypeb.action.back.shopping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.ypeb.dataClass.front.RollGoods;
import com.ypeb.model.hibernate.HibernateSessionFactory;
import com.ypeb.model.shopping.goods.GoodsDAO;
import com.ypeb.model.shopping.roll.Roll;
import com.ypeb.model.shopping.roll.RollDAO;



public class RollAction extends ActionSupport {
	
	private Roll roll;
	private List<Roll> rollList = new ArrayList<Roll>();
	private List<RollGoods> rollGoodsList = new ArrayList<RollGoods>();
	private String destUrl;
	// JUI JSON返回
	private String statusCode;
	private String message;
	private String navTabId;
	private String callbackType;
	private String forwardUrl;
	

	private String uid;
	private File image;// 封装上传文件域的属性
	private String imageContentType;// 封装上传文件类型
	private String imageFileName;// 封装上传文件名
	private static String savePath = "upload/image/roll/";

	private String diyContentType = "jpg/png/gif";

	public String list() {
		/**
		 * @author jilin
		 * @date : 2017年1月13日 上午11:40:28
		 * @descripe:查询所有广告
		 */
		rollList = new RollDAO().findAll();
		for(Roll list:rollList){
			RollGoods temp=new RollGoods();
			temp.setRoll(list);
			temp.setGoods(new GoodsDAO().findById(list.getGoodsId()));
			rollGoodsList.add(temp);
		}
		destUrl = "backPage/shopping/page/roll/list.jsp";
		return "diyUrl";
	}



	public String add() {
		/**
		 * @author jilin
		 * @date : 2017年1月13日 上午11:42:04
		 * @descripe:添加一个广告
		 */
		Transaction tx = null;
		try {
			setImageFileName(System.currentTimeMillis()+getImageFileName());
			
			FileOutputStream fos = new FileOutputStream(ServletActionContext
					.getServletContext().getRealPath(
							getSavePath() + getImageFileName()));
			FileInputStream fis = new FileInputStream(getImage());
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			roll.setUrl(imageFileName);
			
			tx = HibernateSessionFactory.getSession()
					.beginTransaction( );
			new RollDAO().save(roll);
			tx.commit();
			statusCode = "200";
			message = "创建成功";
			navTabId = "roll";
			callbackType = "closeCurrent";
			fos.close();
			fis.close();
		} catch (Exception e) {		
			e.printStackTrace();
			tx.rollback();		
			statusCode = "300";
			message = "创建失败";
			navTabId = "roll";
			callbackType = "closeCurrent";
		}finally{
			HibernateSessionFactory.getSession().close();
		}
		return "ajaxdone";

	}

	public String delete() {
		/**
		 * @author jilin
		 * @date : 2017年1月13日 上午11:42:09
		 * @descripe:删除一个广告
		 */
		Transaction tx = null;
		try {
			tx = HibernateSessionFactory.getSession().beginTransaction();

			RollDAO dao = new RollDAO();
			Integer id = new Integer(uid);

			roll = dao.findById(id.intValue());
			File file=new File(ServletActionContext.getServletContext().getRealPath(getSavePath()+roll.getUrl()));
			
			file.delete();
			dao.delete(roll);
			statusCode = "200";
			message = "删除成功";
			navTabId = "roll";
			callbackType = "";
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			statusCode = "300";
			message = "删除失败";
			navTabId = "roll";
			callbackType = "";
			forwardUrl = "";
		} finally {
			tx.commit();
			HibernateSessionFactory.getSession().close();
		}
		return "ajaxdone";
	}

	public String modifyPre() {
		/**
		 * @author jilin
		 * @date : 2017年1月13日 上午11:43:05
		 * @descripe:修改一个广告信息的前置处理
		 */

		RollDAO dao = new RollDAO();
		Integer id = new Integer(uid);
		roll = dao.findById(id.intValue());

		destUrl = "backPage/shopping/page/roll/modify.jsp";
		return "diyUrl";
	}

	public String modify() {
		/**
		 * @author jilin
		 * @date : 2017年1月13日 上午11:43:05
		 * @descripe:修改一个广告信息
		 */
		Transaction tx = null;
		try {
					
			RollDAO dao = new RollDAO();
			// Integer id = new Integer(uid);
			// Roll RollTemp=dao.findById(id);
			// RollTemp=Roll;
			Roll temp=dao.findById(roll.getId());
			System.out.println(temp.getId());
			File file1=new File(ServletActionContext.getServletContext().getRealPath(getSavePath()+temp.getUrl()));
			System.out.println(file1.getPath());
			file1.delete();
			
			setImageFileName(System.currentTimeMillis()+getImageFileName());
			FileOutputStream fos=new FileOutputStream(ServletActionContext.getServletContext().getRealPath(getSavePath()+getImageFileName()));
			
			FileInputStream fis=new FileInputStream(getImage()); 
			
			byte[] buffer =new byte[1024];
			int len=0;
			while ((len=fis.read(buffer))>0){
				fos.write(buffer, 0, len);
			}
			tx = HibernateSessionFactory.getSession().beginTransaction();
			roll.setUrl(getImageFileName());
			System.out.println("Roll.url"+roll.getUrl());
			dao.merge(roll);
			tx.commit();
			fos.close();
			fis.close();
			statusCode = "200";
			message = "修改成功";
			navTabId = "roll";
			callbackType = "closeCurrent";
			forwardUrl = "";
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			statusCode = "300";
			message = "修改失败";
			navTabId = "roll";
			callbackType = "closeCurrent";
			forwardUrl = "";
		} finally {
			
			HibernateSessionFactory.getSession().flush();
			HibernateSessionFactory.getSession().close();
		}
		return "ajaxdone";

	}



	public Roll getRoll() {
		return roll;
	}



	public void setRoll(Roll roll) {
		this.roll = roll;
	}



	public List<Roll> getRollList() {
		return rollList;
	}



	public void setRollList(List<Roll> rollList) {
		this.rollList = rollList;
	}



	public String getDestUrl() {
		return destUrl;
	}



	public void setDestUrl(String destUrl) {
		this.destUrl = destUrl;
	}



	public String getStatusCode() {
		return statusCode;
	}



	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public String getNavTabId() {
		return navTabId;
	}



	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}



	public String getCallbackType() {
		return callbackType;
	}



	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}



	public String getForwardUrl() {
		return forwardUrl;
	}



	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}



	public String getUid() {
		return uid;
	}



	public void setUid(String uid) {
		this.uid = uid;
	}



	public File getImage() {
		return image;
	}



	public void setImage(File image) {
		this.image = image;
	}



	public String getImageContentType() {
		return imageContentType;
	}



	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}



	public String getImageFileName() {
		return imageFileName;
	}



	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}



	public static String getSavePath() {
		return savePath;
	}



	public static void setSavePath(String savePath) {
		RollAction.savePath = savePath;
	}



	public String getDiyContentType() {
		return diyContentType;
	}



	public void setDiyContentType(String diyContentType) {
		this.diyContentType = diyContentType;
	}



	public List<RollGoods> getRollGoodsList() {
		return rollGoodsList;
	}



	public void setRollGoodsList(List<RollGoods> rollGoodsList) {
		this.rollGoodsList = rollGoodsList;
	}


	
}
