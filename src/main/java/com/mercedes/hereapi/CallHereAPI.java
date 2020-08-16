package com.mercedes.hereapi;

import java.util.Collections;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;
import com.mercedes.config.ConfigProperties;
import com.mercedes.constants.Constants;
import com.mercedes.hereapi.discover.model.DiscoverAPIResponse;
import com.mercedes.hereapi.geocode.model.GeoCodeAPIResponse;

@Service
public class CallHereAPI {
	
	@Autowired
	ConfigProperties configProperties;
	
	@Autowired
	Gson gson;
	
	public static final Logger log = LogManager.getLogger();
	
	public GeoCodeAPIResponse getGeoCode(String location) {
		
		log.info("Fetching GeoCodes for location: "+location);
		String url = configProperties.getConfig().get("GEO_CODE_URL")+location+Constants.API_KEY+configProperties.getConfig().get("HERE_API_KEY");
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, GeoCodeAPIResponse.class);
	}

	public DiscoverAPIResponse discover(String coordinates,String place) {
		
		log.info("Discovering "+place);
		String url = configProperties.getConfig().get("DISCOVER_URL")+coordinates+Constants.QUERY+place+Constants.API_KEY+configProperties.getConfig().get("HERE_API_KEY");
		RestTemplate restTemplate = new RestTemplate();
		DiscoverAPIResponse response = restTemplate.getForObject(url, DiscoverAPIResponse.class);
		if(null != response && null != response.getItems()) {
			Collections.sort(response.getItems());
			if(response.getItems().size() > 3) 
				response.getItems().subList(3, response.getItems().size()).clear();
		}
		log.info("Response from dicover for "+place+": "+gson.toJson(response));
		return response;
	}
}
