<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Connexion</title>
<%@include file="/jsp/head.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/formulaire-elegant.css">
</head>
<body>
<%@include file="/jsp/banner.jsp" %>
<div class="container">
		<div class="row centered-form">
			<div
				class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Connexion :</h3>
					</div>
					<div class="panel-body">
						<div class="form-group">${form.bean.description}</div>
						<form role="form" method="post"
							action="${pageContext.request.contextPath}/connection">

							<table class="form-group ${form.errors.note.kindOfMessage}">
								<label for="inputPseudo" class="sr-only">nom d'utilisateur</label>
								<input type="text" id="inputPseudo" name="pseudo" class="form-control" placeholder="nom d'utilistateur" required autofocus>
				
							</table>
							<input type="submit" value="Connection"
								class="btn btn-info btn-block" /> <input type="hidden"
								name="id" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>