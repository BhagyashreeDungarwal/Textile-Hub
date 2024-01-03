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
import textileejb.UsersLocal;

/**
 * REST Web Service
 *
 * @author kewal dungarwal
 */
@Path("Userrest")
@RequestScoped
public class Userrest {

    @EJB
    UsersLocal obj;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Userrest
     */
    public Userrest() {
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

    @DELETE
    @Path("/deUser/{uemail}/{rid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteuser(@PathParam("email") String uemail, @PathParam("rid") Integer rid) {
        try {
            if (obj.deleteuser(uemail, rid)) {
                String msg = "User Deleted Successfully!!";
                return Response.status(Response.Status.OK).entity(msg).build();
            } else {
                return Response.notModified().build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
        }
    }

    @PUT
    @Path("/upUser/{uemail}/{1}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateuser(@PathParam("uemail") String uemail, Usermaster user) {
        try {
            if (obj.updateuser(user.getUserEmail(), user.getName(), user.getPassword(), user.getContactNo(), user.getGender())) {
                String msg = "User Updated Successfully!!";
                return Response.status(Response.Status.OK).entity(msg).build();
            } else {
                return Response.notModified().build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
        }
    }

    @GET
    @Path("getuserbyId/{uemail}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usermaster getUserbyId(@PathParam("uemail") String uemail) {
        return obj.getuserbyid(uemail);
    }

    @POST
    @Path("inreviews/{uemail}/{pid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertreviews(@PathParam("uemail") String uemail,@PathParam("pid") Integer pid, Testimonials rev) {
        try {
            if (obj.inserttsml(rev.getReview(), rev.getRatting(),pid, uemail)) {
                String msg = "Reviews Addedd Successfully!!";
                return Response.status(Response.Status.OK).entity(msg).build();
            } else {
                return Response.notModified().build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
        }
    }

    @GET
    @Path("getreviewById")
    @Produces(MediaType.APPLICATION_JSON)
    public Testimonials getTestimonialsbyId(@PathParam("id") Integer id) {
        return obj.gettsmlbyid(id);
    }

    @GET
    @Path("getrolebyid")
    @Produces(MediaType.APPLICATION_JSON)
    public Rolemaster getrolebyid(@PathParam("id") Integer id) {
        return obj.getrolebyid(id);
    }

    @GET
    @Path("getProd")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Productmaster> getProductmasters() {
        return obj.getallProductMasters();
    }

    @GET
    @Path("/getprodbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Productmaster getProdbyId(@PathParam("id") Integer id) {
        return obj.getprodbyid(id);
    }
    
    @GET
    @Path("getprodbycat/{cid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Productmaster> getprodbycat (@PathParam("cid") Integer cid){
        return obj.getprodbyCat(cid);
    }
    
    @GET
    @Path("gettstbypro/{pid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Testimonials> gettstbypro(@PathParam("pid") Integer pid){
        return obj.gettstbyPro(pid);
    }

//    @POST
//    @Path("inom/{uemail}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response insertordermaster(@PathParam("uemail") String uemail,  Ordermaster om) {
//        try {
//            if (obj.insertordermaster(om.getOrderStatus(), om.getMeter(), om.getTotalAmt(), uemail)) {
//                String msg = "Order master Addedd Successfully!!";
//                return Response.status(Response.Status.OK).entity(msg).build();
//            } else {
//                return Response.notModified().build();
//            }
//        } catch (IllegalArgumentException e) {
//            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
//        }
//    }

//    @PUT
//    @Path("upom/{id}/{prodid}/{uemail}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response updateordermaster(@PathParam("id") Integer id, @PathParam("uemail") String uemail, @PathParam("prodid") Integer prodid, Ordermaster om) {
//        try {
//            if (obj.updateordermaster(id, om.getOrderStatus(), prodid, om.getId(), om.getTax(), om.getTotalAmt(), uemail)) {
//                String msg = "Order master Updated Successfully!!";
//                return Response.status(Response.Status.OK).entity(msg).build();
//            } else {
//                return Response.notModified().build();
//            }
//        } catch (IllegalArgumentException e) {
//            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
//        }
//    }

//    @DELETE
//    @Path("deom/{omid}/{uemail}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response deleteordermaster(@PathParam("omid") Integer omid, @PathParam("uemail") String uemail) {
//        try {
//            if (obj.deleteordermaster(omid, uemail)) {
//                String msg = "Order master Deleted Successfully!!";
//                return Response.status(Response.Status.OK).entity(msg).build();
//            } else {
//                return Response.notModified().build();
//            }
//        } catch (IllegalArgumentException e) {
//            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
//        }
//    }

    @GET
    @Path("getodbyId")
    @Produces(MediaType.APPLICATION_JSON)
    public Orderdetails getodbyId(@PathParam("id") Integer id) {
        return obj.getorderdetailsbyid(id);
    }
      @GET
    @Path("getodbyuser/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Orderdetails> getodbyuser(@PathParam("email") String email) {
        return obj.getorderbyuser(email);
    }
    
//     @POST
//    @Path("inod/{prodid}/{omid}/{uemail}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response insertod(@PathParam("prodid") Integer prodid,@PathParam("uemail") String uemail, @PathParam("omid") Integer omid, Orderdetails od) {
//        if (obj.insertod(od.getProdPrice(), od.getProdName(), od.getTax(), od.getMeter(), prodid, uemail, omid)) {
//            String msg = "OrderDetails Added Successfully!!";
//            return Response.status(Response.Status.OK).entity(msg).build();
//        } else {
//            return Response.notModified().build();
//        }
//    }

    @POST
    @Path("ingit/{uemail}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertgit(@PathParam("uemail") String uemail, Getintouch git) {
        try {
            if (obj.insertgit(uemail, git.getName(), git.getMessage())) {
                String msg = "GetIN Addedd Successfully!!";
                return Response.status(Response.Status.OK).entity(msg).build();
            } else {
                return Response.notModified().build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
        }
    }

    @GET
    @Path("getcatbyid")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getcatbyid(@PathParam("id") Integer id) {
        return obj.getcatbyid(id);
    }

    @POST
    @Path("incart/{useremail}/{pid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertcart(@PathParam("useremail") String useremail, @PathParam("pid") Integer pid, Cart c) {
        try {
            if (obj.insertcart(c.getMeters(), useremail, c.getAmount(), pid)) {
                String msg = "Cart Added Successfully!!";
                return Response.status(Response.Status.OK).entity(msg).build();
            } else {
                return Response.notModified().build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
        }
    }

    @PUT
    @Path("upcart/{crtid}/{useremail}/{pid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatecart(@PathParam("crtid") Integer crtid, @PathParam("useremail") String useremail, @PathParam("pid") Integer pid, Cart c) {
        try {
            if (obj.updatecart(crtid, c.getMeters(), useremail, c.getAmount(), crtid)) {
                String msg = "Cart Updated Successfully!!";
                return Response.status(Response.Status.OK).entity(msg).build();
            } else {
                return Response.notModified().build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
        }
    }

    @DELETE
    @Path("decart/{crtid}/{useremail}/{pid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletecart(@PathParam("crtid") Integer crtid, @PathParam("useremail") String useremail, @PathParam("pid") Integer pid) {
        try {
            if (obj.deletecart(crtid, useremail, pid)) {
                String msg = "Cart Deleted Successfully!!";
                return Response.status(Response.Status.OK).entity(msg).build();
            } else {
                return Response.notModified().build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
        }
    }

    @GET
    @Path("getcartbyId")
    @Produces(MediaType.APPLICATION_JSON)
    public Cart getcartbyId(@PathParam("id") Integer id) {
        return obj.getcartbyId(id);
    }
    
    

    @POST
    @Path("/inadd/{uemail}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertadd(@PathParam("uemail") String uemail, Addressmaster add) {
        try {
            if (obj.insertadd(add.getAddress(), add.getContactNo(), add.getAltAddress(), add.getCity(), add.getState(), uemail)) {
                String msg = "Address Addedd Successfully!!";
                return Response.status(Response.Status.OK).entity(msg).build();
            } else {
                return Response.notModified().build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
        }
    }

    @PUT
    @Path("/upadd/{id}/{uemail}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateadd(@PathParam("id") Integer id, @PathParam("uemail") String uemail, Addressmaster add) {
        try {
            if (obj.updateadd(id, add.getAddress(), add.getContactNo(), add.getAltAddress(), add.getCity(), add.getState(), uemail)) {
                String msg = "Address Updated Successfully!!";
                return Response.status(Response.Status.OK).entity(msg).build();
            } else {
                return Response.notModified().build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
        }
    }

    @DELETE
    @Path("/deadd/{id}/{uemail}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteadd(@PathParam("id") Integer id, @PathParam("uemail") String uemail) {
        try {
            if (obj.deleteadd(id, uemail)) {
                String msg = "Address Deleted Successfully!!";
                return Response.status(Response.Status.OK).entity(msg).build();
            } else {
                return Response.notModified().build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data").build();
        }
    }

    @GET
    @Path("getaddbyId")
    @Produces(MediaType.APPLICATION_JSON)
    public Addressmaster getaddbyId(@PathParam("id") Integer id) {
        return obj.getaddbyid(id);
    }
    
    @GET
    @Path("getpaybyemail/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Payment> getpaybyEmail(@PathParam("email") String Useremail){
     return obj.getPayByUser(Useremail);
    }
    
    @POST
    @Path("addToCart/{useremail}/{pId}/{meter}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addToCart(@PathParam("useremail") String useremail, @PathParam("pId") Integer pId, @PathParam("meter") Integer meter) {
        boolean result = obj.addProductToCart(useremail, pId, meter);
        if (result) {
            String msg = "Cart Added successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("deleteCart/{useremail}/{pId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeCart(@PathParam("useremail") String useremail, @PathParam("pId") Integer pId) {
        boolean result = obj.removeProductFromCart(useremail, pId);
        if (result) {
            String msg = "product Remove successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.serverError().build();
        }
    }
    
    @GET
    @Path("viewCart/{useremail}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Cart> viewCart(@PathParam("useremail") String useremail){
        return obj.viewCart(useremail);
    }
    @POST
    @Path("PlaceOrder/{useremail}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response placeOrder(@PathParam("useremail") String useremail){
          boolean result = obj.placeOrder(useremail);
        if (result) {
            String msg = "Order Place successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.serverError().build();
        }
    }
}
