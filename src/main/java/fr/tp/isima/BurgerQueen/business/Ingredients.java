package fr.tp.isima.BurgerQueen.business;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.NoResultException;

import com.google.common.base.Optional;

import fr.tp.isima.BurgerQueen.persistence.IngredientDao;

public class Ingredients {
	private final IngredientDao ingredientDao;

	public Ingredients(IngredientDao ingredientDao) {
		super();
		this.ingredientDao = ingredientDao;
	}

	/**
	 * 
	 * @return la liste de tous les ingredients
	 */
	public List<Ingredient> findAllIngredients() {
		return ingredientDao.findAllIngredients().stream().map((ingre) -> new Ingredient(ingredientDao, ingre)).collect(Collectors.toList());
	}

	public Optional<Ingredient> findIngredientById(long id) {
		try {
			return Optional.of(new Ingredient(ingredientDao, ingredientDao.findById(id)));
		} catch (final NoResultException e) {
			return Optional.absent();
		}
	}
}
