package entities;

import entities.Usermaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-12-28T15:56:11")
@StaticMetamodel(Addressmaster.class)
public class Addressmaster_ { 

    public static volatile SingularAttribute<Addressmaster, String> altAddress;
    public static volatile SingularAttribute<Addressmaster, String> address;
    public static volatile SingularAttribute<Addressmaster, String> city;
    public static volatile SingularAttribute<Addressmaster, Integer> addId;
    public static volatile SingularAttribute<Addressmaster, Usermaster> userEmail;
    public static volatile SingularAttribute<Addressmaster, String> state;
    public static volatile SingularAttribute<Addressmaster, String> contactNo;

}