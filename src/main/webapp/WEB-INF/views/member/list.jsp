<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jspf" %>
<div class="container">
<table class="table">
	<tr>
		<th>회원번호</th>
		<th>이름</th>
		<th>이메일</th>
		<th>가입날짜</th>
		<th>가입시간</th>
	</tr>
	<c:forEach items="${list}" var="m">
		<tr>
			<td>${m.id}</td>
			<td>
				<a href="${contextPath}/member/get?id=${m.id}">${m.username}</a>		
			</td>
			<td>${m.email}</td>
			<td>${m.dateAt}</td>
			<td>${m.timeAt}</td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>