package com.mercedes.hereapi.geocode.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoCodeAPIResponse {
	
	private List<GeoCodeResponse> items;

	public List<GeoCodeResponse> getItems() {
		return items;
	}

	public void setItems(List<GeoCodeResponse> items) {
		this.items = items;
	}

}
