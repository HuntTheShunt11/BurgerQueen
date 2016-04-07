package fr.tp.isima.BurgerQueen.presentation.burger;

import static fr.tp.isima.BurgerQueen.presentation.ErrorFields.newErrorBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.tp.isima.BurgerQueen.business.Burger;
import fr.tp.isima.BurgerQueen.business.Burgers;
import fr.tp.isima.BurgerQueen.business.Ingredients;
import fr.tp.isima.BurgerQueen.persistence.UniqueConstraintException;
import fr.tp.isima.BurgerQueen.presentation.ErrorFields;
import fr.tp.isima.BurgerQueen.presentation.Form;
import fr.tp.isima.BurgerQueen.presentation.Page;

@WebServlet("/save/Burger")
public class SaveBurgerServlet extends BurgersServlet {

	@Override
	protected Page process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final Burgers burgers = getBurgers();
		final Ingredients ingredients = getIngredients();
		final Burger burger = burgers.createBurger();

		try {
			final int orig = Integer.parseInt(req.getParameter("orig")),
					qual = Integer.parseInt(req.getParameter("qual")),
					pres = Integer.parseInt(req.getParameter("pres")),
					gout = Integer.parseInt(req.getParameter("gout"));
			
			String nom = req.getParameter("nom"),
					desc = req.getParameter("desc");

			burger.setNom(nom);
			burger.setDescription(desc);
			
			String[] ing = req.getParameterValues("ingredients[]");
			
			burger.setIngredients(
				Arrays.stream(ing)
				.map(id -> ingredients.findIngredientById(Integer.parseInt(id)))
				.map(opt -> opt.get())
				.collect(Collectors.toList())
			);
			
			burger.getOrig().vote(orig);
			burger.getQual().vote(qual);
			burger.getPres().vote(pres);
			burger.getGout().vote(gout);

			burger.save();
		} catch (final UniqueConstraintException e) {
			
			return returnToCreatePage(burger, newErrorBuilder().addField("burger", "Ce burger existe d�j�!").build());
			
        } catch (final IllegalArgumentException e) {

			return returnToCreatePage(burger, newErrorBuilder().addField("note", "note invalide").build());
		}

		return redirectOnListBurgers(req).withBean("burgers", burgers).build();
	}

	private Page returnToCreatePage(final Burger burger, final ErrorFields fields) {
		final BurgerViewBean burViewBean = new BurgerViewBean(getBurgers(), getIngredients(), burger);
		final Form<BurgerViewBean> form = new Form<BurgerViewBean>(burViewBean, fields);

		return forwardOnCreate().withForm(form).build();
	}
}
