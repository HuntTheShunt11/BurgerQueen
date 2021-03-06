package fr.tp.isima.BurgerQueen.common;

import java.util.HashMap;
import java.util.Map;

import fr.tp.isima.BurgerQueen.business.Users;
import fr.tp.isima.BurgerQueen.business.Burgers;
import fr.tp.isima.BurgerQueen.business.Ingredients;
import fr.tp.isima.BurgerQueen.persistence.UserDao;
import fr.tp.isima.BurgerQueen.persistence.BurgerDao;
import fr.tp.isima.BurgerQueen.persistence.IngredientDao;
import fr.tp.isima.BurgerQueen.persistence.JpaUserDao;
import fr.tp.isima.BurgerQueen.persistence.JpaBurgerDao;
import fr.tp.isima.BurgerQueen.persistence.JpaIngredientDao;

/**
 * Cette classe sert simplement � centraliser tous les objets � creer dans
 * l'application.
 * <p>
 * Cette approche est assez proche de l'injection de d�pendance
 * </p>
 * 
 * @author Benjamin
 *
 */
public class ApplicationsObjects {

	/**
	 * L'ensemble des objets sont tout simplement stockes sous la forme d'une
	 * map.
	 * 
	 * Dans notre cas nous n'aurons qu'une seule implementation par classe.
	 * 
	 * Mais dans les containers il est possible de faire bien plus
	 */
	private final Map<Class<?>, Object> objects = new HashMap<Class<?>, Object>();

	private ApplicationsObjects() {

	}

	private <T, V extends T> T addObject(Class<T> keyClass, V instance) {
		objects.put(keyClass, instance);
		return instance;
	}

	/**
	 * Cette methode charge les objets. Notons que cette initialisation en dur
	 * est valable dans notre application.
	 * 
	 * Mais elle est limit�e puisque nous n'offrons pas la possiblite de les
	 * d�finir ailleurs que dans cette m�thode.
	 * 
	 * Ce n'est pas g�nant pour notre exemple.
	 * 
	 * @return l'ensemble des objets de l'application
	 */
	public static ApplicationsObjects loadAll() {
		final ApplicationsObjects app = new ApplicationsObjects();

		final UserDao userDao = app.addObject(UserDao.class, new JpaUserDao());
		final BurgerDao burgerDao = app.addObject(BurgerDao.class, new JpaBurgerDao());
		final IngredientDao ingredientDao = app.addObject(IngredientDao.class, new JpaIngredientDao());

		// On ajoute les services metiers
		app.addObject(Users.class, new Users(userDao));
		app.addObject(Ingredients.class, new Ingredients(ingredientDao));
		app.addObject(Burgers.class, new Burgers(burgerDao, ingredientDao));

		return app;
	}

	/**
	 * 
	 * @param keyClass
	 *            la keyClass qui permet de retrouver l'objet cherch�
	 * @return l'instance correspondant � la "keyclass"
	 */
	public <T> T get(Class<T> keyClass) {
		if (!objects.containsKey(keyClass)) {
			throw new IllegalArgumentException("Aucun objet ne correspond a la classe " + keyClass);
		}
		return (T) objects.get(keyClass);
	}
}
