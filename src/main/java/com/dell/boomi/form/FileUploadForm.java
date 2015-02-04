package com.dell.boomi.form;

/**
 * Created by piyush_g on 2/3/2015.
 */

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import javax.servlet.http.HttpServletRequest;

public class FileUploadForm extends ActionForm {

    private FormFile file;

    public FormFile getFile() {
        return file;
    }

    public void setFile(FormFile file) {
        this.file = file;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        if (getFile().getFileSize() == 0) {
            errors.add("common.file.err", new ActionMessage("error.common.file.required"));
            return errors;
        }

        if (!"text/plain".equals(getFile().getContentType())) {
            errors.add("common.file.err.ext",  new ActionMessage("error.common.file.textfile.only"));
            return errors;
        }

        return errors;
    }
}
