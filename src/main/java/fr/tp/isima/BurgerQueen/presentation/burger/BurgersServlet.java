package fr.tp.isima.BurgerQueen.presentation.burger;

import javax.servlet.http.HttpServletRequest;

import fr.tp.isima.BurgerQueen.business.Burgers;
import fr.tp.isima.BurgerQueen.presentation.NavigableServlet;
import fr.tp.isima.BurgerQueen.presentation.Page;
import fr.tp.isima.BurgerQueen.presentation.Page.PageBuilder;

abstract class BurgersServlet extends NavigableServlet {

	final protected Burgers getArticles() {
		return getApplicationObjects().get(Burgers.class);
	}

	// final protected Categories getCategories() {
	// return getApplicationObjects().get(Categories.class);
	// }

	protected final PageBuilder forwardOnEdit() {
		return Page.forwardOn("/jsp/editBurger.jsp");
	}

	protected final PageBuilder redirectOnListArticles(HttpServletRequest req) {
		return Page.redirectOn(req.getContextPath() + "/listBurgers");
	}

	protected final PageBuilder forwardOnList() {
		return Page.forwardOn("/jsp/listBurgers.jsp");
	}
}
