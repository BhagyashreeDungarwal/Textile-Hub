package entities;

import entities.Addressmaster;
import entities.Cart;
import entities.Getintouch;
import entities.Orderdetails;
import entities.Ordermaster;
import entities.Payment;
import entities.Rolemaster;
import entities.Testimonials;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-12-28T15:56:11")
@StaticMetamodel(Usermaster.class)
public class Usermaster_ { 

    public static volatile CollectionAttribute<Usermaster, Orderdetails> orderdetailsCollection;
    public static volatile SingularAttribute<Usermaster, String> gender;
    public static volatile SingularAttribute<Usermaster, Rolemaster> roleId;
    public static volatile CollectionAttribute<Usermaster, Getintouch> getintouchCollection;
    public static volatile CollectionAttribute<Usermaster, Testimonials> testimonialsCollection;
    public static volatile CollectionAttribute<Usermaster, Addressmaster> addressmasterCollection;
    public static volatile CollectionAttribute<Usermaster, Payment> paymentCollection;
    public static volatile CollectionAttribute<Usermaster, Cart> cartCollection;
    public static volatile SingularAttribute<Usermaster, String> password;
    public static volatile CollectionAttribute<Usermaster, Ordermaster> ordermasterCollection;
    public static volatile SingularAttribute<Usermaster, String> name;
    public static volatile SingularAttribute<Usermaster, String> userEmail;
    public static volatile SingularAttribute<Usermaster, String> contactNo;

}