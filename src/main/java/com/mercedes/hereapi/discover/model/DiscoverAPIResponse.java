package com.mercedes.hereapi.discover.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscoverAPIResponse {
	
	private List<DiscoverResponse> items;

	public List<DiscoverResponse> getItems() {
		return items;
	}

	public void setItems(List<DiscoverResponse> items) {
		this.items = items;
	}

}
