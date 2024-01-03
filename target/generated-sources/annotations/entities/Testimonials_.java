package entities;

import entities.Productmaster;
import entities.Usermaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-12-28T15:56:11")
@StaticMetamodel(Testimonials.class)
public class Testimonials_ { 

    public static volatile SingularAttribute<Testimonials, String> review;
    public static volatile SingularAttribute<Testimonials, String> ratting;
    public static volatile SingularAttribute<Testimonials, Productmaster> proId;
    public static volatile SingularAttribute<Testimonials, Integer> tstId;
    public static volatile SingularAttribute<Testimonials, Usermaster> userEmail;

}