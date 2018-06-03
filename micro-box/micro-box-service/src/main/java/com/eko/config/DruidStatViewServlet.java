package com.eko.config;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

@WebServlet(urlPatterns="/druid/*",    
    initParams={    
         @WebInitParam(name="allow",value=""),  
         @WebInitParam(name="deny",value=""),  
         @WebInitParam(name="loginUsername",value="root"),
         @WebInitParam(name="loginPassword",value="123"),
         @WebInitParam(name="resetEnable",value="false") 
})    
public class DruidStatViewServlet extends StatViewServlet {    
    private static final long serialVersionUID = -2688872071445249539L;    
    
}    