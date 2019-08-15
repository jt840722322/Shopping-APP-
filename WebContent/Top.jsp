<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="top">
      <div id="top_t">
        <!--<div id="logo" class="fl"></div>-->
        <div id="photo_info" class="fr">
          <div id="photo" class="fl">
            <a href="#"><img src="images/a.png" alt="" width="60" height="60"></a>
          </div>
          <div id="base_info" class="fr">
            <div class="help_info">
              <a href="#" id="hp">&nbsp;</a>
              <a href="#" id="gy">&nbsp;</a>
              <a href="login.jsp" id="out">&nbsp;</a>
            </div>
            <div class="info_center">
              <c:out value="${sessionScope.users.username}"></c:out>
              <!--<span id="nt">通知</span><span><a href="#" id="notice">3</a></span>-->
            </div>
          </div>
        </div>
      </div>
</body>
</html>