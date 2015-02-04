package com.dell.boomi.action;

import com.dell.boomi.dto.ParsedFileValueObject;
import com.dell.boomi.form.FileUploadForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by piyush_g on 2/3/2015.
 */
public class FileUploadAction extends Action {

    public static List<ParsedFileValueObject> parseUploadFile(FormFile file) {
        List parsedDatalist = new ArrayList();
        String line = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
            while (br.ready()) {
                if (line != null && !line.equals(""))
                    parsedDatalist.add(line.trim());
            }
            br.close();
        } catch (IOException ioe) {

        }
        return parsedDatalist;
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        FileUploadForm fileUploadForm = (FileUploadForm) form;
        FormFile file = fileUploadForm.getFile();
        String filePath = getServlet().getServletContext().getRealPath("/") + "upload";

        File folder = new File(filePath);
        if (!folder.exists()) {
            folder.mkdir();
        }

        String fileName = file.getFileName();

        System.out.println("Printing File name for parsing ...." + fileName);
        if (!("").equals(fileName)) {

            System.out.println("Server path:" + filePath);
            File newFile = new File(filePath, fileName);

            if (!newFile.exists()) {
                FileOutputStream fos = new FileOutputStream(newFile);
                fos.write(file.getFileData());
                fos.flush();
                fos.close();
            }
            List<ParsedFileValueObject> parsedFileValueObjects = parseUploadFile(file);

            request.setAttribute("uploadedFilePath", newFile.getAbsoluteFile());
            request.setAttribute("uploadedFileName", newFile.getName());
        }

        return mapping.findForward("success");
    }

}