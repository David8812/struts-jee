package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gm
 */
public abstract class GenericDAO {

    protected static EntityManager em;
    private static EntityManagerFactory emf;
    private static final String PERSISTENCE_UNIT_NAME = "HibernateJpaPU";

    public GenericDAO() {
        if (emf == null) {
            System.out.println("Entrando a crear EntityManagerFactory");
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            System.out.println("EntityManagerFactory creada");
        }
    }

    protected EntityManager getEntityManager() {
        if (em == null) {
            System.out.println("Entrando a crear Entity manager");
            em = emf.createEntityManager();
            System.out.println("Entity manager created");
        }
        return em;
    }
}
