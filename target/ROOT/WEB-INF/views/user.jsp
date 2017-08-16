<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>스프링프레임워크 게시판</title>
  </head>
  <body>

  <form id="form">
  
  <div>
  <span>작성자</span>
  
  <input type="text" id="user_name" name="user_name" value="" />
  </div>
  <div>
  <span>내용</span>
  <textarea id="content" name="content" rows="10" cols="20"></textarea>
  </div>
  </form>

  <div>
  <button>저장</button>
  <a href="./list">목록</a>
  </div>

  </body>
</html>