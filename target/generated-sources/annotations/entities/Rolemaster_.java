package entities;

import entities.Usermaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-12-28T15:56:11")
@StaticMetamodel(Rolemaster.class)
public class Rolemaster_ { 

    public static volatile SingularAttribute<Rolemaster, String> role;
    public static volatile CollectionAttribute<Rolemaster, Usermaster> usermasterCollection;
    public static volatile SingularAttribute<Rolemaster, Integer> roleId;

}