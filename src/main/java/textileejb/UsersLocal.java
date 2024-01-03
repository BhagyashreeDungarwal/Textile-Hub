/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package textileejb;

import entities.Addressmaster;
import entities.Cart;
import entities.Category;
import entities.Orderdetails;
import entities.Payment;
import entities.Productmaster;
import entities.Rolemaster;
import entities.Testimonials;
import entities.Usermaster;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author kewal dungarwal
 */
@Local
public interface UsersLocal {

    boolean insertuser(String userEmail, String name, String password, String contactNo, String gender);

    boolean deleteuser(String userEmail, Integer roleId);

    boolean updateuser(String userEmail, String name, String password, String contactNo, String gender);

    Usermaster getuserbyid(String userEmail);

    boolean inserttsml(String review, String ratting,Integer pid ,String userEmail);

    Testimonials gettsmlbyid(Integer tid);
    
    Collection<Testimonials> gettstbyPro(Integer prodid);

    Rolemaster getrolebyid(Integer rid);

    Collection<Productmaster> getallProductMasters();

    Collection<Productmaster> getprodbyCat(Integer cid);

    Productmaster getprodbyid(Integer pid);
    
    Collection<Orderdetails> getorderbyuser(String email);

    Orderdetails getorderdetailsbyid(Integer odid);

    boolean insertgit(String userEmail, String name, String message);

    Category getcatbyid(Integer cid);

    boolean insertcart(Integer meters, String email, Integer amount, Integer productId);

    boolean deletecart(Integer cartid, String email, Integer productId);

    boolean updatecart(Integer cartid, Integer meters, String email, Integer amount, Integer productId);

    Cart getcartbyId(Integer ctid);

    boolean insertadd(String address, String contactNo, String altAddress, String city, String state, String userEmail);

    boolean deleteadd(Integer id, String userEmail);

    boolean updateadd(Integer id, String address, String contactNo, String altAddress, String city, String state, String userEmail);

    Addressmaster getaddbyid(Integer aid);

    Collection<Payment> getPayByUser(String useremail);

    boolean insertpay(String mode, Integer upiId, Integer orderdId, String useremail, Integer amount);

    boolean addProductToCart(String useremail, Integer prodid, Integer meter);

    boolean removeProductFromCart(String useremail, Integer prodid);

    Collection<Cart> viewCart(String useremail);

    boolean placeOrder(String useremail);

}
