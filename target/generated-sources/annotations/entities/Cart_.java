package entities;

import entities.Productmaster;
import entities.Usermaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-12-28T15:56:11")
@StaticMetamodel(Cart.class)
public class Cart_ { 

    public static volatile SingularAttribute<Cart, Integer> amount;
    public static volatile SingularAttribute<Cart, Integer> cartId;
    public static volatile SingularAttribute<Cart, Productmaster> prodId;
    public static volatile SingularAttribute<Cart, Integer> meters;
    public static volatile SingularAttribute<Cart, Usermaster> useremail;

}