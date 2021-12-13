<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jspf" %>

<div class="container">
	<form action="${contextPath}/member/register" method="post">
		이름 : <input type="text" class="form-control" name="username"/>
		이메일 : <input type="text" class="form-control" name="email"/>
		비밀번호 : <input type="password" class="form-control" name="password"/>
		<button class="btn">가입</button>
	</form>

</div>
</body>
</html>