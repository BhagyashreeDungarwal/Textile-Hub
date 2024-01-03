package entities;

import entities.Orderdetails;
import entities.Usermaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-12-28T15:56:11")
@StaticMetamodel(Payment.class)
public class Payment_ { 

    public static volatile SingularAttribute<Payment, String> mode;
    public static volatile SingularAttribute<Payment, Double> amount;
    public static volatile SingularAttribute<Payment, Orderdetails> orderdId;
    public static volatile SingularAttribute<Payment, Integer> payId;
    public static volatile SingularAttribute<Payment, Integer> upiId;
    public static volatile SingularAttribute<Payment, Usermaster> useremail;

}