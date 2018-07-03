/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.GenericDAO.em;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.Group;
import model.User;

/**
 *
 * @author David
 */
public class GroupDAO extends GenericDAO {

    public List<Group> findAll() {
        // Consulta a ejecutar
        // No necesitamos crear una nueva transaccion
        String hql = "SELECT g FROM Group g";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        List<Group> list = query.getResultList();
        for (Group group : list) {
            System.out.println(group);
        }
        return list;
    }

    public boolean insert(Group group) {
        try {
            em = getEntityManager();
            // Iniciamos una transaccion
            em.getTransaction().begin();
            // Insertamos nuevo objeto
            em.persist(group);
            // Terminamos la transaccion
            em.getTransaction().commit();

            return true;
        } catch (Exception ex) {
            System.out.println("Error al insetar objeto:" + ex.getMessage());
            em.getTransaction().rollback();
            ex.printStackTrace();
            return false;
        }
    }

    public boolean update(Group group) {
        try {
            em = getEntityManager();
            // Iniciamos una transaccion
            em.getTransaction().begin();
            // Actualizamos al objeto 
            em.merge(group);
            // Terminamos la transaccion
            em.getTransaction().commit();

            return true;
        } catch (Exception ex) {
            System.out.println("Error al actualizar objeto:" + ex.getMessage());
            em.getTransaction().rollback();
            ex.printStackTrace();

            return false;
        }
    }

    public boolean delete(Group group) {
        try {
            em = getEntityManager();
            // Iniciamos una transaccion
            em.getTransaction().begin();
            // Sincronizamos y eliminamos 
            em.remove(em.merge(group));
            // Terminamos la transaccion
            em.getTransaction().commit();

            return true;
        } catch (Exception ex) {
            System.out.println("Error al eliminar objeto:" + ex.getMessage());
            em.getTransaction().rollback();
            ex.printStackTrace();

            return false;
        }
    }

    public boolean deleteById(Integer id) {
        try {
            Group u = findById(id);
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
            em.getTransaction().rollback();
            ex.printStackTrace();

            return false;
        }
    }

    public Group findById(Integer id) {
        long t = System.currentTimeMillis();

        while (System.currentTimeMillis() - t <= 2000);

        em = getEntityManager();
        return em.find(Group.class, id);
    }
}
