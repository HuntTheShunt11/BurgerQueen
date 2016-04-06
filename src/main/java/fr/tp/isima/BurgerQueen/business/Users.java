package fr.tp.isima.BurgerQueen.business;


import javax.persistence.NoResultException;

import com.google.common.base.Optional;

import fr.tp.isima.BurgerQueen.business.User;
import fr.tp.isima.BurgerQueen.persistence.UserBean;
import fr.tp.isima.BurgerQueen.persistence.UserDao;

public class Users {
	private final UserDao userDao;

	public Users(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	public User createUser() {
        final UserBean userBean = new UserBean();
        return new User(userBean, userDao);
    }

	public Optional<User> findUserById(long id) {
		try {
			return Optional.of(new User(userDao.findById(id), userDao));
		} catch (final NoResultException e) {
			return Optional.absent();
		}
	}

	public User findUserByName(String name) {
		try {
			return new User(userDao.findByName(name), userDao);
		} catch (final NoResultException e) {
			return null;
		}
	}
}
