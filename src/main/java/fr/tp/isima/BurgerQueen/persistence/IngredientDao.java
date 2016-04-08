package fr.tp.isima.BurgerQueen.persistence;

import java.util.List;

public interface IngredientDao extends Dao<IngredientBean> {

	List<IngredientBean> findAllIngredients();

	@Override
	void save(IngredientBean ingredientBean);

	void delete(IngredientBean populatedBean);

}
