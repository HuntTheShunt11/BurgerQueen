package fr.tp.isima.BurgerQueen.business;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.base.Preconditions;

import fr.tp.isima.BurgerQueen.persistence.BurgerBean;
import fr.tp.isima.BurgerQueen.persistence.BurgerDao;
import fr.tp.isima.BurgerQueen.persistence.IngredientDao;

/**
 * 
 * @author Benjamin
 *
 */
public class Burger {

	private final BurgerBean burgerBean;
	private final BurgerDao burgerDao;
	private final IngredientDao ingredientDao;

	public Burger(BurgerBean burgerBean, BurgerDao burgerDao, IngredientDao ingredientDao) {
		Preconditions.checkNotNull(burgerDao, "burgerDao");
		Preconditions.checkNotNull(burgerBean, "burgerBean");
		Preconditions.checkNotNull(ingredientDao, "ingredientDao");
		this.ingredientDao = ingredientDao;
		this.burgerDao = burgerDao;
		this.burgerBean = burgerBean;
	}

	public void setDescription(String descriptionBurger) {
		burgerBean.setDescription(descriptionBurger);
	}

	public void setIngredients(List<Ingredient> ingredients) {
		burgerBean.setIngredients(ingredients.stream().map(ing -> ing.getIngredientBean()).collect(Collectors.toList()));
	}

	public void setNom(String nom) {
		burgerBean.setNom(nom);
	}

	public String getNom() {
		return burgerBean.getNom();
	}

	public String getDescription() {
		return burgerBean.getDescription();
	}

	public Long getId() {
		return burgerBean.getId();
	}

	public void save() {
		burgerDao.save(burgerBean);
	}

	public List<Ingredient> getIngredients() {
		return burgerBean.getIngredients().stream().map(ing -> new Ingredient(ingredientDao, ing)).collect(Collectors.toList());
	}

	public boolean exists() {
		return burgerBean.getId() > 0l;
	}

}
