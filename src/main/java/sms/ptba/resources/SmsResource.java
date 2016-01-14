package sms.ptba.resources;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sms.ptba.SmsConfig;
import sms.ptba.representation.SmsModel;

@Path("/sms")
@Produces({ "application/json" })
public class SmsResource {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SmsResource.class);
	private String pathGammu;
	private String configGammu;
	public SmsResource(SmsConfig c) {
		this.pathGammu = c.getPathGammu();
		this.configGammu = c.getConfigGammu();
	}
	@GET
	@Path("/index")
	public Response index(){
		return Response.ok().build();
	}
	@POST
	@Path("/sendSms")
	public Response sendSms(SmsModel sms){
		Runtime runtime = Runtime.getRuntime();
		try {
			LOGGER.debug("COMMAND : {} ",pathGammu+" -c "+configGammu+" TEXT "+sms.getNomorHp()+" -text \""+sms.getPesan()+"\" ");
			runtime.exec(pathGammu+" -c "+configGammu+" TEXT "+sms.getNomorHp()+" -text \""+sms.getPesan()+"\" ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.ok().build();
	}
}
