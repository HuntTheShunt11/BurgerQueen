package fr.tp.isima.BurgerQueen.persistence;


import java.util.List;

public interface BurgerDao extends Dao<BurgerBean> {

    /**
     * 
     * @return la liste de tous les articles
     */
    List<BurgerBean> findAllArticles();

    /**
     * Sauvegarde l'article dans la couche persistance
     * 
     * @param articleBean
     */
    @Override
    void save(BurgerBean articleBean);

    /**
     * 
     * @param populatedBean
     */
    void delete(BurgerBean populatedBean);

}
