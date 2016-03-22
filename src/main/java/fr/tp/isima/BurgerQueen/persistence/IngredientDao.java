package fr.tp.isima.BurgerQueen.persistence;

import java.util.List;

public interface IngredientDao extends Dao<IngredientBean> {

	List<IngredientBean> findAllIngredients();

	@Override
	void save(IngredientBean articleBean);

	void delete(IngredientBean populatedBean);

}