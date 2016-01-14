package sms.ptba;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class SmsConfig extends Configuration {

	@JsonProperty("path_gammu")
	private String pathGammu;
	
	@JsonProperty("config_gammu")
	private String configGammu;
	public String getPathGammu() {
		return pathGammu;
	}
	public String getConfigGammu() {
		return configGammu;
	}
}
