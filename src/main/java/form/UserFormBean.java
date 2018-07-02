/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * MyEclipse Struts Creation date: 06-21-2010
 *
 * XDoclet definition:
 *
 * @struts.form name="usuarioFormBean"
 */
public class UserFormBean extends ActionForm {

    private String userName;
    private String password;
    private String confirmPassword;
    private String roll;

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getRoll() {
        return roll;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Method validate
     *
     * @param mapping
     * @param request
     * @return ActionErrors
     */
    @Override
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Method reset
     *
     * @param mapping
     * @param request
     */
    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        userName = password = confirmPassword = roll = "";
    }

    @Override
    public String toString() {
        return String.format("[Usuario:%s, Contraseña: %s, Confirmacion Contraseña: %s, Roll:s]", userName, password, confirmPassword, roll);
    }
}