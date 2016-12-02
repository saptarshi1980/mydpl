package in.net.dpl.rest;
 

import in.net.dpl.utility.ConnDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.mail.MessageContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;

/**
 * @author Crunchify.com
 */
 
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.WebServiceContext;

import com.google.gson.Gson;

import in.net.dpl.dao.Project;
import in.net.dpl.dto.BillHistory;
import in.net.dpl.dto.Consumer;
import in.net.dpl.dto.FeedObjects;
import in.net.dpl.dto.Tariff;
import in.net.dpl.utility.ExamineMessage;
 
@Path("/findip")
public class IPfinder {
	@Resource
	  WebServiceContext wsContext;
	
	@Context private javax.servlet.http.HttpServletRequest hsr;
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/ip")
	
		public String getData(@Context HttpServletRequest request,@FormParam("msg") String msg){
			   String ip = request.getRemoteAddr();
			   System.out.println("IP-"+ip);
			   System.out.println("MSG-"+msg);
			   
			   return ip;
			}
		
			    
	    

	


}