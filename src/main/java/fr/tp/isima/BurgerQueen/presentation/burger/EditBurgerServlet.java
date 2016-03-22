package fr.tp.isima.BurgerQueen.presentation.burger;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.tp.isima.BurgerQueen.business.Burger;
import fr.tp.isima.BurgerQueen.presentation.Form;
import fr.tp.isima.BurgerQueen.presentation.Page;

@WebServlet("/editArticle")
public class EditBurgerServlet extends BurgersServlet {

	@Override
	protected Page process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final Burger burger = getArticles().findById(Long.parseLong(req.getParameter("id")));
		final BurgerViewBean burgerViewBean = new BurgerViewBean(getArticles(), getIngredients(), burger);
		return forwardOnEdit().withForm(Form.successForm(burgerViewBean)).build();
	}
}
