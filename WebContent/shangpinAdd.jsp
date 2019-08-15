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
   
   
   <script type="text/javascript">
       $(function(){
        $("#submitBtn").click(function(){
        if($("#user_form").validate())
			$("#user_form").submit();
        });
      }); 
   </script>
   <title>商品添加</title>
 </head>
 <body>
  <div class="container">
     <div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
          	<form action="category/insert" enctype="multipart/form-data" class="jqtransform" method="post" id="user_form">
            <div class="box_top"><b class="pl15">新增商品</b></div>
            <div class="box_center">
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
                 <tr>
                  <td class="td_right">商品名：</td>
                  <td class=""> 
                    <input type="text" id="name" name="name" value="" class="input-text lh30 input-text-right" size="40">
                  </td>
                </tr>
                 <tr>
                   <td><div align="right" class="STYLE2">类型：</div></td>
				      <td><label>
				        <select name="type">
						<option value="水果蔬菜" selected="selected">水果蔬菜</option>
						<option value="肉禽蛋类">肉禽蛋类</option>
						<option value="水产海鲜">水产海鲜</option>
						<option value="烘焙熟食">烘焙熟食</option>
						<option value="粮油副食">粮油副食</option>
						<option value="零食酒水">零食酒水</option>
						<option value="乳品母婴">乳品母婴</option>
				        </select>
				      </label></td>
                </tr>
              
                	<tr>
                <td class="td_right">产品图片： </td>
				<td>&nbsp;&nbsp;&nbsp;<input type="file" name="up2"></td>
                 </tr>
                 <tr>
                   <td class="td_right">&nbsp;</td>
                   <td class="">
                     <input type="button" id="submitBtn" name="submitBtn" class="btn btn82 btn_save2" value="提交">
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
