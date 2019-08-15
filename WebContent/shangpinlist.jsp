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
   <link rel="stylesheet" href="css/common.css">
   <link rel="stylesheet" href="css/main.css">
   <script src="js/jquery-1.8.3.min.js" type="text/javascript" ></script>
   <script type="text/javascript" src="js/colResizable-1.3.min.js"></script>
   <script type="text/javascript" src="js/common.js"></script>
   
   <script type="text/javascript">
      $(function(){  
        $("#btn_add").click(function(){
			window.location = "<%=basePath%>shangpinAdd.jsp";
        });
      }); 

      function del(id) {
  		if (confirm("确定删除记录吗？")) {
  			window.location = "<%=basePath%>category/delete?id=" + id;
  		}
      }	
  	 function selectType(){
  		 var ty=document.getElementById("type").value;
  		if(ty==""){
  				return;
  		}else{
  			window.location="<%=basePath%>category/selectType?type="+ty;
  		}
  	 }
      
   </script>
   <title>商品列表</title>
 </head>
 <body>
  <div class="container">
  
     <div id="button" class="mt10">
       <input type="button" id="btn_add" name="btn_add" class="btn btn82 btn_add" value="新增"> 
       <label class="mt10">
				        <select name="type" id="type">
				        <option value="" selected="selected">--请选择--</option>
						<option value="水果蔬菜">水果蔬菜</option>
						<option value="肉禽蛋类">肉禽蛋类</option>
						<option value="水产海鲜">水产海鲜</option>
						<option value="烘焙熟食">烘焙熟食</option>
						<option value="粮油副食">粮油副食</option>
						<option value="零食酒水">零食酒水</option>
						<option value="乳品母婴">乳品母婴</option>
				        </select>
	 </label>
       <input type="button" class="btn btn82 btn_add" value="查询" onclick="selectType()"> 
       </div>
           
     <div id="table" class="mt10">
        <div class="box span10 oh">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
              <tr>
	              <th>商品名</th>
	              <th>类别</th>
	              <th>图片</th>
	              <th>操作</th>
              </tr>
              <c:choose>
              	<c:when test="${shangpin == null || fn:length(shangpin) == 0}">
              		<tr>
	                   	<th width="30" colspan="4">暂无数据</th>
                    </tr>
              	</c:when>
              	<c:otherwise>
              		<c:forEach items="${shangpin}" var="sp">
              			<tr class="tr">
		                   	<td>${sp.name}</td>
		                   	<td>${sp.type}</td>
		                   	<td><img src="images/shangpin/${sp.photo}" alt="" width="60" height="60"></td>
		                   	<td align="center">
		                   		<a href="">修改</a>
		                   		|
		                   		<a href="javascript:del('${sp.id}');">删除</a>
		                  </c:forEach> 		
              	</c:otherwise>
              </c:choose>
              </table>
        </div>
     </div>
   </div> 
 </body>
 </html>
