<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jspf" %>

<div class="container">
	${memberVo}
	<form action="${contextPath}/member/update" method="post">
		<input type="hidden" name="id" value="${memberVo.id}">
		이름 : <input type="text" class="form-control" name="username" value="${memberVo.username}"/>
		이메일 : <input type="text" class="form-control" name="email" value="${memberVo.email}"/>
		비밀번호 : <input type="password" class="form-control" name="password" value="${memberVo.password}"/>
		<button class="btn">수정확인</button>
	</form>
</div>

</body>
</html>