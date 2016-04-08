package fr.tp.isima.BurgerQueen;

import java.util.List;

import fr.tp.isima.BurgerQueen.common.ApplicationsObjects;
import fr.tp.isima.BurgerQueen.persistence.BurgerBean;
import fr.tp.isima.BurgerQueen.persistence.BurgerDao;
import fr.tp.isima.BurgerQueen.persistence.IngredientBean;
import fr.tp.isima.BurgerQueen.persistence.IngredientDao;
import fr.tp.isima.BurgerQueen.persistence.UserBean;
import fr.tp.isima.BurgerQueen.persistence.UserDao;

public class FillDataBase {

	public static void main(String[] args) {
		final ApplicationsObjects objects = ApplicationsObjects.loadAll();

		final IngredientDao ingredientDao = objects.get(IngredientDao.class);
		final BurgerDao burgerDao = objects.get(BurgerDao.class);
		final UserDao userDao = objects.get(UserDao.class);
		
		final List<BurgerBean> burgers = burgerDao.findAllBurgers();

		ingredientDao.deleteAll();
		burgerDao.deleteAll();

		final IngredientBean tomate = new IngredientBean();
		tomate.setNom("Tomate");
		ingredientDao.save(tomate);
		
		final IngredientBean salade = new IngredientBean();
		salade.setNom("Salade");
		ingredientDao.save(salade);

		final IngredientBean steak = new IngredientBean();
		steak.setNom("Steak haché");
		ingredientDao.save(steak);
		
		final IngredientBean cheddar = new IngredientBean();
		cheddar.setNom("Cheddar");
		ingredientDao.save(cheddar);
		
		final IngredientBean chevre = new IngredientBean();
		chevre.setNom("Chevre");
		ingredientDao.save(chevre);
		
		final IngredientBean sauce = new IngredientBean();
		sauce.setNom("Sauce Burger");
		ingredientDao.save(sauce);
		

		final BurgerBean burger = new BurgerBean();
		burger.setNom("Le classic tomato");
		burger.addIngredient(tomate);
		burger.addIngredient(steak);
		burger.setDescription("Le classique!");
		burger.gout.vote(5);
		burger.orig.vote(4);
		burger.pres.vote(3);
		burger.qual.vote(2);
		burgerDao.save(burger);
		
		final UserBean user = new UserBean();
		user.setNom("test");
		userDao.save(user);

	}
}
