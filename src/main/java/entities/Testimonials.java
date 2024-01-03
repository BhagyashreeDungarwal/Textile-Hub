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
@Table(name = "testimonials")
@NamedQueries({
    @NamedQuery(name = "Testimonials.findAll", query = "SELECT t FROM Testimonials t"),
    @NamedQuery(name = "Testimonials.findByTstId", query = "SELECT t FROM Testimonials t WHERE t.tstId = :tstId"),
    @NamedQuery(name = "Testimonials.findByReview", query = "SELECT t FROM Testimonials t WHERE t.review = :review"),
    @NamedQuery(name = "Testimonials.findByRatting", query = "SELECT t FROM Testimonials t WHERE t.ratting = :ratting")})
public class Testimonials implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tstId")
    private Integer tstId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "review")
    private String review;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ratting")
    private String ratting;
    @JoinColumn(name = "user_email", referencedColumnName = "user_email")
    @ManyToOne(optional = false)
    private Usermaster userEmail;
    @JoinColumn(name = "proId", referencedColumnName = "prodId")
    @ManyToOne(optional = false)
    private Productmaster proId;

    public Testimonials() {
    }

    public Testimonials(Integer tstId) {
        this.tstId = tstId;
    }

    public Testimonials(Integer tstId, String review, String ratting) {
        this.tstId = tstId;
        this.review = review;
        this.ratting = ratting;
    }

    public Integer getTstId() {
        return tstId;
    }

    public void setTstId(Integer tstId) {
        this.tstId = tstId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getRatting() {
        return ratting;
    }

    public void setRatting(String ratting) {
        this.ratting = ratting;
    }

    public Usermaster getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(Usermaster userEmail) {
        this.userEmail = userEmail;
    }

    public Productmaster getProId() {
        return proId;
    }

    public void setProId(Productmaster proId) {
        this.proId = proId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tstId != null ? tstId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Testimonials)) {
            return false;
        }
        Testimonials other = (Testimonials) object;
        if ((this.tstId == null && other.tstId != null) || (this.tstId != null && !this.tstId.equals(other.tstId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Testimonials[ tstId=" + tstId + " ]";
    }
    
}
