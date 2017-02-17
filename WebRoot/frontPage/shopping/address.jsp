<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<link rel="stylesheet" href="frontCss/shopping/add_address.css">
	<link href="frontCss/shopping/city-picker.css" rel="stylesheet">
	<link href="frontCss/shopping/main.css" rel="stylesheet">
	<script src="bootstrap/js/jquery-2.1.4.min.js"></script>
	<script src="frontJs/shopping/city-picker.data.js"></script>
	<script src="frontJs/shopping/city-picker.js"></script>

  </head>
  
 <body id="invest_content">
<div class="ctn-960 mg shadow-5">
  <form  action="#" class="js-form-validate" method="post" onSubmit="return false" data-arg-one="#" data-arg-two="100">
    <div class="confirm-info-list mgt clearfix" style="position: relative; margin:0 auto;">
      <dl class="confirm-info-list-dl confirm-info-list-project">
        <dt class="tc1-title">
          <h2>收件人信息</h2>
        </dt>
        <dd class="clearfix">
            
          <div>收件地址:</div><br/>
          <!-- Content -->
            <div class="container">
            <div class="docs-methods">
                 <div id="distpicker">
                     <div class="form-group">
                         <div style="position: relative;">
                             <input id="city-picker3" class="form-control" readonly type="text" name="address" value="山东省/临沂市/兰山区" data-toggle="city-picker">
                         </div>
                     </div>
                 </div>
            </div>
            </div>
            <br />
            <textarea class="address" name="address" placeholder="填写详细的收货地址,例如街道名称;门牌号码;楼层等信息"></textarea>
            <br /><br />
            <div>收件人:</div><br />
            <input type="text" class="userName" name="userName" placeholder="请输入收件人姓名" />
            <br /><br />
            <div>联系电话:</div><br />
            <input type="text" class="telephone" placeholder="请输入联系电话" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
        </dd>
      </dl>
		<a href="frontPage/shopping/pay.jsp" target="index" >
		    <div class="divyes">
		        <span type="submit" class="spanyes">确认提交</span>
		    </div>
	    </a>
  </div>
  </form>
</div>
</body>
</html>
