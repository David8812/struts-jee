/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import form.GroupFormBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Group;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import service.impl.GroupServiceImpl;

/**
 *
 * @author David
 */
public class SaveGroupAction extends Action {
    
    GroupServiceImpl gservice = new GroupServiceImpl();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        GroupFormBean group = (GroupFormBean) form;
        
        Group g = new Group();
        g.setGroupName(group.getGroupName());
        
        gservice.insert(g);
        
        return mapping.findForward("keepPage");
    }
}
