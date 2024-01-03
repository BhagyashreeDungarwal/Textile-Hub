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
@Table(name = "orderdetails")
@NamedQueries({
    @NamedQuery(name = "Orderdetails.findAll", query = "SELECT o FROM Orderdetails o"),
    @NamedQuery(name = "Orderdetails.findByOdId", query = "SELECT o FROM Orderdetails o WHERE o.odId = :odId"),
    @NamedQuery(name = "Orderdetails.findByProdPrice", query = "SELECT o FROM Orderdetails o WHERE o.prodPrice = :prodPrice"),
    @NamedQuery(name = "Orderdetails.findByProdName", query = "SELECT o FROM Orderdetails o WHERE o.prodName = :prodName"),
    @NamedQuery(name = "Orderdetails.findByTax", query = "SELECT o FROM Orderdetails o WHERE o.tax = :tax"),
    @NamedQuery(name = "Orderdetails.findByMeter", query = "SELECT o FROM Orderdetails o WHERE o.meter = :meter")})
public class Orderdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "odId")
    private Integer odId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProdPrice")
    private double prodPrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ProdName")
    private String prodName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tax")
    private double tax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "meter")
    private int meter;
    @JoinColumn(name = "useremail", referencedColumnName = "user_email")
    @ManyToOne(optional = false)
    private Usermaster useremail;
    @JoinColumn(name = "prodId", referencedColumnName = "prodId")
    @ManyToOne(optional = false)
    private Productmaster prodId;
    @JoinColumn(name = "ordermasterId", referencedColumnName = "omId")
    @ManyToOne(optional = false)
    private Ordermaster ordermasterId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderdId")
    private Collection<Payment> paymentCollection;

    public Orderdetails() {
    }

    public Orderdetails(Integer odId) {
        this.odId = odId;
    }

    public Orderdetails(Integer odId, double prodPrice, String prodName, double tax, int meter) {
        this.odId = odId;
        this.prodPrice = prodPrice;
        this.prodName = prodName;
        this.tax = tax;
        this.meter = meter;
    }

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public int getMeter() {
        return meter;
    }

    public void setMeter(int meter) {
        this.meter = meter;
    }

    public Usermaster getUseremail() {
        return useremail;
    }

    public void setUseremail(Usermaster useremail) {
        this.useremail = useremail;
    }

    public Productmaster getProdId() {
        return prodId;
    }

    public void setProdId(Productmaster prodId) {
        this.prodId = prodId;
    }

    public Ordermaster getOrdermasterId() {
        return ordermasterId;
    }

    public void setOrdermasterId(Ordermaster ordermasterId) {
        this.ordermasterId = ordermasterId;
    }

    @JsonbTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (odId != null ? odId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderdetails)) {
            return false;
        }
        Orderdetails other = (Orderdetails) object;
        if ((this.odId == null && other.odId != null) || (this.odId != null && !this.odId.equals(other.odId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Orderdetails[ odId=" + odId + " ]";
    }

}
