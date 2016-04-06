package fr.tp.isima.BurgerQueen.business;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.base.Preconditions;

import fr.tp.isima.BurgerQueen.persistence.BurgerBean;
import fr.tp.isima.BurgerQueen.persistence.BurgerDao;
import fr.tp.isima.BurgerQueen.persistence.IngredientDao;

/**
 * Cette classe de service permet d'accéder à l'ensemble des burgers
 * 
 * @see BurgerDao
 * @see IngredientDao
 * 
 * @author Benjamin KUCHCIK
 * 
 */
public class Burgers {

	private final BurgerDao burgerDao;
	private final IngredientDao ingredientDao;

	public Burgers(BurgerDao burgerDao, IngredientDao ingredientDao) {
		Preconditions.checkNotNull(burgerDao, "burgerDao");
		Preconditions.checkNotNull(ingredientDao, "ingredientDao");
		this.burgerDao = burgerDao;
		this.ingredientDao = ingredientDao;

	}

	public Burger createBurger() {
		final BurgerBean burgerBean = new BurgerBean();
		return new Burger(burgerBean, burgerDao, ingredientDao);
	}

	/**
	 * 
	 * @return la liste de tous les burgers disponibles
	 */
	public List<Burger> findAllBurgers() {
		return burgerDao.findAllBurgers().stream().map(burgerBean -> new Burger(burgerBean, burgerDao,
				ingredientDao)).collect(Collectors.toList());
	}

	public Burger findById(long parseLong) {
		return new Burger(burgerDao.findById(parseLong), burgerDao, ingredientDao);
	}

	public void deleteBurgerById(long id) {
		burgerDao.delete(burgerDao.findById(id));
	}

}
