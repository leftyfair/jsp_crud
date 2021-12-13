<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jspf" %>

<div class="container">
<c:choose>
<c:when test="${!empty memberVo}">
	<form id="memberForm">
		<input type="hidden" name="id" value="${memberVo.id}" id="id">
		<input type="hidden" name="username" value="${memberVo.username}" id="username">
		<input type="hidden" name="password" value="${memberVo.password}" id="password">
		<input type="hidden" name="email" value="${memberVo.email}" id="email">
		
		<table class="table">
			<tr>
				<td>번호</td>
				<td>${memberVo.id}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${memberVo.username}</td>
			</tr>
				<td>이메일</td>
				<td>${memberVo.email}</td>
			<tr>
				<td>가입일</td>
				<td>${memberVo.dateAt} ${memberVo.timeAt}</td>
			</tr>
		</table>
		<button type="button" class="btn list">목록</button>
		<button type="button" class="btn delete">삭제</button>
		<button type="button" class="btn modify">수정</button>
	</form>
</c:when>
	<c:otherwise>
		<p>회원정보가 없습니다.</p>
	</c:otherwise>
</c:choose>
</div>
<script>
	let memberForm = $('#memberForm');
	let contextPath = "${contextPath}"
	$('#memberForm .list').click(function(){
		location.href = contextPath + "/member/list";
	});
	
	$('#memberForm .delete').click(function(){
		alert("삭제합니다.");
		memberForm.attr("action", contextPath+ "/member/delete");
		memberForm.attr("method", "post");
		memberForm.submit();
	});
	
	$('#memberForm .modify').click(function(){
		alert("수정폼으로 이동");
		memberForm.attr("action", contextPath+ "/member/updateForm");
		memberForm.attr("method", "post");
		memberForm.submit();
	});
	
</script>
</body>
</html>