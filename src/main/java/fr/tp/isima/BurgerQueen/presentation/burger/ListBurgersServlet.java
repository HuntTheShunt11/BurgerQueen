package fr.tp.isima.BurgerQueen.presentation.burger;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.tp.isima.BurgerQueen.business.Burger;
import fr.tp.isima.BurgerQueen.presentation.Page;

@WebServlet(urlPatterns = { "/listBurgers", "/index.html" })
public class ListBurgersServlet extends BurgersServlet {

	@Override
	protected Page process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final List<Burger> burgers = getBurgers().findAllBurgers();
		return forwardOnList().withBean("burgers", burgers).build();
	}
}
