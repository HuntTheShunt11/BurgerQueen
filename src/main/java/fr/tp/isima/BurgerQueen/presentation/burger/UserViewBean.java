package fr.tp.isima.BurgerQueen.presentation.burger;

import fr.tp.isima.BurgerQueen.business.User;

/**
 * Le view bean facilite l'affichage et permet d'aider a creer des jsp plus
 * simples et plus coherentes
 * 
 * @author Benjamin
 *
 */
public class UserViewBean {

	private final User user;

	public UserViewBean(User user) {
		this.user = user;
	}

	public String getNom() {
		return user.getNom();
	}

}

