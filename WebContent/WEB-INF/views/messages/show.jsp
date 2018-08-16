<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../layout/app.jsp">
<c:param name="content">
	<%
		request.setCharacterEncoding("UTF-8");
	%>

	<h2>id : ${message.id}のタスク詳細ぺージ</h2>
	<p>
		タスク状況:
		<c:out value="${message.status}" />
	<p>
	<p>
		タスク内容:
		<c:out value="${message.content}" />
	<p>
	<p>
		登録日時:
		<fmt:formatDate value="${message.created_at}"
			pattern="yyyy-MM-dd HH:mm;ss" />
	<p>
	<p>
		更新日時:
		<fmt:formatDate value="${message.updated_at}"
			pattern="yyyy-MM-dd HH:mm:ss" />
	<p>
	<p>
		<a href="${pageContext.request.contextPath}/index">一覧に戻る</a>
		<p>
		<a href="${pageContext.request.contextPath}/edit?id=${message.id}">このタスクを編集する</a></p>
	<p>
</c:param> </c:import>