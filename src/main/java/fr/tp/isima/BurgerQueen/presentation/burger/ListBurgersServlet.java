package fr.tp.isima.BurgerQueen.presentation.burger;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.tp.isima.BurgerQueen.presentation.Page;

@WebServlet(urlPatterns = { "/listArticles", "/index.html" })
public class ListBurgersServlet extends BurgersServlet {

	@Override
	protected Page process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return forwardOnList().withBean("articles", getArticles().findAllArticles()).build();
	}

}
