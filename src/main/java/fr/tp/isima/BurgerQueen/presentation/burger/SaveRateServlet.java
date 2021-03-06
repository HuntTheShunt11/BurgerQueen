package fr.tp.isima.BurgerQueen.presentation.burger;

import static fr.tp.isima.BurgerQueen.presentation.ErrorFields.newErrorBuilder;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.tp.isima.BurgerQueen.business.Burger;
import fr.tp.isima.BurgerQueen.presentation.ErrorFields;
import fr.tp.isima.BurgerQueen.presentation.Form;
import fr.tp.isima.BurgerQueen.presentation.Page;

@WebServlet("/save/Rate")
public class SaveRateServlet extends BurgersServlet {

	@Override
	protected Page process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final List<Burger> burgers = getBurgers().findAllBurgers();

		final Burger burger = getBurgers().findById(Long.parseLong(req.getParameter("id")));

		try {
			final int orig = Integer.parseInt(req.getParameter("orig")),
					qual = Integer.parseInt(req.getParameter("qual")),
					pres = Integer.parseInt(req.getParameter("pres")),
					gout = Integer.parseInt(req.getParameter("gout"));

			burger.getOrig().vote(orig);
			burger.getQual().vote(qual);
			burger.getPres().vote(pres);
			burger.getGout().vote(gout);

			burger.save();
		} catch (final IllegalArgumentException e) {

			return returnToRatePage(burger, newErrorBuilder().addField("note", "note invalide").build());
		}

		return redirectOnListBurgers(req).withBean("burgers", burgers).build();
	}

	private Page returnToRatePage(final Burger burger, final ErrorFields fields) {
		final BurgerViewBean burViewBean = new BurgerViewBean(getBurgers(), getIngredients(), burger);
		final Form<BurgerViewBean> form = new Form<BurgerViewBean>(burViewBean, fields);

		return forwardOnRate().withForm(form).build();
	}
}
