package fr.tp.isima.BurgerQueen.persistence;

import javax.persistence.EntityManager;

public interface CalledDuringTransaction<T> {

    T call(EntityManager entityManager);
}
