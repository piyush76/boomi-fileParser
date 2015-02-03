package com.dell.boomi;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by piyush_g on 2/2/2015.
 */
public class FileUploadAction  extends Action  {

    private static Logger logger = Logger.getLogger(FileUploadAction.class);


    public ActionForward executeAction(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)	throws Exception {
        ActionForward forward = new ActionForward();

        return forward = mapping.findForward("success");
    }



}
