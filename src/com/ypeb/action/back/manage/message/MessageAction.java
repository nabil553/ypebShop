package com.ypeb.action.back.manage.message;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.ypeb.dataClass.front.MessageShow;
import com.ypeb.model.hibernate.HibernateSessionFactory;
import com.ypeb.model.points.setting.SettingDAO;
import com.ypeb.model.user.message.Message;
import com.ypeb.model.user.message.MessageDAO;
import com.ypeb.model.user.user.User;
import com.ypeb.model.user.user.UserDAO;
import com.ypeb.util.Page;

public class MessageAction extends ActionSupport {
	private List<Message> messageList=new ArrayList<Message>();
	private List<MessageShow> messageShowList=new ArrayList<MessageShow>();
	private Message messag;
	private String destUrl;
	private int uid;
	// JUI JSON返回
	private String statusCode;
	private String message;
	private String navTabId;
	private String callbackType;
	private String forwardUrl;
	private Page page;

	private int pageNum = 1;// dwz分页使用
	private int numPerPage;
	
	public String list(){
		MessageDAO dao=new MessageDAO();
		if (numPerPage == 0)
			numPerPage = 17;
		
		page = new Page(pageNum, numPerPage);

		page.setTotalCount((Integer) dao.findCount());
		messageList=dao.findAllByPage(page);
		for(Message list:messageList){
			MessageShow temp=new MessageShow();
			temp.setMessage(list);
			User tem=new User();
			tem=new UserDAO().findById(list.getUserId());
			temp.setUserName(tem.getName());
			
			messageShowList.add(temp);			
		}
		destUrl = "backPage/message/listReply.jsp";
		return "diyUrl";
	}
	
	public String replyPre(){
		
		messag=new MessageDAO().findById(uid);
		destUrl="backPage/message/reply.jsp";
		return "diyUrl";
	}
	
	public String display(){
		
		messag=new MessageDAO().findById(uid);
		destUrl="backPage/message/display.jsp";
		return "diyUrl";
	}
	
	public String reply(){

		Transaction tx = null;
		try {
			tx = HibernateSessionFactory.getSession().beginTransaction();
			Message temp=new MessageDAO().findById(messag.getId());
			temp.setIsReply(true);
			temp.setReplyTime(new Timestamp(System.currentTimeMillis()));
			temp.setReply(messag.getReply());
			new MessageDAO().merge(temp);
			tx.commit();
			statusCode = "200";
			message = "回复成功";
			navTabId = "messageToReply";
			callbackType = "closeCurrent";
			forwardUrl = "";

		} catch (Exception e) {
			HibernateSessionFactory.getSession().close();
			e.printStackTrace();
		}
		return "ajaxdone";
	}
	
	public String listToReply(){
		
		messageList=new MessageDAO().findByIsReply(false);
		for(Message list:messageList){
			MessageShow temp=new MessageShow();
			temp.setMessage(list);
			User tem=new User();
			tem=new UserDAO().findById(list.getUserId());
			temp.setUserName(tem.getName());
			
			messageShowList.add(temp);			
		}
		
		
		
		destUrl="backPage/message/list.jsp";
		return "diyUrl";
	}


	public List<Message> getMessageList() {
		return messageList;
	}


	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}


	public Message getMessag() {
		return messag;
	}


	public void setMessag(Message messag) {
		this.messag = messag;
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


	public List<MessageShow> getMessageShowList() {
		return messageShowList;
	}


	public void setMessageShowList(List<MessageShow> messageShowList) {
		this.messageShowList = messageShowList;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
}
