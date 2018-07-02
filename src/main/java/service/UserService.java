/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Local;
import model.User;

/**
 *
 * @author David
 */
@Local
public interface UserService {
    
    public boolean insert(User user);
    
    public boolean update(User user);
    
    public List<User> findAll();
    
    public boolean delete(User user);
    
    public boolean deleteById(Integer id);
    
    public boolean findByUserAndPassword(String userName, String password);
}
