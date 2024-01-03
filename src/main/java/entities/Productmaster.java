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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "productmaster")
@NamedQueries({
    @NamedQuery(name = "Productmaster.findAll", query = "SELECT p FROM Productmaster p"),
    @NamedQuery(name = "Productmaster.findByProdId", query = "SELECT p FROM Productmaster p WHERE p.prodId = :prodId"),
    @NamedQuery(name = "Productmaster.findByName", query = "SELECT p FROM Productmaster p WHERE p.name = :name"),
    @NamedQuery(name = "Productmaster.findByDescription", query = "SELECT p FROM Productmaster p WHERE p.description = :description"),
    @NamedQuery(name = "Productmaster.findByImage", query = "SELECT p FROM Productmaster p WHERE p.image = :image"),
    @NamedQuery(name = "Productmaster.findByTax", query = "SELECT p FROM Productmaster p WHERE p.tax = :tax"),
    @NamedQuery(name = "Productmaster.findByColors", query = "SELECT p FROM Productmaster p WHERE p.colors = :colors"),
    @NamedQuery(name = "Productmaster.findByMeters", query = "SELECT p FROM Productmaster p WHERE p.meters = :meters"),
    @NamedQuery(name = "Productmaster.findByPrice", query = "SELECT p FROM Productmaster p WHERE p.price = :price")})
public class Productmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prodId")
    private Integer prodId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tax")
    private double tax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "colors")
    private String colors;
    @Basic(optional = false)
    @NotNull
    @Column(name = "meters")
    private int meters;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proId")
    private Collection<Testimonials> testimonialsCollection;
    @JoinColumn(name = "catId", referencedColumnName = "catId")
    @ManyToOne(optional = false)
    private Category catId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodId")
    private Collection<Orderdetails> orderdetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodId")
    private Collection<Cart> cartCollection;

    public Productmaster() {
    }

    public Productmaster(Integer prodId) {
        this.prodId = prodId;
    }

    public Productmaster(Integer prodId, String name, String description, String image, double tax, String colors, int meters, double price) {
        this.prodId = prodId;
        this.name = name;
        this.description = description;
        this.image = image;
        this.tax = tax;
        this.colors = colors;
        this.meters = meters;
        this.price = price;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public int getMeters() {
        return meters;
    }

    public void setMeters(int meters) {
        this.meters = meters;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @JsonbTransient
    public Collection<Testimonials> getTestimonialsCollection() {
        return testimonialsCollection;
    }

    public void setTestimonialsCollection(Collection<Testimonials> testimonialsCollection) {
        this.testimonialsCollection = testimonialsCollection;
    }

    public Category getCatId() {
        return catId;
    }

    public void setCatId(Category catId) {
        this.catId = catId;
    }

    @JsonbTransient
    public Collection<Orderdetails> getOrderdetailsCollection() {
        return orderdetailsCollection;
    }

    public void setOrderdetailsCollection(Collection<Orderdetails> orderdetailsCollection) {
        this.orderdetailsCollection = orderdetailsCollection;
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
        hash += (prodId != null ? prodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productmaster)) {
            return false;
        }
        Productmaster other = (Productmaster) object;
        if ((this.prodId == null && other.prodId != null) || (this.prodId != null && !this.prodId.equals(other.prodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Productmaster[ prodId=" + prodId + " ]";
    }

}
