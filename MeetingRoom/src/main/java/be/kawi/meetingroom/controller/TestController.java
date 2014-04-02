package be.kawi.meetingroom.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import be.kawi.meetingroom.service.JavaMD5Hash;

@Path("security")
public class TestController {

	
	//deze GET is enkel om console log te produceren voor testredenen van Security string en MD5 hash
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSecurity() {

		JavaMD5Hash javaMD5Hash = new JavaMD5Hash();
		//Deze code hier tussen is enkel om in log te zien dat code correct dingen doet
		
		Date date=new Date();
		 SimpleDateFormat dateFormatyyyyMMdd = new SimpleDateFormat("yyyyMMdd");
		 String today=dateFormatyyyyMMdd.format(date);
		 System.out.println("datum : "+today);
		 String comparisonMD5Hash = javaMD5Hash.md5("MobileApps2013 "+today);
		 System.out.println(comparisonMD5Hash);
		 
		 //
		 
		System.out.println("codeer MobileApps2013 20140402 in MD5 in hex: " + javaMD5Hash.md5("MobileApps2013 20140402"));

		
		
		Response result = Response.status(200).entity("").build();

		return result;

	}

	
	// GET om uit de REST call de header x-authentication te lezen waarin de app de MD5hash heeft gestoken
	@GET
	@Path("/get")
	public Response testCall(@HeaderParam("x-authentication") String xAuthentication) {

		return Response.status(200).entity("testCall is called, header parameter x-authentication bevat: " + xAuthentication).build();

	}

	
	//methode om de gekregen MD5Hash vd app, te vergelijken met de server MD5Hash.
	//is nog niet volledig klaar
	
	 public boolean isMD5HashValid(String incomingMD5hash){
		 JavaMD5Hash javaMD5Hash = new JavaMD5Hash();
		 Date date=new Date();
		 SimpleDateFormat dateFormatyyyyMMdd = new SimpleDateFormat("yyyyMMdd");
		 String today=dateFormatyyyyMMdd.format(date);
		 System.out.println("datum : "+today);
		 
		 String comparisonMD5Hash = javaMD5Hash.md5("MobileApps2013 "+today);
		 
		 return true;
	 }

}