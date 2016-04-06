package fr.tp.isima.BurgerQueen.presentation.burger;

import javax.servlet.http.HttpServletRequest;

import fr.tp.isima.BurgerQueen.business.Burgers;
import fr.tp.isima.BurgerQueen.business.Ingredients;
import fr.tp.isima.BurgerQueen.business.Users;
import fr.tp.isima.BurgerQueen.presentation.NavigableServlet;
import fr.tp.isima.BurgerQueen.presentation.Page;
import fr.tp.isima.BurgerQueen.presentation.Page.PageBuilder;

abstract class BurgersServlet extends NavigableServlet {

	final protected Burgers getBurgers() {
		return getApplicationObjects().get(Burgers.class);
	}
	
	final protected Users getUsers() {
		return getApplicationObjects().get(Users.class);
	}

	final protected Ingredients getIngredients() {
		return getApplicationObjects().get(Ingredients.class);
	}

	protected final PageBuilder forwardOnRate() {
		return Page.forwardOn("/jsp/rateBurger.jsp");
	}
	
	protected final PageBuilder forwardOnCreate() {
		return Page.forwardOn("/jsp/createBurger.jsp");
	}

	protected final PageBuilder redirectOnListBurgers(HttpServletRequest req) {
		return Page.redirectOn(req.getContextPath() + "/listBurgers");
	}

	protected final PageBuilder forwardOnList() {
		return Page.forwardOn("/jsp/listBurgers.jsp");
	}
	
	protected final PageBuilder forwardOnSee() {
		return Page.forwardOn("/jsp/seeBurger.jsp");
	}
	
	protected final PageBuilder forwardOnConnection() {
		return Page.forwardOn("/jsp/connection.jsp");
	}
}
