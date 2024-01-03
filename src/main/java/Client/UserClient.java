/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package Client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:Userrest [Userrest]<br>
 * USAGE:
 * <pre>
 *        UserClient client = new UserClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author kewal dungarwal
 */
public class UserClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/TextileHub/resources";

    public UserClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("Userrest");
    }

    public Response insertcart(Object requestEntity, String useremail, String pid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("incart/{0}/{1}", new Object[]{useremail, pid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response placeOrder(String useremail) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("PlaceOrder/{0}", new Object[]{useremail})).request().post(null, Response.class);
    }

    public <T> T getProductmasters(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getProd");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getcatbyid(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getcatbyid");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response deleteadd(String id, String uemail) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deadd/{0}/{1}", new Object[]{id, uemail})).request().delete(Response.class);
    }

    public Response deleteuser(String uemail, String rid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deUser/{0}/{1}", new Object[]{uemail, rid})).request().delete(Response.class);
    }

    public Response updatecart(Object requestEntity, String crtid, String useremail, String pid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("upcart/{0}/{1}/{2}", new Object[]{crtid, useremail, pid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public <T> T gettstbypro(Class<T> responseType, String pid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("gettstbypro/{0}", new Object[]{pid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getprodbycat(Class<T> responseType, String cid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getprodbycat/{0}", new Object[]{cid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response insertreviews(Object requestEntity, String uemail, String pid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("inreviews/{0}/{1}", new Object[]{uemail, pid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public <T> T getTestimonialsbyId(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getreviewById");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response addToCart(String useremail, String pId, String meter) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("addToCart/{0}/{1}/{2}", new Object[]{useremail, pId, meter})).request().post(null, Response.class);
    }

    public <T> T viewCart(Class<T> responseType, String useremail) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("viewCart/{0}", new Object[]{useremail}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getrolebyid(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getrolebyid");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response insertadd(Object requestEntity, String uemail) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("inadd/{0}", new Object[]{uemail})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response insertuser(Object requestEntity) throws ClientErrorException {
        return webTarget.path("InUser").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public <T> T getodbyuser(Class<T> responseType, String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getodbyuser/{0}", new Object[]{email}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getProdbyId(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getprodbyid/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getcartbyId(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getcartbyId");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response updateadd(Object requestEntity, String id, String uemail) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("upadd/{0}/{1}", new Object[]{id, uemail})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response insertgit(Object requestEntity, String uemail) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("ingit/{0}", new Object[]{uemail})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public <T> T getUserbyId(Class<T> responseType, String uemail) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getuserbyId/{0}", new Object[]{uemail}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getodbyId(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getodbyId");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response removeCart(String useremail, String pId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteCart/{0}/{1}", new Object[]{useremail, pId})).request().delete(Response.class);
    }

    public <T> T getaddbyId(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getaddbyId");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getpaybyEmail(Class<T> responseType, String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getpaybyemail/{0}", new Object[]{email}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response updateuser(Object requestEntity, String uemail, String arg) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("upUser/{0}/{1}", new Object[]{uemail, arg})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response deletecart(String crtid, String useremail, String pid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("decart/{0}/{1}/{2}", new Object[]{crtid, useremail, pid})).request().delete(Response.class);
    }

    public void close() {
        client.close();
    }
    
}
