package com.eko.action;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

public class ReadFileServlet extends BaseServlet {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			  ServletFileUpload upload = new ServletFileUpload();
			 FileItemIterator iter = upload.getItemIterator(request);
			while (iter.hasNext()) {
			    FileItemStream item = iter.next();
			    String name = item.getFieldName();
			    InputStream stream =  item.openStream();
			    if (item.isFormField()) {
			        System.out.println("Form field " + name + " with value "
			            + Streams.asString(stream) + " detected.");
			    } else {
			        System.out.println("File field " + name + " with file name "
			            + item.getName() + " detected.");
			       
			    }
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
