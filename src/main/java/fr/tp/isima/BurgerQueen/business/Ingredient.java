package fr.tp.isima.BurgerQueen.business;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;

import fr.tp.isima.BurgerQueen.persistence.IngredientBean;
import fr.tp.isima.BurgerQueen.persistence.IngredientDao;

/**
 * 
 * @author Benjamin
 *
 */
public class Ingredient {

	private final IngredientBean ingredientBean;
	private final IngredientDao ingredientDao;

	Ingredient(IngredientDao ingredientDao, IngredientBean ingredientBean) {
		this.ingredientDao = ingredientDao;
		Preconditions.checkNotNull(ingredientBean);
		this.ingredientBean = ingredientBean;
	}

	public IngredientBean getIngredientBean() {
		return ingredientBean;
	}

	public String getNom() {
		return ingredientBean.getNom();
	}

	public long getId() {
		return ingredientBean.getId();
	}

	public void save() {
		ingredientDao.save(ingredientBean);
	}

	@Override
	public int hashCode() {
		return HashCode.fromLong(ingredientBean.getId()).asInt();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Ingredient) {
			final Ingredient that = (Ingredient) obj;
			return Objects.equal(ingredientBean.getId(), that.ingredientBean.getId());
		}
		return false;
	}
}
