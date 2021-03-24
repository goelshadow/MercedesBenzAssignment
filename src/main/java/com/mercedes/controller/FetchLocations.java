package com.mercedes.controller;

import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.mercedes.hereapi.discover.model.DiscoverAPIResponse;
import com.mercedes.service.FetchLocationsService;

@RestController
public class FetchLocations {
	
	@Autowired
	FetchLocationsService fetchLocationsService;
	
	@Autowired
	Gson gson;
	
	public static final Logger log = LogManager.getLogger();
	
	/*@GetMapping("/fetchDetails")
	public Map<String,DiscoverAPIResponse> getLocationDetails(@RequestParam("location") String location) {
		
		Map<String,DiscoverAPIResponse> response = null;
		try {
			log.info("Request received, Location: "+location);
			response = fetchLocationsService.fetchDetails(location);
		}catch(Exception e) {
			log.error("Exception occured: "+e,e);
		}
		log.info("Response sent: "+gson.toJson(response));
		return response;
	}*/
	
	@GetMapping("/")
	public String test() {
		log.info("Request received in controller");
		return "Hello from Spring boot";
	}
}
