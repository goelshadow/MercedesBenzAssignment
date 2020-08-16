package com.mercedes.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.mercedes.constants.Constants;
import com.mercedes.hereapi.CallHereAPI;
import com.mercedes.hereapi.discover.model.DiscoverAPIResponse;
import com.mercedes.hereapi.geocode.model.GeoCodeAPIResponse;

@Service
public class FetchLocationsService {

	@Autowired
	CallHereAPI callHereAPI;
	
	public static final Logger log = LogManager.getLogger();
	
	public Map<String,DiscoverAPIResponse> fetchDetails(String location) throws InterruptedException, ExecutionException {
		
		Map<String,DiscoverAPIResponse> finalResponse = new HashMap<>();
		String coordinates = fetchCoOrdinates(location);
		if(!StringUtils.isEmpty(coordinates)) {
			CompletableFuture<DiscoverAPIResponse> restaurantRes = CompletableFuture.supplyAsync(() -> callHereAPI.discover(coordinates,Constants.RESTAURANT));
			CompletableFuture<DiscoverAPIResponse> chargingRes = CompletableFuture.supplyAsync(() -> callHereAPI.discover(coordinates,Constants.CHARGING_STATION));
			CompletableFuture<DiscoverAPIResponse> parkingRes = CompletableFuture.supplyAsync(() -> callHereAPI.discover(coordinates,Constants.PARKING));
			finalResponse.put(Constants.RESTAURANT, restaurantRes.get());
			finalResponse.put(Constants.CHARGING_STATION, chargingRes.get());
			finalResponse.put(Constants.PARKING, parkingRes.get());
			}
		return finalResponse;
	}
	
	private String fetchCoOrdinates(String location) {
		GeoCodeAPIResponse response = callHereAPI.getGeoCode(location);
		if(null != response.getItems() && null != response.getItems().get(0) && null != response.getItems().get(0).getPosition()) {
			String coordinates = response.getItems().get(0).getPosition().getLat() + "," + response.getItems().get(0).getPosition().getLng();
			log.info("Coordinates of "+location+": "+coordinates);
			return coordinates;
		}
		log.info("Unable to fetch Coordinates of "+location);
		return null;
	}
}
