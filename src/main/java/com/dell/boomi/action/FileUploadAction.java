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
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by piyush_g on 2/3/2015.
 */
public class FileUploadAction extends Action {


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

            List<ParsedFileValueObject> dataList = parseUploadFile(file);
            System.out.println("Final Size of data list ---- " + dataList.size());
            request.setAttribute("uploadedFilePath", newFile.getAbsoluteFile());
            request.setAttribute("uploadedFileName", newFile.getName());

        }

        return mapping.findForward("success");
    }


    public static List<ParsedFileValueObject> parseUploadFile(FormFile file) {
        List<ParsedFileValueObject> list = new ArrayList<ParsedFileValueObject>();
        String line;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] splitStr = line.split(",");
                //System.out.println("Date : ---------- " + splitStr[0]);
                //System.out.println("Description: ++++++++++++  " + splitStr[2]);
                //System.out.println("amount : $$$$$$$$ " + splitStr[3]);
                list.add(new ParsedFileValueObject(parseDateFormat(splitStr[0]), splitStr[2], parseAmountFormat(splitStr[3])));
            }
            br.close();
            System.out.println(list.size());
        } catch (IOException ioe) {

        }
        return list;
    }


    private static String parseDateFormat(String str) {
        DateFormat parser = new SimpleDateFormat("MM/dd/yyyy'T'HH:mm:ss'Z'");
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm aaa");
        String formatedDate = null;
        try {
            Date convertedDate = parser.parse(str);
            formatedDate = formatter.format(convertedDate);
            //System.out.println(formatedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return formatedDate;
    }

    private static BigDecimal parseAmountFormat(String amount) {
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        BigDecimal amt = new BigDecimal(amount);
        System.out.println(df.format(amt));
        return amt;


    }


}
