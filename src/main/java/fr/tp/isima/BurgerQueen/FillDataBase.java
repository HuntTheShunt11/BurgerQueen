package fr.tp.isima.BurgerQueen;

import java.util.List;

import fr.tp.isima.BurgerQueen.common.ApplicationsObjects;
import fr.tp.isima.BurgerQueen.persistence.BurgerBean;
import fr.tp.isima.BurgerQueen.persistence.BurgerDao;
import fr.tp.isima.BurgerQueen.persistence.IngredientBean;
import fr.tp.isima.BurgerQueen.persistence.IngredientDao;

public class FillDataBase {

	public static void main(String[] args) {
		final ApplicationsObjects objects = ApplicationsObjects.loadAll();

		final IngredientDao ingredientDao = objects.get(IngredientDao.class);
		final BurgerDao burgerDao = objects.get(BurgerDao.class);

		final List<BurgerBean> burgers = burgerDao.findAllBurgers();

		ingredientDao.deleteAll();
		burgerDao.deleteAll();

		final IngredientBean tomate = new IngredientBean();
		tomate.setNom("Tomate");
		ingredientDao.save(tomate);

		final IngredientBean steak = new IngredientBean();
		steak.setNom("Steak haché");
		ingredientDao.save(steak);

		final BurgerBean burger = new BurgerBean();
		burger.setNom("Le classic tomato");
		burger.addIngredient(tomate);
		burger.addIngredient(steak);
		burger.setDescription("cacahuete");
		burger.gout.vote(5.0f);
		burger.orig.vote(4.0f);
		burger.pres.vote(3.0f);
		burger.qual.vote(2.0f);
		burgerDao.save(burger);

	}
}
