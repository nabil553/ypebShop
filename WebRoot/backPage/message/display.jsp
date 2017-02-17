<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="pageContent">
	
		<div class="pageFormContent nowrap" layoutH="100">
			<input type="hidden" name="messag.id" value="${messag.id }">
			<div class="unit">
			<p>留言内容</p>
				<textarea  name="messag.content" rows="10" cols="100"
					readonly >${messag.content }</textarea>
			</div>
			<div class="unit">
			<p>回复</p>
				<textarea  name="messag.reply" rows="10" cols="100"
					class="required" >${messag.reply }</textarea>
					
			</div>

		</div>
	
</div>
