<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Détails : ${burger.nom}</title>
<%@include file="head.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/formulaire-elegant.css">
<body>
	<div class="container">
		<div class="row centered-form">
			<div
				class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Détails : ${burger.nom}</h3>
					</div>
					<div class="panel-body">
						<h3>Description</h3>
						<div class="form-group">${burger.description}</div>

						<h3>Notes (${burger.orig.votes})</h3>
						<table>
							<tr>
								<td style="padding: 0 8px">Originalité :</td>
								<td><fmt:formatNumber value="${burger.orig.note}"
										minFractionDigits="1" maxFractionDigits="1" /></td>
							</tr>
							<tr>
								<td style="padding: 0 8px">Qualité :</td>
								<td><fmt:formatNumber value="${burger.qual.note}"
										minFractionDigits="1" maxFractionDigits="1" /></td>
							</tr>
							<tr>
								<td style="padding: 0 8px">Présentation :</td>
								<td><fmt:formatNumber value="${burger.pres.note}"
										minFractionDigits="1" maxFractionDigits="1" /></td>
							</tr>
							<tr>
								<td style="padding: 0 8px">Goût :</td>
								<td><fmt:formatNumber value="${burger.gout.note}"
										minFractionDigits="1" maxFractionDigits="1" /></td>
							</tr>
						</table>

						<h3>Ingrédients</h3>
						<ul>
							<c:forEach items="${burger.ingredients}" var="ingredient">
								<li>${ingredient.nom}</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
