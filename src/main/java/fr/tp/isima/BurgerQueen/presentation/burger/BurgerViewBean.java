package fr.tp.isima.BurgerQueen.presentation.burger;

import java.util.List;
import java.util.stream.Collectors;

import fr.tp.isima.BurgerQueen.business.Burger;
import fr.tp.isima.BurgerQueen.business.Burgers;
import fr.tp.isima.BurgerQueen.business.Ingredient;
import fr.tp.isima.BurgerQueen.business.Ingredients;

/**
 * Le view bean facilite l'affichage et permet d'aider a creer des jsp plus
 * simples et plus coherentes
 * 
 * @author Benjamin
 *
 */
public class BurgerViewBean {

	private final Burgers burgers;

	private final Burger burger;

	private final Ingredients ingredients;

	public BurgerViewBean(Burgers burgers, Ingredients ingredients, Burger burger) {
		this.burgers = burgers;
		this.ingredients = ingredients;
		this.burger = burger;
	}

	public String getNom() {
		return burger.getNom();
	}

	public String getDescription() {
		return burger.getDescription();
	}

	public Long getId() {
		return burger.getId();
	}

	public List<Ingredient> getIngredients() {
		return burger.getIngredients();
	}

	public List<IngredientViewBean> getAllIngredients() {
		return ingredients.findAllIngredients().stream().map((c) -> new IngredientViewBean(burger, c)).collect(Collectors.toList());
	}

}
