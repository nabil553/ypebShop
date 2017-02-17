package com.ypeb.action.back.shopping;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GoodsUploadAction extends ActionSupport {
	private File filedata;
	private String filedataContentType;
	private String filedataFileName;
	private String err;
	private String msg;
	private String message;
	private String fileExt = "jpg,jpeg,gif,bmp,png";
	private String statusCode;

	private String navTabId;
	private String callbackType;
	private String forwardUrl;
	private static String savePath = "upload" + File.separator + "image"
			+ File.separator + "goods" + File.separator;
	private String timeMark;

	public String uploadImage() throws IOException {

		timeMark = (String) ActionContext.getContext().getSession()
				.get("timeMark");

		if (timeMark == null) {
			Long temp = System.currentTimeMillis();
			
			timeMark = temp.toString();
			ActionContext.getContext().getSession().put("timeMark", timeMark);
		}
		
		savePath.substring(3);
		String saveRealFilePath = ServletActionContext.getServletContext()
				.getRealPath(File.separator) + savePath + timeMark;
	
		this.createDir(saveRealFilePath);

		StringBuffer sbuffer = new StringBuffer();

		filedataFileName = sbuffer.insert(0, File.separator + new Date().getTime())
				.toString() + filedataFileName;
		File savefile;
		savefile = new File(saveRealFilePath + filedataFileName);
		FileUtils.copyFile(filedata, savefile);
		
		//savePath=".."+File.separator+savePath;
		statusCode = "200";
		message = "成功";
		navTabId = "goods";
		forwardUrl = "";
		msg = savePath + timeMark + filedataFileName;
		System.out.println("************"+msg);
		err = "";
		printInfo(err, msg);
		return "ajaxdone";

	}

	public boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {
			System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {
			destDirName = destDirName + File.separator;
		}
		// 创建目录
		if (dir.mkdirs()) {
			System.out.println("创建目录" + destDirName + "成功！");
			return true;
		} else {
			System.out.println("创建目录" + destDirName + "失败！");
			return false;
		}
	}

	public void printInfo(String err, String newFileName) {
		message = "{\"err\":\"" + err + "\",\"msg\":\"" + newFileName + "\"}";

	}

	public static String getSavePath() {
		return savePath;
	}

	public static void setSavePath(String savePath) {
		GoodsUploadAction.savePath = savePath;
	}

	public String getTimeMark() {
		return timeMark;
	}

	public void setTimeMark(String timeMark) {
		this.timeMark = timeMark;
	}

	public File getFiledata() {
		return filedata;
	}

	public void setFiledata(File filedata) {
		this.filedata = filedata;
	}

	public String getFiledataContentType() {
		return filedataContentType;
	}

	public void setFiledataContentType(String filedataContentType) {
		this.filedataContentType = filedataContentType;
	}

	public String getFiledataFileName() {
		return filedataFileName;
	}

	public void setFiledataFileName(String filedataFileName) {
		this.filedataFileName = filedataFileName;
	}

	public String getErr() {
		return err;
	}

	public void setErr(String err) {
		this.err = err;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
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

}
