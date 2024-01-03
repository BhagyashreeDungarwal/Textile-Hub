package entities;

import entities.Productmaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-12-28T15:56:11")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, Integer> catId;
    public static volatile SingularAttribute<Category, String> name;
    public static volatile SingularAttribute<Category, String> type;
    public static volatile CollectionAttribute<Category, Productmaster> productmasterCollection;

}