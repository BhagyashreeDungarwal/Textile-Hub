package entities;

import entities.Ordermaster;
import entities.Payment;
import entities.Productmaster;
import entities.Usermaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-12-28T15:56:11")
@StaticMetamodel(Orderdetails.class)
public class Orderdetails_ { 

    public static volatile SingularAttribute<Orderdetails, Integer> odId;
    public static volatile SingularAttribute<Orderdetails, Integer> meter;
    public static volatile SingularAttribute<Orderdetails, String> prodName;
    public static volatile SingularAttribute<Orderdetails, Double> prodPrice;
    public static volatile SingularAttribute<Orderdetails, Double> tax;
    public static volatile SingularAttribute<Orderdetails, Productmaster> prodId;
    public static volatile SingularAttribute<Orderdetails, Ordermaster> ordermasterId;
    public static volatile CollectionAttribute<Orderdetails, Payment> paymentCollection;
    public static volatile SingularAttribute<Orderdetails, Usermaster> useremail;

}