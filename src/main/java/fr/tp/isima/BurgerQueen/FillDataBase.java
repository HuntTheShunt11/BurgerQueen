package fr.tp.isima.BurgerQueen;

import fr.tp.isima.BurgerQueen.common.ApplicationsObjects;
import fr.tp.isima.BurgerQueen.persistence.BurgerBean;
import fr.tp.isima.BurgerQueen.persistence.BurgerDao;
import fr.tp.isima.BurgerQueen.persistence.IngredientBean;
import fr.tp.isima.BurgerQueen.persistence.IngredientDao;

public class FillDataBase {

	public static void main(String[] args) {
		final ApplicationsObjects objects = ApplicationsObjects.loadAll();

		objects.get(BurgerDao.class).deleteAll();
		final IngredientDao ingredientDao = objects.get(IngredientDao.class);
		final BurgerDao burgerDao = objects.get(BurgerDao.class);
		ingredientDao.deleteAll();
		burgerDao.deleteAll();

		final IngredientBean tomate = new IngredientBean();
		tomate.setNom("Tomate");
		ingredientDao.save(tomate);

		final IngredientBean steak = new IngredientBean();
		steak.setNom("Steak hach�");
		ingredientDao.save(steak);

		final BurgerBean burger = new BurgerBean();
		burger.setNom("Le classic tomate");
		burger.addIngredient(tomate);
		burger.addIngredient(steak);
		burger.setDescription("blblblblblbl");
		burger.gout.vote(5.0f);
		burger.orig.vote(4.0f);
		burger.pres.vote(3.0f);
		burger.qual.vote(2.0f);
		burgerDao.save(burger);
	}
}
