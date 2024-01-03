package CDIBean;

import Client.AdminClient;
import Client.UserClient;
import entities.Addressmaster;
import entities.Category;
import entities.Getintouch;
import entities.Orderdetails;
import entities.Ordermaster;
import entities.Productmaster;
import entities.Rolemaster;
import entities.Testimonials;
import entities.Usermaster;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author kewal dungarwal
 */
@Named(value = "adminCDI")
@RequestScoped
public class AdminCDI {

    Response rs;
    AdminClient ac;
    UserClient uc;
    //Address
    Addressmaster ad = new Addressmaster();
    Collection<Addressmaster> address;
    GenericType<Collection<Addressmaster>> gad;
    //User
    Usermaster user = new Usermaster();
    Collection<Usermaster> usermaster;
    GenericType<Collection<Usermaster>> guser;
    private String username, user_email, password, gender, contact;
    private Integer roleid;

//    Category
    private String catname;
    private String type;
    Collection<Category> category;
    GenericType<Collection<Category>> gcat;
    Category cat = new Category();

    //GETINTOUCH
    Getintouch git = new Getintouch();
    Collection<Getintouch> getintouch;
    GenericType<Collection<Getintouch>> ggit;
    private String gitname, message;

    //ORDER Details
    Orderdetails od = new Orderdetails();
    Collection<Orderdetails> orderdetails;
    GenericType<Collection<Orderdetails>> god;

//    Order Master
    Ordermaster om = new Ordermaster();
    Collection<Ordermaster> ordermaster;
    GenericType<Collection<Ordermaster>> gomaster;

    //Product
    Productmaster prod = new Productmaster();
    Collection<Productmaster> product;
    GenericType<Collection<Productmaster>> gprod;
    private String prodname, description, colors;
    private Part image;
    private Integer catid, meters;
    private Integer proId;
    private double tax, price;
    private String uimage;

    //Reviews
    Testimonials tst = new Testimonials();
    Collection<Testimonials> tstc;
    GenericType<Collection<Testimonials>> gtst;

//    ROle
    Collection<Rolemaster> rolemaster;
    GenericType<Collection<Rolemaster>> grole;
    Rolemaster rolem = new Rolemaster();
    private String role;

    public AdminCDI() {
        ac = new AdminClient();
        //Address
        address = new ArrayList<>();
        gad = new GenericType<Collection<Addressmaster>>() {
        };
        //User
        usermaster = new ArrayList<>();
        guser = new GenericType<Collection<Usermaster>>() {
        };
        //Category
        category = new ArrayList<>();
        gcat = new GenericType<Collection<Category>>() {
        };

        //GETINTOUCH
        getintouch = new ArrayList<>();
        ggit = new GenericType<Collection<Getintouch>>() {
        };
        //ORDER Details
        orderdetails = new ArrayList<>();
        god = new GenericType<Collection<Orderdetails>>() {
        };
        //OrderMaster
        ordermaster = new ArrayList<>();
        gomaster = new GenericType<Collection<Ordermaster>>() {
        };

        //Product
        product = new ArrayList<>();
        gprod = new GenericType<Collection<Productmaster>>() {
        };
        //Reviews
        tstc = new ArrayList<>();
        gtst = new GenericType<Collection<Testimonials>>() {
        };
        //Role
        rolemaster = new ArrayList<>();
        grole = new GenericType<Collection<Rolemaster>>() {
        };
    }

    public Addressmaster getAd() {
        return ad;
    }

    public void setAd(Addressmaster ad) {
        this.ad = ad;
    }

    public String getName() {
        return catname;
    }

    public void setName(String catname) {
        this.catname = catname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

    public Getintouch getGit() {
        return git;
    }

    public void setGit(Getintouch git) {
        this.git = git;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String useremail) {
        this.user_email = useremail;
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

    public Orderdetails getOd() {
        return od;
    }

    public void setOd(Orderdetails od) {
        this.od = od;
    }

    public Ordermaster getOm() {
        return om;
    }

    public void setOm(Ordermaster om) {
        this.om = om;
    }

    public Productmaster getProd() {
        return prod;
    }

    public void setProd(Productmaster prod) {
        this.prod = prod;
    }

    public String getProdname() {
        return prodname;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public Integer getCatid() {
        return catid;
    }

    public void setCatid(Integer catid) {
        this.catid = catid;
    }

    public Integer getMeters() {
        return meters;
    }

    public void setMeters(Integer meters) {
        this.meters = meters;
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

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Testimonials getTst() {
        return tst;
    }

    public void setTst(Testimonials tst) {
        this.tst = tst;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getUimage() {
        return uimage;
    }

    public void setUimage(String uimage) {
        this.uimage = uimage;
    }

//Address
    public Collection<Addressmaster> getalladd() {
        rs = ac.getaddress(Response.class);
        address = rs.readEntity(gad);
        return address;
    }

    //Category
    public Collection<Category> getallcat() {
        rs = ac.getallCat(Response.class);
        category = rs.readEntity(gcat);
        return category;
    }

    public String insertcat() {
        this.cat.setName(catname);
        this.cat.setType(type);
        ac.insertcat(cat);
        return "Category.xhtml";
    }

    public String deletecat(String catId) {
        ac.deletecat(catId);
        return "Category.xhtml";
    }

    public String getcatbyid(String id) {
        rs = ac.getcatbyid(Response.class, id);
        GenericType<Category> cate = new GenericType<Category>() {
        };
        Category c = rs.readEntity(cate);
        this.setCatid(c.getCatId());
        this.setName(c.getName());
        this.setType(c.getType());
        return "Catupdate.jsf";

    }

    public String updatecat(String catId) {

        this.cat.setName(catname);
        this.cat.setType(type);
        System.out.println(cat.getName());
        System.out.println(cat.getType());
        System.out.println(catId);
        rs = ac.updatecat(cat, catId);
        if (rs != null) {
            return "Category.xhtml";
        } else {
            System.out.println("something wrong");
            return "../index.html";
        }

    }

    //GETINTOUCH
    public Collection<Getintouch> getallgit() {
        rs = ac.getgit(Response.class);
        getintouch = rs.readEntity(ggit);
        return getintouch;
    }

//    ORDER Details
    public Collection<Orderdetails> getallorderd() {
        rs = ac.getodetails(Response.class);
        orderdetails = rs.readEntity(god);
        return orderdetails;
    }
    //ORDer Master

    public Collection<Ordermaster> getallordermaster() {
        rs = ac.getorderm(Response.class);
        ordermaster = rs.readEntity(gomaster);
        return ordermaster;
    }

    //Product
    public Collection<Productmaster> getallprod() {
        rs = ac.getProductmasters(Response.class);
        product = rs.readEntity(gprod);
        return product;
    }

    public void emptyVariable() {
        this.prodname = "";
        this.description = "";
        this.colors = "";
        this.image = null;
//        this.tax = null;
        this.meters = null;
//        this.price = null;
    }

    public Collection<SelectItem> getAllCatwithIds() {
        rs = ac.getallCat(Response.class);
        category = rs.readEntity(gcat);

        Collection<SelectItem> catname = new ArrayList<>();
        for (Category c : category) {
            catname.add(new SelectItem(c.getCatId(), c.getName()));
        }
        return catname;
    }

    //Product
    public String insertpro(String catid) {

        if (image != null) {
            try {
                String fileName = image.getSubmittedFileName();

                // Specify the directory where you want to store the files
                String uploadDirectory = "D:\\Bhagyashree\\textile wholeseller\\textile\\TextileHub\\src\\main\\webapp\\Images";
                File uploadDir = new File(uploadDirectory);

                // Create the directory if it doesn't exist
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }
                // Create a File object representing the uploaded file
                File uploadedFile = new File(uploadDirectory, fileName);
                // Copy the content of the InputStream to the FileOutputStream
                try (InputStream in = image.getInputStream(); FileOutputStream out = new FileOutputStream(uploadedFile)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }
                this.prod.setName(prodname);
                this.prod.setDescription(description);
                this.prod.setImage(fileName);
                this.prod.setColors(colors);
                this.prod.setMeters(meters);
                this.prod.setPrice(price);

                System.out.println("Name :" + prod.getName());
                System.out.println("des :" + prod.getDescription());
                System.out.println("image :" + prod.getImage());
                System.out.println("meter :" + prod.getMeters());
                System.out.println("Price :" + prod.getPrice());
                System.out.println("color :" + prod.getColors());
                System.out.println("catid :" + catid);
                ac.insertprod(prod, catid);
                this.emptyVariable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File is null");
        }
        return "Product.xhtml?faces-redirect=true";
    }

    public String getprodbyId(Productmaster prodd) {
        this.prod = prodd;
        return "ProdUpdate.jsf";
    }

    public String updatepro(String id, String catid) {
        this.prod.setName(prodname);
        this.prod.setDescription(description);
        this.prod.setColors(colors);
        this.prod.setMeters(meters);
        this.prod.setTax(tax);
        this.prod.setPrice(price);
        System.out.println("Product Name" + prodname);
        System.out.println("Product Desc" + description);
        System.out.println("Product Color" + colors);
        System.out.println("Product meter" + meters);
        System.out.println("Product tex" + tax);
        System.out.println("Product Price" + price);
//        String catids = catId.toString();

        System.out.println(cat);
        rs = ac.updateprod(prod, id, catid);
        if (rs != null) {
            System.out.println("Update");
            return "Product.xhtml";
        } else {
            System.out.println("something wrong");
            return "../index.html";
        }
    }

//    public String UpProduct(String id, String cid, String bid) {
//        this.prod.setPName(pname);
//        this.prod.setAmmount(ammount);
//        this.prod.setDescription(description);
//        this.prod.setUnit(unit);
//        this.prod.setStock(stock);
//        this.prod.setDiscount(discount);
//        this.prod.setTax(tax);
//        this.prod.setGst(gst);
//        this.prod.setSgst(sgst);
//
//        System.out.println("pname :" + prod.getPName());
//        System.out.println("amt :" + prod.getAmmount());
//        System.out.println("descri :" + prod.getDescription());
//        System.out.println("unit :" + prod.getUnit());
//        System.out.println("stock :" + prod.getStock());
//        System.out.println("disco :" + prod.getDiscount());
//        System.out.println("tax :" + prod.getTax());
//        System.out.println("gst :" + prod.getGst());
//        System.out.println("sgst :" + prod.getSgst());
//         System.out.println("pid :"+ id);
//          System.out.println("cid :"+ cid);
//           System.out.println("bid :"+ bid);
//        rs = ad.updateProduct(prod, id, cid, bid);
//        if (rs != null) {
//            System.out.println("success");
//        } else {
//            System.out.println("fail");
//        }
//        return "Product.jsf?faces-redirect=true";
//    }
//    
    public String deletepro(Integer proIds) {
        System.out.println("from cdi");
        String ids = proIds.toString();
        ac.deleteprod(ids);
        return "Product.jsf";
    }

    //Reviews
    public Collection<Testimonials> getallrev() {
        rs = ac.getreviews(Response.class);
        tstc = rs.readEntity(gtst);
        return tstc;
    }
//    Role

    public Collection<Rolemaster> getallrole() {
        rs = ac.getrole(Response.class);
        rolemaster = rs.readEntity(grole);
        return rolemaster;
    }

    //User
    public Collection<Usermaster> getalluser() {
        rs = ac.getuser(Response.class);
        usermaster = rs.readEntity(guser);
        return usermaster;
    }

    public String insertuser() {
        this.user.setUserEmail(user_email);
        this.user.setName(username);
        this.user.setGender(gender);
        this.user.setPassword(password);
        this.user.setContactNo(contact);
        System.out.println("");
        uc.insertuser(user);
        this.emptyVariable();
        return "Login.xhtml?faces-redirect=true";
    }

}
