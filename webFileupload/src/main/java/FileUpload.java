import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
import java.nio.file.Path;


@MultipartConfig
@WebServlet("/fileupload")
public class FileUpload extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String path = req.getParameter("destination");//Name of the path where you want to store the file.
        Part filePart = req.getPart("file");//For getting data from the input type file we use part

        //till here we got data from html page

        String filename = filePart.getSubmittedFileName().toString();//file that we submitted

        //start filr upload
        OutputStream outputStream = null;
        InputStream inputStream = null;
         try{
             outputStream= new FileOutputStream(path+File.separator+filename);
             inputStream= filePart.getInputStream();//initialize inputstream

             int read=0;
             byte [] b= new byte[1024];
             while((read=inputStream.read(b))!=-1){
                 outputStream.write(b,0,read);
             }out.println("file uploaded succesfully");
         }catch (Exception e){
             System.out.println("error"+e);
         }
    }
}
