package fr.tp.isima.BurgerQueen.presentation.burger;

import fr.tp.isima.BurgerQueen.business.Burger;
import fr.tp.isima.BurgerQueen.business.Ingredient;

public class IngredientViewBean {

	private final Burger burger;

	private final Ingredient ingredient;

	IngredientViewBean(Burger burger, Ingredient ingredient) {
		super();
		this.burger = burger;
		this.ingredient = ingredient;
	}

	public boolean isSelected() {
		return ingredient.equals(burger.getIngredients());
	}

	public String getNom() {
		return ingredient.getNom();
	}

	public long getId() {
		return ingredient.getId();
	}

}
