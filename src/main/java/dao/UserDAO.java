package dao;

import static dao.GenericDAO.em;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.User;

/**
 *
 * @author gm
 */
public class UserDAO extends GenericDAO {

    public List<User> findAll() {
        // Consulta a ejecutar
        // No necesitamos crear una nueva transaccion
        String hql = "SELECT s FROM Usuario s";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        List<User> list = query.getResultList();
        for (User usuario : list) {
            System.out.println(usuario);
        }
        return list;
    }

    public boolean insert(User usuario) {
        try {
            em = getEntityManager();
            // Iniciamos una transaccion
            em.getTransaction().begin();
            // Insertamos nuevo objeto
            em.persist(usuario);
            // Terminamos la transaccion
            em.getTransaction().commit();

            return true;
        } catch (Exception ex) {
            System.out.println("Error al insetar objeto:" + ex.getMessage());
            // ex.printStackTrace();
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean update(User usuario) {
        try {
            em = getEntityManager();
            // Iniciamos una transaccion
            em.getTransaction().begin();
            // Actualizamos al objeto 
            em.merge(usuario);
            // Terminamos la transaccion
            em.getTransaction().commit();

            return true;
        } catch (Exception ex) {
            System.out.println("Error al actualizar objeto:" + ex.getMessage());
            // ex.printStackTrace();

            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean delete(User usuario) {
        try {
            em = getEntityManager();
            // Iniciamos una transaccion
            em.getTransaction().begin();
            // Sincronizamos y eliminamos 
            em.remove(em.merge(usuario));
            // Terminamos la transaccion
            em.getTransaction().commit();

            return true;
        } catch (Exception ex) {
            System.out.println("Error al eliminar objeto:" + ex.getMessage());
            // ex.printStackTrace();
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean deleteById(Integer id) {
        try {
            User u = findById(id);
            em = getEntityManager();
            // Iniciamos una transaccion
            em.getTransaction().begin();
            // Sincronizamos y eliminamos 
            em.remove(em.merge(u));
            // Terminamos la transaccion
            em.getTransaction().commit();

            return true;
        } catch (Exception ex) {
            System.out.println("Error al eliminar objeto:" + ex.getMessage());
            // ex.printStackTrace();
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public User findById(Integer id) {
        em = getEntityManager();
        return em.find(User.class, id);
    }

    public User findByUserAndPassword(String userName, String password) {
        String hql = "SELECT u FROM User u WHERE u.userName=:user_name AND u.password=:password";
        em = getEntityManager();

        Query query = em.createQuery(hql);
        query.setParameter("user_name", userName);
        query.setParameter("password", password);

        try {
            User u = (User) query.getSingleResult();
            System.out.println("Usuario: " + u);
            return u;
        } catch (NoResultException e) {
            System.out.println("Ningun resultado");
            return null;
        }
    }
}
