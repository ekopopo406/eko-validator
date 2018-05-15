<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page language="java" import="com.eko.upload.UploadFileService"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%><%@ page
	import="javax.servlet.http.*"%><%@ page import="org.apache.commons.*"%><%@ page
	import="org.apache.commons.fileupload.*"%><%@ page
	import="org.apache.commons.fileupload.disk.*"%><%@ page
	import="org.apache.commons.fileupload.servlet.*"%><%@ page
	import="org.apache.commons.io.*"%>
<%@ page import="org.apache.commons.fileupload.util.Streams"%>

<%
try{
  boolean isMultipart = ServletFileUpload.isMultipartContent(request);
  ServletFileUpload upload = new ServletFileUpload();
 FileItemIterator iter = upload.getItemIterator(request);
while (iter.hasNext()) {
    FileItemStream item = iter.next();
    String name = item.getFieldName();
    InputStream stream = item.openStream();
  int fixSize = 1024;
    if (item.isFormField()) {
        out.println("Form field " + name + " with value "
            + Streams.asString(stream) + " detected.");
    } else {
        out.println("File field " + name + " with file name "
            + item.getName() + " detected.");
        File file = new File(System.getProperty("java.io.tmpdir")+item.getName());
  /*      out.println(stream.available());
       int fullSize = stream.available(); */
      /*  int fixParts = fullSize / fixSize;
        int yuParts = fullSize % fixSize;
       out.println("parts:"+fixParts + "yuParts:" + yuParts); */
		 FileUtils.copyInputStreamToFile(stream, file);
		 out.println("read file over");
        UploadFileService service = new UploadFileService(file);
   
		service.upload(); 
		 
    }
}
} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 //C:\\Users\\IBM_ADMIN\\Documents\\SametimeFileTransfers\\Microsite-Portal.zip"
	  	 
%>
