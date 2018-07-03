/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.GroupDAO;
import java.util.List;
import javax.ejb.Stateless;
import model.Group;
import service.GroupService;

/**
 *
 * @author David
 */
@Stateless
public class GroupServiceImpl implements GroupService {

    private final GroupDAO groupDAO = new GroupDAO();

    @Override
    public boolean insert(Group group) {
        return groupDAO.insert(group);
    }

    @Override
    public boolean update(Group group) {
        return groupDAO.update(group);
    }

    @Override
    public List<Group> findAll() {
        return groupDAO.findAll();
    }

    @Override
    public boolean delete(Group group) {
        return groupDAO.delete(group);
    }

    @Override
    public boolean deleteById(Integer id) {
        return groupDAO.deleteById(id);
    }

    @Override
    public Group findById(Integer id) {
        return groupDAO.findById(id);
    }

}
