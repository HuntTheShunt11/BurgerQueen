<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enregistrer un burger</title>
<%@include file="head.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/formulaire-elegant.css">
</head>
<body>
<div class="container">
        <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    		<h3 class="panel-title">Edition d'un burger</h3>
			 			</div>
			 			<div class="panel-body">
			    		<form role="form" method="post" action="${pageContext.request.contextPath}/saveBurger">
	    					<div class="form-group ${form.errors.reference.kindOfMessage}">
	               				<input id="reference" name="reference" type="text" placeholder="Référence du burger" class="form-control input-sm" value="${form.bean.id}" readonly>
	               				<c:if test="${form.errors.reference.error}">
									<span class="help-block"> ${form.errors.reference.errorMessage}</span>
								</c:if>
	  	            		</div>
	  	            		
	  	            		
	  	            		<div class="form-group control-group ${form.errors.nom.kindOfMessage}">
								<textarea id="description" name="description" class="form-control" placeholder="Nom du burger">${form.bean.nom}</textarea>
								<c:if test="${form.errors.nom.error}">
									 <span class="help-block"> ${form.errors.nom.errorMessage}</span>
								</c:if>
			    			</div>
	    		
			    			<div class="form-group control-group ${form.errors.description.kindOfMessage}">
								<textarea id="description" name="description" class="form-control" placeholder="Description du burger">${form.bean.description}</textarea>
								<c:if test="${form.errors.description.error}">
									 <span class="help-block"> ${form.errors.description.errorMessage}</span>
								</c:if>
			    			</div>
			    			
			    			<div class="form-group control-group ${form.errors.category.kindOfMessage}">
			    				<select class="form-control" name="ingredient">
				    				<c:forEach items="${form.bean.allIngredients}" var="ingredient">
				    					<c:choose>
				    						<c:when test="${ingredient.selected}">
						    					<option value="${ingredient.id}" selected="selected">${ingredient.nom}</option>
				    						</c:when>
				    						<c:otherwise>
						    					<option value="${ingredient.id}">${ingredient.nom}</option>					
				    						</c:otherwise>
				    					</c:choose>
				    				</c:forEach>
	   							</select>
								<c:if test="${form.errors.category.error}">
									 <span class="help-block"> ${form.errors.category.errorMessage}</span>
								</c:if>	   							
							</div>	
										
			    			<input type="submit" value="Enregistrer l'article" class="btn btn-info btn-block">
			    			<input type="hidden" name="id" value="${form.bean.id}"/>
			    		</form>
			    	</div>
	    		</div>
    		</div>
    	</div>
    </div>
</body>
</html>
