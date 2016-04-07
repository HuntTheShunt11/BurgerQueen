package fr.tp.isima.BurgerQueen.presentation.burger;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.tp.isima.BurgerQueen.presentation.Page;

@WebServlet("/Deconnection")
public class DeconnectionServlet extends BurgersServlet{

	@Override
	protected Page process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final HttpSession session = req.getSession(); //on recupère la session

        session.invalidate();//on la supprime
		
		return redirectOnListBurgers(req).build();//et on redirige l'utilisateur sur la page d'accueil
	}

}
