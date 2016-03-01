package fr.tp.isima.BurgerQueen.persistence;

import java.util.List;

public class JpaIngredientDao implements IngredientDao {

	private final EntityManagerExecutor entityManagerExecutor = new EntityManagerExecutor();

	@Override
	public List<IngredientBean> findAllCategories() {
		return entityManagerExecutor.execute(em -> em.createQuery("select a from Ingredient a", IngredientBean.class).getResultList());
	}

	@Override
	public void save(IngredientBean articleBean) {
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
	public IngredientBean findById(final long id) {
		return entityManagerExecutor
				.execute(em -> em.createQuery("select a from Ingredient a where a.id='" + id + "'", IngredientBean.class).getSingleResult());
	}

	@Override
	public void delete(IngredientBean populatedBean) {
		entityManagerExecutor.delete(populatedBean);
	}

	@Override
	public Class<IngredientBean> getBeanClass() {
		return IngredientBean.class;
	}

	@Override
	public void deleteAll() {
		entityManagerExecutor.execute(em -> em.createQuery("delete from Ingredient").executeUpdate());
	}
}
