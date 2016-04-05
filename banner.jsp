<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        
        <nav class="navbar navbar-burgerQueen navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                  <a id="home-button" class="navbar-brand trans-100" href="${pageContext.request.contextPath}/">BurgerQueen</a>
                </div>
                <div class="navbar-collapse collapse">
                  <ul class="nav navbar-nav navbar-right">
                    <li>
						<div class="dropdown">
						  <button class="btn btn-custom dropdown-toggle" type="button" id="dropdownMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
							Profil
							<span class="caret"></span>
						  </button>
						  <ul class="dropdown-menu" aria-labelledby="dropdownMenu">
						  		<li><a href="${pageContext.request.contextPath}/connection.jsp">Connexion</a></li>
						  </ul>
						</div>
					</li>
                  </ul>
                </div>
            </div>
        </nav>
        
        