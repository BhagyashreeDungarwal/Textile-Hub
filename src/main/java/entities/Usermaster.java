/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kewal dungarwal
 */
@Entity
@Table(name = "usermaster")
@NamedQueries({
    @NamedQuery(name = "Usermaster.findAll", query = "SELECT u FROM Usermaster u"),
    @NamedQuery(name = "Usermaster.findByName", query = "SELECT u FROM Usermaster u WHERE u.name = :name"),
    @NamedQuery(name = "Usermaster.findByUserEmail", query = "SELECT u FROM Usermaster u WHERE u.userEmail = :userEmail"),
    @NamedQuery(name = "Usermaster.findByPassword", query = "SELECT u FROM Usermaster u WHERE u.password = :password"),
    @NamedQuery(name = "Usermaster.findByContactNo", query = "SELECT u FROM Usermaster u WHERE u.contactNo = :contactNo"),
    @NamedQuery(name = "Usermaster.findByGender", query = "SELECT u FROM Usermaster u WHERE u.gender = :gender")})
public class Usermaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "name")
    private String name;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "user_email")
    private String userEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "contact_no")
    private String contactNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "gender")
    private String gender;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEmail")
    private Collection<Testimonials> testimonialsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEmail")
    private Collection<Addressmaster> addressmasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEmail")
    private Collection<Ordermaster> ordermasterCollection;
    @JoinColumn(name = "roleId", referencedColumnName = "roleId")
    @ManyToOne(optional = false)
    private Rolemaster roleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "useremail")
    private Collection<Orderdetails> orderdetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEmail")
    private Collection<Getintouch> getintouchCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "useremail")
    private Collection<Payment> paymentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "useremail")
    private Collection<Cart> cartCollection;

    public Usermaster() {
    }

    public Usermaster(String userEmail) {
        this.userEmail = userEmail;
    }

    public Usermaster(String userEmail, String name, String password, String contactNo, String gender) {
        this.userEmail = userEmail;
        this.name = name;
        this.password = password;
        this.contactNo = contactNo;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonbTransient
    public Collection<Testimonials> getTestimonialsCollection() {
        return testimonialsCollection;
    }

    public void setTestimonialsCollection(Collection<Testimonials> testimonialsCollection) {
        this.testimonialsCollection = testimonialsCollection;
    }

    @JsonbTransient
    public Collection<Addressmaster> getAddressmasterCollection() {
        return addressmasterCollection;
    }

    public void setAddressmasterCollection(Collection<Addressmaster> addressmasterCollection) {
        this.addressmasterCollection = addressmasterCollection;
    }

    @JsonbTransient
    public Collection<Ordermaster> getOrdermasterCollection() {
        return ordermasterCollection;
    }

    public void setOrdermasterCollection(Collection<Ordermaster> ordermasterCollection) {
        this.ordermasterCollection = ordermasterCollection;
    }

    public Rolemaster getRoleId() {
        return roleId;
    }

    public void setRoleId(Rolemaster roleId) {
        this.roleId = roleId;
    }

    @JsonbTransient
    public Collection<Orderdetails> getOrderdetailsCollection() {
        return orderdetailsCollection;
    }

    public void setOrderdetailsCollection(Collection<Orderdetails> orderdetailsCollection) {
        this.orderdetailsCollection = orderdetailsCollection;
    }

    @JsonbTransient
    public Collection<Getintouch> getGetintouchCollection() {
        return getintouchCollection;
    }

    public void setGetintouchCollection(Collection<Getintouch> getintouchCollection) {
        this.getintouchCollection = getintouchCollection;
    }

    @JsonbTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    @JsonbTransient
    public Collection<Cart> getCartCollection() {
        return cartCollection;
    }

    public void setCartCollection(Collection<Cart> cartCollection) {
        this.cartCollection = cartCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userEmail != null ? userEmail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usermaster)) {
            return false;
        }
        Usermaster other = (Usermaster) object;
        if ((this.userEmail == null && other.userEmail != null) || (this.userEmail != null && !this.userEmail.equals(other.userEmail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usermaster[ userEmail=" + userEmail + " ]";
    }

}
