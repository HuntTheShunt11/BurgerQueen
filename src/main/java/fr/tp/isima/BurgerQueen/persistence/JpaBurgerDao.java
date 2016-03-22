package fr.tp.isima.BurgerQueen.persistence;

import java.util.List;

public class JpaBurgerDao implements BurgerDao {

	private final EntityManagerExecutor entityManagerExecutor = new EntityManagerExecutor();

	@Override
	public List<BurgerBean> findAllBurgers() {
		return entityManagerExecutor.execute(em -> em.createQuery("from Burger a", BurgerBean.class).getResultList());
	}

	@Override
	public void save(BurgerBean burgerBean) {
		if (burgerBean.getId() > 0) {
			entityManagerExecutor.update(burgerBean);
		} else {
			try {
				entityManagerExecutor.insert(burgerBean);
			} catch (final RuntimeException e) {
				burgerBean.setId(0);
				throw e;
			}
		}
	}

	@Override
	public BurgerBean findById(final long id) {
		return entityManagerExecutor.execute(em -> em.createQuery("select a from Burger a where a.id='" + id + "'", BurgerBean.class).getSingleResult());
	}

	@Override
	public void delete(BurgerBean populatedBean) {
		entityManagerExecutor.delete(populatedBean);
	}

	@Override
	public Class<BurgerBean> getBeanClass() {
		return BurgerBean.class;
	}

	@Override
	public void deleteAll() {
		entityManagerExecutor.execute(em -> em.createQuery("delete from Burger").executeUpdate());
	}
}
