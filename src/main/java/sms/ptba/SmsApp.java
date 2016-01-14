package sms.ptba;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import sms.ptba.resources.SmsResource;

public class SmsApp extends Application<SmsConfig> {

	@Override
	public void run(SmsConfig c, Environment e) throws Exception {
		e.jersey().register(new SmsResource(c));
	}
	
	public static void main(String[] args) throws Exception{
		new SmsApp().run(args);
	}

}
