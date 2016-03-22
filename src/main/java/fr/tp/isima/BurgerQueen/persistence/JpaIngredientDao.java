package fr.tp.isima.BurgerQueen.persistence;

import java.util.List;

public class JpaIngredientDao implements IngredientDao {

	private final EntityManagerExecutor entityManagerExecutor = new EntityManagerExecutor();

	@Override
	public List<IngredientBean> findAllIngredients() {
		return entityManagerExecutor.execute(em -> em.createQuery("select a from Ingredient a", IngredientBean.class).getResultList());
	}

	@Override
	public void save(IngredientBean ingredientBean) {
		if (ingredientBean.getId() > 0) {
			entityManagerExecutor.update(ingredientBean);
		} else {
			try {
				entityManagerExecutor.insert(ingredientBean);
			} catch (final RuntimeException e) {
				ingredientBean.setId(0);
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
