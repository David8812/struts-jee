/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import form.UserFormBean;
import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import service.impl.UserServiceImpl;

/**
 *
 * @author David
 */
public class SaveUserAction extends Action {

    @EJB
    private UserServiceImpl service;

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        UserFormBean userForm = (UserFormBean) form;

        String userName = userForm.getUserName(), password = userForm.getPassword();
        String confirmPassword = userForm.getConfirmPassword(), roll = userForm.getRoll();

        System.out.println("Usuario: " + userName + " Contraseña: " + password + " Confirmacion Contraseña: " + confirmPassword + " Roll: " + roll);

        System.out.println("Servicio: " + service);
        
        if (password.equals(confirmPassword)) {
            
            EJBContainer container = EJBContainer.createEJBContainer();
            Object o = container.getContext().lookup("java:global/struts-javaee/UserServiceImpl!service.impl.UserServiceImpl");

            User u = new User(userName, password, roll);

            if(service == null) {
                System.out.println("Ups!!! servicio es NULL");
            } else {
                System.out.println("servicio OK!");
                
                boolean inserted = service.insert(u);

                request.setAttribute("insertationState", inserted);
            }
        }

        return mapping.findForward("keepPage");
    }
}
