/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Group;

/**
 *
 * @author David
 */
public interface GroupService {
    public boolean insert(Group group);
    
    public boolean update(Group group);
    
    public List<Group> findAll();
    
    public boolean delete(Group group);
    
    public boolean deleteById(Integer id);
    
    public Group findById(Integer id);
}
