/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CDIBean;

import Client.UserClient;
import entities.Addressmaster;
import entities.Cart;
import entities.Category;
import entities.Getintouch;
import entities.Orderdetails;
import entities.Ordermaster;
import entities.Productmaster;
import entities.Testimonials;
import entities.Usermaster;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.ws.rs.RedirectionException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

@Named(value = "userCDI")
@SessionScoped
//@RequestScoped
public class UserCDI implements Serializable {

    Response rs;
    UserClient uc;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession session = (HttpSession) externalContext.getSession(false);
    String Email = (String) session.getAttribute("User");
    //User
    Usermaster user = new Usermaster();
    Collection<Usermaster> usermaster;
    GenericType<Collection<Usermaster>> guser;
    private String name, user_email, password, gender, contact;
    private Integer roleid;

    //Category
    Collection<Category> category;
    GenericType<Collection<Category>> gcat;
    Category cat = new Category();
    //Product

    Productmaster prod = new Productmaster();
    Collection<Productmaster> product;
    GenericType<Collection<Productmaster>> gprod;
    private String catid, prodId, prodname, description, image, colors;
    private Integer meters;
    private Integer proId;
    private double tax, price, totalprice;

    //Cart
    Cart ct = new Cart();
    Collection<Cart> cart;
    GenericType<Collection<Cart>> gcart;
    private String sprodId;

    //Ordermaster
    Ordermaster om = new Ordermaster();
    Collection<Ordermaster> ordermaster;
    GenericType<Collection<Ordermaster>> gomaster;
    private String orderDate, orderStatus;
    private Integer omid, totalmeter;
    private double totalAmt;

    //Orderdetails
    Orderdetails od = new Orderdetails();
    Collection<Orderdetails> orderdetails;
    GenericType<Collection<Orderdetails>> god;

    //Contact
    Getintouch git = new Getintouch();
    Collection<Getintouch> getintouch;
    GenericType<Collection<Getintouch>> ggit;
    private String gitname, message;

    //Testimonials    
    Testimonials tst = new Testimonials();
    Collection<Testimonials> tstc;
    GenericType<Collection<Testimonials>> gtst;
    private String msg, ratting;

    //Address
    Addressmaster add = new Addressmaster();
    GenericType<Collection<Addressmaster>> gadd;
    private String address, phone, alt, city, state;

    public UserCDI() {
        uc = new UserClient();
        //User
        usermaster = new ArrayList<>();
        guser = new GenericType<Collection<Usermaster>>() {
        };

        //Product
        product = new ArrayList<>();
        gprod = new GenericType<Collection<Productmaster>>() {
        };

        //Cart
        cart = new ArrayList<>();
        gcart = new GenericType<Collection<Cart>>() {
        };

        //Ordermaster
        ordermaster = new ArrayList<>();
        gomaster = new GenericType<Collection<Ordermaster>>() {
        };

        //ORDER Details
        orderdetails = new ArrayList<>();
        god = new GenericType<Collection<Orderdetails>>() {
        };

        //Reviews
        tstc = new ArrayList<>();
        gtst = new GenericType<Collection<Testimonials>>() {
        };

        //Getintouch
        getintouch = new ArrayList<>();
        ggit = new GenericType<Collection<Getintouch>>() {
        };

        gadd = new GenericType<Collection<Addressmaster>>() {
        };

    }

    public Usermaster getUser() {
        return user;
    }

    public void setUser(Usermaster user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Productmaster getProd() {
        return prod;
    }

    public void setProd(Productmaster prod) {
        this.prod = prod;
    }

    public Cart getCt() {
        return ct;
    }

    public void setCt(Cart ct) {
        this.ct = ct;
    }

    public Ordermaster getOm() {
        return om;
    }

    public void setOm(Ordermaster om) {
        this.om = om;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getTotalmeter() {
        return totalmeter;
    }

    public void setTotalmeter(Integer totalmeter) {
        this.totalmeter = totalmeter;
    }

    public double getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(double totalAmt) {
        this.totalAmt = totalAmt;
    }

    public Orderdetails getOd() {
        return od;
    }

    public void setOd(Orderdetails od) {
        this.od = od;
    }

    public Integer getOmid() {
        return omid;
    }

    public void setOmid(Integer omid) {
        this.omid = omid;
    }

    public Getintouch getGit() {
        return git;
    }

    public void setGit(Getintouch git) {
        this.git = git;
    }

    public String getGitname() {
        return gitname;
    }

    public void setGitname(String gitname) {
        this.gitname = gitname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Testimonials getTst() {
        return tst;
    }

    public void setTst(Testimonials tst) {
        this.tst = tst;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRatting() {
        return ratting;
    }

    public void setRatting(String ratting) {
        this.ratting = ratting;
    }

    public String getProdname() {
        return prodname;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public Integer getMeters() {
        return meters;
    }

    public void setMeters(Integer meters) {
        this.meters = meters;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public Addressmaster getAdd() {
        return add;
    }

    public void setAdd(Addressmaster add) {
        this.add = add;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void emptyVariable() {
        //User
        this.name = "";
        this.user_email = "";
        this.password = "";
        this.contact = null;
        this.gender = "";
        //Geit in touch
        this.name = "";
        this.message = "";
        //Ordermaster
        this.orderDate = "";
        this.orderStatus = "";
        this.totalmeter = null;

    }

//USer
    public String insertuser() {
        this.user.setUserEmail(user_email);
        this.user.setName(name);
        this.user.setGender(gender);
        this.user.setPassword(password);
        this.user.setContactNo(contact);
        System.out.println(Email);
        uc.insertuser(user);
        this.emptyVariable();
        return "Login.xhtml?faces-redirect=true";
    }

    //Products
    public Collection<Productmaster> getallprod() {
        rs = uc.getProductmasters(Response.class);
        product = rs.readEntity(gprod);
        return product;
    }

    public String getprodbyId(String pid) {
        rs = uc.getProdbyId(Response.class, pid);
        GenericType<Productmaster> pro = new GenericType<Productmaster>() {
        };

        System.out.println(pid);
        Productmaster p = rs.readEntity(pro);
        this.setProId(p.getProdId());
        this.setDescription(p.getDescription());
        this.setProdname(p.getName());
        this.setColors(p.getColors());
        this.setMeters(p.getMeters());
        this.setTax(p.getTax());
        this.setImage(p.getImage());
        this.setProdname(p.getName());
        this.setPrice(p.getPrice());

        return "SingleProd.jsf";
    }

    public Collection<Productmaster> getprodbycat() {
        rs = uc.getprodbycat(Response.class, catid);
        product = rs.readEntity(gprod);
        return product;
    }

    public String getSingleProdById(String proId, Integer totalmeter) {
        rs = uc.getProdbyId(Response.class, proId);
        System.out.println(proId);
        System.out.println(totalmeter);
        rs = uc.getProdbyId(Response.class, proId);
        GenericType<Productmaster> pro = new GenericType<Productmaster>() {
        };
        Productmaster p = rs.readEntity(pro);
        this.setProId(p.getProdId());
        this.setDescription(p.getDescription());
        this.setProdname(p.getName());
        this.setColors(p.getColors());
        this.setMeters(p.getMeters());
        this.setImage(p.getImage());
        this.setProdname(p.getName());
        this.setCatid(p.getCatId().getName());
        this.setPrice(p.getPrice());
        return "Ordermaster.jsf";
    }

    //Git In Touch
    public String insertgit() {
        this.git.setName(name);
        this.git.setMessage(message);
        uc.insertgit(git, Email);
        this.emptyVariable();
        return "Home.xhtml?faces-redirect=true";
    }

    //Cart
    public Collection<Cart> getAllCart() {
        rs = uc.viewCart(Response.class, Email);
        cart = rs.readEntity(gcart);
        return cart;
    }

    public String addToCart(String proId, Integer totalmeter) {
        String totalmeters = totalmeter.toString();
        rs = uc.addToCart(Email, proId, totalmeters);
        if (rs != null) {
            System.out.println("Success");
            return "Products.xhtml?faces-redirect=true";
        } else {
            System.out.println("fail");
            return "SingleProd.xhtml?faces-redirect=true";
        }
    }

    public String checkout() {
        rs = uc.placeOrder(Email);
        if (rs != null) {
            System.out.println("Success");
            return "Billing.xhtml?faces-redirect=true";
        } else {
            System.out.println("fail");
            return "Cart.xhml?faces-redirect=true";
        }
    }

    //LOGOUT
    public String logout() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();

        // Invalidate the session
        HttpSession session = (HttpSession) externalContext.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        // Redirect to the login page or any other desired page
        return "Home.xhtml?faces-redirect=true";
    }

    //Payment
    //Order
    public Collection<Orderdetails> getorderbyuser() {
        rs = uc.getodbyuser(Response.class, Email);
        orderdetails = rs.readEntity(god);
        return orderdetails;
    }

    //Testimonials
    public String inserttst() {
        this.tst.setReview(msg);
        System.out.println(tst.getReview());
        this.tst.setRatting("5");
        rs = uc.insertreviews(tst, Email, prodId);
        if (rs != null) {
            System.out.println("Success");
        } else {
            System.out.println("fail");
        }
        return "Home.jsf?faces-redirect=true";
    }

    public Collection<Testimonials> gettstbypro() {
        String proids = proId.toString();
        rs = uc.gettstbypro(Response.class, proids);
        tstc = rs.readEntity(gtst);
        return tstc;
    }

    public void removeCart(Integer id) {
        String pids = id.toString();
       
        System.out.println(pids);
        System.out.println(Email);
        uc.removeCart(Email, pids);

    }
    //Address
    public String inAdd() {
        this.add.setAddress(address);
        this.add.setAltAddress(alt);
        this.add.setContactNo(phone);
        this.add.setCity(city);
        this.add.setState(state);
        System.out.println(add.getAddress());
        rs = uc.insertadd(add, Email);
        if (rs != null) {
            System.out.println("Success");
            return "Success.xhtml?faces-redirect=true";
        }
        return "Success.xhtml?faces-redirect=true";
    }
}
