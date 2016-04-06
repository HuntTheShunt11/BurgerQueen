package fr.tp.isima.BurgerQueen.persistence;



public interface UserDao extends Dao<UserBean> {

	/**
     * @param nom
     * @return UserBean
     */
    UserBean findByName(String nom);

    /**
     * 
     * @param id
     * @return UserBean
     */
    @Override
    UserBean findById(long id);

}
