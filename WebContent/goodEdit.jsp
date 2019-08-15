<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 <!doctype html>
 <html lang="zh-CN">
 <head>
 <base href="<%=basePath%>">
   <meta charset="UTF-8">
   <link rel="stylesheet" href="./js/jQueryUI/css/ui-lightness/jquery-ui-1.9.2.custom.min.css">
   	<link type="text/css" rel="stylesheet" href="./js/uploadify/uploadify.css" />
   <link rel="stylesheet" href="css/common.css">
   <link rel="stylesheet" href="css/main.css">
   <script src="js/jquery-1.8.3.min.js" type="text/javascript" ></script>
   <script type="text/javascript" src="js/colResizable-1.3.min.js"></script>
   <script type="text/javascript" src="js/common.js"></script>
   <script type="text/javascript" src="js/validate/jquery.validate.js"></script>
   <script src="js/validate/messages_cn.js" type="text/javascript"></script>
   <script src="js/validate/userValidate.js" type="text/javascript"></script>
   <script type="text/javascript" src="js/jQueryUI/js/jquery-ui-1.9.2.custom.js"></script>
      
      <script type="text/javascript" src="js/uploadify/jquery.uploadify.min.js"></script>
	<script type="text/javascript" src="js/uploadify/swfobject.js"></script>
   
   
  
   <title>商品添加</title>
 </head>
 <body>

  <div class="container">
     <div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
          	<form action="good/update" enctype="multipart/form-data" class="jqtransform" method="post" id="user_form">
 				<input type="text" name="id" value="${edit.id}">
 				<input type="text" name="photo" value="${edit.photo}">
            <div class="box_top"><b class="pl15">修改商品</b></div>
            <div class="box_center">
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
                 <tr>
                  <td class="td_right">商品名：</td>
                  <td class=""> 
                    <input type="text" id="name" name="name" value="${edit.name}" class="input-text lh30 input-text-right" size="40">
                  </td>
                </tr>
                <!-- 旧价格 -->
                 <tr>
                  <td class="td_right">旧价格：</td>
                  <td class=""> 
                    <input type="text" id="oldprice" name="oldprice" value="${edit.oldprice}" class="input-text lh30 input-text-right" size="40">
                  </td>
                </tr>
                <!-- 新价格 -->
                <tr>
                  <td class="td_right">新价格：</td>
                  <td class=""> 
                    <input type="text" id="newprice" name="newprice" value="${edit.newprice}" class="input-text lh30 input-text-right" size="40">
                  </td>
                </tr>
                <!-- 备注 -->
                <tr>
                  <td class="td_right">备注：</td>
                  <td class=""> 
                    <input type="text" id="remark" name="remark" value="${edit.remark}" class="input-text lh30 input-text-right" size="40">
                  </td>
                </tr>
                <!-- 分类id -->
                <tr>
                  <td class="td_right">分类id：</td>
                  <td class=""> 
                    <select name="cid" id="type">
				        <option value="" selected="selected">--请选择--</option>
						 <c:forEach items="${categorys}" var="c">
				       
						<option value="${c.id}" ${c.id==edit.cid?"selected":""}>${c.name}</option>
						
				      </c:forEach> 
				        </select>
                  </td>
                </tr>
                <!-- 销售数量 -->
                <tr>
                  <td class="td_right">销售数量：</td>
                  <td class=""> 
                    <input type="text" id="num" name="num" value="${edit.num}" class="input-text lh30 input-text-right" size="40">
                  </td>
                </tr>
                <!-- 商品图片 -->
               <tr>
                <td class="td_right">商品图片： </td>
				<td>&nbsp;&nbsp;&nbsp;<input type="file" name="up4"></td>
				
                 </tr>
                 <!-- 是否热销 -->
                 <tr>
                  <td class="td_right">是否热销：</td>
                  <td class=""> 
                    <input type="text" id="hot" name="hot" value="${edit.hot}" class="input-text lh30 input-text-right" size="40">
                  </td>
                </tr>
                <!-- 增加时间 -->
                  <tr>
                  <td class="td_right">增加时间：</td>
                  <td class=""> 
                    <input type="text" id="createdate" name="createdate" value="" class="input-text lh30 input-text-right" size="40">
                  </td>
                </tr>
                <!-- 排序 -->
                <tr>
                  <td class="td_right">排序：</td>
                  <td class=""> 
                    <input type="text" id="sort" name="sort" value="${edit.sort}" class="input-text lh30 input-text-right" size="40">
                  </td>
                </tr>
                <!-- 规格 -->
                 <tr>
                  <td class="td_right">规格：</td>
                  <td class=""> 
                    <input type="text" id="standard" name="standard" value="${edit.standard}" class="input-text lh30 input-text-right" size="40">
                  </td>
                </tr>
                 
                 <tr>
                   <td class="td_right">&nbsp;</td>
                   <td class="">
                     <input type="submit" id="submitBtn" name="submitBtn" class="btn btn82 btn_save2" value="提交">
                    <input type="reset" name="button" class="btn btn82 btn_res" value="重置">
                   </td>
                 </tr>
               </table>
            </div>
          	</form>
          </div>
        </div>
     </div>
   </div> 
   
 
    <div id="fileQueue"></div>
        
   
 </body>
 </html>
