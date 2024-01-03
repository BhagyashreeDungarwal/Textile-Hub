/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kewal dungarwal
 */
@Entity
@Table(name = "getintouch")
@NamedQueries({
    @NamedQuery(name = "Getintouch.findAll", query = "SELECT g FROM Getintouch g"),
    @NamedQuery(name = "Getintouch.findById", query = "SELECT g FROM Getintouch g WHERE g.id = :id"),
    @NamedQuery(name = "Getintouch.findByName", query = "SELECT g FROM Getintouch g WHERE g.name = :name"),
    @NamedQuery(name = "Getintouch.findByMessage", query = "SELECT g FROM Getintouch g WHERE g.message = :message")})
public class Getintouch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "message")
    private String message;
    @JoinColumn(name = "user_email", referencedColumnName = "user_email")
    @ManyToOne(optional = false)
    private Usermaster userEmail;

    public Getintouch() {
    }

    public Getintouch(Integer id) {
        this.id = id;
    }

    public Getintouch(Integer id, String name, String message) {
        this.id = id;
        this.name = name;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Usermaster getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(Usermaster userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Getintouch)) {
            return false;
        }
        Getintouch other = (Getintouch) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Getintouch[ id=" + id + " ]";
    }
    
}
