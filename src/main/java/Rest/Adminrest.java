/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package Rest;

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
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import textileejb.AdminLocal;

/**
 * REST Web Service
 *
 * @author kewal dungarwal
 */
@Path("Adminrest")
@RequestScoped
public class Adminrest {

    @EJB
    AdminLocal obj;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Adminrest
     */
    public Adminrest() {
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String hello() {
        return "<h3>Admin</h3>";
    }

    @GET
    @Path("getrole")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Rolemaster> getrole() {
        return obj.getRole();
    }

    @GET
    @Path("getrolebyid")
    @Produces(MediaType.APPLICATION_JSON)
    public Rolemaster getrolebyid(@PathParam("id") Integer id) {
        return obj.getrolebyid(id);
    }

    @GET
    @Path("getallcat")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Category> getallCat() {
        return obj.getallCategory();
    }

    @POST
    @Path("/insertcat")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertcat(Category cat) {
        try {
            if (obj.insertcat(cat.getName(), cat.getType())) {
                String msg = "success";
                return Response.status(Response.Status.OK).entity(msg).build();
            } else {
                return Response.notModified().build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
        }
    }

    @DELETE
    @Path("/deletecat/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletecat(@PathParam("id") Integer id) {
        try {
            if (obj.deletecat(id)) {
                String msg = "success";
                return Response.status(Response.Status.OK).entity(msg).build();
            } else {
                return Response.notModified().build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
        }
    }

    @PUT
    @Path("/updatecat/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
    public Response updatecat(@PathParam("id") Integer id, Category cat) {
        try {
            if (obj.updatecat(id, cat.getName(), cat.getType())) {
                String msg = "updated";
                return Response.status(Response.Status.OK).entity(msg).build();
            } else {
                return Response.notModified().build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
        }
    }

    @GET
    @Path("getcatbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getcatbyid(@PathParam("id") Integer id) {
        return obj.getcatbyid(id);
    }

    @GET
    @Path("getProd")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Productmaster> getProductmasters() {
        return obj.getallProductMasters();
    }

    @POST
    @Path("insertProd/{catId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertprod(@PathParam("catId") Integer catId, Productmaster prod) {
        try {
            if (obj.insertpro(catId, prod.getName(), prod.getDescription(), prod.getImage(), prod.getColors(), prod.getMeters(), prod.getPrice())) {
                String msg = "Product Insert successfullyy!!";
                return Response.status(Response.Status.OK).entity(msg).build();
            } else {
                return Response.notModified().build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
        }
    }

    
    @DELETE
    @Path("deleteprod/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteprod(@PathParam("id") Integer id) {
        try {
            if (obj.deletepro(id)) {
                System.out.println("form rest");
                String msg = "Product Deleted Successfully!!";
                return Response.status(Response.Status.OK).entity(msg).build();
            } else {
                return Response.notModified().build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
        }
    }

    
    
    @PUT
    @Path("update/{id}/{catId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateprod(@PathParam("id") Integer id, @PathParam("catId") Integer catId, Productmaster prod) {
        try {
            if (obj.updatepro(id, prod.getName(), catId, prod.getDescription(), prod.getImage(), prod.getColors(), prod.getMeters(), prod.getPrice())) {
                String msg = "Product Deleted Successfully!!";
                return Response.status(Response.Status.OK).entity(msg).build();
            } else {
                return Response.notModified().build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
        }
    }

    @GET
    @Path("/getprodbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Productmaster getProdbyId(@PathParam("id") Integer id) {
        return obj.getprodbyid(id);
    }

    @GET
    @Path("getaddress")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Addressmaster> getaddress() {
        return obj.gettaddress();
    }

    @GET
    @Path("getaddbyId")
    @Produces(MediaType.APPLICATION_JSON)
    public Addressmaster getaddbyId(@PathParam("id") Integer id) {
        return obj.getaddbyid(id);
    }

    @GET
    @Path("getcart")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Cart> getcart() {
        return obj.getcartlist();
    }

    @GET
    @Path("getcartbyId")
    @Produces(MediaType.APPLICATION_JSON)
    public Cart getcartbyId(@PathParam("id") Integer id) {
        return obj.getcartbyId(id);
    }

    @GET
    @Path("getgit")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Getintouch> getgit() {
        return obj.getgit();
    }

    @GET
    @Path("gitbyId")
    @Produces(MediaType.APPLICATION_JSON)
    public Getintouch getgitbyId(@PathParam("id") Integer id) {
        return obj.gitid(id);
    }

    @GET
    @Path("getodbyId")
    @Produces(MediaType.APPLICATION_JSON)
    public Orderdetails getodbyId(@PathParam("id") Integer id) {
        return obj.getorderbyid(id);
    }

    @GET
    @Path("getodetails")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Orderdetails> getodetails() {
        return obj.getorderdetails();
    }

//    @PUT
//    @Path("upom/{id}/{prodid}/{uemail}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response updateom(@PathParam("id") Integer id, @PathParam("uemail") String uemail, @PathParam("prodid") Integer prodid, Ordermaster om) {
//        try {
//            if (obj.updateordermaster(id, prodid, om.getOrderStatus(), om.getTax(), om.getTotalAmt(), uemail)) {
//                String msg = "Order master Updated Successfully!!";
//                return Response.status(Response.Status.OK).entity(msg).build();
//            } else {
//                return Response.notModified().build();
//            }
//        } catch (IllegalArgumentException e) {
//            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
//        }
//    }

    @GET
    @Path("getorderm")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Ordermaster> getorderm() {
        return obj.getOrdermaster();
    }

    @GET
    @Path("getombyId")
    @Produces(MediaType.APPLICATION_JSON)
    public Ordermaster getombyId(@PathParam("id") Integer id) {
        return obj.getordermbyid(id);
    }

    @GET
    @Path("getreviews")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Testimonials> getreviews() {
        return obj.gettsml();
    }

    @GET
    @Path("getreviewById")
    @Produces(MediaType.APPLICATION_JSON)
    public Testimonials getTestimonialsbyId(@PathParam("id") Integer id) {
        return obj.gettsmlbyid(id);
    }

    @GET
    @Path("getUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Usermaster> getuser() {
        return obj.getUser();
    }

    @GET
    @Path("getuserbyId/{uemail}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usermaster getUserbyId(@PathParam("uemail") String uemail) {
        return obj.getuserbyid(uemail);
    }
    
    @GET
    @Path("getPayment")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Payment> getpay(){
        return obj.getpayment();
    }
      @POST
    @Path("/InUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertuser( Usermaster user) {
        try {
            if (obj.insertuser(user.getUserEmail(), user.getName(), user.getPassword(), user.getContactNo(), user.getGender())) {
                String msg = "User Inserted successfully!!";
                return Response.status(Response.Status.OK).entity(msg).build();
            } else {
                return Response.notModified().build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
        }
    }
}
