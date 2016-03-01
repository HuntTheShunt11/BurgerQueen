package fr.tp.isima.BurgerQueen.business;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.base.Preconditions;

import fr.tp.isima.BurgerQueen.persistence.BurgerBean;
import fr.tp.isima.BurgerQueen.persistence.BurgerDao;
import fr.tp.isima.BurgerQueen.persistence.IngredientDao;

/**
 * Cette classe de service permet d'accéder à l'ensemble des articles et
 * categories
 * 
 * @see ArticleDao
 * @see CategorieDao
 * 
 * @author Benjamin KUCHCIK
 * 
 */
public class Burgers {

	private final BurgerDao articleDao;
	private final IngredientDao categoryDao;

	public Burgers(BurgerDao articleDao, IngredientDao categoryDao) {
		Preconditions.checkNotNull(articleDao, "articleDao");
		Preconditions.checkNotNull(categoryDao, "categoryDao");
		this.articleDao = articleDao;
		this.categoryDao = categoryDao;

	}

	public Burger createArticle() {
		final BurgerBean articleBean = new BurgerBean();
		return new Burger(articleBean, articleDao, categoryDao);
	}

	/**
	 * 
	 * @return la liste de tous les articles disponibles
	 */
	public List<Burger> findAllArticles() {
		return articleDao.findAllArticles().stream().map(articleBean -> new Burger(articleBean, articleDao,
				categoryDao)).collect(Collectors.toList());
	}

	public Burger findById(long parseLong) {
		return new Burger(articleDao.findById(parseLong), articleDao, categoryDao);
	}

	public void deleteArticleById(long id) {
		articleDao.delete(articleDao.findById(id));
	}

}
