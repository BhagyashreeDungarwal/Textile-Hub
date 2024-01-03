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
@Table(name = "addressmaster")
@NamedQueries({
    @NamedQuery(name = "Addressmaster.findAll", query = "SELECT a FROM Addressmaster a"),
    @NamedQuery(name = "Addressmaster.findByAddId", query = "SELECT a FROM Addressmaster a WHERE a.addId = :addId"),
    @NamedQuery(name = "Addressmaster.findByAddress", query = "SELECT a FROM Addressmaster a WHERE a.address = :address"),
    @NamedQuery(name = "Addressmaster.findByContactNo", query = "SELECT a FROM Addressmaster a WHERE a.contactNo = :contactNo"),
    @NamedQuery(name = "Addressmaster.findByAltAddress", query = "SELECT a FROM Addressmaster a WHERE a.altAddress = :altAddress"),
    @NamedQuery(name = "Addressmaster.findByCity", query = "SELECT a FROM Addressmaster a WHERE a.city = :city"),
    @NamedQuery(name = "Addressmaster.findByState", query = "SELECT a FROM Addressmaster a WHERE a.state = :state")})
public class Addressmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "addId")
    private Integer addId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "contact_no")
    private String contactNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "alt_address")
    private String altAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "state")
    private String state;
    @JoinColumn(name = "user_email", referencedColumnName = "user_email")
    @ManyToOne(optional = false)
    private Usermaster userEmail;

    public Addressmaster() {
    }

    public Addressmaster(Integer addId) {
        this.addId = addId;
    }

    public Addressmaster(Integer addId, String address, String contactNo, String altAddress, String city, String state) {
        this.addId = addId;
        this.address = address;
        this.contactNo = contactNo;
        this.altAddress = altAddress;
        this.city = city;
        this.state = state;
    }

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAltAddress() {
        return altAddress;
    }

    public void setAltAddress(String altAddress) {
        this.altAddress = altAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
        hash += (addId != null ? addId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Addressmaster)) {
            return false;
        }
        Addressmaster other = (Addressmaster) object;
        if ((this.addId == null && other.addId != null) || (this.addId != null && !this.addId.equals(other.addId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Addressmaster[ addId=" + addId + " ]";
    }
    
}
