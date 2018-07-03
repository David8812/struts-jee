/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author David
 */
@Entity
@Table(name = "grupo")
public class Group implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo")
    @Basic(optional = false)
    private Integer idGroup;

    @Column(name = "group_name", unique = true)
    @Size(min = 1, max = 255)
    @NotNull
    private String groupName;
    
    @OneToMany(mappedBy = "group")
    private List<User> userList;

    public Group() {
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    @Override
    public String toString() {
        return String.format("[ID:%s, Name:%s]", idGroup, groupName);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Group)) {
            return false;
        }
        Group g = (Group) obj;
        if (idGroup != null && g.getIdGroup() == null) {
            return false;
        }
        if (idGroup == null) {
            return false;
        }
        return idGroup.equals(g.getIdGroup());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (idGroup != null ? idGroup.hashCode() : 0);
        hash = 17 * hash + groupName.hashCode();
        return hash;
    }
}
