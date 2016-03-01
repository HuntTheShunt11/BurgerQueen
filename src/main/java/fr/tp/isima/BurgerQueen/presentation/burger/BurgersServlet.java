package fr.tp.isima.BurgerQueen.presentation.burger;

import javax.servlet.http.HttpServletRequest;

import org.junit.experimental.categories.Categories;

import fr.tp.isima.BurgerQueen.business.Burgers;
import fr.tp.isima.BurgerQueen.presentation.NavigableServlet;
import fr.tp.isima.BurgerQueen.presentation.Page;
import fr.tp.isima.BurgerQueen.presentation.Page.PageBuilder;

abstract class BurgersServlet extends NavigableServlet {

	final protected Burgers getArticles() {
		return getApplicationObjects().get(Burgers.class);
	}

	final protected Categories getCategories() {
		return getApplicationObjects().get(Categories.class);
	}

	protected final PageBuilder forwardOnEdit() {
		return Page.forwardOn("/jsp/editArticle.jsp");
	}

	protected final PageBuilder redirectOnListArticles(HttpServletRequest req) {
		return Page.redirectOn(req.getContextPath() + "/listArticles");
	}

	protected final PageBuilder forwardOnList() {
		return Page.forwardOn("/jsp/listArticles.jsp");
	}
}
