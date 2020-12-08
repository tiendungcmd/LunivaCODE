<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="<%=request.getContextPath()%>/view/css/style.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/user.js"></script>
<title>ユーザ管理 </title>
</head>
<body>
	<!-- Begin vung header -->
	<jsp:include page="header.jsp"></jsp:include>

	<!-- End vung header -->

	<!-- Begin vung input-->
	<form action="ADM004.html" method="post" name="inputform">
		<table class="tbl_input" border="0" width="75%" cellpadding="0"
			cellspacing="0">
			<tr>
				<th align="left">
					<div style="padding-left: 100px;">会員情報編集</div>
				</th>
			</tr>
			<tr>
				<td class="errMsg">
					<div style="padding-left: 120px">
						&nbsp;
					</div>
				</td>
			</tr>
			<tr>
				<td align="left">
					<div style="padding-left: 100px;">
						<table border="0" width="100%" class="tbl_input" cellpadding="4"
							cellspacing="0">
							<tr>
								<td class="lbl_left"><font color="red">*</font> アカウント名:</td>
								<td align="left"><input class="txBox" type="text" name="id"
									value="" size="15" onfocus="this.style.borderColor='#0066ff';"
									onblur="this.style.borderColor='#aaaaaa';" /></td>
							</tr>
							<tr>
								<td class="lbl_left"><font color="red">*</font> グループ:</td>
								<td align="left"><select name="group_id">
										<c:forEach items="${lstGroup}" var="lstGroup">
											<option value="${lstGroup.group_id}">${lstGroup.group_name }</option>
										</c:forEach>
										<option value="0">選択してください</option>

								</select> <span>
										&nbsp;
										&nbsp;
										&nbsp;
								</span></td>
							</tr>
							<tr>
								<td class="lbl_left"><font color="red">*</font> 氏名:</td>
								<td align="left"><input class="txBox" type="text"
									name="name" value="" size="30"
									onfocus="this.style.borderColor='#0066ff';"
									onblur="this.style.borderColor='#aaaaaa';" /></td>
							</tr>
							<tr>
								<td class="lbl_left">カタカナ氏名:</td>
								<td align="left"><input class="txBox" type="text"
									name="name" value="" size="30"
									onfocus="this.style.borderColor='#0066ff';"
									onblur="this.style.borderColor='#aaaaaa';" /></td>
							</tr>
							<tr>
								<td class="lbl_left"><font color="red">*</font> 生年月日:</td>
								<td align="left"><select>
										<option value="${yearNow}" selected="selected">${yearNow}</option>
										<c:forEach items="${lstYear }" var="lstYear">
											<option value="${lstYear}">${lstYear}</option>
										</c:forEach>

								</select>年 <select>
										<option value="${monthNow }" selected="selected">${monthNow }</option>
										<c:forEach items="${lstMonth}" var="lstMonth">
											<option value="${lstMonth }">${lstMonth }</option>
										</c:forEach>
								</select>月 <select>
										<option value="${dayNow }" selected="selected">${dayNow }</option>
										<c:forEach items="${lstDay }" var="lstDay">
											<option value="${ lstDay}">${lstDay }</option>
										</c:forEach>
								</select>日</td>
							</tr>
							<tr>
								<td class="lbl_left"><font color="red">*</font> メールアドレス:</td>
								<td align="left"><input class="txBox" type="text"
									name="email" value="" size="30"
									onfocus="this.style.borderColor='#0066ff';"
									onblur="this.style.borderColor='#aaaaaa';" /></td>
							</tr>
							<tr>
								<td class="lbl_left"><font color="red">*</font>電話番号:</td>
								<td align="left"><input class="txBox" type="text"
									name="tel" value="" size="30"
									onfocus="this.style.borderColor='#0066ff';"
									onblur="this.style.borderColor='#aaaaaa';" /></td>
							</tr>
							<tr>
								<td class="lbl_left"><font color="red">*</font> パスワード:</td>
								<td align="left"><input class="txBox" type="password"
									name="email" value="" size="30"
									onfocus="this.style.borderColor='#0066ff';"
									onblur="this.style.borderColor='#aaaaaa';" /></td>
							</tr>
							<tr>
								<td class="lbl_left">パスワード（確認）:</td>
								<td align="left"><input class="txBox" type="password"
									name="email" value="" size="30"
									onfocus="this.style.borderColor='#0066ff';"
									onblur="this.style.borderColor='#aaaaaa';" /></td>
							</tr>
							<tr>
								<th align="left" colspan="2"><a href="#">日本語能力</a></th>
							</tr>
							<tr>
								<td class="lbl_left">資格:</td>
								<td align="left"><select name="kyu_id">
										<option value="0">選択してください</option>
										<c:forEach items="${lstJapan}" var="lstJapan">

											<option value="${lstJapan.code_level}">${lstJapan.code_level}</option>
										</c:forEach>


								</select></td>
							</tr>
							<tr>
								<td class="lbl_left">資格交付日:</td>
								<td align="left"><select>
										<option value="${yearNow}" selected="selected">${yearNow}</option>
										<c:forEach items="${lstYear }" var="lstYear">
											<option value="${lstYear}">${lstYear}</option>
										</c:forEach>
								</select>年 <select>
										<option value="${monthNow }" selected="selected">${monthNow }</option>
										<c:forEach items="${lstMonth}" var="lstMonth">
											<option value="${lstMonth }">${lstMonth }</option>
										</c:forEach>
								</select>月 <select>
											<option value="${dayNow }" selected="selected">${dayNow }</option>
										<c:forEach items="${lstDay }" var="lstDay">
											<option value="${ lstDay}">${lstDay }</option>
										</c:forEach>
								</select>日</td>
							</tr>
							<tr>
								<td class="lbl_left">失効日:</td>
								<td align="left"><select>
										<option value="${yearNow}" selected="selected">${yearNow}</option>
										<c:forEach items="${lstYear }" var="lstYear">
											<option value="${lstYear}">${lstYear}</option>
										</c:forEach>
								</select>年 <select>
										<option value="${monthNow }" selected="selected">${monthNow }</option>
										<c:forEach items="${lstMonth}" var="lstMonth">
											<option value="${lstMonth }">${lstMonth }</option>
										</c:forEach>
								</select>月 <select>
											<option value="${dayNow }" selected="selected">${dayNow }</option>
										<c:forEach items="${lstDay }" var="lstDay">
											<option value="${ lstDay}">${lstDay }</option>
										</c:forEach>
								</select>日</td>
							</tr>
							<tr>
								<td class="lbl_left">点数:</td>
								<td align="left"><input class="txBox" type="text"
									name="total" value="" size="5"
									onfocus="this.style.borderColor='#0066ff';"
									onblur="this.style.borderColor='#aaaaaa';" /></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		<div style="padding-left: 100px;">
			&nbsp;
		</div>
		<!-- Begin vung button -->
		<div style="padding-left: 45px;">
			<table border="0" cellpadding="4" cellspacing="0" width="300px">
				<tr>
					<th width="200px" align="center">
						&nbsp;
					</th>
					<td><input class="btn" type="submit" value="確認" /></td>
					<td><input class="btn" type="button" value="戻る" /></td>
				</tr>
			</table>
			<!-- End vung button -->
	</form>
	<!-- End vung input -->

	<!-- Begin vung footer -->
	<div class="lbl_footer">
		<br><br><br><br> Copyright © 2010 ルビナソフトウエア株式会社.
						All rights reserved. 
	</div>
	<!-- End vung footer -->
</body>

</html>