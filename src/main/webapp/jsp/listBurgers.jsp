<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Une page generant une citation aleatoire</title>
<%@include file="head.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/formulaire-elegant.css">
</head>
<body>
	<div class="container">
		<div class="row centered-form">
			<div
				class="col-xs-12 col-sm-8 col-md-8 col-sm-offset-2 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<%-- 			    		<h3 class="panel-title">Liste des burgers not�s&nbsp;<a href="${pageContext.request.contextPath}/addNewArticle" style="float:right">Cr�er un article</a></h3> --%>
					</div>
					<div class="panel-body">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>#</th>
									<th>Reference</th>
									<th>Description</th>
									<th>Ingr�dients</th>
									<th>Originalit�</th>
									<th>Qualit�</th>
									<th>Pr�sentation</th>
									<th>Go�t</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${burgers}" var="burger">
									<tr>
										<td>${burger.id}</td>
										<td>${burger.nom}</td>
										<td>${burger.description}</td>
										<td>
											<ul>
												<c:forEach items="${burger.ingredients}" var="ingredient">
													<li>${ingredient.nom}</li>
												</c:forEach>
											</ul>
										</td>
										<td><fmt:formatNumber value="${burger.orig.note}" minFractionDigits="1" maxFractionDigits="1"/></td>
										<td><fmt:formatNumber value="${burger.qual.note}" minFractionDigits="1" maxFractionDigits="1"/></td>
										<td><fmt:formatNumber value="${burger.pres.note}" minFractionDigits="1" maxFractionDigits="1"/></td>
										<td><fmt:formatNumber value="${burger.gout.note}" minFractionDigits="1" maxFractionDigits="1"/></td>
										<td><a
											href="${pageContext.request.contextPath}/rateBurger?id=${burger.id}">Noter</a>&nbsp;(${burger.orig.votes})
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
