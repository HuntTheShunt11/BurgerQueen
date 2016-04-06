package fr.tp.isima.BurgerQueen.business;


import com.google.common.base.Preconditions;

import fr.tp.isima.BurgerQueen.persistence.UserBean;
import fr.tp.isima.BurgerQueen.persistence.UserDao;


public class User {

	private final UserBean userBean;
	private final UserDao userDao;

	public User(UserBean userBean, UserDao userDao) {
		Preconditions.checkNotNull(userDao, "userDao");
		Preconditions.checkNotNull(userBean, "userBean");
		this.userDao = userDao;
		this.userBean = userBean;
	}

	public void setNom(String nom) {
		userBean.setNom(nom);
	}

	public String getNom() {
		return userBean.getNom();
	}

	public Long getId() {
		return userBean.getId();
	}

	public void save() {
		userDao.save(userBean);
	}

	public boolean exists() {
		return userBean.getId() > 0l;
	}

}

