/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CDIBean;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Email;

/**
 *
 * @author kewal dungarwal
 */
@Named(value = "navigationCDI")
@RequestScoped
public class NavigationCDI {

    /**
     * Creates a new instance of NavigationCDI
     */
    public NavigationCDI() {
    }

    String Email;
    public String checkAdmin() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(false);
        Email = (String) session.getAttribute("Admin");
        if (Email == null) {
            // Redirect to the login page
            try {
                externalContext.redirect(externalContext.getRequestContextPath() + "/Login.jsf");
            } catch (Exception e) {
                e.printStackTrace(); // Handle the exception as needed
            }
            return "/Login.jsf?faces-redirect=true";
        }
        return "successOutcome";
    }
    
    public String checkUser()
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(false);

         Email = (String) session.getAttribute("User");
        if (Email == null) {
            // Redirect to the login page
            try {
                externalContext.redirect(externalContext.getRequestContextPath() + "/Login.jsf");
            } catch (Exception e) {
                e.printStackTrace(); // Handle the exception as needed
            }
            return "/Login.jsf?faces-redirect=true";
        }
         return "successOutcome";
    }
}
