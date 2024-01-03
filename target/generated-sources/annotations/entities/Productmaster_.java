package entities;

import entities.Cart;
import entities.Category;
import entities.Orderdetails;
import entities.Testimonials;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-12-28T15:56:11")
@StaticMetamodel(Productmaster.class)
public class Productmaster_ { 

    public static volatile CollectionAttribute<Productmaster, Cart> cartCollection;
    public static volatile SingularAttribute<Productmaster, String> image;
    public static volatile SingularAttribute<Productmaster, Category> catId;
    public static volatile CollectionAttribute<Productmaster, Orderdetails> orderdetailsCollection;
    public static volatile SingularAttribute<Productmaster, Double> price;
    public static volatile SingularAttribute<Productmaster, String> name;
    public static volatile SingularAttribute<Productmaster, String> description;
    public static volatile CollectionAttribute<Productmaster, Testimonials> testimonialsCollection;
    public static volatile SingularAttribute<Productmaster, Double> tax;
    public static volatile SingularAttribute<Productmaster, Integer> prodId;
    public static volatile SingularAttribute<Productmaster, String> colors;
    public static volatile SingularAttribute<Productmaster, Integer> meters;

}