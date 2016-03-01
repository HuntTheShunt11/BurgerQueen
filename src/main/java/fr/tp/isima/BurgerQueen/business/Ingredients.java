package fr.tp.isima.BurgerQueen.business;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.NoResultException;

import com.google.common.base.Optional;

import fr.tp.isima.BurgerQueen.persistence.IngredientDao;

public class Ingredients {
	private final IngredientDao categoryDao;

	public Ingredients(IngredientDao categoryDao) {
		super();
		this.categoryDao = categoryDao;
	}

	/**
	 * 
	 * @return la liste de toutes les categories d'article
	 */
	public List<Ingredient> findAllCategories() {
		return categoryDao.findAllCategories().stream().map((categ) -> new Ingredient(categoryDao, categ)).collect(Collectors.toList());
	}

	public Optional<Ingredient> findCategoryById(long id) {
		try {
			return Optional.of(new Ingredient(categoryDao, categoryDao.findById(id)));
		} catch (final NoResultException e) {
			return Optional.absent();
		}
	}
}
