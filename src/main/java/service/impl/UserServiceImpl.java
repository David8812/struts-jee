/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.UserDAO;
import java.util.List;
import javax.ejb.Stateless;
import model.User;
import service.UserService;

/**
 *
 * @author David
 */
@Stateless
public class UserServiceImpl implements UserService {
    
    private final UserDAO userDao = new UserDAO();

    @Override
    public boolean insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean delete(User user) {
        return userDao.delete(user);
    }

    @Override
    public boolean deleteById(Integer id) {
        return userDao.deleteById(id);
    }

    @Override
    public boolean findByUserAndPassword(String userName, String password) {
        return userDao.findByUserAndPassword(userName, password) != null;
    }
    
}
