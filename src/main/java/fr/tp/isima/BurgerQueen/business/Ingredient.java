package fr.tp.isima.BurgerQueen.business;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;

import fr.tp.isima.BurgerQueen.persistence.IngredientBean;
import fr.tp.isima.BurgerQueen.persistence.IngredientDao;

/**
 * La catégorie permet de regrouper les articles ( {@link Article}) rendant
 * possible l'affichage thématique
 * 
 * @author Benjamin
 *
 */
public class Ingredient {

	private final IngredientBean categoryBean;
	private final IngredientDao categoryDao;

	Ingredient(IngredientDao categoryDao, IngredientBean categoryBean) {
		this.categoryDao = categoryDao;
		Preconditions.checkNotNull(categoryBean);
		this.categoryBean = categoryBean;
	}

	public IngredientBean getCategoryBean() {
		return categoryBean;
	}

	public String getNom() {
		return categoryBean.getNom();
	}

	public long getId() {
		return categoryBean.getId();
	}

	public void save() {
		categoryDao.save(categoryBean);
	}

	@Override
	public int hashCode() {
		return HashCode.fromLong(categoryBean.getId()).asInt();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Ingredient) {
			final Ingredient that = (Ingredient) obj;
			return Objects.equal(categoryBean.getId(), that.categoryBean.getId());
		}
		return false;
	}
}
