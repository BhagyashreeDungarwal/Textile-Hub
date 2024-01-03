package entities;

import entities.Orderdetails;
import entities.Usermaster;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-12-28T15:56:11")
@StaticMetamodel(Ordermaster.class)
public class Ordermaster_ { 

    public static volatile CollectionAttribute<Ordermaster, Orderdetails> orderdetailsCollection;
    public static volatile SingularAttribute<Ordermaster, Double> totalAmt;
    public static volatile SingularAttribute<Ordermaster, String> orderStatus;
    public static volatile SingularAttribute<Ordermaster, Usermaster> userEmail;
    public static volatile SingularAttribute<Ordermaster, Integer> omId;
    public static volatile SingularAttribute<Ordermaster, Date> orderDate;

}