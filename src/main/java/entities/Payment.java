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
@Table(name = "payment")
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findByPayId", query = "SELECT p FROM Payment p WHERE p.payId = :payId"),
    @NamedQuery(name = "Payment.findByMode", query = "SELECT p FROM Payment p WHERE p.mode = :mode"),
    @NamedQuery(name = "Payment.findByUpiId", query = "SELECT p FROM Payment p WHERE p.upiId = :upiId"),
    @NamedQuery(name = "Payment.findByAmount", query = "SELECT p FROM Payment p WHERE p.amount = :amount")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "payId")
    private Integer payId;
    @Size(max = 250)
    @Column(name = "mode")
    private String mode;
    @Column(name = "upiId")
    private Integer upiId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private double amount;
    @JoinColumn(name = "orderdId", referencedColumnName = "odId")
    @ManyToOne(optional = false)
    private Orderdetails orderdId;
    @JoinColumn(name = "useremail", referencedColumnName = "user_email")
    @ManyToOne(optional = false)
    private Usermaster useremail;

    public Payment() {
    }

    public Payment(Integer payId) {
        this.payId = payId;
    }

    public Payment(Integer payId, double amount) {
        this.payId = payId;
        this.amount = amount;
    }

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Integer getUpiId() {
        return upiId;
    }

    public void setUpiId(Integer upiId) {
        this.upiId = upiId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Orderdetails getOrderdId() {
        return orderdId;
    }

    public void setOrderdId(Orderdetails orderdId) {
        this.orderdId = orderdId;
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
        hash += (payId != null ? payId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.payId == null && other.payId != null) || (this.payId != null && !this.payId.equals(other.payId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Payment[ payId=" + payId + " ]";
    }
    
}
