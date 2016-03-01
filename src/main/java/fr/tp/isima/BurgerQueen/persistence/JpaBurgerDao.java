package fr.tp.isima.BurgerQueen.persistence;

import java.util.List;

public class JpaBurgerDao implements BurgerDao {

	private final EntityManagerExecutor entityManagerExecutor = new EntityManagerExecutor();

	@Override
	public List<BurgerBean> findAllArticles() {
		return entityManagerExecutor.execute(em -> em.createQuery("select a from Burger a", BurgerBean.class).getResultList());
	}

	@Override
	public void save(BurgerBean articleBean) {
		if (articleBean.getId() > 0) {
			entityManagerExecutor.update(articleBean);
		} else {
			try {
				entityManagerExecutor.insert(articleBean);
			} catch (final RuntimeException e) {
				articleBean.setId(0);
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
