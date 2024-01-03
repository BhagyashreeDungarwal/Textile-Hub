/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kewal dungarwal
 */
@Entity
@Table(name = "ordermaster")
@NamedQueries({
    @NamedQuery(name = "Ordermaster.findAll", query = "SELECT o FROM Ordermaster o"),
    @NamedQuery(name = "Ordermaster.findByOmId", query = "SELECT o FROM Ordermaster o WHERE o.omId = :omId"),
    @NamedQuery(name = "Ordermaster.findByOrderDate", query = "SELECT o FROM Ordermaster o WHERE o.orderDate = :orderDate"),
    @NamedQuery(name = "Ordermaster.findByOrderStatus", query = "SELECT o FROM Ordermaster o WHERE o.orderStatus = :orderStatus"),
    @NamedQuery(name = "Ordermaster.findByTotalAmt", query = "SELECT o FROM Ordermaster o WHERE o.totalAmt = :totalAmt")})
public class Ordermaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "omId")
    private Integer omId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Size(max = 250)
    @Column(name = "order_status")
    private String orderStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_Amt")
    private double totalAmt;
    @JoinColumn(name = "user_email", referencedColumnName = "user_email")
    @ManyToOne(optional = false)
    private Usermaster userEmail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordermasterId")
    private Collection<Orderdetails> orderdetailsCollection;

    public Ordermaster() {
    }

    public Ordermaster(Integer omId) {
        this.omId = omId;
    }

    public Ordermaster(Integer omId, Date orderDate, double totalAmt) {
        this.omId = omId;
        this.orderDate = orderDate;
        this.totalAmt = totalAmt;
    }

    public Integer getOmId() {
        return omId;
    }

    public void setOmId(Integer omId) {
        this.omId = omId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(double totalAmt) {
        this.totalAmt = totalAmt;
    }

    public Usermaster getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(Usermaster userEmail) {
        this.userEmail = userEmail;
    }

    @JsonbTransient
    public Collection<Orderdetails> getOrderdetailsCollection() {
        return orderdetailsCollection;
    }

    public void setOrderdetailsCollection(Collection<Orderdetails> orderdetailsCollection) {
        this.orderdetailsCollection = orderdetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (omId != null ? omId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordermaster)) {
            return false;
        }
        Ordermaster other = (Ordermaster) object;
        if ((this.omId == null && other.omId != null) || (this.omId != null && !this.omId.equals(other.omId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ordermaster[ omId=" + omId + " ]";
    }

}
