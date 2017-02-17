package com.ypeb.action.back.shopping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.ypeb.model.hibernate.HibernateSessionFactory;
import com.ypeb.model.shopping.goodsCategory.Goodscategory;
import com.ypeb.model.shopping.goodsCategory.GoodscategoryDAO;
import com.ypeb.util.Page;
import come.ypeb.model.manager.ManagerDAO;

public class CategoryAction extends ActionSupport {
	private Goodscategory category;
	private List<Goodscategory> categoryList = new ArrayList<Goodscategory>();
	private String destUrl;
	// JUI JSON返回
	private String statusCode;
	private String message;
	private String navTabId;
	private String callbackType;
	private String forwardUrl;
	
	private Page page;


	private int pageNum = 1;// dwz分页使用
	private int numPerPage;

	private String uid;
	private File image;// 封装上传文件域的属性
	private String imageContentType;// 封装上传文件类型
	private String imageFileName;// 封装上传文件名
	private static String savePath = "upload/image/category/";

	private String diyContentType = "jpg/png/gif";

	public String list() {
		/**
		 * @author jilin
		 * @date : 2017年1月13日 上午11:40:28
		 * @descripe:查询所有栏目
		 */
		GoodscategoryDAO dao = new GoodscategoryDAO();

		if (numPerPage == 0)
			numPerPage = 17;

		page = new Page(pageNum, numPerPage);

		page.setTotalCount((Integer) dao.findCount());
		
		categoryList = new GoodscategoryDAO().findAllByPage(page);
		destUrl = "backPage/shopping/category/list.jsp";
		return "diyUrl";
	}

	public String comprehensiveQuery() {
		try {
			if (category.getName().isEmpty())
				category.setName(null);
			category.setIsDelete(false);
			categoryList = new GoodscategoryDAO().findByExample(category);

		} catch (Exception e) {
			e.printStackTrace();
		}
		destUrl = "backPage/shopping/category/list.jsp";
		return "diyUrl";
	}

	public String add() {
		/**
		 * @author jilin
		 * @date : 2017年1月13日 上午11:42:04
		 * @descripe:添加一个栏目
		 */
		Transaction tx = null;
		try {
			setImageFileName(System.currentTimeMillis() + getImageFileName());

			FileOutputStream fos = new FileOutputStream(ServletActionContext
					.getServletContext().getRealPath(
							getSavePath() + getImageFileName()));
			FileInputStream fis = new FileInputStream(getImage());
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			category.setUrl(imageFileName);
			if (category.getLevel() == 1) {
				category.setSuperId(null);
			}else{
				category.setSuperName(new GoodscategoryDAO().findById(category.getSuperId()).getName());
			}
			category.setIsDelete(false);
			tx = HibernateSessionFactory.getSession().beginTransaction();
			
			new GoodscategoryDAO().save(category);
			tx.commit();
			statusCode = "200";
			message = "创建成功";
			navTabId = "category";
			callbackType = "closeCurrent";
			fos.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			statusCode = "300";
			message = "创建失败";
			navTabId = "category";
			callbackType = "closeCurrent";
		} finally {
			HibernateSessionFactory.getSession().close();
		}
		return "ajaxdone";

	}

	public String delete() {
		/**
		 * @author jilin
		 * @date : 2017年1月13日 上午11:42:09
		 * @descripe:删除一个栏目
		 */
		Transaction tx = null;
		try {
			tx = HibernateSessionFactory.getSession().beginTransaction();

			GoodscategoryDAO dao = new GoodscategoryDAO();
			Integer id = new Integer(uid);

			category = dao.findById(id.intValue());
			File file = new File(ServletActionContext.getServletContext()
					.getRealPath(getSavePath() + category.getUrl()));
			category.setIsDelete(true);
			file.delete();
			dao.merge(category);
			statusCode = "200";
			message = "删除成功";
			navTabId = "category";
			callbackType = "";
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			statusCode = "300";
			message = "删除失败";
			navTabId = "category";
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
		 * @descripe:修改一个栏目信息的前置处理
		 */

		GoodscategoryDAO dao = new GoodscategoryDAO();
		Integer id = new Integer(uid);
		category = dao.findById(id.intValue());

		destUrl = "backPage/shopping/category/modify.jsp";
		return "diyUrl";
	}

	public String modify() {
		/**
		 * @author jilin
		 * @date : 2017年1月13日 上午11:43:05
		 * @descripe:修改一个栏目信息
		 */
		Transaction tx = null;
		try {

			if (category.getLevel() == 1) {
				category.setSuperId(null);
			}
			category.setIsDelete(false);
			GoodscategoryDAO dao = new GoodscategoryDAO();
			// Integer id = new Integer(uid);
			// Goodscategory categoryTemp=dao.findById(id);
			// categoryTemp=category;
			Goodscategory temp = dao.findById(category.getId());

			File file1 = new File(ServletActionContext.getServletContext()
					.getRealPath(getSavePath() + temp.getUrl()));
			System.out.println(file1.getPath());
			file1.delete();

			setImageFileName(System.currentTimeMillis() + getImageFileName());
			FileOutputStream fos = new FileOutputStream(ServletActionContext
					.getServletContext().getRealPath(
							getSavePath() + getImageFileName()));

			FileInputStream fis = new FileInputStream(getImage());

			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			tx = HibernateSessionFactory.getSession().beginTransaction();
			category.setUrl(getImageFileName());
			System.out.println("category.url" + category.getUrl());
			dao.merge(category);
			tx.commit();
			fos.close();
			fis.close();
			statusCode = "200";
			message = "修改成功";
			navTabId = "category";
			callbackType = "closeCurrent";
			forwardUrl = "";
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			statusCode = "300";
			message = "修改失败";
			navTabId = "category";
			callbackType = "closeCurrent";
			forwardUrl = "";
		} finally {

			HibernateSessionFactory.getSession().flush();
			HibernateSessionFactory.getSession().close();
		}
		return "ajaxdone";

	}

	public Goodscategory getCategory() {
		return category;
	}

	public void setCategory(Goodscategory category) {
		this.category = category;
	}

	public List<Goodscategory> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Goodscategory> categoryList) {
		this.categoryList = categoryList;
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
		CategoryAction.savePath = savePath;
	}

	public String getDiyContentType() {
		return diyContentType;
	}

	public void setDiyContentType(String diyContentType) {
		this.diyContentType = diyContentType;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

}
