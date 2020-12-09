<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>
			<table>
				<tr>
					<td width="80%"><img
						src="<%=request.getContextPath()%>/view/images/logo-manager-user.gif"
						alt="Luvina" />
					<td>
					<td align="left"><a href="Login.do">ログアウト</a> &nbsp; <c:url
							var="back" value="ListUserController">
							<c:param name="action" value="back"></c:param>
							<c:param name="sortType" value="${full_name }"></c:param>
							<c:param name="fullName" value="${fullName }"></c:param>
							<c:param name="group_id" value="${group_id }"></c:param>
						</c:url> <a href="ListUserController">トップ</a>
					<td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>