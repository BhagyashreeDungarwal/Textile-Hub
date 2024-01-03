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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.glassfish.soteria.identitystores.hash.PasswordHashCompare;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

@Stateless
public class Admin implements AdminLocal {
    
    Pbkdf2PasswordHashImpl pb;
    PasswordHashCompare pbc;
    @PersistenceContext(unitName = "TextileHubPu")
    EntityManager em;
    
    @Override
    public Collection<Rolemaster> getRole() {
        Collection<Rolemaster> rolem = em.createNamedQuery("Rolemaster.findAll").getResultList();
        return rolem;
    }
    
    @Override
    public Rolemaster getrolebyid(Integer rid) {
        Rolemaster role = em.find(Rolemaster.class, rid);
        return role;
    }
    
    @Override
    public boolean insertcat(String name, String type) {
        try {
            if (name == null || type == null) {
                throw new IllegalArgumentException("Please Enter all feild");
            } else {
                
                Category cat = new Category();
                cat.setName(name);
                cat.setType(type);
                em.persist(cat);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean deletecat(Integer id) {
        Category cat = em.find(Category.class, id);
        em.remove(cat);
        return true;
    }
    
    @Override
    public boolean updatecat(Integer id, String name, String type) {
        try {
            Category cat = em.find(Category.class, id);
            cat.setName(name);
            cat.setType(type);
            Category mergeCat = em.merge(cat);
            if (mergeCat != null) {
                System.out.println("Successfully merged");
                return true;
            } else {
                System.out.println("failure");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    @Override
    public Collection<Category> getallCategory() {
        Collection<Category> cat = em.createNamedQuery("Category.findAll").getResultList();
        return cat;
    }
    
    @Override
    public Category getcatbyid(Integer cid) {
        Category cat = em.find(Category.class, cid);
        return cat;
    }
    
    @Override
    public boolean insertpro(Integer catId, String name, String description, String image, String colors, Integer meters, double price) {
        try {
            if (catId == null || name == null || description == null || image == null || colors == null || meters == null) {
                throw new IllegalArgumentException("Please Enter all feild");
            } else {
                Productmaster prod = new Productmaster();
                Category cat = em.find(Category.class, catId);
                Collection<Productmaster> pm = cat.getProductmasterCollection();
                prod.setName(name);
                prod.setCatId(cat);
                prod.setDescription(description);
                prod.setImage(image);
                prod.setTax(12);
                prod.setColors(colors);
                prod.setMeters(meters);
                prod.setPrice(price);
                pm.add(prod);
                cat.setProductmasterCollection(pm);
                em.persist(prod);
                em.merge(cat);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean deletepro(Integer id) {
        Productmaster prod = em.find(Productmaster.class, id);
        
        em.remove(prod);
        System.out.println("from ejb");
        return true;
    }
    
    @Override
    public boolean updatepro(Integer id, String name, Integer catId, String description, String image, String colors, Integer meters, double price) {
        try {
            Productmaster prod = em.find(Productmaster.class, id);
            
            prod.setName(name);
            prod.setDescription(description);
            prod.setImage(image);
            prod.setCatId(em.find(Category.class, catId));
            prod.setColors(colors);
            prod.setMeters(meters);
            prod.setPrice(price);
            Productmaster mergeprod = em.merge(prod);
            if (mergeprod != null) {
                System.out.println("Successfully merged");
                return true;
            } else {
                System.out.println("failure");
                return false;
            }
            
        } catch (Exception e) {
            System.out.println(e);
//            e.printStackTrace();
            return false;
        }
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
    
    @Override
    public Collection<Addressmaster> gettaddress() {
        Collection<Addressmaster> addressm = em.createNamedQuery("Addressmaster.findAll").getResultList();
        return addressm;
    }
    
    @Override
    public Addressmaster getaddbyid(Integer aid) {
        Addressmaster addressm = em.find(Addressmaster.class, aid);
        return addressm;
    }
    
    @Override
    public Collection<Cart> getcartlist() {
        Collection<Cart> cart = em.createNamedQuery("Cart.findAll").getResultList();
        return cart;
    }
    
    @Override
    public Cart getcartbyId(Integer ctid) {
        Cart cart = em.find(Cart.class, ctid);
        return cart;
    }
    
    @Override
    public Collection<Getintouch> getgit() {
        Collection<Getintouch> geti = em.createNamedQuery("Getintouch.findAll").getResultList();
        return geti;
    }
    
    @Override
    public Getintouch gitid(Integer gitid) {
        Getintouch geti = em.find(Getintouch.class, gitid);
        return geti;
    }
    
    @Override
    public Orderdetails getorderbyid(Integer oid) {
        Orderdetails orderdetails = em.find(Orderdetails.class, oid);
        return orderdetails;
    }
    
    @Override
    public Collection<Orderdetails> getorderdetails() {
        Collection<Orderdetails> orderdetail = em.createNamedQuery("Orderdetails.findAll").getResultList();
        return orderdetail;
    }
    
    @Override
    public Collection<Ordermaster> getOrdermaster() {
        Collection<Ordermaster> orderm = em.createNamedQuery("Ordermaster.findAll").getResultList();
        return orderm;
    }
    
    @Override
    public Ordermaster getordermbyid(Integer omid) {
        Ordermaster orderm = em.find(Ordermaster.class, omid);
        return orderm;
    }
    
    @Override
    public Collection<Testimonials> gettsml() {
        Collection<Testimonials> tsml = em.createNamedQuery("Testimonials.findAll").getResultList();
        return tsml;
    }
    
    @Override
    public Testimonials gettsmlbyid(Integer tid) {
        Testimonials tsml = em.find(Testimonials.class, tid);
        return tsml;
    }
    
    @Override
    public Collection<Usermaster> getUser() {
        Collection<Usermaster> user = em.createNamedQuery("Usermaster.findAll").getResultList();
        return user;
    }
    
    @Override
    public Usermaster getuserbyid(String userEmail) {
        Usermaster user = em.find(Usermaster.class, userEmail);
        return user;
    }
    
    @Override
    public Collection<Payment> getpayment() {
        Collection<Payment> pay = em.createNamedQuery("Payment.findAll").getResultList();
        return pay;
    }
    
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
    
}
