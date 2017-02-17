package com.ypeb.action.back.shopping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ypeb.action.front.shopping.District;
import com.ypeb.dataClass.front.CategoryByLevel;
import com.ypeb.model.hibernate.HibernateSessionFactory;
import com.ypeb.model.shopping.goods.Goods;
import com.ypeb.model.shopping.goods.GoodsDAO;
import com.ypeb.model.shopping.goodsCategory.Goodscategory;
import com.ypeb.model.shopping.goodsCategory.GoodscategoryDAO;
import com.ypeb.model.user.user.User;
import com.ypeb.util.Page;

public class GoodsAction extends ActionSupport {
	private Goods goods;
	private List<Goods> goodsList = new ArrayList<Goods>();
	private String destUrl;
	// JUI JSON返回
	private String statusCode;
	private String message;
	private String navTabId;
	private String callbackType;
	private String forwardUrl;

	private String uid;
	private String category2;

	
	private String imageContentType;// 封装上传文件类型
	
	private List<File> images;// 封装上传文件域的属性
	private List<String> imagesFileName=new ArrayList<String>();

	private Page page;

	private int pageNum = 1;// dwz分页使用
	private int numPerPage;

	private Map<String, Object> dataMap;// 级联查询 json

	private List<Goodscategory> categoryList = new ArrayList<Goodscategory>();
	private District district;

	private static String savePath = "upload/image/goods/";

	private String diyContentType = "jpg/png/gif";
	private List<Goodscategory> firstCategoryList = new ArrayList<Goodscategory>();
	private ArrayList<CategoryByLevel> categoryByLevel = new ArrayList<CategoryByLevel>();

	public String test() {
		try {
			int i = 0;
			for (File file : images) {

				imagesFileName.set(i, System.currentTimeMillis()
						+ imagesFileName.get(i));
				FileOutputStream fos = new FileOutputStream(
						ServletActionContext.getServletContext().getRealPath(
								getSavePath() + imagesFileName.get(i++)));
				FileInputStream fis = new FileInputStream(file);
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = fis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}

				fos.close();
				fis.close();
			}

			statusCode = "200";
			message = "创建成功";
			navTabId = "goods";
			callbackType = "closeCurrent";
		} catch (Exception e) {
			e.printStackTrace();

			statusCode = "300";
			message = "未知原因，插入失败";
		} finally {
			HibernateSessionFactory.getSession().close();
		}

		return "ajaxdone";

	}

	public GoodsAction() {
		// 初始化Map对象
		dataMap = new HashMap<String, Object>();
	}

	public String queryCategory2() {
		/**
		 * @author jilin
		 * @date : 2017年1月19日 上午2:21:38
		 * @descripe:dwz级联查询商品分类
		 */

		GoodscategoryDAO categoryDao = new GoodscategoryDAO();
		short level = 1;
		Goodscategory categoryTemp=new Goodscategory();
		categoryTemp.setLevel(level);
		categoryTemp.setIsDelete(false);
		level=2;
		firstCategoryList = categoryDao.findByExample(categoryTemp);
		for (Goodscategory first : firstCategoryList) {
			Goodscategory category = new Goodscategory();
			CategoryByLevel cate = new CategoryByLevel();
			cate.setId(first.getId());
			cate.setName(first.getName());
			//category.setSuperId(first.getId());
			category.setSuperId(first.getId());
			category.setLevel(level);
			category.setIsDelete(false);
			cate.setSecCategoryList(categoryDao.findByExample(category));
			categoryByLevel.add(cate);
		}
		destUrl = "backPage/shopping/goods/bringBack.jsp";
		return "diyUrl";
	}

	public String queryByPage() {
		try {
			GoodsDAO dao = new GoodsDAO();
			if (numPerPage == 0)
				numPerPage = 17;

			page = new Page(pageNum, numPerPage);

			page.setTotalCount((Integer) dao.findCount());

			goodsList = dao.findAllByPage(page);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		destUrl = "backPage/shopping/goods/list.jsp";
		return "diyUrl";
	}

	public String addPre() {
		Goodscategory category = new Goodscategory();
		category.setIsDelete(false);
		short tem = 1;
		category.setLevel(tem);

		categoryList = new GoodscategoryDAO().findByExample(category);

		destUrl = "backPage/shopping/goods/add.jsp";
		return "diyUrl";
	}

	public String comprehensiveQuery() {
		try {
			if (goods.getName().isEmpty())
				goods.setName(null);
			if (goods.getCode().isEmpty())
				goods.setCode(null);
			goods.setIsDelete(false);
			goodsList = new GoodsDAO().findByExample(goods);

		} catch (Exception e) {
			e.printStackTrace();
		}
		destUrl = "backPage/shopping/goods/list.jsp";
		return "diyUrl";
	}

	public String add() {
		GoodsDAO dao = new GoodsDAO();
		Transaction tx = null;
		try {
			if (ActionContext.getContext().getSession().get("timeMark") != null) {
				goods.setTimeMark((String) ActionContext.getContext()
						.getSession().get("timeMark"));
			}

			ServletActionContext.getContext().getSession()
					.put("timeMark", null);

			int i = 0;
			for (File file : images) {

				imagesFileName.set(i, (System.currentTimeMillis()
						+ imagesFileName.get(i)));
				FileOutputStream fos = new FileOutputStream(
						ServletActionContext.getServletContext().getRealPath(
								getSavePath() + imagesFileName.get(i++)));
				FileInputStream fis = new FileInputStream(file);
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = fis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				System.out.println(imagesFileName.get(i-1));
				if (i == 1)
					goods.setImageUrl1(imagesFileName.get(i-1));
				if (i == 2)
					goods.setImageUrl2(imagesFileName.get(i-1));
				if (i == 3)
					goods.setImageUrl3(imagesFileName.get(i-1));
				if (i == 4)
					goods.setImageUrl4(imagesFileName.get(i-1));
				if (i == 5)
					goods.setImageUrl5(imagesFileName.get(i));

				fos.close();
				fis.close();
			}

			
			Integer tem = new Integer(district.getId2());

			goods.setCategory2(tem.intValue());
			tem = new Integer(district.getId1());
			Goodscategory temp = new GoodscategoryDAO()
					.findById(tem.intValue());
			goods.setGoodscategory(temp);
			goods.setIsDelete(false);
			goods.setCategory2name(district.getCate2());
			tx = HibernateSessionFactory.getSession().beginTransaction();
			goods.setSecondCateg(goods.getGoodscategory().getId());
			dao.save(goods);
			tx.commit();

			statusCode = "200";
			message = "创建成功";
			navTabId = "goods";
			callbackType = "closeCurrent";
		} catch (Exception e) {
			e.printStackTrace();

			statusCode = "300";
			message = "未知原因，插入失败";
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
		Integer m = new Integer(uid);
		goods = new GoodsDAO().findById(m.intValue());
		try {
			Transaction tx = HibernateSessionFactory.getSession()
					.beginTransaction();
			try {
				goods.setIsDelete(true);
				new GoodsDAO().merge(goods);

				tx.commit();
				HibernateSessionFactory.getSession().flush();
				HibernateSessionFactory.getSession().close();
				statusCode = "200";
				message = "成功删除";
				navTabId = "goods";
				forwardUrl = "";
			} catch (Exception e) {
				e.printStackTrace();
				statusCode = "300";
				message = "删除失败";
				navTabId = "goods";
				forwardUrl = "";
			}

		} catch (Exception e) {
			statusCode = "300";
			message = "删除失败。可能原因：重复删除。";
			return "ajaxdone";
		}
		return "ajaxdone";
	}

	public String modifyPre() {
		/**
		 * @author jilin
		 * @date : 2017年1月13日 上午11:43:05
		 * @descripe:修改一个栏目信息的前置处理
		 */
		
		GoodsDAO dao = new GoodsDAO();
		Integer id = new Integer(uid);
		goods = dao.findById(id.intValue());

		destUrl = "backPage/shopping/goods/modify.jsp";
		return "diyUrl";
	}

	public String modify() {
		/**
		 * @author jilin
		 * @date : 2017年1月13日 上午11:43:05
		 * @descripe:修改一个栏目信息
		 */
		GoodsDAO dao = new GoodsDAO();
		Transaction tx = null;
		try {
			

			int i = 0;
			for (File file : images) {

				imagesFileName.set(i, (System.currentTimeMillis()
						+ imagesFileName.get(i)));
				FileOutputStream fos = new FileOutputStream(
						ServletActionContext.getServletContext().getRealPath(
								getSavePath() + imagesFileName.get(i++)));
				FileInputStream fis = new FileInputStream(file);
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = fis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				System.out.println(imagesFileName.get(i-1));
				if (i == 1)
					goods.setImageUrl1(imagesFileName.get(i-1));
				if (i == 2)
					goods.setImageUrl2(imagesFileName.get(i-1));
				if (i == 3)
					goods.setImageUrl3(imagesFileName.get(i-1));
				if (i == 4)
					goods.setImageUrl4(imagesFileName.get(i-1));
				if (i == 5)
					goods.setImageUrl5(imagesFileName.get(i));

				fos.close();
				fis.close();
			}

			
			Integer tem = new Integer(district.getId2());

			goods.setCategory2(tem.intValue());
			tem = new Integer(district.getId1());
			Goodscategory temp = new GoodscategoryDAO()
					.findById(tem.intValue());
			goods.setGoodscategory(temp);
			goods.setIsDelete(false);
			goods.setCategory2name(district.getCate2());
			tx = HibernateSessionFactory.getSession().beginTransaction();
			goods.setSecondCateg(goods.getGoodscategory().getId());
			dao.merge(goods);
			tx.commit();

			statusCode = "200";
			message = "修改成功";
			navTabId = "goods";
			callbackType = "closeCurrent";
			forwardUrl="";
		} catch (Exception e) {
			e.printStackTrace();

			statusCode = "300";
			message = "未知原因，修改失败";
			navTabId = "goods";
			callbackType = "closeCurrent";
		} finally {
			HibernateSessionFactory.getSession().close();
		}

		return "ajaxdone";

	}

	// 删除文件夹和文件夹下面的文件
	public void deleteFile(File file) {
		if (file.isFile()) {// 表示该文件不是文件夹
			file.delete();
		} else {
			// 首先得到当前的路径

			String[] childFilePaths = file.list();
			for (String childFilePath : childFilePaths) {

				File childFile = new File(file.getAbsolutePath() + "/"
						+ childFilePath);
				deleteFile(childFile);
			}
			file.delete();
		}
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
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


	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	

	public static String getSavePath() {
		return savePath;
	}

	public static void setSavePath(String savePath) {
		GoodsAction.savePath = savePath;
	}

	public String getDiyContentType() {
		return diyContentType;
	}

	public void setDiyContentType(String diyContentType) {
		this.diyContentType = diyContentType;
	}

	public String getCategory2() {
		return category2;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
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

	public List<Goodscategory> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Goodscategory> categoryList) {
		this.categoryList = categoryList;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public List<Goodscategory> getFirstCategoryList() {
		return firstCategoryList;
	}

	public void setFirstCategoryList(List<Goodscategory> firstCategoryList) {
		this.firstCategoryList = firstCategoryList;
	}

	public ArrayList<CategoryByLevel> getCategoryByLevel() {
		return categoryByLevel;
	}

	public void setCategoryByLevel(ArrayList<CategoryByLevel> categoryByLevel) {
		this.categoryByLevel = categoryByLevel;
	}

	public List<File> getImages() {
		return images;
	}

	public void setImages(List<File> images) {
		this.images = images;
	}

	public List<String> getImagesFileName() {
		return imagesFileName;
	}

	public void setImagesFileName(List<String> imagesFileName) {
		this.imagesFileName = imagesFileName;
	}

}
