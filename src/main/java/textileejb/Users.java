/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
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
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.glassfish.soteria.identitystores.hash.PasswordHashCompare;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author kewal dungarwal
 */
@Stateless
public class Users implements UsersLocal {

    Pbkdf2PasswordHashImpl pb;
    PasswordHashCompare pbc;
    @PersistenceContext(unitName = "TextileHubPu")
    EntityManager em;

    @Override
    public boolean insertuser(String userEmail, String name, String password, String contactNo, String gender) {
        try {
            if (userEmail == null || name == null || password == null || contactNo == null || gender == null) {
                throw new IllegalArgumentException("Please Enter all feild");
            } else {
                Usermaster user = new Usermaster();
                Rolemaster role = em.find(Rolemaster.class, 1);
                Collection<Usermaster> um = role.getUsermasterCollection();

                //HAshing Password
                pb = new Pbkdf2PasswordHashImpl();
                pbc = new PasswordHashCompare();

                String enc = pb.generate(password.toCharArray());
                user.setUserEmail(userEmail);
                user.setName(name);
                user.setPassword(enc);
                user.setContactNo(contactNo);
                user.setGender(gender);
                user.setRoleId(role);
                um.add(user);
                role.setUsermasterCollection(um);
                em.persist(user);
                em.merge(role);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteuser(String userEmail, Integer roleId) {
        Usermaster user = em.find(Usermaster.class, userEmail);
        Rolemaster role = em.find(Rolemaster.class, roleId);
        Collection<Usermaster> um = role.getUsermasterCollection();
        if (um.contains(user)) {
            em.remove(user);
        }
        return true;
    }

    @Override
    public boolean updateuser(String userEmail, String name, String password, String contactNo, String gender) {
        try {
            Usermaster user = em.find(Usermaster.class, userEmail);
            Rolemaster role = em.find(Rolemaster.class, 1);
            Collection<Usermaster> um = role.getUsermasterCollection();
            if (um.contains(user)) {
                user.setName(name);
                user.setPassword(password);
                user.setContactNo(contactNo);
                user.setGender(gender);
                Usermaster mergeuser = em.merge(user);
                if (mergeuser != null) {
                    System.out.println("Successfully merged");
                    return true;
                } else {
                    System.out.println("failure");
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Usermaster getuserbyid(String userEmail) {
        Usermaster user = em.find(Usermaster.class, userEmail);
        return user;
    }

    @Override
    public boolean inserttsml(String review, String ratting, Integer pid, String userEmail) {
        try {
            if (review == null || ratting == null || userEmail == null) {
                throw new IllegalArgumentException("Please Enter all feild");
            } else {
                Testimonials tsml = new Testimonials();
                Usermaster user = em.find(Usermaster.class, userEmail);
                Collection<Testimonials> tm = user.getTestimonialsCollection();
                Productmaster prod = em.find(Productmaster.class, pid);
                Collection<Testimonials> pm = prod.getTestimonialsCollection();
                tsml.setReview(review);
                tsml.setRatting(ratting);
                tsml.setUserEmail(user);
                tm.add(tsml);
                pm.add(tsml);
                user.setTestimonialsCollection(tm);
                prod.setTestimonialsCollection(tm);
                em.persist(tsml);
                em.merge(user);
                em.merge(prod);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Testimonials gettsmlbyid(Integer tid) {
        Testimonials tsml = em.find(Testimonials.class, tid);
        return tsml;
    }

    @Override
    public Rolemaster getrolebyid(Integer rid) {
        Rolemaster role = em.find(Rolemaster.class, rid);
        return role;
    }

    @Override
    public Collection<Productmaster> getallProductMasters() {
        Collection<Productmaster> prod = em.createNamedQuery("Productmaster.findAll").getResultList();
        return prod;
    }

    @Override
    public Productmaster getprodbyid(Integer pid) {
        Productmaster prod = em.find(Productmaster.class, pid);
        return prod;
    }

//    @Override
//    public boolean insertordermaster(String orderStatus, Integer meter, Integer totalAmt, String userEmail) {
//        try {
//            if (orderStatus == null || meter == null || totalAmt == null || userEmail == null) {
//                throw new IllegalArgumentException("Please Enter all feild");
//            } else {
//                if (meter <= 50) {
//                    throw new IllegalArgumentException("Meters should be more than 50");
//                }
//
//                Date orderDate1 = new Date();
////                Integer finaltotal = meter * totalAmt;
////                Integer gst = totalAmt * (tax / 100);
////                Integer grandtotal = totalAmt + gst;
////                Integer amt = meter * gst + totalAmt;
//                Ordermaster orderm = new Ordermaster();
//                Usermaster user = em.find(Usermaster.class, userEmail);
////                Productmaster prod = em.find(Productmaster.class, prodid);
//                Collection<Ordermaster> om = user.getOrdermasterCollection();
////                Collection<Ordermaster> op = prod.get
//
////                if (meter > prod.getMeters()) {
////                    throw new IllegalArgumentException("Entered meters exceed the available meter for this product");
////                }
//                orderm.setOrderDate(orderDate1);
//                orderm.setOrderStatus("Pending");
//                orderm.setMeter(meter);
//                orderm.setTotalAmt(totalAmt);
//                orderm.setUserEmail(user);
//                om.add(orderm);
//                user.setOrdermasterCollection(om);
//                em.persist(orderm);
//                em.merge(user);
//            }
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//    @Override
//    public boolean deleteordermaster(Integer omid, String userEmail) {
//        Ordermaster orderm = em.find(Ordermaster.class, omid);
//        Usermaster user = em.find(Usermaster.class, userEmail);
////        Productmaster prod = em.find(Productmaster.class, prodid);
////        Collection<Ordermaster> op = prod.getOrdermasterCollection();
//        Collection<Ordermaster> om = user.getOrdermasterCollection();
//        if (om.contains(orderm)) {
//            em.remove(orderm);
//        }
//        return true;
//    }
//    @Override
//    public boolean updateordermaster(Integer id, String orderStatus, Integer prodid, Integer meter, Integer tax, Integer totalAmt, String userEmail) {
//        try {
//            Ordermaster orderm = em.find(Ordermaster.class, id);
//            Usermaster user = em.find(Usermaster.class, userEmail);
//            Productmaster prod = em.find(Productmaster.class, prodid);
//            Collection<Ordermaster> op = prod.getOrdermasterCollection();
//            Collection<Ordermaster> om = user.getOrdermasterCollection();
//            if (op.contains(orderm) || om.contains(orderm)) {
//
//                orderm.setOrderStatus(orderStatus);
//                orderm.setMeter(meter);
//                orderm.setTax(tax);
//                orderm.setTotalAmt(totalAmt);
//                Ordermaster mergeom = em.merge(orderm);
//                if (mergeom != null) {
//                    System.out.println("Successfully merged");
//                    return true;
//                } else {
//                    System.out.println("failure");
//                    return false;
//                }
//            }
//            return true;
//        } catch (Exception e) {
//            System.out.println(e);
////            e.printStackTrace();
//            return false;
//        }
//    }
//    @Override
//    public boolean insertod(Integer prodPrice, String prodName, Integer tax, Integer meter, Integer prodId, String useremail, Integer ordermasterId) {
//
//        try {
//            if (prodPrice == null || ordermasterId == null || useremail == null || prodId == null) {
//                throw new IllegalArgumentException("Please enter all feild");
//            } else {
//                Orderdetails orderdt = new Orderdetails();
//                Ordermaster omaster = em.find(Ordermaster.class, ordermasterId);
//                Collection<Orderdetails> odm = omaster.getOrderdetailsCollection();
//                Productmaster prod = em.find(Productmaster.class, prodId);
//                Collection<Orderdetails> odprod = prod.getOrderdetailsCollection();
//                Usermaster user = em.find(Usermaster.class, useremail);
//                Collection<Orderdetails> oduser = user.getOrderdetailsCollection();
//
//                if (prod.getMeters() < meter) {
//                    throw new IllegalArgumentException("Insufficient stock");
//                }
//                orderdt.setProdPrice(prodPrice);
//                orderdt.setOrdermasterId(omaster);
//                orderdt.setProdId(prod);
//                odm.add(orderdt);
//                odprod.add(orderdt);
//                oduser.add(orderdt);
//                omaster.setOrderdetailsCollection(odm);
//                prod.setOrderdetailsCollection(odprod);
//                user.setOrderdetailsCollection(oduser);
//                em.persist(orderdt);
//                em.merge(omaster);
//                em.merge(prod);
//                em.merge(user);
//            }
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
    @Override
    public Orderdetails getorderdetailsbyid(Integer oid) {
        Orderdetails orderdet = em.find(Orderdetails.class, oid);
        return orderdet;
    }

    @Override
    public boolean insertgit(String userEmail, String name, String message) {
        try {
            if (userEmail == null || name == null || message == null) {
                throw new IllegalArgumentException("Please Enter all feild");
            } else {

                Getintouch geti = new Getintouch();
                Usermaster user = em.find(Usermaster.class, userEmail);
                Collection<Getintouch> gi = user.getGetintouchCollection();
                geti.setUserEmail(user);
                geti.setName(name);
                geti.setMessage(message);
                gi.add(geti);
                user.setGetintouchCollection(gi);
                em.persist(geti);
                em.merge(user);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Category getcatbyid(Integer cid) {
        Category cat = em.find(Category.class, cid);
        return cat;
    }

    @Override
    public boolean insertcart(Integer meters, String email, Integer amount, Integer productId) {
        try {
            if (meters == null || email == null || productId == null) {
                throw new IllegalArgumentException("Please Enter all feild");
            } else {
                if (meters <= 50) {
                    throw new IllegalArgumentException("Meters should be more than 50");
                }
                Cart cart = new Cart();
                Usermaster user = em.find(Usermaster.class, email);
                Productmaster prod = em.find(Productmaster.class, productId);
                Collection<Cart> ucart = user.getCartCollection();
                Collection<Cart> cprod = prod.getCartCollection();

                if (meters > prod.getMeters()) {
                    throw new IllegalArgumentException("Entered meters exceed the available meter for this product");
                }

                cart.setMeters(meters);
                cart.setProdId(prod);
                cart.setUseremail(user);
                cart.setAmount(amount);
                ucart.add(cart);
                cprod.add(cart);
                user.setCartCollection(ucart);
                prod.setCartCollection(cprod);
                em.persist(cart);
                em.merge(user);
                em.merge(prod);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletecart(Integer cartid, String email, Integer productId) {
        Cart cart = em.find(Cart.class, cartid);
        Usermaster user = em.find(Usermaster.class, email);
        Productmaster prod = em.find(Productmaster.class, productId);
        Collection<Cart> ucart = user.getCartCollection();
        Collection<Cart> cprod = prod.getCartCollection();
        if (ucart.contains(cart) || cprod.contains(cart)) {
            em.remove(cart);
        }
        return true;
    }

    @Override
    public boolean updatecart(Integer cartid, Integer meters, String email, Integer amount, Integer productId) {
        try {
            if (meters <= 50) {
                throw new IllegalArgumentException("Meters should be more than 50");
            }
            Cart cart = em.find(Cart.class, cartid);
            Usermaster user = em.find(Usermaster.class, email);
            Productmaster prod = em.find(Productmaster.class, productId);
            Collection<Cart> ucart = user.getCartCollection();
            Collection<Cart> cprod = prod.getCartCollection();

            if (meters > prod.getMeters()) {
                throw new IllegalArgumentException("Entered meters exceed the available meter for this product");
            }
            if (ucart.contains(cart) || cprod.contains(cart)) {
                cart.setMeters(meters);
                cart.setProdId(prod);
                cart.setUseremail(user);
                cart.setAmount(amount);

                Cart mergect = em.merge(cart);
                if (mergect != null) {
                    System.out.println("Updation Successfully!!");
                    return true;
                } else {
                    System.out.println("Updation fail!!");
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Cart getcartbyId(Integer ctid) {
        Cart cart = em.find(Cart.class, ctid);
        return cart;
    }

    @Override
    public boolean insertadd(String address, String contactNo, String altAddress, String city, String state, String userEmail) {
        try {
            if (address == null || contactNo == null || altAddress == null || city == null || state == null || userEmail == null) {
                throw new IllegalArgumentException("Please enter all feild");
            } else {

                Addressmaster addressm = new Addressmaster();
                Usermaster user = em.find(Usermaster.class, userEmail);
                Collection<Addressmaster> ad = user.getAddressmasterCollection();
                addressm.setAddress(address);
                addressm.setContactNo(contactNo);
                addressm.setAltAddress(altAddress);
                addressm.setCity(city);
                addressm.setState(state);
                addressm.setUserEmail(user);
                ad.add(addressm);
                user.setAddressmasterCollection(ad);
                em.persist(addressm);
                em.merge(user);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteadd(Integer id, String userEmail) {
        Addressmaster addressm = em.find(Addressmaster.class, id);
        Usermaster user = em.find(Usermaster.class, userEmail);
        Collection<Addressmaster> ad = user.getAddressmasterCollection();
        if (ad.contains(addressm)) {
            em.remove(addressm);
        }
        return true;
    }

    @Override
    public boolean updateadd(Integer id, String address, String contactNo, String altAddress, String city, String state, String userEmail) {
        try {
            Addressmaster addressm = em.find(Addressmaster.class, id);
            Usermaster user = em.find(Usermaster.class, userEmail);
            Collection<Addressmaster> ad = user.getAddressmasterCollection();
            if (ad.contains(addressm)) {
                addressm.setAddress(address);
                addressm.setContactNo(contactNo);
                addressm.setAltAddress(altAddress);
                addressm.setCity(city);
                addressm.setState(state);
                Addressmaster mergeAd = em.merge(addressm);
                if (mergeAd != null) {
                    System.out.println("Successfully merged");
                    return true;
                } else {
                    System.out.println("failure");
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
//            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Addressmaster getaddbyid(Integer aid) {
        Addressmaster addressm = em.find(Addressmaster.class, aid);
        return addressm;
    }

    @Override
    public Collection<Payment> getPayByUser(String useremail) {
        try {
            TypedQuery<Payment> query = em.createQuery(
                    "SELECT p FROM Payment p WHERE p.useremail.userEmail = :userEmail", Payment.class);
            query.setParameter("userEmail", useremail);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your application's requirements
            return null;
        }
    }

    @Override
    public boolean insertpay(String mode, Integer upiId, Integer orderdId, String useremail, Integer amount) {
        try {
            if (mode == null || upiId == null || orderdId == null || useremail == null || amount == null) {
                throw new IllegalArgumentException("Please enter all feild");
            } else {
                Payment pay = new Payment();
                Usermaster user = em.find(Usermaster.class, useremail);
                Orderdetails orderdet = em.find(Orderdetails.class, orderdId);
                Collection<Payment> ods = orderdet.getPaymentCollection();
                Collection<Payment> upay = user.getPaymentCollection();
                pay.setMode(mode);
                pay.setUpiId(upiId);
                pay.setOrderdId(orderdet);
                pay.setUseremail(user);
                pay.setAmount(amount);
                ods.add(pay);
                upay.add(pay);
                user.setPaymentCollection(upay);
                orderdet.setPaymentCollection(ods);
                em.persist(pay);
                em.merge(user);
                em.merge(orderdet);

            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addProductToCart(String useremail, Integer prodid, Integer meter) {
        try {
            Productmaster product = em.find(Productmaster.class, prodid);
            Usermaster user = em.find(Usermaster.class, useremail);

            if (product != null && product.getMeters() >= meter && user != null) {
                Cart cart = new Cart();
                cart.setProdId(product);
                cart.setUseremail(user);
                cart.setMeters(meter);
                cart.setAmount((int) (meter * product.getPrice()));
                em.persist(cart);

            } else {
                System.err.println("Eather Email,Productid or Quantity is null");
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeProductFromCart(String useremail, Integer prodId) {
        try {
            Productmaster product = em.find(Productmaster.class, prodId);
            Usermaster user = em.find(Usermaster.class, useremail);

            if (user == null) {
                throw new IllegalArgumentException("User Not Found!!!");
            } else {
                TypedQuery<Cart> query = em.createQuery(
                        "SELECT c FROM Cart c WHERE c.useremail = :user AND c.prodId = :prodId", Cart.class);
                query.setParameter("user", user);
                query.setParameter("prodId", product);

                List<Cart> carts = query.getResultList();

                if (!carts.isEmpty()) {
                    Cart productInCart = carts.get(0);
                    em.remove(productInCart);
                    System.out.println("Product removed from the user's cart.");
                } else {
                    System.out.println("Product not found in the user's cart.");
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Collection<Cart> viewCart(String useremail) {
        try {
            if (useremail == null) {
                throw new IllegalArgumentException("Invalid Email!!!");
            }
            Usermaster user = (Usermaster) em.find(Usermaster.class, useremail);
            if (user == null) {
                throw new IllegalArgumentException("Usermaster with email " + useremail + " not found!");
            }

            TypedQuery<Cart> query = em.createQuery("SELECT c FROM Cart c WHERE c.useremail = :user", Cart.class);
            query.setParameter("user", user);
            Collection<Cart> result = query.getResultList();

            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean placeOrder(String useremail) {
        try {
            Usermaster user = (Usermaster) em.find(Usermaster.class, useremail);
            TypedQuery<Cart> query = em.createQuery("SELECT c FROM Cart c WHERE c.useremail = :user", Cart.class);
            query.setParameter("user", user);
            Collection<Cart> cartItems = query.getResultList();
            double totalAmount = 0;
            System.out.println("after get carts");

            if (!cartItems.isEmpty()) {

                Ordermaster order = new Ordermaster();
                order.setUserEmail(user);
                order.setOrderDate(new Date());
                order.setOrderStatus("Pending");

                for (Cart cartItem : cartItems) {
                    Productmaster product = em.find(Productmaster.class, cartItem.getProdId().getProdId());
                    System.out.println(cartItem.getAmount());
                    if (product != null) {
                        double productTotal = cartItem.getAmount() * cartItem.getMeters();
                        int stock = product.getMeters() - cartItem.getMeters();
                        product.setMeters(stock);
                        Orderdetails orderDetails = new Orderdetails();
                        orderDetails.setUseremail(user);
                        orderDetails.setProdId(product);
                        orderDetails.setProdName(cartItem.getProdId().getName());
                        orderDetails.setMeter(cartItem.getMeters());
                        orderDetails.setProdPrice(productTotal);

                        // Calculate tax and gst amounts for the current product
                        double tax_rate = product.getTax() / 100;
                        double taxAmount = productTotal * tax_rate;
                        orderDetails.setTax(taxAmount);

                        // Update the totalAmount with tax and gst for each product
                        totalAmount += productTotal + taxAmount;
                        System.out.println(totalAmount);
                        orderDetails.setOrdermasterId(order);
                        removeProductFromCart(user.getUserEmail(), product.getProdId());

                        em.persist(orderDetails);
                        em.merge(product);
                    } else {
                        System.out.println("Product null");
                    }
                }
                order.setTotalAmt(totalAmount);
                em.persist(order);
            } else {
                System.out.println("Cart is getting Null!!!");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Collection<Productmaster> getprodbyCat(Integer cid) {
        Category cat = em.find(Category.class, cid);
        Collection<Productmaster> prod = cat.getProductmasterCollection();
        return prod;
    }

    @Override
    public Collection<Testimonials> gettstbyPro(Integer prodid) {
        Productmaster prod = em.find(Productmaster.class, prodid);
        Collection<Testimonials> tst = prod.getTestimonialsCollection();
        return tst;
    }

    @Override
    public Collection<Orderdetails> getorderbyuser(String email) {
     Usermaster u = em.find(Usermaster.class, email);
     Collection<Orderdetails> o = u.getOrderdetailsCollection();
     return o;
    }

}
