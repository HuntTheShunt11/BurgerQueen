package fr.tp.isima.BurgerQueen.presentation.burger;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.tp.isima.BurgerQueen.business.Burger;
import fr.tp.isima.BurgerQueen.presentation.Form;
import fr.tp.isima.BurgerQueen.presentation.Page;

@WebServlet("/seeBurger")
public class SeeBurgerServlet extends BurgersServlet {

	@Override
	protected Page process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final Burger burger = getBurgers().findById(Long.parseLong(req.getParameter("id")));
		final BurgerViewBean burgerViewBean = new BurgerViewBean(getBurgers(), getIngredients(), burger);
		return forwardOnSee().withBean("burger", burgerViewBean).build();
	}
}
