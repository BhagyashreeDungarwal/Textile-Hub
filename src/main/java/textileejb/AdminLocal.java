/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package textileejb;

import entities.Addressmaster;
import entities.Cart;
import entities.Category;
import entities.Getintouch;
import entities.Orderdetails;
import entities.Ordermaster;
import entities.Payment;
import entities.Productmaster;
import entities.Rolemaster;
import entities.Testimonials;
import entities.Usermaster;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author kewal dungarwal
 */
@Local
public interface AdminLocal {

    Collection<Rolemaster> getRole();

    Rolemaster getrolebyid(Integer rid);

    boolean insertcat(String name, String type);

    boolean deletecat(Integer id);

    boolean updatecat(Integer id, String name, String type);

    Collection<Category> getallCategory();

    Category getcatbyid(Integer cid);

    boolean insertpro(Integer catId, String name, String description, String image, String colors, Integer meters, double price);

    boolean deletepro(Integer id);

    boolean updatepro(Integer id, String name, Integer catId, String description, String image, String colors, Integer meters, double price);

    Collection<Productmaster> getallProductMasters();

    Productmaster getprodbyid(Integer pid);

    Collection<Addressmaster> gettaddress();

    Addressmaster getaddbyid(Integer aid);

    Collection<Cart> getcartlist();

    Cart getcartbyId(Integer ctid);

    Collection<Getintouch> getgit();

    Getintouch gitid(Integer gitid);

    Orderdetails getorderbyid(Integer oid);

    Collection<Orderdetails> getorderdetails();

//    boolean updateordermaster(Integer id, Integer prodid, String orderStatus, Integer tax, Integer totalAmt, String userEmail);

    Collection<Ordermaster> getOrdermaster();

    Ordermaster getordermbyid(Integer omid);

    Collection<Testimonials> gettsml();

    Testimonials gettsmlbyid(Integer tid);

    Collection<Usermaster> getUser();

    Usermaster getuserbyid(String userEmail);

    Collection<Payment> getpayment();
    
     boolean insertuser(String userEmail, String name, String password, String contactNo, String gender);

}
