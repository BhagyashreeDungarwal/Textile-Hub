/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textileejb;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@DeclareRoles({"Admin", "User"})
@Stateless
public class SecureBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

@RolesAllowed("User")  
//@PermitAll  
 //@DenyAll   
public String saySecureHello()
{
    return "Secure Hello from Secure Bean";
}

}
