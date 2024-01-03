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

/**
 *
 * @author kewal dungarwal
 */
@Entity
@Table(name = "cart")
@NamedQueries({
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c"),
    @NamedQuery(name = "Cart.findByCartId", query = "SELECT c FROM Cart c WHERE c.cartId = :cartId"),
    @NamedQuery(name = "Cart.findByMeters", query = "SELECT c FROM Cart c WHERE c.meters = :meters"),
    @NamedQuery(name = "Cart.findByAmount", query = "SELECT c FROM Cart c WHERE c.amount = :amount")})
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cartId")
    private Integer cartId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "meters")
    private int meters;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @JoinColumn(name = "prodId", referencedColumnName = "prodId")
    @ManyToOne(optional = false)
    private Productmaster prodId;
    @JoinColumn(name = "useremail", referencedColumnName = "user_email")
    @ManyToOne(optional = false)
    private Usermaster useremail;

    public Cart() {
    }

    public Cart(Integer cartId) {
        this.cartId = cartId;
    }

    public Cart(Integer cartId, int meters, int amount) {
        this.cartId = cartId;
        this.meters = meters;
        this.amount = amount;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public int getMeters() {
        return meters;
    }

    public void setMeters(int meters) {
        this.meters = meters;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Productmaster getProdId() {
        return prodId;
    }

    public void setProdId(Productmaster prodId) {
        this.prodId = prodId;
    }

    public Usermaster getUseremail() {
        return useremail;
    }

    public void setUseremail(Usermaster useremail) {
        this.useremail = useremail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartId != null ? cartId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.cartId == null && other.cartId != null) || (this.cartId != null && !this.cartId.equals(other.cartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cart[ cartId=" + cartId + " ]";
    }
    
}
