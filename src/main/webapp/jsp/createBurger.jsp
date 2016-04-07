<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nouveau burger</title>
<%@include file="head.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/createBurger.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/formulaire-elegant.css">
<body>
	<%@include file="banner.jsp" %>
	<div class="container">
		<div class="row centered-form">
			<div
				class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Nouveau burger</h3>
					</div>
					<div class="panel-body">
						<form role="form" method="post"
							action="${pageContext.request.contextPath}/saveBurger">

						<h3>Nom du burger</h3>
						<input type="text" name="nom" />

						<h3>Description du burger</h3>
						<textarea name="desc"></textarea>

						<h3>Ingrédients</h3>
						
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-btn"><select class="form-control" id="ingredientSelector">
									<c:forEach items="${form.bean.allIngredients}" var="ingredient">
										<option value="${ingredient.id}">${ingredient.nom}</option>
									</c:forEach>
								</select></span>
								<span class="input-group-btn"><button type="button" class="btn btn-primary" onclick="javascript:addIngredient();">Ajouter</button></span>
							</div>
						</div>
						
						<ul class="list-group" id="ingredientsList"></ul>

						<% pageContext.setAttribute("labels", new String[][]{
							{"orig", "Originalité"},
							{"qual", "Qualité"},
							{"pres", "Présentation"},
							{"gout", "Goût"}
						}); %>

							<h3>Notez ce burger</h3>
							<table class="form-group ${form.errors.note.kindOfMessage}">
								<c:if test="${form.errors.note.error}">
									 <p class="text-error"> ${form.errors.note.errorMessage}</p>
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
							<input type="submit" value="Enregistrer le burger"
								class="btn btn-info btn-block" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
