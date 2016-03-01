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

	private final BurgerBean articleBean;
	private final BurgerDao articleDao;
	private final IngredientDao categoryDao;

	public Burger(BurgerBean articleBean, BurgerDao articleDao, IngredientDao categoryDao) {
		Preconditions.checkNotNull(articleDao, "articleDao");
		Preconditions.checkNotNull(articleBean, "articleBean");
		Preconditions.checkNotNull(categoryDao, "categoryDao");
		this.categoryDao = categoryDao;
		this.articleDao = articleDao;
		this.articleBean = articleBean;
	}

	public void setDescription(String descriptionArticle) {
		articleBean.setDescription(descriptionArticle);
	}

	public void setIngredients(List<Ingredient> ingredients) {
		articleBean.setIngredients(ingredients.stream().map(ing -> ing.getCategoryBean()).collect(Collectors.toList()));
	}

	public void setNom(String nom) {
		articleBean.setNom(nom);
	}

	public String getNom() {
		return articleBean.getNom();
	}

	public String getDescription() {
		return articleBean.getDescription();
	}

	public Long getId() {
		return articleBean.getId();
	}

	public void save() {
		articleDao.save(articleBean);
	}

	public List<Ingredient> getCategory() {
		return articleBean.getIngredients().stream().map(ing -> new Ingredient(categoryDao, ing)).collect(Collectors.toList());
	}

	public boolean exists() {
		return articleBean.getId() > 0l;
	}

}
