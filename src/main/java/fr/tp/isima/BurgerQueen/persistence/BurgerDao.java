package fr.tp.isima.BurgerQueen.persistence;


import java.util.List;

public interface BurgerDao extends Dao<BurgerBean> {

    /**
     * 
     * @return la liste de tous les burgers
     */
    List<BurgerBean> findAllBurgers();

    /**
     * Sauvegarde le burger dans la couche persistance
     * 
     * @param burgerBean
     */
    @Override
    void save(BurgerBean burgerBean);

    /**
     * 
     * @param populatedBean
     */
    void delete(BurgerBean populatedBean);

}
