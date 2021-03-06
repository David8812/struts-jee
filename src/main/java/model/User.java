/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author David
 */
@Entity
@Table(name = "usuario")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    @Basic(optional = false)
    private Integer idUsuario;

    @Column(name = "user_name")
    @Basic(optional = false)
    private String userName;

    @Basic(optional = false)
    private String password;
    
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    private Group group;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User)) {
            return false;
        }
        User u = (User) o;
        if(idUsuario == null && u.getIdUsuario() != null) {
            return false;
        }
        if(idUsuario != null && u.getIdUsuario() == null) {
            return false;
        }
        return idUsuario.equals(u.getIdUsuario());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (idUsuario != null ? idUsuario.hashCode() : 0);
        hash = 17 * hash + userName.hashCode();
        hash = 17 * hash + password.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        return String.format("[ID:%s, User name: %s, Password: %s, Group:%s]", idUsuario, userName, password, group);
    }
}
