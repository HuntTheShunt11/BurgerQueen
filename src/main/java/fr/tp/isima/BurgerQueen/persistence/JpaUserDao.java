package fr.tp.isima.BurgerQueen.persistence;

public class JpaUserDao implements UserDao {

	private final EntityManagerExecutor entityManagerExecutor = new EntityManagerExecutor();

	@Override
	public UserBean findByName(String nom) {
		return entityManagerExecutor.execute(em -> em.createQuery("select a from User a where a.nom='" + nom + "'", UserBean.class).getSingleResult());
	}

	@Override
	public UserBean findById(final long id) {
		return entityManagerExecutor.execute(em -> em.createQuery("select a from User a where a.id='" + id + "'", UserBean.class).getSingleResult());
	}

	@Override
	public Class<UserBean> getBeanClass() {
		return UserBean.class;
	}

	@Override
	public void save(UserBean userBean) {
		if (userBean.getId() > 0) {
			entityManagerExecutor.update(userBean);
		} else {
			try {
				entityManagerExecutor.insert(userBean);
			} catch (final RuntimeException e) {
				userBean.setId(0);
				throw e;
			}
		}
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
}

