<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>�valuation : ${form.bean.nom}</title>
<%@include file="head.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/formulaire-elegant.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/stars.js"></script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/stars.css">
</head>
<body>
	<div class="container">
		<div class="row centered-form">
			<div
				class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">�valuation : ${form.bean.nom}</h3>
					</div>
					<div class="panel-body">
						<div class="form-group">${form.bean.description}</div>
						<form role="form" method="post"
							action="${pageContext.request.contextPath}/saveRate?id=${form.bean.id}">

						<% pageContext.setAttribute("labels", new String[][]{
							{"orig", "Originalit�"},
							{"qual", "Qualit�"},
							{"pres", "Pr�sentation"},
							{"gout", "Go�t"}
						}); %>

							<table class="form-group ${form.errors.note.kindOfMessage}">
								<c:if test="${form.errors.note.error}">
									 <span class="help-block"> ${form.errors.note.errorMessage}</span>
								</c:if>
								<c:forEach items="${labels}" var="item">
									<tr>
										<td style="padding: 0 8px">${item[1]}</td>
										<td style="padding: 0 8px">0</td>
										<td>
											<c:forEach begin="0" end="5" var="note">
												<input type="radio" name="${item[0]}" value="${note}" />
											</c:forEach>
										</td>
										<td style="padding: 0 8px">5</td>
									</tr>
								</c:forEach>
							</table>
							<input type="submit" value="Enregistrer l'article"
								class="btn btn-info btn-block" /> <input type="hidden"
								name="id" value="${form.bean.id}" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
